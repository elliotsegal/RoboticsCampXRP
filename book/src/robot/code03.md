# Follow by maintaining distance

Now let's set up an autonomous routine that will use the rangefinder to maintain a distance from an object. What this means is that if the robot is too close to the object, it will back up, and if it is too far, it will drive forward. If you point the robot at your foot and walk away from it, it should follow you without getting too close.

The project comes with two autonomous routines that can be selected on the dashboard. The default, "Distance", drives forward 10 inches, then turns around and comes back. The other one, "Follow", will need some changes before it does what we want.

> Try out both autonomous routines.

Right now the "Follow" routine just drives forward forever! That's no good. Let's change it.

> Open commands/AutonomousFollow.java

We have all the parts we need here, except for the conditions that tell us if we're too close or too far. First let's look at the variables:

```java
private static final double SPEED = 0.75;
private static final double FOLLOW_DISTANCE = 15;
```

These are called constants, and are useful for numbers that get used in multiple places, as well as making code more readable. Anywhere that you see `SPEED` in the code below becomes 0.75. If we changed the constant to be `private static final double SPEED = 1;`, then all the speeds would become 1 instead, which saves us the trouble of editing each line.

Now let's look at the routine itself:

```java
addCommands(
    Commands.repeatingSequence(
        // Drive forward while far from the object
        new DriveSpeed(drivetrain, SPEED).onlyWhile(() -> true),
        // Drive backward while close to the object
        new DriveSpeed(drivetrain, -SPEED).onlyWhile(() -> false)
    )
);
```

`Commands.repeatingSequence` repeats the list of commands forever. There are two commands that get repeated. The first drives forward, and the second drives backward (notice the minus sign in front of `SPEED`). They also both have a condition, added with the `onlyWhile` function: the command will only run while the condition after the `->` is true. Right now though, the first one has `true` as its condition, meaning it runs forever, and the second has `false`, meaning it never runs.

We'll need to replace the words `true` and `false` with the actual conditions for these commands. As the comments say, the first should check if the robot is far away from something, and the second should check if its close to something.

We can use the rangefinder sensor for this -- notice that right above `addCommands`, `AutonomousFollow` already has an argument for `XRPRangefinder rangefinder`, meaning it's available to use in this code with the name `rangefinder`. To check if the robot is far away from something, you can do this:

```java
rangefinder.getDistanceInches() > FOLLOW_DISTANCE
```

We're using the `FOLLOW_DISTANCE` constant here, which is set as 15 above. So this code checks if the distance reported by the rangefinder is greater than 15 inches.

> Replace `true` with the code above to run the first command only while the robot is more than 15 inches away from something.

> Replace `false` with the opposite condition, so that it only runs while the robot is LESS than 15 inches away from something.

> Run the "Follow" autonomous routine.

You'll notice that while this basically works, rather than stopping when the robot is 15 inches from something, it wiggles back and forth. Use the dashboard to look at the value of the rangefinder. Can you figure out why this is happening?

The problem is the robot will never be precisely 15 inches away from something -- it will always be slightly off, for example 14.99 or 15.01. This causes the code to rapidly switch between driving forward and backward.

How can we fix this? Instead of having the robot try to land on exactly 15 inches, we can use a "dead zone", where there's some range that the robot doesn't move. For example, you could change the first condition to have the robot drive forward when it's more than 16 inches away, but keep the second condition the same. That way the robot won't move if it's between 15 and 16 inches away. Try making that change and seeing if it fixes the problem.

### Lambdas

Normally the robot runs all of your code right when it turns on. When your code creates commands, they are saved by the robot to be run when needed, for example when you enter autonomous mode. For conditions and certain other things, it's important that the robot checks the condition when it's running the command, not when it's first turned on. The special syntax `() ->` creates a *lambda*, which captures a bit of code without running it. That way, the command can save a piece of code and run it as many times as it needs.