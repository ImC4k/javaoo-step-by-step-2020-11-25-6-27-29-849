package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private Student leader;
    private List<Student> students = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (!students.contains(leader)) {
            System.out.print("It is not one of us.\n");
        }
        else {
            this.leader = leader;
        }
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public void appendMember(Student student) {
        students.add(student);
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber() == this.getNumber();
    }
}
