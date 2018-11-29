package com.thealtening;

import com.thealtening.domain.Account;
import com.thealtening.domain.User;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Trol
 * @since 1:31 PM, 11/29/18
 */

public class TheAlteningAPITests {
    private TheAltening theAltening = new TheAltening("API-KEY-HERE");

    @Test
    public void user_info_test() {

        try {
            User user = theAltening.getUser();
            System.out.printf("%s:%s:%s:%s", user.getUsername(), user.isPremium(), user.getExpiryDate(), user.getPremiumName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void account_info_test() {
        try {
            Account account = theAltening.generateAccount(theAltening.getUser());
            System.out.printf("%s:%s:%s:%s", account.getUsername(), account.getExpiryDate(), account.getExpiryDate(), account.getSkinHash());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
