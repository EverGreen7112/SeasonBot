package org.usfirst.frc.team7112.robot;

import java.util.List;

import edu.wpi.first.wpilibj.Joystick;

enum LogitechKeys {
	Y(4),
	X(3),
	B(2),
	A(1),
	RB(6),
	LB(5);
	
	public final int port;
	
	private LogitechKeys(int port){
		this.port = port;
	}
}

public class SmartJoystick {
	
	private List<Joystick> allJoysticks;
	
	private Joystick nativeJoystick;
	
	/**
	 * 
	 * 
	 * @param nativeJoystickPort - the physical joystick port
	 */
	public SmartJoystick(int nativeJoystickPort){
		
		nativeJoystick = new Joystick(nativeJoystickPort);
		
	}
	
	public Joystick getPreset(String preset){
		return allJoysticks.get(LogitechKeys.valueOf(preset).port);
	} 
	
	public void switchToPreset(int preset){
		
	}
	
}
