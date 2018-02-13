package org.usfirst.frc.team7112.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;

import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Left;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Right;

import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.commands.temp;
import org.usfirst.frc.team7112.robot.commands.testing;
import org.usfirst.frc.team7112.robot.commands.chassis.ArcadeDrive;
import org.usfirst.frc.team7112.robot.commands.chassis.ArcadeDrivee;

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
	private static final double kDistancePerPulse = 1;//0.0447; //temp

	private Chassis() {
		//encoders
		encLeft = new Encoder(Chassis_Encoder_Left_A, Chassis_Encoder_Left_B);
		encRight = new Encoder(Chassis_Encoder_Right_A, Chassis_Encoder_Right_B);
		encLeft.setReverseDirection(true);
		encLeft.setDistancePerPulse(kDistancePerPulse);
		encRight.setDistancePerPulse(kDistancePerPulse);
		encLeft.reset();
		encRight.reset();
		//gyro
		gyro = new AnalogGyro(0); // temp
		//Talons
		Talon_Left = new WPI_TalonSRX(Chassis_Talon_Left);
		Talon_Right = new WPI_TalonSRX(Chassis_Talon_Right);
		Driver = new DifferentialDrive(Talon_Left, Talon_Right);
		driveMultiplier = 0.5;
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
	
	public void test(){
		Talon_Left.set(0.2);
		Talon_Right.set(0.2);
	}
	
	/**
	 * Returns the current distance that the right side motors traveled via the encoder
	 * @return The current distance that the right encoder recorded
	 */
	public double getDistanceR() {
		return encRight.getDistance();
	}
	
	/**
	 * Returns the current distance that the left side motors traveled via the encoder
	 * @return The current distance that the left encoder recorded
	 */
	public double getDistanceL() {
		return encLeft.getDistance();
	}
	
	/**
	 * Returns the angle that the robot is at since the gyro was reset
	 * @return The angle that the robot is at
	 */
	public double getAngle() {
		return gyro.getAngle();
	}
	
	/**
	 * Resets the driving encoders
	 */
	public void resetEncoders() {
		encLeft.reset();
		encRight.reset();
	}
	
	/**
	 * Resets the gyro
	 */
	public void resetGyro() {
		gyro.reset();
	}

	public static final void init() {
		instance = new Chassis();
    	OI.getInstance().GetBButton().whenPressed(new ArcadeDrivee());
    	OI.getInstance().getButton10().whenPressed(new temp());
    	OI.getInstance().getButton11().whenPressed(new testing(5));
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
