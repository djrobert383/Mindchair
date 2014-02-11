import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Sound;

public class Main implements ButtonListener {
	public static void main(String[] args) {
		new Main();
	}

	public final int C4 = 261;
	public final int D4 = 294;
	public final int E4 = 329;
	public final int F4 = 349;
	public final int G4 = 392;
	public final int A4 = 440;
	public final int Ab4 = 415;
	public final int B4 = 493;

	public final int C5 = 523;
	public final int D5 = 587;
	public final int E5 = 659;
	public final int F5 = 698;
	public final int G5 = 783;
	public final int A5 = 830;
	public final int B5 = 987;

	public boolean nothingSelected = true;
	public int selectedOption;
	public final int[] melody1 = { E4, E5, G5, Ab4, A4, E5 };
	public final int[] melody1Length = { 150, 75, 300, 75, 150, 75, 200 };
	public final int[] melody2 = { 500, 400, 300, 200 };

	public Main() {
		Button.LEFT.addButtonListener(this);
		Button.RIGHT.addButtonListener(this);
		Button.ENTER.addButtonListener(this);
		Button.ESCAPE.addButtonListener(this);
		options();
	}

	public void options() {
		Sound.setVolume(50);
		selectedOption = 1;
		clearScreen();
		System.out.println("Select Melody:");
		selection(true, "Melody 1");
		selection(false, "Melody 2");
		while (nothingSelected) {

		}
	}

	public void clearScreen() {
		for (int i = 0; i < 7; i++) {
			System.out.println();
		}
	}

	public void selection(boolean selected, String text) {
		if (selected) {
			System.out.println(">" + text);
		} else {
			System.out.println(" " + text);
		}

	}

	@Override
	public void buttonPressed(Button b) {
		if (b.equals(Button.LEFT)) {
			selectedOption = 1;
			clearScreen();
			System.out.println("Select Melody:");
			selection(true, "Melody 1");
			selection(false, "Melody 2");
		}
		if (b.equals(Button.RIGHT)) {
			selectedOption = 2;
			clearScreen();
			System.out.println("Select Melody:");
			selection(false, "Melody 1");
			selection(true, "Melody 2");
		}
		if (b.equals(Button.ENTER)) {
			playMelody(selectedOption);
		}
		if (b.equals(Button.ESCAPE)) {
			nothingSelected = false;
		}
	}

	@Override
	public void buttonReleased(Button b) {

	}

	public void playMelody(int melody) {
		if (melody == 1) {
			for (int ii = 0; ii < 16; ii++) {
				for (int i = 0; i < melody1.length; i++) {
					Sound.playNote(Sound.XYLOPHONE, melody1[i],
							melody1Length[i]);
				}

			}
		}
		if (melody == 2) {
			Sound.playSample(new File("Guitar.wav"));
		}
	}
}
