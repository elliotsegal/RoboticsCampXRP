# Show info on the dashboard

First we're going to add some more information to the dashboard.

* Open RobotContainer.java and look for the `dashboardPeriodic()` function

This function currently has one comment and one line of code:

```java
public void dashboardPeriodic() {
    // Update the dashboard
    SmartDashboard.putNumber("Rangefinder", rangefinder.getDistanceInches());
}
```

You can add new lines of `SmartDashboard.putNumber` to have other values appear on the dashboard. You can track anything you want, for example this code shows the values from the line follower, which is actually two sensors, a left and a right:

```java
SmartDashboard.putNumber("Line Follower Left", lineFollower.getLeftReflectanceValue());
SmartDashboard.putNumber("Line Follower Right", lineFollower.getRightReflectanceValue());
```

When calling `SmartDashboard.putNumber`, the first argument (in double quotes) is the name that will appear on the dashboard, and can be anything you want. The second argument is the value that you want to be displayed.

Add some more code to `dashboardPeriodic()` to display the following information:

* Line follower left and right (copy the code above and add it to the function)
* Drivetrain distance traveled (add a new `SmartDashboard.putNumber` with `drivetrain.getAverageDistanceInch()` as the second argument)
* Gyro angle (add a new `SmartDashboard.putNumber` with `drivetrain.getGyroAngleZ()` as the second argument)

Let's also add the robot's average acceleration. You can call `drivetrain.getAccelX()` to get the robot's acceleration on the x-axis, and there are corresponding functions for the y- and z-axis. However, we want the average of all three. You can calculate the average and store it in a variable like this:

```java
double averageAccel = (drivetrain.getAccelX() + drivetrain.getAccelY() + drivetrain.getAccelZ()) / 3;
```

Now add a new `SmartDashboard.putNumber` with `averageAccel` as the second argument to display the calculated average on the dashboard.
