package org.usfirst.frc.team7112.robot.commands.chassis;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class SwitchPerspectives extends Command {

    public SwitchPerspectives() {
        // Use requires() here to declare subsystem dependencies
        requires(Chassis.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Chassis.getInstance().switchPerspectives();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
