package Test1;

public abstract class Employee
{
    private int employeeID;
    private String employeeName;
    private double payRate;

    public Employee(int empID, String name, double rate)
    {
        employeeID = empID;
        employeeName = name;

        if (rate < 10.75)
            rate = 10.75;
        payRate = rate;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int empID)
    {
        employeeID = empID;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String Name)
    {
        employeeName = Name;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double rate)
    {
        if (rate < 10.25)
            rate = 10.25;
        payRate = rate;
    }

    @Override
    public String toString()
    {
        return String.format("EmployeeID: %d%nFull Name: %s%nHourly Rate: $%.2f",
                employeeID, employeeName, payRate);
    }

    // abstract method must be overridden by concrete subclasses
    public abstract void calcGrossPay();

    // abstract method must be overridden by concrete subclasses
    public abstract double calcNetPay();
}