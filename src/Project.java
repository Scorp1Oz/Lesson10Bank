import java.util.Random;
public class Project {
    public static void main(String[] args) {
        Random random = new Random();
        Bank[] banks = new Bank[14];

        banks[0] = new Bank("АТ КБ «ПРИВАТБАНК»", random.nextDouble() * 5 + 35);
        banks[1] = new Bank("АТ «Monobank»", random.nextDouble() * 5 + 35);
        banks[2] = new Bank("ПАТ «VostokBank»", random.nextDouble() * 5 + 35);
        banks[3] = new Bank("АТ «Сенс Банк»", random.nextDouble() * 5 + 35);
        banks[4] = new Bank("АТ «Сітібанк»", random.nextDouble() * 5 + 35);
        banks[5] = new Bank("АТ «ІНГ Банк Україна»", random.nextDouble() * 5 + 35);
        banks[6] = new Bank("АТ «Ощадбанк»", random.nextDouble() * 5 + 35);
        banks[7] = new Bank("АТ «Укрексімбанк»", random.nextDouble() * 5 + 35);
        banks[8] = new Bank("АБ «УКРГАЗБАНК»", random.nextDouble() * 5 + 35);
        banks[9] = new Bank("АТ «Райффайзен Банк»", random.nextDouble() * 5 + 35);
        banks[10] = new Bank("АТ «УКРСИББАНК»", random.nextDouble() * 5 + 35);
        banks[11] = new Bank("АT «ПУМБ»", random.nextDouble() * 5 + 35);
        banks[12] = new Bank("АТ «КРЕДІ АГРІКОЛЬ БАНК»", random.nextDouble() * 5 + 35);
        banks[13] = new Bank("АБ «Південний»", random.nextDouble() * 5 + 35);

        double dollars = 100;

        Bank[] bestBanks = new Bank[14];
        double bestRate = 0;
        int bestBankCount = 0;

        for (Bank bank : banks) {
            double amountInUAH = bank.calculateAmountInUAH(dollars);
            if (amountInUAH > bestRate) {
                bestRate = amountInUAH;
                bestBankCount = 1;
                bestBanks[0] = bank;
            } else if (amountInUAH == bestRate) {
                bestBanks[bestBankCount] = bank;
                bestBankCount++;
            }
        }

        if (bestBankCount == 0) {
            System.out.println("Немає вигідних банків для обміну.");
        } else {
            System.out.println("Найкращі банки для обміну:");
            for (int i = 0; i < bestBankCount; i++) {
                Bank bestBank = bestBanks[i];
                double uah = bestBank.calculateAmountInUAH(dollars);
                double convertedDollars = bestBank.calculateDollarsFromUAH(uah);
                System.out.println("Сума доларів: " + convertedDollars);
                System.out.println(bestBank.getName() + " (Курс: " + bestBank.getExchangeRate() + ", Сума в гривнях: " + uah + ")");

            }
        }
    }
}
