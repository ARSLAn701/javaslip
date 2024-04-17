package oral;
import java.util.*;
class printer implements Runnable{
    private String str;
    public printer(String str){
        this.str=str;
    }
public void run(){
    try{
        for(int i=0;i<=str.length();i++){
            char ch=str.charAt(i);
            if(isVowel(ch)){
                System.out.println(ch);
                Thread.sleep(2000);
            }
        }
    }catch (Exception e){
        System.out.println(e);
    }
}
private boolean isVowel(char ch){
        return ch=='A'||ch=='a'||ch=='E'||ch=='e'||ch=='I'||ch=='i'||ch=='o'||ch=='O'||ch=='U'||ch=='u';
}
}

public class VowelPrinter {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        String name=sc.nextLine();

        printer p=new printer(name);
        Thread t=new Thread(p);
        t.start();
    }
}


Q2)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StudentNames {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No student names provided.");
            return;
        }

        ArrayList<String> studentList = new ArrayList<>();

        // Accepting student names from command line arguments
        for (String arg : args) {
            studentList.add(arg);
        }

        // Displaying student names using Iterator
        System.out.println("Student names using Iterator:");
        displayNamesWithIterator(studentList);

        // Displaying student names using ListIterator
        System.out.println("\nStudent names using ListIterator:");
        displayNamesWithListIterator(studentList);
    }

    private static void displayNamesWithIterator(ArrayList<String> studentList) {
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void displayNamesWithListIterator(ArrayList<String> studentList) {
        ListIterator<String> listIterator = studentList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
