package com.llollox.algorithms.problems.unitn.patterns;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class Singleton {

    public int n = 1;

    Singleton() {
        try {
            Thread.sleep(10000);
            this.n = 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Helper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Helper.INSTANCE;
    }


    public void test() {
        Log.w("singleton", "***********************************************");

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                Singleton singleton = Singleton.getInstance();
                Log.w("singleton", singleton.toString());
                Log.w("singleton", "" + singleton.n);
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    Singleton singleton = Singleton.getInstance();
                    Log.w("singleton", singleton.toString());
                    Log.w("singleton", "" + singleton.n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
