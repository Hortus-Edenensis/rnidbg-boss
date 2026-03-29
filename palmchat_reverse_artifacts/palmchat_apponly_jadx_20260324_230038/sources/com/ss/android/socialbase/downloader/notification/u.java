package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10624a;
    private long b;
    private long fx;
    private int iz = 0;
    private int n;
    private int nr;
    private String pn;
    protected Notification u;
    private long x;

    public u(int i, String str) {
        this.nr = i;
        this.pn = str;
    }

    public String b() {
        return this.pn;
    }

    public long fx() {
        return this.b;
    }

    public long iz() {
        if (this.x == 0) {
            this.x = System.currentTimeMillis();
        }
        return this.x;
    }

    public boolean n() {
        return this.f10624a;
    }

    public long nr() {
        return this.fx;
    }

    public int pn() {
        return this.iz;
    }

    public abstract void u(BaseException baseException, boolean z);

    public void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.nr = downloadInfo.getId();
        this.pn = downloadInfo.getTitle();
    }

    public synchronized void x() {
        this.n++;
    }

    public void nr(long j) {
        this.b = j;
    }

    public int u() {
        return this.nr;
    }

    public void u(long j) {
        this.fx = j;
    }

    public void u(int i, BaseException baseException, boolean z) {
        u(i, baseException, z, false);
    }

    public void u(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.iz != i) {
            this.iz = i;
            u(baseException, z);
        }
    }

    public void u(long j, long j2) {
        this.fx = j;
        this.b = j2;
        this.iz = 4;
        u((BaseException) null, false);
    }

    public void u(Notification notification) {
        if (this.nr == 0 || notification == null) {
            return;
        }
        nr.u().u(this.nr, this.iz, notification);
    }
}
