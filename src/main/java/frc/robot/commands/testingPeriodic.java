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
<<<<<<< HEAD
<<<<<<< HEAD
        new WaitCommand(2).deadlineFor(Shooter.getInstance().spinShooterMotors(.4)),
        new WaitCommand(0.1).deadlineFor(Shooter.getInstance().spinShooterZero()),


        //--------Commands for Index--------//
        new WaitCommand(2).deadlineFor(Index.getInstance().spinIndex(.3)),
        new WaitCommand(0.1).deadlineFor(Index.getInstance().spinIndexZero()),
    

        //--------Commands for Intake and Intake Arm--------//
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmDown(0.5)),
        new WaitCommand(2).deadlineFor(Intake.getInstance().spinIntake(.2)),
        new WaitCommand(0.1).deadlineFor(Intake.getInstance().spinIntake(0)),
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmUp(0.5)),

        //--------Swerve Drive--------//
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveForward()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveRight()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveBackwards()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveLeft()),

        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().rotateClockwise()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().rotateCounterClockwise()),

        new WaitCommand(0.1).deadlineFor(testingPeriodicSwerve.getInstance().stop())
=======
        new WaitCommand(3).deadlineFor(Shooter.getInstance().spinShooterMotors(.65))
            .andThen(Shooter.getInstance().spinShooterZero()),
=======
        new WaitCommand(2).deadlineFor(Shooter.getInstance().spinShooterMotors(.4)),
        new WaitCommand(0.1).deadlineFor(Shooter.getInstance().spinShooterZero()),
>>>>>>> 23268a8 (attempt two at getting the testing periodic to work)


        //--------Commands for Index--------//
        new WaitCommand(2).deadlineFor(Index.getInstance().spinIndex(.3)),
        new WaitCommand(0.1).deadlineFor(Index.getInstance().spinIndexZero()),
    

        //--------Commands for Intake and Intake Arm--------//
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmDown(0.5)),
        new WaitCommand(2).deadlineFor(Intake.getInstance().spinIntake(.2)),
        new WaitCommand(0.1).deadlineFor(Intake.getInstance().spinIntake(0)),
        new WaitCommand(2).deadlineFor(IntakeArm.getInstance().spinArmUp(0.5)),

        //--------Swerve Drive--------//
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveForward()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveRight()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveBackwards()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().moveLeft()),

        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().rotateClockwise()),
        new WaitCommand(2).deadlineFor(testingPeriodicSwerve.getInstance().rotateCounterClockwise()),

<<<<<<< HEAD
        new WaitCommand(3).deadlineFor(testingPeriodicSwerve.getInstance().stop())
>>>>>>> 5947b06 (attempt one at making a testing periodic routine)
=======
        new WaitCommand(0.1).deadlineFor(testingPeriodicSwerve.getInstance().stop())
>>>>>>> 23268a8 (attempt two at getting the testing periodic to work)


    );

 }


}