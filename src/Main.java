public class Main {

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Иванов", "Иван", "Иванович", 2, 120000);
        employee[1] = new Employee("Петров", "Петр", "Петрович", 3, 70000);
        employee[2] = new Employee("Кузьмин", "Андрей", "Андреевич", 4, 65000);
        employee[3] = new Employee("Семенов", "Семен", "Семенович", 4, 90000);

        printAllEmployees(employee);
        System.out.println(sumSalary(employee));
        System.out.println("Первый сотрудник с минимальной зарплатой: " + minSalary(employee));
        System.out.println("Первый сотрудник с максимальной зарплатой: " + maxSalary(employee));
        System.out.println(avgSalary(employee));
        printAllFIO(employee);


    }

    public static void printAllEmployees(Employee[] employee) {
        for(int i =0; i < employee.length && (i+1)<Employee.getCounterId(); i++) {
            System.out.println(employee[i]);
        }
    }

    public static int sumSalary(Employee[] employee){
        int sumSalary = 0;

        for (int i=0; i< employee.length && (i+1)<Employee.getCounterId(); i++) {
            sumSalary += employee[i].getSalary();
        }
        return sumSalary;
    }

    public static Employee minSalary (Employee[] employee){
        //находим минимальную зарплату
        int minSalary = employee[0].getSalary();
        for(int i=0; i< employee.length && employee[i]!=null; i++){
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

    public static Employee maxSalary (Employee[] employee){
        //находим минимальную зарплату
        int maxSalary = employee[0].getSalary();
        for(int i=0; i< employee.length && employee[i]!=null; i++){
            if(maxSalary<employee[i].getSalary()){
                maxSalary = employee[i].getSalary();
            }
        }

        Employee empWithMinSalary = employee[0];

        for(int i=0; i< employee.length && employee[i]!=null; i++) {
            if(employee[i].getSalary() == maxSalary){
                empWithMinSalary = employee[i];
            }
        }
        return empWithMinSalary;
    }

    public static double avgSalary(Employee[] employee){
        return sumSalary(employee) * 1.0 / (Employee.getCounterId()-1);
    }

    public static void printAllFIO(Employee[] employee){
        for(int i=0; i< employee.length && employee[i]!=null; i++) {
            employee[i].printFIO();
        }
    }

}