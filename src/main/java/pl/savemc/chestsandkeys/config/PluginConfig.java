package pl.savemc.chestsandkeys.config;

import net.dzikoysk.cdn.entity.Description;

import java.io.Serializable;

public final class PluginConfig implements Serializable {

    @Description("# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ #")
    @Description("#                                          #")
    @Description("#        SMC-SMCChestsAndKeys v1.0         #")
    @Description("#          by Kamicjusz, Rollczi           #")
    @Description("#                                          #")
    @Description("# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ #")

    @Description("")
    @Description("# ~~~~~~~~~~~~~~~~~~ #")
    @Description("# #---# System #---#")
    @Description("# ~~~~~~~~~~~~~~~~~~ #")
    @Description("")
    @Description("# Tryb debugowania (Console)")
    public boolean debugConsole = false;

}