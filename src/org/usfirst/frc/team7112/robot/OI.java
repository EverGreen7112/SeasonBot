/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7112.robot;

import org.usfirst.frc.team7112.robot.commands.ResetDrivingEncoders;
import org.usfirst.frc.team7112.robot.commands.angle.AngleClose;
import org.usfirst.frc.team7112.robot.commands.angle.AngleOpen;
import org.usfirst.frc.team7112.robot.commands.angle.StopAngle;
import org.usfirst.frc.team7112.robot.commands.chassis.ChangeSpeedModifier;
import org.usfirst.frc.team7112.robot.commands.chassis.SwitchPerspectives;
import org.usfirst.frc.team7112.robot.commands.claw.CloseClaw;
import org.usfirst.frc.team7112.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team7112.robot.commands.claw.StopClaw;
import org.usfirst.frc.team7112.robot.commands.climber.PullRope;
import org.usfirst.frc.team7112.robot.commands.climber.StopClimberMotors;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private static OI instance;

	// joysticks
	public Joystick JS;
	public Joystick DrivingJS;

	Button buttonX; //
	Button buttonB; //
	Button buttonLB; //
	Button buttonRB; //	
	Button buttonY;
	Button buttonA;
	Button buttonLT;

	/**
	 * Boosts the robot's speed
	 */
	Button buttonTrigger;
	/**
	 * Slows the robot or brakes
	 */
	Button buttonThumb;
	/**
	 * Closes the claw or nothing for now, POV might be used instead
	 */
	Button button5;
	/**
	 * Opens the claw or nothing for now, POV might be used instead
	 */
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button10;
	Button button11;
	Button button12;

	private OI(){
		JS = new Joystick(1);
		DrivingJS = new Joystick(0);

		buttonX = new JoystickButton(JS, 1); //
		buttonB = new JoystickButton(JS, 3); //
		buttonLB = new JoystickButton(JS, 5); //
		buttonRB = new JoystickButton(JS, 6); //	
		buttonY = new JoystickButton(JS, 4);
		buttonA = new JoystickButton(JS, 2);
		buttonLT = new JoystickButton(JS, 7);

		buttonTrigger = new JoystickButton(DrivingJS, 1);
		buttonThumb = new JoystickButton(DrivingJS, 2);
		button5 = new JoystickButton(DrivingJS, 5);
		button6 = new JoystickButton(DrivingJS, 6);
		button7 = new JoystickButton(DrivingJS, 7);
		button8 = new JoystickButton(DrivingJS, 8);
		button9 = new JoystickButton(DrivingJS, 9);
		button10 = new JoystickButton(DrivingJS, 10);
		button11 = new JoystickButton(DrivingJS, 11);
		button12 = new JoystickButton(DrivingJS, 12);
	}

	public void BindKeys(){
		//DrivingJS key bindings
		buttonTrigger.whenPressed(new ChangeSpeedModifier(Chassis.getInstance().getFastDriveMultiplier()));
		buttonTrigger.whenReleased(new ChangeSpeedModifier(Chassis.getInstance().getDriveMultiplier()));
		buttonThumb.whenPressed(new ChangeSpeedModifier(Chassis.getInstance().getSlowDriveMultiplier()));
		buttonThumb.whenReleased(new ChangeSpeedModifier(Chassis.getInstance().getDriveMultiplier()));
		button5.whenPressed(new CloseClaw());
		button5.whenReleased(new StopClaw());
		button6.whenPressed(new OpenClaw());
		button6.whenReleased(new StopClaw());
		button8.whenPressed(new SwitchPerspectives());
		button11.whenPressed(new ResetDrivingEncoders());

		//OperatorJS key bindings
		buttonY.whenPressed(new AngleOpen());
		buttonY.whenReleased(new StopAngle());
		buttonA.whenPressed(new AngleClose());
		buttonA.whenReleased(new StopAngle());
		buttonX.whenPressed(new OpenClaw());
		buttonX.whenReleased(new StopClaw());
		buttonB.whenPressed(new CloseClaw());
		buttonB.whenReleased(new StopClaw());
		buttonLB.whenPressed(new PullRope());
		buttonLB.whenReleased(new StopClimberMotors());
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

	//creates an instance of OI
	public static final void init() {
		instance = new OI();
		}

	//returns the current instance of OI
	public static final OI getInstance() {
		return instance;
	}
}
