package me.TahaCheji.Mafana.itemData.masterData;

public class ItemValueUtl {

    private final int Value;
    private final boolean sellable;

    public ItemValueUtl(int itemValue, boolean isSellable) {
        this.Value = itemValue;
        this.sellable = isSellable;
    }

    public int getValue() {
        return Value;
    }

    public boolean isSellable() {
        return sellable;
    }

}
