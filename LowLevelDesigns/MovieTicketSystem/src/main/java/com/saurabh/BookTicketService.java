package com.saurabh;

import java.util.List;

public class BookTicketService {
    private PaymentService paymentService;
    private SeatLockProvider seatLockProvider;

    // to book ticket first we have to check if these seats are available or not?
    public Ticket bookTicket(Show show, List<Seat> seats) {
        // 1 . first we will check if seats are available ie not occupied as well as not locked by other user
        // 2. if seat is available then lock seat for a duration of 5 minutes in time the user can complete payment and generate ticket and mark occupied status as true
        // 3. if payment fails then unlock the seat with occupied status as false;

        // check if seats are available and not locked
        seatLockProvider.checkIfSeatAvailable(seats, show);

        // if available book for x seconds

        seatLockProvider.lockSeat(seats, show, 300);

        if (!paymentService.pay()) {
            seatLockProvider.unLockSeat(seats, show);
        } else {
            // mark each seats as occupied.
        }

        // Generate Ticket

        Ticket ticket = generateTicket();
        return ticket;
    }

    private Ticket generateTicket() {
        return null;
    }
}
