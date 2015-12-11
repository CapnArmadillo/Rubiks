package com.armadillo.rubik.tutorial.cube;


public class Cube extends Mesh {
	public Cube(float width, float height, float depth) {
		width  /= 2;
		height /= 2;
		depth  /= 2;
		
		float vertices[] = {
			-width, -height, -depth, // 0
			 width, -height, -depth, // 1
			 width,  height, -depth, // 2
			-width,  height, -depth, // 3
			-width, -height,  depth, // 4
			 width, -height,  depth, // 5
			 width,  height,  depth, // 6
			-width,  height,  depth, // 7
		};
		
		short indices[] = {
			0, 4, 5,
			0, 5, 1,
			1, 5, 6,
			1, 6, 2,
			2, 6, 7,
			2, 7, 3,
			3, 7, 4,
			3, 4, 0,
			4, 7, 6,
			4, 6, 5,
			3, 0, 1,
			3, 1, 2, 
		};
		
		short lines[] = {
				0, 1,
				1, 2,
				2, 3,
				3, 0,

				0, 4,
				1, 5,
				2, 6,
				3, 7,
				
				4, 5,
				5, 6,
				6, 7,
				1, 4,
		};

		// The colors mapped to the vertices, trying to use "opposite" colors.  IE, red is "opposite" cyan, since cyan has no red.
		float[] colors = {
			1f, 0f, 0f, 1f, // vertex 0 red
			0f, 0f, 1f, 1f, // vertex 2 blue
			0.5f, 0f, 1f, 1f, // vertex 7 purple
			1f, 0f, 1f, 1f, // vertex 3 magenta
			1f, 0.5f, 0f, 1f, // vertex 4 orange
			0f, 1f, 0f, 1f, // vertex 6 green
			0f, 1f, 1f, 1f, // vertex 5 cyan
			1f, 1f, 0f, 1f, // vertex 1 yellow
		};

		setIndices(indices);
		setVertices(vertices);
		setLines(lines);
		setColors(colors);
	}
	public Cube(float width, float height, float depth,
            int widthSegments, int heightSegments, int depthSegments){
		width  /= 2;
		height /= 2;
		depth  /= 2;
		
		float vertices[] = {
			-width, -height, -depth, // 0
			 width, -height, -depth, // 1
			 width,  height, -depth, // 2
			-width,  height, -depth, // 3
			-width, -height,  depth, // 4
			 width, -height,  depth, // 5
			 width,  height,  depth, // 6
			-width,  height,  depth, // 7
		};
		
		short indices[] = {
			0, 4, 5,
			0, 5, 1,
			1, 5, 6,
			1, 6, 2,
			2, 6, 7,
			2, 7, 3,
			3, 7, 4,
			3, 4, 0,
			4, 7, 6,
			4, 6, 5,
			3, 0, 1,
			3, 1, 2, 
		};

		// The colors mapped to the vertices.
		float[] colors = {
			1f, 0f, 0f, 1f, // vertex 0 red
			0f, 1f, 0f, 1f, // vertex 1 green
			0f, 0f, 1f, 1f, // vertex 2 blue
			1f, 0f, 1f, 1f, // vertex 3 magenta
			0f, 1f, 1f, 1f, // vertex 4 cyan
			1f, 1f, 0f, 1f, // vertex 5 yellow
			1f, 0.5f, 0f, 1f, // vertex 6 orange
			0.5f, 0f, 1f, 1f, // vertex 7 purple
		};

		setIndices(indices);
		setVertices(vertices);
		setColors(colors);
		
	}
}