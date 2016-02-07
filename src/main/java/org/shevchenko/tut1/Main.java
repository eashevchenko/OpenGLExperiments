package org.shevchenko.tut1;

import org.lwjgl.opengl.GL11;
import org.shevchenko.core.Core;
import org.shevchenko.core.interfaces.IScreen;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        try {
            IScreen screen = new TestScreen();
            Core core = new Core("Test01", 600, 480, screen);
            core.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
}
