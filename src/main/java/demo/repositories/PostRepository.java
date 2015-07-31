package demo.repositories;

/**
 * Created by Charlie on 7/30/2015.
 */

import org.springframework.stereotype.Repository;

import demo.Post;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
