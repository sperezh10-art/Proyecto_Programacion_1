/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    static Properties config = new Properties();

    String hostname = null;
    String port = null;
    String database = null;
    String username = null;
    String password = null;

    public CreateConnection() throws IOException {

        InputStream in = null;

        String path = "C:\\Users\\samue\\OneDrive\\Documentos\\NetBeansProjects\\Proyecto_Final_P1\\src\\conexion\\db_config.properties";

        try {

            in = Files.newInputStream(Paths.get(path));
            config.load(in);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        loadProperties();
    }

    public void loadProperties() {

        this.hostname = config.getProperty("hostname");
        this.port = config.getProperty("port");
        this.username = config.getProperty("username");
        this.password = config.getProperty("passaword");
        this.database = config.getProperty("database");

    }

    public Connection getConnection() {

        Connection conn = null;

        try {

            String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;

            conn = DriverManager.getConnection(jdbcUrl, username, password);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return conn;
    }
}