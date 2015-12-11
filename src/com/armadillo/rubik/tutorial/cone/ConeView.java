package com.armadillo.rubik.tutorial.cone;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class ConeView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // (NEW)
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN); // (NEW)
		
		GLSurfaceView view = new GLSurfaceView(this);
		Bundle bundle = getIntent().getExtras();
		int type = bundle.getInt("TYPE");
		view.setRenderer(new ConeRender(type));
		setContentView(view);
	}
}