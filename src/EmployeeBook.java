public class EmployeeBook {
    private Employee[] employee;
  //  private int counterId = 1;

    private int size;

    public EmployeeBook(){
        this.employee = new Employee[10];
    }

    public void addEmployee(String lastName, String firstName, String middleName, int department, int salary){
        if(size >= employee.length){
            System.out.println("Нельзя добавить сотрудника! Закончилось место.");
            return;
        }

        Employee newEmployee = new Employee(lastName, firstName, middleName, department, salary);
        employee[size++] = newEmployee;
    }

    public void removeEmployee(String lastName, String firstName, String middleName, int department){
        for (int i=0; i< employee.length;i++){
            if (employee[i].getLastName().equals(lastName) &&
                    employee[i].getFirstName().equals(firstName) &&
                    employee[i].getMiddleName().equals(middleName) &&
                    employee[i].getDepartment() == department){
                System.out.println(employee[i] + " удален.");
                System.arraycopy(employee, i+1, employee, i, employee.length-i-1);
                employee[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void changeEmployee(String lastName, String firstName, String middleName, int value) {
        for (int i = 0; i < size; i++) {
            if (employee[i].getLastName().equals(lastName) &&
                    employee[i].getFirstName().equals(firstName) &&
                    employee[i].getMiddleName().equals(middleName)) {
                if (value>0 && value <=5){
                    employee[i].setDepartment(value);
                } else {
                    employee[i].setSalary(value);
                }
            }
        }
    }

    public void printAllEmployees() {
        for(int i =0; i < size; i++) {
            System.out.println(employee[i]);
        }
    }

    public int sumSalary(){
        int sumSalary = 0;

        for (int i=0; i < size; i++) {
            sumSalary += employee[i].getSalary();
        }
        return sumSalary;
    }


    public Employee minSalary (){
        //находим минимальную зарплату
        int minSalary = employee[0].getSalary();
        Employee employeeWithMinSalary = employee[0];
        for(int i=0; i< size; i++){
            if(minSalary>employee[i].getSalary()){
                minSalary = employee[i].getSalary();
                employeeWithMinSalary=employee[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Employee maxSalary (){
        //находим минимальную зарплату
        int maxSalary = employee[0].getSalary();
        Employee employeeWithMaxSalary = employee[0];
        for(int i=0; i< size; i++){
            if(maxSalary<employee[i].getSalary()){
                maxSalary = employee[i].getSalary();
                employeeWithMaxSalary = employee[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public double avgSalary(){
        return (double) sumSalary() / size;
    }

    public void printAllFIO(){
        for(int i=0; i< size; i++) {
            employee[i].printFIO();
        }
    }

    //повышенная сложность

    public void increaseSalaryToAllEmployees(double increaseRate){
        for(int i=0; i< size; i++){
            employee[i].setSalary((int)(employee[i].getSalary()*(1+increaseRate)));
        }
    }

    public Employee searchEmployeeWithMinSalaryInDepartment (int department){
        int minSalaryInDepartment = 1_000_000_000;
        Employee employeeWithMinSalaryInDepartment = null;
        for(int i=0; i< size; i++){
            if(employee[i].getDepartment()==department) {
                if (minSalaryInDepartment > employee[i].getSalary()) {
                    minSalaryInDepartment = employee[i].getSalary();
                    employeeWithMinSalaryInDepartment = employee[i];
                }
            }
        }
        return employeeWithMinSalaryInDepartment;
    }

    public Employee searchEmployeeWithMaxSalaryInDepartment (int department){
        int maxSalaryInDepartment = 0;
        Employee employeeWithMaxSalaryInDepartment = null;
        for(int i=0; i< size; i++){
            if(employee[i].getDepartment()==department) {
                if (maxSalaryInDepartment < employee[i].getSalary()) {
                    maxSalaryInDepartment = employee[i].getSalary();
                    employeeWithMaxSalaryInDepartment = employee[i];
                }
            }
        }
        return employeeWithMaxSalaryInDepartment;
    }

    public int sumSalaryInDepartment(int department){
        int sumSalaryInDepartment = 0;

        for (int i=0; i < size; i++) {
            if(employee[i].getDepartment()==department) {
                sumSalaryInDepartment += employee[i].getSalary();
            }
        }
        return sumSalaryInDepartment;
    }

    public double avgSalaryInDepartment(int department){
        int countEmployeeInDepartment = 0;
        for(int i=0; i < size; i++){
            if(employee[i].getDepartment()==department){
                countEmployeeInDepartment++;
            }
        }
        return (double) sumSalaryInDepartment(department) / countEmployeeInDepartment;
    }

    public void increaseSalaryInDepartment(int department, double increaseRateInDepartment){
        for(int i=0; i< size; i++){
            if(employee[i].getDepartment()==department) {
                employee[i].setSalary((int) (employee[i].getSalary() * (1 + increaseRateInDepartment)));
            }
        }
    }

    public void printEmployeeInDepartment(int department){
        System.out.println("Сотрудники отдела " + department + ":");
        for(int i=0; i< size; i++) {
            if(employee[i].getDepartment()==department) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }

    public void printEmployeesWithLowerSalary (int setSalary){
        System.out.println("Список сотрудников с зарплатой ниже " + setSalary);
        for(int i=0; i< size; i++) {
            if(employee[i].getSalary()<setSalary) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }

    public void printEmployeesWithHigherSalary (int setSalary){
        System.out.println("Список сотрудников с зарплатой выше " + setSalary);
        for(int i=0; i< size; i++) {
            if(employee[i].getSalary()>setSalary) {
                employee[i].printEmployeeWithoutDepartment();
            }
        }
    }

    public void printAllEmployeesByDepartment(){
        System.out.println("Печать сотрудников по отделам:");
        int department = 1;
        while (department<6){
            printEmployeeInDepartment(department);
            department++;
        }
    }
}
