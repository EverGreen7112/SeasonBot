package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Talon;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_MicroSwitch;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Angle extends Subsystem {

	private static Angle instance;
	private Encoder m_encoder;
	private SpeedController m_motor;
	private DigitalInput m_microSwitch;
	
	private Angle(){
		m_motor = new WPI_TalonSRX(Angle_Talon);
		m_microSwitch = new DigitalInput(Angle_MicroSwitch);
	}
	
	public static final void init() {
		instance = new Angle();
	}
	
	

	//sets the power to the motor
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }
	
	public static final Angle getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

