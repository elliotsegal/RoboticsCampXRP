// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This command drives the robot at a given speed until it has traveled a given distance.
 */
public class DriveDistance extends Command {
  private final Drivetrain m_drivetrain;
  private final double m_distance;
  private final double m_speed;

  public DriveDistance(Drivetrain drivetrain, double speed, double inches) {
    m_drivetrain = drivetrain;
    m_distance = inches;
    m_speed = speed;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.arcadeDrive(0, 0);
    m_drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return Math.abs(m_drivetrain.getAverageDistanceInch()) >= m_distance;
  }
}
