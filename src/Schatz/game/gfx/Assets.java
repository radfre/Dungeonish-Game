package Schatz.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int width = 16;
	private static final int height = 16;
	private static final int p_width = 32, p_height = 32;
	private static final int k_width = 16, k_height = 16;

	// MapTiles

	public static BufferedImage dirt;
	public static BufferedImage grass;
	public static BufferedImage stone;
	public static BufferedImage water1;
	public static BufferedImage water2;
	public static BufferedImage lava;
	public static BufferedImage tree;
	public static BufferedImage wfloor;
	public static BufferedImage bot_wall;
	// player arrays
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_up;

	// player arrays
	public static BufferedImage[] kobold_down;
	public static BufferedImage[] kobold_left;
	public static BufferedImage[] kobold_right;
	public static BufferedImage[] kobold_up;

//MenuState stuff
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_options;
	public static BufferedImage[] btn_exit;

//reusable buttons
	public static BufferedImage[] btn_back;

// nonused buttons
	public static BufferedImage[] btn_title;

	public static void init() {
		SpriteSheet tile_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sprite_Sheet16x16_01.png"));
		SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/Players/Sprite_Sheet_16x16.png"));
		SpriteSheet kobold_sheet = new SpriteSheet(ImageLoader.loadImage("/Enemy/Sprite_Sheet_16x16.png"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/Buttons/MenuButtons.png"));

//MenuState 
		btn_start = new BufferedImage[2];
		btn_start[0] = menuSheet.crop(0, 0, 71, 30);
		btn_start[1] = menuSheet.crop(0, 30, 71, 30);

		btn_options = new BufferedImage[2];
		btn_options[0] = menuSheet.crop(71, 0, 92, 30);
		btn_options[1] = menuSheet.crop(71, 30, 92, 30);

		btn_exit = new BufferedImage[2];
		btn_exit[0] = menuSheet.crop(163, 0, 49, 30);
		btn_exit[1] = menuSheet.crop(163, 30, 49, 30);

//reusable Buttons
		btn_back = new BufferedImage[2];
		btn_back[0] = menuSheet.crop(163 + 49, 0, 49, 30);
		btn_back[1] = menuSheet.crop(163 + 49, 30, 49, 30);
//non used buttons
		btn_title = new BufferedImage[2];
		btn_title[0] = menuSheet.crop(0, 60, 163, 30);
		btn_title[1] = menuSheet.crop(0, 90, 163, 30);

//General player buffered arrays 
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];

		// Down player Buffered array
		player_down[0] = player_sheet.crop(p_width * 2, 0, p_width, p_height);
		player_down[1] = player_sheet.crop(p_width * 2, p_height, p_width, p_height);
		player_down[2] = player_sheet.crop(p_width * 2, p_height * 2, p_width, p_height);
		player_down[3] = player_sheet.crop(p_width * 2, p_height * 3, p_width, p_height);

		// up player Buffered arrays
		player_up[0] = player_sheet.crop(p_width, 0, p_width, p_height);
		player_up[1] = player_sheet.crop(p_width, p_height, p_width, p_height);
		player_up[2] = player_sheet.crop(p_width, p_height * 2, p_width, p_height);
		player_up[3] = player_sheet.crop(p_width, p_height * 3, p_width, p_height);

		// Left player buffered arrays
		player_left[0] = player_sheet.crop(p_width * 3, 0, p_width, p_height);
		player_left[1] = player_sheet.crop(p_width * 3, p_height, p_width, p_height);
		player_left[2] = player_sheet.crop(p_width * 3, p_height * 2, p_width, p_height);
		player_left[3] = player_sheet.crop(p_width * 3, p_height * 3, p_width, p_height);

		// Right player buffered arrays
		player_right[0] = player_sheet.crop(0, 0, p_width, p_height);
		player_right[1] = player_sheet.crop(0, p_height, p_width, p_height);
		player_right[2] = player_sheet.crop(0, p_height * 2, p_width, p_height);
		player_right[3] = player_sheet.crop(0, p_height * 3, p_width, p_height);

// General kobold buffered arrays
		kobold_down = new BufferedImage[2];
		kobold_up = new BufferedImage[2];
		kobold_left = new BufferedImage[4];
		kobold_right = new BufferedImage[4];

		// Down Kobold Buffered array
		kobold_down[0] = kobold_sheet.crop(0, 0, k_width, k_height);
		kobold_down[1] = kobold_sheet.crop(k_width, 0, k_width, k_height);
		

		// up Kobold Buffered arrays
		kobold_up[0] = kobold_sheet.crop(k_width * 2 + 2, 0, k_width, k_height);
		kobold_up[1] = kobold_sheet.crop(k_width * 3 + 2, 0, k_width, k_height);

		// Left Kobold buffered arrays
		kobold_left[0] = kobold_sheet.crop(k_width * 4 + 4, 0, k_width, k_height);
		kobold_left[1] = kobold_sheet.crop(k_width * 5 + 4, 0, k_width, k_height);
		kobold_left[2] = kobold_sheet.crop(k_width * 4 + 4, 0, k_width, k_height);
		kobold_left[3] = kobold_sheet.crop(k_width * 5 + 4, 0, k_width, k_height);

		// Right Kobold buffered arrays
		kobold_right[0] = kobold_sheet.crop(k_width * 4 + 4, k_height + 1, k_width, k_height);
		kobold_right[1] = kobold_sheet.crop(k_width * 5 + 4, k_height + 1, k_width, k_height);
		kobold_right[2] = kobold_sheet.crop(k_width * 4 + 4, k_height + 1, k_width, k_height);
		kobold_right[3] = kobold_sheet.crop(k_width * 5 + 4, k_height + 1, k_width, k_height);

//Materials 

		dirt = tile_sheet.crop(48, 0, width, height);
		grass = tile_sheet.crop(0, 0, width, height);
		stone = tile_sheet.crop(16, 16, width, height);
		water1 = tile_sheet.crop(176, 0, width, height);
		water2 = tile_sheet.crop(176, 0, width, height);
		lava = tile_sheet.crop(80, 16, width, height);
		wfloor= tile_sheet.crop(96, 16, width, height);
		bot_wall = tile_sheet.crop(208, 16, width, height);
	}
}
