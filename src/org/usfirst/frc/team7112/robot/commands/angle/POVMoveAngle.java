package org.usfirst.frc.team7112.robot.commands.angle;
import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.command.Command;

public class POVMoveAngle extends Command {

	private int goalAngle;
	public POVMoveAngle(int goalAngle) {
		// Use requires() here to declare subsystem dependencies
		requires(Angle.getInstance());
		this.goalAngle = goalAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(OI.getInstance().GetDrivePOV()==0){
			Angle.getInstance().setMotorPower(-Angle.getInstance().getSpeedModifier());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Angle.getInstance().getCurrentAngle() == goalAngle || Angle.getInstance().isPressed();
	}

	// Called once after isFinished returns true
	protected void end() {}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {}

}