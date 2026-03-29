package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {
    private long b;
    private long fx;
    private Handler iz;
    private boolean nr;
    private SoftReference<JumpUnknownSourceActivity> pn;
    private final Queue<Integer> u;
    private Runnable x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static final n u = new n();
    }

    private n() {
        this.u = new ArrayDeque();
        this.nr = false;
        this.iz = new Handler(Looper.getMainLooper());
        this.x = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.fx();
            }
        };
        com.ss.android.socialbase.downloader.u.u.u().u(new u.InterfaceC0886u() { // from class: com.ss.android.socialbase.appdownloader.n.2
            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void nr() {
                if (n.this.u.isEmpty()) {
                    return;
                }
                long jU = com.ss.android.socialbase.downloader.n.u.fx().u("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - n.this.b;
                if (jCurrentTimeMillis < jU) {
                    if (n.this.iz.hasCallbacks(n.this.x)) {
                        return;
                    }
                    n.this.iz.postDelayed(n.this.x, jU - jCurrentTimeMillis);
                } else {
                    n.this.b = System.currentTimeMillis();
                    n.this.fx();
                }
            }

            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void fx() {
            }
        });
    }

    private boolean b() {
        return System.currentTimeMillis() - this.fx < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.u.u.u().nr()) {
            synchronized (this.u) {
                numPoll = this.u.poll();
            }
            this.iz.removeCallbacks(this.x);
            if (numPoll == null) {
                this.nr = false;
                return;
            }
            final Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.iz.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.3
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.nr(contextOa, numPoll.intValue(), false);
                    }
                });
            } else {
                nr(contextOa, numPoll.intValue(), false);
            }
            this.iz.postDelayed(this.x, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nr(Context context, int i, boolean z) {
        int iNr = fx.nr(context, i, z);
        if (iNr == 1) {
            this.nr = true;
        }
        this.fx = System.currentTimeMillis();
        return iNr;
    }

    public void u(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        fx();
    }

    public JumpUnknownSourceActivity nr() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.pn;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.pn = null;
        return jumpUnknownSourceActivity;
    }

    public static n u() {
        return u.u;
    }

    public int u(final Context context, final int i, final boolean z) {
        if (z) {
            return nr(context, i, z);
        }
        if (b()) {
            this.iz.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.n.4
                @Override // java.lang.Runnable
                public void run() {
                    n.this.u(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.ss.android.socialbase.downloader.u.u.u().nr()) {
            com.ss.android.socialbase.downloader.fx.u.fx("leaves", "on Foreground");
            return nr(context, i, z);
        }
        if (nr.u()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.u.isEmpty() && !this.nr && z2) {
            return nr(context, i, z);
        }
        int iU = com.ss.android.socialbase.downloader.n.u.fx().u("install_queue_size", 3);
        synchronized (this.u) {
            while (this.u.size() > iU) {
                this.u.poll();
            }
        }
        if (z2) {
            this.iz.removeCallbacks(this.x);
            this.iz.postDelayed(this.x, com.ss.android.socialbase.downloader.n.u.u(i).u("install_queue_timeout", 20000L));
        }
        synchronized (this.u) {
            if (!this.u.contains(Integer.valueOf(i))) {
                this.u.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    public void u(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.pn = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
