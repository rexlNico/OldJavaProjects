package de.rexlNico.Mafia.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Mafia {

	public static void createMafia(Player p, String mafianame, String mafiakürzel){
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list.add(p.getUniqueId().toString());
		Var.cfgusers.set(p.getUniqueId().toString(), mafianame);
		Var.cfgmafia.set(mafianame+".kürzel", mafiakürzel);
		Var.cfgmafia.set(mafianame+".boss", p.getUniqueId().toString());
		Var.cfgmafia.set(mafianame+".rgb", "20/20/20");
		Var.cfgmafia.set(mafianame+".users", list);
		Var.cfgmafia.set(mafianame+".mafiosis", list2);
		try {
			Var.cfgmafia.save(Var.mafia);
			Var.cfgusers.save(Var.users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean IsInAMafia(Player p){
		if(Var.cfgusers.contains(p.getUniqueId().toString())){
			return true;
		}
		return false;
	}
	public static void JoinMafia(String mafianame, Player p){
		List<String> list = Var.cfgmafia.getStringList(mafianame+".users");
		list.add(p.getUniqueId().toString());
		Var.cfgmafia.set(mafianame+".users", list);
		try {
			Var.cfgmafia.save(Var.mafia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteMavia(Player p, String mafianame){
		
	}
	public static boolean isMafiaBoss(String mafianame, Player p){
		if(Var.cfgmafia.getString(mafianame+".boss", p.getUniqueId().toString()) == p.getUniqueId().toString()) return true;
		return false;
	}
	public static boolean isMafiaNameIsUsed(String mafianame){
		if(Var.cfgmafia.contains(mafianame)){
			return true;
		}
		return false;
	}
	public static boolean isMafiaKürzelUsed(String kürzel){
		if(Var.cfgmafia.contains(kürzel)) return true;
		
		return false;
	}
	
}
