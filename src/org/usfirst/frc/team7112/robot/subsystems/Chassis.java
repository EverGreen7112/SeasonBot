package org.usfirst.frc.team7112.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Left;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Right;

import org.usfirst.frc.team7112.robot.commands.chassis.ArcadeDrive;

import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Left_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Left_B;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Right_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Right_B;

/**
 * Chassis 
 * @author Maarahot
 *
 */
public class Chassis extends Subsystem {

	private SpeedController Talon_Left;
	private SpeedController Talon_Right;
	
	private static Chassis instance;
		
	private Encoder encLeft, encRight;
	
	private AnalogGyro gyro;
	
	private DifferentialDrive Driver;
	private static double driveMultiplier;

	private Chassis() {
		//encoders
		encLeft = new Encoder(Chassis_Encoder_Left_A, Chassis_Encoder_Left_B);
		encRight = new Encoder(Chassis_Encoder_Right_A, Chassis_Encoder_Right_B,true);
		encLeft.setDistancePerPulse(0); //temp
		encRight.setDistancePerPulse(0); //temp
		encLeft.reset();
		encRight.reset();
		//gyro
		gyro = new AnalogGyro(0); // temp
		Talon_Left = new WPI_TalonSRX(Chassis_Talon_Left);
		Talon_Right = new WPI_TalonSRX(Chassis_Talon_Right);
		Driver = new DifferentialDrive(Talon_Left, Talon_Right);
		driveMultiplier = 0.5;
		//
		}
	
	public double getDriveMultiplier() {
		return driveMultiplier;
	}

	public void setDriveMultiplier(double mult) {
		driveMultiplier = mult;
	}
	
	// getters for sensors
	public double getDistance() {
		return (encLeft.getDistance() + encRight.getDistance()) / 2; //maybe + instead of -
	}

	public double getSpeed() {
		return (encLeft.getRate() + encRight.getRate()) / 2;// maybe + instead of -
	}
	
	public double getSpeedL() {
		return encRight.getRate();
	}
	
	public double getSpeedR() {
		return encLeft.getRate();
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	// reset methods for sensors
	public void resetEncoders() {
		encLeft.reset();
		encRight.reset();
	}
	
	public void resetGyro() {
		gyro.reset();
	}

	public static final void init() {
		instance = new Chassis();
	}

	public static final Chassis getInstance() {
		return instance;
	}

	public void arcadeDrive(double forward, double side) {
		Driver.arcadeDrive(forward, side);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());

	}

}
