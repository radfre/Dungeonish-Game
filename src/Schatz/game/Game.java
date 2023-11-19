package Schatz.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Schatz.game.display.Display;
import Schatz.game.gfx.Assets;
import Schatz.game.gfx.GameCamera;
import Schatz.game.input.KeyManager;
import Schatz.game.input.MouseManager;
import Schatz.game.states.GameState;
import Schatz.game.states.MenuState;
import Schatz.game.states.OptionsState;
import Schatz.game.states.State;

public class Game implements Runnable{

	private Display display;	
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//states 
	public State gameState;
	public State menuState;
	public State optionsState;
	public State igoptionsState;

	
	//input 
	private KeyManager keyManager;
	private MouseManager mouseManag;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManag = new MouseManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManag);
		display.getFrame().addMouseMotionListener(mouseManag);
		display.getCanvas().addMouseListener(mouseManag);
		display.getCanvas().addMouseMotionListener(mouseManag);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		menuState = new MenuState(handler);
		

		
		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) 
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g= bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//draw here
		
		if(State.getState() != null) 
			State.getState().render(g);
		
		//end drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
			tick();
			ticks++;
			delta--;
			}
			render();
			frames++;

			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				display.getFrame().setTitle("Tile game FPS: " + frames + " | UPS: " + ticks);
				ticks= 0;
				frames = 0;
			}
		}
		
		stop();
	
		
	}
	
	public void createGState() {
		menuState = null;
		gameState = new GameState(handler);
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManag;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) 
			return; 
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
