package demo;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by Charlie on 7/30/2015.
 */
@Entity
@Table(name="users")
public class User {

    protected User() {}

    /*public User(String inputText, LocalDateTime creationDate) {
        this.text = inputText;
        this.creationDate = creationDate;
    }*/


    @Id
    @Column(name = "userID", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private long userID;

    @Getter
    @Setter
    private String userName;

    public long getUserID(){
        return this.userID;
    }
}