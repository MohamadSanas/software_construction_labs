import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private static int totalStudents;

    private final String StudentCategorySwitch;
    private final String StudentCategoryIF;

    public Student(int id, String name, int age, String grade) throws IllegalArgumentException {
        this.id = id;
        this.name = name;
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }

        this.age = age;
        this.grade = grade;
        this.StudentCategoryIF = categoriesStudent(grade);
        this.StudentCategorySwitch = categoriesStudentSwitch(grade);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void UpdateAge(int newAge) {
        this.age = newAge;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void displayStudentDetails() {

        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Grade: " + grade);
    }

    public void incrementTotalStudents() {
        totalStudents++;
    }

    public String categoriesStudent(String Grade) {
        if (Grade.equals("A")) {
            return "Excellent Grade";
        } else if (Grade.equals("B")) {
            return "Good Grade";
        } else if (Grade.equals("C")) {
            return "Average Grade";
        } else if (Grade.equals("D")) {
            return " Needs Improvement";
        } else {
            return "Invalid Grade";
        }
    }

    public String categoriesStudentSwitch(String Grade) {
        switch (Grade) {
            case "A":
                return "Excellent Grade";
            case "B":
                return "Good Grade";
            case "C":
                return "Average Grade";
            case "D":
                return "Needs Improvement";
            default:
                return "Invalid Grade";
        }
    }

    public void namespaceConflictExample() {
        String name = "LocalName";
        System.out.println("Local name: " + name);
        System.out.println("Instance name (this.name): " + this.name);


    }
    @Override
    protected void finalize() throws  Throwable {
        System.out.println("Student object Garbage Collected "+name);


    }
}

class llegalArgumentException extends RuntimeException{
    public llegalArgumentException(String message){
        super(message);
    }
}

class StudentListProcessor{
    private final List<Student> studentList;

    public StudentListProcessor(List<Student> studentList){
        this.studentList = studentList;
    }

    public void getStudentListForLoop(){
        System.out.println("Student details by for loop");

        for(int i=0;i<studentList.size();i++){
            studentList.get(i).displayStudentDetails();
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("########################################################");

    }

    public void getStudentListWhileLoop(){
        System.out.println("Student details by while loop");

        int i=0;
        while(studentList.size()>i){
            studentList.get(i).displayStudentDetails();
            i++;
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("########################################################");
    }

    public void getStudentListDoWhileLoop(){
        System.out.println("Student details by do while loop");
        int i=0;
        do{
            studentList.get(i).displayStudentDetails();
            i++;
            System.out.println("-------------------------------------------------------------");
        }
        while (studentList.size()>i);
        System.out.println("########################################################");
    }

    public void getStudentListForEachLoop(){
        System.out.println("Student details by for each loop");

        for (Student s :studentList){
            s.displayStudentDetails();
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("########################################################");
    }


}

class StudentMemoryDemo{
    public void runDemo(){
        System.out.println("Student memory demo");

        Student s1=new Student(309,"Alex" ,20,"B");
        Student s2=new Student(310,"Delex" ,21,"C");
        Student s3=new Student(311,"Daniel" ,22,"C");

        s1=null;
        s2=null;

        System.out.println("Reques Garbage collection");
        System.gc();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();


        try{
            studentList.add(new Student(1, "sanas", 19, "A"));
        }catch (Exception e){
            e.getMessage();
        }
        try{
            studentList.add(new Student(2, "Aakil", 21, "B"));
        }catch (Exception e){
            e.getMessage();
        }

        try{
            studentList.add(new Student(3, "Riyasath", 22, "C"));
        }catch (Exception e){
            e.getMessage();
        }

        try{
            studentList.add(new Student(4, "Munshif", -1, "D"));
        }catch (Exception e){
            e.getMessage();
        }

        try{
            studentList.add(new Student(5, "Mishra", 101, "D"));
        }catch (Exception e){
            e.getMessage();
        }








        StudentListProcessor processor = new StudentListProcessor(studentList);
        processor.getStudentListForLoop();
        processor.getStudentListWhileLoop();
        processor.getStudentListDoWhileLoop();
        processor.getStudentListForEachLoop();

        // Show namespace conflict example
        if (!studentList.isEmpty()) {
            studentList.get(0).namespaceConflictExample();
            System.out.println();
        }

        new StudentMemoryDemo().runDemo();



    }
}




