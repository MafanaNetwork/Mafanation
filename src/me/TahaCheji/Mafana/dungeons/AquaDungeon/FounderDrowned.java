package me.TahaCheji.Mafana.dungeons.AquaDungeon;



public class FounderDrowned  {
    /*

    public FounderDrowned(Location loc) {
        super(EntityTypes.s, ((CraftWorld) loc.getWorld()).getHandle());

        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
/*
        this.getAttributeInstance(GenericAttributes.).setValue(1250);
        this.setHealth(1250);
        this.setSlot(EnumItemSlot, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.DIAMOND_CHESTPLATE)));
        this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.GOLDEN_LEGGINGS)));
        this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.DIAMOND_BOOTS)));
        this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.TRIDENT)));
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(
                ChatColor.translateAlternateColorCodes
                        ('&', "&4&lFounderDrowned ")));


 */

    /*

    public static class FounderDrownedMain implements Listener {

        public static void FounderDrowned(Player player) {
           spawnPoint1(player);
            }

        public static void spawnPoint1(Player player) {
            Location SpawnPoint1 = new Location(Bukkit.getWorld("world"),237, 22, 96);
            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(SpawnPoint1, EntityType.ARMOR_STAND);
            as.setVisible(false);
            as.setGravity(false);
            for (Entity entity : as.getNearbyEntities(5, 5, 5)) {
                if (((CraftEntity) entity).getHandle() instanceof FounderDrowned) {
                    return;
                }
            }
            FounderDrowned founderDrowned = new FounderDrowned(SpawnPoint1);
            ((CraftWorld) player.getWorld()).getHandle().addEntity(founderDrowned, CreatureSpawnEvent.SpawnReason.CUSTOM);
        }

        }

        public void createArmorStand(Location location) {
        //Creats armor stand and spawns it
            ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            //set the armor stand visibale so if you want like only the armor to show put it false
            as.setVisible(false);
            //setting the custom name visible and setting the name if you would like
            as.setCustomNameVisible(true);
            as.setCustomName("name");
            //setting the gravity false if you want it to move and stuff
            as.setGravity(false);
            //setting it small bec u said so
            as.setSmall(true);
            //setting the armor of it i used my armor constucker you can use itemStakcs
            as.getEquipment().setHelmet(ItemUtl.createItem(Material.LEATHER_HELMET, 1, ItemType.ARMOR, null, true, true, RarityType.GOLD, "Leather Helmet",
                    1, 1, 1, 1, null, null, false, false, 0, "Just a leather helmet"));
            as.getEquipment().setChestplate(ItemUtl.createItem(Material.LEATHER_CHESTPLATE, 1, ItemType.ARMOR, null, true, true, RarityType.GOLD, "Leather Chestplate",
                    1, 1, 1, 1, null, null, false, false, 0, "Just a leather Chestplate"));
            as.getEquipment().setLeggings(ItemUtl.createItem(Material.LEATHER_LEGGINGS, 1, ItemType.ARMOR, null, true, true, RarityType.GOLD, "Leather Legging",
                    1, 1, 1, 1, null, null, false, false, 0, "Just a leather legging"));
            as.getEquipment().setBoots(ItemUtl.createItem(Material.LEATHER_BOOTS, 1, ItemType.ARMOR, null, true, true, RarityType.GOLD, "Leather Boots",
                    1, 1, 1, 1, null, null, false, false, 0, "Just a leather boots"));
        }

     */




    }




