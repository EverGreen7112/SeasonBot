package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Claw_Talon;
import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.commands.Claw.CloseClaw;
import org.usfirst.frc.team7112.robot.commands.Claw.OpenClaw;
import org.usfirst.frc.team7112.robot.commands.Claw.StopClaw;
import org.usfirst.frc.team7112.robot.commands.Claw.UseClaw;

import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_In;
import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_Out;
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
    
    /*
     * Initiates the Pliers.
     */
    public static final void init() {
		instance = new Claw();
	}

    //uses the pliers, opens if B_Button is pressed or closes if X_Button is pressed
    public void usePliers(){
    	OI.getInstance().GetBButton().whenPressed(new OpenClaw());
    	OI.getInstance().GetXButton().whenPressed(new CloseClaw());
    	OI.getInstance().GetXButton().whenReleased(new StopClaw());
    	OI.getInstance().GetBButton().whenReleased(new StopClaw());
    }
  
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }
    
    public void stopMotor(){
    	m_motor.stopMotor();
    }

    //returns true is the InSwitch is pressed
    public boolean isPressed_In(){
    	return m_switchIn.get();
    }
    
  //returns true is the OutSwitch is pressed
    public boolean isPressed_Out(){
    	return m_switchOut.get();
    }

    
	public static final Claw getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UseClaw());
    }
}

