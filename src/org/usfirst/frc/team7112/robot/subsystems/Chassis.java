package org.usfirst.frc.team7112.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;

import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Left;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Right;

import org.usfirst.frc.team7112.robot.commands.Chassis.ArcadeDrive;

public class Chassis extends Subsystem {

	private SpeedController m_Talon_Left;
	private SpeedController m_Talon_Right;
	
	private static Chassis instance;
	
	private DifferentialDrive m_Driver;
	private double driveMultiplier;

	private Chassis() {
		m_Talon_Left = new WPI_TalonSRX(Chassis_Talon_Left);
		m_Talon_Right = new WPI_TalonSRX(Chassis_Talon_Right);
		m_Driver = new DifferentialDrive(m_Talon_Left, m_Talon_Right);
		driveMultiplier = 0.5;
		}

	public double getDriveMultiplier() {
		return driveMultiplier;
	}

	public void setDriveMultiplier(double mult) {
		driveMultiplier = mult;
	}

	public static final void init() {
		instance = new Chassis();
	}

	public static final Chassis getInstance() {
		return instance;
	}

	public void arcadeDrive(double forward, double side) {
		m_Driver.arcadeDrive(forward, side);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());

	}

}
