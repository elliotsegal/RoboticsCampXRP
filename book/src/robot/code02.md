# Turn when a button is pressed

Let's set up two controller buttons to make the robot quickly turn 90 degrees.

We can do this easily using commands. There's already a command to turn the robot some number of degrees, we just need to set up the code so that command is run when we press a button.

> Open RobotContainer.java and look for the `configureTeleopBindings()` function.

This function has all of the controls for teleop mode. By default the robot will use the `ArcadeDrive` command, which uses the left stick of the controller to move and turn. We can have it run a different command when a button is pressed with this code:

```java
controller.leftBumper().onTrue( /*command goes here*/ );
```

After that command is run, the robot will go back to the `ArcadeDrive` command. The command we want is `TurnDegrees`. To have the robot turn 90 degrees, we create a new command like this:

```java
new TurnDegrees(drivetrain, 1, 90)
```

The first argument is the drivetrain. In this case, we've created our drivetrain at the top of the `RobotContainer` class, and now we're handing it off to the command. The second argument is the speed (1 means full speed), and the third argument is the number of degrees.

> Uncomment the two lines in `configureTeleopBindings()` that start with `controller.leftBumper()` and `controller.rightBumper()`

> For the left bumper, inside the parentheses after `onTrue`, put the code above that creates the `TurnDegrees` command.

> Do the same for the right bumper, but change the command to rotate negative 90 degrees.
