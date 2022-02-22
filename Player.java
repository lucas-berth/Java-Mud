import java.util.Scanner;
public class Player
{
    private String name;
    private Room currentRoom;
    private Exit knownExits;
    
    public Player(String name)
    {
        this.name = name;
        this.currentRoom = null;
        this.knownExits = null;
    }
    
    public void setRoom(Room r)
    {
        this.currentRoom = r;
        
    }
    /*
    
    public void setExits(Exit e)
    {
        this.currentRoom.hasExit();
        //start here 
    }
    */
    
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
                    //update not sure how to call the getRoomInADirection function without an exit.
                    
                    this.currentRoom.removePlayer();
                    this.currentRoom.hasExit(line).getRoomInADirection(line).addPlayer(this);
                    //take the exit - add player to a new room that matches the exit taken 
                    //remove player from old room.
                    //***possibly switch first 2
                    //lastly just do a lookAround
                    
                    this.lookAround();
                    
                    
                    
                    
                    
                    
                    //take that exit
                    //write the code to take this exit and ensure the player ends up 
                    //in the right place.
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