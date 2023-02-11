public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    int department;
    int salary;

    int id;
    private static int counterId = 1;

    public Employee(String lastName, String firstName, String middleName, int department, int salary){
        this.id = counterId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        counterId+=1;
    }
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMiddleName(){
        return middleName;
    }
    public int getDepartment(){
        return department;
    }
    public int getSalary(){
        return salary;
    }

    public static int getCounterId(){
        return counterId;
    }
    public void setDepartment(int department){
        this.department = department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String toString(){
        return "Employee: id = " + id + ",LastName = " + lastName + ", FirstName = " + firstName +
                ", MiddleName = " + middleName + ", Department = " + department + ", Salary = " + salary;
    }

    public void printFIO(){
        System.out.println(lastName.toUpperCase() + " " + firstName.toUpperCase().charAt(0) + ". " +
                middleName.toUpperCase().charAt(0) + ".");
    }
}
