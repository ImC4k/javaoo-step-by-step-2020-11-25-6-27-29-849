package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return klass == null?
                super.introduce() + " I am a Teacher. I teach No Class."
                :
                super.introduce() + String.format(" I am a Teacher. I teach Class %d.", klass.getNumber());
    }

    public String introduceWith(Student student) {
        if (klass == null || student.getKlass().getNumber() != klass.getNumber())
            return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
        else
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
    }
}