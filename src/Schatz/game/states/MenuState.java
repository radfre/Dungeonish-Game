package Schatz.game.states;

import java.awt.Color;
import java.awt.Graphics;

import Schatz.game.Handler;
import Schatz.game.gfx.Assets;
import Schatz.game.ui.ClickListener;
import Schatz.game.ui.UIImageButton;
import Schatz.game.ui.UIManager;

public class MenuState extends State {

	public UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(strt);
		
		uiManager.addObject(options);

		uiManager.addObject(exit);
		
		uiManager.addObject(title);
		
		
	}
	
	@Override
	public UIManager getui() {
		return uiManager;
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640*2, 360*2);
		uiManager.render(g);
	}
	
	//BUTTONS
	public UIImageButton strt = new UIImageButton(280*2, 240*2, 71*2, 30*2, Assets.btn_start, new ClickListener() {

		@Override
		public void onClick() {
			//System.exit(0);
			handler.getGame().createGState();
			handler.getMouseManager().setUIManager(null);
			State.setState(handler.getGame().gameState);
			
			
		}
		
		
		
	});
	
	public UIImageButton exit = new UIImageButton(290*2, 320*2, 49*2, 30*2, Assets.btn_exit, new ClickListener() {

		@Override
		public void onClick() {
			System.exit(0);
		}
		
	});
	
	public UIImageButton options = new UIImageButton(270*2, 280*2, 92*2, 30*2, Assets.btn_options, new ClickListener() {
		
		@Override
		public void onClick() {
			handler.getGame().optionsState = new OptionsState(handler);
			State.setState(handler.getGame().optionsState);
			
			handler.getMouseManager().setUIManager(handler.getGame().optionsState.getui());
		}
	});
	
	public UIImageButton title = new UIImageButton(200*2, 50*2, 250*2, 30*2, Assets.btn_title, new ClickListener() {
		
		@Override
		public void onClick() {
			
		}
	});
}
