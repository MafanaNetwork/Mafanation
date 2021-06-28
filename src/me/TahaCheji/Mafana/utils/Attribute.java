package me.TahaCheji.Mafana.utils;

public enum Attribute {
	
	STRENGTH("Strength", Integer.MAX_VALUE),
	HEALTH("Health", Integer.MAX_VALUE),
	SPEED("Speed", Integer.MAX_VALUE),
	MANA("Mana", Integer.MAX_VALUE);

	private final String name;
	private final int maxValue;
	
	Attribute(String string, int maxValue) {
		this.name = string;
		this.maxValue = maxValue;
	}
	
	public String getName() {
		return this.name;
	}

	public int getMaxValue() {
		return this.maxValue;
	}
}
