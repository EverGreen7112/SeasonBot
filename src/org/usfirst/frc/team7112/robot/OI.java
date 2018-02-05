/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7112.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private static OI instance;

	// joysticks
	public Joystick JS = new Joystick(0);
	Button buttonX = new JoystickButton(JS, 3); //
	Button buttonB = new JoystickButton(JS, 2); //
	Button buttonLB = new JoystickButton(JS, 5); //
	Button buttonRB = new JoystickButton(JS, 6); //
	
	//creates an instance of OI
	public static final void init() {
		instance = new OI();
	}
	
	//returns the current instance of OI
	public static final OI getInstance() {
		return instance;
	}
	
	public Button Get_LB_Button(){
		return buttonLB;
	}
	
	public Button Get_RB_Button(){
		return buttonRB;
	}
	
	//returns joystick X axis
	public double Get_X_Axis() {
		return JS.getRawAxis(0);
	}
	
	//returns joystick Y axis
	public double Get_Y_Axis() {
		return JS.getRawAxis(1);
	}
	
	public double get_LT_Axis(){
		return JS.getRawAxis(2);
	}
	
	public double get_RT_Axis(){
		return JS.getRawAxis(3);
	}

	
	public int GetPOV(){
		return JS.getPOV(0);
	}
	
	public Button Get_X_Button(){
		return buttonX;
	}
	
	public Button Get_B_Button(){
		return buttonB;
	}
}
