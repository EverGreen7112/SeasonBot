package org.usfirst.frc.team7112.robot.commands;

import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenClaw extends Command {

	public OpenClaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Claw.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Claw.getInstance().setMotorPower(-0.225);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Claw.getInstance().isPressed_In()) return true;
        else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Claw.getInstance().setMotorPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}