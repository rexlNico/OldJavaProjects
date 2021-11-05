package Campions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitManager implements Listener{
	
	private ArrayList<Kit> kits;
	private static HashMap<Player, Kit> kitConn;


	public KitManager(){
		kits = new ArrayList<>();
		kitConn = new HashMap<>();
		
		//Kits registrieren
		List<ItemStack> itemVayne = new ArrayList<>();
		itemVayne.add(new ItemStack(Material.GOLD_INGOT));
		itemVayne.add(new ItemStack(Material.IRON_INGOT));
		itemVayne.add(new ItemStack(Material.COAL));
		itemVayne.add(new ItemStack(Material.DIAMOND));
		
		List<ItemStack> itemTwitch = new ArrayList<>();
		itemTwitch.add(new ItemStack(Material.STICK));
		itemTwitch.add(new ItemStack(Material.BOWL));
		itemTwitch.add(new ItemStack(Material.FEATHER));
		itemTwitch.add(new ItemStack(Material.SEEDS));
		
		kits.add(new Vayne("§cVayne", "§6The night Hunter", Material.ARROW, itemVayne));
		kits.add(new Twitch("§cTwitch", "§6The Plague rat", Material.ROTTEN_FLESH, itemTwitch));
		
	}
	
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.LEFT_CLICK_AIR) ||
				e.getAction().equals(Action.RIGHT_CLICK_AIR) ||
				e.getAction().equals(Action.LEFT_CLICK_BLOCK) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) ){
				if(p.getItemInHand().getType().equals(Material.CHEST)){
					if(p.getItemInHand().getItemMeta().getDisplayName().equals("§bChampion Wahl")){
						openKitGUI(p);
				}
			}
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equals("§bChampion Wahl")){
			for(Kit kit: kits){
				String name = kit.getName();
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals(name)){
					kitConn.put(p, kit);
					p.closeInventory();
					break;
				}
			}
			e.setCancelled(true);
			p.closeInventory();
		}
	}
	
	
	public void openKitGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 9*3, "§bChampion Wahl");
		for(int i = 0; i < kits.size(); i++){
			inv.setItem(i, kits.get(i).getMenuItem());
		}
		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1, 1);
	}
	public ArrayList<Kit> getKits(){
		return this.kits;	
	}
	public static Kit getPlayerKit(Player p){
		return kitConn.containsKey(p) ? kitConn.get(p) : null;
	}

}
