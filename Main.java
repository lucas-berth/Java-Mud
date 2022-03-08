import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
	    ArrayList<Room> theRooms = new ArrayList<Room>();
	    ArrayList<Exit> theExits = new ArrayList<Exit>();
	    Main.buildMap(theRooms, theExits);
	    Player thePlayer = new Player("Lucas");
		Monster theRat = new Monster("rat");
	    Room theEntrance = Main.getRoomGivenName("Entrance", theRooms);
	    theEntrance.addPlayer(thePlayer);
		theEntrance.addMonster(theRat);
		theRat.start();
	    thePlayer.play();
        
	}
	
	private static void buildMap(ArrayList<Room> theRooms, ArrayList<Exit> theExits) throws Exception
	{
	    FileInputStream fin = new FileInputStream("map.txt");
        Scanner input = new Scanner(fin);
        String line;
        String currentMode = "No Mode";
        while(input.hasNext())
        {
            line = input.nextLine();
            if(line.equals("ROOMS"))
            {
                currentMode = "ROOMS";
                //System.out.println("Change Mode to ROOMS ");
            }
            else if(line.equals("EXITS"))
            {
                /*
                for(int i = 0; i < theRooms.size(); i++)
                {
                    System.out.println(theRooms.get(i));
                }
                */
                currentMode = "EXITS";
                //System.out.println("Change Mode to EXITS ");
            }
            else
            {
                //line holds the contents of either a ROOM or an EXIT depending on
                //the current mode
                if(currentMode.equals("ROOMS"))
                {
                    //build a room object and add it to a collection of rooms
                    //System.out.println("Build Room: " + line);
                    //Room temp = new Room(line);
                    theRooms.add(new Room(line));
                }
                else if(currentMode.equals("EXITS"))
                {
                    //parse the exit string and build an exit
                    //parsing means to break out the 4 pieces
                    //of info so we can actually build an Exit
                    //object...
                    //System.out.println("Build Exit: " + line);
                    String[] exitParts = Main.parseExit(line);
                    Room dest1 = Main.getRoomGivenName(exitParts[0], theRooms);
                    String dir1 = exitParts[1];
                    Room dest2 = Main.getRoomGivenName(exitParts[2], theRooms);
                    String dir2 = exitParts[3];
                    theExits.add(new Exit(dest1, dir1, dest2, dir2));
                    
                }
            }
        }
        System.out.println("My Map should be built!!!!");
	}
	
	private static Room getRoomGivenName(String roomName, ArrayList<Room> theRooms)
	{
	    Room temp;
	    for(int i = 0; i < theRooms.size(); i++)
	    {
	        temp = theRooms.get(i);
	        if(temp.getName().equals(roomName))
	        {
	            return temp;
	        }
	    }
	    throw new RuntimeException("Room with name: " + roomName + " not found!!!!");
	}
	
	private static String[] parseExit(String exitString)
	{
	    //example: "Laser Cutter,north,Lobby,south"
	    //System.out.println("About to parse: " + exitString);
	    String[] exitParts = new String[4];
	    //fills exitParts up with the 4 parts of the Exit
	    
	    String currentPart = "";
	    int exitPartsPos = 0;
	    for(int i = 0; i < exitString.length(); i++)
	    {
	        if(exitString.charAt(i) == ',')
	        {
	            exitParts[exitPartsPos] = currentPart;
	            currentPart = "";
	            exitPartsPos++;
	        }
	        else
	        {
	            currentPart = currentPart + exitString.charAt(i);
	        }
	    }
	    exitParts[exitPartsPos] = currentPart;
	    return exitParts;
	}
}