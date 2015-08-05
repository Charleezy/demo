package demo.repositories;

/**
 * Created by Charlie on 7/30/2015.
 */

import demo.Customer;
import org.springframework.stereotype.Repository;

import demo.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserName(String userName);
}
