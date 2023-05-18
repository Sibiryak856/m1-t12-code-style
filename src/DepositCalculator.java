import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().openingDeposit();
    }
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double earning = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return Math.round(earning);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double earning = amount + amount * yearRate * depositPeriod;
        return Math.round(earning);
    }

    void openingDeposit() {
        int amount, depositPeriod, action;
        double finalAmount = 0;
        Scanner scanner = new Scanner(System.in);
        double depositPercent = 0.06;

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            finalAmount = calculateSimplePercent(amount, depositPercent, depositPeriod);
        } else if (action == 2) {
            finalAmount = calculateComplexPercent(amount, depositPercent, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + "рублей за " + depositPeriod + " лет превратятся в "
                + finalAmount + "рублей");
    }
}
