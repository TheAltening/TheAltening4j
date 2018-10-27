package com.thealtening;

import com.thealtening.api.user.UserKey;
import com.thealtening.process.processes.UserInformationGatheringProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author trol
 * @since 10/27/18
 */
public class Main {
    // TODO: Replace this with JUnit tests

    public static void main(String[] args) {

        try {
            String API_KEY = new BufferedReader(new FileReader(new File("logindata.txt"))).readLine();

            UserKey userKey = new UserKey(API_KEY);

            UserInformationGatheringProcess validator = new UserInformationGatheringProcess(userKey);

            validator.validate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
