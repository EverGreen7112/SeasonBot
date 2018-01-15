package org.usfirst.frc.team7112.robot.subsystems;

import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_Talon;
import org.usfirst.frc.team7112.robot.OI;
import org.usfirst.frc.team7112.robot.commands.ClosePliers;
import org.usfirst.frc.team7112.robot.commands.OpenPliers;
import org.usfirst.frc.team7112.robot.commands.UsePliers;

import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_In;
import static org.usfirst.frc.team7112.robot.RobotMap.Pliers_MicroSwitch_Out;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Pliers extends Subsystem {
	
	private static Pliers instance;
    private SpeedController m_motor;
    private DigitalInput m_switchIn;
    private DigitalInput m_switchOut;
    
    private Pliers(){
    	m_motor = new WPI_TalonSRX(Pliers_Talon);
    	m_switchIn = new DigitalInput(Pliers_MicroSwitch_In);
    	m_switchOut= new DigitalInput(Pliers_MicroSwitch_Out);
    }
    
    /*
     * Initiates the Pliers.
     */
    public static final void init() {
		instance = new Pliers();
	}

    //uses the pliers, opens if B_Button is pressed or closes if X_Button is pressed
    public void usePliers(){
    	OI.getInstance().GetBButton().whileHeld(new OpenPliers());
    	OI.getInstance().GetXButton().whileHeld(new ClosePliers());
    }
  
    public void setMotorPower(double Power) {
    	m_motor.set(Power);
    }

    //returns true is the InSwitch is pressed
    public boolean isPressed_IN(){
    	return m_switchIn.get();
    }
    
  //returns true is the OutSwitch is pressed
    public boolean isPressed_Out(){
    	return m_switchOut.get();
    }

    
	public static final Pliers getInstance() {
		return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UsePliers());
    }
}

