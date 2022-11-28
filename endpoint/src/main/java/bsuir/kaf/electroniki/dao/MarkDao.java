package bsuir.kaf.electroniki.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.Mark;

public interface MarkDao extends EntityDao<Mark> {

    List<Mark> findMarksByCrit(Connection connection, long idCrit) throws SQLException;
}
