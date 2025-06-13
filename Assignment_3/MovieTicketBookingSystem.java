package Assignment_3;
import java.util.*;

interface MovieBooking {
    void showMovies();
    void bookTickets();
    void showBill();
}

abstract class Theater {
    protected String theaterName = "Cinepolice";
    public String getTheaterName() {
        return theaterName;
    }
}

abstract class Menu {
    protected List<Snack> snacks = Arrays.asList(
            new Snack("Popcorn", 100),
            new Snack("Nachos", 120),
            new Snack("Samosa", 40),
            new Snack("French Fries", 90),
            new Snack("Chocolate", 60),
            new Snack("Chips", 50),
            new Snack("Hot Dog", 130),
            new Snack("Burger", 150),
            new Snack("Sandwich", 80),
            new Snack("Ice Cream", 70)
    );
    protected List<Snack> drinks = Arrays.asList(
            new Snack("Coke", 40),
            new Snack("Pepsi", 40),
            new Snack("Sprite", 40),
            new Snack("Fanta", 40),
            new Snack("Water Bottle", 20)
    );
    public List<Snack> getSnacks() { return snacks; }
    public List<Snack> getDrinks() { return drinks; }
}

abstract class MovieList {
    protected List<Movie> movies = Arrays.asList(
            new Movie("Pushpa-2", "Telugu", 1, 260),
            new Movie("Singam-2", "Tamil", 2, 220),
            new Movie("IT", "English", 3, 200),
            new Movie("HIT: The Third Case", "Telugu", 4, 210),
            new Movie("Salaar", "Kannada", 5, 230),
            new Movie("WAR-2", "Hindi", 6, 240),
            new Movie("Jawan", "Hindi", 7, 180),
            new Movie("KGF", "Kannada", 8, 210),
            new Movie("Leo", "Tamil", 9, 220),
            new Movie("RRR", "Telugu", 10, 200)
    );
    public List<Movie> getMovies() { return movies; }
}

class Movie {
    private String name;
    private String language;
    private int screen;
    private double price;

    public Movie(String name, String language, int screen, double price) {
        this.name = name;
        this.language = language;
        this.screen = screen;
        this.price = price;
    }

    public String getName() { return name; }
    public String getLanguage() { return language; }
    public int getScreen() { return screen; }
    public double getPrice() { return price; }
}

class Snack {
    private String name;
    private double price;

    public Snack(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class MovieBookingSystem extends Theater implements MovieBooking, Runnable {
    private List<Movie> movies;
    private List<Snack> snacks;
    private List<Snack> drinks;

    private Movie selectedMovie;
    private int ticketCount;
    private double ticketTotal;
    private double snackTotal;
    private double drinkTotal;
    private double foodTotal;
    private double foodTax;
    private double movieTax;
    private List<String> selectedSnacks = new ArrayList<>();
    private List<String> selectedDrinks = new ArrayList<>();
    private double subtotal, totalPayable;

    private Scanner sc = new Scanner(System.in);

    public MovieBookingSystem() {
        Menu menu = new Menu() {};
        MovieList movieList = new MovieList() {};
        this.snacks = menu.getSnacks();
        this.drinks = menu.getDrinks();
        this.movies = movieList.getMovies();
    }

    @Override
    public void run() {
        showMovies();
        bookTickets();
        showBill();
    }

    @Override
    public void showMovies() {
        System.out.println("Welcome to " + getTheaterName() + "!");
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.printf("%d. %s | %s | Screen %d | Rs. %.2f\n", i+1, m.getName(), m.getLanguage(), m.getScreen(), m.getPrice());
        }
    }

    @Override
    public void bookTickets() {
        System.out.print("Enter the number of the movie you want to book: ");
        int movieChoice = sc.nextInt() - 1;
        selectedMovie = movies.get(movieChoice);

        System.out.print("How many tickets? ");
        ticketCount = sc.nextInt();
        ticketTotal = selectedMovie.getPrice() * ticketCount;

        System.out.print("Do you want snacks? (yes/no): ");
        String snackAns = sc.next();
        snackTotal = 0;
        selectedSnacks.clear();
        if (snackAns.equalsIgnoreCase("yes")) {
            System.out.println("Available Snacks:");
            for (int i = 0; i < snacks.size(); i++) {
                Snack s = snacks.get(i);
                System.out.printf("%d. %s (Rs. %.2f)\n", i+1, s.getName(), s.getPrice());
            }
            System.out.print("Enter snack numbers separated by space (0 to finish): ");
            sc.nextLine();
            String[] snackChoices = sc.nextLine().split(" ");
            for (String choice : snackChoices) {
                if (choice.equals("0")) break;
                int idx = Integer.parseInt(choice) - 1;
                if (idx >= 0 && idx < snacks.size()) {
                    snackTotal += snacks.get(idx).getPrice();
                    selectedSnacks.add(snacks.get(idx).getName());
                }
            }
        }

        System.out.print("Do you want drinks? (yes/no): ");
        String drinkAns = sc.next();
        drinkTotal = 0;
        selectedDrinks.clear();
        if (drinkAns.equalsIgnoreCase("yes")) {
            System.out.println("Available Drinks:");
            for (int i = 0; i < drinks.size(); i++) {
                Snack d = drinks.get(i);
                System.out.printf("%d. %s (Rs. %.2f)\n", i+1, d.getName(), d.getPrice());
            }
            System.out.print("Enter drink numbers separated by space (0 to finish): ");
            sc.nextLine();
            String[] drinkChoices = sc.nextLine().split(" ");
            for (String choice : drinkChoices) {
                if (choice.equals("0")) break;
                int idx = Integer.parseInt(choice) - 1;
                if (idx >= 0 && idx < drinks.size()) {
                    drinkTotal += drinks.get(idx).getPrice();
                    selectedDrinks.add(drinks.get(idx).getName());
                }
            }
        }

        foodTotal = snackTotal + drinkTotal;
        foodTax = foodTotal * 0.07;
        movieTax = ticketTotal * 0.12;
        subtotal = ticketTotal + foodTotal;
        totalPayable = subtotal + foodTax + movieTax;
    }

    @Override
    public void showBill() {
        System.out.println("\n----- BILL -----");
        System.out.println("Theater: " + getTheaterName());
        System.out.println("Movie: " + selectedMovie.getName());
        System.out.println("Language: " + selectedMovie.getLanguage());
        System.out.println("Screen: " + selectedMovie.getScreen());
        System.out.println("Tickets: " + ticketCount + " x Rs. " + selectedMovie.getPrice() + " = Rs. " + ticketTotal);
        if (!selectedSnacks.isEmpty()) {
            System.out.println("Snacks: " + String.join(", ", selectedSnacks) + " = Rs. " + snackTotal);
        } else {
            System.out.println("Snacks: None");
        }
        if (!selectedDrinks.isEmpty()) {
            System.out.println("Drinks: " + String.join(", ", selectedDrinks) + " = Rs. " + drinkTotal);
        } else {
            System.out.println("Drinks: None");
        }
        System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
        System.out.printf("Food Tax (7%% on snacks & drinks): Rs. %.2f\n", foodTax);
        System.out.printf("Movie Ticket Tax (12%% on tickets): Rs. %.2f\n", movieTax);
        System.out.printf("Total Payable: Rs. %.2f\n", totalPayable);
        System.out.println("----------------");
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        MovieBookingSystem bookingSystem = new MovieBookingSystem();
        Thread bookingThread = new Thread(bookingSystem);
        bookingThread.start();
        try {
            bookingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted.");
        }
    }
}