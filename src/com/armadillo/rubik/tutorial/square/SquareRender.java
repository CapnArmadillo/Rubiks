package com.armadillo.rubik.tutorial.square;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;

public class SquareRender extends OpenGLRenderer {
	// Initialize our squares.
	private Square square;
	private FlatColoredSquare flatSquare; // CHANGED
	private SmoothColoredSquare smoothSquare; // NEW LINE ADDED.
	private float angle; // Don't forget to add this.

	public SquareRender() {
		// Initialize our square.
		square = new Square();
		flatSquare = new FlatColoredSquare(); // CHANGED
		smoothSquare = new SmoothColoredSquare(); // NEW LINE ADDED.
	}
/* * /
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();

		// Translates 7 units into the screen and 1.5 units up.
		gl.glTranslatef(0, 1.5f, -7);
		// Draw our flat square.
		flatSquare.draw(gl);

		// Translate to end up under the flat square.
		gl.glTranslatef(0, -3f, 0);
		// Draw our smooth square.
		smoothSquare.draw(gl);
	}
/* */
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();
		// Translates 10 units into the screen.
		gl.glTranslatef(0, 0, -10); 

		// SQUARE A
		// Save the current matrix.
		gl.glPushMatrix();
		// Rotate square A counter-clockwise.
		gl.glRotatef(angle, 0, 0, 1);
		// Draw square A.
//		square.draw(gl);
//		flatSquare.draw(gl); // Don't forget to change this one.
		smoothSquare.draw(gl); // Don't forget to change this one.
		// Restore the last matrix.
		gl.glPopMatrix();

		// SQUARE B
		// Save the current matrix
		gl.glPushMatrix();
		// Rotate square B before moving it, making it rotate around A.
		gl.glRotatef(-angle, 0, 0, 1);
		// Move square B.
		gl.glTranslatef(2, 0, 0);
		// Scale it to 50% of square A
		gl.glScalef(.5f, .5f, .5f);
		// Draw square B.
		flatSquare.draw(gl);			

		// SQUARE C
		// Save the current matrix
		gl.glPushMatrix();
		// Make the rotation around B
		gl.glRotatef(-angle, 0, 0, 1);
		gl.glTranslatef(2, 0, 0);
		// Scale it to 50% of square B
		gl.glScalef(.5f, .5f, .5f);
		// Rotate around it's own center.
		gl.glRotatef(angle*10, 0, 0, 1);
		// Draw square C.
		square.draw(gl);

		// Restore to the matrix as it was before C.
		gl.glPopMatrix();
		// Restore to the matrix as it was before B.
		gl.glPopMatrix();

		// Increse the angle.
		angle++;
	}
}