abstract public class Inhabitant extends Thread
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

    public String getInhabitantName()
    {
        return this.name;
    }



    
}
