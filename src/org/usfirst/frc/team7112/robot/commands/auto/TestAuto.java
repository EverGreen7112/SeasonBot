package org.usfirst.frc.team7112.robot.commands.auto;

import org.usfirst.frc.team7112.robot.commands.angle.AutoMoveAngle;
import org.usfirst.frc.team7112.robot.commands.chassis.AdvancedDriveByDistance;
import org.usfirst.frc.team7112.robot.commands.chassis.DriveByDistance;
import org.usfirst.frc.team7112.robot.commands.chassis.TurnInPlace;
import org.usfirst.frc.team7112.robot.commands.claw.AutoOpenClaw;
import org.usfirst.frc.team7112.robot.subsystems.Angle;
import org.usfirst.frc.team7112.robot.subsystems.Chassis;
import org.usfirst.frc.team7112.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {

    public TestAuto() {
    	requires(Chassis.getInstance());
    	requires(Angle.getInstance());
    	requires(Claw.getInstance());
    	addSequential(new DriveByDistance(2));
    	addSequential(new TurnInPlace(14));
    	addSequential(new DriveByDistance(0.5));
        addParallel(new AutoMoveAngle(-20));
        addSequential(new AutoOpenClaw());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
