import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Project {
    public static void main(String[] args) {
        Random random = new Random();
        List<Bank> banks = new ArrayList<>();

        banks.add(new Bank("АТ КБ «ПРИВАТБАНК»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Monobank»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("ПАТ «VostokBank»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Сенс Банк»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Сітібанк»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «ІНГ Банк Україна»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Ощадбанк»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Укрексімбанк»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АБ «УКРГАЗБАНК»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «Райффайзен Банк»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «УКРСИББАНК»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АT «ПУМБ»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АТ «КРЕДІ АГРІКОЛЬ БАНК»", random.nextDouble() * 5 + 35));
        banks.add(new Bank("АБ «Південний»", random.nextDouble() * 5 + 35));


        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть суму в доларах, яку ви хочете обміняти: ");
        double dollars = scanner.nextDouble();

        List<Bank> bestBanks = new ArrayList<>();
        double bestRate = 0;

        for (Bank bank : banks) {
            double amountInUAH = bank.calculateAmountInUAH(dollars);
            if (amountInUAH > bestRate) {
                bestRate = amountInUAH;
                bestBanks.clear();
                bestBanks.add(bank);
            } else if (amountInUAH == bestRate) {
                bestBanks.add(bank);
            }
        }

        if (bestBanks.isEmpty()) {
            System.out.println("Немає вигідних банків для обміну.");
        } else {
            System.out.println("Найкращі банки для обміну:");
            for (Bank bestBank : bestBanks) {
                System.out.println(bestBank.getName() + " (Курс: " + bestBank.getExchangeRate() + ")");
            }
        }
    }

}
