
public class Main {

    public static void main(String[] args) {

        Report report = new Report();

        report.readReport("tickets.json");

        System.out.println("average flight time : " + report.getAverageTime());

        System.out.println("90th percentile: " + report.getPercentile());
    }
}
