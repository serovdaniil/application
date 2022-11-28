package bsuir.kaf.electroniki.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bsuir.kaf.electroniki.model.SysEquip;

public interface SysEquipDao  extends EntityDao<SysEquip>{

    List<SysEquip> findSysEquipForIdUnit(Connection connection, long idUnit) throws SQLException;
}
