
package rc.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import rc.domain.User;

@Repository
public class UserDao {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    public void save(User user){
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public List<User> findByDetailsNameQuery(String detailsName) {
        return userRepository.findByDetailsNameQuery(detailsName);
    }
 
    public List<User> findByDetails(String key , String name){   
        Query query = new Query();
        query.addCriteria(Criteria.where(key).is(name));
        return mongoTemplate.find(query, User.class);
    }

    
    
}
