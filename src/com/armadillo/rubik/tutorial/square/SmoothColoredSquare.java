package com.armadillo.rubik.tutorial.square;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class SmoothColoredSquare extends Square {
	// The colors mapped to the vertices.
	float[] colors = {
		1f, 0f, 0f, 1f, // vertex 0 red
		0f, 1f, 0f, 1f, // vertex 1 green
		0f, 0f, 1f, 1f, // vertex 2 blue
		1f, 0f, 1f, 1f, // vertex 3 magenta
	};

    // Our color buffer.
	private FloatBuffer colorBuffer;

	public SmoothColoredSquare() {
		super();

		// float has 4 bytes, colors (RGBA) * 4 bytes
		ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
		cbb.order(ByteOrder.nativeOrder());
		colorBuffer = cbb.asFloatBuffer();
		colorBuffer.put(colors);
		colorBuffer.position(0);
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

		// Enable the color array buffer to be used during rendering.
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY); // NEW LINE ADDED.
		// Point out the where the color buffer is.
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer); // NEW LINE ADDED.

		gl.glDrawElements(GL10.GL_TRIANGLES, indices().length,
					GL10.GL_UNSIGNED_SHORT, indexBuffer());

		// Disable the vertices buffer.
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY); // OpenGL docs
		// Disable face culling.
		gl.glDisable(GL10.GL_CULL_FACE); // OpenGL docs

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer());

		// Disable the color buffer.
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}

}