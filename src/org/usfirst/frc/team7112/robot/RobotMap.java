/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7112.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	 
	//---------Chassis---------
	
	/**
	 * The chassis ports.
	 * 
	 * @see {@link org.usfirst.frc.team7112.robot.subsystems.Chassis Chassis}
	 */
	public static final int 
			Chassis_Talon_Left = 0,
			Chassis_Talon_Right = 1;
	
	//Encoders
	public static final int
			Chassis_Encoder_Left_A = 3,
			Chassis_Encoder_Left_B = 4,
			Chassis_Encoder_Right_A = 5,
			Chassis_Encoder_Right_B = 6;
	
	
	//---------Claw---------
	
	//Talon
	public static final int
			Claw_Talon = 2;
	
	//MicroSwitches
	public static final int 
			Claw_MicroSwitch_In = 0,
			Claw_MicroSwitch_Out = 1;
	
	//---------Climber---------
	
	//Talons
	public static final int
			Climber_Rope_Talon = 2,
			Climber_Tape_Talon = 3;
	
	//---------Angle---------
	
	//Talon
	public static final int
			Angle_Talon = 4;
	
	//MicroSwitch
	public static final int
			Angle_MicroSwitch = 2;
	
	//Encoder
	public static final int
			Angle_Encoder_A = 7,
			Angle_Encoder_B = 8;
}
