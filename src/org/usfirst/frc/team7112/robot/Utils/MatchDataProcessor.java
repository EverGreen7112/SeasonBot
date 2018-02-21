package org.usfirst.frc.team7112.robot.Utils;

import org.usfirst.frc.team7112.robot.commands.auto.TestAuto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MatchDataProcessor {
	private static final MatchDataProcessor instance;

	private Command m_autoCommand;
	private SendableChooser<Command> m_autoChooser;

	static {
		instance = new MatchDataProcessor();
	}

	private MatchDataProcessor() {
		
	}
	
	public void robotInit(){
		m_autoChooser = new SendableChooser<>();
		m_autoChooser.addDefault("Basic Drive Strait", new TestAuto());

		SmartDashboard.putData("Autonomus Command", m_autoChooser);
	}

}


