import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
public class Player extends Inhabitant
{
    public Player(String name)
    {
        super(name); //must be the first line in the constructor if we choose to use super
       
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
                /*
                if(currentRoom.hasExit(where) == true)
                {
                    Monster temp = currentRoom.checkForMonster(who);
                    //System.out.println(temp); test to see if a monster is getting passed
                    if(temp != null)
                    {
                        currentRoom.throwMonster(where);
                        this.lookAround();
                        ;
                    }
                    else
                    {
                        System.out.println("No Monsters Here by that name!!!!");
                    }
                }
                */

                //Litmans answer
                ///*
                try
                {
                    Monster theMonster = this.currentRoom.getMonsterGivenName(who);
                    if(this.currentRoom.hasExit(where))
                    {
                        this.currentRoom.takeExit(where, theMonster);
                        System.out.println(who + " has been thrown to the: " + where);
                    }
                    
                    else
                    {
                        System.err.println(who + " bounces off the " + where + "wall");
                    }
                }
                catch(Exception e)
                {
                    System.err.println(e);
                    this.lookAround();
                }
               // */
                
                //this is where the program is left off, I will update with Litman's code once its fixed up and update 
                //friday is when we do multithreading. 
                
                
               
                
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
                    this.currentRoom.takeExit(line, this);
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