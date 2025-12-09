package com.saurabh.uml;

import java.util.ArrayList;

// house have a strong has-a relationship with room
// ie rooms cannot exist without house
// if house class hs is destroyed, room object are destroyed as well.
class House {
    private String name;
    private ArrayList<Room> rooms = new ArrayList<>();

    House(String name) {
        this.name = name;
        rooms.add(new Room("room 1"));
        rooms.add(new Room("room 2"));
        rooms.add(new Room("room 3"));
    }

    public String getHouseName() {
        return name;
    }

    public ArrayList<Room> getAllRooms() {
        return rooms;
    }
}

class Room {
    private String name;

    Room(String name){
        this.name = name;
    }

    public String getRoomName() {
        return name;
    }
}

public class compositionExample {
    public static void main(String[] args) {
        House hs = new House("My house");

        var allRooms = hs.getAllRooms();
        System.out.println("House: " + hs.getHouseName() + " have these rooms");
        for (Room room : allRooms) {
            System.out.println("Room is: " + room.getRoomName());
        }
    }
}
