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
	public Joystick JS = new Joystick(1);
	Button buttonX = new JoystickButton(JS, 1); //
	Button buttonB = new JoystickButton(JS, 3); //
	Button buttonLB = new JoystickButton(JS, 5); //
	Button buttonRB = new JoystickButton(JS, 6); //	
	
	public Joystick DrivingJS = new Joystick(0);
	/**
	 * Boosts the robot's speed
	 */
	Button buttonTrigger = new JoystickButton(DrivingJS, 1);
	/**
	 * Slows the robot or brakes
	 */
	Button buttonThumb = new JoystickButton(DrivingJS, 2);
	/**
	 * Closes the claw or nothing for now, POV might be used instead
	 */
	Button button5 = new JoystickButton(DrivingJS, 5);
	/**
	 * Opens the claw or nothing for now, POV might be used instead
	 */
	Button button6 = new JoystickButton(DrivingJS, 6);
	Button button7 = new JoystickButton(DrivingJS, 7);
	Button button8 = new JoystickButton(DrivingJS, 8);
	Button button9 = new JoystickButton(DrivingJS, 9);
	Button button10 = new JoystickButton(DrivingJS, 10);
	Button button11 = new JoystickButton(DrivingJS, 11);
	Button button12 = new JoystickButton(DrivingJS, 12);
	
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
	
	/**
	 * @return the buttonTrigger
	 */
	public Button getButtonTrigger() {
		return buttonTrigger;
	}

	/**
	 * @return the buttonThumb
	 */
	public Button getButtonThumb() {
		return buttonThumb;
	}

	/**
	 * @return the button5
	 */
	public Button getButton5() {
		return button5;
	}

	/**
	 * @return the button6
	 */
	public Button getButton6() {
		return button6;
	}

	/**
	 * @return the button7
	 */
	public Button getButton7() {
		return button7;
	}

	/**
	 * @return the button8
	 */
	public Button getButton8() {
		return button8;
	}

	/**
	 * @return the button9
	 */
	public Button getButton9() {
		return button9;
	}

	/**
	 * @return the button10
	 */
	public Button getButton10() {
		return button10;
	}

	/**
	 * @return the button11
	 */
	public Button getButton11() {
		return button11;
	}

	/**
	 * @return the button12
	 */
	public Button getButton12() {
		return button12;
	}

	/**
	 * @return JS X Axis
	 */
	public double Get_X_Axis() {
		return JS.getRawAxis(0);
	}
	
	/**
	 * @return JS Y Axis
	 */
	public double Get_Y_Axis() {
		return JS.getRawAxis(1);
	}
	
	/**
	 * @return the current state of JS Left Trigger
	 */
	public double get_LT_Axis(){
		return JS.getRawAxis(2);
	}
	
	/**
	 * @return the current state of JS Right Trigger
	 */
	public double get_RT_Axis(){
		return JS.getRawAxis(3);
	}

	/**
	 * @return DrivingJS X Axis
	 */
	public double GetXAxis() {
		return DrivingJS.getRawAxis(0);
	}
	
	/**
	 * @return DrivingJS Y Axis
	 */
	public double GetYAxis() {
		return -DrivingJS.getRawAxis(1);
	}
	
	/**
	 * @return DrivingJS Z Axis (rotate)
	 */
	public double GetRotateAxis(){
		return DrivingJS.getRawAxis(2);
	}
	
	/**
	 * @return Driving Slider Axis
	 */
	public double GetSliderAxis(){
		return DrivingJS.getRawAxis(3);
	}
	
	/**
	 * @return the current state of the DrivingJS POV
	 */
	public int GetDrivePOV(){
		return DrivingJS.getPOV(0);
	}
	
	/**
	 * @return the current state of the JS POV
	 */
	public int GetPOV(){
		return JS.getPOV(0);
	}
	
	/**
	 * @return the X Button
	 */
	public Button GetXButton(){
		return buttonX;
	}
	
	/**
	 * @return the B Button
	 */
	public Button GetBButton(){
		return buttonB;
	}
}
