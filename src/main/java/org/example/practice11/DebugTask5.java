package org.example.practice11;

public class DebugTask5 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        person.updateAge();
        System.out.println("Updated age: " + person.getAge());
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void updateAge() {
        this.age++;
    }


}
