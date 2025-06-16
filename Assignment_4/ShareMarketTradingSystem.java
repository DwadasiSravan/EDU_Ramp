import java.util.*;
import java.util.concurrent.*;
import java.util.Scanner;

class InsufficientSharesException extends Exception {
    public InsufficientSharesException(String message) { super(message); }
}

class StockNotFoundException extends Exception {
    public StockNotFoundException(String message) { super(message); }
}

class InsufficientMarketSharesException extends Exception {
    public InsufficientMarketSharesException(String message) { super(message); }
}

class User {
    private final String name;
    private final String contactNumber;
    private final String panNumber;
    private final Map<String, Integer> holdings = new HashMap<>();

    public User(String name, String contactNumber, String panNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.panNumber = panNumber;
    }

    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getPanNumber() { return panNumber; }
    public Map<String, Integer> getHoldings() { return holdings; }

    public void buyStock(String stockName, int quantity) {
        String key = stockName.toUpperCase();
        holdings.put(key, holdings.getOrDefault(key, 0) + quantity);
    }

    public void sellStock(String stockName, int quantity) throws InsufficientSharesException {
        String key = stockName.toUpperCase();
        int owned = holdings.getOrDefault(key, 0);
        if (owned < quantity) throw new InsufficientSharesException("Not enough shares to sell. Owned: " + owned);
        holdings.put(key, owned - quantity);
        if (holdings.get(key) == 0) holdings.remove(key);
    }
}

class Stock {
    private final String name;
    private double pricePerShare;
    private int availableShares;
    private double todayOpen;
    private double todayHigh;
    private double todayLow;
    private double week52High;
    private double week52Low;
    private double listedPrice;
    private double price1DayAgo;
    private double price1WeekAgo;
    private double price1MonthAgo;
    private double price1YearAgo;
    private double price5YearAgo;
    private double marketCap;
    private double peRatio;
    private double pbRatio;
    private double industryPe;
    private double debtToEquity;
    private double roe;
    private double eps;
    private double dividendYield;
    private double bookValue;
    private double faceValue;

    public Stock(String name, double pricePerShare, int availableShares,
                 double todayOpen, double todayHigh, double todayLow, double week52High, double week52Low,
                 double listedPrice, double price1DayAgo, double price1WeekAgo, double price1MonthAgo,
                 double price1YearAgo, double price5YearAgo,
                 double marketCap, double peRatio, double pbRatio, double industryPe, double debtToEquity,
                 double roe, double eps, double dividendYield, double bookValue, double faceValue) {
        this.name = name;
        this.pricePerShare = pricePerShare;
        this.availableShares = availableShares;
        this.todayOpen = todayOpen;
        this.todayHigh = todayHigh;
        this.todayLow = todayLow;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.listedPrice = listedPrice;
        this.price1DayAgo = price1DayAgo;
        this.price1WeekAgo = price1WeekAgo;
        this.price1MonthAgo = price1MonthAgo;
        this.price1YearAgo = price1YearAgo;
        this.price5YearAgo = price5YearAgo;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.pbRatio = pbRatio;
        this.industryPe = industryPe;
        this.debtToEquity = debtToEquity;
        this.roe = roe;
        this.eps = eps;
        this.dividendYield = dividendYield;
        this.bookValue = bookValue;
        this.faceValue = faceValue;
    }

    public String getName() { return name; }
    public double getPricePerShare() { return pricePerShare; }
    public int getAvailableShares() { return availableShares; }
    public void setAvailableShares(int availableShares) { this.availableShares = availableShares; }

    public String getReturnsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("1 Day Change: ").append(formatReturn(pricePerShare, price1DayAgo)).append("\n");
        sb.append("1 Week Return: ").append(formatReturn(pricePerShare, price1WeekAgo)).append("\n");
        sb.append("1 Month Return: ").append(formatReturn(pricePerShare, price1MonthAgo)).append("\n");
        sb.append("1 Year Return: ").append(formatReturn(pricePerShare, price1YearAgo)).append("\n");
        sb.append("5 Year Return: ").append(formatReturn(pricePerShare, price5YearAgo)).append("\n");
        sb.append("All Time Return: ").append(formatReturn(pricePerShare, listedPrice)).append("\n");
        return sb.toString();
    }

    private String formatReturn(double current, double past) {
        if (past == 0) return "N/A";
        double change = current - past;
        double percent = (change / past) * 100;
        return String.format("%.2f (%.2f%%)", change, percent);
    }

    public String getHighLowInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Today's High: ").append(todayHigh).append("\n");
        sb.append("Today's Low: ").append(todayLow).append("\n");
        sb.append("52 Week High: ").append(week52High).append("\n");
        sb.append("52 Week Low: ").append(week52Low).append("\n");
        return sb.toString();
    }

    public String getFundamentals() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mkt Cap: ").append(marketCap).append("\n");
        sb.append("P/E Ratio (TTM): ").append(peRatio).append("\n");
        sb.append("P/B Ratio: ").append(pbRatio).append("\n");
        sb.append("Industry P/E: ").append(industryPe).append("\n");
        sb.append("Debt to Equity: ").append(debtToEquity).append("\n");
        sb.append("ROE: ").append(roe).append("%\n");
        sb.append("EPS (TTM): ").append(eps).append("\n");
        sb.append("Div Yield: ").append(dividendYield).append("%\n");
        sb.append("Book Value: ").append(bookValue).append("\n");
        sb.append("Face Value: ").append(faceValue).append("\n");
        return sb.toString();
    }
}

