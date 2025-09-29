package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            connection.setSchema(config.getProperty("schema"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement("insert into items(name, time) values (?, ?);",
                Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        if (findById(id) != null) {
            try (PreparedStatement statement =
                         connection.prepareStatement("update items set name = ? where id = ?;")) {
                statement.setString(1, item.getName());
                statement.setInt(2, id);
                statement.executeUpdate();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void delete(int id) {
        if (findById(id) != null) {
            try (PreparedStatement statement = connection.prepareStatement("delete from items where id = ?;")) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement("Select * from items;")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Item(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getTimestamp("time").toLocalDateTime()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new LinkedList<>();
        try (PreparedStatement statement = connection.prepareStatement("Select * from items where name = ?;")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("time").toLocalDateTime())
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement statement = connection.prepareStatement("Select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String resultName = resultSet.getString("name");
                    int resultId = resultSet.getInt("id");
                    LocalDateTime created = resultSet.getTimestamp("time").toLocalDateTime();
                    result = new Item(resultId, resultName, created);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}