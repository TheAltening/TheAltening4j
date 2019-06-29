package com.thealtening.api;

import org.junit.Test;

public class TheAlteningAPITests {
    private final TheAltening theAltening = new TheAltening("api_key_here");
    private final TheAltening.Asynchronous asynchronous = new TheAltening.Asynchronous(theAltening);
    @Test
    public void account_generation() {
        System.out.println(theAltening.getAccountData());
    }
    @Test
    public void license_gathering() {
        System.out.println(theAltening.getLicenseData());
    }
    @Test
    public void asynchronous_account_generation() {
        asynchronous.getAccountData().thenAccept(System.out::println).handle((input, exception) -> {
            exception.printStackTrace();
            return null;
        });
    }

    @Test
    public void asynchronous_license_gathering() {
        asynchronous.getLicenseData().thenAccept(System.out::println).handle((input, exception) -> {
            exception.printStackTrace();
            return null;
        });
    }
}
