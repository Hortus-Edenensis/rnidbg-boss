package defpackage;

import android.text.TextUtils;
import cn.jiguang.sdk.impl.connect.IpPort;
import com.qiniu.android.collect.ReportItem;
import com.tencent.matrix.trace.config.SharePluginInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class uu2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IpPort f21290a;
    public int b;
    public long c;
    public long d;
    public int e;

    public uu2(IpPort ipPort) {
        this.f21290a = ipPort;
    }

    public static uu2 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            uu2 uu2Var = new uu2(new IpPort(jSONObject.getString("ip"), jSONObject.getInt(ReportItem.RequestKeyPort)));
            uu2Var.b = jSONObject.optInt("status");
            uu2Var.c = jSONObject.optLong("fetch_time");
            uu2Var.d = jSONObject.optLong(SharePluginInfo.ISSUE_COST);
            uu2Var.e = jSONObject.optInt("prefer");
            return uu2Var;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.f21290a.ip);
            jSONObject.put(ReportItem.RequestKeyPort, this.f21290a.port);
            jSONObject.put("status", this.b);
            jSONObject.put("fetch_time", this.c);
            jSONObject.put(SharePluginInfo.ISSUE_COST, this.d);
            jSONObject.put("prefer", this.e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uu2)) {
            return false;
        }
        uu2 uu2Var = (uu2) obj;
        if (this.b != uu2Var.b || this.c != uu2Var.c || this.d != uu2Var.d || this.e != uu2Var.e) {
            return false;
        }
        IpPort ipPort = this.f21290a;
        IpPort ipPort2 = uu2Var.f21290a;
        return ipPort != null ? ipPort.equals(ipPort2) : ipPort2 == null;
    }

    public int hashCode() {
        IpPort ipPort = this.f21290a;
        int iHashCode = (((ipPort != null ? ipPort.hashCode() : 0) * 31) + this.b) * 31;
        long j = this.c;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.d;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.e;
    }

    public String toString() {
        return "IpInfo{ipPort=" + this.f21290a + ", status=" + this.b + ", fetchTime=" + this.c + ", cost=" + this.d + ", prefer=" + this.e + '}';
    }
}
