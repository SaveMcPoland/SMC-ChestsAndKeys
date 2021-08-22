package pl.savemc.chestsandkeys.system;

import panda.std.Option;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoyalSetsManager {

    private final Map<String, RoyalSet> royalSets = new HashMap<>();

    public void registerRoyalSet(RoyalSet royalSet) {
        this.royalSets.put(royalSet.getName(), royalSet);
    }

    public Option<RoyalSet> getRoyalSet(String name) {
        return Option.of(royalSets.get(name));
    }

    public Set<RoyalSet> getRoyalSets() {
        return new HashSet<>(royalSets.values());
    }

}
