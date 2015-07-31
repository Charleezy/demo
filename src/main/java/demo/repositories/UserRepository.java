package demo.repositories;

import demo.Customer;
import demo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Charlie on 7/30/2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(String userName);
}
