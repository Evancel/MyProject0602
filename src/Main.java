

public class Main {
    static Employee[] employee = new Employee[10];
    static int counterId;
    public static void main(String[] args) {

        addEmployee("Иванов", "Иван", "Иванович", 2, 120000);
        addEmployee("Петров", "Петр", "Петрович", 3, 70000);
        addEmployee("Кузьмин", "Андрей", "Андреевич", 4, 65000);
        addEmployee("Семенов", "Семен", "Семенович", 4, 90000);
        addEmployee("Иванова", "Лариса", "Ивановна", 2, 50000);
        addEmployee("Петрова", "Ольга", "Андреевна", 2, 87000);
        addEmployee("Кузьмина", "София", "Иосифовна", 4, 115000);


        printAllEmployees();
        System.out.println(sumSalary());
        System.out.println("Первый сотрудник с минимальной зарплатой: " + minSalary());
        System.out.println("Первый сотрудник с максимальной зарплатой: " + maxSalary());
        System.out.println(avgSalary());
        printAllFIO();

        increaseSalaryToAllEmployees(0.05);
        printAllEmployees();
        System.out.println("Первый сотрудник с минимальной зарплатой в отделе 4: " + searchEmployeeWithMinSalaryInDepartment(4));
        System.out.println("Первый сотрудник с максимальной зарплатой в отделе 4: " + searchEmployeeWithMaxSalaryInDepartment(4));
        System.out.println("Сумма затрат на зарплату по отделу 4:" + sumSalaryInDepartment(4));
        System.out.println("Средняя зарплата по отделу 4:" + avgSalaryInDepartment(4));
        increaseSalaryInDepartment(4,0.02);
        printAllEmployees();
        printEmployeeInDepartment(4);
        printEmployeesWithLowerSalary(100000);
        printEmployeesWithHigherSalary(100000);

    }

    public static void addEmployee(String lastName, String firstName, String middleName, int department, int salary){
        if(counterId >= employee.length){
            System.out.println("Нельзя добавить сотрудника! Закончилось место.");
            return;
        }
        Employee newEmployee = new Employee(lastName, firstName, middleName, department, salary);
        employee[counterId++] = newEmployee;
    }

    public static void printAllEmployees() {
        for(int i =0; i < counterId; i++) {
            System.out.println(employee[i]);
        }
    }

    public static int sumSalary(){
        int sumSalary = 0;

        for (int i=0; i < counterId; i++) {
            sumSalary += employee[i].getSalary();
        }
        return sumSalary;
    }


    public static Employee minSalary (){
        //находим минимальную зарплату
        int minSalary = employee[0].getSalary();
        Employee employeeWithMinSalary = employee[0];
        for(int i=0; i< counterId; i++){
            if(minSalary>employee[i].getSalary()){
                minSalary = employee[i].getSalary();
                employeeWithMinSalary=employee[i];
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee maxSalary (){
        //находим минимальную зарплату
        int maxSalary = employee[0].getSalary();
        Employee employeeWithMaxSalary = employee[0];
        for(int i=0; i< counterId; i++){
            if(maxSalary<employee[i].getSalary()){
                maxSalary = employee[i].getSalary();
                employeeWithMaxSalary = employee[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public static double avgSalary(){
        return (double) sumSalary() / counterId;
    }

    public static void printAllFIO(){
        for(int i=0; i< counterId; i++) {
            employee[i].printFIO();
        }
    }

    //повышенная сложность

    public static void increaseSalaryToAllEmployees(double increaseRate){
        for(int i=0; i< counterId; i++){
            employee[i].setSalary((int)(employee[i].getSalary()*(1+increaseRate)));
        }
    }

    public static Employee searchEmployeeWithMinSalaryInDepartment (int department){
        int minSalaryInDepartment = 1_000_000_000;
        Employee employeeWithMinSalaryInDepartment = null;
        for(int i=0; i< counterId; i++){
            if(employee[i].getDepartment()==department) {
                if (minSalaryInDepartment > employee[i].getSalary()) {
                    minSalaryInDepartment = employee[i].getSalary();
                    employeeWithMinSalaryInDepartment = employee[i];
                }
            }
            }
        return employeeWithMinSalaryInDepartment;
    }

    public static Employee searchEmployeeWithMaxSalaryInDepartment (int department){
        int maxSalaryInDepartment = 0;
        Employee employeeWithMaxSalaryInDepartment = null;
        for(int i=0; i< counterId; i++){
            if(employee[i].getDepartment()==department) {
                if (maxSalaryInDepartment < employee[i].getSalary()) {
                    maxSalaryInDepartment = employee[i].getSalary();
                    employeeWithMaxSalaryInDepartment = employee[i];
                }
            }
        }
        return employeeWithMaxSalaryInDepartment;
    }

    public static int sumSalaryInDepartment(int department){
        int sumSalaryInDepartment = 0;

        for (int i=0; i < counterId; i++) {
            if(employee[i].getDepartment()==department) {
                sumSalaryInDepartment += employee[i].getSalary();
            }
        }
        return sumSalaryInDepartment;
    }

    public static double avgSalaryInDepartment(int department){
        int countEmployeeInDepartment = 0;
        for(int i=0; i < counterId; i++){
            if(employee[i].getDepartment()==department){
                countEmployeeInDepartment++;
            }
        }
        return (double) sumSalaryInDepartment(department) / countEmployeeInDepartment;
    }

    public static void increaseSalaryInDepartment(int department, double increaseRateInDepartment){
        for(int i=0; i< counterId; i++){
            if(employee[i].getDepartment()==department) {
                employee[i].setSalary((int) (employee[i].getSalary() * (1 + increaseRateInDepartment)));
            }
        }
    }

    public static void printEmployeeInDepartment(int department){
        System.out.println("Сотрудники отдела " + department + ":");
        for(int i=0; i< counterId; i++) {
            if(employee[i].getDepartment()==department) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }

    public static void printEmployeesWithLowerSalary (int setSalary){
        System.out.println("Список сотрудников с зарплатой ниже " + setSalary);
        for(int i=0; i< counterId; i++) {
            if(employee[i].getSalary()<setSalary) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }

    public static void printEmployeesWithHigherSalary (int setSalary){
        System.out.println("Список сотрудников с зарплатой выше " + setSalary);
        for(int i=0; i< counterId; i++) {
            if(employee[i].getSalary()>setSalary) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }



}