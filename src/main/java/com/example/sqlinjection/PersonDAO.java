package com.example.sqlinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonDAO {

    @Value("${datasource.url}")
    private String URL;
    @Value("${datasource.username}")
    private String USERNAME;
    @Value("${datasource.password}")
    private String PASSWORD;

    public List<Person> findByName(String name) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("select * from person " +
                     " where person_name = ? ;")) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            List<Person> people = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String personName = resultSet.getString(2);
                people.add(new Person(id, personName));
            }
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
