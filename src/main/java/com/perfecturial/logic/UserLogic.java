package com.perfecturial.logic;

import com.perfecturial.dao.UserDao;
import com.perfecturial.dto.RegisterUser;
import com.perfecturial.entity.User;
import com.perfecturial.entity.UserStatus;
import com.perfecturial.util.SessionIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/18/2015
 */
@Service
public class UserLogic {

    @Autowired
    private UserDao userDao;

    public boolean createUser(RegisterUser registerUser) {
        try {
            User user = new User();
            user.setEmail(registerUser.getEmail());
            user.setFirstName(registerUser.getFirstName());
            user.setLastName(registerUser.getLastName());
            user.setUserStatus(UserStatus.CREATE);
            String activeSessionId = SessionIdentifierGenerator.nextSessionId();
            user.setActiveSessionId(activeSessionId);
            userDao.save(user);
            sendEmail(user.getEmail(), activeSessionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean activeUser(String sessionId) {
        try {
            User user = userDao.getBySessionId(sessionId);
            if (user == null)
                throw new RuntimeException();
            user.setUserStatus(UserStatus.ACTIVE);
            user.setActiveSessionId(SessionIdentifierGenerator.nextSessionId());
            userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean requestChangePassword(String email) {
        try {
            User user = userDao.getByEmail(email);
            if (user == null)
                throw new RuntimeException();
            final String nextSessionId = SessionIdentifierGenerator.nextSessionId();
            user.setActiveSessionId(nextSessionId);
            userDao.update(user);
            sendEmail(email, nextSessionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void sendEmail(String email, String nextSessionId) {

    }

    public boolean changePassword(String sessionId, String password) {
        try {
            final User user = userDao.getBySessionId(sessionId);
            user.setPassword(password);
            userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean isValidChangePassword(String sessionId) {
        final User user = userDao.getBySessionId(sessionId);
        return user != null;
    }
}
