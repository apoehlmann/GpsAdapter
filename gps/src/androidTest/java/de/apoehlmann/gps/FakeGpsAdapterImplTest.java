package de.apoehlmann.gps;

import android.location.Location;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import de.apoehlmann.gps.configuration.GpsModus;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.DefaultSubscriber;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FakeGpsAdapterImplTest {

    private final GpsAdapter mGpsAdapter = GpsAdapterProvider.getFakeGpsAdapter();

    @Test
    public void testAdapter() throws InterruptedException {
        final List<Location> locations = new ArrayList<>();
        mGpsAdapter.getListener().subscribe(new Consumer<Location>() {
            @Override
            public void accept(Location location) throws Exception {
                locations.add(location);
            }
        });
        mGpsAdapter.start(GpsModus.BIKE);
        Thread.sleep(10000);
        mGpsAdapter.stop();
        assertTrue(!locations.isEmpty());
    }
}