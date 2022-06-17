# <center>project0</center>

## what is a constructor?

```java
public class Dog {
    String _name;
    String _breed;
    int _age;

    public Dog(String name, String breed, int age) {
        _name = name;
        _breed = breed;
        _age = age;
    }
}
```

The `Dog` class has three non-static fields. Each instance of the `Dog` class can have a name, a breed, and an age. Our simple **constructor**, which takes three arguments, **initializes** these fields for all new `Dog` objects.

```java
public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName; 
	private static final double G = 6.67e-11; 
  
  /*首先声明类有哪些属性，再利用下面的constructor传入实例的具体属性*/
  
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
```

Constructor has the same name of the `class`, and it takes the actual values of arguments that define a planet. in the constructor, the arguments of class are assigned to the values the constructor takes in by using expressions.

## scientific notation

java support scientific notation. like :

$G = 6.67 \times 10^{-11}$

```java
private static final double G = 6.67e-11;
private static final double G = 6.67E-11;
```



## Std.in

```java
public class In
/*initializing */
In in = new In(path); /*path 是要读取的文本文件的路径*/
in.readDouble();
in.readInt();
in.readString();
/*在一次调用执行中，读取是有记忆和顺序的。不会每一次都从头开始读取，正因为如此，可以用for循环读取行星的数据。
例如，先知道了有5个行星（list.length），那么先for五个循环，每个循环读取六次（xp,yp,xv,yv,m,img），可以巧妙的读取行星数据*/
```

![3792725344-618ca8f562543_fix732](/Users/yecong/Desktop/cs61b/projectIMG/3792725344-618ca8f562543_fix732.webp)

## Std.out

