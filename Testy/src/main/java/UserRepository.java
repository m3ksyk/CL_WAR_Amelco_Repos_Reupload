import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepository {

    private final Map<UUID, User> users = new HashMap<UUID, User>();

    public User create(String name) {
        User user = new User(name);
        save(user);
        return user;
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(UUID id) {
        return users.get(id);
    }

    public void delete(User user) {
        users.remove(user.getId());
    }

    public int getCount() {
        return users.size();
    }
}
