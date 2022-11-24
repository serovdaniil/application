package bsuir.kaf.electroniki.model;

import java.time.Year;
import java.time.YearMonth;
import java.util.Objects;

public class PercentageSafVal {

    private Year period;

    private double percentage;

    private double height;

    public PercentageSafVal() {
    }

    public PercentageSafVal(Year period, double percentage, double height) {
        this.period = period;
        this.percentage = percentage;
        this.height = height;
    }

    public Year getPeriod() {
        return period;
    }

    public void setPeriod(Year period) {
        this.period = period;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PercentageSafVal that = (PercentageSafVal) o;
        return Double.compare(that.percentage, percentage) == 0 && Double.compare(that.height, height) == 0 && Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, percentage, height);
    }
}
