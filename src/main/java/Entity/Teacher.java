package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TEACHER")
@Getter @Setter
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToMany
    @JoinTable(name = "TEACHER_SEMESTER",
            joinColumns = @JoinColumn(name = "TEACHER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SEMESTER_ID"))
    private Set<Semester> semesters = new LinkedHashSet<>();

    public Teacher()
    {
    }

    public Teacher(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }



}