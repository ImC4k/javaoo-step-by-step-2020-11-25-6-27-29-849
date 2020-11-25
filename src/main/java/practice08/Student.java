package practice08;


public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
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
        String introduction = super.introduce() + " I am a Student.";
        if (klass.getLeader() != null && klass.getLeader().equals(this)) {
            introduction += String.format(" I am Leader of %s.", klass.getDisplayName());
        }
        else {
            introduction += String.format(" I am at %s.", klass.getDisplayName());
        }
        return introduction;
    }
}
