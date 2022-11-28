package bsuir.kaf.electroniki.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.CurStatus;

public interface CurStatusDao extends EntityDao<CurStatus>{

    void addNewCurStatus(Connection connection, CurStatus entity);

    List<CurStatus> findCurStatusBySystem(Connection connection, long idSystem) throws SQLException;
}
