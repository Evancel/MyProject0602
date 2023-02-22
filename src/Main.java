

public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов","Иван","Иванович",2,120000);
        employeeBook.addEmployee("Петров", "Петр", "Петрович", 3, 70000);
        employeeBook.addEmployee("Кузьмин", "Андрей", "Андреевич", 4, 65000);
        employeeBook.addEmployee("Семенов", "Семен", "Семенович", 4, 90000);
        employeeBook.addEmployee("Иванова", "Лариса", "Ивановна", 2, 50000);
        employeeBook.addEmployee("Петрова", "Ольга", "Андреевна", 2, 87000);
        employeeBook.addEmployee("Кузьмина", "София", "Иосифовна", 4, 115000);


        employeeBook.printAllEmployees();
        System.out.println("Сумма расходов на выплату зарплаты: " + employeeBook.sumSalary());
        System.out.println("Первый сотрудник с минимальной зарплатой: " + employeeBook.minSalary());
        System.out.println("Первый сотрудник с максимальной зарплатой: " + employeeBook.maxSalary());
        System.out.printf("Среднее значение зарплаты: %.2f %n", employeeBook.avgSalary());
        employeeBook.printAllFIO();

        employeeBook.increaseSalaryToAllEmployees(0.05);
        employeeBook.printAllEmployees();
        System.out.println("Первый сотрудник с минимальной зарплатой в отделе 4: " + employeeBook.searchEmployeeWithMinSalaryInDepartment(4));
        System.out.println("Первый сотрудник с максимальной зарплатой в отделе 4: " + employeeBook.searchEmployeeWithMaxSalaryInDepartment(4));
        System.out.println("Сумма затрат на зарплату по отделу 4: " + employeeBook.sumSalaryInDepartment(4));
        System.out.printf("Средняя зарплата по отделу 4: %.2f %n",employeeBook.avgSalaryInDepartment(4));
        employeeBook.increaseSalaryInDepartment(4,0.02);
        employeeBook.printAllEmployees();
        employeeBook.printEmployeeInDepartment(4);
        employeeBook.printEmployeesWithLowerSalary(100000);
        employeeBook.printEmployeesWithHigherSalary(100000);

        employeeBook.removeEmployee("Кузьмин", "Андрей", "Андреевич", 4);
        employeeBook.addEmployee("Андреева","Екатерина","Дмитриевна",2,170000);
        employeeBook.removeEmployee("Андреева","Екатерина","Дмитриевна",2);
        employeeBook.changeEmployee("Иванов","Иван","Иванович",3);
        employeeBook.changeEmployee("Иванов","Иван","Иванович",187000);
        employeeBook.printAllEmployeesByDepartment();
    }
}