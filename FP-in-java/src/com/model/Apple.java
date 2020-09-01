package com.model;

public class Apple {

	private Color color;
	private int weight;
	private String country;

	public Apple(int weight, Color color, String country) {
		super();
		this.color = color;
		this.weight = weight;
		this.country = country;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + ", country="+country+"]";
	}

}
