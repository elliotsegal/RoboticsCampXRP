# Java Reference

## Comments

Anything after two slashes is not considered code. It's handy for adding notes for yourself.

```java
// The code below calculates the sum of 45 and 98
int sum = 45 + 98; // comments can be on the same line as code too!
```

## Types

Primitive types are all lowercase

* `int`: an integer, like 12  
* `double`: a number with a decimal, like 12.7  
* `char`: a single letter or symbol, like 'Q' or '&'  
* `boolean`: either true or false

Object types start with a capital letter

* `String`: a bit of text, like "the quick brown fox"

## Variables

```java
Type variableName = value;
```

### Examples

```java
int myNumber = 12;
double squareRootOfTwo = Math.sqrt(2);
Animal onlyFriend = new Cat("Mittens");
```

## Control Flow

If statement: execute code if some condition is true

```java
int myNumber = 12;
int result = 0;
if (myNumber > 10) {
    result = 1;
}
```

`result` will be 1 if myNumber is greater than 10, otherwise `result` will be 0.

### Equality in Java

When comparing if two primitives are equal, use `a == b`

```java
int myNumber = 12;
if (myNumber == 5) {
    // code here will not run, since myNumber is not 5
}
if (myNumber == 12) {
    // code here will run, since myNumber is 12
}
```

When comparing if two objects are equal, use `a.equals(b)`

```java
String password = "secure password 123";
if (password.equals("strong password 456")) {
    unlockTheVault();
}
```

### Combining Conditions

`&&` means AND (all conditions must be true)  
`||` means OR (only one condition needs to be true)

```java
int x = 5;
int y = 8;
if (x == 5 && y == 10) {
    // code here will not run
    // x must be 5 AND y must be 10
}
if (x == 5 || y == 10) {
    // code here will run
    // x must be 5 OR y must be 10
}
```

## Functions

Functions are blocks of code that can be reused in different places. First, declare a function:

```java
// Create a new function called unlockTheVault()
void unlockTheVault() {
    // code here runs whenever unlockTheVault() is called
    VaultDoor door = new VaultDoor();
    door.disengageLocks();
    door.open();
    if (user.equals("Elliot")) {
        openHiddenCompartment();
    }
}
```

Now that code can be run by calling that function:

```java
if (voiceCommand.equals("Open")) {
    unlockTheVault();
}
if (voiceCommand.equals("Unlock")) {
    unlockTheVault();
}
if (timeSpentWaiting > 100) {
    unlockTheVault();
}
```

## Objects

To create an object, use the special word `new`:

```java
Object variableName = new Object();
```

Objects can have their own functions, which are called methods. To call a method, use `object.method()`

```java
door.open();
motor.spinAtFullSpeed();
if (myCat.hasEaten()) {
    myCat.goOutside();
}
else {
    myDog.getTailObject().startWagging();
}
```

### Null

`null` is a special word meaning there is no object. Any variable that can hold an object can also hold null. It's useful for representing optional values or objects that are only valid sometimes.

```java
Object variableName = null;
```

Note that calling a method on a null object WILL CRASH YOUR CODE! This is by far the easiest way to cause a crash, so be careful when working with null! You can check that a variable isn't null before using it like this:

```java
if (myCat != null) {
    myCat.eatDinner();
    myCat.goOutside();
}
```
