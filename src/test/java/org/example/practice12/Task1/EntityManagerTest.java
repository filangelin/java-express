package org.example.practice12.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerTest {
    private EntityManager<User> users;
    private User user;
    private User user2;

    @BeforeEach
    public void setup() {
        users = new EntityManager<>();
        user = new User("Ivan", 22, true);
        user2 = new User("Anna", 25, false);

    }

    @Test
    public void addEntityTest() {
        User userNewObject = new User(user.getName(), user.getAge(), user.isActive());
        int initialSize = users.size();
        users.add(user);
        User actualUser = users.getAll().getFirst();
        assertAll(
                () -> assertEquals(userNewObject, actualUser),
                () -> assertEquals(initialSize + 1, users.size())
        );
    }

    @Test
    public void removeEntityTest() {
        users.add(user);
        int sizeAfterAdd = users.size();
        boolean isRemoved = users.remove(user);
        assertAll(
                () -> assertTrue(isRemoved),
                () -> assertEquals(sizeAfterAdd - 1, users.size())
        );
    }

    @Test
    public void shouldReturnFalseWhenRemoveNonExistingElement() {
        assertFalse(users.remove(user));
    }


    @Test
    public void getAllTest() {
        int initialSize = users.size();
        users.add(user);
        users.add(user2);
        var actualUsers = users.getAll();
        assertAll(
                () -> assertEquals(initialSize + 2, actualUsers.size()),
                () -> assertTrue(actualUsers.contains(user)),
                () -> assertTrue(actualUsers.contains(user2))
        );
    }

    @Test
    public void FilterByAgeTest() {
        var user3 = new User("Sveta", 18, false);
        var user4 = new User("Alla", 40, true);
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        var filteredUsers = users.filerByAge(18, 22);
        assertAll(
                () -> assertTrue(filteredUsers.contains(user3)),
                () -> assertTrue(filteredUsers.contains(user)),
                () -> assertFalse(filteredUsers.contains(user2)),
                () -> assertFalse(filteredUsers.contains(user4))
        );
    }

    @Test
    public void FilterByNameTest() {
        users.add(user);
        users.add(user2);
        var filteredUsers = users.filterByName("anna");
        assertAll(
                () -> assertTrue(filteredUsers.contains(user2)),
                () -> assertFalse(filteredUsers.contains(user))
        );
    }

    @Test
    public void FilterByActivityTest() {
        users.add(user);
        users.add(user2);
        var filteredUsers = users.filterByActivity(false);
        assertAll(
                () -> assertTrue(filteredUsers.contains(user2)),
                () -> assertFalse(filteredUsers.contains(user))
        );
    }

}