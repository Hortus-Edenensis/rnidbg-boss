package com.bykv.vk.openvk.component.video.api.fx;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private int n;
    private String nr;
    private String u;
    private long fx = -2147483648L;
    private int b = Integer.MIN_VALUE;
    private long pn = -2147483648L;
    private double iz = -2.147483648E9d;
    private double x = -2.147483648E9d;

    public double b() {
        return this.x;
    }

    public long fx() {
        return this.fx;
    }

    public double iz() {
        return this.iz;
    }

    public String nr() {
        return this.u;
    }

    public String pn() {
        return this.nr;
    }

    public JSONObject u() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.nr)) {
                jSONObject.putOpt("audio_url", this.nr);
            }
            if (!TextUtils.isEmpty(this.u)) {
                jSONObject.putOpt("file_hash", this.u);
            }
            long j = this.fx;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.b;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.pn;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.iz;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.x;
            if (d2 > 0.0d) {
                jSONObject.put("start", d2);
            }
            int i2 = this.n;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int x() {
        return this.n;
    }

    public void nr(long j) {
        this.pn = j;
    }

    public void nr(String str) {
        this.nr = str;
    }

    public void nr(double d) {
        this.iz = d;
    }

    public void nr(int i) {
        if (i < 0) {
            i = 0;
        }
        this.n = i;
    }

    public void u(String str) {
        this.u = str;
    }

    public void u(long j) {
        this.fx = j;
    }

    public void u(int i) {
        this.b = i;
    }

    public void u(double d) {
        this.x = d;
    }
}
