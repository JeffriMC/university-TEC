package aplication;

import controllers.C_Main_Window;
import view.Main_View;

public class Main {
	public static void main(String[] args) {
		Main_View view_main = new Main_View("AyA");
		C_Main_Window controller = new C_Main_Window(view_main);
	}
}
