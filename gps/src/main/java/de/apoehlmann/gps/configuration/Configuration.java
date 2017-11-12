package de.apoehlmann.gps.configuration;

import android.location.Criteria;

/**
 * Created by apoehlmann on 05.11.17.
 */

public final class Configuration {

    private final long mMinTime;
    private final float mMinDistance;

    public Configuration(long minTime, float minDistance) {
        mMinTime = minTime;
        mMinDistance = minDistance;
    }

    public float getMinDistance() {
        return mMinDistance;
    }

    public long getMinTime() {
        return mMinTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Configuration that = (Configuration) o;

        if (mMinTime != that.mMinTime) return false;
        return Float.compare(that.mMinDistance, mMinDistance) == 0;

    }

    @Override
    public int hashCode() {
        int result = (int) (mMinTime ^ (mMinTime >>> 32));
        result = 31 * result + (mMinDistance != +0.0f ? Float.floatToIntBits(mMinDistance) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "mMinTime=" + mMinTime +
                ", mMinDistance=" + mMinDistance +
                '}';
    }
}
