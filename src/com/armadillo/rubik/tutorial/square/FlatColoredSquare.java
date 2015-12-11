package com.armadillo.rubik.tutorial.square;

import javax.microedition.khronos.opengles.GL10;

public class FlatColoredSquare extends Square {

	public FlatColoredSquare() {
		super();
	}

	/**
	 * This function draws our square on screen.
	 * @param gl
	 */
	public void draw(GL10 gl) {
		gl.glColor4f(0.5f, 0.5f, 1.0f, 1.0f); // 0x8080FFFF
		// Counter-clockwise winding.
		gl.glFrontFace(GL10.GL_CCW); // OpenGL docs
		// Enable face culling.
		gl.glEnable(GL10.GL_CULL_FACE); // OpenGL docs
		// What faces to remove with the face culling.
		gl.glCullFace(GL10.GL_BACK); // OpenGL docs

		// Enabled the vertices buffer for writing and to be used during
		// rendering.
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// OpenGL docs.
		// Specifies the location and data format of an array of vertex
		// coordinates to use when rendering.
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, // OpenGL docs
				vertexBuffer());

		gl.glDrawElements(GL10.GL_TRIANGLES, indices().length,// OpenGL docs
				GL10.GL_UNSIGNED_SHORT, indexBuffer());

		// Disable the vertices buffer.
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY); // OpenGL docs
		// Disable face culling.
		gl.glDisable(GL10.GL_CULL_FACE); // OpenGL docs
	}

}