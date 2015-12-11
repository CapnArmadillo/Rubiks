package com.armadillo.rubik.tutorial.cone;


public class Drum extends Cone {
	public Drum(float radius, float height)  {
		super(radius, radius, height, 16, true);
	}
	public Drum(float radius, float height, int numberOfSides)  {
		super(radius, radius, height, numberOfSides, true);
	}
}