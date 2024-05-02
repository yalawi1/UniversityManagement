// Yousef Alawi


import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {

        // creating an arraylist to store every Person
        ArrayList<Student> arrayOfStudent = new ArrayList<>();
        ArrayList<Staff> arrayOfStaff = new ArrayList<>();
        ArrayList<Faculty> arrayOfFaculty = new ArrayList<>();

        System.out.println("            Welcome to my Personal Management Program\n");
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        // Creating a loop to keep the program running
        while(loop) {
            Options();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Reading input from the user
                    System.out.print("\n\nEnter the faculty info: ");
                    System.out.print("\n    Name of faculty: ");
                    sc.nextLine().trim();
                    String facultyName = sc.nextLine().trim();

                    System.out.print("\n    ID: ");
                    String facultyID = sc.nextLine().trim();
                    System.out.print("\n    Rank: ");
                    String rank = sc.nextLine().trim();
                    System.out.print("\n    Department: ");
                    String department = sc.nextLine().trim();
                    System.out.print("\nFaculty added!\n\n");

                    // Adding the information
                    Faculty faculty = new Faculty(facultyName, facultyID, rank, department);
                    arrayOfFaculty.add(faculty);
                    break;
                case 2:
                    // Reading the students input
                    System.out.print("\n\nEnter the student info:");
                    System.out.print("\n    Name of Student: ");

                    sc.nextLine().trim();
                    String studentName = sc.nextLine();

                    System.out.print("\n    ID: ");
                    String ID = sc.nextLine();
                    System.out.print("\n    Gpa: ");
                    double GPA = sc.nextDouble();
                    System.out.print("\n    Credit hours: ");
                    int creditHours = sc.nextInt();
                    System.out.print("\nStudent added!\n\n");

                    // Adding the students information
                    Student student = new Student(studentName, ID, GPA, creditHours);
                    arrayOfStudent.add(student);
                    break;
                case 3:
                    // Output the information back to the user
                    System.out.print("Enter the student's id: ");

                    sc.nextLine().trim();
                    String getStudentId = sc.nextLine().trim();

                    for(int i = 0; i < arrayOfStudent.size(); i++){
                        Student current = arrayOfStudent.get(i);
                        if (current.getID().equals(getStudentId)){
                            current.printInformation();
                        }
                        else {
                            System.out.println("No student matched!\n\n");
                        }
                    }
                    break;
                case 4:
                    // Output the information back to the user
                    System.out.print("Enter the Faculty's id: ");
                    sc.nextLine().trim();
                    String getFacultyId = sc.nextLine().trim();

                    for(int i = 0; i < arrayOfFaculty.size(); i++){
                        Faculty current = arrayOfFaculty.get(i);
                        if (current.getID().equals(getFacultyId)){
                            current.printInformation();
                        }
                        else {
                            System.out.println("No Faculty matched!\n\n");
                        }
                    }
                    break;
                case 5:
                    // Reading the information from the Staff
                    System.out.print("\nName of the staff member: ");
                    sc.nextLine().trim();
                    String staffName = sc.nextLine().trim();

                    System.out.print("\nEnter the id: ");
                    String staffID = sc.nextLine().trim();
                    System.out.print("\nDepartment: ");
                    String staffDepartment = sc.nextLine().trim();
                    System.out.print("\nStatus, Enter P for Part Time, or Enter F for Full Time: ");
                    String status = sc.nextLine().trim();
                    System.out.print("\nStaff member added!\n\n");

                    // Adding the staff info
                    Staff staff = new Staff(staffName, staffID, status, staffDepartment);
                    arrayOfStaff.add(staff);
                    break;
                case 6:

                    // Output the information back to the user
                    System.out.print("Enter the Staff's id: ");
                    sc.nextLine().trim();
                    String getStaffId = sc.nextLine().trim();

                    for(int i = 0; i < arrayOfStaff.size(); i++){
                        Staff current = arrayOfStaff.get(i);
                        if (current.getID().equals(getStaffId)){
                            current.printInformation();
                        }
                        else {
                            System.out.println("No Staff matched!\n\n");
                        }
                    }
                    break;
                case 7:
                    // exiting the program
                    loop = false;
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
        System.out.println("Goodbye!");
    }


    public static void Options() {
        System.out.println("1- Enter the information a faculty");
        System.out.println("2- Enter the information of a student");
        System.out.println("3- Print tuition invoice for a student");
        System.out.println("4- Print faculty information");
        System.out.println("5- Enter the information of a staff member");
        System.out.println("6- Print the information of a staff member");
        System.out.println("7- Exit Program ");
        System.out.print("    Enter your selection: ");
    }
}
abstract class Person{

