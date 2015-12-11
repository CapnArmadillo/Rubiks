package com.armadillo.rubik.tutorial.group;

import com.armadillo.rubik.tutorial.cone.Face;


public class Cube2 extends Group {
	public Cube2(float width, float height, float depth) {
		width  /= 2;
		height /= 2;
		depth  /= 2;
		
		float[] vertices = {
			-width, -height, -depth, // 0
			 width, -height, -depth, // 1
			 width,  height, -depth, // 2
			-width,  height, -depth, // 3
			-width, -height,  depth, // 4
			 width, -height,  depth, // 5
			 width,  height,  depth, // 6
			-width,  height,  depth, // 7
		};
		
		short[][] indices = {
			{
				3, 1, 0,
				3, 2, 1, 
			},{
				5, 4, 0,
				0, 1, 5,
			},{
				3, 4, 7,
				4, 3, 0,
			},{
				6, 5, 1,
				1, 2, 6,
			},{
				7, 6, 2,
				2, 3, 7,
			},{
				4, 6, 7,
				4, 5, 6,
			}
		};
		
		short[][] lines = {
			{
				0, 1,
				0, 3,
				1, 2,
				2, 3,
			},{
				0, 1,
				0, 4,
				1, 5,
				4, 5,
			},{
				0, 3,
				0, 4,
				3, 7,
				4, 7,
			},{
				1, 2,
				1, 5,
				2, 6,
				5, 6,
			},{
				2, 3,
				2, 6,
				3, 7,
				6, 7,
			},{
				4, 5,
				4, 7,
				5, 6,
				6, 7,
			}
		};

		// The colors mapped to the sides.
		float[][] colors = {
			{
				1f, 0f, 0f, 1f, // 0 red
			},{
				0f, 0f, 1f, 1f, // 1 blue
			},{
				1f, 1f, 1f, 1f, // 2 white
			},{
				1f, 0.5f, 0f, 1f, // 3 orange
			},{
				1f, 1f, 0f, 1f, // 4 yellow
			},{
				0f, 1f, 0f, 1f, // 5 green
			},{
				0f, 1f, 1f, 1f, // 6 cyan
			},{
				1f, 0f, 1f, 1f, // 7 magenta
			},{
				0.5f, 0f, 1f, 1f, // 8 purple
			},{
				1f, 0f, 0.5f, 1f, // 9 maroon
			},{
				0.5f, 1f, 0f, 1f, // 10 lime
			},{
				0f, 1f, 0.5f, 1f, // 11 maroon
			},{
				0f, 0.5f, 1f, 1f, // 12 teal
			}
		};

		for(int i = 0; i < 6; i++){
			add(new Face(vertices, indices[i], lines[i], colors[i]));
		}
	}
}