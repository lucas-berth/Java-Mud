import java.util.ArrayList;

public class Room
{
    private ArrayList<Exit> theExits;
    private String name;
    private Player currentPlayer;
    
    public Room(String name)
    {
        this.name = name;
        this.theExits = new ArrayList<Exit>();
        this.currentPlayer = null;
    }
    
    public void display()
    {
        System.out.println("Room: " + this.name);
        System.out.println("Also Here: ");
        if(this.currentPlayer != null)
        {
            System.out.println(this.currentPlayer.getName());
        }
        else
        {
            System.out.println("");
        }
        
        System.out.println("Obvious Exits: " );
        String exitDirections = "";
        for(int i = 0; i < this.theExits.size(); i++)
        {
            //build a string that is all the exits leading out of this room 
            exitDirections = exitDirections + 
                this.theExits.get(i).getDirectionStringLeadingAwayFromRoom(this) + " ";
        }
        System.out.println(exitDirections);
    }
    
    public void takeExit(String direction)
    {
        for(int i = 0; i < this.theExits.size(); i++)
        {
            if(this.theExits.get(i).getDirectionStringLeadingAwayFromRoom(this).equals(direction))
            {
                //not sure what the put here but pretty sure we have to use it 
                //addPlayer(currentPlayer);
                //currentPlayer.setRoom(this);
                //addPlayer(currentPlayer);
                
                this.removePlayer();
                currentPlayer.setRoom(getRoomInADirection(direction));
                addPlayer(currentPlayer);

                //theExits.get(i).getRoomInADirection(direction).addPlayer(currentPlayer);
            }
        }
    }
    
    public boolean hasExit(String direction)
    {
        for(int i = 0; i < this.theExits.size(); i++)
        {
            if(this.theExits.get(i).getDirectionStringLeadingAwayFromRoom(this).equals(direction))
            {
                return true;
            }
        }
        return false;
    }
    
    void addPlayer(Player p)
    {
        this.currentPlayer = p;
        p.setRoom(this);
    }
    
    public Player getPlayer()
    {
        return this.currentPlayer;
    }
    
    public void removePlayer()
    {
        this.currentPlayer = null;
    }
    
    public void addExit(Exit e)
    {
        this.theExits.add(e);
    }
    
    public String getName()
    {
        return this.name;
    }
}