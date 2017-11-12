package de.apoehlmann.gps;

import android.location.Location;
import de.apoehlmann.gps.configuration.GpsModus;

/**
 * Created by apoehlmann on 05.11.17.
 */

final class FakeGpsAdapterImpl extends BaseGpsAdapter {

    private final Thread mThread = new Thread("Fake gps") {

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    sleep(getCurrentMode().getConfiguration().getMinTime());
                } catch (InterruptedException e) {
                    error(e);
                }
                mPublishSubject.onNext(new Location("Testprovider"));
            }
        }
    };
    private boolean isStopped = false;

    @Override
    public void start(GpsModus modus) {
        super.start(modus);
        isStopped = false;
        mThread.start();
    }

    @Override
    public void stop() {
        super.stop();
        isStopped = true;
    }
}
