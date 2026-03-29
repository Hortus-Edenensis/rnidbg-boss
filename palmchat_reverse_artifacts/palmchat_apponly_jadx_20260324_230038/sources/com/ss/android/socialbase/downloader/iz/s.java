package com.ss.android.socialbase.downloader.iz;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s {
    private int nr;
    private final JSONObject u;

    private s(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    private int my() {
        return this.u.optInt("url_balance", 2);
    }

    public long a() {
        long jOptInt = ((long) this.u.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < x()) {
            return -1L;
        }
        return jOptInt;
    }

    public int b() {
        return this.u.optInt("buffer_count", 512);
    }

    public boolean fx() {
        return my() == 1;
    }

    public boolean iz() {
        return this.u.optInt("segment_mode", 1) == 0;
    }

    public long jk() {
        long jOptInt = this.u.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public float k() {
        return Math.min(Math.max(0.0f, (float) this.u.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public int l() {
        return this.u.optInt("ip_strategy", 0);
    }

    public float mv() {
        return (float) this.u.optDouble("main_ratio", 0.0d);
    }

    public long n() {
        long jOptInt = ((long) this.u.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public boolean nr() {
        return my() > 0;
    }

    public int pn() {
        return this.u.optInt("buffer_size", 8192);
    }

    public int s() {
        return this.u.optInt("ratio_segment", 0);
    }

    public long t() {
        long jOptInt = this.u.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public void u(int i) {
        this.nr = nr(i);
    }

    public long x() {
        long jOptInt = ((long) this.u.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    private int nr(int i) {
        int iOptInt = this.u.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return my() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (my() > 0) {
            return i;
        }
        return 1;
    }

    public int u() {
        return this.nr;
    }

    @NonNull
    public static s u(@NonNull JSONObject jSONObject) {
        return new s(jSONObject);
    }
}
