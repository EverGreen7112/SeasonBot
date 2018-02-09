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
	private static final double kSpeedModifier = 0.5; //temp
	private static final int kDistancePerPulse = 0; //temp
	private static final double kGoalAngle = 0; //temp
	
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
	
	/**
	 * Returns the state of the micro switch
	 * @return True if the switche is pressed, otherwise will return false
	 */
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
     * returns the speed modifier
     * @return the speed modifier
     */
	public double getSpeedModifier() {
		return kSpeedModifier;
	}

	/**
	 * Stops the angle motor
	 */
	public void stopMotor(){
		motor.stopMotor();
	}
	
	/**
	 * returns the goal angle
	 * @return the goal angle
	 */
	public static double getkGoalAngle() {
		return kGoalAngle;
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


}

