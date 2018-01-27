package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Talon;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_MicroSwitch;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Angle extends PIDSubsystem{

	private static Angle instance;
	private Encoder m_encoder;
	private static double kP = 0, kI = 0, kD = 0;
	private SpeedController m_motor;
	private DigitalInput m_microSwitch;
	private double m_slowModifier = 0.3;
	
	private Angle(){
		super("Chassis", kP,kI,kD);
		m_motor = new WPI_TalonSRX(Angle_Talon);
		m_microSwitch = new DigitalInput(Angle_MicroSwitch);
	}
	
	//returns the state of the microSwitch
	public boolean isPressed(){
		return m_microSwitch.get();
	}
	
	//sets the power to the motor
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }
	
	public static final void init() {
		instance = new Angle();
	}
	
	public static final Angle getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

