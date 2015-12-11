/**
 * EnumColor.java
 * TDWUK
 * 
 * Copyright (c) 2011, Markit On Demand, All rights reserved.
 */
package com.armadillo.rubik;

import java.util.Hashtable;

import android.graphics.Color;
import android.util.Log;

/**
 * @author john.pushnik
 * @since Jul 19, 2011
 *
 */
public enum RubikColor {
	RED("RED",0,Color.RED),
	BLUE("BLUE",1,Color.BLUE),
	YELLOW("YELLOW",2,Color.YELLOW),
	ORANGE("ORANGE",3,Color.rgb(255, 127, 0)),
	GREEN("GREEN",4,Color.GREEN),
	WHITE("WHITE",5,Color.WHITE),
	UNKNOWN("UNKNOWN",6,Color.BLACK);
	
	
	private String _colorName;
	private int _color;
	private int _id;
	private static RubikColor _opposite;

	private static String TAG = "EnumColor";
	private static Hashtable<String, RubikColor> stringToEnumColor;
	private static Hashtable<Integer, RubikColor> intToEnumColor;
	private static Hashtable<RubikColor, RubikColor> oppositeColor;

	RubikColor(String name, int id, int color){
		_colorName = name;
		_id = id;
		_color = color; 
	}

	public String colorName(){
		return _colorName;
	}
	public int color(){
		return _color;
	}

	private static void initialize(){
		stringToEnumColor = new Hashtable<String, RubikColor>();
		intToEnumColor = new Hashtable<Integer, RubikColor>();
		setOpposite(RED,ORANGE);
		setOpposite(YELLOW,WHITE);
		setOpposite(BLUE,GREEN);
		setOpposite(UNKNOWN,UNKNOWN);

		RubikColor[] values = RubikColor.values();
		for (int i = 0; i < values.length; i++){
			try {
				stringToEnumColor.put(values[i]._colorName, values[i]);
				intToEnumColor.put(values[i]._id, values[i]);
			} catch (Exception e) {
				Log.d(TAG, "-182. exception: " + e);
			}
			Log.d(TAG, "-184. values[" + i + "] quoteType: " + values[i]._colorName 
					+ "  description: " + values[i]._color);
		}
	}

	public static RubikColor colorFromInt(int color){
		if (intToEnumColor == null){
			initialize();
		}
		if (intToEnumColor.get(color) != null){
			return intToEnumColor.get(color);
		} else {
			return UNKNOWN;
		}
	}
	public static RubikColor colorFromInt(String color){
		if (stringToEnumColor == null){
			initialize();
		}
		return stringToEnumColor.get(color);
	}
	public static void setOpposite(RubikColor color1, RubikColor color2){
		color1.setOpposite(color2);
		color2.setOpposite(color1);
	}
	public static void setOpposite(RubikColor color){
		_opposite = color;
	}
	public static RubikColor opposite(RubikColor color){
		return oppositeColor.get(color);
	}
	public static RubikColor opposite(){
		return _opposite;
	}

}
