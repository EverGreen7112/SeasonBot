package org.usfirst.frc.team7112.robot.commands.angle;
import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.command.Command;

public class OpenAngleStartingPoint extends Command {

    public OpenAngleStartingPoint() {
        // Use requires() here to declare subsystem dependencies
        requires(Angle.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Angle.getInstance().setMotorPower(-Angle.getInstance().getSpeedModifier());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Angle.getInstance().stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}

}