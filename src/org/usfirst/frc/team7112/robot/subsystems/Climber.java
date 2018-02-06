package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Rope_Talon;
import static org.usfirst.frc.team7112.robot.RobotMap.Climber_Tape_Talon;

import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.commands.climber.StopTape;
import org.usfirst.frc.team7112.robot.commands.climber.TapeClose;
import org.usfirst.frc.team7112.robot.commands.climber.TapeOpen;
import org.usfirst.frc.team7112.robot.commands.climber.UseRope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Climber extends Subsystem {
	
	
		private static Climber instance;
		private SpeedController Tape_Motor;
		private SpeedController Rope_Motor;
		private double ropePowerModifier, tapePowerModifier;
	
		private Climber(){
			Rope_Motor = new WPI_TalonSRX(Climber_Rope_Talon);
			Tape_Motor = new WPI_TalonSRX(Climber_Tape_Talon);
			ropePowerModifier = 0.4; tapePowerModifier = 0.4;
		}
		
		//sets the power to the rope motor
	    public void setRopeMotorPower(double power) {
	    	Rope_Motor.set(power);
	    }
	    
	    //sets the power to the tape motors
	    public void setTapeMotorsPower(double power){
	    	Tape_Motor.set(power);
	    }
	    
	    //stops the tape motors
	    public void stopTapeMotors(){
	    	Tape_Motor.stopMotor();
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
	    
	    //binds the keys for the tape and rope controls. LB open tape, RB close tape
	    private static void bindKeys(){
	    	OI.getInstance().Get_LB_Button().whenPressed(new TapeOpen());
	    	OI.getInstance().Get_LB_Button().whenReleased(new StopTape());
	    	OI.getInstance().Get_RB_Button().whenPressed(new TapeClose());
	    	OI.getInstance().Get_RB_Button().whenActive(new StopTape());
	    }
	    
	    public static final void init() {
			instance = new Climber();
			bindKeys();
		}	
	    
	 //returns the instance of the climber
		public static final Climber getInstance() {
			return instance;
		}
	

    public void initDefaultCommand() {
        setDefaultCommand(new UseRope());
    }

	
}

