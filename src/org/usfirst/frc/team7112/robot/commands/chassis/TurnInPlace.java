package org.usfirst.frc.team7112.robot.commands.chassis;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnInPlace extends Command implements PIDOutput , PIDSource {

	private int timesOnTarget=0;
	private double Kp = 1, Ki = 0.3, Kd = 0;
	private double angle;
	private PIDController drivePID;
	private final double P2 = 2.0 / 90.0; //maybe change
	
	public TurnInPlace(double angle){
		requires(Chassis.getInstance());
		this.angle = angle;
		drivePID = new PIDController(Kp, Ki, Kd, this, this);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
		Chassis.getInstance().resetGyro();
		Chassis.getInstance().resetEncoders();
    	drivePID.reset();
		drivePID.setAbsoluteTolerance(0.15);
		drivePID.setSetpoint(angle);
		drivePID.setOutputRange(-Chassis.getInstance().getDriveMultiplier(), Chassis.getInstance().getDriveMultiplier());
		drivePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivePID.setPID(
    			SmartDashboard.getNumber("Drive PID P", 0),
    			SmartDashboard.getNumber("Drive PID I", 0), 
    			SmartDashboard.getNumber("Drive PID D", 0));
    	SmartDashboard.putNumber("Drive PID P", drivePID.getP());
		SmartDashboard.putNumber("Drive PID I", drivePID.getI());
		SmartDashboard.putNumber("Drive PID D", drivePID.getD());
		SmartDashboard.putNumber("Encoder", Chassis.getInstance().getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		if (drivePID.onTarget()) {
			timesOnTarget++;
		} else {
			timesOnTarget = 0;
		}
		return timesOnTarget > 2;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	/**
	 * @returns Angle's current angle
	 */
	public double pidGet() {
		return Chassis.getInstance().getAngle();
	}

	@Override
	public void pidWrite(double output) {
		Chassis.getInstance().arcadeDrive(0,output);		
	}

}