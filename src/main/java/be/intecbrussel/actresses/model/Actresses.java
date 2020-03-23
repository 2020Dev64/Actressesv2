package be.intecbrussel.actresses.model;

public class Actresses {

    private int ID;
    private String name;
    private String surname;
    private int age;

    public Actresses(int ID, String name, String surname, int age) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Actresses{" +
                "ID=" + (ID-1) +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age + '\n';
    }
}
