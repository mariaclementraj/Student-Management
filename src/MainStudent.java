import java.sql.SQLException;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) throws SQLException {
        StudentMethod obj = new StudentMethod();
        Scanner scanner = new Scanner(System.in);
        obj.checkUserPassword(scanner);
        int opt;
        while (true) {
            System.out.println();
            System.out.println("Press 1 For Student Profile");
            System.out.println("Press 2 For Entering Marks");
            System.out.println("Press 3 For Admin Operation");
            System.out.println("Press 4 For Report Viewing");
            System.out.println("Press 5 To Exit...");
            System.out.println("Please Enter Your Option");
            try {
                opt = Integer.parseInt(scanner.nextLine().trim());
                switch (opt) {
                    case 1:
                        studentProfile(obj, scanner);
                        break;
                    case 2:
                        studentMark(obj, scanner);
                        break;
                    case 3:
                        studentAdmin(obj, scanner);
                        break;
                    case 4:
                        studentReport(obj,scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.out.println("Thank You...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid Option Please Enter Number Between 1 and 5");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please Enter a Valid Integer...");
            }
        }
    }

    public static void studentProfile(StudentMethod obj, Scanner scanner) throws SQLException {
        int opt;
        do {
            System.out.println();
            System.out.println("Press 1 For Add Profile");
            System.out.println("Press 2 For Update Profile");
            System.out.println("Press 3 For Delete Profile");
            System.out.println("Press 4 For View Profile");
            System.out.println("Press 5 For Exit...");
            System.out.println("Enter Your Option");
            opt = Integer.parseInt(scanner.nextLine().trim());
            switch (opt) {
                case 1:
                    obj.insertStudent(scanner);
                    break;
                case 2:
                    obj.updateStudent(scanner);
                    break;
                case 3:
                    obj.deleteStudent(scanner);
                    break;
                case 4:
                    obj.viewStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thank You...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (opt != 5);
    }

    public static void studentMark(StudentMethod obj, Scanner scanner) throws SQLException {
        int opt;
        do {
            System.out.println();
            System.out.println("Press 1 For Add Marks");
            System.out.println("Press 2 For Update Marks");
            System.out.println("Press 3 For Delete Marks");
            System.out.println("Press 4 For View Marks");
            System.out.println("Press 5 For Exit...");
            System.out.println("Enter Your Option");
            opt = Integer.parseInt(scanner.nextLine().trim());
            switch (opt) {
                case 1:
                    obj.insertStudentMark(scanner);
                    break;
                case 2:
                    obj.updateStudentMark(scanner);
                    break;
                case 3:
                    obj.deleteStudentMark(scanner);
                    break;
                case 4:
                    obj.viewStudentMark(scanner);
                    break;
                case 5:
                    System.out.println("Thank You...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (opt != 5);
    }

    public static void studentAdmin(StudentMethod obj, Scanner scanner) throws SQLException {
        int opt;
        do {
            System.out.println();
            System.out.println("Press 1 For Add Admin");
            System.out.println("Press 2 For Delete Admin");
            System.out.println("Press 3 For Exit...");
            System.out.println("Enter Your Option");
            opt = Integer.parseInt(scanner.nextLine().trim());
            switch (opt) {
                case 1:
                    obj.insertAdmin(scanner);
                    break;
                case 2:
                    obj.deleteAdmin(scanner);
                    break;
                case 3:
                    System.out.println("Thank You...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        } while (opt != 3);
    }

    public static void studentReport(StudentMethod obj, Scanner scanner) throws SQLException {
        int opt;
        do {
            System.out.println();
            System.out.println("Press 1 For Student Profile Report");
            System.out.println("Press 2 For Student Mark Report");
            System.out.println("Press 3 For Search Report Using Student ID");
            System.out.println("Press 4 For Search Report Using Student Name");
            System.out.println("Press 5 For Exit...");
            System.out.println("Enter Your Option");
            opt = Integer.parseInt(scanner.nextLine().trim());
            switch (opt) {
                case 1:
                    obj.studentReport(scanner);
                    break;
                case 2:
                    obj.markReport(scanner);
                    break;
                case 3:
                    obj.searchReport(scanner);
                    break;
                case 4:
                    obj.searchReportName(scanner);
                    break;
                case 5:
                    System.out.println("Thank You...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        } while (opt != 5);
    }
}