    private String Name;
    private String ID;

    // Constructor
    public Person(String Name, String ID) {
        this.Name = Name;
        this.ID = ID;
    }

    abstract void printInformation();

    // Make the getters and setters
    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }
}


class Student extends Person{

// Specified attributes

    double gpa;
    int noOfCreditHours;

    // Declaring a discount variable because we have to show it
    public double discount = 0.00;


    // constructor
    public Student(String fullName, String ID, double gpa, int noOfCreditHours) {
        super(fullName, ID);
        this.gpa = gpa;
        this.noOfCreditHours = noOfCreditHours;
    }

// Adding in the getters and setters
    public int getNoOfCreditHours()
    {
        return noOfCreditHours;
    }


    // Overriding all methods of Parent class
    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public void setName(String Name)
    {
        super.setName(Name);
    }

    @Override
    public String getID()
    {
        return super.getID();
    }

    @Override
    public void setID(String ID)
    {
        super.setID(ID);
    }

// A method tuition invoice for calculating total payment & return it
    public double tuitionInvoice(){

        // Students pay $236.45 per credit hour in addition to a $52 administrative fee
        double total = ( noOfCreditHours * 236.45) + 52.00;

        // implement the 25% off discount if the gpa is above 3.85
        if(this.gpa >= 3.85){

            discount = total * (25.0 / 100.0);
            total -= discount;
        }
        return total;
    }

    // @Override
    void printInformation() {

        System.out.println("\nHere is the tuition invoice for "+getName()+" :");
        System.out.println("---------------------------------------------------------------------------\n");
        System.out.println(getName()+"\t"+getID() +"\n"+
                "Credit Hours: "+getNoOfCreditHours()+" ($236.45/credit hour)\n"+
                "Fees: $52\nTotal Payment: $"+tuitionInvoice()+"\t"+"($"+discount+" discount applied)");
        System.out.println("---------------------------------------------------------------------------\n");
    }
}

abstract class Employee extends Person{

    private String department;

    // Creating my constructor
    public Employee(String fullName, String ID, String department) {
        super(fullName, ID);
        this.department = department;
    }

    // Adding the getters and setters
    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    // Overriding all methods of Parent class
    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public void setName(String Name)
    {
        super.setName(Name);
    }

    @Override
    public String getID()
    {
        return super.getID();
    }

    @Override
    public void setID(String ID)
    {
        super.setID(ID);
    }

    @Override
    void printInformation(){
    }
}
class Faculty extends Employee {
    String rank;

    // constructor
    public Faculty(String name, String ID, String rank, String department){
        super(name, ID, department);
        this.rank = rank;
    }

    // Overriding all methods of Parent class
    @Override
    public String getDepartment()
    {
        return super.getDepartment();
    }
    @Override
    public void setDepartment(String Name)
    {
        super.setDepartment(Name);
    }
    @Override
    public String getName()
    {
        return super.getName();
    }
    @Override
    public void setName(String Name)
    {
        super.setName(Name);
    }
    @Override
    public String getID()
    {
        return super.getID();
    }
    @Override
    public void setID(String ID)
    {
        super.setID(ID);
    }

    @Override
    void printInformation(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(getName() +"\t" +getID());
        System.out.println(getDepartment()+" Department \t," +this.rank);
        System.out.println("---------------------------------------------------------------------------");
    }
}
class Staff extends Employee {

    String status;

    // constructor
    public Staff(String name, String ID, String status, String department){
        super(name, ID, department);
        this.status = status;
    }

    // Overriding all methods of Parent class
    @Override
    public String getDepartment()
    {
        return super.getDepartment();
    }
    @Override
    public void setDepartment(String Name)
    {
        super.setDepartment(Name);
    }
    @Override
    public String getName()
    {
        return super.getName();
    }
    @Override
    public void setName(String Name)
    {
        super.setName(Name);
    }
    @Override
    public String getID()
    {
        return super.getID();
    }
    @Override
    public void setID(String ID)
    {
        super.setID(ID);
    }
    @Override
    void printInformation(){
        String time;
        if(this.status.equals("F")){
            time = "Full Time";
        }
        else {
            time = "Part Time";
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(getName() +"\t" +getID());
        System.out.println(getDepartment() +" Department \t," +time);
        System.out.println("---------------------------------------------------------------------------");
    }
}
