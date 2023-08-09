package mastermind5;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Mastermind5 {
	public static void game() throws InterruptedException {
		int guess_number, array1_length, c = 0;
		char r1 = 0, r2 = 0, r3 = 0, a1, a2, a3, a4,a0;
		System.out.println("Enter 1 to see a HINT! YOU WILL LOSE ONE CHANCE ");
		System.out.println("Enter 0 to restart the game!");
		System.out.println("Please JUST enter 5 CAPITAL LETTERS");
		System.out.println("Please enter number of guesses to START :)) : ");
		Scanner scanner = new Scanner(System.in);
		guess_number = scanner.nextInt(); // grftn tedad forsat ha braye hads az karbar

		int random_string_length = 5; // qarar ddne ye reshte 5 harfi random va zakhire krdnesh
		String[] all_characters = { "O", "Y", "P", "B", "R", "W", "P" }; // moshakhas krdne char haye mojaz
		int all_characters_length = all_characters.length; // peyda krdn tule string

		int min = 0;
		int max = all_characters_length - 1;

		String random_string = ""; // meghdar dehie avalie b random string
		for (int x = 1; x < random_string_length + 1; x++) {
			Random r = new Random(); // rand grftn
			int random_number = r.nextInt(max - min + 1) + min;
			String random_character = all_characters[random_number]; // meghdar dehi
			random_string += random_character; // ezafe shodn

		}
		a0=random_string.charAt(0);
		a1 = random_string.charAt(1); // peida krdnE dovomin charE random string
		a2 = random_string.charAt(2); // peida krdnE 3omin charE random string
		a3 = random_string.charAt(3); // peida krdnE 4omin charE random string
		a4 = random_string.charAt(4); // peida krdnE 5omin charE random string
		System.out.println("......_____");
		for (int i = 0; true; i++, guess_number--) {
			c = 0; // shomarandeye # ra 0 mknim
			Scanner s = new Scanner(System.in); // Grftne vurudi az karbar
			String array1 = s.nextLine();
			array1_length = array1.length(); // peyda krdne tule array1
			r3 = array1.charAt(0);// grftne avalin charE stringE vurudi k 0 hast ya na
			if (array1_length > 5 && r3 != ('0') && r3 != ('1')) {
				System.out.println("PLEASE ENTER 5 CHARACTERS");
			} else if (array1_length < 5 && r3 != ('0') && r3 != ('1')) {
				System.out.println("PLEASE ENTER 5 CHARACTERS");
			} else if (r3 == '0') {
				for (int j = 0; j <= 100; j++) {
					System.out.println(" ");
				}
				game(); // restart the game
			} else if (r3 == '1' && guess_number != 1) {
				JFrame frame = new JFrame(" ");
				frame.setAlwaysOnTop(true);
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				JLabel label = new JLabel(random_string);
				panel.add(label);
				frame.add(panel);
				frame.setSize(100, 100);
				frame.setLocationRelativeTo(null); // qaarar ddne frame dr markaze safe
				frame.setVisible(true); // neshan ddne frame
				TimeUnit.SECONDS.sleep(1); // 1 Sanye random string ra neshan dehad
				frame.setVisible(false); // baste shodne frame
			} else if (r3 == '1' && guess_number == 1) {
				System.out.print(" Game Over");
			} else {
				System.out.print("guess:");
				System.out.print(array1);
				System.out.print("      Number of chances left: ");
				System.out.println(guess_number - 1);
				System.out.print("......");
				for (int i1 = 0; i1 <= 4; i1++) { // moqayese charHa bhm
					r1 = random_string.charAt(i1);
					r2 = array1.charAt(i1);
					if (r1 == r2) {
						System.out.print("#");
						c++; // shemordne tedade # ha
					} else if (r2==a0||r2 == a1 || r2 == a2 || r2 == a3 || r2 == a4) {
						System.out.print("+");
					} else {
						System.out.print("-");
					}
				}
				System.out.println(" "); // ijade fasele baraye chape natije
				if (c == 5) {
					System.out.print(" That's Right :) ");
					scanner.close();
					break;
				} else if (guess_number == 1) {
					System.out.print(" Game Over");
					scanner.close();
					break;
				}
			}
		}
		System.out.println(" ");
		scanner.close();

	}

	public static void main(String[] args) throws InterruptedException {
		game();
	}

}
