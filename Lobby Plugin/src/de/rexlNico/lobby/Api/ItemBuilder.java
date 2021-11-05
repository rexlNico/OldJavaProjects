		  package de.rexlNico.lobby.Api;
 import java.lang.reflect.Field;

 import org.bukkit.Color;
 import org.bukkit.Material;
 import org.bukkit.enchantments.Enchantment;
 import org.bukkit.entity.EntityType;
 import org.bukkit.inventory.ItemFlag;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.BookMeta;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.inventory.meta.LeatherArmorMeta;
 import org.bukkit.inventory.meta.PotionMeta;
 import org.bukkit.inventory.meta.SkullMeta;
 import org.bukkit.potion.PotionEffectType;

 
 import com.mojang.authlib.GameProfile;
 import com.mojang.authlib.properties.Property;
 
 public class ItemBuilder
 {
   private ItemStack item;
   
   public ItemBuilder(Material material, int amount)
   {
/*  26 */     this.item = new ItemStack(material, amount);
   }
   
   public ItemBuilder(Material material, int amount, int data) {
/*  30 */     this.item = new ItemStack(material, amount, (short)data);
   }
   
   public ItemBuilder(ItemStack item) {
/*  34 */     this.item = item;
   }
   
   public ItemBuilder setData(int data) {
/*  38 */     this.item.setDurability((short)data);
/*  39 */     return this;
   }
   
   public ItemBuilder setMaterial(Material m) {
/*  43 */     this.item.setType(m);
/*  44 */     return this;
   }
   
   public ItemBuilder setAmount(int amount) {
/*  48 */     this.item.setAmount(amount);
/*  49 */     return this;
   }
   
   public ItemBuilder setName(String name) {
/*  53 */     ItemMeta m = this.item.getItemMeta();
/*  54 */     m.setDisplayName(name);
/*  55 */     this.item.setItemMeta(m);
/*  56 */     return this;
   }
   
   public ItemBuilder setLore(String... lore) {
/*  60 */     ItemMeta m = this.item.getItemMeta();
/*  61 */     m.setLore(java.util.Arrays.asList(lore));
/*  62 */     this.item.setItemMeta(m);
/*  63 */     return this;
   }
   
   public ItemBuilder enchant(Enchantment ench, int lvl) {
/*  67 */     this.item.addUnsafeEnchantment(ench, lvl);
/*  68 */     return this;
   }
   
   public ItemBuilder addFlags(ItemFlag... flag) {
/*  72 */     ItemMeta m = this.item.getItemMeta();
/*  73 */     m.addItemFlags(flag);
/*  74 */     this.item.setItemMeta(m);
/*  75 */     return this;
   }
   
   public ItemBuilder setLeatherColor(Color color) {
/*  79 */     LeatherArmorMeta m = (LeatherArmorMeta)this.item.getItemMeta();
/*  80 */     m.setColor(color);
/*  81 */     this.item.setItemMeta(m);
/*  82 */     return this;
   }
   
   public ItemBuilder setSkullOwner(String owner) {
/*  86 */     SkullMeta m = (SkullMeta)this.item.getItemMeta();
/*  87 */     m.setOwner(owner);
/*  88 */     this.item.setItemMeta(m);
/*  89 */     return this;
   }
   
   public ItemBuilder setPotionType(PotionEffectType type) {
/*  93 */     PotionMeta m = (PotionMeta)this.item.getItemMeta();
/*  94 */     m.setMainEffect(type);
/*  95 */     this.item.setItemMeta(m);
/*  96 */     return this;
   }
   
   public ItemBuilder setBookAuthor(String author) {
/* 100 */     BookMeta m = (BookMeta)this.item.getItemMeta();
/* 101 */     m.setAuthor(author);
/* 102 */     this.item.setItemMeta(m);
/* 103 */     return this;
   }
   
   public ItemBuilder setBookContent(String... pages) {
/* 107 */     BookMeta m = (BookMeta)this.item.getItemMeta();
/* 108 */     m.setPages(pages);
/* 109 */     this.item.setItemMeta(m);
/* 110 */     return this;
   }
   
   public ItemBuilder setBookTitle(String title) {
/* 114 */     BookMeta m = (BookMeta)this.item.getItemMeta();
/* 115 */     m.setTitle(title);
/* 116 */     this.item.setItemMeta(m);
/* 117 */     return this;
   }
   
   public ItemBuilder setBookMeta(String title, String author, String... pages) {
/* 121 */     BookMeta m = (BookMeta)this.item.getItemMeta();
/* 122 */     m.setTitle(title);
/* 123 */     m.setAuthor(author);
/* 124 */     m.setPages(pages);
/* 125 */     this.item.setItemMeta(m);
/* 126 */     return this;
   }
   
   @SuppressWarnings("deprecation")
public ItemBuilder setEggType(EntityType type) {
/* 130 */     if ((this.item != null) && (this.item.getType() == Material.MONSTER_EGG) && (type != null) && (type.getName() != null))
     {
       try
       {
/* 134 */         String version = org.bukkit.Bukkit.getServer().getClass().toString().split("\\.")[3];
/* 135 */         Class<?> craftItemStack = Class.forName("org.bukkit.craftbukkit." + version + ".inventory.CraftItemStack");
/* 136 */         Object nmsItemStack = craftItemStack.getDeclaredMethod("asNMSCopy", new Class[] { ItemStack.class }).invoke(null, new Object[] { this.item });
/* 137 */         Object nbtTagCompound = Class.forName("net.minecraft.server." + version + ".NBTTagCompound").newInstance();
/* 138 */         Field nbtTagCompoundField = nmsItemStack.getClass().getDeclaredField("tag");
/* 139 */         nbtTagCompoundField.setAccessible(true);
/* 140 */         nbtTagCompound.getClass().getMethod("setString", new Class[] { String.class, String.class }).invoke(nbtTagCompound, new Object[] { "id", type.getName() });
/* 141 */         nbtTagCompound.getClass().getMethod("set", new Class[] { String.class, Class.forName("net.minecraft.server." + version + ".NBTBase") }).invoke(nbtTagCompoundField.get(nmsItemStack), new Object[] { "EntityTag", nbtTagCompound });
/* 142 */         this.item = ((ItemStack)craftItemStack.getDeclaredMethod("asCraftMirror", new Class[] { nmsItemStack.getClass() }).invoke(null, new Object[] { nmsItemStack }));
       }
       catch (Exception ex)
       {
/* 146 */         ex.printStackTrace();
       }
     }
/* 149 */     return this;
   }
   
   public ItemBuilder setSkullTexture(String base64) {
/* 153 */     ItemMeta m = this.item.getItemMeta();
/* 154 */     GameProfile profile = new GameProfile(java.util.UUID.randomUUID(), null);
/* 155 */     profile.getProperties().put("textures", new Property("textures", base64));
/* 156 */     Field profileField = null;
     try
     {
/* 159 */       profileField = m.getClass().getDeclaredField("profile");
/* 160 */       profileField.setAccessible(true);
/* 161 */       profileField.set(m, profile);
     }
     catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException e1)
     {
/* 165 */       e1.printStackTrace();
     }
/* 167 */     this.item.setItemMeta(m);
/* 168 */     return this;
   }
   
   public ItemStack build() {
/* 172 */     return this.item;
   }
 }

