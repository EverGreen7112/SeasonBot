package org.usfirst.frc.team7112.robot.Utils;

import org.usfirst.frc.team7112.robot.commands.auto.TestAuto;
import org.usfirst.frc.team7112.robot.commands.autoCommandChoosers.AutoCommandChooserLeft;
import org.usfirst.frc.team7112.robot.commands.autoCommandChoosers.AutoCommandChooserMiddle;
import org.usfirst.frc.team7112.robot.commands.autoCommandChoosers.AutoCommandChooserRight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MatchDataProcessor {
	private static final MatchDataProcessor instance;

	private Command autoCommand;
	private SendableChooser<Command> autoChooser;

	static {
		instance = new MatchDataProcessor();
	}

	public static final MatchDataProcessor getInstance(){ return instance; }
	
	private MatchDataProcessor() {

	}

	public void robotInit(){
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Basic Drive Strait", new TestAuto());
		autoChooser.addObject("Left From Side", new AutoCommandChooserLeft(true));
		autoChooser.addObject("Left From Front", new AutoCommandChooserLeft(false));
		autoChooser.addObject("Right From Side" , new AutoCommandChooserRight(true));
		autoChooser.addObject("Right From Front" , new AutoCommandChooserRight(false));
		autoChooser.addObject("Middle", new AutoCommandChooserMiddle());

		SmartDashboard.putData("Autonomus Command", autoChooser);
	}

	public void autonomusInit(){
		autoCommand = autoChooser.getSelected();
		if(autoCommand !=null)
			autoCommand.start();
	}

	public void teleopInit() {
		if(autoCommand != null)
			autoCommand.cancel();
	}

}


