package com.dummyproject;

public class PrintMyArray  <X, Y, Z> {
    X[] myXArray;
    Y[] myYArray;
    Z[] myZArray;
    public PrintMyArray(X[] myXArray, Y[] myYArray, Z[] myZArray)
    {
        this.myXArray=myXArray;
        this.myYArray=myYArray;
        this.myZArray=myZArray;
    }

    public static void main(String[] args)
    {
        Integer[] a = {1,2,3};
        Double[]b={1.1,1.2,1.3};
        Character[] c = {'a','b','c'};
        toPrint(a);
        toPrint(b);
        toPrint(c);
        new PrintMyArray<Integer, Double, Character>(a, b, c).toPrint();


    }
    private void toPrint()
    {
        toPrint(myXArray);
        toPrint(myYArray);
        toPrint(myZArray);

    }

    private static <E> void toPrint(E[] a)
    {
        for(E i : a)
        {
            System.out.println(i);
        }
    }

}
