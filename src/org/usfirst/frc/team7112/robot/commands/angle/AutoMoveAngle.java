package org.usfirst.frc.team7112.robot.commands.angle;
import org.usfirst.frc.team7112.robot.subsystems.Angle;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoMoveAngle extends Command {

	private int goalAngle;
	/**
	 * true is positive (up), false is negative (down)
	 */
	private boolean direction; 
    public AutoMoveAngle(int angle) {
    	requires(Angle.getInstance());
    	goalAngle = -angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(goalAngle > 0)
    		direction = true;
    	else
    		direction = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("angleEncoder", Angle.getInstance().getCurrentAngle());
//    	if(Angle.getInstance().getCurrentAngle() >= Math.abs(goalAngle))
//    		Angle.getInstance().stopMotor();
//    	else
    		if(direction)
    		Angle.getInstance().setMotorPower(Angle.getInstance().getSpeedModifier());
    		else
        		Angle.getInstance().setMotorPower(-Angle.getInstance().getSpeedModifier());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Angle.getInstance().getCurrentAngle()) >= Math.abs(goalAngle);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Angle.getInstance().stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {end();}

}