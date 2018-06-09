package pl.coderslab.advanced.dao.simple.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends AbstractDao{

    private static final String LOAD_ALL_QUERY = "SELECT * FROM users;";
    private static final String LOAD_BY_ID_QUERY = "SELECT * FROM users WHERE id=?;";
    private static final String CREATE_QUERY = "INSERT INTO users(name, group_id) VALUES(?,?);";
    private static final String UPDATE_QUERY = "UPDATE users SET name=?, group_id=? WHERE id=?;";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id=?;";

    @Override
    protected PreparedStatement saveNewStatement(Connection con, Model user) throws SQLException {
        String[] genereatedColumns = { "id" };
        PreparedStatement ps = con.prepareStatement(CREATE_QUERY, genereatedColumns);
        ps.setString(1, ((User) user).getName());
        ps.setLong(2, ((User) user).getGroup().getId());
        return ps;

    }

    @Override
    protected PreparedStatement updateExistingStatement(Connection con, Model user) throws SQLException {
        PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
        ps.setString(1, ((User) user).getName());
        ps.setLong(2, ((User) user).getGroup().getId());
        ps.setLong(3, user.getId());
        return ps;
    }

    @Override
    protected PreparedStatement deleteStatement(Connection con, Model user) throws SQLException {
        PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
        ps.setLong(1, user.getId());
        return ps;

    }

    @Override
    protected Model newFromResultSet(ResultSet rs) throws SQLException {
        GroupDao groupDao = new GroupDao();
        Group group = (Group) groupDao.loadById(rs.getInt("group_id"));
        return new User(rs.getLong("id"), rs.getString("name"), group);
    }

    @Override
    protected String getLoadAllQuery() {

        return LOAD_ALL_QUERY;
    }

    @Override
    protected String getLoadByIdQuery() {

        return LOAD_BY_ID_QUERY;
    }
}
