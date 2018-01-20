package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_In;
import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_Out;
import static org.usfirst.frc.team7112.robot.RobotMap.Claw_Talon;

import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team7112.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team7112.robot.commands.Claw.StopClaw;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Claw extends Subsystem {
	
	private static Claw instance;
    private SpeedController m_motor;
    private DigitalInput m_switchIn;
    private DigitalInput m_switchOut;
    
    
    private Claw(){
    	m_motor = new WPI_TalonSRX(Claw_Talon);
    	m_switchIn = new DigitalInput(Pliers_MicroSwitch_In);
    	m_switchOut= new DigitalInput(Pliers_MicroSwitch_Out);
    }
    
    //Initiates the Pliers
    public static final void init() {
		instance = new Claw();
		//binds the X key to open the claw and the B key to close the claw
    	OI.getInstance().Get_B_Button().whenPressed(new OpenClaw());
    	OI.getInstance().Get_B_Button().whenReleased(new StopClaw());
    	OI.getInstance().Get_X_Button().whenPressed(new CloseClaw());
    	OI.getInstance().Get_X_Button().whenActive(new StopClaw());

	}

    //sets the power to the motor
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }
    
    //stops the motor
    public void stopMotor(){
    	m_motor.stopMotor();
    }

    //returns true is the InSwitch is pressed
    public boolean switchPressed_Open(){
    	return m_switchIn.get();
    }
    
  //returns true is the OutSwitch is pressed
    public boolean switchPressed_Close(){
    	return m_switchOut.get();
    }

    //returns the instance of the claw
	public static final Claw getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
    }
}

