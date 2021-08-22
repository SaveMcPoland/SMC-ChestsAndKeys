package pl.savemc.chestsandkeys.config;

import net.dzikoysk.cdn.entity.Description;
import pl.savemc.chestsandkeys.config.components.RoyalSetConfig;

import java.io.Serializable;
import java.util.*;

public final class ChestConfig implements Serializable {

    @Description("# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ #")
    @Description("#                                          #")
    @Description("#        SMC-SMCChestsAndKeys v1.0         #")
    @Description("#          by Kamicjusz, Rollczi           #")
    @Description("#                                          #")
    @Description("# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ #")

    @Description("")
    @Description("# ~~~~~~~~~~~~~~~~ #")
    @Description("# #---# Chests #---#")
    @Description("# ~~~~~~~~~~~~~~~~ #")
    @Description("")
    @Description("# Zestawy:")

    public List<RoyalSetConfig> royalSets = Collections.singletonList(new RoyalSetConfig());

}