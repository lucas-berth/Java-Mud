abstract public class Inhabitant extends Object
{
    protected String name;
    protected Room currentRoom;

    public Inhabitant(String name)
    {
        //super(); this is here invisibly
        this.name = name;
        this.currentRoom = null;
        
    }

    public void setRoom(Room r)
    {
        this.currentRoom = r;
    }

    public String getName()
    {
        return this.name;
    }

    
}
