package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Tape_Talon;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_Talon;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	
		private static Climber instance;
		private WPI_TalonSRX m_Tape_Motor;
		private WPI_TalonSRX m_Rope_Motor;
	
		private Climber(){
			m_Rope_Motor = new WPI_TalonSRX(Climber_Rope_Talon);
			m_Tape_Motor = new WPI_TalonSRX(Climber_Tape_Talon);
		}
		
		//sets the power to the motor
	    public void setRopeMotorPower(double power) {
	    	m_Rope_Motor.set(power);
	    }
	    
	    public void setTapeMotorPower(double power){
	    	m_Tape_Motor.set(power);
	    }
	    
	    //stops the rope motor
	    public void stopRopeMotor(){
	    	m_Rope_Motor.stopMotor();
	    }
	    
	    public void stopTapeMotor(){
	    	m_Tape_Motor.stopMotor();
	    }
	    
	    public static final void init() {
			instance = new Climber();
		}
	    
	 //returns the instance of the climber
		public static final Climber getInstance() {
			return instance;
		}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

