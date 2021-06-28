package me.TahaCheji.Mafana.utils;

import org.bukkit.entity.Entity;

public class removeHealth {

    public void removeMobHealth(Entity entity) {
        String name = entity.getCustomName();
        assert name != null;
        name = name.replaceAll("♥" , "");
        name = name.replaceAll("[0-9]","");
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
    }


}
