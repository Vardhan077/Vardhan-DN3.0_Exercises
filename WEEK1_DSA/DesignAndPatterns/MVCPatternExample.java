

public class MVCPatternExample {
    public static void main(String[] args) {
        Student studentModel = new Student("1", "John Doe", "A");
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);
        studentController.updateView();
        studentController.setStudentName("Jane Doe");
        studentController.setStudentGrade("B");
        studentController.updateView();
    }
}


class Student {
    private String studentId;
    private String studentName;
    private String studentGrade;

    public Student(String studentId, String studentName, String studentGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}

class StudentView {
    public void displayStudentInfo(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Information:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

class StudentController {
    private Student studentModel;
    private StudentView studentView;

    public StudentController(Student studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    public void setStudentName(String studentName) {
        studentModel.setStudentName(studentName);
    }

    public String getStudentName() {
        return studentModel.getStudentName();
    }

    public void setStudentId(String studentId) {
        studentModel.setStudentId(studentId);
    }

    public String getStudentId() {
        return studentModel.getStudentId();
    }

    public void setStudentGrade(String studentGrade) {
        studentModel.setStudentGrade(studentGrade);
    }

    public String getStudentGrade() {
        return studentModel.getStudentGrade();
    }

    public void updateView() {
        studentView.displayStudentInfo(studentModel.getStudentName(), studentModel.getStudentId(), studentModel.getStudentGrade());
    }
}