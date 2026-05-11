package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;
import frc.robot.commands.testingPeriodicSwerve;

public class testingPeriodic extends SequentialCommandGroup {
/*
 * activate shooters -> deactivate shooters
 * index on -> index off
 * spin arm down -> intake on -> intake off -> spin arm up
 * drive -> forward -> back -> left -> right
 * drive -> rotate clockwise -> rotate counter clockwise 
 */

 public testingPeriodic() {
    addCommands (

        //--------Commands for Shooter--------//
        new WaitCommand(3).deadlineFor(Shooter.getInstance().spinShooterMotors(.65))
            .andThen(Shooter.getInstance().spinShooterZero()),


        //--------Commands for Index--------//
        new WaitCommand(2).deadlineFor(Index.getInstance().spinIndex(.5))
            .andThen(Index.getInstance().spinIndexZero()),
    

        //--------Commands for Intake and Intake Arm--------//
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmDown(0.75)),
        new WaitCommand(2).deadlineFor(Intake.getInstance().spinIntake(.5))
            .andThen(Intake.getInstance().spinIntake(0)),
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmUp(0.75)),

        //--------Swerve Drive--------//
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().moveForward()),
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().moveRight()),
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().moveBackwards()),
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().moveLeft()),

        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().rotateClockwise()),
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().rotateCounterClockwise()),

        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().stop())


    );

 }


}