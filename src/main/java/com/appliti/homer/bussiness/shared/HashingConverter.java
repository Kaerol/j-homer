package com.appliti.homer.bussiness.shared;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashingConverter {

    public static String hash(final String plain) {
        return Hashing.sha256()
                      .hashString(plain, StandardCharsets.UTF_8)
                      .toString();
    }
}
