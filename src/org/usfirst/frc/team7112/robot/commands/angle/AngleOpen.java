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
public class AngleOpen extends Command implements PIDSource, PIDOutput {

	private PIDController anglePID;
	private int timesOnTarget=0;
	private double Kp = 1, Ki = 0, Kd = 0;
	private double angle;
    public AngleOpen() {
        requires(Angle.getInstance());
    	anglePID = new PIDController(Kp, Ki, Kd, this, this);
    	this.angle= Angle.getInstance().getGoalAngle();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	anglePID.reset();
		anglePID.setAbsoluteTolerance(0.15);
		anglePID.setSetpoint(angle);
		anglePID.setOutputRange(-Angle.getInstance().getSpeedModifier(),Angle.getInstance().getSpeedModifier());
		anglePID.enable();
    	SmartDashboard.putNumber("Angle PID P", anglePID.getP());
		SmartDashboard.putNumber("Angle PID I", anglePID.getI());
		SmartDashboard.putNumber("Angle PID D", anglePID.getD());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("angleEncoder", Angle.getInstance().getCurrentAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (anglePID.onTarget()) {
			timesOnTarget++;
		} else {
			timesOnTarget = 0;
		}
		return timesOnTarget > 2;    }

    // Called once after isFinished returns true
    protected void end() {
    	Angle.getInstance().stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	public void pidWrite(double output) {
		Angle.getInstance().setMotorPower(output);
		
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return Angle.getInstance().getCurrentAngle();
	}
}
