import java.util.HashMap;
import java.util.Map;

public class StartMenu  extends AMenu {

    private final Map<String, String > users;

    public StartMenu() {
        users = new HashMap<>();
    }

    private boolean login(String userName, String password){
        return false;
    }
    private boolean register(String userName, String password){
       return false;
    }

    private void runUserDialog(){

    }

    private void loadUserData(String userName){

    }
    @Override
    public void setup() {

    }

    public void loadUsers(){

    }

    public void saveUsers(){

    }

}
