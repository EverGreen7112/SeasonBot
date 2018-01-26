package org.usfirst.frc.team7112.robot.commands.Angle;

import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AngleOpen extends Command {

    public AngleOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Angle.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Angle.getInstance().setMotorPower(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!Angle.getInstance().isNotPressed()){
    		Angle.getInstance().setMotorPower(0.3); return true;
    	}
    	
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
