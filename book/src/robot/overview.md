# Overview

The project files are shown on the left side of Visual Studio Code (you may need to click the "two pages" icon in the upper left if the sidebar is hidden or showing something else). Most of the files are configuration, the code is all inside the "src" folder.

> Expand src/main/java/frc/robot to see the project code.

Inside the project, you will mainly be working in RobotContainer.java and the files in the commands folder.

## RobotContainer.java

This is the main class of the robot, which contains the code that runs when the robot first turns on.

At the top of the class, there are a number of objects for the robot's systems and sensors.

```java
// The robot's subsystems (drivetrain also contains the gyro and accelerometer sensors)
private final Drivetrain drivetrain = new Drivetrain();
private final Arm arm = new Arm();

// External sensors plugged into the robot
private final XRPRangefinder rangefinder = new XRPRangefinder();
private final XRPReflectanceSensor lineFollower = new XRPReflectanceSensor();

// The controller plugged into the computer
private final CommandXboxController controller = new CommandXboxController(0);

// SmartDashboard chooser for autonomous routines
private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();
```

These objects live here, in the robot object, and get handed off to other parts of your code as needed. Most of these objects are only allowed to exist once, so make sure to share them from this file instead of creating new ones in other files.

This file also contains three important functions that you will be adding code to:

* `configureTeleopBindings()`: Sets up the controller buttons for teleop mode.
* `configureAutonomousRoutines()`: Adds all of the autonomous routines to `autonomousChooser` so they can be selected on the dashboard.
* `dashboardPeriodic()`: Displays information on the dashboard.

## The commands folder

This folder contains the commands, or actions, your robot can do. Some commands just do one thing, like DriveSpeed.java, and some commands are made up of other commands, like AutonomousDistance.java.
