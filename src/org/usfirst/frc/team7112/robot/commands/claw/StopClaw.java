package org.usfirst.frc.team7112.robot.commands.claw;
import org.usfirst.frc.team7112.robot.subsystems.Claw;
import edu.wpi.first.wpilibj.command.Command;

public class StopClaw extends Command {

    public StopClaw() {
        // Use requires() here to declare subsystem dependencies
        requires(Claw.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Claw.getInstance().stopMotor();
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