import java.util.*;

public class IntegerCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        Set<Integer> integerSet = new TreeSet<>();

        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            integerSet.add(num);
        }

        // Displaying integers in sorted order
        System.out.println("\nIntegers in sorted order:");
        for (int num : integerSet) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        // Searching for a particular element
        System.out.print("Enter the integer to search: ");
        int searchNum = scanner.nextInt();
        if (integerSet.contains(searchNum)) {
            System.out.println("Integer " + searchNum + " found in the collection.");
        } else {
            System.out.println("Integer " + searchNum + " not found in the collection.");
        }

        scanner.close();
    }
}



Q2)



  import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficSignalSimulator extends JFrame {
    private JLabel signalLabel;

    private static final Color RED_COLOR = Color.RED;
    private static final Color YELLOW_COLOR = Color.YELLOW;
    private static final Color GREEN_COLOR = Color.GREEN;

    private volatile boolean running = true;

    public TrafficSignalSimulator() {
        setTitle("Traffic Signal Simulator");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signalLabel = new JLabel("Red Signal", SwingConstants.CENTER);
        signalLabel.setFont(new Font("Arial", Font.BOLD, 24));
        signalLabel.setOpaque(true);
        signalLabel.setBackground(RED_COLOR);
        add(signalLabel);

        Thread thread = new Thread(new SignalTask());
        thread.start();
    }

    private class SignalTask implements Runnable {
        public void run() {
            try {
                while (running) {
                    signalLabel.setBackground(RED_COLOR);
                    signalLabel.setText("Red Signal");
                    Thread.sleep(5000); // Red signal for 5 seconds

                    signalLabel.setBackground(YELLOW_COLOR);
                    signalLabel.setText("Yellow Signal");
                    Thread.sleep(2000); // Yellow signal for 2 seconds

                    signalLabel.setBackground(GREEN_COLOR);
                    signalLabel.setText("Green Signal");
                    Thread.sleep(5000); // Green signal for 5 seconds
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficSignalSimulator().setVisible(true);
            }
        });
    }
}
