package com.assignment.dao.mysql;

import com.assignment.dao.UserDao;
import com.assignment.data.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * MySQL implementation of the UserDao interface.
 *
 * @author MeHeR ALi
 */
public class MySqlUserDao implements UserDao {

    private static final String SELECT_BY_ID = 
        "SELECT * FROM User WHERE id = ?";
    private static final String SELECT_ALL = 
        "SELECT * FROM User";
    private static final String INSERT = 
        "INSERT INTO User (firstName, lastName, cnic, address, contact, email, borrowings, bookBorrowLimit, magazineBorrowLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = 
        "UPDATE User SET firstName = ?, lastName = ?, cnic = ?, address = ?, contact = ?, email = ?, borrowings = ?, bookBorrowLimit = ?, magazineBorrowLimit = ? WHERE id = ?";
    private static final String DELETE = 
        "DELETE FROM User WHERE id = ?";
    private static final String SELECT_BY_EMAIL = 
        "SELECT * FROM User WHERE email = ?";
    private static final String SELECT_BY_CNIC = 
        "SELECT * FROM User WHERE cnic = ?";
    private static final String SELECT_BY_CONTACT = 
        "SELECT * FROM User WHERE contact = ?";
    private static final String UPDATE_BORROWINGS = 
        "UPDATE User SET borrowings = ? WHERE id = ?";

    private final Connection connection;

    public MySqlUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(extractUserFromResultSet(rs));
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        }
        return users;
    }

    @Override
    public User save(User user) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            setUserParameters(stmt, user);
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
            return user;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
            setUserParameters(stmt, user);
            stmt.setInt(10, user.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_EMAIL)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(extractUserFromResultSet(rs));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByCnic(long cnic) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_CNIC)) {
            stmt.setLong(1, cnic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(extractUserFromResultSet(rs));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByContact(String contact) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_CONTACT)) {
            stmt.setString(1, contact);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(extractUserFromResultSet(rs));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean updateBorrowings(int userId, int borrowings) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE_BORROWINGS)) {
            stmt.setInt(1, borrowings);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(
            rs.getInt("id"),
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getLong("cnic"),
            rs.getString("address"),
            rs.getString("contact"),
            rs.getString("email"),
            rs.getInt("borrowings"),
            rs.getInt("bookBorrowLimit"),
            rs.getInt("magazineBorrowLimit"),
            rs.getTimestamp("created_at") != null ? rs.getTimestamp("created_at").toLocalDateTime() : null
        );
    }

    private void setUserParameters(PreparedStatement stmt, User user) throws SQLException {
        stmt.setString(1, user.getFirstName());
        stmt.setString(2, user.getLastName());
        stmt.setLong(3, user.getCnic());
        stmt.setString(4, user.getAddress());
        stmt.setString(5, user.getContact());
        stmt.setString(6, user.getEmail());
        stmt.setInt(7, user.getBorrowings());
        stmt.setInt(8, user.getBookBorrowLimit());
        stmt.setInt(9, user.getMagazineBorrowLimit());
    }
}
