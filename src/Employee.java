public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private int department;
    private int salary;

    int id;

    public Employee(int id, String lastName, String firstName, String middleName, int department, int salary){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
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

   public void setDepartment(int department){
        this.department = department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee: id = " + id + ",LastName = " + lastName + ", FirstName = " + firstName +
                ", MiddleName = " + middleName + ", Department = " + department + ", Salary = " + salary;
    }

  /*  @Override
   public boolean equals(Object other){
        if(this.getClass() != other.getClass()){
            return false;
        }
        Employee emp2 = (Employee) other;

        return (this.getLastName()== emp2.getLastName() && this.getFirstName()== emp2.getFirstName()&&
        this.getMiddleName()== emp2.getMiddleName());
    }
*/

    public void printFIO(){
        System.out.println(lastName.toUpperCase() + " " + firstName.toUpperCase().charAt(0) + ". " +
                middleName.toUpperCase().charAt(0) + ".");
    }

    public void printEmployeeWithoutDepartment(){
        System.out.println(id + " " + lastName + " " + firstName + " " +
                middleName + " " + salary);
    }
}
