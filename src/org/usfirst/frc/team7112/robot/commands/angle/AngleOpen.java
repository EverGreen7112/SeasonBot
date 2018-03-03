package org.usfirst.frc.team7112.robot.commands.angle;

import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AngleOpen extends Command {

	private double goalAngle;
	public AngleOpen() {
		requires(Angle.getInstance());
		this.goalAngle= Angle.getInstance().getGoalAngle();
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("angleEncoder", Angle.getInstance().getCurrentAngle());
		if(Angle.getInstance().getCurrentAngle()<goalAngle)
			Angle.getInstance().setMotorPower(-Angle.getInstance().getSpeedModifier());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Angle.getInstance().getCurrentAngle() >= goalAngle);
		 
	}

	// Called once after isFinished returns true
	protected void end() {
		Angle.getInstance().stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}