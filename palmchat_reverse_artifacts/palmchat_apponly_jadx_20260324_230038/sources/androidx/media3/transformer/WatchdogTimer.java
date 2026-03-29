package androidx.media3.transformer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import j$.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class WatchdogTimer {
    private final Listener listener;
    private final long timeoutDurationMs;
    private ScheduledFuture<?> timeoutScheduledFuture;
    private final ScheduledExecutorService watchdogScheduledExecutorService = Util.newSingleThreadScheduledExecutor("WatchdogTimer");

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onTimeout();
    }

    public WatchdogTimer(long j, Listener listener) {
        this.timeoutDurationMs = j;
        this.listener = listener;
    }

    private void cancelExistingTimer() {
        ((ScheduledFuture) Assertions.checkNotNull(this.timeoutScheduledFuture)).cancel(false);
    }

    private void scheduleNewTimer() {
        ScheduledExecutorService scheduledExecutorService = this.watchdogScheduledExecutorService;
        final Listener listener = this.listener;
        Objects.requireNonNull(listener);
        this.timeoutScheduledFuture = scheduledExecutorService.schedule(new Runnable() { // from class: ki6
            @Override // java.lang.Runnable
            public final void run() {
                listener.onTimeout();
            }
        }, this.timeoutDurationMs, TimeUnit.MILLISECONDS);
    }

    public void reset() {
        cancelExistingTimer();
        scheduleNewTimer();
    }

    public void start() {
        scheduleNewTimer();
    }

    public void stop() {
        cancelExistingTimer();
        this.watchdogScheduledExecutorService.shutdownNow();
    }
}
