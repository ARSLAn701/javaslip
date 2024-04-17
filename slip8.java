class TextPrinterThread extends Thread {
    private String text;
    private int times;

    public TextPrinterThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
}

public class MultiThreadTextPrinting {
    public static void main(String[] args) {
        // Create and start threads
        TextPrinterThread thread1 = new TextPrinterThread("COVID19", 10);
        TextPrinterThread thread2 = new TextPrinterThread("LOCKDOWN2020", 20);
        TextPrinterThread thread3 = new TextPrinterThread("VACCINATED2021", 30);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}



Q2)


  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Checker</title>
</head>
<body>
    <% 
        int number = Integer.parseInt(request.getParameter("number"));
        boolean isPrime = true;
        
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        String resultMessage;
        if (isPrime) {
            resultMessage = "Prime";
        } else {
            resultMessage = "Not Prime";
        }
    %>
    
    <h2 style="color: red;">Result: <%= resultMessage %></h2>
</body>
</html>
