package Schatz.game.states;

import java.awt.Color;
import java.awt.Graphics;

import Schatz.game.Handler;
import Schatz.game.gfx.Assets;
import Schatz.game.ui.ClickListener;
import Schatz.game.ui.UIImageButton;
import Schatz.game.ui.UIManager;

public class InGameOptionState extends State {

	public UIManager igouiManager;

	@Override
	public UIManager getui() {
		return igouiManager;
	}

	public InGameOptionState(Handler handler) {
		super(handler);
		igouiManager = new UIManager(handler);

		igouiManager.addObject(o_Options);
		igouiManager.addObject(o_Exit);
	}

	@Override
	public void tick() {
		igouiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, 640*2, 360*2);
		handler.getGame().gameState.render(g);

		g.setColor(new Color(75, 25, 0));
		g.fillRect(270 * 2 - 5, 280 * 2 - 5, 92 * 2 + 10, 30 * 2 + 10);
		g.fillRect(290 * 2 - 5, 320 * 2 - 5, 49 * 2 + 10, 30 * 2 + 10);

		igouiManager.render(g);
	}

	// BUTTONS

	public UIImageButton o_Options = new UIImageButton(270 * 2, 280 * 2, 92 * 2, 30 * 2, Assets.btn_back,
			new ClickListener() {

				@Override
				public void onClick() {
					// handler.getGame().gameState = GameState;
					State.setState(handler.getGame().gameState);

					handler.getMouseManager().setUIManager(handler.getGame().gameState.getui());
				}
			});

	public UIImageButton o_Exit = new UIImageButton(290 * 2, 320 * 2, 49 * 2, 30 * 2, Assets.btn_exit,
			new ClickListener() {

				@Override
				public void onClick() {
					System.exit(0);
				}

			});

}
