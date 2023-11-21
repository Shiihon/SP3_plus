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

            String input = ui.getChoiceYN("Do you wish to quit? (Y/N) ");

            switch (input) {
                case "Y":
                    end();
                    break;
                case "N":
                    break;
            }
        }
    }

    public void end() {
        ui.displayMessage("Quitting...");
        running = false;
    }
}
