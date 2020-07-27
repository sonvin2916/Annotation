package com.dummyproject;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Narayn", comments = "Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("Old method,dont use it");
    }

    public static void main(String[] args) {

        try
        {
            for (Method method : AnnotationExample.class.getMethods())
            {
                if (method.isAnnotationPresent(MethodInfo.class))
                {
                    try
                    {
                        for (Annotation anno : method.getDeclaredAnnotations())
                        {
                            System.out.println("Annotation in mehod '"+method+"':"+anno);

                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if ( methodAnno.revision()==1)
                        {
                            System.out.println("Method with revision no 1 ="+method);
                        }
                    }
                    catch (Throwable ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e)
        {
            e.printStackTrace();
        }
    }
}
