package com.thealtening.api.json.error;

public class PrivateError {
    public static final PrivateError EMPTY = new PrivateError();
    private boolean success;
    private PrivateError() {
        this.success = false;
    }
    public PrivateError(boolean success) {
        this.success = success;
    }

    public boolean isSuccessful() {
        return success;
    }
}

