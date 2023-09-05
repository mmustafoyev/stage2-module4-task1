package com.mjc.stage2.impl.loader;

import lombok.SneakyThrows;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;



public class H2DatabasePropertiesLoader implements PropertiesLoader{



    private static class H2DatabasePropertiesLoaderHolder{
        private static final PropertiesConfiguration configuration = new PropertiesConfiguration();
        private static final H2DatabasePropertiesLoader instance = new H2DatabasePropertiesLoader(H2DatabasePropertiesLoaderHolder.configuration);
    }
    private final PropertiesConfiguration configuration;
    private final static String FILE_NAME ="h2database.properties";
    @SneakyThrows
    public H2DatabasePropertiesLoader(PropertiesConfiguration configuration) {
        configuration.load(FILE_NAME);
        this.configuration = configuration;
    }

    @Override
    public String getByKey(String key) {
        return this.configuration.getString(key);
    }
    public static PropertiesLoader getInstance() {
        return H2DatabasePropertiesLoaderHolder.instance;
    }
}
