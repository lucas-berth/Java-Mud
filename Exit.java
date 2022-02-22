public class Exit
{
    private Room destination1;
    private Room destination2;
    private String directionLeadingToDest1;
    private String directionLeadingToDest2;
    
    public Exit(Room destination1, String directionLeadingToDest1, 
                Room destination2, String directionLeadingToDest2)
    
    {
        this.destination1 = destination1;
        this.destination2 = destination2;
        this.directionLeadingToDest1 = directionLeadingToDest1;
        this.directionLeadingToDest2 = directionLeadingToDest2;
        this.destination1.addExit(this);
        this.destination2.addExit(this);
    }

    public Room getRoomInADirection(String direction)
    {
        //this assumes that direction is a legal direction for this room 
        if(this.directionLeadingToDest2.equals(direction))
        {
            return this.destination2;
        }
        else if(this.directionLeadingToDest1.equals(direction))
        {
            return this.destination1;
        }
        else
        {
            throw new RuntimeException("Room in that direction not found!!!");
        }
    }
    
    public String getDirectionStringLeadingAwayFromRoom(Room r)
    {
        if(this.destination1 == r)
        {
            return this.directionLeadingToDest2;
        }
        else
        {
            return this.directionLeadingToDest1;
        }
    }
    
    
}