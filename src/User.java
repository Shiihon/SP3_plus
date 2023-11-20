import java.util.List;

public interface User {

    String getUserName();

    List<Media> getWatchedList();

    List<Media> getFavoriteList();
}
