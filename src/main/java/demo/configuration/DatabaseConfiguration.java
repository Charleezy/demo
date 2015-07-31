package demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by Charlie on 7/23/2015.
 */

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("rootroot");
        Properties unicodeProps = new Properties();
        unicodeProps.setProperty("useUnicode", "yes");
        unicodeProps.setProperty("characterEncoding", "utf8");
        dataSource.setConnectionProperties(unicodeProps);
        return dataSource;
    }

}
