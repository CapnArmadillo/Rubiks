package com.armadillo.rubik.tutorial.cone;


public class Pyramid extends Cone {
	public Pyramid(float baseRadius, float height)  {
		super(baseRadius, 0, height, 4);
	}
	public Pyramid(float baseRadius, float height, int numberOfSides)  {
		super(baseRadius, 0, height, numberOfSides);
	}
}