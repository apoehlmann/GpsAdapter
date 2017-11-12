package de.apoehlmann.gps;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.Map;

import de.apoehlmann.gps.configuration.Configuration;
import de.apoehlmann.gps.configuration.GpsModus;

/**
 * Created by apoehlmann on 05.11.17.
 */

final class GpsAdapterImpl extends BaseGpsAdapter implements LocationListener {

    private final LocationManager mLocationManager;

    GpsAdapterImpl(LocationManager locationManager) {
        mLocationManager = locationManager;
    }

    @Override
    public void start(GpsModus modus) {
        super.start(modus);
        try {
            Criteria criteria = new Criteria();
            long minTime = modus.getConfiguration().getMinTime();
            float minDistances = modus.getConfiguration().getMinDistance();
            mLocationManager.requestLocationUpdates(minTime, minDistances, criteria,  this, null);
        } catch (SecurityException e) {
            error(e);
        }
    }

    @Override
    public void stop() {
        super.stop();
        mLocationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mPublishSubject.onNext(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
