package oral;
import java.util.*;

public class StudentNames {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of Subject :");
        int n=sc.nextInt();
        System.out.println("Enter the "+n +"subjects names:");
        LinkedList<String> ll=new LinkedList<>();
        for (int i=0;i<=n;i++){
            String name=sc.nextLine();
            ll.add(name);
        }
        System.out.println("Details :");
        Iterator<String> it=ll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}



Q2)


  package oral;
import java.util.concurrent.*;
import java.util.*;
class producer implements Runnable{
    private BlockingQueue<Integer> queue;
    public producer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run(){
        try {
            for (int i=1;i<=10;i++){
                queue.put(i);
                System.out.println("producer produced :"+i);
                Thread.sleep(2000);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
class consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    public consumer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        try{
            for (int i=1;i<=10;i++){
                int val=queue.take();
                System.out.println("consumer consumed :"+val);
                Thread.sleep(3000);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);
        producer p=new producer(queue);
        consumer c=new consumer(queue);

        Thread t1=new Thread(p);
        Thread t2=new Thread(c);

        t1.start();
        t2.start();
    }
}
