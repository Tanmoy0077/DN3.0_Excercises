public class App {
    public static void main(String[] args) {
         // Create the model
         Student student = new Student("Sunil Chetri", "12345", "A");

         // Create the view
         StudentView view = new StudentView();
 
         // Create the controller
         StudentController controller = new StudentController(student, view);
 
         // Display initial student details
         controller.updateView();
 
         // Update student details
         controller.setStudentName("Robato Carlos");
         controller.setStudentGrade("B");
 
         // Display updated student details
         controller.updateView();
    }
}
