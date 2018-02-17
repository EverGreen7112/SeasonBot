package org.usfirst.frc.team7112.robot.commands.climber;

import org.usfirst.frc.team7112.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopClimberMotors extends Command {

    public StopClimberMotors() {
        // Use requires() here to declare subsystem dependencies
        requires(Climber.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Climber.getInstance().stopRopeMotors();
    	Climber.getInstance().stopTapeMotors();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
