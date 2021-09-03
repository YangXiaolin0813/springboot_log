package com.lyl.service;

import com.lyl.entity.Building;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableTask1 implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(getClass());
 
    @Override
    public void run(){
        Building building = new Building();
        synchronized (building){
            try {
                for (int i = 1;i <= 100;i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                    building.wait(200);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}