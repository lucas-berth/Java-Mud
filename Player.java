import java.util.Scanner;
public class Player extends Inhabitant
{
    public Player(String name)
    {
        super(name); //must be the first line in the constructor if we choose to use super
       
    }

    
    
    public void setRoom(Room r)
    {
        this.currentRoom = r;
        
    }
    
    
    public void play()
    {
        //show the room we are currently in when we start to play
        this.lookAround();
        
        Scanner input = new Scanner(System.in);
        String line;
        while(true)
        {
            System.out.print("What would you like to do? > ");
            line = input.nextLine();
            if(line.equals("look"))
            {
                this.lookAround();
            }
            else if(line.equals("throw"))
            {
                System.out.println("Who do you want to throw? ");
                String who = input.nextLine();
                System.out.println("Where do you want to throw " + who + "? ");
                String where = input.nextLine();
                System.out.println("About to throw..." + who + " through the exit to the: " + where + "!!!");
                //start here for HW 
                


            }

            else if(line.equals("exit"))
            {
                System.out.println("Goodbye!!!");
                return;
                
            }
            else
            {
                //must be trying to do movement
                //so line holds something like "north"
                if(this.currentRoom.hasExit(line))
                {
                    this.currentRoom.takeExit(line);
                    this.lookAround();
                    
                }
                else
                {
                    System.out.println("Exit Not Found");
                    this.lookAround();
                }
            }
            
        }
       
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void lookAround()
    {
        this.currentRoom.display();
    }
    
    
}