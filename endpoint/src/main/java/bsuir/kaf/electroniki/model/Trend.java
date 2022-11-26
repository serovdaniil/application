package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

public class Trend implements Entity, Serializable {

    private Long id;

    private LocalDate date;

    private Year period;

    private BigDecimal value;

    private User user;

    private Long unitId;

    private Long safIndId;

    public Trend(Long id, LocalDate date, Year period, User user, Long unitId, Long safIndId) {
        this.id = id;
        this.date = date;
        this.period = period;
        this.user = user;
        this.unitId = unitId;
        this.safIndId = safIndId;
    }

    public Trend(Long id, LocalDate date, Year period, BigDecimal value, User user, Long unitId, Long safIndId) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trend{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", period=").append(period);
        sb.append(", value=").append(value);
        sb.append(", user=").append(user);
        sb.append(", unitId=").append(unitId);
        sb.append(", safIndId=").append(safIndId);
        sb.append('}');
        return sb.toString();
    }
}
