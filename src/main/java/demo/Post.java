package demo;

import javax.persistence.*;

import demo.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Charlie on 7/30/2015.
 */
@Entity
@Table(name="posts")
public class Post {

    protected Post() {}

    /*@Autowired
    private UserRepository userRepo;*/

    public Post(String inputText, String userName) {
        this.text = inputText;
        this.creationDate = LocalDateTime.now();
        //List<User> users = userRepo.findByUserName(userName);
        //this.user = users.get(0);

    }


    @Id
    @Column(name = "postID", columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private long postID;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="userID")
    private User user;

    @Getter
    @Setter
    private LocalDateTime creationDate;

    @Getter
    @Setter
    private String text;
}