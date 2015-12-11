package com.armadillo.rubik;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RubiksApp extends Activity {
	private static final int SIZE = 3;
	private static final int SIDES = 6;
	private static final String TAG = "RubiksCube";
	private static int count = 0;
	
	RubikColor[][][] cube = new RubikColor[SIDES][SIZE][SIZE]; 

	LinearLayout[] sides = new LinearLayout[SIDES]; 
	TextView _countView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		_countView = (TextView)findViewById(R.id.hello);
		LinearLayout cubeLayout = (LinearLayout)findViewById(R.id.cube);
		sides[0] = (LinearLayout)cubeLayout.findViewById(R.id.side0);
		sides[1] = (LinearLayout)cubeLayout.findViewById(R.id.side1);
		sides[2] = (LinearLayout)cubeLayout.findViewById(R.id.side2);
		sides[3] = (LinearLayout)cubeLayout.findViewById(R.id.side3);
		sides[4] = (LinearLayout)cubeLayout.findViewById(R.id.side4);
		sides[5] = (LinearLayout)cubeLayout.findViewById(R.id.side5);
/* * /
		for(int i = 0; i < SIDES; i++){
			sides[i].setId(i);
		}
/* */
		reset(null);
	}

	public void buttonPressed(String button){
		String buttonText = button + " button pressed.";
	    Log.d(TAG, "-63. " + buttonText);
	}

	public void action(View view){
		buttonPressed("action");
	}

	public void turnRight(View view){
		buttonPressed("turn right");
		rotate(5);
		rotateBack(0);
		RubikColor[][] temp = cube[4];
		for(int i = 4; i > 1; i--){
			cube[i] = cube[i - 1];
		    Log.d(TAG, "i = " + i);
		}
		cube[1] = temp;
		update();
	}
	public void turnLeft(View view){
		buttonPressed("turn left");
		rotate(0);
		rotateBack(5);
		RubikColor[][] temp = cube[1];
		for(int i = 1; i < 4; i++){
			cube[i] = cube[i+1];
		    Log.d(TAG, "i = " + i);
		}
		cube[4] = temp;
		update();
	}
	public void turnDown(View view){
		buttonPressed("turn down");
		rotate(4);
		rotateBack(2);
		rotate(5);
		rotate(5);
		RubikColor[][] temp = cube[5];
		cube[5] = cube[1];
		cube[1] = cube[0];
		rotate(3);
		rotate(3);
		cube[0] = cube[3];
		cube[3] = temp;
		update();
	}
	public void turnUp(View view){
		buttonPressed("turn up");
		rotate(2);
		rotateBack(4);
		rotate(0);
		rotate(0);
		RubikColor[][] temp = cube[0];
		cube[0] = cube[1];
		cube[1] = cube[5];
		rotate(3);
		rotate(3);
		cube[5] = cube[3];
		cube[3] = temp;
		update();
	}
	
	public void shift(int row){
		RubikColor[] temp = cube[1][row];
		for(int i = 1; i < 4; i++){
			cube[i][row] = cube[i + 1][row];
		}
		cube[4][row] = temp;
	}
	public void rotateTop(View view){
		rotate(0);
		shift(0);
		count(); 
	}
	public void rotateBottom(View view){
		turnUp(view);
		rotateFront(view);
		turnDown(view);
	}
	public void rotateFront(View view){
		turnUp(view);
		rotateTop(view);
		turnDown(view);
	}
	public void rotateRear(View view){
		turnDown(view);
		rotateTop(view);
		turnUp(view);
	}
	public void rotateLeft(View view){
		turnRight(view);
		rotateFront(view);
		turnLeft(view);
	}
	public void rotateRight(View view){
		turnRight(null);
		rotateRear(view);
		turnLeft(null);
	}

	public void shiftBack(int row){
		RubikColor[] temp = cube[4][row];
		for(int i = 4; i > 1; i--){
			cube[i][row] = cube[i - 1][row];
		}
		cube[1][row] = temp;
	}
	public void rotateTopBack(View view){
		rotateBack(0);
		shiftBack(0);
		count(); 
	}
	public void rotateBottomBack(View view){
		turnUp(view);
		rotateFrontBack(view);
		turnDown(view);
	}
	public void rotateFrontBack(View view){
		turnUp(view);
		rotateTopBack(view);
		turnDown(view);
	}
	public void rotateRearBack(View view){
		turnDown(view);
		rotateTopBack(view);
		turnUp(view);
	}
	public void rotateLeftBack(View view){
		turnRight(view);
		rotateFrontBack(view);
		turnLeft(view);
	}
	public void rotateRightBack(View view){
		turnRight(null);
		rotateRearBack(view);
		turnLeft(null);
	}

	public void updateCount(){
		_countView.setText("Count: " + count);
		update();
	}
	public void count(){
		count++;
		updateCount();
	}

	void rotate(int side){
		RubikColor[][] temp = new RubikColor[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				temp[j][SIZE - 1 - i] = cube[side][i][j];
			}
		}
		cube[side] = temp;
		update(side);
	}
	void rotateBack(int side){
		RubikColor[][] temp = new RubikColor[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				temp[SIZE - 1 - j][i] = cube[side][i][j];
			}
		}
		cube[side] = temp;
		update(side);
	}
	void fill(int side, RubikColor color){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				cube[side][i][j] = color;
			}
		}
		update(side);
	}
	void fill(int side){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				cube[side][i][j] = RubikColor.colorFromInt((side + i + j) % 6);
			}
		}
		update(side);
	}
	void update(){
		for(int i = 0; i < SIDES; i++){
			update(i);
		}
	}
	void update(int side){
		if(side < SIDES){
			sides[side].findViewById(R.id.cell00).setBackgroundColor(cube[side][0][0].color());
			sides[side].findViewById(R.id.cell01).setBackgroundColor(cube[side][0][1].color());
			sides[side].findViewById(R.id.cell02).setBackgroundColor(cube[side][0][2].color());
			sides[side].findViewById(R.id.cell10).setBackgroundColor(cube[side][1][0].color());
			sides[side].findViewById(R.id.cell11).setBackgroundColor(cube[side][1][1].color());
			sides[side].findViewById(R.id.cell12).setBackgroundColor(cube[side][1][2].color());
			sides[side].findViewById(R.id.cell20).setBackgroundColor(cube[side][2][0].color());
			sides[side].findViewById(R.id.cell21).setBackgroundColor(cube[side][2][1].color());
			sides[side].findViewById(R.id.cell22).setBackgroundColor(cube[side][2][2].color());
		}
	}
	public void action(View view, int act){
		switch (act % 12){
			case 0:
			rotateTop(view);
			break;
			case 1:
			rotateFront(view);
			break;
			case 2:
			rotateRight(view);
			break;
			case 3:
			rotateRear(view);
			break;
			case 4:
			rotateLeft(view);
			break;
			case 5:
			rotateBottom(view);
			break;
			case 6:
			rotateTopBack(view);
			break;
			case 7:
			rotateFrontBack(view);
			break;
			case 8:
			rotateRightBack(view);
			break;
			case 9:
			rotateRearBack(view);
			break;
			case 10:
			rotateLeftBack(view);
			break;
			case 11:
			rotateBottomBack(view);
			break;
		}
	}
	public void step1(View view){
		// bottom cross
	}
	public void step2(View view){
		// bottom corners
	}
	public void step3r(View view){
		// middle edges right
		// top, right, top', right', top', front', top, front
		action(view,0);
		action(view,2);
		action(view,6);
		action(view,8);
		action(view,6);
		action(view,7);
		action(view,0);
		action(view,1);
	}
	public void step3l(View view){
		// middle edges left
		// top', left', top, left, top, front, top', front'
		action(view,6);
		action(view,10);
		action(view,0);
		action(view,4);
		action(view,0);
		action(view,1);
		action(view,6);
		action(view,7);
	}
	public void step4l(View view){
		// top cross move into position
		// left, top, front, top', front', left'
		action(view,4);
		action(view,0);
		action(view,1);
		action(view,6);
		action(view,7);
		action(view,10);
	}
	public void step4i(View view){
		// top cross move into position alt
		// left, front, top, front', top', left'
		action(view,4);
		action(view,1);
		action(view,0);
		action(view,7);
		action(view,6);
		action(view,10);
	}
	public void step5l(View view){
		// top cross rotate left
		// left, top, left', top, left, top, top, left'
		action(view,4);
		action(view,0);
		action(view,10);
		action(view,0);
		action(view,4);
		action(view,0);
		action(view,0);
		action(view,10);
	}
	public void step5r(View view){
		// top cross rotate right
		// right', top', right, top', right', top', top', right
		action(view,8);
		action(view,6);
		action(view,2);
		action(view,6);
		action(view,8);
		action(view,6);
		action(view,6);
		action(view,2);
	}
	public void step6l(View view){
		// top corners move into position
		// left, top', right', top, left', top', right, top
		action(view,4);
		action(view,6);
		action(view,8);
		action(view,0);
		action(view,10);
		action(view,6);
		action(view,2);
		action(view,0);
	}
	public void step6r(View view){
		// top corners move into position reverse
		// right', top, left, top', right, top, left', top'
		action(view,8);
		action(view,0);
		action(view,4);
		action(view,6);
		action(view,2);
		action(view,0);
		action(view,10);
		action(view,6);
	}
	public void step7l(View view){
		// top corners rotate
		step5l(view);
		step5r(view);
	}
	public void step7r(View view){
		// top corners rotate
		step5r(view);
		step5l(view);
	}
	public void reset(View view){
		fill(0, RubikColor.RED);
		fill(1, RubikColor.BLUE);
		fill(2, RubikColor.WHITE);
		fill(3, RubikColor.GREEN);
		fill(4, RubikColor.YELLOW);
		fill(5, RubikColor.ORANGE);

		count = 0;
		updateCount();
	}
	public void scramble(View view){
//		reset(view);
		for (int i = 0; i < 36; i++){
			action(view, i);
		}

		count = 0;
		updateCount();
	}
	public void flower(View view){
		action(view,0);		//top
		action(view,11);
		action(view,1);		//front
		action(view,9);

		action(view,2);		//sides
		action(view,10);
		action(view,1);		//front
		action(view,9);

		action(view,2);		//sides
		action(view,10);
		action(view,0);		//top
		action(view,11);
/* * /
		action(view,0);
		action(view,0);
		action(view,11);
		action(view,11);
		action(view,1);
		action(view,1);
		action(view,9);
		action(view,9);
		action(view,2);
		action(view,2);
		action(view,10);
		action(view,10);
/* */
	}
	public void twist(View view){
		action(view,1);	
		action(view,2);
		action(view,3);
		action(view,4);
	}
	public void twist2(View view){
		for(int i = 0; i < 15; i++){
			twist(view);
		}
	}
}