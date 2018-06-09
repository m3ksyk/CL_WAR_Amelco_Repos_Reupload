import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest {

    private UserRepository userRepository = new UserRepository();
    private User user;

    @Before
    public void setUp() {
        user = userRepository.create("Alice");
    }

    @Test
    public void shouldCreateUser() {
        assertThat(user.getName(), is("Alice"));
        assertThat(userRepository.getCount(), is(1));
    }

    @Test
    public void shouldHaveNonNullId() {
        assertThat(user.getId(), is(notNullValue()));
    }

    @Test
    public void shouldEditUser() {

        user.setName("Bob");
        userRepository.save(user);

        User foundUser = userRepository.findById(user.getId());

        assertThat(foundUser, is(notNullValue()));
        assertThat(foundUser.getName(), is("Bob"));
    }

    @Test
    public void shouldDeleteUser() {

        userRepository.delete(user);

        assertThat(userRepository.getCount(), is(0));

        User foundUser = userRepository.findById(user.getId());
        assertThat(foundUser, is(nullValue()));
    }
}