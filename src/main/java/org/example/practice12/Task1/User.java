package org.example.practice12.Task1;

public class User extends Entity {
    public User(String name, int age, boolean isActive) {
        super(name, age, isActive);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return (user.getName().equals(this.getName())
                && user.getAge() == this.getAge()
                && user.isActive() == this.isActive());
    }
}
