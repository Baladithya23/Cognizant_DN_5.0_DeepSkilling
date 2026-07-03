public class FinancialForecast {

    public static double forecast(double currentValue,
                                  double growthRate,
                                  int years) {

        if (years == 0) {
            return currentValue;
        }

        return forecast(currentValue * (1 + growthRate),
                        growthRate,
                        years - 1);
    }

    public static void main(String[] args) {

        double initialValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue =
                forecast(initialValue, growthRate, years);

        System.out.println("Initial Value : " + initialValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("Future Value  : " + futureValue);
    }
}