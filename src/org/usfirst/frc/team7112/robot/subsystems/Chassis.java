package org.usfirst.frc.team7112.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Left;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Talon_Right;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Left_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Left_B;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Right_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Chassis_Encoder_Right_B;





import org.usfirst.frc.team7112.robot.commands.Chassis.ArcadeDrive;

public class Chassis extends PIDSubsystem {

	private SpeedController m_Talon_Left;
	private SpeedController m_Talon_Right;
	
	private static Chassis instance;
	
	private static double kP = 0, kI = 0, kD = 0;
	
	private Encoder m_encLeft, m_encRight;
	
	private AnalogGyro m_gyro;
	
	private DifferentialDrive m_Driver;
	private double driveMultiplier;

	private Chassis() {
		super("Chassis", kP,kI,kD);
		//encoders
		m_encLeft = new Encoder(Chassis_Encoder_Left_A, Chassis_Encoder_Left_B);
		m_encRight = new Encoder(Chassis_Encoder_Right_A, Chassis_Encoder_Right_B);
		m_encLeft.setDistancePerPulse(0); //temp
		m_encRight.setDistancePerPulse(0); //temp
		//gyro
		m_gyro = new AnalogGyro(0); // temp
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
	
	// getters for sensors
		public double getDistance() {
			return (m_encLeft.getDistance() + m_encRight.getDistance()) / 2; //maybe + instead of -
		}

		public double getSpeed() {
			return (m_encLeft.getRate() + m_encRight.getRate()) / 2;// maybe + instead of -
		}
		
		public double getSpeedL() {
			return m_encRight.getRate();
		}
		
		public double getSpeedR() {
			return m_encLeft.getRate();
		}
		
		public double getAngle() {
			return m_gyro.getAngle();
		}
		
		// reset methods for sensors
		public void resetEncoders() {
			m_encLeft.reset();
			m_encRight.reset();
		}
		
		public void resetGyro() {
			m_gyro.reset();
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

	@Override
	protected double returnPIDInput() {
		 return getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		
	}

}
