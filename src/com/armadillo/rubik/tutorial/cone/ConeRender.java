package com.armadillo.rubik.tutorial.cone;

import javax.microedition.khronos.opengles.GL10;

import com.armadillo.rubik.tutorial.OpenGLRenderer;

public class ConeRender extends OpenGLRenderer {
	private Cone cone;
	private int angle;

	public ConeRender() {
		// Initialize our cone.
		cone = new Cone(3, 2, 4, 8);
		cone.rx = 90;
		cone.ry = 0;
//		cone.rz = 90;
	}
	public ConeRender(int type) {
		// Initialize our cone.
		switch (type){
			case 1:
				cone = new Cylinder(2, 3);
				break;
			case 2:
				cone = new Pyramid(2, 3);
				break;
			case 3:
				cone = new Drum(2, 2, 8);
				break;
			case 4: // d20
				cone = new Lathe(1.7888f, 4);
				break;
			case 5: // d4
				cone = new Pyramid(2, 2.8284f, 3);
				break;
			case 6: // d8
				float[] radii8 = {0, 2, 0};
				float[] heights8 = {-2, 0, 2};
				cone = new Lathe(radii8, heights8, 4);
				break;
			case 7: // d10
				float[] radii10 = {0, 2, 2, 0};
				float[] heights10 = {-2, -0.2f, 0.2f, 2};
				cone = new Lathe(radii10, heights10, 5);
				break;
			default:{
				new ConeRender();
			}
		}
	}
	public void onDrawFrame(GL10 gl) {
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();

		gl.glTranslatef(0, 0, -10); // OpenGL docs

		gl.glRotatef(angle, 1, 1, 1);
//		gl.glRotatef(angle, 0, 1, 0);
//		gl.glRotatef(angle, 0, 0, 1);
		angle++;
		// Draw our cone.
		cone.draw(gl);
	}
}