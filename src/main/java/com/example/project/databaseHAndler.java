package com.example.project;
import java.sql.*;

public class databaseHAndler extends dataConnector {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.User_Name + "," + Const.User_number + "," + Const.User_tariff + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getName());
            prSt.setString(4, user.getNumber());
            prSt.setString(5, user.getTariff());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet chooseTariff() {
        ResultSet reset = null;
        String select = "SELECT * FROM " + Const.TARIFF_TABLE;
        System.out.println(select);
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            reset = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reset;
    }

    public ResultSet getTariff() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE;
        System.out.println(select);
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void addTariff(User user) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.User_tariff + "=?" + " WHERE " + Const.USER_ID + "=?;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, user.getTariff());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void rating(Rate rate) {
        String insert = "INSERT INTO " + Const.RATING_TABLE + "(" + Const.RATING_RATE + "," + Const.RATING_REVIEW + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, rate.getRating());
            prSt.setString(2, rate.getReview());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public ResultSet getRating() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.RATING_TABLE;
        System.out.println(select);
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }
    public void addComplain(complain complain) {
        String insert = "INSERT INTO " + Const.COMPLAIN_TABLE + "(" + Const.COMPLAIN_COMPLAIN + "," + Const.COMPLAIN_REASON + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, complain.getComplaint());
            prSt.setString(2, complain.getReason());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void changeLogin(User user) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_USERNAME + "=?" + " WHERE " + Const.USER_ID + "=?;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void changeNumber(User user) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.User_number + "=?" + " WHERE " + Const.USER_ID + "=?;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, user.getNumber());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(User user) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=?" + " WHERE " + Const.USER_ID + "=?;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void changeName(User user) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.User_Name + "=?" + " WHERE " + Const.USER_ID + "=?;";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
