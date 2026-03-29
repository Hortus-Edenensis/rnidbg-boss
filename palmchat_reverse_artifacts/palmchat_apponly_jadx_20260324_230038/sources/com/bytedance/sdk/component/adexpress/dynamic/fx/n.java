package com.bytedance.sdk.component.adexpress.dynamic.fx;

import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.qq.gdt.action.ActionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pn f5085a;
    private float b;
    private float fx;
    private float iz;
    private List<n> jk;
    private List<List<n>> l;
    private String mv;
    private float n;
    private float nr;
    private float pn;
    private boolean s;
    private n t;
    private String u;
    private float x;
    private Map<String, String> k = new HashMap();
    private Map<Integer, String> my = new HashMap();

    public float a() {
        return this.x;
    }

    public float b() {
        return this.b;
    }

    public boolean bg() {
        return this.s;
    }

    public Map<String, String> bq() {
        return this.k;
    }

    public boolean c() {
        return TextUtils.equals(this.f5085a.pn().d(), "flex");
    }

    public void dw() {
        List<List<n>> list = this.l;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<n> list2 : this.l) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.l = arrayList;
    }

    public String fx() {
        return this.u;
    }

    public float iz() {
        return this.nr;
    }

    public pn jk() {
        return this.f5085a;
    }

    public float k() {
        iz izVarPn = this.f5085a.pn();
        return mv() + izVarPn.k() + izVarPn.my() + (izVarPn.l() * 2.0f);
    }

    public n l() {
        return this.t;
    }

    public int mv() {
        iz izVarPn = this.f5085a.pn();
        return izVarPn.wi() + izVarPn.su();
    }

    public float my() {
        iz izVarPn = this.f5085a.pn();
        return s() + izVarPn.o() + izVarPn.s() + (izVarPn.l() * 2.0f);
    }

    public float n() {
        return this.iz;
    }

    public Map<Integer, String> nr() {
        return this.my;
    }

    public List<List<n>> o() {
        return this.l;
    }

    public float pn() {
        return this.pn;
    }

    public String q() {
        return this.f5085a.pn().q();
    }

    public boolean qq() {
        return this.f5085a.pn().jw() < 0 || this.f5085a.pn().uq() < 0 || this.f5085a.pn().ju() < 0 || this.f5085a.pn().zx() < 0;
    }

    public int s() {
        iz izVarPn = this.f5085a.pn();
        return izVarPn.cj() + izVarPn.tk();
    }

    public boolean sx() {
        List<n> list = this.jk;
        return list == null || list.size() <= 0;
    }

    public List<n> t() {
        return this.jk;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.u + "', x=" + this.nr + ", y=" + this.fx + ", width=" + this.iz + ", height=" + this.x + ", remainWidth=" + this.n + ", rootBrick=" + this.f5085a + ", childrenBrickUnits=" + this.jk + '}';
    }

    public String u() {
        return this.mv;
    }

    public float x() {
        return this.fx;
    }

    public void b(float f) {
        this.fx = f;
    }

    public void fx(float f) {
        this.nr = f;
    }

    public void iz(float f) {
        this.x = f;
    }

    public void nr(String str) {
        this.u = str;
    }

    public void pn(float f) {
        this.iz = f;
    }

    public void u(String str) {
        this.mv = str;
    }

    public void x(float f) {
        this.n = f;
    }

    public void fx(String str) {
        this.f5085a.pn().iz(str);
    }

    public void nr(float f) {
        this.pn = f;
    }

    public void u(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.my.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void nr(List<List<n>> list) {
        this.l = list;
    }

    public void u(float f) {
        this.b = f;
    }

    public void u(pn pnVar) {
        this.f5085a = pnVar;
    }

    public void u(List<n> list) {
        this.jk = list;
    }

    public void u(n nVar) {
        this.t = nVar;
    }

    public void u(boolean z) {
        this.s = z;
    }

    public void u(String str, String str2) {
        this.k.put(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5085a.getType());
        sb.append(":");
        sb.append(this.u);
        if (this.f5085a.pn() != null) {
            sb.append(":");
            sb.append(this.f5085a.pn().gl());
        }
        sb.append(":");
        sb.append(i);
        if (this.f5085a.pn() != null) {
            sb.append(":");
            String strM = this.f5085a.pn().m();
            strM.hashCode();
            switch (strM) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String strM2 = this.f5085a.pn().m();
            strM2.hashCode();
            if (strM2.equals(BaseWrapper.ENTER_ID_17) || strM2.equals(BaseWrapper.ENTER_ID_18)) {
                i2 = (i2 * 10) + 2;
            }
            String strM3 = this.f5085a.pn().m();
            strM3.hashCode();
            switch (strM3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
