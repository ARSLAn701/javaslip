import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase database = new EmployeeDatabase();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    database.insertEmployee();
                    break;
                case 2:
                    database.updateEmployee();
                    break;
                case 3:
                    database.displayEmployees();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

class EmployeeDatabase {
    private int[] ENo = new int[100];
    private String[] EName = new String[100];
    private double[] Salary = new double[100];
    private int currentIndex = 0;

    public void insertEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Number: ");
        ENo[currentIndex] = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        scanner.nextLine(); // Consume newline character
        EName[currentIndex] = scanner.nextLine();
        System.out.print("Enter Salary: ");
        Salary[currentIndex] = scanner.nextDouble();
        currentIndex++;
    }

    public void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Number to update: ");
        int searchENo = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (ENo[i] == searchENo) {
                System.out.print("Enter new Salary: ");
                Salary[i] = scanner.nextDouble();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        System.out.println("Employee Details:");
        System.out.println("ENo\tEName\tSalary");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(ENo[i] + "\t" + EName[i] + "\t" + Salary[i]);
        }
    }
}



Q2)



  <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h2>Welcome to the Greeting Page</h2>
    <form action="greet.jsp" method="post">
        Enter your name: <input type="text" name="username">
        <input type="submit" value="Greet">
    </form>
</body>
</html>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    String username = request.getParameter("username");
    Date currentTime = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("HH");
    int hour = Integer.parseInt(sdf.format(currentTime));

    String greeting;
    if (hour < 12) {
        greeting = "Good morning";
    } else if (hour < 18) {
        greeting = "Good afternoon";
    } else {
        greeting = "Good evening";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
    <h2><%= greeting %>, <%= username %>!</h2>
    <p>It's currently <%= currentTime %></p>
</body>
</html>
