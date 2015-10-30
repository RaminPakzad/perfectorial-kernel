package com.perfectorial.logic;

import com.perfectorial.dao.UserDao;
import com.perfectorial.entity.User;
import com.perfectorial.entity.UserStatus;
import com.perfectorial.util.SessionIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/18/2015
 */
@Service
public class UserLogic extends AbstractGenericLogic<User> {
    @Autowired
    private UserDao userDao;

    public User create(User user) {
        user.setUserStatus(UserStatus.CREATE);
        String activeSessionId = SessionIdentifierGenerator.nextSessionId();
        user.setActiveSessionId(activeSessionId);
        userDao.create(user);
        sendEmail(user.getEmail(), activeSessionId);
        return user;
    }

    public boolean activeUser(String sessionId) {
        User user = userDao.getBySessionId(sessionId);
        checkUser(user);
        user.setUserStatus(UserStatus.ACTIVE);
        user.setActiveSessionId(SessionIdentifierGenerator.nextSessionId());
        userDao.update(user);
        return true;
    }

    public boolean requestChangePassword(String email) {
        User user = userDao.getByEmail(email);
        checkUser(user);
        final String nextSessionId = SessionIdentifierGenerator.nextSessionId();
        user.setActiveSessionId(nextSessionId);
        userDao.update(user);
        sendEmail(email, nextSessionId);
        return true;
    }

    public boolean changePassword(String sessionId, String password) {
        final User user = userDao.getBySessionId(sessionId);
        user.setPassword(password);
        userDao.update(user);
        return false;
    }

    public boolean isValidChangePassword(String sessionId) {
        return userDao.getBySessionId(sessionId) != null;
    }

    private void checkUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException(String.format("User cannot be null."));
        }
    }

    private void sendEmail(String email, String nextSessionId) {
    }
}
