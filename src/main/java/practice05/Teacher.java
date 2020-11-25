package practice05;

public class Teacher extends Person {
    private Integer klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return klass == null?
            super.introduce() + " I am a Teacher. I teach No Class."
            :
            super.introduce() + String.format(" I am a Teacher. I teach Class %d.", klass);
    }
}
