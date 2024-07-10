import java.sql.*;
import java.util.Scanner;

public class StudentMethod {
    private static final String url = "jdbc:mysql://localhost/student";
    private static final String user = "root";
    private static final String pass = "Clement@12345";
    public String result;

    public Connection checkUserPassword(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Enter Username ");
            String username = scanner.nextLine();

            System.out.println("Enter Password ");
            String password = scanner.nextLine();

            String sql = "Select Pwd from admin where username = ?";
            try (PreparedStatement pre = con.prepareStatement(sql)) {
                pre.setString(1, username);
                try (ResultSet r = pre.executeQuery()) {
                    if (r.next()) {
                        String storedPassword = r.getString("Pwd");
                        if (password.equals(storedPassword)) {
                            System.out.println("Welcome " + username);
                        } else {
                            System.out.println("Incorrect Password");
                            System.out.println("Try Again with correct password");
                        }
                    } else {
                        System.out.println("User Not Found...");
                        System.out.println("You Can Add Admin Profile...");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }


    public Connection insertStudent(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "INSERT INTO student(StudentName, Age, AddressLine1, AddressLine2, AddressLine3, DOB, State, Pincode, LandMark, Moblie_No) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter Student Name");
                String name = scanner.nextLine();
                System.out.println("Enter the Age");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the AddressLine 1");
                String address1 = scanner.nextLine();
                System.out.println("Enter the AddressLine 2");
                String address2 = scanner.nextLine();
                System.out.println("Enter the AddressLine 3");
                String address3 = scanner.nextLine();
                System.out.println("Enter the DOB");
                String dob = scanner.nextLine();
                System.out.println("Enter the State");
                String state = scanner.nextLine();
                System.out.println("Enter the Pincode");
                int pin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Landmark");
                String landmark = scanner.nextLine();
                System.out.println("Enter the Mobile No");
                int mobile = scanner.nextInt();
                scanner.nextLine();
                pre.setString(1, name);
                pre.setInt(2, age);
                pre.setString(3, address1);
                pre.setString(4, address2);
                pre.setString(5, address3);
                pre.setString(6, dob);
                pre.setString(7, state);
                pre.setInt(8, pin);
                pre.setString(9, landmark);
                pre.setInt(10, mobile);
                pre.executeUpdate();
                System.out.println("Student Details Added Successfully...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }

    public Connection insertStudentMark(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "INSERT INTO marks(Student_ID, Mark1, Mark2, Mark3, Mark4, Result) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter Student ID");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 1");
                int m1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 2");
                int m2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 3");
                int m3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 4");
                int m4 = scanner.nextInt();
                scanner.nextLine();
                int tot = (m1 + m2 + m3 + m4) / 4;
                String result = (tot >= 50) ? "Pass" : "Fail";
                pre.setInt(1, id);
                pre.setInt(2, m1);
                pre.setInt(3, m2);
                pre.setInt(4, m3);
                pre.setInt(5, m4);
                pre.setString(6, result);
                pre.executeUpdate();
                System.out.println("Student Marks Added Successfully...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }


    public Connection insertAdmin(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "INSERT INTO admin(Name, UserName, Pwd) VALUES (?, ?, ?)";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter Admin Name");
                String name = scanner.nextLine();
                System.out.println("Enter Admin User Name");
                String userName = scanner.nextLine();
                System.out.println("Enter Admin Password");
                String password = scanner.nextLine();
                pre.setString(1, name);
                pre.setString(2, userName);
                pre.setString(3, password);
                pre.executeUpdate();
                System.out.println("Admin Details Added Successfully...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }


    public Connection updateStudent(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "UPDATE student SET StudentName=?, Age=?, AddressLine1=?, AddressLine2=?, AddressLine3=?, DOB=?, State=?, Pincode=?, LandMark=?, Moblie_No=? WHERE ID=?";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter the Student ID to Update ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Student Name");
                String name = scanner.nextLine();
                System.out.println("Enter the Age");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the AddressLine 1");
                String address1 = scanner.nextLine();
                System.out.println("Enter the AddressLine 2");
                String address2 = scanner.nextLine();
                System.out.println("Enter the AddressLine 3");
                String address3 = scanner.nextLine();
                System.out.println("Enter the DOB");
                String dob = scanner.nextLine();
                System.out.println("Enter the State");
                String state = scanner.nextLine();
                System.out.println("Enter the Pincode");
                int pin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Landmark");
                String landmark = scanner.nextLine();
                System.out.println("Enter the Mobile No");
                int mobile = scanner.nextInt();
                scanner.nextLine();
                pre.setString(1, name);
                pre.setInt(2, age);
                pre.setString(3, address1);
                pre.setString(4, address2);
                pre.setString(5, address3);
                pre.setString(6, dob);
                pre.setString(7, state);
                pre.setInt(8, pin);
                pre.setString(9, landmark);
                pre.setInt(10, mobile);
                pre.setInt(11, studentId);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student Details Updated Successfully...");
                } else {
                    System.out.println("No Student Found With ID " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }

    public Connection updateStudentMark(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "UPDATE marks SET Student_ID=?, Mark1=?, Mark2=?, Mark3=?, Mark4=?, Result=? WHERE Student_ID=?";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter the Student ID ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Student ID to Update");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 1 to Update");
                int m1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 2 to Update");
                int m2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 3 to Update");
                int m3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Mark 4 to Update");
                int m4 = scanner.nextInt();
                scanner.nextLine();
                int tot = (m1 + m2 + m3 + m4) / 4;
                String result;
                if (tot >= 50)
                    result = "Pass";
                else
                    result = "Fail";
                pre.setInt(1, id);
                pre.setInt(2, m1);
                pre.setInt(3, m2);
                pre.setInt(4, m3);
                pre.setInt(5, m4);
                pre.setString(6, result);
                pre.setInt(7, studentId);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student Details Updated Successfully...");
                } else {
                    System.out.println("No Student Found With ID " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }


    public static void viewStudent(Scanner scanner) throws SQLException {
        Connection con = null;
        System.out.println("Enter student ID to View Profile ");
        int studentId = Integer.parseInt(scanner.nextLine().trim());
        String selectQuery = "SELECT * FROM student WHERE ID = ?";
        try {
            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pre = con.prepareStatement(selectQuery);
            pre.setInt(1, studentId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                System.out.println("Student Profile ");
                String name = rs.getString("StudentName");
                System.out.println("Student Name = " + name);
                int age = rs.getInt("Age");
                System.out.println("Age = " + age);
                String add1 = rs.getString("AddressLine1");
                System.out.println("AddressLine 1 = " + add1);
                String add2 = rs.getString("AddressLine2");
                System.out.println("AddressLine 2 = " + add2);
                String add3 = rs.getString("AddressLine3");
                System.out.println("AddressLine 3 = " + add3);
                String dob = rs.getString("DOB");
                System.out.println("DOB = " + dob);
                String state = rs.getString("State");
                System.out.println("State = " + state);
                int pin = rs.getInt("Pincode");
                System.out.println("Pincode = " + pin);
                String land = rs.getString("LandMark");
                System.out.println("Landmark = " + land);
                int mobile = rs.getInt("Moblie_No");
                System.out.println("Mobile No = " + mobile);
            } else {
                System.out.println("No Student Found with ID " + studentId);
            }
        } catch (SQLException e) {
            System.out.println("Error executing select query: " + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    public static void viewStudentMark(Scanner scanner) throws SQLException {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Enter Student ID to View Marks ");
            int studentId;
            try {
                studentId = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for Student ID.");
                return;
            }
            String selectQuery = "SELECT * FROM marks WHERE Student_ID = ?";
            pre = con.prepareStatement(selectQuery);
            pre.setInt(1, studentId);
            rs = pre.executeQuery();
            if (rs.next()) {
                System.out.println("Student Marks: ");
                int id = rs.getInt("Student_ID");
                System.out.println("Student ID: " + id);
                int m1 = rs.getInt("Mark1");
                System.out.println("Mark 1: " + m1);
                int m2 = rs.getInt("Mark2");
                System.out.println("Mark 2: " + m2);
                int m3 = rs.getInt("Mark3");
                System.out.println("Mark 3: " + m3);
                int m4 = rs.getInt("Mark4");
                System.out.println("Mark 4: " + m4);
                String result = rs.getString("Result");
                System.out.println("Result: " + result);
            } else {
                System.out.println("No Student Found with ID: " + studentId);
            }
        } catch (SQLException e) {
            System.out.println("Error executing select query: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                    pre.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing database resources: " + ex.getMessage());
            }
        }
    }


    public static void studentReport(Scanner scanner) throws SQLException {
        String selectQuery = "SELECT * FROM student";
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement pre = con.prepareStatement(selectQuery);
            ResultSet rs = pre.executeQuery();
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t*********");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tSTUDENT PROFILE REPORTS");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t*********");
            System.out.println();
            System.out.println("|------------|------------------|-----|-----------------------------------|------------|---------|---------|----------|------------|");
            System.out.println("| Student ID | Student Name     | Age | Address                           | DOB        | State   | Pincode | Landmark | Mobile No  |");
            System.out.println("|------------|------------------|-----|-----------------------------------|------------|---------|---------|----------|------------|");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("StudentName");
                int age = rs.getInt("Age");
                String address = rs.getString("AddressLine1") + ", " + rs.getString("AddressLine2") + ", " + rs.getString("AddressLine3");
                String dob = rs.getString("DOB");
                String state = rs.getString("State");
                int pin = rs.getInt("Pincode");
                String landmark = rs.getString("LandMark");
                int mobile = rs.getInt("Moblie_No");
                System.out.printf("| %-10d | %-16s | %-3d | %-33s | %-10s | %-7s | %-7d | %-8s | %-10d |\n", id, name, age, address, dob, state, pin, landmark, mobile);
            }
            System.out.println("|------------|------------------|-----|-----------------------------------|------------|---------|---------|----------|------------|");
        } catch (SQLException e) {
            System.out.println("Error executing select query: " + e.getMessage());
        }
    }


    public static void markReport(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String selectQuery = "SELECT * FROM marks";
            PreparedStatement pre = con.prepareStatement(selectQuery);
            ResultSet rs = pre.executeQuery();
            System.out.println();
            System.out.println("\t\t\t\t\t********");
            System.out.println("\t\t\t\t\tSTUDENT MARKS REPORTS");
            System.out.println("\t\t\t\t\t********");
            System.out.println();
            System.out.println("+------------+-------+-------+-------+-------+--------+");
            System.out.println("| Student ID | Mark1 | Mark2 | Mark3 | Mark4 | Result |");
            System.out.println("+------------+-------+-------+-------+-------+--------+");
            while (rs.next()) {
                int id = rs.getInt("Student_ID");
                int m1 = rs.getInt("Mark1");
                int m2 = rs.getInt("Mark2");
                int m3 = rs.getInt("Mark3");
                int m4 = rs.getInt("Mark4");
                String result = rs.getString("Result");
                System.out.printf("| %-10d | %-5d | %-5d | %-5d | %-5d | %-6s |\n", id, m1, m2, m3, m4, result);
            }
            System.out.println("+------------+-------+-------+-------+-------+--------+");
        } catch (SQLException e) {
            System.out.println("Error executing select query: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    public static void searchReport(Scanner scanner) throws SQLException {
        System.out.println("Enter Student ID to Search ");
        int studentId = Integer.parseInt(scanner.nextLine().trim());
        String query = "SELECT student.ID, student.StudentName, marks.Mark1, marks.Mark2, marks.Mark3, marks.Mark4, marks.Result " +
                "FROM student " +
                "INNER JOIN marks ON student.ID = marks.Student_ID " +
                "WHERE student.ID = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setInt(1, studentId);
            ResultSet resultSet = pre.executeQuery();
            System.out.println();
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
            System.out.println("| ID     | Student Name | Mark 1 | Mark 2 | Mark 3 | Mark 4 | Result |");
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String studentName = resultSet.getString("StudentName");
                int mark1 = resultSet.getInt("Mark1");
                int mark2 = resultSet.getInt("Mark2");
                int mark3 = resultSet.getInt("Mark3");
                int mark4 = resultSet.getInt("Mark4");
                String result = resultSet.getString("Result");
                System.out.printf("| %-6d | %-12s | %-6d | %-6d | %-6d | %-6d | %-6s |\n",
                        id, studentName, mark1, mark2, mark3, mark4, result);
            }
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
        } catch (SQLException e) {
            System.err.println("Error executing SQL query:");
            e.printStackTrace();
        }
    }


    public static void searchReportName(Scanner scanner) throws SQLException {
        System.out.println("Enter Student Name to Search ");
        String name = scanner.nextLine();
        String query = "SELECT student.ID, student.StudentName, marks.Mark1, marks.Mark2, marks.Mark3, marks.Mark4, marks.Result " +
                "FROM student " +
                "INNER JOIN marks ON student.ID = marks.Student_ID " +
                "WHERE student.StudentName LIKE ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setString(1, "%" + name + "%");
            ResultSet resultSet = pre.executeQuery();
            System.out.println();
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
            System.out.println("| ID     | Student Name | Mark 1 | Mark 2 | Mark 3 | Mark 4 | Result |");
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String studentName = resultSet.getString("StudentName");
                int mark1 = resultSet.getInt("Mark1");
                int mark2 = resultSet.getInt("Mark2");
                int mark3 = resultSet.getInt("Mark3");
                int mark4 = resultSet.getInt("Mark4");
                String result = resultSet.getString("Result");
                System.out.printf("| %-6d | %-12s | %-6d | %-6d | %-6d | %-6d | %-6s |\n",
                        id, studentName, mark1, mark2, mark3, mark4, result);
            }
            System.out.println("+--------+--------------+--------+--------+--------+--------+--------+");
        } catch (SQLException e) {
            System.err.println("Error executing SQL query:");
            e.printStackTrace();
        }
    }


    public Connection deleteStudent(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "DELETE FROM student WHERE ID=?";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter the Student ID to Delete ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                pre.setInt(1, studentId);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student Details Deleted Successfully...");
                } else {
                    System.out.println("No Student Found With ID " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }


    public Connection deleteStudentMark(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "DELETE FROM marks WHERE Student_ID=?";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter the Student ID to Delete ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                pre.setInt(1, studentId);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student Details Deleted Successfully...");
                } else {
                    System.out.println("No Student Found With ID " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }

    public Connection deleteAdmin(Scanner scanner) throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            String query = "DELETE FROM admin WHERE ID=?";
            try (PreparedStatement pre = con.prepareStatement(query)) {
                System.out.println("Enter the Admin ID to Delete ");
                int adminId = scanner.nextInt();
                scanner.nextLine();
                pre.setInt(1, adminId);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Admin Details Deleted Successfully...");
                } else {
                    System.out.println("No Admin Found With ID " + adminId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return con;
    }
}