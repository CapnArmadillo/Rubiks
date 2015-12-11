package com.armadillo.rubik;

import com.armadillo.rubik.graph.ChartView;
import com.armadillo.rubik.tutorial.TutorialPartI;
import com.armadillo.rubik.tutorial.cone.ConeView;
import com.armadillo.rubik.tutorial.cube.CubeView;
import com.armadillo.rubik.tutorial.cube.MeshView;
import com.armadillo.rubik.tutorial.group.Cube2View;
import com.armadillo.rubik.tutorial.group.GroupView;
import com.armadillo.rubik.tutorial.square.SquaresView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Menu extends Activity {
	private static final String TAG = "Menu";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}

	public void buttonPressed(String button){
		String buttonText = button + " button pressed.";
	    Log.d(TAG, "-63. " + buttonText);
	}

	public void rubiks(View view){
		buttonPressed("rubiks");
		Intent myIntent = new Intent(view.getContext(), RubiksApp.class);
		startActivity(myIntent);
	}
	public void tutorial1(View view){
		buttonPressed("3d");
		Intent myIntent = new Intent(view.getContext(), TutorialPartI.class);
		startActivity(myIntent);
	}
	public void cube(View view){
		buttonPressed("cube");
		Intent myIntent = new Intent(view.getContext(), CubeView.class);
		startActivity(myIntent);
	}
	public void cube2(View view){
		buttonPressed("cube2");
		Intent myIntent = new Intent(view.getContext(), Cube2View.class);
		startActivity(myIntent);
	}
	public void cone(View view){
		buttonPressed("cone");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 0);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void cylinder(View view){
		buttonPressed("cylinder");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 1);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void drum(View view){
		buttonPressed("drum");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 3);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void lathe(View view){
		buttonPressed("lathe");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 4);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void mesh(View view){
		buttonPressed("mesh");
		Intent myIntent = new Intent(view.getContext(), MeshView.class);
		startActivity(myIntent);
	}
	public void chart(View view){
		buttonPressed("chart");
		Intent myIntent = new Intent(view.getContext(), ChartView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 0);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void wideChart(View view){
		buttonPressed("Chart");
		Intent myIntent = new Intent(view.getContext(), ChartView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 1);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void chart2(View view){
		buttonPressed("Chart2");
		Intent myIntent = new Intent(view.getContext(), ChartView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 2);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void chart3(View view){
		buttonPressed("Chart3");
		Intent myIntent = new Intent(view.getContext(), ChartView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 3);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void chart4(View view){
		buttonPressed("Chart4");
		Intent myIntent = new Intent(view.getContext(), ChartView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 4);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void d20(View view){
		buttonPressed("d20");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 4);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void d4(View view){
		buttonPressed("d4");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 5);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void d8(View view){
		buttonPressed("d8");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 6);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void d10(View view){
		buttonPressed("d10");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 7);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void pyramid(View view){
		buttonPressed("pyramid");
		Intent myIntent = new Intent(view.getContext(), ConeView.class);
		Bundle bundle = new Bundle();
		bundle.putInt("TYPE", 2);
		myIntent.putExtras(bundle);
		startActivity(myIntent);
	}
	public void group(View view){
		buttonPressed("square");
		Intent myIntent = new Intent(view.getContext(), GroupView.class);
		startActivity(myIntent);
	}
	public void square(View view){
		buttonPressed("square");
		Intent myIntent = new Intent(view.getContext(), SquaresView.class);
		startActivity(myIntent);
	}
	public void squares(View view){
		buttonPressed("squares");
		Intent myIntent = new Intent(view.getContext(), SquaresView.class);
		startActivity(myIntent);
	}

	public void action(View view){
		buttonPressed("action");
	}

}