import java.util.List;
import java.util.Scanner;

public class TextUI {

    private final Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int getChoice(String msg, List<String> options) {
        displayOptions(options);

        String input = getInput(msg);

        try {
            int choice = Integer.parseInt(input);

            if (choice >= 1 && choice <= options.size()) {
                return choice;
            }
        } catch (NumberFormatException ignored) {
        }

        displayMessage("Please choose a valid option.");
        return getChoice(msg, options);
    }

    public String getChoiceYN(String msg) {
        String input = getInput(msg);

        if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {
            return "Y";
        } else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No")) {
            return "N";
        } else {
            displayMessage("Please choose a valid option.");
            return getChoiceYN(msg);
        }
    }

    public void displayOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            displayMessage("[" + (i+1) + "] " + options);
        }
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
