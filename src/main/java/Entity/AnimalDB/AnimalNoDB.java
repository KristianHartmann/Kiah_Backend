package Entity.AnimalDB;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalNoDB {
    String type;
    String sound;

    public AnimalNoDB(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }
}