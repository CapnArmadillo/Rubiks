package com.armadillo.rubik.tutorial.cone;

import com.armadillo.rubik.tutorial.cube.Mesh;

public class Face extends Mesh {
	private int colorSpace = 0;
	public Face() {
		this(1, 1);
	}

	public Face(float width, float height) {
		float[] vertices = {
					-width / 2, -height / 2, 0,
					width / 2, -height / 2, 0,
					0, height / 2, 0
		};
		short[] indices = {
				0, 1, 2
		};
		short[] lines = {
				0, 1,
				0, 2,
				1, 2,
		};
		setVertices(vertices);
		setIndices(indices);
		setLines(lines);
	}

	public Face(float[] vertices, short[] indices){
		setVertices(vertices);
		setIndices(indices);
	}
	public Face(float[] vertices, short[] indices, float angle){
		setVertices(vertices);
		setIndices(indices);
		setColor(angle);
	}
	public Face(float[] vertices, short[] indices, short[] lines){
		setVertices(vertices);
		setIndices(indices);
		setLines(lines);
	}
	public Face(float[] vertices, short[] indices, short[] lines, float[] color){
		setVertices(vertices);
		setIndices(indices);
		setLines(lines);
		setColor(color);
	}
	public Face(float[] vertices, short[] indices, short[] lines, float angle){
		setVertices(vertices);
		setIndices(indices);
		setLines(lines);
		setColor(angle);
	}
	public Face(float[] vertices, short[] indices, short[] lines, float angle, int colorSpace){
		setVertices(vertices);
		setIndices(indices);
		setLines(lines);
		setColorSpace(colorSpace);
		setColor(angle);
	}
	public void setColor(float angle){
		float a = ((angle) % 360 ) / 360;
		float r, g, b;
		switch (colorSpace){
			case 1:
				a = (((angle / 64) % 4) / 4);
				r = (((angle / 1) % 4) / 4);
				g = (((angle / 4) % 4) / 4);
				b = (((angle / 16) % 4) /4);
				setColor(r, g, b, a);
				break;
			case 2:
				setColor(a, a, a, 1);
				break;
			case 3:
				setColor(a, 0, 0, 1);
				break;
			case 4:
				setColor(0, a, 0, 1);
				break;
			case 5:
				setColor(0, 0, a, 1);
				break;
			default:
				a = (4  - ((angle / 64) % 4)) / 4;
				r = ((angle % 4)) / 4 - a;
				g = ((angle / 4) % 4) / 4 - a;
				b = ((angle / 16) % 4) / 4 - a;
				setColor(r, g, b, 1);
				
		}
	}

	protected void setColorSpace(int colorSpace) {
		this.colorSpace = colorSpace;
	}

	protected int colorSpace() {
		return colorSpace;
	}

}