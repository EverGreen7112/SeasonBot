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
	 
	//Chassis Talons
	public static final int 
			Chassis_Talon_Left = 0,
			Chassis_Talon_Right = 1;
	
	//Pliers Talon
	public static final int
			Pliers_Talon = 2;
	
	//Pliers MicroSwitches
	public static final int 
			Pliers_MicroSwitch_In = 0,
			Pliers_MicroSwitch_Out = 1;
}
