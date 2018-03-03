package org.usfirst.frc.team7112.robot.commands.chassis;

import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AdvancedTurnInPlace extends Command implements PIDSource {

	private int timesOnTarget=0;
	private double Kp = 1, Ki = 0.3, Kd = 0; //for left motors
	private double kP = 1, kI = 0.3, kD = 0; //for right motors
	
	private double radius = 0.0762;
	private double deltaTime = 0.005;
	private double xDot;
	private double u = 0, errorBefore = 0, currentError;
	private double L = 0.55421; // distance between wheels
	
	private double distance;
	private PIDController drivePIDLeft;
	private PIDController drivePIDRight;

	public AdvancedTurnInPlace(double distance){
		requires(Chassis.getInstance());
		this.distance = distance;
		drivePIDLeft = new PIDController(Kp, Ki, Kd, this, new PIDOutput() {

			@Override
			public void pidWrite(double output) {
				Chassis.getInstance().setLeftMotorsPower(u + output);
			}
		});
		drivePIDRight = new PIDController(kP, kI, kD, this, new PIDOutput() {

			@Override
			public void pidWrite(double output) {
				Chassis.getInstance().setRightMotorsPower(-(u + output));
			}
		});
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Chassis.getInstance().resetGyro();
		Chassis.getInstance().resetEncoders();
		drivePIDLeft.reset();
		drivePIDLeft.setAbsoluteTolerance(0.15);
		drivePIDLeft.setSetpoint(distance);
		drivePIDLeft.setOutputRange(-Chassis.getInstance().getDriveMultiplier(), Chassis.getInstance().getDriveMultiplier());
		drivePIDLeft.enable();

		drivePIDRight.reset();
		drivePIDRight.setAbsoluteTolerance(0.15);
		drivePIDRight.setSetpoint(distance);
		drivePIDRight.setOutputRange(-Chassis.getInstance().getDriveMultiplier(), Chassis.getInstance().getDriveMultiplier());
		drivePIDRight.enable();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivePIDLeft.setPID(
				SmartDashboard.getNumber("Drive Left PID P", 1),
				SmartDashboard.getNumber("Drive Left PID I", 0), 
				SmartDashboard.getNumber("Drive Left PID D", 0));

		drivePIDRight.setPID(
				SmartDashboard.getNumber("Drive PID P", 1),
				SmartDashboard.getNumber("Drive PID I", 0), 
				SmartDashboard.getNumber("Drive PID D", 0));

		SmartDashboard.putNumber("Drive Left PID P", drivePIDLeft.getP());
		SmartDashboard.putNumber("Drive Left PID I", drivePIDLeft.getI());
		SmartDashboard.putNumber("Drive Left PID D", drivePIDLeft.getD());
		SmartDashboard.putNumber("EncoderLeft", Chassis.getInstance().getDistanceL());

		SmartDashboard.putNumber("Drive Right PID P", drivePIDRight.getP());
		SmartDashboard.putNumber("Drive Right PID I", drivePIDRight.getI());
		SmartDashboard.putNumber("Drive Right PID D", drivePIDRight.getD());
		SmartDashboard.putNumber("EncoderRight", Chassis.getInstance().getDistanceR());
		
		currentError = drivePIDLeft.getSetpoint() - Chassis.getInstance().getDistance();
		xDot = (currentError - errorBefore) / deltaTime;
		u = xDot / radius;
		errorBefore = currentError; 
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (drivePIDLeft.onTarget() && drivePIDRight.onTarget()) {
			timesOnTarget++;
		} else {
			timesOnTarget = 0;
		}
		return timesOnTarget > 2;
	}

	// Called once after isFinished returns true
	protected void end() {
		Chassis.getInstance().stopMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return Chassis.getInstance().getDistance();
	}

}
