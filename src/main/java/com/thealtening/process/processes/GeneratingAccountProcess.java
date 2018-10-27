package com.thealtening.process.processes;

import com.thealtening.api.user.User;
import com.thealtening.process.Process;

import java.net.URL;

/**
 * @author trol
 * @since 10/27/18
 */
public class GeneratingAccountProcess extends Process {
    private final User user;
    private String output;
    private String getOutput() {
        return output;
    }
    public GeneratingAccountProcess(User user) {
        this.user = user;
    }
    @Override
    public void run() {

    }
}
