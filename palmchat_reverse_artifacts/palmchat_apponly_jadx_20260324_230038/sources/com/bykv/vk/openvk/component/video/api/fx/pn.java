package com.bykv.vk.openvk.component.video.api.fx;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.b.x;
import com.qiniu.android.collect.ReportItem;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements nr {
    private static final AtomicInteger dw = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4966a;
    private String b;
    private String bg;
    private int bq;
    private int c;
    private String fx;
    private int iz;
    private double jk;
    private int k;
    private JSONObject kj;
    private long l;
    private long mv;
    private int my;
    private StringBuilder n;
    private JSONArray nr;
    private int o;
    private String pn;
    private String q;
    private int qq;
    private long s;
    private boolean sx;
    private double t;
    private StringBuilder u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private String fx;
        private long iz;
        private double jk;
        private JSONObject l;
        private int n;
        private String nr;
        private int pn;
        private String u;
        private int x;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4967a = -1;
        private String t = "";

        public u b(String str) {
            this.b = str;
            return this;
        }

        public u fx(String str) {
            this.nr = str;
            return this;
        }

        public u nr(String str) {
            this.fx = str;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public u fx(int i) {
            this.n = i;
            return this;
        }

        public u nr(int i) {
            this.x = i;
            return this;
        }

        public u u(double d) {
            this.jk = d;
            return this;
        }

        public u u(int i) {
            this.pn = i;
            return this;
        }

        public u u(long j) {
            this.iz = j;
            return this;
        }

        public pn u() {
            return new pn(this);
        }
    }

    public String fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str.hashCode();
        switch (str) {
        }
        return "unknown";
    }

    @Override // com.bykv.vk.openvk.component.video.api.fx.nr
    public void nr(String str) {
        int iIndexOf = this.n.indexOf(str);
        if (TextUtils.isEmpty(this.n)) {
            this.n.append(str);
        } else if (iIndexOf == -1) {
            StringBuilder sb = this.n;
            sb.append(",");
            sb.append(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.fx.nr
    public void u(int i, int i2, String str) {
        this.o = i;
        this.bq = i2;
        this.bg = str;
    }

    private pn() {
        this.u = new StringBuilder();
        this.nr = new JSONArray();
        this.o = -8888;
        this.sx = false;
        this.bq = -8888;
        this.c = 0;
        this.qq = -1;
        this.c = dw.addAndGet(1);
    }

    @Override // com.bykv.vk.openvk.component.video.api.fx.nr
    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", this.pn);
            jSONObject.put("cid", this.b);
            jSONObject.put("adtype", this.iz);
            jSONObject.put(ReportItem.RequestKeyRequestId, this.fx);
            jSONObject.put("duration", this.x);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject nr() {
        JSONObject jSONObject = this.kj;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("session_id", this.n.toString());
            jSONObject.put("node_line", this.u.toString());
            jSONObject.put("node_line_detail", this.nr.toString());
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_URL, this.f4966a);
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_DURATION, this.jk);
            jSONObject.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, this.t);
            jSONObject.put("start_duration", this.mv - this.l);
            jSONObject.put("play_duration", SystemClock.elapsedRealtime() - this.l);
            jSONObject.put("play_cache_size", this.s);
            jSONObject.put("play_type", this.k);
            jSONObject.put("player_type", this.my);
            jSONObject.put("video_index", this.c);
            jSONObject.put("is_audio", this.sx ? 1 : 0);
            jSONObject.put("dynamic_join_type", this.qq);
            int i = this.o;
            if (i != -8888) {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
            }
            jSONObject.put("error_msg", this.bg);
            int i2 = this.bq;
            if (i2 != -8888) {
                jSONObject.put("extra_error_code", i2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bykv.vk.openvk.component.video.api.fx.nr
    public void u(String str) {
        this.u.append(str);
        String strFx = fx(str);
        JSONObject jSONObject = new JSONObject();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.equals("0505", str)) {
            this.l = jElapsedRealtime;
        } else if (TextUtils.equals("0506", str)) {
            this.mv = jElapsedRealtime;
        }
        try {
            jSONObject.putOpt("type", strFx);
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        this.nr.put(jSONObject);
    }

    private pn(u uVar) {
        this.u = new StringBuilder();
        this.nr = new JSONArray();
        this.o = -8888;
        this.sx = false;
        this.bq = -8888;
        this.c = 0;
        this.qq = -1;
        this.fx = uVar.nr;
        this.b = uVar.fx;
        this.pn = uVar.b;
        this.iz = uVar.pn;
        this.k = uVar.n;
        this.qq = uVar.f4967a;
        this.s = uVar.iz;
        this.my = uVar.x;
        this.jk = uVar.jk;
        this.q = uVar.u;
        this.kj = uVar.l;
        String str = uVar.t;
        this.n = new StringBuilder(TextUtils.isEmpty(str) ? "" : str);
        this.c = dw.addAndGet(1);
    }

    @Override // com.bykv.vk.openvk.component.video.api.fx.nr
    public void u(long j, iz izVar) {
        x xVar = (x) com.bytedance.sdk.openadsdk.ats.fx.u("event");
        if (xVar == null || izVar == null) {
            return;
        }
        this.t = izVar.l();
        this.sx = izVar.x();
        this.x = String.valueOf(j);
        this.f4966a = izVar.my();
        xVar.onStatsEvent(this.q, u(), nr());
    }
}
