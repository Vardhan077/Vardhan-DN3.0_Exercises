package WEEK1_DSA.DSA;
package WEEK1_DSA.DSA;
public class FinancialForecasting {
    public static double calculateFutureValue(double principal, double interestRate, int years) {
        if (years == 0) {
            return principal;
        }
        return calculateFutureValue(principal * (1 + interestRate), interestRate, years - 1);
    }

    public static void main(String[] args) {
        double principalAmount = 1000.0;
        double annualInterestRate = 0.05; // 5% growth rate
        int numberOfYears = 10;
        double futureValue = calculateFutureValue(principalAmount, annualInterestRate, numberOfYears);
        System.out.println("Projected Future Value: $" + futureValue);
    }
}
