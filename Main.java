import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a word:");
        String word = scanner.nextLine();

        String scrambled = new String(wordScrambler(word));
        System.out.println(scrambled);

        System.out.println("Which two letters do you want to swap?\nYou can exit by typing X and pressing enter.");
        while (true) {
            System.out.println("Give me the first letter's number:");
            String input1 = scanner.nextLine();
            if (input1.equals("x")) {
                break;
            }
            int firstLetter = Integer.parseInt(input1);


            System.out.println("Give me the second letter's number:");
            String input2 = scanner.nextLine();
            if (input2.equals("x")) {
                break;
            }
            int secondLetter = Integer.parseInt(input2);

            String slightlyLessScrambled = letterChanger(scrambled, firstLetter, secondLetter);
            scrambled = slightlyLessScrambled;
            System.out.println("The word is now: " + slightlyLessScrambled);
        }
    }

    public static char[] wordScrambler(String word) {
            char[] characters = word.toCharArray();
            Random random = new Random();

            for (int i = characters.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
            }
            return characters;
        }

        public static String letterChanger(String word, int firstLetter, int secondLetter) {
            char[] characters = word.toCharArray();
            char tempFirst = characters[firstLetter - 1];
            char tempSecond = characters[secondLetter - 1];
            characters[firstLetter - 1] = tempSecond;
            characters[secondLetter - 1] = tempFirst;

            String slightlyLessScrambled = new String(characters);

            return slightlyLessScrambled;
        }
    }
