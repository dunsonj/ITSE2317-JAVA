package Test1;

public class HourlyWorker extends Employee {
    private  double hoursWorked;
    private  double grossPay;

    public HourlyWorker(int empID, String name, double rate) {
        super(empID, name, rate);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > 80) {
            throw new IllegalArgumentException("Hours worked must be between 0 and 80.");
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calcGrossPay() {
        if (hoursWorked <= 40) {
            grossPay = hoursWorked * getPayRate();
        } else {
            double regularPay = 40 * getPayRate();
            double overtimePay = (hoursWorked - 40) * (getPayRate() * 1.5);
            grossPay = regularPay + overtimePay;
        }
    }

    @Override
    public double calcNetPay() {
        double grossPay = getGrossPay();
        if (grossPay <= 950.70) {
            return grossPay;
        } else {
            double tax = (grossPay - 950.70) * 0.0875;
            return grossPay - tax;
        }
    }

    public double getGrossPay() {
        return grossPay;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nHours Worked: %.2f%nGross Pay: $%.2f%nNet Pay: $%.2f%n",
                hoursWorked, grossPay, calcNetPay());
    }
}
