package com.mgk.jvm;

import java.util.*;

public class CCTest {
    public static void main(String[] args) {
        HashMap l =new HashMap();
        ArrayList list = new ArrayList();
        for (int i = 0; i <12 ; i++) {
            l.put("a"+i,i);
        }
        Set set = l.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            String key =(String) iterator.next();
            System.out.println(" "+key+":"+key);
        }
        HashSet S  = new HashSet();
        set.iterator();
    }
    public static  void  code(){
    }
}
class  A{
    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    String name;
    String age;

    public A(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return Objects.equals(name, a.name) &&
                Objects.equals(age, a.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
