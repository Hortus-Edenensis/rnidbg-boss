package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f10578a;
    private final boolean b;
    private final String fx;
    private final String iz;
    private final List<String> jk;
    private final String k;
    private final Object l;
    private final String mv;
    private final JSONObject my;
    private final JSONObject n;
    private final String nr;
    private final long pn;
    private final boolean s;
    private final int t;
    private String u;
    private final long x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f10579a;
        private String fx;
        private String iz;
        private Map<String, Object> jk;
        private int l;
        private Object mv;
        private String my;
        private JSONObject n;
        private String nr;
        private JSONObject o;
        private long pn;
        private String s;
        private List<String> t;
        private String u;
        private long x;
        private boolean b = false;
        private boolean k = false;

        public u b(String str) {
            this.s = str;
            return this;
        }

        public u fx(String str) {
            this.iz = str;
            return this;
        }

        public u nr(String str) {
            this.fx = str;
            return this;
        }

        public u u(boolean z) {
            this.k = z;
            return this;
        }

        public u nr(long j) {
            this.x = j;
            return this;
        }

        public u u(String str) {
            this.nr = str;
            return this;
        }

        public u nr(boolean z) {
            this.b = z;
            return this;
        }

        public u u(long j) {
            this.pn = j;
            return this;
        }

        public u nr(JSONObject jSONObject) {
            this.f10579a = jSONObject;
            return this;
        }

        public u u(JSONObject jSONObject) {
            this.n = jSONObject;
            return this;
        }

        public u u(List<String> list) {
            this.t = list;
            return this;
        }

        public u u(int i) {
            this.l = i;
            return this;
        }

        public u u(Object obj) {
            this.mv = obj;
            return this;
        }

        public fx u() {
            if (TextUtils.isEmpty(this.u)) {
                this.u = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.n == null) {
                this.n = new JSONObject();
            }
            try {
                Map<String, Object> map = this.jk;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.jk.entrySet()) {
                        if (!this.n.has(entry.getKey())) {
                            this.n.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.k) {
                    this.my = this.fx;
                    JSONObject jSONObject2 = new JSONObject();
                    this.o = jSONObject2;
                    if (this.b) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.n.toString());
                    } else {
                        Iterator<String> itKeys = this.n.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.o.put(next, this.n.get(next));
                        }
                    }
                    this.o.put(x.cw, this.u);
                    this.o.put("tag", this.nr);
                    this.o.put(ActionUtils.PAYMENT_AMOUNT, this.pn);
                    this.o.put("ext_value", this.x);
                    if (!TextUtils.isEmpty(this.s)) {
                        this.o.put("refer", this.s);
                    }
                    JSONObject jSONObject3 = this.f10579a;
                    if (jSONObject3 != null) {
                        this.o = com.ss.android.download.api.fx.nr.u(jSONObject3, this.o);
                    }
                    if (this.b) {
                        if (!this.o.has("log_extra") && !TextUtils.isEmpty(this.iz)) {
                            this.o.put("log_extra", this.iz);
                        }
                        this.o.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.b) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.n.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.iz)) {
                        jSONObject.put("log_extra", this.iz);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.n);
                }
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.putOpt("refer", this.s);
                }
                JSONObject jSONObject4 = this.f10579a;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.fx.nr.u(jSONObject4, jSONObject);
                }
                this.n = jSONObject;
            } catch (Exception e) {
                l.bq().u(e, "DownloadEventModel build");
            }
            return new fx(this);
        }
    }

    public fx(u uVar) {
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz;
        this.x = uVar.x;
        this.n = uVar.n;
        this.f10578a = uVar.f10579a;
        this.jk = uVar.t;
        this.t = uVar.l;
        this.l = uVar.mv;
        this.s = uVar.k;
        this.k = uVar.my;
        this.my = uVar.o;
        this.mv = uVar.s;
    }

    public JSONObject a() {
        return this.f10578a;
    }

    public boolean b() {
        return this.b;
    }

    public String fx() {
        return this.fx;
    }

    public String iz() {
        return this.iz;
    }

    public List<String> jk() {
        return this.jk;
    }

    public JSONObject k() {
        return this.my;
    }

    public Object l() {
        return this.l;
    }

    public boolean mv() {
        return this.s;
    }

    public JSONObject n() {
        return this.n;
    }

    public String nr() {
        return this.nr;
    }

    public long pn() {
        return this.pn;
    }

    public String s() {
        return this.k;
    }

    public int t() {
        return this.t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("category: ");
        sb.append(this.u);
        sb.append("\ttag: ");
        sb.append(this.nr);
        sb.append("\tlabel: ");
        sb.append(this.fx);
        sb.append("\nisAd: ");
        sb.append(this.b);
        sb.append("\tadId: ");
        sb.append(this.pn);
        sb.append("\tlogExtra: ");
        sb.append(this.iz);
        sb.append("\textValue: ");
        sb.append(this.x);
        sb.append("\nextJson: ");
        sb.append(this.n);
        sb.append("\nparamsJson: ");
        sb.append(this.f10578a);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.jk;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.t);
        sb.append("\textraObject: ");
        Object obj = this.l;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.s);
        sb.append("\tV3EventName: ");
        sb.append(this.k);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.my;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public String u() {
        return this.u;
    }

    public long x() {
        return this.x;
    }
}
