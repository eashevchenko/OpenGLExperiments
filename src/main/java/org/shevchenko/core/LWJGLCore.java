package org.shevchenko.core;


public class LWJGLCore implements Runnable {

    public static final int TARGET_FPS = 75;

    public static final int TARGET_UPS = 30;

    private final LWJGLWindow window;

    private final Thread gameLoopThread;

    private final LWJGLTimer timer;

    private final IScreen screen;

    public LWJGLCore(String windowTitle, int width, int height, IScreen screen) throws Exception {
        gameLoopThread = new Thread(this, "LOOP_THREAD");
        window = new LWJGLWindow(windowTitle, width, height);
        this.screen = screen;
        timer = new LWJGLTimer();
    }

    public void start() {
        gameLoopThread.start();
    }

    @Override
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        }
    }

    protected void init() throws Exception {
        window.init();
        timer.init();
        screen.init();
    }

    protected void gameLoop() {
        float ellapsedTime;
        float accumulator = 0f;
        float interval = 1f / TARGET_UPS;

        boolean running = true;
        while (running && !window.windowShouldClose()) {
            ellapsedTime = timer.getEllapsedTime();
            accumulator += ellapsedTime;

            input();

            while (accumulator >= interval) {
                update(interval);
                accumulator -= interval;
            }

            render();

            sync();
        }
    }

    private void sync() {
        float loopSlot = 1f / TARGET_FPS;
        double endTime = timer.getLastLoopTime() + loopSlot;
        while (timer.getTime() < endTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ie) {
            }
        }
    }

    protected void input() {
        screen.input(window);
    }

    protected void update(float interval) {
        screen.update(interval);
    }

    protected void render() {
        screen.render(window);
        window.update();
    }
}