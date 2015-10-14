package com.perfecturial.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/18/2015
 */

public final class SessionIdentifierGenerator {
    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}