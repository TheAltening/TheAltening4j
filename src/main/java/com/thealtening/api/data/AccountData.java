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

import com.thealtening.api.data.info.AccountInfo;

public class AccountData {

    private String token;

    private String password;

    private String username;

    private boolean limit;

    private AccountInfo info;

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLimit() {
        return limit;
    }

    public AccountInfo getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("AccountData[%s:%s:%s:%s]", token, username, password, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountData)) {
            return false;
        }
        AccountData castedAccountInfo = (AccountData) obj;
        return castedAccountInfo.getUsername().equals(username) && castedAccountInfo.getToken().equals(token);
    }
}
