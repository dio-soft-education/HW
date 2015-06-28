package com.diosoft.lecture1;

public class Main {
    public static void main(String[] args)
    {
        StringBuilder message = new StringBuilder();

        if(args.length > 0)
        {
            message.append("You have passed ")
                    .append(args.length)
                    .append(" arguments")
                    .append("\n")
                    .append("In particular: ");
            for(int i = 0; i < args.length; i++)
                message.append((i > 0 ? ", " : "")).append(args[i]);
        }
        else
        {
            message.append("No arguments have been passed");
        }

        System.out.println(message);
    }
}
