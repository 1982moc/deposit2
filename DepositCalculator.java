import java.util.Scanner;



public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateIncome();
    }
    double calculateComplexPercent(double amount, double yearRate,int depositPeriod ) {
        double incomeBeforeRound = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundResult(incomeBeforeRound, 2);
    }
    double calculateSimplePercent(double depositAmount,double yearRate, int depositPeriod) {
        return roundResult(depositAmount+depositAmount * yearRate * depositPeriod, 2);
    }
    double roundResult(double incomeBeforeRound, int numberOfDigits) {
        double ScaLe= Math.pow(10, numberOfDigits);
        return Math.round(incomeBeforeRound * ScaLe) / ScaLe;
    }
    void calculateIncome() {
        int depositPeriod;
        int selectMenu;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        selectMenu = scanner.nextInt();
        double incomeTotal = 0;
        if (selectMenu ==1) {
            incomeTotal = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (selectMenu == 2) {
            incomeTotal = calculateComplexPercent(amount, 0.06, depositPeriod);
        }

        System.out.println("Резульcтат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + incomeTotal);

    }
}
