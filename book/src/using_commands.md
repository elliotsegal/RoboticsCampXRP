# Using Commands

From the WPILib documentation:

> "Command-based" programming is one possible design pattern for robot software. It is not the only way to write a robot program, but it is a very effective one. Command-based robot code tends to be clean, extensible, and (with some tricks) easy to reuse from year to year.

The main idea is that your code prepares Command objects that tell the robot what to do. One way to think about it is that your code creates other code that the robot then runs. Controlling the robot by giving it a list of commands has a number of advantages, one of the main ones being that commands themselves can be simple, reusable actions, and can be easily combined into complex routines.

One thing that's a little weird about this setup is that your code that prepares commands only gets run when the robot first turns on. Because the commands you create are what controls the robot, your code can't use things like if statements and while loops to change what the robot does. Instead, those things have to be part of a command. Instead of an if statement, you can call `onlyIf` on a Command object, and instead of a while loop, you can put Command objects inside `Commands.repeatingSequence`. You can also create your own commands, which let you control the robot directly.

[You can read more about commands here.](https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html)