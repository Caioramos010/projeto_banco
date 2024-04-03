
package entitys;

import entitys.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Departament departament;
    private List<HourContract> contracts = new ArrayList();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.departament = departament;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return this.level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return this.departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContract() {
        return this.contracts;
    }

    public void addContract(HourContract contract) {
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }

    public double income(int year, int month) {
        double sum = this.baseSalary;
        Calendar cal = Calendar.getInstance();
        Iterator var6 = this.contracts.iterator();

        while(var6.hasNext()) {
            HourContract c = (HourContract)var6.next();
            cal.setTime(c.getDate());
            int c_year = cal.get(1);
            int c_month = 1 + cal.get(2);
            if (year == c_year && month == c_month) {
                sum += c.valueTotal();
            }
        }

        return sum;
    }
}
