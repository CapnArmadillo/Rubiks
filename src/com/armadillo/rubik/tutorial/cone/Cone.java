package com.armadillo.rubik.tutorial.cone;


import android.util.FloatMath;
//import android.util.Log;

import com.armadillo.rubik.tutorial.group.Group;

public class Cone extends Group {
	private static final String TAG = "Cone";
//	private float baseRadius, topRadius, height; 
	private float angle;
	private static float[] _radii, _heights;
	private int numberOfSides;
	private boolean offsetSides = false;
	private int colorSpace = 5;
	
	public Cone(float baseRadius, float topRadius, float height, int numberOfSides){
		this(getRadii(baseRadius, topRadius), getHeights(height), numberOfSides, false);
	}
	public Cone(float baseRadius, float topRadius, float height, int numberOfSides, boolean offsetSides){
		this(getRadii(baseRadius, topRadius), getHeights(height), numberOfSides, offsetSides);
	}
	public Cone(float[] radii, float[] heights, int numberOfSides, boolean offsetSides){
		setRadii(radii);
		setHeights(heights);
		setNumberOfSides(numberOfSides);
		setOffsetSides(offsetSides);
		
		angle = 360 / numberOfSides;
		for(int i = 0; i < numberOfSides(); i++){
			addFaces(radii, heights, angle * (i + 0.5f));
		}
	}

	public void addFaces(float[] radii, float[] heights, float angleStart) {
		
		float[] point1, point2; 
		float[] point3 = {radii[0] * FloatMath.cos((float)Math.toRadians(angleStart)), -radii[0] * FloatMath.sin((float)Math.toRadians(angleStart)), heights[0]}; 
		float[] point4 = {radii[0] * FloatMath.cos((float)Math.toRadians(angleStart + angle)), -radii[0] * FloatMath.sin((float)Math.toRadians(angleStart + angle)), heights[0]}; 

		for (int i = 1; i < radii.length; i++){
			point1 = point3; 
			point2 = point4; 
			float angleOffset = 0;
			if (offsetSides()){
				angleOffset = i * angle / 2;
			}
			float[] temp3 = {radii[i] * FloatMath.cos((float)Math.toRadians(angleStart + angleOffset)), -radii[i] * FloatMath.sin((float)Math.toRadians(angleStart + angleOffset)), heights[i], }; 
			float[] temp4 = {radii[i] * FloatMath.cos((float)Math.toRadians(angleStart + angle + angleOffset)), -radii[i] * FloatMath.sin((float)Math.toRadians(angleStart + angle  + angleOffset)), heights[i], }; 
			point3 = temp3;
			point4 = temp4;

			float vertices[] = {
				point1[0], point1[1], 	point1[2], // 0
				point2[0], point2[1], 	point2[2], // 1
				point3[0], point3[1], 	point3[2], // 2
				point4[0], point4[1], 	point4[2], // 3
			};
			
			short[][] indices = {
				{
					0, 2, 1, 
				},{
					1, 2, 3, 
				}
			};
			short[][] lines = getLines();
			for(int j = 0; j < indices.length; j++){
				add(new Face(vertices, indices[j], lines[j], angleStart, colorSpace));
			}
//			add(new Face(vertices, indices[i], lines[i], angleStart + (angle * i / 4), colorSpace));
		}
		
	}
	protected static short[][] getLines(){
		short[][] lines = {
				{
					0, 1,
					0, 2, 
					1, 2,
				},{
					1, 3, 
					2, 3,
				}
			};
		return lines;
	}
	public static float[] getRadii(float baseRadius, float topRadius){
		float[] radii = {0, baseRadius, topRadius, 0};
		setRadii(radii);
		return radii;
	}
	public static float[] getHeights(float height){
		float[] heights = {-height / 2, -height / 2, height / 2, height / 2};
		setHeights(heights);
		return heights;
	}
	protected static void setRadii(float[] radii) {
		_radii = radii;
	}
	protected float[] radii() {
		return _radii;
	}
	protected static void setHeights(float[] heights) {
		_heights = heights;
	}
	protected float[] heights() {
		return _heights;
	}
	protected void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	protected int numberOfSides() {
		return numberOfSides;
	}
	protected void setOffsetSides(boolean offsetSides) {
		this.offsetSides = offsetSides;
	}
	protected boolean offsetSides() {
		return offsetSides;
	}
	protected void setColorSpace(int colorSpace) {
		this.colorSpace = colorSpace;
	}
	protected int colorSpace() {
		return colorSpace;
	}

}