package pl.savemc.chestsandkeys.config.composers;

import net.dzikoysk.cdn.serialization.Composer;
import net.dzikoysk.cdn.serialization.SimpleDeserializer;
import net.dzikoysk.cdn.serialization.SimpleSerializer;

public interface MoreSimpleComposer<T> extends Composer<T>, SimpleSerializer<T>, SimpleDeserializer<T> {

}
