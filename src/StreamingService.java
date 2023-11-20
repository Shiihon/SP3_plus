public class StreamingService {

    private final StartMenu startMenu;
    private final MainMenu mainMenu;
    private final TextUI ui;

    private boolean running;

    public StreamingService() {
        startMenu = new StartMenu();
        mainMenu = new MainMenu();
        ui = new TextUI();
    }

    public void start() {
        loop();
    }

    public void loop() {
        running = true;

        while (running) {
            ui.displayMessage("Welcome to Chad-Dave-Steve&Mark-Flix#Pump");

            startMenu.setup();
            mainMenu.setup();

            boolean validOption = false;

            while (!validOption) {
                validOption = true;

                switch (ui.getInput("Do you wish to quit? (Y/N)").trim().toUpperCase()) {
                    case "Y":
                        running = false;
                        break;
                    case "N":
                        break;
                    default:
                        ui.displayMessage("Not a valid option");
                        validOption = false;
                }
            }
        }
    }

    public void end() {
        running = false;
    }
}
