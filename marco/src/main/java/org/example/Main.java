package org.example;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Hello world!");
    }
}