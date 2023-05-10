package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory(){

    }
    public static Connection getConnection() throws SQLException, IOException {
        Connection connection = null;

        try(InputStream input = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("connection.properties")){

            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAdress = prop.getProperty("db.adress");
            String dataBaseName = prop.getProperty("db.dataBaseName");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAdress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            try{
                connection = DriverManager.getConnection(connectionUrl,user,password);
            }catch (SQLException e){
                System.out.println("Falha ao conectar ao BD");
                e.printStackTrace();
            }
        }catch (IOException e){
            System.out.println("Erro ao tentar arquivo de propriedade de conexão");
            e.printStackTrace();
        }
    return connection;
    }
}
