package bsuir.kaf.electroniki.model;

import java.io.Serializable;

public class SafInd implements Entity, Serializable {

    private Long id;

    private String name;

    private String meas;

    public SafInd() {
    }

    public SafInd(Long idSafInd, String name, String meas) {
        this.id = idSafInd;
        this.name = name;
        this.meas = meas;
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

    public String getMeas() {
        return meas;
    }

    public void setMeas(String meas) {
        this.meas = meas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SafInd{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", meas='").append(meas).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
