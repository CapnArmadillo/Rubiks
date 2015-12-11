package com.armadillo.rubik.graph;

import com.armadillo.rubik.tutorial.cube.Mesh;

public class Chart extends Mesh {
	private static float[][] zCoords = {
		{
			28.73f,	28.54f,	28.41f,	27.63f,	26.49f,	27.81f,	28.00f,
		}, {
			26.86f,	26.77f,	26.68f,	27.60f,	27.42f,	27.33f,	25.94f,
		}, {
			25.57f,	25.96f,	26.05f,	25.86f,	25.67f,	26.15f,	26.34f,
		}, {
			24.70f,	25.20f,	25.90f,	25.00f,	24.20f,	25.20f,	24.40f,
		}
	};
//	private static int zWidth = 3, zHeight = 3;
	private static int zWidth = 4, zHeight = 7;
	private static float zOffset = 26;
	public Chart() {
		this(1, 1, zWidth, zHeight, zCoords, zOffset);
	}

	public Chart(float width, float height) {
		this(width, height, zCoords, zOffset);
		x = 0;
		y = 0;
		z = 0;
		rx = 0;
		ry = 0;
		rz = 0;
	}

	public Chart(float width, float height, float[][] zValues, float offset) {
		this(width, height, zValues.length, zValues[0].length, zValues, offset);
	}
	public Chart(float[][][] zValues) {
		int width = zValues.length;
		int height = (zValues[0].length > 10) ? 10 : zValues[0].length;
		float[] vertices = new float[(width * height) * 3];
		short[] indices = new short[(width * height) * 6];
		short[] lines = new short[(width * height) * 8];
		
		int currentVertex = 0;
		int currentIndex = 0;
		int currentLine = 0;

		short w = (short) (width);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				vertices[currentVertex + 2] = zValues[i][j][1] / 100;
				vertices[currentVertex + 0] = zValues[i][j][0] * 10;
				vertices[currentVertex + 1] = i;
				currentVertex += 3;

				int n = j * (width) + i;

				if (j < height - 1 && i < width - 1) {
					// Face one
					indices[currentIndex] = (short) n;
					indices[currentIndex + 1] = (short) (n + 1);
					indices[currentIndex + 2] = (short) (n + w);
					// Face two
					indices[currentIndex + 3] = (short) (n + 1);
					indices[currentIndex + 4] = (short) (n + 1 + w);
					indices[currentIndex + 5] = (short) (n + w);

					lines[currentLine] = (short) n;
					lines[currentLine + 1] = (short) (n + 1);
					lines[currentLine + 2] = (short) (n);
					lines[currentLine + 3] = (short) (n + w);
					
					lines[currentLine + 4] = (short) (n + 1);
					lines[currentLine + 5] = (short) (n + 1 + w);
					lines[currentLine + 6] = (short) (n + w);
					lines[currentLine + 7] = (short) (n + 1 + w);

					currentIndex += 6;
					currentLine += 8;
				}
			}
		}

		setIndices(indices);
		setVertices(vertices);
		setLines(lines);
	}
	public Chart(float width, float height, int widthSegments,	int heightSegments, float[][] zValues, float offset) {
		zCoords = zValues;
		zOffset = offset;
		float[] vertices = new float[(widthSegments) * (heightSegments)
		                             * 3];
		short[] indices = new short[(widthSegments) * (heightSegments)
		                            * 6];
		short[] lines = new short[(widthSegments) * (heightSegments)
		                            * 8];

		float xOffset = width / -2;
		float yOffset = height / -2;
		float xWidth = width / (widthSegments - 1);
		float yHeight = height / (heightSegments - 1);
		int currentVertex = 0;
		int currentIndex = 0;
		int currentLine = 0;
		
		short w = (short) (widthSegments);
		for (int j = 0; j < heightSegments; j++) {
			for (int i = 0; i < widthSegments; i++) {
				vertices[currentVertex + 2] = xOffset + (i * xWidth);
				vertices[currentVertex + 0] = yOffset + (j * yHeight);
				vertices[currentVertex + 1] = zCoords[i][j] - zOffset;
				currentVertex += 3;

				int n = j * (widthSegments) + i;

				if (j < heightSegments - 1 && i < widthSegments - 1) {
					// Face one
					indices[currentIndex] = (short) n;
					indices[currentIndex + 1] = (short) (n + 1);
					indices[currentIndex + 2] = (short) (n + w);
					// Face two
					indices[currentIndex + 3] = (short) (n + 1);
					indices[currentIndex + 4] = (short) (n + 1 + w);
					indices[currentIndex + 5] = (short) (n + w);

					lines[currentLine] = (short) n;
					lines[currentLine + 1] = (short) (n + 1);
					lines[currentLine + 2] = (short) (n);
					lines[currentLine + 3] = (short) (n + w);
					
					lines[currentLine + 4] = (short) (n + 1);
					lines[currentLine + 5] = (short) (n + 1 + w);
					lines[currentLine + 6] = (short) (n + w);
					lines[currentLine + 7] = (short) (n + 1 + w);

					currentIndex += 6;
					currentLine += 8;
				}
			}
		}

		setIndices(indices);
		setVertices(vertices);
		setLines(lines);
	}

	public void setZCoords(float[][] coords) {
		zCoords = coords;
	}

	public float[][] zCoords() {
		return zCoords;
	}
}