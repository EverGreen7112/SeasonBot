package org.usfirst.frc.team7112.robot.commands.chassis;

import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Chassis.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Chassis.getInstance().arcadeDrive(OI.getInstance().GetYAxis() * Chassis.getInstance().getDriveMultiplier(), OI.getInstance().GetXAxis() * Chassis.getInstance().getDriveMultiplier());
    	//Chassis.getInstance().arcadeDrive(OI.getInstance().GetYAxis() * Chassis.getInstance().getDriveMultiplier(),0);
    	SmartDashboard.putNumber("DriverMul", Chassis.getInstance().getDriveMultiplier());    	
    	SmartDashboard.putNumber("Encoder", Chassis.getInstance().getDistance());
    	SmartDashboard.putNumber("Y_Axis",OI.getInstance().GetYAxis());
    	SmartDashboard.putNumber("X_Axis",OI.getInstance().GetXAxis());
		SmartDashboard.putNumber("encLeft", Chassis.getInstance().getDistanceL());
		SmartDashboard.putNumber("encRight", Chassis.getInstance().getDistanceR());
		SmartDashboard.putNumber("error", Chassis.getInstance().getDistanceR() - Chassis.getInstance().getDistanceL());
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
