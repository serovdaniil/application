package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class SafVal implements Entity, Serializable {

    private Long id;

    private LocalDate date;

    private YearMonth period;

    private BigDecimal value;

    private int userId;

    private int unitId;

    private int safIndId;

    public SafVal(Long id, LocalDate date, YearMonth period, BigDecimal value, int userId, int unitId, int safIndId) {
        this.id = id;
        this.date = date;
        this.period = period;
        this.value = value;
        this.userId = userId;
        this.unitId = unitId;
        this.safIndId = safIndId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public void setPeriod(YearMonth period) {
        this.period = period;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getSafIndId() {
        return safIndId;
    }

    public void setSafIndId(int safIndId) {
        this.safIndId = safIndId;
    }

    @Override
    public boolean isNew() {
        return Entity.super.isNew();
    }
}
