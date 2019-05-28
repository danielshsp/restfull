package rc.domain;


import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private Object details;
   // private Map<String,Object> details = new HashMap();

    public User() { 
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

   

   
}
