package org.usfirst.frc.team7112.robot.commands.angle;
import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AngleClose extends Command {

	public AngleClose() {
		// Use requires() here to declare subsystem dependencies
		requires(Angle.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putBoolean("angleMicroSwitch", Angle.getInstance().isPressed());
		SmartDashboard.putNumber("angleEncoder", Angle.getInstance().getCurrentAngle());
		if(Angle.getInstance().isPressed() && Angle.getInstance().getCurrentAngle()!=0)
			Angle.getInstance().reset();
		else 
			if(!Angle.getInstance().isPressed()){
				Angle.getInstance().setMotorPower(Angle.getInstance().getSpeedModifier());
			}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Angle.getInstance().isPressed();
	}

	// Called once after isFinished returns true
	protected void end() {
		Angle.getInstance().stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
