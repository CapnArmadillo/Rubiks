package com.armadillo.rubik.tutorial.cube;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;

public class CubeRender extends OpenGLRenderer {
	private Cube cube;
	private int angle;

	public CubeRender() {
		// Initialize our cube.
		cube = new Cube(1, 1, 1);
		cube.rx = 45;
		cube.ry = 45;
	}
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, -4); // OpenGL docs

		gl.glRotatef(angle, 1, 1, 1);
//		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 0, 1);
		angle++;
		// Draw our cube.
		cube.draw(gl);
	}
}