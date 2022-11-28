package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class CurStatus implements Serializable, Entity {

    private Long id;

    private LocalDate date;

    private User user;

    private Long idSys;

    private Mark mark;

    private BigDecimal distant;

    public CurStatus() {
    }

    public CurStatus(LocalDate date, User idUser, Long idSys) {
        this.date = date;
        this.user = idUser;
        this.idSys = idSys;
    }

    public CurStatus(Long id, LocalDate date, User idUser, Long idSys, Mark mark, BigDecimal distant) {
        this.id = id;
        this.date = date;
        this.user = idUser;
        this.idSys = idSys;
        this.mark = mark;
        this.distant = distant;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdSys() {
        return idSys;
    }

    public void setIdSys(Long idSys) {
        this.idSys = idSys;
    }

    public Long getIdMark() {
        return mark.getId();
    }

    public void setIdMark(Long idMark) {
        this.mark = new Mark(idMark, "");
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public BigDecimal getDistant() {
        return distant;
    }

    public void setDistant(BigDecimal distant) {
        this.distant = distant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurStatus curStatus = (CurStatus) o;
        return Objects.equals(id, curStatus.id) && Objects.equals(date, curStatus.date) && Objects.equals(user, curStatus.user) && Objects.equals(idSys, curStatus.idSys) && Objects.equals(mark, curStatus.mark) && Objects.equals(distant, curStatus.distant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, user, idSys, mark, distant);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CurStatus{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", user=").append(user);
        sb.append(", idSys=").append(idSys);
        sb.append(", mark=").append(mark);
        sb.append(", distant=").append(distant);
        sb.append('}');
        return sb.toString();
    }
}
