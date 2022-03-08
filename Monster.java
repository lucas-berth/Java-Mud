public class Monster extends Inhabitant
{
    public Monster(String name)
    {
        super(name);
    }
    //we do not need a getName method because it is in inhabitant

    public void run()
    {
        while(true)
        {
            try
            {
                sleep(2000);
                System.out.println(this.name = " says woof! lol");
            }
            catch(Exception e)
            {
                System.out.println("Problem with sleep");
            }
            
        }
    }
}
