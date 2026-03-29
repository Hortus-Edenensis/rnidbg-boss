package com.oplus.tblplayer.monitor.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.SimpleExoPlayer;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.misc.MediaUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SDKAnalyticsMonitorManager {
    private static final String TAG = "SDKAnalyticsMonitorManager";
    private boolean isStarted = false;
    private SDKNormalAnalyticsMonitor sdkNormalAnalyticsMonitor;
    private SDKStuckAnalyticsMonitor sdkStuckAnalyticsMonitor;

    public SDKAnalyticsMonitorManager(@NonNull SimpleExoPlayer simpleExoPlayer, Context context) {
        this.sdkNormalAnalyticsMonitor = null;
        this.sdkStuckAnalyticsMonitor = null;
        if (Globals.isSdkStuckEnabled()) {
            this.sdkStuckAnalyticsMonitor = new SDKStuckAnalyticsMonitor(simpleExoPlayer, context);
        }
        if (Globals.isSdkNormalEnabled()) {
            this.sdkNormalAnalyticsMonitor = new SDKNormalAnalyticsMonitor(simpleExoPlayer, context);
        }
    }

    public synchronized NormalReport endMonitor() {
        NormalReport normalReportEndMonitor = null;
        if (!this.isStarted) {
            return null;
        }
        SDKStuckAnalyticsMonitor sDKStuckAnalyticsMonitor = this.sdkStuckAnalyticsMonitor;
        if (sDKStuckAnalyticsMonitor != null) {
            sDKStuckAnalyticsMonitor.endMonitor();
        }
        SDKNormalAnalyticsMonitor sDKNormalAnalyticsMonitor = this.sdkNormalAnalyticsMonitor;
        if (sDKNormalAnalyticsMonitor != null) {
            normalReportEndMonitor = sDKNormalAnalyticsMonitor.endMonitor();
        }
        this.isStarted = false;
        return normalReportEndMonitor;
    }

    public synchronized SDKNormalAnalyticsMonitor getSDKNormalAnalyticsMonitor() {
        return this.sdkNormalAnalyticsMonitor;
    }

    public synchronized SDKStuckAnalyticsMonitor getSDKStuckAnalyticsMonitor() {
        return this.sdkStuckAnalyticsMonitor;
    }

    public synchronized StuckReport getStuckReport() {
        SDKStuckAnalyticsMonitor sDKStuckAnalyticsMonitor;
        return (!this.isStarted || (sDKStuckAnalyticsMonitor = this.sdkStuckAnalyticsMonitor) == null) ? null : sDKStuckAnalyticsMonitor.buildStuckReport();
    }

    public synchronized boolean isValidState() {
        return this.isStarted;
    }

    public synchronized void startMonitor(MediaUrl mediaUrl) {
        SDKStuckAnalyticsMonitor sDKStuckAnalyticsMonitor;
        if (!this.isStarted && mediaUrl != null && ((sDKStuckAnalyticsMonitor = this.sdkStuckAnalyticsMonitor) != null || this.sdkNormalAnalyticsMonitor != null)) {
            if (sDKStuckAnalyticsMonitor != null) {
                sDKStuckAnalyticsMonitor.startMonitor(mediaUrl);
            }
            SDKNormalAnalyticsMonitor sDKNormalAnalyticsMonitor = this.sdkNormalAnalyticsMonitor;
            if (sDKNormalAnalyticsMonitor != null) {
                sDKNormalAnalyticsMonitor.startMonitor(mediaUrl);
            }
            this.isStarted = true;
        }
    }
}
