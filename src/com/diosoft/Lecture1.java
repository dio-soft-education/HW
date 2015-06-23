package com.diosoft;

public class Lecture1 {

	public static void main(String[] args)
	{
		StringBuilder message = new StringBuilder();

		if(args.length > 0)
		{
			message.append("You have passed " + args.length + " arguments" + "\n" + "In particular: ");
			for(int i = 0; i < args.length; i++)
				message.append((i > 0 ? ", " : "") + args[i]);
		}
		else
		{
			message.append("No arguments have been passed");
		}

		System.out.println(message);
	}

}
