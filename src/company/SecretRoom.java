package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SecretRoom extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNum;
    double money;

    /**
     * constructor with no parameter
     */
    public SecretRoom()
    {
        roomNum = 8;
        contents.add("piles of gold");
        direction.put('w', 6);
    }

    @Override
    public int getRoomNumber() {
        return roomNum;
    }

    public HashMap getExit()
    {
        return direction;
    }

    @Override
    public String displayContent() {
        return "You are standing in the secret room.\nYou see "+ contents.get (0);
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction ='0';
        switch(s)
        {
            case "1": direction='w'; break;
            case "Q": direction='q'; break;
            case "q": direction='q'; break;
        }
        return direction;
    }

    @Override
    public double amountOfMoney() {
        Random random = new Random();
        double min =0;
        double max =1000;
        money = 0 + (1000 -0)* random.nextDouble();
        return money;
    }

    @Override
    public String getContents() {
        return contents.get (0);
    }
}
