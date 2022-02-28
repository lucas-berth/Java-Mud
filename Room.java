import java.util.ArrayList;

public class Room
{
    private ArrayList<Exit> theExits;
    private String name;
    private Player currentPlayer;
    private ArrayList<Monster> theMonsters;
    
    public Room(String name)
    {
        this.name = name;
        this.theExits = new ArrayList<Exit>();
        this.theMonsters = new ArrayList<Monster>();
        this.currentPlayer = null;
        
    }
    
    public void display()
    {
        System.out.println("Room: " + this.name);
        System.out.println("Also Here: ");
        String alsoHereOutput = "";
        if(this.currentPlayer != null)
        {
            alsoHereOutput = this.currentPlayer.getName();
        }

        //what monsters are in this room???
        for(int i = 0; i < this.theMonsters.size(); i++)
        {
            if(alsoHereOutput.length() > 0)
            {
                alsoHereOutput = alsoHereOutput + ", " + this.theMonsters.get(i).getName();
            }
            else
            {
                alsoHereOutput = this.theMonsters.get(i).getName();
            }
        }


        System.out.println(alsoHereOutput);
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
        Exit temp;
        for(int i = 0; i < this.theExits.size(); i++)
        {
            temp = this.theExits.get(i);
            if(temp.getDirectionStringLeadingAwayFromRoom(this).equals(direction))
            {
                temp.travelInDirection(direction, this, this.currentPlayer);
                return;
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

    void addMonster(Monster m)
    {
        this.theMonsters.add(m);
        m.setRoom(this);
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