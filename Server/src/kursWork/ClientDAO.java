package kursWork;

import kursWork.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends AbstractDAO {
    public ClientDAO(Connection connection) {
        super(connection);
    }

    public int getIdUserFK (String userLogin){
        int idUser = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT F_ID FROM t_user WHERE F_USERNAME=?;")) {
            preparedStatement.setString(1, userLogin);
            ResultSet resSet = preparedStatement.executeQuery();
            if (resSet.next()) {
                idUser = resSet.getInt("F_ID");
            }
            return idUser;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return idUser;
    }

    public boolean addNewClient(Client client, String userLogin) {
        int idUserFK = getIdUserFK(userLogin);
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO t_client(F_SURNAME, F_NAME, F_PASSPORT, F_ID_USER_FK) " + "VALUES(?,?,?,?) ;")) {
            preparedStatement.setString(1, client.getSurname());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getPassport());
            preparedStatement.setInt(4, idUserFK);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
