import java.util.LinkedList;
import java.util.List;

public abstract class AUser implements User {

    private final String userName;
    private final String password;
    private List<Media> watchedMedia;
    private List<Media> favorites;

    public AUser(String useName, String password) {
        this.userName = useName;
        this.password = password;

        this.watchedMedia = new LinkedList<>();
        this.favorites = new LinkedList<>();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public List<Media> getWatchedList() {
        return watchedMedia;
    }

    @Override
    public List<Media> getFavoriteList() {
        return favorites;
    }
}
