import java.util.Scanner;
import java.util.Random;

public class WorkerBee extends Thread
{
    private String name;

    public WorkerBee(String name)
    {
        this.name = name;
    }
    public void run()
    {
       // Scanner input = new Scanner(System.in);
        Random r = new Random();
		while(true)
		{
			//System.out.print("(" + this.name + ") Enter a number: ");
			//int number = Integer.parseInt(input.nextLine());
            int number = r.nextInt() % 200000;
			for(int i =0; i < number; i++)
			{
				System.out.println("(" + this.name + ") - Count: " + i );
			}
		}
    }
}
