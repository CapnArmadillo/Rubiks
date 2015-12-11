package com.armadillo.rubik.tutorial.cone;


public class Lathe extends Cone {
	public Lathe(float radius, float height)  {
		super(getRadii(radius), getHeights(height), 5, true);
	}
	public Lathe(float[] radii, float[] heights, int numberOfSides)  {
		super(radii, heights, numberOfSides, true);
	}
	public static float[] getRadii(float radius){
		float[] radii = {0, radius, radius, 0};
		return radii;
	}
	public static float[] getHeights(float height){
		float[] heights = {-height * 0.5f, -height * 0.2236f, height * 0.2236f, height * 0.5f};
		return heights;
	}
}