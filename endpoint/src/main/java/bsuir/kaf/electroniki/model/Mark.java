package bsuir.kaf.electroniki.model;

import java.io.Serializable;
import java.util.Objects;

public class Mark implements Serializable, Entity{

    private Long id;

    private String name;

    private int mark;

    private Crits crit;

    public Mark(Long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Mark(Long id, String name, int mark, Crits crit) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.crit = crit;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Crits getCrit() {
        return crit;
    }

    public void setCrit(Crits crit) {
        this.crit = crit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mark mark1 = (Mark) o;
        return mark == mark1.mark && Objects.equals(id, mark1.id) && Objects.equals(name, mark1.name) && Objects.equals(crit, mark1.crit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mark, crit);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mark{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", mark=").append(mark);
        sb.append(", crit=").append(crit);
        sb.append('}');
        return sb.toString();
    }
}
