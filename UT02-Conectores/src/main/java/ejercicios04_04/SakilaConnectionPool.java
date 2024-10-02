package ejercicios04_04;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SakilaConnectionPool {


    private SakilaConnectionPool instance = new SakilaConnectionPool();

    private static final String CONNECTION_STRING = "jbdc:mariadb://localhost:3306";
    private static final String USERNAME = "sakilauser";
    private static final String PASSWORD = "pwdsakilauser";

    private HikariDataSource dataSource;



    private SakilaConnectionPool() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
    }

}