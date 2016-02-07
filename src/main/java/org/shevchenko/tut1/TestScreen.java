package org.shevchenko.tut1;

import org.apache.log4j.Logger;
import org.shevchenko.core.IScreen;
import org.shevchenko.core.LWJGLWindow;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.opengl.GL11.glViewport;

public class TestScreen implements IScreen {

    private final Logger logger = Logger.getLogger(TestScreen.class);

    private int direction = 0;

    private float color = 0.0f;

    private final ScreenRenderer renderer;

    public TestScreen() {
        renderer = new ScreenRenderer();
    }

    @Override
    public void init() throws Exception {
        renderer.init();
    }

    @Override
    public void input(LWJGLWindow window) {
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            direction = 1;
        } else if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            direction = -1;
        } else {
            direction = 0;
        }
    }

    @Override
    public void update(float interval) {
        color += direction * 0.01f;
        if (color > 1) {
            color = 1.0f;
        } else if (color < 0) {
            color = 0.0f;
        }
    }

    @Override
    public void render(LWJGLWindow window) {
        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
            logger.info("size: " + window.getWidth() + ": " + window.getHeight());
        }

        window.setClearColor(color, color, color, 0.0f);
        renderer.render(window);
    }

    @Override
    public void cleanup() {
        renderer.cleanup();
    }
}
