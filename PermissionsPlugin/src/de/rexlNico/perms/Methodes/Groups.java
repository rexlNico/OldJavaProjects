package de.rexlNico.perms.Methodes;

import java.util.ArrayList;

public class Groups {

	public static ArrayList<String> list = new ArrayList<>();
	public static String admin = "admin",
			dev = "dev",
			builder = "builder",
			mod = "mod",
			supp = "supp",
			youtuber = "youtuber",
			premium = "premium",
			spieler = "spieler";
			
	public static void toList(){
		list.add(admin);
		list.add(dev);		
		list.add(builder);
		list.add(mod);
		list.add(supp);
		list.add(youtuber);
		list.add(premium);
		list.add(spieler);
	}
	
}
