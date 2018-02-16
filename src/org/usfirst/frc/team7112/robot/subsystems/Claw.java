package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Claw_MicroSwitch_In;
import static org.usfirst.frc.team7112.robot.RobotMap.Claw_MicroSwitch_Out;
import static org.usfirst.frc.team7112.robot.RobotMap.Claw_Talon;

import org.usfirst.frc.team7112.robot.commands.claw.UseClaw;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Claw extends Subsystem {
	
	private static Claw instance;
    private SpeedController motor;
    private DigitalInput switchIn;
    private static final double speedModifier = 0.5;
    
    
    private Claw(){
    	motor = new WPI_TalonSRX(Claw_Talon);
    	switchIn = new DigitalInput(Claw_MicroSwitch_In);
    }
    

    //sets the power to the motor
    public void setMotorPower(double Power) {
    	motor.set(Power);
    }
    //Initiates the Pliers
    public static final void init() {
		instance = new Claw();    	
	}

    /**
	 * @return the speedmodifier
	 */
	public double getSpeedmodifier() {
		return speedModifier;
	}

	//stops the motor
    public void stopMotor(){
    	motor.stopMotor();
    }

    //returns true is the InSwitch is pressed
    public boolean switchPressed_Open(){
    	return switchIn.get();
    }

    //returns the instance of the claw
	public static final Claw getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new UseClaw());
    }
}

