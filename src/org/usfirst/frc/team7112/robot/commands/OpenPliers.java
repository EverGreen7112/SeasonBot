package org.usfirst.frc.team7112.robot.commands;

import org.usfirst.frc.team7112.robot.subsystems.Pliers;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenPliers extends Command {

	public OpenPliers() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Pliers.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Pliers.getInstance().setMotorPower(-0.15);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Pliers.getInstance().isPressed_Out()) return true;
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
