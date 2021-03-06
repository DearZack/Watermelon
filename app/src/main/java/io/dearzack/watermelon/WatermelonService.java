package io.dearzack.watermelon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class WatermelonService extends Service {
    private Server mServer;

    @Override
    public void onCreate() {
        mServer = AndServer.webServer(this)
                .port(12333)
                .timeout(10, TimeUnit.SECONDS)
                .listener(new Server.ServerListener() {
                    @Override
                    public void onStarted() {
//                        InetAddress address = NetUtils.getLocalIPAddress();
                    }

                    @Override
                    public void onStopped() {
                    }

                    @Override
                    public void onException(Exception e) {
                    }
                })
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startServer();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        stopServer();
        super.onDestroy();
    }

    /**
     * Start server.
     */
    private void startServer() {
        mServer.startup();
    }

    /**
     * Stop server.
     */
    private void stopServer() {
        mServer.shutdown();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
