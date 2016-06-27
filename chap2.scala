object test {
  def main(args : Array[String]): Unit ={
    //1. The signum of a number is 1 if the number is positive, –1 if it is negative, and
    //0 if it is zero. Write a function that computes this value
    // if else statement has a (return) type
    // no need to declare return type if function is not recursive
    def signum(num : Int) = if(num >= 0) 1 else -1
    print(signum(3))

    //2. What is the value of an empty block expression {}? What is its type?
    // {blabl;bla;} block expression contains a sequence of statement
    // {} expression's type is the type of last statement
    // empty statement is type Unit
    // d: Unit = ()
    val emptyBlock = {}

    //3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x .)
    // var - mutable variable
    // val x : Unit - assignment expression's type is Unit
    var y:Int = 0

    val x: Unit = y = 1

    /*4. Write a Scala equivalent for the Java loop
    for (int i = 10; i >= 0; i--) System.out.println(i);*/
    //(1)With a range and reverse
    (0 to 10).reverse.foreach(println)
    //(2) 1 to 10's reverse
    //left arrow means assignment
    for(i <- 10.to(1,-1)) println(i)


    /*5, Write a procedure countdown(n: Int) that prints the numbers from n to 0.*/
    /*Some people (not me) dislike this concise syntax for procedures and suggest that
      you always use an explicit return type of Unit:*/
    def countdown(n: Int): Unit ={
      n.to(0,-1).foreach(println)
    }
    countdown(10)

    /*6, Write a for loop for computing the product of the Unicode codes of all letters
     in a string. For example, the product of the characters in "Hello" is 825152896*/
    var productTemp = 1
    for(ch <- "fanwang") productTemp = productTemp * ch // The cool shit of String
    println(productTemp)

    /*7.Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
      Scaladoc.)*/
    var product1 = 1
    "fanwang".foreach(ch => {product1*=ch})
    println(product1)

    //8. Write a function product(s : String) that computes the product, as described
    //in the preceding exercises
    def product(s : String) : Long={
      var tmp: Long  = 1
      s.foreach(ch => tmp*=ch)
      tmp //{} block expression's type and value is the last statement's value and type
    }
    product("fanwang")

    /*9. Make the function of the preceding exercise a recursive function*/

    def productRecursive(s : String , i : Int) : Long = {
      var product : Long = 1
      if( i  == s.size - 1)
        s.charAt(i)
      else
      //don't do this : product *= productRecursive(s,i+1)
      // assignment is always type Unit
        s.charAt(i) * productRecursive(s,i+1)
    }

    productRecursive("fanwang",0)

    /*10. Write a function that computes xn, where n is an integer. Use the following
recursive definition:
• xn = y2 if n is even and positive, where y = xn / 2.
• xn = x· xn – 1 if n is odd and positive.
• x0 = 1.
• xn = 1 / x–n if n is negative.
Don’t use a return statement.*/
    import Math.abs;
    def power(x : Int, n : Int) : Double = {
      if(n == 0)
        1
      else if(n > 0){
        x*power(x,n-1)
      }else{
        1/(x*power(x,abs(n) - 1))
      }
    }
    assert(power(3,0) == 1)
    assert(power(3,2) == 9)
    assert(power(2,-1) == 0.5)

  }
}
