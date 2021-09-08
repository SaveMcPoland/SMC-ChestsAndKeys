# SMC-ChestsAndKeys (Prace nad projektem, jeszcze nieaktywny)

Plugin dodaje drop kluczy, za pomocą których można wylosować itemy ze skrzynek.


Add your chest and key in code:
```java
SMCChestsAndKeys plugin = (SMCChestsAndKeys) Bukkit.getPluginManager().getPlugin("SMC-ChestsAndKeys");

RoyalSetsManager royalSetsManager = plugin.getRoyalSetsManager();
RoyalSet royalSet = new RoyalSet("example");
Key key = royalSet.getKey();
Chest chest = royalSet.getChest();

ItemBuilder keyItem = new ItemBuilder(Material.CHEST)
        .setName("&aexample key", true);
ItemBuilder chestItem = new ItemBuilder(Material.CHEST)
        .setName("&aexample chest", true)
        .setLore("&7line1", "&7line2");

key.setChance(0.25); // (25% chance)
key.setRepresentation(keyItem);
chest.setRepresentation(chestItem);

royalSetsManager.registerRoyalSet(royalSet);
```
