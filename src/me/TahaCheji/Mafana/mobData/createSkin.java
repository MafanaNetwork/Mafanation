package me.TahaCheji.Mafana.mobData;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.SkinTrait;

public class createSkin {

    private final String name;
    private final String signature;
    private final String data;

    public createSkin(String name, String signature, String data) {
        this.name = name;
        this.signature = signature;
        this.data = data;
    }

    public void setSkin(NPC npc) {
        SkinTrait skin = npc.getOrAddTrait(SkinTrait.class);
        skin.setSkinPersistent(name, signature, data);
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }

    public String getData() {
        return data;
    }






}
