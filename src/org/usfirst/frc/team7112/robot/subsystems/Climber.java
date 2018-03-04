package org.usfirst.frc.team7112.robot.subsystems;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_FrontSpark;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_BackSpark;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Tape_Spark;

import org.usfirst.frc.team7112.robot.commands.climber.UseTape;

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
		private final double ropePowerModifier = 0.85, tapePowerModifierOpen = 0.75, tapePowerModifierClose = 0.65;
	
		private Climber(){
			//-----------sparks---------//
			ropeFrontMotor = new Spark(Climber_Rope_FrontSpark);
			ropeBackMotor = new Spark(Climber_Rope_BackSpark);
			tapeMotor = new Spark(Climber_Tape_Spark);
			
			ropeFrontMotor.setInverted(true);
			ropeBackMotor.setInverted(true);
		}
		
		//Sets power to the rope motor
	    public void setRopeMotorPower(double power) {
	    	ropeFrontMotor.set(power);
	    	ropeBackMotor.set(power);
	    }
	    
	    //Sets power to the tape motors
	    public void setTapeMotorsPower(double power){
	    	tapeMotor.set(power);
	    }
	    
	    //Stops tapes's motor
	    public void stopTapeMotors(){
	    	tapeMotor.stopMotor();
	    }
	    
	    /**
	     * @returns rope's power modifier
	     */
	    public double getRopePowerModifier(){
	    	return ropePowerModifier;
	    }
	    
	    /**
	     * @returns tapes's power modifier for open them
	     */
	    public double getTapePowerModifierOpen(){
	    	return tapePowerModifierOpen;
	    }
	    
	    public void stopRopeMotors(){
	    	ropeFrontMotor.stopMotor();
			ropeBackMotor.stopMotor();
	    }
	    
	    /**
	     * @returns tapes's power modifier for close them
	     */
	    public double getTapePowerModifierClose(){
	    	return tapePowerModifierClose;
	    }

	    public static final void init() {
			instance = new Climber();
			}	
	    
	 //returns the instance of the climber
		public static final Climber getInstance() {
			return instance;
		}
	

    public void initDefaultCommand() {
        setDefaultCommand(new UseTape());
    }
    
}

