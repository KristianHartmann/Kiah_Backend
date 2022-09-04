package Entity.SchoolDB;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SEMESTER")
@Getter @Setter
public class Semester
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "currentsemester")
    private Set<Student> students = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "TEACHER_SEMESTER",
            joinColumns = @JoinColumn(name = "SEMESTER_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

    public Semester()
    {
    }

    public Semester(String description, String name)
    {
        this.description = description;
        this.name = name;
    }



}