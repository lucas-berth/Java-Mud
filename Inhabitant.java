abstract public class Inhabitant extends Object
{
    protected String name;
    protected Room currentRoom;
    //private ArrayList<Exit> theExits;

    public Inhabitant(String name)
    {
        //super(); this is here invisibly
        this.name = name;
        this.currentRoom = null;
        //this.theExits = new ArrayList<Exit>();
    }

    public void setRoom(Room r)
    {
        this.currentRoom = r;
    }

    public String getName()
    {
        return this.name;
    }

    
    /*
    public void throwMonster(String direction)
    {
        Exit temp;
        Room tempr;
        tempr = currentRoom;
        for(int i = 0; i < tempr.theExits.size(); i++)
        {
            temp = currentRoom.theExits.get(i);
            if(temp.getDirectionStringLeadingAwayFromRoom(tempr).equals(direction))
            {
                temp.travelMonster(direction, currentRoom, this);
                return;
            }
        }
    }
    */

    
}
