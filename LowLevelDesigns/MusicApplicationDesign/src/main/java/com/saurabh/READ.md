Here's your **Amazon SDE2 LLD round-ready design** for an **Amazon Music streaming system**. I'll give you the **exact 20-minute presentation structure** with diagram, classes, and code skeleton. [github](https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/music-streaming-service.md)

***

## 🎯 **LLD Presentation Script (20 mins)**

**You start**: "I'll design **Amazon Music core**—user library, playlists, playback queue, search, with **concurrency for multi-device**. Focus on **clean OOP**, **patterns**, **thread-safety**. " [github](https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/music-streaming-service.md)

***

## 1. **Requirements & Scope** (2 mins)

**Functional** (Amazon Music v1):
- Users browse/search songs/albums/artists/playlists.
- Create/manage playlists, add/remove songs.
- Play/pause/skip/seek/next/prev/shuffle/repeat.
- Queue management (add next, clear).
- **Multi-device sync**: Play state across phone/laptop.

**Non-functional**:
- Thread-safe (UI threads + background sync).
- Extensible (recommendations, offline later).

**Not in scope**: Streaming protocol/CDN (HLS), auth, recommendations.

***

## 2. **Class diagram** (3 mins – whiteboard this!)

```
+----------------+       +----------------+  
|   User         |◄──────|   Library      |  owns
| userId, name   |       | songs, albums  |  
+----------------+       +----------------+  
         │                        │
         │ owns                    │ contains
         ▼                        ▼
+----------------+       +----------------+  
|  Playlist      |◄──────|    Song        |  
| playlistId     |       | songId, title  |  
| name, songs    |       | artist, album  |  
+----------------+       +----------------+  
         │                        ▲
         │ owns                    │ in
         ▼                        │
+----------------+       +----------------+  
|   Player       |◄──────|    Queue       |  
| isPlaying      |       | currentSong    |  
| position       |       | upcomingSongs  |  
| volume         |       | shuffleMode    |  
+----------------+       +----------------+  
         │
         │ manages
         ▼
+----------------+
|  SearchService |
+----------------+
```

