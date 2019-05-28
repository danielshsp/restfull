package rc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.domain.User;
import rc.persistence.UserDao;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public void save(User user){
        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
    public List<User> findByDetailsNameQuery(String detailsName) {
        return userDao.findByDetailsNameQuery(detailsName);
    }
    
    public List<User> findByDetails(String key , String name){ 
        return userDao.findByDetails(key, name);
     }
}
