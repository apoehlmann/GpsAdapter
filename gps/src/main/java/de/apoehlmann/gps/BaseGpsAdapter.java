package de.apoehlmann.gps;

import android.location.Location;

import java.util.Map;

import de.apoehlmann.gps.configuration.GpsModus;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import static de.apoehlmann.gps.configuration.GpsModus.WALK;

/**
 * Created by apoehlmann on 05.11.17
 */

abstract class BaseGpsAdapter implements GpsAdapter {

    protected final PublishSubject<Location> mPublishSubject = PublishSubject.create();
    private GpsModus mCurrentMode = WALK;

    @Override
    public Observable<Location> getListener() {
        return mPublishSubject;
    }

    @Override
    public void start(GpsModus modus) {
        mCurrentMode = modus;
    }

    @Override
    public void stop() {
        mPublishSubject.onComplete();
    }

    @Override
    public void error(Throwable e) {
        mPublishSubject.onError(e);
    }

    protected GpsModus getCurrentMode() {
        return mCurrentMode;
    }
}