**Patterns**:
- **Player singleton** per user session.
- **Observer** for play state sync.
- **Strategy** for shuffle/repeat. [dev](https://dev.to/abhishekjaiswal_4896/low-level-design-of-a-music-player-application-2co0)

***

## 3. **Core entities** (3 mins)

```java
// Immutable where possible
public class Song {
    private final String songId, title, artist, album;
    private final int durationMs;
    // getters only
}

public class Playlist {
    private final String playlistId, name;
    private final List<Song> songs = new CopyOnWriteArrayList<>();  // thread-safe add/remove

    public void addSong(Song song) { songs.add(song); }
    public void removeSong(Song song) { songs.remove(song); }
    public List<Song> getSongs() { return new ArrayList<>(songs); }  // snapshot
}

public class User {
    private final String userId;
    private final Map<String, Playlist> playlists = new ConcurrentHashMap<>();
    // getters, addPlaylist(), etc.
}
```

**Concurrency**: `CopyOnWriteArrayList` for playlist iteration during playback/search. [designgurus](https://www.designgurus.io/answers/detail/top-concurrency-and-multithreading-for-system-design-interviews)

***

## 4. **Player & Queue** (5 mins – core complexity)

```java
public enum PlaybackMode { NORMAL, SHUFFLE, REPEAT_ONE, REPEAT_ALL }
public enum PlaybackState { STOPPED, PLAYING, PAUSED }

public class PlaybackQueue {
    private final Deque<Song> upcoming = new ArrayDeque<>();  // FIFO
    private volatile Song currentSong;  // visible across threads
    private volatile PlaybackMode mode = PlaybackMode.NORMAL;

    public void addNext(Song song) { upcoming.addFirst(song); }
    public void addToEnd(Song song) { upcoming.addLast(song); }
    public Song getNext() {
        return mode == PlaybackMode.SHUFFLE ? shuffleNext() : upcoming.pollFirst();
    }
    private Song shuffleNext() { /* Fisher-Yates shuffle */ }
}

public class Player {
    private static final Logger log = Logger.getLogger(Player.class);
    
    private final PlaybackQueue queue;
    private volatile PlaybackState state = PlaybackState.STOPPED;
    private volatile double positionMs = 0;     // seek position
    private volatile double volume = 1.0;
    private final List<PlayerListener> listeners = new CopyOnWriteArrayList<>();

    // Singleton per user session
    private static final ThreadLocal<Player> INSTANCE = new ThreadLocal<>();

    public static Player getInstance(PlaybackQueue queue) {
        Player p = INSTANCE.get();
        if (p == null) {
            p = new Player(queue);
            INSTANCE.set(p);
        }
        return p;
    }

    public void play() { 
        state = PlaybackState.PLAYING; 
        notifyListeners(); 
    }

    public void pause() { 
        state = PlaybackState.PAUSED; 
        notifyListeners(); 
    }

    public void skip() {
        currentSong = queue.getNext();
        positionMs = 0;
        state = PlaybackState.PLAYING;
        notifyListeners();
    }

    public void seek(double ms) {
        if (ms >= 0 && ms <= currentSong.durationMs()) {
            positionMs = ms;
            notifyListeners();
        }
    }

    private void notifyListeners() {
        for (PlayerListener l : listeners) {
            l.onStateChanged(this);  // sync across devices
        }
    }
}
```

**Concurrency**:
- `volatile` for `state`, `position`, `currentSong` → visible across threads (UI + sync).
- `CopyOnWriteArrayList` for listeners.
- `ThreadLocal<Player>` per user session. [designgurus](https://www.designgurus.io/answers/detail/top-concurrency-and-multithreading-for-system-design-interviews)

***

## 5. **SearchService** (2 mins)

```java
public class SearchService {
    private final Map<String, List<Song>> songIndex = new ConcurrentHashMap<>();
    // Pre-populated from library

    public List<Song> search(String query) {
        return songIndex.entrySet().stream()
            .filter(e -> e.getKey().contains(query.toLowerCase()))
            .flatMap(e -> e.getValue().stream())
            .toList();
    }
}
```

**Simple in-memory trie/index for LLD; real: Elasticsearch.** [github](https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/music-streaming-service.md)

***

## 6. **Usage example** (2 mins)

```java
User user = new User("u1");
Playlist favorites = user.createPlaylist("Favorites");
favorites.addSong(song1);
favorites.addSong(song2);

Player player = Player.getInstance(new PlaybackQueue());
player.queue.addNext(song3);
player.queue.addToEnd(song4);

player.play();      // starts song3
player.skip();      // plays song4
player.seek(30000); // 30s into song4
```

***

## 7. **Multi-device sync** (2 mins)

**Observer pattern**:
```java
public interface PlayerListener {
    void onStateChanged(Player player);  // phone hears laptop pause
}

// Laptop pauses → sync service pushes state to cloud → phone syncs
```

**Cloud sync** (brief):
```
PlayerState { userId, state, currentSongId, positionMs, volume }
→ DynamoDB + WebSocket fanout
```

***

## 8. **Concurrency & patterns summary** (1 min)

| Component | Concurrency Strategy |
|-----------|---------------------|
| Playlist | CopyOnWriteArrayList |
| Player state | volatile fields |
| Registry | ConcurrentHashMap |
| Listeners | CopyOnWriteArrayList |

**SOLID**: Single responsibility (Player vs Queue), Open/closed (add RepeatStrategy).

***

## 🎯 **Trade-offs table**

| Feature | Choice | Why not... |
|---------|--------|------------|
| Queue | Deque | LinkedList (poor cache) |
| State sync | Volatile | Locks (contention) |
| Playlists | CopyOnWrite | ConcurrentList (complex) |

**QPS**: 10k ops/sec per user session, lock-free where possible.

**End**: "Multi-device via WebSocket sync? Offline cache next?" [github](https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/music-streaming-service.md)

***

**Practice this once**—diagram in 3 mins, code verbalize. **Perfect for Amazon LLD**.

Want **mock interview** or **deeper Queue/Player code**?