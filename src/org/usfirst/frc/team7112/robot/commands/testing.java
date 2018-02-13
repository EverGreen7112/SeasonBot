package org.usfirst.frc.team7112.robot.commands;

import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class testing extends TimedCommand {

    public testing(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        requires(Chassis.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Chassis.getInstance().arcadeDrive(0.7, /*0.15*//*0.175*//*0.157*//*0.158*/1.750000001);
		SmartDashboard.putNumber("encLeft", Chassis.getInstance().getDistanceL());
		SmartDashboard.putNumber("encRight", Chassis.getInstance().getDistanceR());
		SmartDashboard.putNumber("error", Chassis.getInstance().getDistanceR() - Chassis.getInstance().getDistanceL());

    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
