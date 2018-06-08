package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Library extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
    double money;
    /**
     * constructor with no parameter
     */
    public Library()
    {
        roomNumber = 3;
        contents.add("spiders");
        direction.put('e',2);
        direction.put('n',5);

    }


    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public HashMap getExit() {

        return direction;
    }


    @Override
    public String displayContent() {

        String display = "You are standing in a library.\nYou see "+ contents.get(0);
        return display;
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the east, (2) exit to the north or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='e'; break;
            case "2": direction='n'; break;
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
        return contents.get(0);
    }

}
