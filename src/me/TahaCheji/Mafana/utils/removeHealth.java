package me.TahaCheji.Mafana.utils;

import org.bukkit.entity.Entity;

public class removeHealth {

    public void removeMobHealth(Entity entity) {
        if(entity == null) return;
        if(entity.getCustomName() == null) return;
        String name = entity.getCustomName();
        assert name != null;
        name = name.replaceAll("♥" , "");
        name = name.replaceAll("[0-9]","");
        name = name.replaceAll("-","");
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
    }


}
