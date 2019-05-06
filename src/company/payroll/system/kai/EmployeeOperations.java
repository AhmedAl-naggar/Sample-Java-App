package company.payroll.system.kai;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeOperations extends Employee {

    public static void addEmployeeToFile(Employee e, String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
        writer.write(e.toString() + System.getProperty("line.separator")); //System.getProperty("line.separator") is used to add a new line.
        writer.close();
    }

    public static void updateFile(Employee[] employees, String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath))); //Note that is new FileWriter(filePath) NOT new FileWriter(filePath, true).
        writer.write(""); //to ears the previous data and start from new.
        for (Employee employee : employees) {
            if (employee.getId() != 0) { //this condition to avoid printing none intialized objects
                writer.write(employee.toString() + System.getProperty("line.separator")); //System.getProperty("line.separator") is used to add a new line.
            }
        }
        writer.close();
    }

    public static Employee[] loadFromFile(String fileName) throws FileNotFoundException {
        Employee a[] = new Employee[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = new Employee();
        }

        Scanner inFile = new Scanner(new File(fileName));
        int i = 0;
        while (inFile.hasNext()) {
            a[i].setId(Integer.parseInt(inFile.next()));
            a[i].setName(inFile.next());
            a[i].setAddress(inFile.next());
            a[i].setRank(inFile.next());
            a[i].setHoursWorked(Integer.parseInt(inFile.next()));
            a[i].setOverTimeHoures(Integer.parseInt(inFile.next()));
            i++;
        }
        return a;
    }

    public static Employee searchByID(Employee[] employees, int id) throws FileNotFoundException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public static double payment(Employee[] employees, int id) {
        int dummy = 0;
        for (int j = 0; j < employees.length; j++) {
            if (id == employees[j].getId()) {
                dummy = j;
                break;
            }
        }
        return ((employees[dummy].getHoursWorked() + employees[dummy].getOverTimeHoures()) * 30);
    }

    public static double average(Employee[] employees) {
        double payment = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getId() != 0) { //this condition to skip unitialized empolyees.
                payment += payment(employees, employee.getId());
                count++;
            }
        }
        return payment / count;
    }

    public static boolean checkId(Employee[] e, int id) {
        for (Employee employee : e) {
            if (employee.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
