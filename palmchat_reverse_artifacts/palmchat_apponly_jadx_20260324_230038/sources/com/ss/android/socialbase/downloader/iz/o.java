package com.ss.android.socialbase.downloader.iz;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10614a;
    final boolean b;
    final String fx;
    private int iz;
    private final AtomicLong jk;
    private int n;
    final String nr;
    private final List<mv> pn;
    final String u;
    private boolean x;

    public o(String str, boolean z) {
        this.pn = new ArrayList();
        this.jk = new AtomicLong();
        this.u = str;
        this.b = z;
        this.nr = null;
        this.fx = null;
    }

    private String pn() {
        if (this.f10614a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.u);
            sb.append("_");
            String str = this.nr;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.b);
            this.f10614a = sb.toString();
        }
        return this.f10614a;
    }

    private String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized boolean b() {
        return this.x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return pn().equals(((o) obj).pn());
        }
        return false;
    }

    public synchronized void fx() {
        this.x = false;
    }

    public int hashCode() {
        if (this.n == 0) {
            this.n = pn().hashCode();
        }
        return this.n;
    }

    public synchronized void nr(mv mvVar) {
        try {
            this.pn.remove(mvVar);
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return "UrlRecord{url='" + this.u + "', ip='" + this.nr + "', ipFamily='" + this.fx + "', isMainUrl=" + this.b + ", failedTimes=" + this.iz + ", isCurrentFailed=" + this.x + '}';
    }

    public synchronized void nr() {
        this.iz++;
        this.x = true;
    }

    public synchronized void u(mv mvVar) {
        this.pn.add(mvVar);
    }

    public synchronized int u() {
        return this.pn.size();
    }

    public o(String str, String str2) {
        this.pn = new ArrayList();
        this.jk = new AtomicLong();
        this.u = str;
        this.b = false;
        this.nr = str2;
        this.fx = u(str2);
    }

    public void u(long j) {
        this.jk.addAndGet(j);
    }
}
