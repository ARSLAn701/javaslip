public class AlphabetPrinter implements Runnable {
    
    @Override
    public void run() {
        char currentAlphabet = 'A';
        try {
            while (currentAlphabet <= 'Z') {
                System.out.print(currentAlphabet + " ");
                currentAlphabet++;
                Thread.sleep(2000); // Sleep for 2 seconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AlphabetPrinter printer = new AlphabetPrinter();
        Thread thread = new Thread(printer);
        thread.start();
    }
}


Q2)


  import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetailsForm extends JFrame {
    private JTextField enoField, enameField, designationField, salaryField;
    private JButton saveButton;

    public EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel enoLabel = new JLabel("Employee Number:");
        enoField = new JTextField(20);

        JLabel enameLabel = new JLabel("Employee Name:");
        enameField = new JTextField(20);

        JLabel designationLabel = new JLabel("Designation:");
        designationField = new JTextField(20);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField(20);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveEmployeeDetails();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(enoLabel, constraints);

        constraints.gridx = 1;
        panel.add(enoField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(enameLabel, constraints);

        constraints.gridx = 1;
        panel.add(enameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(designationLabel, constraints);

        constraints.gridx = 1;
        panel.add(designationField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(salaryLabel, constraints);

        constraints.gridx = 1;
        panel.add(salaryField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(saveButton, constraints);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void saveEmployeeDetails() {
        String eno = enoField.getText();
        String ename = enameField.getText();
        String designation = designationField.getText();
        String salary = salaryField.getText();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Establishing a connection to the database (assuming MySQL for this example)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // SQL query to insert employee details into the database
            String sql = "INSERT INTO Employee (ENo, EName, Designation, Salary) VALUES (?, ?, ?, ?)";

            // Creating PreparedStatement object with the SQL query
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, eno);
            pstmt.setString(2, ename);
            pstmt.setString(3, designation);
            pstmt.setString(4, salary);

            // Executing the query to insert employee details
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee details saved successfully!");
                enoField.setText("");
                enameField.setText("");
                designationField.setText("");
                salaryField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save employee details!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Closing PreparedStatement and Connection
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDetailsForm().setVisible(true);
            }
        });
    }
}
