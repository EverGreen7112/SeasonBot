package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_FrontSpark;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_BackSpark;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Tape_Spark;

import org.usfirst.frc.team7112.robot.commands.climber.UseRope;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Climber extends Subsystem {
	
	
		private static Climber instance;
		private SpeedController tapeMotor;
		private SpeedController ropeFrontMotor;
		private SpeedController ropeBackMotor;
		private final double ropePowerModifier = 0.7, tapePowerModifier= 0.4;
	
		private Climber(){
			ropeFrontMotor = new Spark(Climber_Rope_FrontSpark);
			ropeBackMotor = new Spark(Climber_Rope_BackSpark);
			tapeMotor = new Spark(Climber_Tape_Spark);
			ropeFrontMotor.setInverted(true);
			ropeBackMotor.setInverted(true);
		}
		
		//sets the power to the rope motor
	    public void setRopeMotorPower(double power) {
	    	ropeFrontMotor.set(power);
	    	//ropeBackMotor.set(ControlMode.Follower,Climber_Rope_FrontSpark);
	    }
	    
	    //sets the power to the tape motors
	    public void setTapeMotorsPower(double power){
	    	tapeMotor.set(power);
	    }
	    
	    //stops the tape motors
	    public void stopTapeMotors(){
	    	tapeMotor.stopMotor();
	    }
	    
	    //stops the tape motors
	    public void stopRopeMotors(){
	    	ropeFrontMotor.stopMotor();
	    	ropeBackMotor.stopMotor();
	    }
	    
	    /**
	     * returns the power modifier of the rope motors
	     * @return the rope power modifier
	     */
	    public double getRopePowerModifier(){
	    	return ropePowerModifier;
	    }
	    
	    /**
	     * returns the power modifier of the tape motors
	     * @return the tape power modifier
	     */
	    public double getTapePowerModifier(){
	    	return tapePowerModifier;
	    }

	    public static final void init() {
			instance = new Climber();
			}	
	    
	 //returns the instance of the climber
		public static final Climber getInstance() {
			return instance;
		}
	

    public void initDefaultCommand() {
        setDefaultCommand(new UseRope());
    }

	
}

