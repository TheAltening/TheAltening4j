package com.thealtening.api.json;

public class LicenseInfo {
    public static final LicenseInfo EMPTY = new LicenseInfo();
    private String username;

    private boolean premium;

    private String premium_name;

    private String expires;

    private LicenseInfo() {
        this.username = "";
        this.premium = false;
        this.premium_name = "";
        this.expires = "";
    }

    public LicenseInfo(String username, boolean premium, String premium_name, String expires) {
        this.username = username;
        this.premium = premium;
        this.premium_name = premium_name;
        this.expires = expires;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getPremiumName() {
        return premium_name;
    }

    public String getExpiryDate() {
        return expires;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s", username, premium, premium_name, expires);
    }

    @Override
    public int hashCode() {
        int premium = (isPremium() ? 2 : 1) * 33;
        int premium_name_hashcode = premium_name.hashCode() * 33;
        int expires_hashcode = expires.hashCode() * 33;
        int username_hashcode = username.hashCode() * 33;
        return premium * premium_name_hashcode * expires_hashcode * username_hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LicenseInfo)) {
            return false;
        }
        LicenseInfo castedLicenseInfo = (LicenseInfo) obj;

        return castedLicenseInfo.getExpiryDate().equals(getExpiryDate()) && castedLicenseInfo.getPremiumName().equals(getPremiumName()) && castedLicenseInfo.isPremium() == isPremium() && castedLicenseInfo.getUsername().equals(getUsername());
    }
}
