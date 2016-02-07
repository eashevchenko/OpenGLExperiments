package org.shevchenko.core;

public interface IScreen {

    void init() throws Exception;

    void input(LWJGLWindow window);

    void update(float interval);

    void render(LWJGLWindow window);

    void cleanup();
}
