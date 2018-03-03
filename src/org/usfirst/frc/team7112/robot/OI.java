/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7112.robot;

import org.usfirst.frc.team7112.robot.Utils.ResetDrivingEncoders;
import org.usfirst.frc.team7112.robot.commands.angle.AngleClose;
import org.usfirst.frc.team7112.robot.commands.angle.AngleOpen;
import org.usfirst.frc.team7112.robot.commands.angle.OpenAngleStartingPoint;
import org.usfirst.frc.team7112.robot.commands.angle.StopAngle;
import org.usfirst.frc.team7112.robot.commands.auto.TestAuto;
import org.usfirst.frc.team7112.robot.commands.chassis.AdvancedDriveByDistance;
import org.usfirst.frc.team7112.robot.commands.chassis.ChangeSpeedModifier;
import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.commands.chassis.SwitchPerspectives;
import org.usfirst.frc.team7112.robot.commands.claw.CloseClaw;
import org.usfirst.frc.team7112.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team7112.robot.commands.claw.StopClaw;
import org.usfirst.frc.team7112.robot.commands.climber.PullRope;
import org.usfirst.frc.team7112.robot.commands.climber.SlowClimb;
import org.usfirst.frc.team7112.robot.commands.climber.StopClimberMotors;
import org.usfirst.frc.team7112.robot.commands.climber.StopTape;
import org.usfirst.frc.team7112.robot.commands.climber.TapeClose;
import org.usfirst.frc.team7112.robot.commands.climber.TapeOpen;
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
	Button buttonStart;

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
		JS = new Joystick(0);
		DrivingJS = new Joystick(1);
		
		
		buttonX = new JoystickButton(JS, 1); //
		buttonB = new JoystickButton(JS, 3); //
		buttonLB = new JoystickButton(JS, 5); //
		buttonRB = new JoystickButton(JS, 6); //	
		buttonY = new JoystickButton(JS, 4);
		buttonA = new JoystickButton(JS, 2);
		buttonLT = new JoystickButton(JS, 7);
		buttonStart = new JoystickButton(JS, 10);
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
		/*DrivingJS key bindings*/
		
		//If pressed increases robot's speed
		buttonTrigger.whenPressed(new ChangeSpeedModifier(Chassis.getInstance().getFastDriveMultiplier()));
		//When released return robo's speed to normal
		buttonTrigger.whenReleased(new ChangeSpeedModifier(Chassis.getInstance().getDriveMultiplier()));
		
		//If pressed decreases robot's speed
		buttonThumb.whenPressed(new ChangeSpeedModifier(Chassis.getInstance().getSlowDriveMultiplier()));
		//When released return robo's speed to normal
		buttonThumb.whenReleased(new ChangeSpeedModifier(Chassis.getInstance().getDriveMultiplier()));
		
		//If pressed closes claw on the CUBE
		button5.whenPressed(new CloseClaw());
		//When released stops claw movement
		button5.whenReleased(new StopClaw());
		
		//If pressed opens claw
		button6.whenPressed(new OpenClaw());
		//When released stops claw movement
		button6.whenReleased(new StopClaw());
		
		//If pressed brings tapes down
		button7.whenPressed(new TapeClose());
		//When released stops to pull the tapes
		button7.whenReleased(new StopTape());
		
		//If pressed brings tapes up
		button8.whenPressed(new TapeOpen());
		//When released stops to push the tapes
		button8.whenReleased(new StopTape());
		
		//If pressed switches perspective, Now BACK is FOWARD and the opposite
		button12.whenPressed(new SwitchPerspectives());
		
		//If pressed resets encoders information
		button11.whenPressed(new ResetDrivingEncoders());
		
		//If pressed activate drum
		button9.whenPressed(new PullRope());
		//When released stops drum
		button9.whenReleased(new StopClimberMotors());
		
		//Drive 3Meters Autonomous
		button10.whenPressed(new DriveByDistance(3.04));

		//OperatorJS key bindings
		
		
		
		//Brings up the angle to the start point. DO IT BEFORE EVEREY ROUND!!
		buttonStart.whenPressed(new OpenAngleStartingPoint());
		//Stops angle movement
		buttonStart.whenReleased(new StopAngle());
		
		//Brings up the angle to the switches high
		buttonY.whenPressed(new AngleOpen());
		//Stops angle movement
		buttonY.whenReleased(new StopAngle());
		
		//Brings angle down
		buttonA.whenPressed(new AngleClose());
		//Stops angle movement
		buttonA.whenReleased(new StopAngle());
		
		//Opens the claw
		buttonX.whenPressed(new OpenClaw());
		//Stops claw opening
		buttonX.whenReleased(new StopClaw());
		
		//Closes the claw and catches the cube 
		buttonB.whenPressed(new CloseClaw());
		//Stops claw movement
		buttonB.whenReleased(new StopClaw());
		
		//Starts drum movement, a FAST movement.
		buttonLB.whenPressed(new PullRope());
		//Stops drum movement
		buttonLB.whenReleased(new StopClimberMotors());
		
		//Starts drum movement, a SLOW movement.
		buttonRB.whenPressed(new SlowClimb());
		//Stops drum movement
		buttonRB.whenReleased(new StopClimberMotors());
		
		
	}
	/**
	 * @returns buttonTrigger
	 */
	
	public Button Get_LB_Button(){
		return buttonLB;
	}

	public Button Get_RB_Button(){
		return buttonRB;
	}

	
	public Button getButtonTrigger() {
		return buttonTrigger;
	}

	/**
	 * @returns buttonThumb
	 */
	public Button getButtonThumb() {
		return buttonThumb;
	}

	/**
	 * @returns button5
	 */
	public Button getButton5() {
		return button5;
	}

	/**
	 * @returns button6
	 */
	public Button getButton6() {
		return button6;
	}

	/**
	 * @returns button7
	 */
	public Button getButton7() {
		return button7;
	}

	/**
	 * @returns button8
	 */
	public Button getButton8() {
		return button8;
	}

	/**
	 * @returns button9
	 */
	public Button getButton9() {
		return button9;
	}

	/**
	 * @returns button10
	 */
	public Button getButton10() {
		return button10;
	}

	/**
	 * @returns button11
	 */
	public Button getButton11() {
		return button11;
	}

	/**
	 * @returns button12
	 */
	public Button getButton12() {
		return button12;
	}

	/**
	 * @returns JS X Axis
	 */
	public double Get_X_Axis() {
		return JS.getRawAxis(0);
	}

	/**
	 * @returns JS Y Axis
	 */
	public double Get_Y_Axis() {
		return JS.getRawAxis(1);
	}

	/**
	 * @returns current state of JS Left Trigger
	 */
	public double get_LT_Axis(){
		return JS.getRawAxis(2);
	}

	/**
	 * @returns current state of JS Right Trigger
	 */
	public double get_RT_Axis(){
		return JS.getRawAxis(3);
	}

	/**
	 * @returns DrivingJS X Axis
	 */
	public double GetXAxis() {
		return DrivingJS.getRawAxis(0);
	}

	/**
	 * @returns DrivingJS Y Axis
	 */
	public double GetYAxis() {
		return -DrivingJS.getRawAxis(1);
	}

	/**
	 * @returns DrivingJS Z Axis (rotate)
	 */
	public double GetRotateAxis(){
		return DrivingJS.getRawAxis(2);
	}

	/**
	 * @returns current state of the DrivingJS POV
	 */
	public int GetDrivePOV(){
		return DrivingJS.getPOV(0);
	}

	/**
	 * @returns current state of the JS POV
	 */
	public int GetPOV(){
		return JS.getPOV(0);
	}

	/**
	 * @returns X Button
	 */
	public Button GetXButton(){
		return buttonX;
	}

	/**
	 * @returns B Button
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