class Market {
    private final Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getName().toUpperCase(), stock);
    }

    public synchronized void buyStock(String name, int quantity) throws StockNotFoundException, InsufficientMarketSharesException {
        Stock stock = stocks.get(name.toUpperCase());
        if (stock == null) throw new StockNotFoundException("Stock " + name + " not found in market.");
        if (stock.getAvailableShares() < quantity)
            throw new InsufficientMarketSharesException("Market has only " + stock.getAvailableShares() + " shares of " + stock.getName());
        stock.setAvailableShares(stock.getAvailableShares() - quantity);
    }

    public synchronized void sellStock(String name, int quantity) throws StockNotFoundException {
        Stock stock = stocks.get(name.toUpperCase());
        if (stock == null) throw new StockNotFoundException("Stock " + name + " not found in market.");
        stock.setAvailableShares(stock.getAvailableShares() + quantity);
    }

    public Stock getStock(String name) {
        return stocks.get(name.toUpperCase());
    }

    public Collection<Stock> getAllStocks() {
        return stocks.values();
    }

    public void printCompanyInfo(String name) {
        Stock stock = stocks.get(name.toUpperCase());
        if (stock == null) {
            System.out.println("Company with name " + name + " not found.");
            return;
        }
        System.out.println("\n**" + stock.getName() + "**");
        System.out.println("Current Price: " + stock.getPricePerShare());
        System.out.println(stock.getReturnsInfo());
        System.out.println(stock.getHighLowInfo());
        System.out.println("Fundamentals:");
        System.out.println(stock.getFundamentals());
    }

    public void printCompanyList() {
        System.out.println("List of Companies:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getName() + " | Today's Market Price: " + stock.getPricePerShare());
        }
    }
}

public class ShareMarketTradingSystem {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();

