package aplication;

import controllers.C_Main_Window;
import models.Water_Plant;
import view.Main_View;

public class Main {
	public static void main(String[] args) {
		Water_Plant water_plant = new Water_Plant("AYA");
		GLOBALS.AYA_DB.insert_root(water_plant);
		Main_View view_main = new Main_View("AyA");
		C_Main_Window controller = new C_Main_Window(view_main);
	}
}
