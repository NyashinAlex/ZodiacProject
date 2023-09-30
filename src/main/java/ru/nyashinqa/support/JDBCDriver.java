package ru.nyashinqa.support;

import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class JDBCDriver {
        private static final PropertyRunner propertyRunner = PropertyRunner.getInstance();
        private static final String url = propertyRunner.getProperty(EnvironmentSettings.POSTGRES_ADDRESS);
        private static final String database = propertyRunner.getProperty(EnvironmentSettings.POSTGRES_DATABASE);
        private static final String username = propertyRunner.getProperty(EnvironmentSettings.POSTGRES_USERNAME);
        private static final String password = propertyRunner.getProperty(EnvironmentSettings.POSTGRES_PASSWORD);
        private static SessionFactory sessionFactory;

        public JDBCDriver() {

        }

        @SneakyThrows
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();
                    Properties properties = new Properties();
                    propertiesPut(properties);
                    configuration.setProperties(properties);
                    configurationAnnotatedAdd(configuration);
                    sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }

        private static void configurationAnnotatedAdd(Configuration configuration) {
//            configuration.addAnnotatedClass(BasicServiceSetDetails.class);
        }

        private static void propertiesPut(Properties properties) {
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://" + (url.endsWith("/") ? url + database : url + "/" + database));
            properties.put(Environment.USER, username);
            properties.put(Environment.PASS, password);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
            properties.put(Environment.SHOW_SQL, "false");
        }
    }
