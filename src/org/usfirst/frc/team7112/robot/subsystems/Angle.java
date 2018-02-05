package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Talon;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_MicroSwitch;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Encoder_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Encoder_B;

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
	private Encoder encoder;
	private SpeedController motor;
	private DigitalInput microSwitch;
	private static double kSpeedModifier = 0.5; //temp
	private static double kSlowModifier = 0.3; //temp
	private static int kDistancePerPulse = 0; //temp
	private static double kSlowingAngle = 30; //temp
	
	private Angle(){
		//Talon
		motor = new WPI_TalonSRX(Angle_Talon);
		//MicroSwitche
		microSwitch = new DigitalInput(Angle_MicroSwitch);
		//Encoder
		encoder = new Encoder(Angle_Encoder_A,Angle_Encoder_B);
		encoder.setDistancePerPulse(kDistancePerPulse);
		reset();
	}
	
	//returns the state of the microSwitch
	public boolean isPressed(){
		return microSwitch.get();
	}
	
	/**
	 * Sets the power to the Angle motor
	 * @param Power - the power: between 1 to -1
	 */
    public void setMotorPower(double Power) {
    	motor.set(Power);
    }
    
	/**
	 * returns the slow modifier for the Angle
	 * @return the slow modifier
	 */
    public double getSlowModifier(){
    	return kSlowModifier;
    }
    
    /**
     * returns the current angle by the encoder
     * @return the current angle
     */
    public double getCurrentAngle(){
    	return encoder.get();
    }
    
    /**
     * resets the Angle encoder
     */
    public void reset(){
    	encoder.reset();
    }
    
    /**
     * returns the angle that the Angle will start slowing at
     */
    public double getSlowingAngle(){
    	return kSlowingAngle;
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

	public double getSpeedModifier() {
		return kSpeedModifier;
	}
}

