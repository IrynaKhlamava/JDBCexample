package com.company.dao;

import com.company.model.Guest;
import com.company.dao.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestDao {

    private final Connector connector = Connector.getInstance();

    public List<Guest> getAll() {
        Connection connection = connector.getConnection();
        String sql = "SELECT * FROM GUESTS";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Guest> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(parseResultSet(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Guest parseResultSet(ResultSet resultSet) throws SQLException {
        Guest guest = new Guest();
        guest.setId(resultSet.getLong("id"));
        guest.setName(resultSet.getString("name"));
        guest.setDaysOfStay(resultSet.getInt("days_of_stay"));

        Optional.ofNullable(resultSet.getDate("date_check_in"))
                .map(Date::toLocalDate)
                .ifPresent(guest::setDateCheckIn);

        Optional.ofNullable(resultSet.getDate("date_check_out"))
                .map(Date::toLocalDate)
                .ifPresent(guest::setDateCheckOut);

        Optional.of(resultSet.getLong("rooms_id"))
                .ifPresent(guest::setRoomId);

        return guest;
    }
}
