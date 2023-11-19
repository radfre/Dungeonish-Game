package Schatz.game.states;

import java.awt.Color;
import java.awt.Graphics;

import Schatz.game.Handler;
import Schatz.game.gfx.Assets;
import Schatz.game.ui.ClickListener;
import Schatz.game.ui.UIImageButton;
import Schatz.game.ui.UIManager;

public class OptionsState extends State {

	public UIManager ouiManager;
	
	@Override
	public UIManager getui() {
		return ouiManager;
	}

	public OptionsState(Handler handler) {
		super(handler);
		ouiManager = new UIManager(handler);
		
		
		
		ouiManager.addObject(o_Options);
		ouiManager.addObject(o_Exit);
	}

	@Override
	public void tick() {
		ouiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640*2, 360*2);
		ouiManager.render(g);

	}

	// BUTTONS

public UIImageButton o_Options = new UIImageButton(270*2, 280*2, 92*2, 30*2, Assets.btn_back, new ClickListener() {
		
		@Override
		public void onClick() {
			handler.getGame().menuState = new MenuState(handler);
			State.setState(handler.getGame().menuState);
			
			handler.getMouseManager().setUIManager(handler.getGame().menuState.getui());
		}
	});

	public UIImageButton o_Exit = new UIImageButton(290*2, 320*2, 49*2, 30*2, Assets.btn_exit, new ClickListener() {

		@Override
		public void onClick() {
			System.exit(0);
		}

	});

}
