package Campions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Kit {

	private String name;
	private String description;
	private Material symbol;
	private List<ItemStack> startItems;
	
	public  ItemStack getMenuItem(){
		ItemStack item = new ItemStack(symbol);
		ItemMeta imeta = item.getItemMeta();
		imeta.setDisplayName(this.name);
		String[] split = description.split("//");
		ArrayList<String> lore = new ArrayList<>();
		for(String lorePart : split){
			lore.add(lorePart);
		}
		imeta.setLore(lore);
		item.setItemMeta(imeta);
		
		return item;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Material getSymbol() {
		return symbol;
	}
	public void setSymbol(Material symbol) {
		this.symbol = symbol;
	}
	public List<ItemStack> getStartItems() {
		return startItems;
	}
	public void setStartItems(List<ItemStack> startItems) {
		this.startItems = startItems;
	}
	public Kit(String name, String description, Material symbol, List<ItemStack> startItems) {
		super();
		this.name = name;
		this.description = description;
		this.symbol = symbol;
		this.startItems = startItems;
	}
	
	
	
}
