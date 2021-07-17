package pl.savemc.chestsandkeys;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class KeysDropping implements Listener {

    private final SMCChestsAndKeys plugin;
    // chance of drop keys from stone, 10 = 1%
    private int slvChance, gldChance, dmdChance;

    public KeysDropping(SMCChestsAndKeys plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMine(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getType() == Material.STONE){
            int rnd = new Random().nextInt(1000);
            if (rnd < slvChance + gldChance + dmdChance){
                if (rnd < slvChance){
                    // drop slv
                } else if(rnd > slvChance && rnd < slvChance + gldChance){
                    // drop gold
                } else if(rnd > slvChance + gldChance && rnd > slvChance + gldChance + dmdChance){
                    // drop diamond
                }
            }
        }
    }
}
