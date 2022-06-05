# introduction to java

## essentials

1. all code in Java must be part of a class.
2. we delimit the begining and end of segments of code using { and }.
3. all statement in Java must end in a semi-colon.
4. for codes to run we need public static void main(String[] args)![截屏2022-06-02 13.31.21](/Users/yecong/Library/Application Support/typora-user-images/截屏2022-06-02 13.31.21.png)

### variables and loops

```java
public class HelloNumbers{
  
  public static void main(String[] args){
    int x;
    x = 0;
    while (x<10){
      System.out.println(x);
      x = x +1;
    }
  }
}
```

1. before Java variables can be used, they must be declared.
2. Java variables must have a specific type;
3. Java variable types can never change.
4. types are verified before the code even runs!

### static typing

- The compiler ensures that all types are compatible, making it easier for the programmer to debug their code.
- Since the code is guaranteed to be free of type errors, users of your compiled programs will never run into type errors. For example, Android apps are written in Java, and are typically distributed only as .class files, i.e. in a compiled format. As a result, such applications should never crash due to a type error since they have already been checked by the compiler.
- Every variable, parameter, and function has a declared type, making it easier for a programmer to understand and reason about code.

> why `string h = 5 +'horse'`can work but `int h =5 +'horse'not?`
>
> Because the first one consider h as a `string`, so the java complier takes '+' as to combine two strings. but the second one we declare that h is `int`.
>
> in python, however, it doesn't restraint the type of varables. so when we type `h = 5 +'horse'`,dose it mean you want to combine two string or you want to do the mathematical calculation? so the python will rise a type error.



### defining functions

```java
public class larger{
  /** returns the larger of x and y. */
  public static int larger(int x,int y){
    if (x>y){
      return x;
    }
    return y;
  }
  public static void main(String[] args){
    System.out.println(larger(-5,10));
  }
}
```

1. functions must be declared as part of a class in java;
2. a function that is part of a class is called a 'method'. so in java , all functions are methods.
3. to define a fucntion in java , we use public static and other ways.
4. all parameters of a function must have a declared type, and the return value of the function must have a declared type.
5. functions in java return only one value.

> difference between `println` and `print`
>
> 前者提行，后者不提行



## Objects

### static methods

To run a class, **we must define a main method!** Not all classes have a main method,these classes cannot be directly called.

`public static void main(String[] args){}`

### instance variables and objects instantiation

```java
public class Dog {
    public int weightInPounds;
    /*没有 static*/
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }
    }    
}

public class DogLauncher {
    public static void main(String[] args) {
        Dog d;
        d = new Dog();
        d.weightInPounds = 20;
        d.makeNoise();
    }
}
/* to simply using the constructor */
public class Dog {
    public int weightInPounds; /* this is instance variable : can have many of these as you want. */

    public Dog(int w) {
        weightInPounds = w;
    } /* this is the constructor */

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }    /* this is non-static method,a.k.a. instance method.if the method is going to be invoked by an instance of the class, then it should be non-static. roughly, if the method uses MY INSTANCE(dog w for example), it has to be non-static. */
    }
}
```

- An `Object` in Java is an instance of any class.
- The `Dog` class has its own variables, also known as *instance variables* or *non-static variables*. These must be declared inside the class, unlike languages like Python or Matlab, where new variables can be added at runtime.
- The method that we created in the `Dog` class did not have the `static` keyword. We call such methods *instance methods* or *non-static methods*.
- To call the `makeNoise` method, we had to first *instantiate* a `Dog` using the `new` keyword, and then make a specific `Dog` bark. In other words, we called `d.makeNoise()` instead of `Dog.makeNoise()`.
- Once an object has been instantiated, it can be *assigned* to a *declared* variable of the appropriate type, e.g. `d = new Dog();`
- Variables and methods of a class are also called *members* of a class.
- Members of a class are accessed using *dot notation*.

### static methods vs. instance methods

static methods can be invoked by calling the class name. `Dog.makeNosie()`

instance methods are invoked using an instance name.`maya.makeNoise()`

Static methods can't access **my** `this. ` instance variables.(e.g. `wightinPounds`),because there is no 'me'.



### public static void main(String[] args)

