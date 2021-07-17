package pl.savemc.chestsandkeys.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemManager {

    private static ItemManager itemManager;
    private final ItemStack
            // chests
            silverChest, goldenChest, diamondChest,
            // keys
            silverKey, goldenKey, diamondKey
            ;

    public ItemManager() {
        itemManager = this;
        /* sample
        ArrayList<String>  = new ArrayList();
        .add("&b-----------------------------");
        .add("&e");
        .add("&b-----------------------------");
        this. = new ItemBuilder(Material.)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore()
                .getItem();*/
        ArrayList<String> silverLore = new ArrayList();
        silverLore.add("&b-----------------------------");
        silverLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        silverLore.add("&b-----------------------------");
        this.silverChest = new ItemBuilder(Material.TRAPPED_CHEST)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(silverLore)
                .getItem();
        ArrayList<String> goldenLore = new ArrayList();
        goldenLore.add("&b-----------------------------");
        goldenLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        goldenLore.add("&b-----------------------------");
        this.goldenChest = new ItemBuilder(Material.TRAPPED_CHEST)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(goldenLore)
                .getItem();
        ArrayList<String> diamondLore = new ArrayList();
        diamondLore.add("&b-----------------------------");
        diamondLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        diamondLore.add("&b-----------------------------");
        this.diamondChest = new ItemBuilder(Material.TRAPPED_CHEST)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(diamondLore)
                .getItem();
        ArrayList<String> slvKeyLore = new ArrayList();
        slvKeyLore.add("&b-----------------------------");
        slvKeyLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        slvKeyLore.add("&b-----------------------------");
        this.silverKey = new ItemBuilder(Material.TRIPWIRE_HOOK)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(slvKeyLore)
                .getItem();
        ArrayList<String> glnKeyLore = new ArrayList();
        glnKeyLore.add("&b-----------------------------");
        glnKeyLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        glnKeyLore.add("&b-----------------------------");
        this.goldenKey = new ItemBuilder(Material.TRIPWIRE_HOOK)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(glnKeyLore)
                .getItem();
        ArrayList<String> dmdKeyLore = new ArrayList();
        dmdKeyLore.add("&b-----------------------------");
        dmdKeyLore.add("&cBy ja otworzyc potrzebujesz klucza!");
        dmdKeyLore.add("&b-----------------------------");
        this.diamondKey = new ItemBuilder(Material.TRIPWIRE_HOOK)
                .setName("", true)
                .setFlag(ItemFlag.HIDE_ENCHANTS)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .setLore(dmdKeyLore)
                .getItem();


    }

    public static ItemManager getInstance() {
        return itemManager;
    }

    public ItemStack getSilverChest() {
        return silverChest;
    }

    public ItemStack getGoldenChest() {
        return goldenChest;
    }

    public ItemStack getDiamondChest() {
        return diamondChest;
    }

    public ItemStack getSilverKey() {
        return silverKey;
    }

    public ItemStack getGoldenKey() {
        return goldenKey;
    }

    public ItemStack getDiamondKey() {
        return diamondKey;
    }
}

