package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightNull extends CommandGroup {

    public RightNull() {
    	requires(Chassis.getInstance());
    	requires(Claw.getInstance());
    	requires(Angle.getInstance());
        addSequential(new DriveByDistance(2.04));
        addSequential(new DriveByDistance(0,14.47));
        addSequential(new DriveByDistance(1.84));
        addSequential(new DriveByDistance(0,-14.47));
        addSequential(new DriveByDistance(5));
        addSequential(new DriveByDistance(0,-90));
    }
}
