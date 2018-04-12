package dev.brian.com.drawer_navigation.Model;

import io.realm.RealmObject;

/**
 * Created by brian-kamau on 4/12/18.
 */

public class Student extends RealmObject {

    String name;
    int marks;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
