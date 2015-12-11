package com.armadillo.rubik.tutorial.cone;


public class Cylinder extends Cone {
	public Cylinder(float radius, float height)  {
		super(radius, radius, height, 8);
	}
	public Cylinder(float radius, float height, int numberOfSides)  {
		super(radius, radius, height, numberOfSides);
	}
}