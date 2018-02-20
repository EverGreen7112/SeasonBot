package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.angle.AutoMoveAngle;
import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.commands.claw.AutoOpenClaw;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSide extends CommandGroup {

    public RightSide() {
    	requires(Chassis.getInstance());
    	requires(Claw.getInstance());
    	requires(Angle.getInstance());
        addSequential(new DriveByDistance(0.54));
        addSequential(new DriveByDistance(0,30));
        addSequential(new DriveByDistance(1.75));
        addSequential(new DriveByDistance(0,-37.5));
        addSequential(new DriveByDistance(1.37));
        addSequential(new DriveByDistance(0,-45));
        addSequential(new DriveByDistance(0.62));
        addSequential(new DriveByDistance(0,-37.5));
        addSequential(new DriveByDistance(0.24));
        addParallel(new AutoMoveAngle(-20));
        addSequential(new AutoOpenClaw());
    }
}
