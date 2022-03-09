class Students {
  private String rollNo;
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public void setRollNo(String rollNo) {
    this.rollNo = rollNo;
  }

  public String getName() {
    return name;
  }

  public String getRollNo() {
    return rollNo;
  }
}

class StudentView {

  public void printStudentInfo(String name, String studentRollNo) {
    System.out.println("Student");
    System.out.println(String.format("Student name: %s", name));
    System.out.println(String.format("Student rollNo: %s", studentRollNo));
  }
}

class StudentController {
  private Students students;
  private StudentView studentView;

  StudentController(Students students, StudentView studentView) {
    this.students = students;
    this.studentView = studentView;
  }

  public void setStudents(String name) {
    this.students.setName(name);
  }

  public void setStudentView(String roll) {
    this.students.setRollNo(roll);
  }

  public String getStudentsName() {
    return students.getName();
  }

  public String getStudentRollNO() {
    return students.getRollNo();
  }

  public void update() {
    studentView.printStudentInfo(students.getName(), students.getRollNo());
  }

}

public class MVC_DesignPattern {
  private static Students simulateStudent() {
    Students students = new Students();
    students.setName("First name students");
    students.setRollNo("111");
    return students;
  }

  public static void main(String[] args) {

    Students model = simulateStudent();
    StudentView studentView = new StudentView();
    StudentController studentController = new StudentController(model, studentView);
    studentController.update();
    studentController.setStudents("Name set by controller");
    studentController.update();

  }
}
