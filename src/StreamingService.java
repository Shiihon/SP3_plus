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
        startMenu.loadUsers();
        mainMenu.loadMedia();

        loop();
    }

    public void loop() {
        running = true;

        while (running) {
            ui.displayMessage("\nWelcome to Netflix and Chill\n");

            startMenu.setup();

            if (startMenu.getUser() != null) {
                mainMenu.setUser(startMenu.getUser());
                mainMenu.setup();
            }

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
