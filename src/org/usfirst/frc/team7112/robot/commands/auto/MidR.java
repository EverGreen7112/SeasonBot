package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.angle.AutoMoveAngle;
import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.commands.claw.AutoOpenClaw;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Used when the starting position is the middle and the Right side of the switch is the ally alliences' side.
 *<p>The robot drives towards strait a small amount, turns right, drives towards the auto line then it turns towards the switch, drives to it while lowering the Angle and opening the Claw.</p>
 */
public class MidR extends CommandGroup {

    public MidR() {
    	requires(Chassis.getInstance());
    	requires(Claw.getInstance());
    	requires(Angle.getInstance());
        addSequential(new DriveByDistance(0.54));
        addSequential(new DriveByDistance(0,28.2));
        addSequential(new DriveByDistance(1.61));
        addSequential(new DriveByDistance(0,-28.2));
        addSequential(new DriveByDistance(0.47));
        addSequential(new DriveByDistance(0.2));
        addParallel(new AutoMoveAngle(-20));
        addSequential(new AutoOpenClaw());
    }
}
