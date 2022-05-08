package ca.georgebrown.comp3074.adulting;

public class User {
    public String fullName, age, email, journal;

    public User(String fullName, String age, String email){
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public User(String journal) {
        this.journal = journal;
    }


    public User(String fullName, String age, String email, String journal){
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.journal = journal;
    }

}
