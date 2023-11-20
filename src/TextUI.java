import java.util.Scanner;

public class TextUI {

    private final Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String msg) {
        this.displayMessage(msg);
        return scanner.nextLine();
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
