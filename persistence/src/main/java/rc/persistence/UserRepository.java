package rc.persistence;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Query("{'details.name' : ?0}")
    public List<User> findByDetailsNameQuery(String detailsName);
    
}
