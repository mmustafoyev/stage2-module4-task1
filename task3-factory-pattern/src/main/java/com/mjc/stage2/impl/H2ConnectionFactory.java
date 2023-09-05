package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import com.mjc.stage2.impl.loader.H2DatabasePropertiesLoader;
import com.mjc.stage2.impl.loader.PropertiesLoader;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;


@SuppressWarnings("unused")
public class H2ConnectionFactory implements ConnectionFactory {
    private static final PropertiesLoader propertiesLoader = H2DatabasePropertiesLoader.getInstance();

    private static class PropertyKey{
        private static final String URL = "db_url";
        private static final String USER = "user";
        private static final String PASSWORD = "password";
    }
    @SneakyThrows
    @Override
    public Connection createConnection() {
            return DriverManager.getConnection(propertiesLoader.getByKey(PropertyKey.URL),
                    propertiesLoader.getByKey(PropertyKey.USER),
                    propertiesLoader.getByKey(PropertyKey.PASSWORD));
    }
}

