package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private Student leader;
    private List<Student> students = new ArrayList<>();

    private Teacher teacher = null;

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

    public void assignLeader(Student newLeader) {
        if (!students.contains(newLeader)) {
            System.out.print("It is not one of us.\n");
        }
        else {
            this.leader = newLeader;
            if (teacher != null) {
                teacher.handleClassLeaderChange(this, newLeader);
            }
        }
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public void appendMember(Student newStudent) {
        students.add(newStudent);
        if (teacher != null) {
            teacher.handleNewStudentJoiningClass(this, newStudent);
        }
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber() == this.number;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
