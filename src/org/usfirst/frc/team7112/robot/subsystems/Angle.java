package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Talon;

import org.usfirst.frc.team7112.robot.OI;

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
	private double m_slowModifier = 0.3;
	
	private Angle(){
		m_motor = new WPI_TalonSRX(Angle_Talon);
		m_microSwitch = new DigitalInput(Angle_MicroSwitch);
	}
	
	//returns the state of the microSwitch
	public boolean isNotPressed(){
		return m_microSwitch.get();
	}
	
	//sets the power to the motor
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }
    
    public double getSlow(){
    	return m_slowModifier;
    }
    
    public Encoder getEncoder(){
    	return m_encoder;
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

	public void stopMotor() {
		m_motor.stopMotor();
	}

	public boolean switchNotPressed_Open() {
		return OI.getInstance().Get_LB_Button().get();
	}

	public boolean switchNotPressed_Close() {
		return OI.getInstance().Get_RB_Button().get();
	}
}

