package com.perfecturial.dao;

import com.perfecturial.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 */
@Service
public class UserDao extends GenericDao {
    public void save(User user) {
        mongoOperation.save(user);
    }

    public void update(User user) {
        final Criteria criteria = Criteria.where("id").is(user.getId());
        mongoOperation.updateFirst(Query.query(criteria), Update.update(user.getId(), user), User.class);
    }

    public User getBySessionId(String activeSessionId) {
        return this.get("activeSessionId", activeSessionId,User.class);
    }

    public User getByEmail(String email) {
        return this.get("email", email,User.class);
    }



}
