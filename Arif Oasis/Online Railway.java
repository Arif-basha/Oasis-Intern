import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Reservation> reservations = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Task 1: Login Form
        System.out.println("=== Online Reservation System ===");
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (authenticateUser(enteredUsername, enteredPassword)) {
            // Task 2: Reservation System
            System.out.println("\n=== Reservation System ===");
            System.out.println("Enter passenger details:");

            Passenger passenger = new Passenger();

            System.out.print("Name: ");
            passenger.setName(scanner.nextLine());
            System.out.print("Train number: ");
            passenger.setTrainNumber(scanner.nextLine());

            // Other details can be added similarly

            // Perform reservation logic
            int reservationId = performReservation(passenger);
            System.out.println("Reservation successful! Reservation ID: " + reservationId);

            // Task 3: Cancellation Form
            System.out.println("\n=== Cancellation Form ===");
            System.out.print("Enter Reservation ID for cancellation: ");
            int reservationIdForCancellation = Integer.parseInt(scanner.nextLine());

            // Perform cancellation logic
            if (performCancellation(reservationIdForCancellation)) {
                System.out.println("Cancellation successful!");
            } else {
                System.out.println("Cancellation failed. Invalid Reservation ID.");
            }
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        // Implement simple username/password authentication logic here
        return "admin".equals(username) && "password".equals(password);
    }

    private static int performReservation(Passenger passenger) {
        // Implement reservation logic (store in-memory)
        int reservationId = reservations.size() + 1;
        Reservation reservation = new Reservation(reservationId, passenger);
        reservations.add(reservation);
        return reservationId;
    }

    private static boolean performCancellation(int reservationId) {
        // Implement cancellation logic (remove from in-memory list)
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservations.remove(reservation);
                return true;
            }
        }
        return false;
    }
}

class Passenger {
    private String name;
    private String trainNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
}

class Reservation {
    private int reservationId;
    private Passenger passenger;

    public Reservation(int reservationId, Passenger passenger) {
        this.reservationId = reservationId;
        this.passenger = passenger;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
