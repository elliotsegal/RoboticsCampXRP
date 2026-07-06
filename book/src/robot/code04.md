# Move back and forth while a button is held

Let's give the robot the ability to ram things by driving back and forth. First, we'll set this up as a new autonomous routine, then we'll attach it to a button.

Make a new file in the commands folder called BackAndForth.java. Here's some code to get started:

```java
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This command repeatedly drives forward and backward.
 */
public class BackAndForth extends SequentialCommandGroup {

    private static final double SPEED = 1;
    private static final double DISTANCE = 10;

    public BackAndForth(Drivetrain drivetrain) {
        addCommands(
            Commands.repeatingSequence(
                // commands go here
            )
        );
    }

}
```

You will need to add two `DriveDistance` commands, one to drive forward and one to drive backward. Look at commands/AutonomousDistance.java for an example of `DriveDistance`, and try to use the constants `SPEED` and `DISTANCE` (use `-SPEED` to drive backward).

Let's set this up as an autonomous routine to test it out. Open RobotContainer.java and find the `configureAutonomousRoutines()` function. Add this line below the other autonomous routines, but ABOVE the `SmartDashboard.putData` line:

```java
autonomousChooser.addOption("Back and Forth", new BackAndForth(drivetrain));
```

If you get an error on `BackAndForth`, click on it, then click on the lightbulb icon to the left and select the first option, "Import 'BackAndForth'".

> Run the "Back and Forth" autonomous routine.

Does it work? Adjust the `SPEED` and `DISTANCE` as desired.

Now let's attach it to a button. There's code to do this already in `configureTeleopBindings()`, it just needs to be uncommented:

```java
// Hold the B button to ram
controller.b().whileTrue(new BackAndForth(drivetrain));
```

> Try the command by holding the B button in teleop mode.

Notice that we're using `whileTrue` to run this command, instead of `onTrue` like we did for the bumpers. This means the command will run as long as the button is held down, and will stop as soon as the button is released. This works well for commands that run forever, like `BackAndForth`.

Also notice that we've attached an entire autonomous routine to a button! This way the robot can take very complex actions in teleop mode by just pressing a button. Try holding down the B button and pressing the bumpers at the same time to see what happens when multiple commands run at once.
