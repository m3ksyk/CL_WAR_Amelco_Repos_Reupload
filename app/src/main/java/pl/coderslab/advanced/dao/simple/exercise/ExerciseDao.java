package pl.coderslab.advanced.dao.simple.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseDao extends AbstractDao {

    private static final String LOAD_ALL_QUERY = "SELECT * FROM exercise;";
    private static final String LOAD_BY_ID_QUERY = "SELECT * FROM exercise WHERE id=?;";
    private static final String CREATE_QUERY = "INSERT INTO exercise(title, description) VALUES(?,?);";
    private static final String UPDATE_QUERY = "UPDATE exercise SET title=?, decription=? WHERE id=?;";
    private static final String DELETE_QUERY = "DELETE FROM exercise WHERE id=?;";

    @Override
    protected PreparedStatement saveNewStatement(Connection con, Model exercise) throws SQLException {
        String[] genereatedColumns = { "id" };
        PreparedStatement ps = con.prepareStatement(CREATE_QUERY, genereatedColumns);
        ps.setString(1, ((Exercise) exercise).getTitle());
        ps.setString(2, ((Exercise) exercise).getDescription());
        return ps;

    }

    @Override
    protected PreparedStatement updateExistingStatement(Connection con, Model exercise) throws SQLException {
        PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
        ps.setString(1, ((Exercise) exercise).getTitle());
        ps.setString(2, ((Exercise) exercise).getDescription());
        ps.setLong(3, exercise.getId());
        return ps;
    }

    @Override
    protected PreparedStatement deleteStatement(Connection con, Model exercise) throws SQLException {
        PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
        ps.setLong(1, exercise.getId());
        return ps;

    }

    @Override
    protected Model newFromResultSet(ResultSet rs) throws SQLException {
        return new Exercise(rs.getLong("id"), rs.getString("title"),
        rs.getString("description"));
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
