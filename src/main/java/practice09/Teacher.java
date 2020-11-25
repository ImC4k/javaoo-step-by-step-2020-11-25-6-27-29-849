package practice09;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public List<Klass> getClasses() {
        return klasses;
    }

    public void setClasses(List<Klass> klasses) {
        this.klasses = klasses;
    }

    @Override
    public String introduce() {
        return klasses == null || klasses.isEmpty()?
                super.introduce() + " I am a Teacher. I teach No Class."
                :
                super.introduce() +
                        String.format(" I am a Teacher. I teach Class %s.",
                            klasses.stream()
                            .map(Klass::getNumber)
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
                );
    }

    public String introduceWith(Student student) {
        if (klasses.isEmpty() || !isTeaching(student))
            return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
        else
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
    }

    public boolean isTeaching(Student student) {
        return !klasses.stream()
                .filter(klass ->
                        klass.isIn(student))
                .collect(Collectors.toList())
                .isEmpty();
    }
}
