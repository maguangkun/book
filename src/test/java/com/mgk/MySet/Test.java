package com.mgk.MySet;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class Test implements Serializable {
    public static void main(String[] args) throws IOException {
            File file = new File("D://A.zip");
            if(!file.exists()){
                file.createNewFile();
            }




//        Rongqi rongqi = new Rongqi();
//        ShengChan shengChan = new ShengChan(rongqi);
//        XiaoFei xiaoFei = new XiaoFei(rongqi);
//        Thread t1 = new Thread(shengChan);
//        Thread t2 = new Thread(xiaoFei);
//        t1.start();
//        t2.start();
    }
    public static int gcd (int a, int b) {
        // write code here
        //判断a>b
        for(int i=a;i<0;i--){
            if(a%i==0){
                if(b%i==0){
                    return i;
                }
            }
        }
        return  a;
    }
}


/**
 * 生产者
 */
class ShengChan implements Runnable{
    private  Rongqi Rongqi;

    public ShengChan(com.mgk.MySet.Rongqi rongqi) {
        Rongqi = rongqi;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Rongqi.push(new Check(i+""));
            System.out.println("生产了"+i+"只鸡肉");
        }
    }
}

/**
 * 消费者
 */
class XiaoFei implements Runnable{
    private  Rongqi Rongqi;

    public XiaoFei(com.mgk.MySet.Rongqi rongqi) {
        Rongqi = rongqi;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+Rongqi.pop().getId()+"只鸡");
        }
    }
}

/**
 * 容器
 */
class Rongqi{
    private Check[]  checks = new Check[15];

    private int count = 0;

    /**
     * 推
     */
    public synchronized void push(Check check) throws InterruptedException {
        if(count==checks.length){//容器内容满了就需要停止生产
            System.out.println("容器满了需要等会再生产");
            this.wait();
        }
        checks[count++]=check;
        this.notify();
        System.out.println("通知消费者");
    }

    /**
     * 取
     * @return
     */
    public synchronized Check pop() throws InterruptedException {
        Check check  = null;
        if(count==0){//容器内没东西停止消费
            System.out.println("容器空了需要等待");
            this.wait();
        }
        //通知生产
        check = checks[--count];
        this.notify();
        System.out.println("正在消费通知生产者");
        return check;
    }
}

/**
 * 产品
 */
class Check{
    private String id;

    @Override
    public String toString() {
        return "Check{" +
                "id='" + id + '\'' +
                '}';
    }

    public Check(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return Objects.equals(getId(), check.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