        market.addStock(new Stock(
                "Tata Consultancy Services", 3900.0, 1000,
                3880.0, 3925.0, 3870.0, 4000.0, 3200.0,
                1200.0, 3885.0, 3800.0, 3700.0, 3200.0, 1500.0,
                1400000000000.0, 32.5, 12.1, 28.0, 0.1, 35.0, 120.0, 1.2, 400.0, 1.0
        ));
        market.addStock(new Stock(
                "Reliance Industries", 2850.0, 2000,
                2820.0, 2865.0, 2810.0, 2900.0, 2200.0,
                900.0, 2840.0, 2750.0, 2600.0, 2200.0, 1100.0,
                1900000000000.0, 28.0, 2.8, 24.0, 0.2, 18.0, 102.0, 0.9, 350.0, 10.0
        ));
        market.addStock(new Stock(
                "Infosys", 1550.0, 1500,
                1540.0, 1565.0, 1535.0, 1700.0, 1200.0,
                400.0, 1545.0, 1500.0, 1400.0, 1200.0, 600.0,
                650000000000.0, 25.0, 5.2, 22.0, 0.05, 24.0, 62.0, 2.1, 200.0, 5.0
        ));
        market.addStock(new Stock(
                "HDFC Bank", 1700.0, 1800,
                1680.0, 1715.0, 1670.0, 1800.0, 1400.0,
                800.0, 1695.0, 1650.0, 1600.0, 1400.0, 700.0,
                950000000000.0, 20.0, 3.5, 18.0, 0.9, 16.0, 80.0, 1.5, 500.0, 1.0
        ));
        market.addStock(new Stock(
                "ICICI Bank", 1100.0, 1600,
                1090.0, 1120.0, 1080.0, 1200.0, 900.0,
                400.0, 1095.0, 1050.0, 1000.0, 900.0, 350.0,
                800000000000.0, 18.0, 2.9, 16.0, 0.7, 14.0, 60.0, 1.3, 300.0, 2.0
        ));
        market.addStock(new Stock(
                "Hindustan Unilever", 2500.0, 1200,
                2480.0, 2515.0, 2470.0, 2600.0, 2000.0,
                900.0, 2495.0, 2450.0, 2400.0, 2000.0, 800.0,
                600000000000.0, 55.0, 10.2, 50.0, 0.3, 80.0, 45.0, 1.1, 120.0, 1.0
        ));
        market.addStock(new Stock(
                "Bharti Airtel", 950.0, 1400,
                940.0, 965.0, 935.0, 1000.0, 700.0,
                350.0, 945.0, 900.0, 850.0, 700.0, 300.0,
                500000000000.0, 60.0, 8.5, 55.0, 1.5, 12.0, 16.0, 0.7, 80.0, 5.0
        ));
        market.addStock(new Stock(
                "State Bank of India", 650.0, 2000,
                640.0, 665.0, 635.0, 700.0, 400.0,
                200.0, 645.0, 600.0, 550.0, 400.0, 150.0,
                450000000000.0, 10.0, 1.5, 9.0, 1.2, 10.0, 65.0, 2.0, 350.0, 1.0
        ));
        market.addStock(new Stock(
                "Larsen & Toubro", 3200.0, 900,
                3180.0, 3225.0, 3170.0, 3400.0, 2500.0,
                1200.0, 3195.0, 3100.0, 3000.0, 2500.0, 1000.0,
                400000000000.0, 30.0, 4.2, 28.0, 0.5, 20.0, 100.0, 1.0, 400.0, 2.0
        ));
        market.addStock(new Stock(
                "Asian Paints", 3100.0, 800,
                3080.0, 3125.0, 3070.0, 3300.0, 2200.0,
                1000.0, 3095.0, 3000.0, 2900.0, 2200.0, 900.0,
                350000000000.0, 65.0, 15.0, 60.0, 0.2, 30.0, 48.0, 0.8, 150.0, 1.0
        ));
        market.addStock(new Stock(
                "Maruti Suzuki", 12000.0, 700,
                11900.0, 12150.0, 11870.0, 12500.0, 9000.0,
                4000.0, 11950.0, 11500.0, 11000.0, 9000.0, 3500.0,
                300000000000.0, 35.0, 6.5, 32.0, 0.1, 18.0, 340.0, 1.3, 1800.0, 5.0
        ));

        Scanner scanner = new Scanner(System.in);

        // User registration
        System.out.println("Welcome! Please enter your details to register:");
        System.out.print("Name: ");
        String userName = scanner.nextLine().trim();
        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine().trim();
        System.out.print("PAN Number: ");
        String panNumber = scanner.nextLine().trim();
        User user = new User(userName, contactNumber, panNumber);

        // Initial holdings input
        System.out.print("Do you want to add your current stock holdings? (yes/no): ");
        String addHoldings = scanner.nextLine().trim().toLowerCase();
        if (addHoldings.equals("yes")) {
            while (true) {
                System.out.print("Enter company name (or type 'done' to finish): ");
                String cname = scanner.nextLine().trim();
                if (cname.equalsIgnoreCase("done")) break;
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(scanner.nextLine().trim());
                user.buyStock(cname, qty);
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Welcome to Share Market Trading System ---");
            market.printCompanyList();
            System.out.println("\nYour Holdings:");
            for (Map.Entry<String, Integer> entry : user.getHoldings().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
            }
            System.out.println("\nOptions:");
            System.out.println("1. View Fundamentals of a Company");
            System.out.println("2. Buy Shares");
            System.out.println("3. Sell Shares");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter Company Name to view fundamentals: ");
                    String companyName = scanner.nextLine().trim();
                    market.printCompanyInfo(companyName);
                    break;
                case "2":
                    System.out.print("Enter Company Name to buy: ");
                    String buyCompany = scanner.nextLine().trim();
                    System.out.print("Enter quantity to buy: ");
                    int buyQty = Integer.parseInt(scanner.nextLine().trim());
                    try {
                        market.buyStock(buyCompany, buyQty);
                        user.buyStock(buyCompany, buyQty);
                        System.out.println("Bought " + buyQty + " shares of " + buyCompany);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Enter Company Name to sell: ");
                    String sellCompany = scanner.nextLine().trim();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = Integer.parseInt(scanner.nextLine().trim());
                    try {
                        user.sellStock(sellCompany, sellQty);
                        market.sellStock(sellCompany, sellQty);
                        System.out.println("Sold " + sellQty + " shares of " + sellCompany);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nFinal Holdings:");
        for (Map.Entry<String, Integer> entry : user.getHoldings().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
        }

        System.out.println("\nFinal Market Shares:");
        for (Stock stock : market.getAllStocks()) {
            System.out.println(stock.getName() + ": " + stock.getAvailableShares() + " shares left");
        }
    }
} 