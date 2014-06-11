package Projects;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("input size key");
        int sizeKey = new Scanner(System.in).nextInt();
        JShifrHilla Hilla = new JShifrHilla(sizeKey);       
        System.out.println("Input key("+ (int)Math.pow(sizeKey, 2) +"symbols) :");
        Hilla.setKey(new Scanner(System.in).nextLine());
        System.out.println("Input Text");
        String shifr = Hilla.Shifruvannya(new Scanner(System.in).nextLine());
        System.out.println("Shifr:");
        System.out.println(shifr);
        String text = Hilla.DeShifruvannya(shifr);
        System.out.println("Text:");
        System.out.println(text);
	}

}
