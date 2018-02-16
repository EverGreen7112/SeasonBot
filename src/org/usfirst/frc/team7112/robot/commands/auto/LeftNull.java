package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.angle.AutoMoveAngle;
import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.commands.claw.AutoOpenClaw;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftNull extends CommandGroup {

    public LeftNull() {
    	requires(Chassis.getInstance());
    	requires(Claw.getInstance());
        addSequential(new DriveByDistance(1.54));
        addSequential(new DriveByDistance(0,65.86));
        addSequential(new DriveByDistance(1.17));
        addSequential(new DriveByDistance(0,-65.86));
        addSequential(new DriveByDistance(0.43));
        addSequential(new DriveByDistance(0.2));
        addParallel(new AutoMoveAngle(-20));
        addSequential(new AutoOpenClaw());
    }
}
