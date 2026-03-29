package com.bykv.vk.openvk.component.video.api.fx;

import android.text.TextUtils;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4964a;
    private double b;
    private long fx;
    private String iz;
    private String jk;
    private int l;
    private int mv;
    private String n;
    private int nr;
    private String pn;
    private double t;
    private int u;
    private String x;
    private float s = -1.0f;
    private int k = 0;
    private int my = 0;
    private int o = 0;
    private int sx = 0;
    private int bg = 307200;
    private int bq = 1;

    public String a() {
        return this.pn;
    }

    public int b() {
        return this.mv;
    }

    public JSONObject bg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", nr());
            jSONObject.put("cover_url", t());
            jSONObject.put("cover_width", fx());
            jSONObject.put("endcard", mv());
            jSONObject.put("file_hash", k());
            jSONObject.put("resolution", a());
            jSONObject.put("size", pn());
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, iz());
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_URL, l());
            jSONObject.put("playable_download_url", s());
            jSONObject.put("if_playable_loading_show", bq());
            jSONObject.put("remove_loading_page_type", dw());
            jSONObject.put("fallback_endcard_judge", u());
            jSONObject.put("video_preload_size", my());
            jSONObject.put("reward_video_cached_type", o());
            jSONObject.put("execute_cached_type", sx());
            jSONObject.put("endcard_render", b());
            jSONObject.put("replay_time", qq());
            jSONObject.put("play_speed_ratio", n());
            if (x() > 0.0d) {
                jSONObject.put("start", x());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int bq() {
        return this.k;
    }

    public boolean c() {
        return this.sx == 1;
    }

    public int dw() {
        return this.my;
    }

    public int fx() {
        return this.nr;
    }

    public double iz() {
        return this.b;
    }

    public int[] jk() {
        try {
            int iIndexOf = this.pn.indexOf("x");
            return new int[]{Integer.parseInt(this.pn.substring(0, iIndexOf).trim()), Integer.parseInt(this.pn.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String k() {
        if (TextUtils.isEmpty(this.jk)) {
            this.jk = com.bykv.vk.openvk.component.video.api.iz.nr.u(this.x);
        }
        return this.jk;
    }

    public String l() {
        return this.x;
    }

    public String mv() {
        return this.n;
    }

    public int my() {
        if (this.bg < 0) {
            this.bg = 307200;
        }
        long j = this.bg;
        long j2 = this.fx;
        if (j > j2) {
            this.bg = (int) j2;
        }
        return this.bg;
    }

    public float n() {
        return this.s;
    }

    public int nr() {
        return this.u;
    }

    public int o() {
        return this.o;
    }

    public long pn() {
        return this.fx;
    }

    public boolean q() {
        return this.o == 0;
    }

    public int qq() {
        return this.bq;
    }

    public String s() {
        return this.f4964a;
    }

    public int sx() {
        return this.sx;
    }

    public String t() {
        return this.iz;
    }

    public int u() {
        return this.l;
    }

    public double x() {
        return this.t;
    }

    public void b(String str) {
        this.n = str;
    }

    public void fx(int i) {
        this.nr = i;
    }

    public void iz(int i) {
        this.sx = i;
    }

    public void nr(int i) {
        this.u = i;
    }

    public void pn(String str) {
        this.jk = str;
    }

    public void u(int i) {
        this.l = i;
    }

    public void b(int i) {
        this.bg = i;
    }

    public void fx(String str) {
        this.x = str;
    }

    public void nr(double d) {
        this.t = d;
    }

    public void pn(int i) {
        this.o = i;
    }

    public void u(long j) {
        this.fx = j;
    }

    public void nr(String str) {
        this.iz = str;
    }

    public void u(double d) {
        this.b = d;
    }

    public void u(float f) {
        this.s = f;
    }

    public void u(String str) {
        this.pn = str;
    }
}
