public class Bank {
   final private String name;
   final private double exchangeRate;

    public Bank(String name, double exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double calculateAmountInUAH(double dollars) {
        return dollars * exchangeRate;
    }
}

