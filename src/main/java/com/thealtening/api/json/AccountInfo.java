package com.thealtening.api.json;

import com.squareup.moshi.Json;

public class AccountInfo {
    public static final AccountInfo EMPTY = new AccountInfo();
    private String token;

    private String password;

    private String username;

    private boolean limit;

    private Info info;

    private AccountInfo() {
        token = "";
        password = "";
        username = "";
        limit = false;
    }

    public AccountInfo(String token, String password, String username, boolean limit, Info info) {
        this.token = token;
        this.password = password;
        this.username = username;
        this.limit = limit;
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLimited() {
        return limit;
    }

    public Info getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s", token, username, password, limit);
    }

    @Override
    public int hashCode() {
        int limit_hashcode = (limit ? 2 : 1) * 33;
        int username_hashcode = username.hashCode() * 33;
        int password_hashcode = password.hashCode() * 33;
        int token_hashcode = token.hashCode() * 33;
        return username_hashcode * password_hashcode * token_hashcode * limit_hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountInfo)) {
            return false;
        }
        AccountInfo castedAccountInfo = (AccountInfo) obj;
        return castedAccountInfo.getUsername().equals(username) && castedAccountInfo.getToken().equals(token);
    }

    class Info {

        @Json(name = "hypixel.lvl")
        private int hypixelLevel;
        @Json(name = "hypixel.rank")
        private String hypixelRank;

        @Json(name = "mineplex.lvl")
        private int mineplexLevel;

        @Json(name = "mineplex.rank")
        private String mineplexRank;

        @Json(name = "labymod.cape")
        private boolean labymodCape;

        @Json(name = "5zig.cape")
        private boolean fiveZigCape;

        public int getHypixelLevel() {
            return hypixelLevel;
        }

        public String getHypixelRank() {
            return hypixelRank;
        }

        public int getMineplexLevel() {
            return mineplexLevel;
        }

        public String getMineplexRank() {
            return mineplexRank;
        }

        public boolean hasLabyModCape() {
            return labymodCape;
        }

        public boolean hasFiveZigCape() {
            return fiveZigCape;
        }
    }
}
