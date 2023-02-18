public class Main {
    static Employee[] employee = new Employee[10];
    public static void main(String[] args) {

        employee[0] = new Employee("Иванов", "Иван", "Иванович", 2, 120000);
        employee[1] = new Employee("Петров", "Петр", "Петрович", 3, 70000);
        employee[2] = new Employee("Кузьмин", "Андрей", "Андреевич", 4, 65000);
        employee[3] = new Employee("Семенов", "Семен", "Семенович", 4, 90000);

        printAllEmployees();
        System.out.println(sumSalary());
        System.out.println("Первый сотрудник с минимальной зарплатой: " + minSalary());
        System.out.println("Первый сотрудник с максимальной зарплатой: " + maxSalary());
        System.out.println(avgSalary());
        printAllFIO();

        increaseSalaryToAllEmployees(0.05);
        printAllEmployees();
    }

    public static void printAllEmployees() {
        for(int i =0; i < employee.length && (i+1)<Employee.getCounterId(); i++) {
            System.out.println(employee[i]);
        }
    }

    public static int sumSalary(){
        int sumSalary = 0;

        for (int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++) {
            sumSalary += employee[i].getSalary();
        }
        return sumSalary;
    }


    public static Employee minSalary (){
        //находим минимальную зарплату
        int minSalary = employee[0].getSalary();
        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++){
            if(minSalary>employee[i].getSalary()){
                minSalary = employee[i].getSalary();
            }
        }

        Employee empWithMinSalary = employee[0];

        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++) {
            if(employee[i].getSalary() == minSalary){
                empWithMinSalary = employee[i];
            }
        }
        return empWithMinSalary;
    }

    public static Employee maxSalary (){
        //находим минимальную зарплату
        int maxSalary = employee[0].getSalary();
        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++){
            if(maxSalary<employee[i].getSalary()){
                maxSalary = employee[i].getSalary();
            }
        }

        Employee empWithMinSalary = employee[0];

        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++) {
            if(employee[i].getSalary() == maxSalary){
                empWithMinSalary = employee[i];
            }
        }
        return empWithMinSalary;
    }

    public static double avgSalary(){
        return sumSalary() * 1.0 / (Employee.getCounterId()-1);
    }

    public static void printAllFIO(){
        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++) {
            employee[i].printFIO();
        }
    }

    public static void increaseSalaryToAllEmployees(double increaseRate){
        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++){
            employee[i].setSalary((int)(employee[i].getSalary()*(1+increaseRate)));
        }
    }

    public static Employee searchEmployeeWithMinSalaryInDepartment (int department){
        for(int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++){
            if (employee[i].getDepartment()==department) {
                int minSalaryInDepartment = employee[i].getSalary();
                for (int i=0; )
            }
            }
        }
    }




}