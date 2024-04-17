import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeDetails {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployeeDetails <EmployeeID>");
            return;
        }

        int employeeID = Integer.parseInt(args[0]);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Establishing a connection to the database (assuming MySQL for this example)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // SQL query to delete employee details based on employee ID
            String sql = "DELETE FROM Employee WHERE ENo = ?";

            // Creating PreparedStatement object with the SQL query
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeID);

            // Executing the query to delete employee details
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully for employee ID: " + employeeID);
            } else {
                System.out.println("No employee found with ID: " + employeeID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing PreparedStatement and Connection
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



Q2)



  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Calculate Sum of First and Last Digit</h2>
    <form action="calculateSum.jsp" method="post">
        Enter a number: <input type="number" name="number" required>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>

  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum of First and Last Digit</title>
</head>
<body>
    <%
        int number = Integer.parseInt(request.getParameter("number"));
        int lastDigit = number % 10;

        // Loop to find the first digit
        while (number >= 10) {
            number /= 10;
        }
        int firstDigit = number;

        int sum = firstDigit + lastDigit;
    %>
    
    <h2 style="color: red; font-size: 18px;">Sum of first and last digit: <%= sum %></h2>
</body>
</html>
