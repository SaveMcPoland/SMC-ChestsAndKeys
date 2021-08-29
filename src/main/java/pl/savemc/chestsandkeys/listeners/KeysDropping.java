package pl.savemc.chestsandkeys.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.savemc.chestsandkeys.SMCChestsAndKeys;
import pl.savemc.chestsandkeys.system.Key;
import pl.savemc.chestsandkeys.system.RoyalSet;
import pl.savemc.chestsandkeys.system.RoyalSetsManager;

import java.util.Random;

public class KeysDropping implements Listener {

    private final SMCChestsAndKeys plugin;
    private final Random random = new Random();

    public KeysDropping(SMCChestsAndKeys plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onMine(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType() != Material.STONE) {
            return;
        }

        Player player = event.getPlayer();
        RoyalSetsManager royalSetsManager = plugin.getRoyalSetsManager();
        double randomVal = random.nextDouble(); // wartość od 0.0 do 1.0

        for (RoyalSet royalSet : royalSetsManager.getRoyalSets()) {
            Key key = royalSet.getKey();

            // jeśli wartość key.getChance() to 0.1, to jest szansa 10% że randomVal będzie mniejsza od key.getChance()
            if (!(randomVal < key.getChance())) {
                return;
            }

            player.getInventory().addItem(key.getRepresentation().getItem());
        }
    }
}
