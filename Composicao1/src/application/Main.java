
package application;

import entitys.Departament;
import entitys.HourContract;
import entitys.Worker;
import entitys.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter departament`s name:");
        String departament = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salary: ");
        double baseSalary = sc.nextDouble();
        Worker wk = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departament));
        System.out.println("How many Contract to this worker:");
        int qc = sc.nextInt();
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(int i = 0; i < qc; ++i) {
            System.out.println("Enter Contract #" + (i + 1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hour = sc.nextInt();
            HourContract hc = new HourContract(contractDate, valuePerHour, hour);
            wk.addContract(hc);
        }

        System.out.println("Enter mounth and year to calculate income (MM/YYYY): ");
        sc.nextLine();
        String dateCalculate = sc.nextLine();
        int dateMounth = Integer.parseInt(dateCalculate.substring(0, 2));
        int dateYear = Integer.parseInt(dateCalculate.substring(3));
        System.out.println("Name: " + wk.getName());
        System.out.println("Departament: " + wk.getDepartament().getName());
        System.out.println("Income for " + dateCalculate + ": " + wk.income(dateYear, dateMounth));
    }
}
