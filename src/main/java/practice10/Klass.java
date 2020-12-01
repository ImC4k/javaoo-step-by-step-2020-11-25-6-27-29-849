package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final Integer number;
    private Student leader;
    private final List<Student> students = new ArrayList<>();

    private final List<KlassNewJoinObserver> newJoinObservers = new ArrayList<>();
    private final List<KlassNewLeaderObserver> newLeaderObservers = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
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
            notifyNewLeader(newLeader);
        }
    }

    private void notifyNewLeader(Student newLeader) {
        newLeaderObservers.forEach(klassNewLeaderObserver -> klassNewLeaderObserver.updateOnNewLeader(newLeader, this));
    }

    public void appendMember(Student newStudent) {
        students.add(newStudent);
        notifyNewJoiner(newStudent);
    }

    private void notifyNewJoiner(Student newStudent) {
        newJoinObservers.forEach(newJoinObserver -> newJoinObserver.updateOnNewJoin(newStudent, this));
    }

    public String getDisplayName() {
        return String.format("Class %d", number);
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber().equals(this.number);
    }

    public void attachNewJoinObserver(KlassNewJoinObserver observer) {
        this.newJoinObservers.add(observer);
    }

    public void attachNewLeaderObserver(KlassNewLeaderObserver observer) {
        this.newLeaderObservers.add(observer);
    }
}
