package com.thealtening.api.json.error;

public class FavoriteError {
    public static final FavoriteError EMPTY = new FavoriteError();
    private boolean success = false;

    private FavoriteError() {
        this.success = false;
    }

    public FavoriteError(boolean success) {
        this.success = success;
    }

    public boolean isSuccessful() {
        return success;
    }
}