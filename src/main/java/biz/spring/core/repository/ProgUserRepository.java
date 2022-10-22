package biz.spring.core.repository;

import biz.spring.core.model.ProgUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProgUserRepository implements TableRepository<ProgUser> {

    public ProgUser findByLogin(String login){
        ProgUser progUser = findWhere("proguser_name =:proguserName", Map.of("proguserName", login)).get(0);
        return progUser;
    }
}
