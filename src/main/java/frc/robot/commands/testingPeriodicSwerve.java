package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.RobotContainer;

public class testingPeriodicSwerve {

    public static final testingPeriodicSwerve instance;

    static {
        instance = new testingPeriodicSwerve();
    }

    public static testingPeriodicSwerve getInstance() {
        return instance;
    }

    public Command moveForward() {
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(-2)
                        .withVelocityY(0)
                        .withRotationalRate(0);
                }));
    }

    public Command moveBackwards() {
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(2)
                        .withVelocityY(0)
                        .withRotationalRate(0);
                }));
    }

    public Command moveRight(){
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(0)
                        .withVelocityY(-2)
                        .withRotationalRate(0);
                }));
    }

    public Command moveLeft() {
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(0)
                        .withVelocityY(2)
                        .withRotationalRate(0);
                }));
    }

    public Command rotateClockwise(){
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(0)
                        .withVelocityY(0)
                        .withRotationalRate(-0.48);
                }));
    }

    public Command rotateCounterClockwise() {
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(0)
                        .withVelocityY(0)
                        .withRotationalRate(0.48);
                }));
    }

    public Command stop(){
        return Commands.sequence(
                RobotContainer.getInstance().getDriveTrain().applyRequest(() -> {
                    return RobotContainer.getInstance().getSwerveCentric()
                        .withVelocityX(0)
                        .withVelocityY(0)
                        .withRotationalRate(0);
                }));
    }

}
