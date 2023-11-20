public class StreamingService {

    private final StartMenu startMenu;
    private final MainMenu mainMenu;

    public StreamingService() {
        startMenu = new StartMenu();
        mainMenu = new MainMenu();
    }

    public void start (){

    }

    public void loop (){
        boolean running = true;

        while (running) {


            startMenu.setup();
            mainMenu.setup();
        }
    }

    public void end (){

    }
}
