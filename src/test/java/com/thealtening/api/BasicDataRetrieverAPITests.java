/*
 * Copyright (C) 2019 BasicDataRetriever
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

package com.thealtening.api;

import com.thealtening.api.retriever.AsynchronousDataRetriever;
import com.thealtening.api.retriever.BasicDataRetriever;
import org.junit.Test;

public class BasicDataRetrieverAPITests {
    private final BasicDataRetriever basicDataRetriever = TheAltening.newBasicRetriever("api_key_here");
    private final AsynchronousDataRetriever asynchronousDataRetriever = basicDataRetriever.toAsync();

    @Test
    public void account_generation() {
        System.out.println(basicDataRetriever.getAccount());
    }

    @Test
    public void license_gathering() {
        System.out.println(basicDataRetriever.getLicence());
    }

    @Test
    public void asynchronous_account_generation() {
        asynchronousDataRetriever.getAccountDataAsync()
                .thenAccept(System.out::println)
                .handle((input, exception) -> {
                    exception.printStackTrace();
                    return null;
                });
    }

    @Test
    public void asynchronous_license_gathering() {
        asynchronousDataRetriever.getLicenseDataAsync()
                .thenAccept(System.out::println)
                .handle((input, exception) -> {
                    exception.printStackTrace();
                    return null;
                });
    }

    @Test
    public void asynchronous_is_account_private_test() {
        asynchronousDataRetriever.isPrivateAsync("test")
                .thenAccept(System.out::println)
                .exceptionally((exception) -> {
                    exception.printStackTrace();
                    return null;
                });
    }
}
