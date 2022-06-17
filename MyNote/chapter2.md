## List

### Bits

All information in your computer is stored in *memory* as a sequence of `1` and `0`.

#### primitive types

`int`,`double`,`short`,`byte`,`char`,`str`,`long`,`float`,`boolean`

One interesting observation is that both 72 and H are stored as 01001000. This raises the question: how does a piece of Java code know how to interpret 01001000?

The answer is through types! For example, consider the code below:

```java
char c = 'H';
int x = c;
System.out.println(c);
System.out.println(x);
>>> H
>>> 72
```

When you declare a variable of a certain type, Java finds a contiguous block with exactly enough bits to hold a thing of that type. For example, if you declare an int, you get a block of 32 bits. If you declare a byte, you get a block of 8 bits.

#### the golden rule of equals

When you write `y = x`, you are telling the Java interpreter to copy the bits**(box)** from x into y. 

#### reference type

despite the primitive types, evrything else,including arrays,is a reference type.

When we *declare* a variable of any reference type (Walrus, Dog, Planet, array, etc.), Java allocates a box of 64 bits, no matter what type of object:the 64 bit box contains **not** the data about the walrus, but instead the **address** of the Walrus in memory. (by the `new` method)

```java
Walrus someWalrus;
someWalrus = new Walrus(1000, 8.3);
```

The first line creates a box of 64 bits. The second line creates a new Walrus, and the address is returned by the `new` operator. These bits are then copied into the `someWalrus` box according to the GRoE.

According to the GRoE, the final line simply copies the **bits** (actually the 64-bits address) in the `a` box into the `b` box,namely the address. so the `a` and `b` point at the same object instantiation box.

#### parameter passing

it follows *the golden rule of equals*. That means that if we pass a object as a parameter of a class method, the local change inside the method will cause the global value change of the object, but it won't happen if we pass a primitive type data into a method as a parameter(because if it's a primitive type data, we just simply copy the bits,namely the value, not the address.)

### instantiation of arrays

```java
int[] a;
/*declaration of list a, (draw the box),creating a 64 bit address box*/
new int[]{0,1,2,95,4};
/*instantiation of a list, create a substantial new object,in this case an int arrays,it's anomynous*/
int[] a = new int[]{0,1,2,95,4};
/*assigment*/
```

Objects can be lost if you lose the bits corresponding to the address. For example if the only copy of the address of a particular Walrus is stored in `x`, then `x = null` will cause you to permanently lose this Walrus. 

### IntLists

```java
public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
}
```

#### size

```java
/*recursion*/
		public int size(IntList L){
      if (this.rest == null){
        return 1;
      }
      return 1 + this.rest.size();
      
    }
```

Exercise: You might wonder why we don't do something like `if (this == null) return 0;`. Why wouldn't this work?

Answer: Think about what happens when you call size. You are calling it on an object, for example L.size(). If L were null, then you would get a NullPointer error!

```java
/** Return the size of the list using no recursion! */
public int iterativeSize() {
    IntList p = this;
    int totalSize = 0;
    while (p != null) {
        totalSize += 1;
        p = p.rest;
    }
    return totalSize;
}
```

Why do we use the p to do the iterative process rather than `this`?

Because we cannot override `this`, it is a java keyword and it always refers to the current object. you can't reassign `this` in java.

#### get

```java
public int get(int i){
  if (i> this.size()){
    return NullPointerException;
  }elif (i == 0){
    return first;
  }else{
    return rest.get( i - 1);
  }
  
}
/*体会一下和下面这种写法的区别*/
public int get(int i, IntList L){
  if (i == 0){
    return L[0];
  }else{
    return get(i-1,L.rest);
  }
}
```

