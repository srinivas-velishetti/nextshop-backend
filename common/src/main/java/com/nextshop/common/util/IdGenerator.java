package com.nextshop.common.util;

import java.util.UUID;

/**
 * @Author: Srinivas Velishetti
 */
public class IdGenerator {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
