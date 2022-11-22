package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;

public class SafVal implements Entity, Serializable {

    private Long id;

    private LocalDate date;

    private Year period;

    private BigDecimal value;

    private User user;

    private Long unitId;

    private Long safIndId;

    public SafVal(Long id, LocalDate date, Year period, BigDecimal value, User user, Long unitId, Long safIndId) {
        this.id = id;
        this.date = date;
        this.period = period;
        this.value = value;
        this.user = user;
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

    public Year getPeriod() {
        return period;
    }

    public void setPeriod(Year period) {
        this.period = period;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getSafIndId() {
        return safIndId;
    }

    public void setSafIndId(Long safIndId) {
        this.safIndId = safIndId;
    }

    @Override
    public boolean isNew() {
        return Entity.super.isNew();
    }
}
