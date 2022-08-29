package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String type;
    String sound;

    public Animal(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }

    public Animal() {

    }
}
