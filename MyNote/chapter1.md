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



