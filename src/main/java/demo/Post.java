package demo;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by Charlie on 7/30/2015.
 */
@Entity
@Table(name="posts")
public class Post {

    protected Post() {}


    public Post(String inputText, String userName) {
        this.text = inputText;
        this.creationDate = LocalDateTime.now();
        //TODO: username should go in user table
        this.userName = userName;
    }


    @Id
    @Column(name = "postID", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private long postID;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private LocalDateTime creationDate;

    @Getter
    @Setter
    private String text;
}