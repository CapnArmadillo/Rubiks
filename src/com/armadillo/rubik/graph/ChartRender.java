package com.armadillo.rubik.graph;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;

public class ChartRender extends OpenGLRenderer {
	private Chart mesh;
	private int angle;
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
	
	private static float[][] GOOG =
	{
		{0f, 615.32f},{0.04f, 611.36f},{0.08f, 611.34f},{0.12f, 613.25f},{0.16f, 615.4f},{0.2f, 614.57f},{0.24f, 611.65f},{0.28f, 611.83f},{0.32f, 610.72f},{0.36f, 610.8f},{0.4f, 608.86f},{0.44f, 609.51f},{0.48f, 609.63f},{0.52f, 608.68f}
	};
	private static float[][] AAPL =
	{
		{0f, 603.898f},{0.04f, 600.53f},{0.08f, 599.26f},{0.12f, 600.84f},{0.16f, 601.285f},{0.2f, 601.41f},{0.24f, 600f},{0.28f, 600.19f},{0.32f, 601.252f},{0.36f, 599.54f},{0.4f, 598f},{0.44f, 596.86f},{0.48f, 595.92f},{0.52f, 595.69f}
	};
	private static float[][] THI =
	{
		{0f, 54.84f},{0.04f, 55.1f},{0.08f, 54.74f},{0.12f, 54.76f},{0.16f, 54.86f},{0.2f, 54.81f},{0.24f, 54.75f},{0.28f, 54.76f},{0.32f, 54.64f},{0.36f, 54.53f},{0.4f, 54.52f},{0.44f, 54.39f},{0.48f, 54.34f},{0.52f, 54.31f}
	};
	private static float[][] HAS =
	{
		{0f, 36.1f},{0.04f, 36.41f},{0.08f, 36.21f},{0.12f, 36.31f},{0.16f, 36.4f},{0.2f, 36.34f},{0.24f, 36.37f},{0.28f, 36.348f},{0.32f, 36.29f},{0.36f, 36.26f},{0.4f, 36.12f},{0.44f, 36.167f},{0.48f, 36.19f},{0.52f, 36.189f}
	};
	
	private static float[][][] stocks = {GOOG, AAPL, THI, HAS};
	private static float[][][] bigStocks = {GOOG, AAPL};
	private static float[][][] smallStocks = {THI, HAS};
	private static int zWidth = 3, zHeight = 3;
	private static float zOffset = 26;

	public ChartRender() {
		this(0);
	}
	public ChartRender(int option) {
		// Initialize our chart.
		switch (option){
			case 1:
				mesh = new Chart(3, 6, zCoords, zOffset);
				mesh.rx = 0;
				mesh.ry = 30;
				mesh.rz = 0;
				break;
			case 2:
				mesh = new Chart(stocks);
				mesh.rx = 0;
				mesh.ry = 30;
				mesh.rz = 0;
				mesh.z = 0;
				break;
			case 3:
				mesh = new Chart(smallStocks);
				mesh.rx = 0;
				mesh.ry = 30;
				mesh.rz = 0;
				mesh.z = 0;
				break;
			case 4:
				mesh = new Chart(bigStocks);
				mesh.rx = 0;
				mesh.ry = 30;
				mesh.rz = 0;
				mesh.z = 0;
				break;
			default:
				mesh = new Chart(3, 6, zWidth, zHeight, zCoords, zOffset);
				mesh.rx = 0;
				mesh.ry = 30;
				mesh.rz = 0;
		}
	}
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, -10); // OpenGL docs

		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 0, 1);
		angle++;
		// Draw our chart.
		mesh.draw(gl);
	}
}