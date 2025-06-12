package com.es.sms.connection;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            // To create Product Table
            String createProductTable = "CREATE TABLE product (" +
                    "product_id INT NOT NULL AUTO_INCREMENT," +
                    "product_desc VARCHAR(255) NOT NULL," +
                    "startdate VARCHAR(45) NOT NULL," +
                    "enddate VARCHAR(45) NOT NULL," +
                    "PRIMARY KEY (product_id)" +
                    ");";
            statement.execute(createProductTable);

            // To create Module Table
            String createModuleTable = "CREATE TABLE module (" +
                    "module_id INT NOT NULL AUTO_INCREMENT," +
                    "module_desc VARCHAR(255) NOT NULL," +
                    "startdate VARCHAR(45) NOT NULL," +
                    "enddate VARCHAR(45) NOT NULL," +
                    "PRIMARY KEY (module_id)" +
                    ");";
            statement.execute(createModuleTable);

            //To create Product_Module Association Table
            String createProductModuleTable = "CREATE TABLE Product_Module (" +
                    "product_id INT NOT NULL," +
                    "module_id INT NOT NULL," +
                    "PRIMARY KEY (product_id, module_id)," +
                    "CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (product_id)," +
                    "CONSTRAINT fk_module FOREIGN KEY (module_id) REFERENCES module (module_id)" +
                    ");";
            statement.execute(createProductModuleTable);

            System.out.println("Tables created successfully!");
            // Close the resources
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

