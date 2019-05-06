package company.payroll.system.kai;

public class Employee {

    private int id;
    private String name;
    private String address;
    private String rank;
    private int hoursWorked;
    private int overTimeHoures;

    //constructors
    public Employee() {
        this.id = 0;
        this.name = "";
        this.address = "";
        this.rank = "";
        this.hoursWorked = 0;
        this.overTimeHoures = 0;
    }

    public Employee(int id, String name, String address, String rank, int hoursWorked, int overTimeHoures) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rank = rank;
        this.hoursWorked = hoursWorked;
        this.overTimeHoures = overTimeHoures;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setOverTimeHoures(int overTimeHoures) {
        this.overTimeHoures = overTimeHoures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getOverTimeHoures() {
        return overTimeHoures;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + address + " " + rank + " " + hoursWorked + " " + overTimeHoures + "\n";
    }
}
