package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.util.Objects;

public class SysEquip implements Entity, Serializable {

    private Long id;

    private String nameSys;

    private String kks;

    private Long idUnit;

    private Long idMark;

    public SysEquip() {
    }

    public SysEquip(Long id, String nameSys, String kks, Long idUnit, Long idMark) {
        this.id = id;
        this.nameSys = nameSys;
        this.kks = kks;
        this.idUnit = idUnit;
        this.idMark = idMark;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSys() {
        return nameSys;
    }

    public void setNameSys(String nameSys) {
        this.nameSys = nameSys;
    }

    public String getKks() {
        return kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public Long getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Long idUnit) {
        this.idUnit = idUnit;
    }

    public Long getIdMark() {
        return idMark;
    }

    public void setIdMark(Long idMark) {
        this.idMark = idMark;
    }

    @Override
    public boolean isNew() {
        return Entity.super.isNew();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysEquip sysEquip = (SysEquip) o;
        return Objects.equals(id, sysEquip.id) && Objects.equals(nameSys, sysEquip.nameSys) && Objects.equals(kks, sysEquip.kks) && Objects.equals(idUnit, sysEquip.idUnit) && Objects.equals(idMark, sysEquip.idMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSys, kks, idUnit, idMark);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysEquip{");
        sb.append("id=").append(id);
        sb.append(", nameSys='").append(nameSys).append('\'');
        sb.append(", kks='").append(kks).append('\'');
        sb.append(", idUnit=").append(idUnit);
        sb.append(", idMark=").append(idMark);
        sb.append('}');
        return sb.toString();
    }
}
