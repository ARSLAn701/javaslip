import java.util.*;

public class FriendNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();

        Set<String> friendSet = new HashSet<>();

        // Reading 'N' names of friends
        System.out.println("Enter the names of your friends:");
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            friendSet.add(name);
        }

        // Displaying friends in ascending order
        List<String> sortedFriends = new ArrayList<>(friendSet);
        Collections.sort(sortedFriends);

        System.out.println("\nFriends in ascending order:");
        for (String friend : sortedFriends) {
            System.out.println(friend);
        }

        scanner.close();
    }
}


Q2)


  import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RequestInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Information</title>");
        out.println("</head>");
        out.println("<body>");

        // Client information
        out.println("<h2>Client Information:</h2>");
        out.println("<p><b>IP Address:</b> " + request.getRemoteAddr() + "</p>");
        out.println("<p><b>Browser Type:</b> " + request.getHeader("User-Agent") + "</p>");

        // Server information
        out.println("<h2>Server Information:</h2>");
        out.println("<p><b>Server Name:</b> " + request.getServerName() + "</p>");
        out.println("<p><b>Server Port:</b> " + request.getServerPort() + "</p>");
        out.println("<p><b>Server Software:</b> " + getServletContext().getServerInfo() + "</p>");

        // Servlet information
        out.println("<h2>Servlet Information:</h2>");
        out.println("<p><b>Served by Servlet:</b> " + getServletName() + "</p>");

        // Names of currently loaded servlets
        out.println("<h2>Currently Loaded Servlets:</h2>");
        Enumeration<String> servletNames = getServletContext().getServletNames();
        while (servletNames.hasMoreElements()) {
            String servletName = servletNames.nextElement();
            out.println("<p>" + servletName + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
