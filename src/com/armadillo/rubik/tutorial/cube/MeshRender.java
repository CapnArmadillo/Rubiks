package com.armadillo.rubik.tutorial.cube;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;

public class MeshRender extends OpenGLRenderer {
	private Plane mesh;
	private int angle;

	public MeshRender() {
		// Initialize our cube.
		mesh = new Plane(2, 4);
		mesh.rx = 45;
		mesh.ry = 45;
	}
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, -6); // OpenGL docs

		gl.glRotatef(angle, 1, 1, 1);
//		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 0, 1);
		angle++;
		// Draw our cube.
		mesh.draw(gl);
	}
}