import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextScroll extends JFrame {
    private JLabel textLabel;
    private String text;
    private volatile boolean running = true;

    public TextScroll(String text) {
        setTitle("Text Scroll");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.text = text;
        textLabel = new JLabel(text);

        add(textLabel, BorderLayout.CENTER);

        Thread thread = new Thread(new ScrollTask());
        thread.start();
    }

    private class ScrollTask implements Runnable {
        public void run() {
            try {
                while (running) {
                    char lastChar = text.charAt(text.length() - 1);
                    String newText = lastChar + text.substring(0, text.length() - 1);
                    textLabel.setText(newText);
                    Thread.sleep(100); // Adjust speed here (lower value -> faster scrolling)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextScroll("Scrolling text continuously...").setVisible(true);
            }
        });
    }
}


Q2)

  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Status</title>
</head>
<body>
    <% 
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && username.equals(password)) {
            response.sendRedirect("Login.html");
        } else {
            response.sendRedirect("Error.html");
        }
    %>
</body>
</html>
