import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String username;
    private boolean online;

    private UserExtraInfo userExtraInfo;

    public User(){}

    public User(int id, String username, boolean isOnline) {
        this.id = id;
        this.username = username;
        this.online = isOnline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public UserExtraInfo getUserExtraInfo() {
        return userExtraInfo;
    }

    public void setUserExtraInfo(UserExtraInfo userExtraInfo) {
        this.userExtraInfo = userExtraInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", online=" + online +
                '}';
    }
}
