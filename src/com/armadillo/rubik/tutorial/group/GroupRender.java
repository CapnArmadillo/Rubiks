package com.armadillo.rubik.tutorial.group;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;
import com.armadillo.rubik.tutorial.cube.Cube;

public class GroupRender extends OpenGLRenderer {
	private Group root;
	private int angle;

	public GroupRender() {
		Group group = new Group();
		Cube cube = new Cube(1, 1, 1);
		cube.rx = 45;
		cube.ry = 45;
		group.add(cube);
		root = group;
	}
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();
		// Translates 10 units into the screen.
		gl.glTranslatef(0, 0, -6); 

		gl.glRotatef(angle, 3, 5, 7);
//		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 0, 1);
		angle++;
		// Draw our scene.
		root.draw(gl);
	}
}