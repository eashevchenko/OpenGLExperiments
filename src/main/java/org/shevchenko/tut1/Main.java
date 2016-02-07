package org.shevchenko.tut1;

import org.shevchenko.core.LWJGLCore;
import org.shevchenko.core.IScreen;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        try {
            IScreen screen = new TestScreen();
            LWJGLCore lwjglCore = new LWJGLCore("Test01", 600, 480, screen);
            lwjglCore.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
}
