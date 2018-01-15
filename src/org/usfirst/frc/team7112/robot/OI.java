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
	Button button_X = new JoystickButton(JS, 2);
	Button button_B = new JoystickButton(JS, 1);
	
	//creates an instance of OI
	public static final void init() {
		instance = new OI();
	}
	
	//returns the current instance of OI
	public static final OI getInstance() {
		return instance;
	}
	
	
	
	//returns joystick X axis
	public double GetXAxis() {
		return JS.getRawAxis(0);
	}
	//returns joystick Y axis
	public double GetYAxis() {
		return JS.getRawAxis(1);
	}

	public Button GetXButton(){
		return button_X;
	}
	
	public Button GetBButton(){
		return button_B;
	}
}
