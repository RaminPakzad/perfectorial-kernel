package com.perfectorial.dao;

import com.perfectorial.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/25/2015
 */
@Service
public class UserDao extends AbstractGenericDao<User> {
    public void update(User user) {
        final Criteria criteria = Criteria.where("id").is(user.getId());
        mongoOperation.updateFirst(Query.query(criteria), Update.update(user.getId(), user), User.class);
    }

    public User getBySessionId(String activeSessionId) {
        return this.get(User.class, "activeSessionId", activeSessionId);
    }

    public User getByEmail(String email) {
        return this.get(User.class, "email", email);
    }


}
