package org.usfirst.frc.team7112.robot.commands.autoCommandChoosers;

import org.usfirst.frc.team7112.robot.commands.auto.LeftDefence;
import org.usfirst.frc.team7112.robot.commands.auto.LeftFront;
import org.usfirst.frc.team7112.robot.commands.auto.LeftNull;
import org.usfirst.frc.team7112.robot.commands.auto.LeftSide;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandChooserLeft extends CommandGroup {

	private String gameMessage;
	public AutoCommandChooserLeft(boolean fromSide) {
		requires(Chassis.getInstance());
		requires(Angle.getInstance());
		requires(Claw.getInstance());

		gameMessage = edu.wpi.first.wpilibj.DriverStation.getInstance().getGameSpecificMessage();
		if(gameMessage.charAt(0)=='L' && fromSide)
			addSequential(new LeftSide());
		else
			if(gameMessage.charAt(0)=='L')
				addSequential(new LeftFront());
			else
				if(gameMessage.charAt(1)=='L')
					addSequential(new LeftNull());
				else
					addSequential(new LeftDefence());

	}
}
