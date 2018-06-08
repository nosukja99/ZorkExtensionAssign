package company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Room withCharcter = user.makeCharacter();
        int withChrRoomNum = withCharcter.getRoomNumber();//room number with character

        String choice;
        double dMoney=0;
        double personalTotal = 0;

        String totalToString;
        ArrayList<Integer> visitedRoom = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");

        //in the foyer at the start
        Foyer foyer= new Foyer();

        System.out.println(foyer.displayContent());

        dMoney = foyer.amountOfMoney();
        if(foyer.getRoomNumber() == withChrRoomNum)
        {
            System.out.println("In this room there is a character which takes all personal total");
            personalTotal=0;
        }
        else {
            personalTotal = personalTotal + dMoney;
        }
        totalToString = df.format(personalTotal);

        //System.out.println("In this room you can get $"+ totalToString);
        System.out.println("Current your money total is "+ totalToString);
        if(!visitedRoom.contains(foyer.getRoomNumber())) {
            visitedRoom.add(foyer.getRoomNumber());
        }
        System.out.println("You visited "+visitedRoom.size()+" room.");
        System.out.println(foyer.displayExitMessage());


        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();

        if(foyer.changeStringToChar(choice) != 'q') {
            String choice1;
            //form foyer to another room
            char direction = foyer.changeStringToChar(choice);
            if (direction != '0') {
                Room newRoom = user.move(foyer, direction);

                System.out.println(newRoom.displayContent());
                //System.out.println("Cuttenrt room number is; "+newRoom.getRoomNumber());
                dMoney=newRoom.amountOfMoney();
                //display current room's money
                //System.out.println("In this room you can get $"+ df.format(dMoney));
                //check the visited room list
                if(visitedRoom.contains(newRoom.getRoomNumber()))
                {
                    //System.out.println("You already visited this room and took the money.");
                    personalTotal=personalTotal;
                }
                else
                {
                    personalTotal = personalTotal + dMoney;
                }

                if(newRoom.getRoomNumber()== withChrRoomNum)
                {
                    System.out.println("In this room there is a character which takes all personal total");
                    personalTotal=0;
                }

                totalToString=df.format(personalTotal);
                System.out.println("Current your money total is $"+ totalToString);
                if(!visitedRoom.contains(newRoom.getRoomNumber())) {
                    visitedRoom.add(newRoom.getRoomNumber());
                }
                System.out.println("You visited "+visitedRoom.size()+" room.");
                System.out.println(newRoom.displayExitMessage());
                choice1 = scanner.next();
                while (newRoom.changeStringToChar(choice1) != 'q') {
                    char newDirection = newRoom.changeStringToChar(choice1);

                    if (newDirection=='0') {
                        System.out.println("That is not one of the valid options.\nPlease enter a valid option next time.");
                        break;
                    }
                    newRoom = user.move(newRoom, newDirection);

                    System.out.println(newRoom.displayContent());
                    //System.out.println("Cuttenrt room number is; "+newRoom.getRoomNumber());
                    dMoney=newRoom.amountOfMoney();
                    //System.out.println("In this room you can get $"+ df.format(dMoney));
                    if(visitedRoom.contains(newRoom.getRoomNumber()))
                    {
                        //System.out.println("You already visited this room and took the money.");
                        personalTotal=personalTotal;
                    }
                    else
                    {
                        personalTotal = personalTotal + dMoney;
                    }

                    if(newRoom.getRoomNumber()== withChrRoomNum)
                    {
                        System.out.println("In this room there is a character which takes all personal total");
                        personalTotal=0;
                    }

                    totalToString=df.format(personalTotal);
                    System.out.println("Current your money total is $"+ totalToString);

                    if(!visitedRoom.contains(newRoom.getRoomNumber())) {
                        visitedRoom.add(newRoom.getRoomNumber());
                    }

                    System.out.println("You visited "+visitedRoom.size()+" room.");
                    System.out.println(newRoom.displayExitMessage());

                    choice1 = scanner.next();
                }

                    String displayVisitedRooms = printOutRoonNum(visitedRoom);
                    String displaySeenContents = printOutContents(visitedRoom);
                    System.out.println("You have visited these rooms: "+displayVisitedRooms+".\nYou have seen these items: "+displaySeenContents+
                            ".\nAnd the total money you got is: $"+totalToString);
                    System.exit(-1);
            } else {
                System.out.println("That is not one of the valid options.\nPlease enter a valid option next time.");
                System.exit(-1);
            }
        }
            String displayVisitedRooms = printOutRoonNum(visitedRoom);
            String displaySeenContents = printOutContents(visitedRoom);
            System.out.println("You have visited these rooms: "+displayVisitedRooms+".\nYou have seen these items: "+displaySeenContents+
                    ".\nAnd the total money you got is: $"+totalToString);
    }

    public static String printOutRoonNum(ArrayList<Integer> visitedRoom)
    {
        String visitedRooms = "";
        for(int i=0; i<visitedRoom.size();i++ )
        {
            visitedRooms = visitedRooms+"  "+visitedRoom.get(i).toString();
        }
        return visitedRooms;
    }
    //with room number to return contents ??????

    public static String printOutContents(ArrayList<Integer> visitedRoom)
    {
        String ContentsSeen = "";
        for(int i=0; i<visitedRoom.size();i++ )
        {
            User user = new User();
            ContentsSeen= ContentsSeen+ "   "+user.returnRoomWithNum(i+1).getContents();
        }
        return ContentsSeen;
    }
}
