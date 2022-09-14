package Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fname", length = 45)
    private String fname;

    @Column(name = "lname", length = 45)
    private String lname;

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "created")
    private String created;

    @Column(name = "lastedited")
    private String lastedited;

    public Person() {

    }

    public Person(Integer id, String fname, String lname, String phone, String created, String lastedited) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.phone = phone;
    this.created = created;
    this.lastedited = lastedited;
    }

    public Person(String fName, String lName, String phone) {
    this.fname = fName;
        this.lname= lName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastedited() {
        return lastedited;
    }

    public void setLastedited(String lastedited) {
        this.lastedited = lastedited;
    }

}