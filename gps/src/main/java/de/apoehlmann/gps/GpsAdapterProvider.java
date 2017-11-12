package de.apoehlmann.gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by apoehlmann on 05.11.17.
 */

public final class GpsAdapterProvider {

    public static GpsAdapter getFakeGpsAdapter() {
        return new FakeGpsAdapterImpl();
    }

    public static GpsAdapter getGpsAdapter(Context context) {
        GpsAdapter gpsAdapter = null;
        if (!(ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            gpsAdapter = new GpsAdapterImpl(locationManager);
        }
        return gpsAdapter;
    }
}
