package com.ss.android.downloadlib.addownload.nr;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10589a;
    public String b;
    public String fx;
    public String iz;
    public final List<Pair<String, String>> n = new ArrayList();
    public long nr;
    public String pn;
    public long u;
    public String x;

    public static long u(long j, long j2) {
        return j > 0 ? j : j2;
    }

    public long u() {
        return u(this.u, this.nr);
    }
}
