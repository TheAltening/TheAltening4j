/*
 * Copyright (C) 2019 TheAltening
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.thealtening.api.data;

import com.google.gson.annotations.SerializedName;

public class LicenseData {

    private String username;

    private boolean premium;

    @SerializedName("premium_name")
    private String premiumName;

    @SerializedName("expires")
    private String expiryDate;

    public String getUsername() {
        return username;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getPremiumName() {
        return premiumName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


    @Override
    public String toString() {
        return String.format("LicenseData[%s:%s:%s:%s]", username, premium, premiumName, expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LicenseData)) {
            return false;
        }
        LicenseData castedLicenseInfo = (LicenseData) obj;

        return castedLicenseInfo.getExpiryDate().equals(getExpiryDate()) && castedLicenseInfo.getPremiumName().equals(getPremiumName()) && castedLicenseInfo.isPremium() == isPremium() && castedLicenseInfo.getUsername().equals(getUsername());
    }
}
