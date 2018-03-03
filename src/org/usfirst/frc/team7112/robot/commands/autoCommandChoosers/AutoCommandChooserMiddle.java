package org.usfirst.frc.team7112.robot.commands.autoCommandChoosers;

import org.usfirst.frc.team7112.robot.commands.auto.MidL;
import org.usfirst.frc.team7112.robot.commands.auto.MidR;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandChooserMiddle extends CommandGroup {

	private String gameMessage;
    public AutoCommandChooserMiddle() {
        requires(Chassis.getInstance());
        requires(Angle.getInstance());
        requires(Claw.getInstance());
		gameMessage = edu.wpi.first.wpilibj.DriverStation.getInstance().getGameSpecificMessage();
		if(gameMessage.charAt(0)=='R')
			addSequential(new MidR());
		else
			addSequential(new MidL());
    }
}
