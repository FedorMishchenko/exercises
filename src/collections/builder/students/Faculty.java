package collections.builder.students;

public class Faculty {
    private String faculty;
    private int course;
    private int group;

    public String getFaculty() {
        return faculty;
    }

    public Faculty setFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public int getCourse() {
        return course;
    }

    public Faculty setCourse(int course) {
        this.course = course;
        return this;
    }

    public int getGroup() {
        return group;
    }

    public Faculty setGroup(int group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("faculty='").append(faculty).append('\'');
        sb.append(", course=").append(course);
        sb.append(", group=").append(group);
        return sb.toString();
    }
}
