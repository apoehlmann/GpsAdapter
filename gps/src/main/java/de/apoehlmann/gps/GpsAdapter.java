package de.apoehlmann.gps;

import android.location.Location;

import de.apoehlmann.gps.configuration.Configuration;
import de.apoehlmann.gps.configuration.GpsModus;
import io.reactivex.Observable;

/**
 * Created by apoehlmann on 05.11.17.
 */

public interface GpsAdapter {
    void start(GpsModus modus);
    void stop();
    void error(Throwable e);
    Observable<Location> getListener();
}
