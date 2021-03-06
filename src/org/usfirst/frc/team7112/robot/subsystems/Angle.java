package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Talon;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static org.usfirst.frc.team7112.robot.RobotMap.Angle_MicroSwitch;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Encoder_A;
import static org.usfirst.frc.team7112.robot.RobotMap.Angle_Encoder_B;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Angle extends Subsystem {

	private static Angle instance;
	private Encoder encoder;
	private SpeedController motor;
	private DigitalInput microSwitch;
	private static final double kSpeedModifier = 0.86; //temp
	private static final double kDistancePerPulse = 0.0304878049; //degrees per round: 0.15697
	private static final double kGoalAngle = 72; //temp
	private static final double kStartingAngle = 80;
	
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
	 * @Returns the state of the micro switch
	 * @returns True if the switch is pressed, otherwise will return false
	 */
	public boolean isPressed(){
		return microSwitch.get();
	}
	
	/**
	 * @Sets the power to the Angle motor
	 * @param Power - the power: between 1 to -1
	 */
    public void setMotorPower(double Power) {
    	motor.set(Power);
    }
    
    /**
     * @returns the current angle by the encoder
     * @returns the current angle
     */
    public double getCurrentAngle(){
    	return encoder.getDistance();
    }
    
    /**
     * @returns the direction of the angle, UP or Down(+ or -)
     */

    public boolean getCurrentDirection(){
    	return encoder.getDirection();
    }
    
    /**
     * resets the Angle encoder
     */
    public void reset(){
    	encoder.reset();
    }
   
    /**
     * @returns speed modifier
     */
	public double getSpeedModifier() {
		return kSpeedModifier;
	}

	/**
	 * @Stops angle's motor
	 */
	public void stopMotor(){
		motor.stopMotor();
	}
	
	/**
	 * @returns angle's goal
	 */
	public double getGoalAngle() {
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

