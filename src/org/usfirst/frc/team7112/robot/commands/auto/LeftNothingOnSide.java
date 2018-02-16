package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *For use when the starting position is on the left side, and the switch's left side is the enemy alliences'. </br>
 *The robot passes the auto line, moves toward the space between the cubes and the platform, then goes 6 meters strait through
 */
public class LeftNothingOnSide extends CommandGroup {

    public LeftNothingOnSide() {
    	requires(Chassis.getInstance());
    	requires(Claw.getInstance());
    	requires(Angle.getInstance());
        addSequential(new DriveByDistance(2.04));
        addSequential(new DriveByDistance(0,-14.47));
        addSequential(new DriveByDistance(3.57));
        addSequential(new DriveByDistance(0,104.47));
        addSequential(new DriveByDistance(0.43));
        addSequential(new DriveByDistance(6));
        addSequential(new DriveByDistance(0,90));
    }
}
