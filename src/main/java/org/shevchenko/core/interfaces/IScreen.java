package org.shevchenko.core.interfaces;

import org.shevchenko.core.Window;

public interface IScreen {

    void init() throws Exception;

    void input(Window window);

    void update(float interval);

    void render(Window window);

    void cleanup();
}
