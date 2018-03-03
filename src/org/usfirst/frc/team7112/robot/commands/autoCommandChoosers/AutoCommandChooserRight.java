package org.usfirst.frc.team7112.robot.commands.autoCommandChoosers;

import org.usfirst.frc.team7112.robot.commands.auto.RightDefence;
import org.usfirst.frc.team7112.robot.commands.auto.RightFront;
import org.usfirst.frc.team7112.robot.commands.auto.RightNull;
import org.usfirst.frc.team7112.robot.commands.auto.RightSide;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandChooserRight extends CommandGroup {

	private String gameMessage;
	public AutoCommandChooserRight(boolean fromSide) {
		requires(Chassis.getInstance());
		requires(Angle.getInstance());
		requires(Claw.getInstance());

		gameMessage = edu.wpi.first.wpilibj.DriverStation.getInstance().getGameSpecificMessage();
		if(gameMessage.charAt(0)=='R' && fromSide)
			addSequential(new RightSide());
		else
			if(gameMessage.charAt(0)=='R')
				addSequential(new RightFront());
			else
				if(gameMessage.charAt(1)=='R')
					addSequential(new RightNull());
				else
					addSequential(new RightDefence());

	}
}
