// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.HootAutoReplay;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Shooter;
//import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Index;
import frc.robot.commands.testingPeriodic;
import frc.robot.generated.TunerConstants;


public class Robot extends TimedRobot {
    private Command m_autonomousCommand;

    private final Field2d field = new Field2d();

    private final RobotContainer m_robotContainer;


    /* log and replay timestamp and joystick data */
    private final HootAutoReplay m_timeAndJoystickReplay = new HootAutoReplay()
        .withTimestampReplay()
        .withJoystickReplay();

    public Robot() {
        m_robotContainer = new RobotContainer();
    }

    @Override
    public void robotInit() {
        SmartDashboard.putData(CommandScheduler.getInstance());
        DriverStation.getAlliance();
        SmartDashboard.putData("Game Field", field);
    }

    @Override
    public void robotPeriodic() {
        m_timeAndJoystickReplay.update();
        CommandScheduler.getInstance().run(); 
        SmartDashboard.putNumber("Match Timer", DriverStation.getMatchTime());
        //May 6, 2026 -> will fix later; I have to implement all of the pose estimators in the commandswervedrivetrain class -AZ
        //field.setRobotPose(m_odometry.getPo);
//         SmartDashboard.putData("Swerve Drive", new Sendable() {
//   @Override
//   public void initSendable(SendableBuilder builder) {
//     builder.setSmartDashboardType("SwerveDrive");

//     builder.addDoubleProperty("Front Left Angle", () -> drivetrain.getAngle().getRadians(), null);
//     builder.addDoubleProperty("Front Left Velocity", () -> frontLeftModule.getVelocity(), null);

//     builder.addDoubleProperty("Front Right Angle", () -> FrontRight.getAngle().getRadians(), null);
//     builder.addDoubleProperty("Front Right Velocity", () -> frontRightModule.getVelocity(), null);

//     builder.addDoubleProperty("Back Left Angle", () -> BackLeft.getAngle().getRadians(), null);
//     builder.addDoubleProperty("Back Left Velocity", () -> backLeftModule.getVelocity(), null);

//     builder.addDoubleProperty("Back Right Angle", () -> BackRight.getAngle().getRadians(), null);
//     builder.addDoubleProperty("Back Right Velocity", () -> backRightModule.getVelocity(), null);

//     builder.addDoubleProperty("Robot Angle", () -> getRotation().getRadians(), null);
//   }
}//);
    //}

    @Override
    public void disabledInit() {
        SmartDashboard.putString("Auto State", "");
    }

    @Override
    public void disabledPeriodic() {}

    @Override
    public void disabledExit() {}

    @Override
    public void autonomousInit() {
        DriverStation.reportError("Report::autonomousInit: Started!", isAutonomous());

        //Calls the Selected Manual Auto
        // m_autonomousCommand = m_robotContainer.getSelectedAuto();
        
        //Calls the Selected Path Planner Auto
        m_autonomousCommand = m_robotContainer.getPathPlannerAuto();

        if (m_autonomousCommand != null) {
            CommandScheduler.getInstance().schedule(m_autonomousCommand);
            SmartDashboard.putString("Auto State", "Start");
        }
       
    }

    @Override
    public void autonomousPeriodic() {
        //DriverStation.reportError("Report::autonomousPeriodic: Periodic()", isAutonomous());
        //SmartDashboard.putString("Auto State", "running");
    }

    @Override
    public void autonomousExit() {
        DriverStation.reportWarning("Report::autonomousExit: Done", isAutonomous());
        SmartDashboard.putString("Auto State", "end");
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            CommandScheduler.getInstance().cancel(m_autonomousCommand);
        }
        
        Shooter.getInstance().spinShooterZero();
        Index.getInstance().spinIndexZero();
        SmartDashboard.putString("Auto State", "End");
    }

    @Override
    public void teleopPeriodic() {}

    @Override
    public void teleopExit() {}

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
        new testingPeriodic();
    }

    @Override
    public void testExit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void simulationInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void simulationPeriodic() {}
}
