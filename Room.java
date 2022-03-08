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
        //Monster test1 = new Monster("test1");
        this.theMonsters = new ArrayList<Monster>();
        //this.theMonsters.add(test1);
        this.currentPlayer = null;
        
    }
    
    public void display()
    {
        System.out.println("Room: " + this.name);
        System.out.println("Also Here: ");
        String alsoHereOutput = "";
        if(this.currentPlayer != null)
        {
            alsoHereOutput = this.currentPlayer.getInhabitantName();
        }

        //what monsters are in this room???
        for(int i = 0; i < this.theMonsters.size(); i++)
        {
            if(alsoHereOutput.length() > 0)
            {
                alsoHereOutput = alsoHereOutput + ", " + this.theMonsters.get(i).getInhabitantName();
            }
            else
            {
                alsoHereOutput = this.theMonsters.get(i).getInhabitantName();
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
    
    //another version of takeExit
    /*
    public void throwMonster(String direction)
    {
        Exit temp;
        Monster mtemp;
       
        
        for(int i = 0; i < this.theExits.size(); i++)
        {
            temp = this.theExits.get(i);
            if(temp.getDirectionStringLeadingAwayFromRoom(this).equals(direction))
            {
                for(int k = 0; k < this.theMonsters.size(); k++)
                {
                    mtemp = this.theMonsters.get(k);
                    temp.travelInDirection(direction, this, mtemp);
                    return;
                }
            }
        }
    }

    */
    //Litmans answer
    public void takeExit(String direction, Inhabitant theInhabitant)
    {
        Exit temp;
        for(int i = 0; i < this.theExits.size(); i++)
        {
            temp = this.theExits.get(i);
            if(temp.getDirectionStringLeadingAwayFromRoom(this).equals(direction))
            {
                temp.travelInDirection(direction, this, theInhabitant);
                return;
            }
        }
    }

    public Monster checkForMonster(String name)
    {
        if(this.theMonsters.size() != 0)
        {
            Monster temp;
            for(int i = 0; i < this.theMonsters.size(); i++)
            {
                temp = this.theMonsters.get(i);
                if(temp.getName().equals(name))
                {
                    return temp;
                }
            }
        }
        return null;
    }

    //Litman's answer which is very similar to checkForMonster
    public Monster getMonsterGivenName(String name) throws Exception
    {
        for(int i = 0; i < this.theMonsters.size(); i++)
        {
            Monster temp = this.theMonsters.get(i);
            if(temp.getName().equals(name))
            {
                return temp;
            }
        }
        //If I am here, I did not find a monster with that name!!!
        throw new Exception("Monster with " + name + " not found!!!");
    }




    //this should be what we need to do, but in not sure yet how to get the monster out of the array list. 
    //update: got this working by running the same loop as usef for the arraylist with exits 
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

    //same as Litman's answer 
    void removeMonster(Monster m)
    {
        this.theMonsters.remove(m);
    }
    //note this was clearning my array now it is just removing the monster from the array

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