package com.bytedance.sdk.openadsdk.core.jp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.fx.b;
import com.bytedance.sdk.openadsdk.core.h.nr;
import com.bytedance.sdk.openadsdk.core.jp.u.fx;
import com.bytedance.sdk.openadsdk.core.jp.u.pn;
import com.bytedance.sdk.openadsdk.core.kj.rv;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.sx;
import com.kuaishou.weapon.p0.g;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final List<String> mv = Arrays.asList("-10001", "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");

    @SuppressLint({"StaticFieldLeak"})
    private static volatile u u;
    private final rv b;
    private final fx fx;
    private String[] n;
    private final Context nr;
    private final b pn;
    private final AtomicBoolean x = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5288a = 0;
    private long jk = 0;
    private long t = 0;
    private long l = 0;
    private boolean iz = true;

    private u(Context context) {
        this.nr = context;
        this.fx = fx.u(context);
        b bVarU = b.u();
        this.pn = bVarU;
        if (bVarU == null) {
            this.b = new rv("", "-1", "", "");
            return;
        }
        String strFx = bVarU.fx("cr", 3300000L);
        if (TextUtils.isEmpty(strFx)) {
            this.b = new rv("", "", "", "");
        } else {
            this.b = new rv(bVarU.fx("vd", u(strFx)), bVarU.fx(NotificationCompat.CATEGORY_ERROR, u(strFx)), bVarU.fx("tk", u(strFx)), bVarU.fx("cr", u(strFx)));
        }
        fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.x.set(false);
        this.fx.nr();
    }

    private void fx() {
        b bVar = this.pn;
        if (bVar != null) {
            this.jk = bVar.nr("uni_fir_ts", 0L);
            if (jp.u(System.currentTimeMillis(), this.jk)) {
                this.t = this.pn.nr("uni_times", 0L);
                this.l = this.pn.nr("uni_ts", 0L);
            } else {
                this.t = 0L;
                this.l = 0L;
            }
        }
    }

    private boolean nr() {
        b bVar = this.pn;
        if (bVar != null) {
            String strFx = bVar.fx("cr", 3300000L);
            if (!TextUtils.isEmpty(strFx) && !TextUtils.isEmpty(this.pn.fx("tk", u(strFx)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long u(String str) {
        byte b;
        switch (str.hashCode()) {
            case 49:
                b = !str.equals("1") ? (byte) -1 : (byte) 1;
                break;
            case 50:
                if (str.equals("2")) {
                    b = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    b = 2;
                    break;
                }
                break;
        }
        if (b != 0) {
            return 3300000L;
        }
        return DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US;
    }

    public static u u(Context context) {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u(context);
                }
            }
        }
        return u;
    }

    public rv u() {
        if (!nr() && this.iz) {
            if (!this.x.compareAndSet(false, true)) {
                return this.b;
            }
            jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jp.u.1
                /* JADX WARN: Removed duplicated region for block: B:53:0x00cf  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int iU;
                    String strConcat;
                    final ArrayList arrayList = new ArrayList();
                    if (nr.u(u.this.nr, g.b) != -1) {
                        iU = u.this.fx.u();
                        if (iU != 3 || nr.u(u.this.nr, "android.permission.CHANGE_NETWORK_STATE") != -1) {
                            if (iU == 3 || iU == 2) {
                                String strU = pn.u();
                                strU.hashCode();
                                switch (strU) {
                                    case "0":
                                        u.this.iz = false;
                                        strConcat = "3";
                                        break;
                                    case "1":
                                        arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                        strConcat = "";
                                        break;
                                    case "2":
                                        arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                        strConcat = "";
                                        break;
                                    case "3":
                                        arrayList.add("https://id6.me/gw/preuniq.do");
                                        strConcat = "";
                                        break;
                                    case "4":
                                    case "6":
                                        arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                        arrayList.add("https://id6.me/gw/preuniq.do");
                                        arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                        strConcat = "";
                                        break;
                                    default:
                                        u.this.iz = false;
                                        strConcat = "2";
                                        break;
                                }
                            } else {
                                strConcat = "4".concat(String.valueOf(iU));
                            }
                        }
                        if (TextUtils.isEmpty(strConcat)) {
                            u.this.b.u("", strConcat, "", "");
                            u.this.x.set(false);
                            return;
                        }
                        u.this.b.u("", "1", "", "");
                        if (iU == 3) {
                            u.this.fx.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.jp.u.1.1
                                @Override // com.bytedance.sdk.openadsdk.core.jp.u.fx.u
                                public void u(Network network) {
                                    if (network == null) {
                                        u.this.b();
                                    } else {
                                        u.this.u(network, (List<String>) arrayList);
                                    }
                                }
                            });
                            return;
                        } else {
                            u.this.u((Network) null, arrayList);
                            return;
                        }
                    }
                    iU = 0;
                    u.this.iz = false;
                    strConcat = "5";
                    if (TextUtils.isEmpty(strConcat)) {
                    }
                }
            });
            return this.b;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010b A[ADDED_TO_REGION, EDGE_INSN: B:76:0x010b->B:58:0x010b BREAK  A[LOOP:0: B:3:0x0007->B:79:0x0007], REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(Network network, List<String> list) {
        int iHashCode;
        byte b;
        String str;
        String str2;
        String strU;
        String str3;
        String strU2;
        for (String str4 : list) {
            try {
                iHashCode = str4.hashCode();
            } catch (Exception unused) {
                this.b.u("", "6", "", "");
            }
            if (iHashCode == 15305274) {
                if (str4.equals("https://msg.cmpassport.com/h5/getMobile")) {
                    b = 0;
                }
                if (b != 0) {
                }
                u(network, strU, strU2, str, str3, str2);
                if (!TextUtils.isEmpty(this.b.nr())) {
                }
            } else {
                if (iHashCode != 899606572) {
                    b = (iHashCode == 1964448447 && str4.equals("https://id6.me/gw/preuniq.do")) ? (byte) 1 : (byte) -1;
                    if (b != 0) {
                        if (b != 1) {
                            if (b != 2) {
                                this.x.set(false);
                                return;
                            }
                            long j = this.t + 1;
                            this.t = j;
                            b bVar = this.pn;
                            if (bVar != null) {
                                bVar.u("uni_times", j);
                                if (this.t == 1) {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    this.jk = jCurrentTimeMillis;
                                    this.pn.u("uni_fir_ts", jCurrentTimeMillis);
                                }
                            }
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            str = "2";
                            if (jp.u(jCurrentTimeMillis2, this.jk) && this.t >= 30 && jCurrentTimeMillis2 - this.l < 3000000) {
                                this.b.u("2", "7", "", "2");
                            } else {
                                long jCurrentTimeMillis3 = System.currentTimeMillis();
                                this.l = jCurrentTimeMillis3;
                                b bVar2 = this.pn;
                                if (bVar2 != null) {
                                    bVar2.u("uni_ts", jCurrentTimeMillis3);
                                }
                                strU = str4;
                                strU2 = null;
                                str2 = null;
                                str3 = "2";
                            }
                            if (!TextUtils.isEmpty(this.b.nr()) || (!TextUtils.isEmpty(this.b.u()) && !mv.contains(this.b.u()))) {
                                break;
                            }
                        } else {
                            String strU3 = com.bytedance.sdk.component.utils.u.u(8);
                            str2 = strU3;
                            str = "3";
                            strU2 = null;
                            str3 = "1";
                            strU = com.bytedance.sdk.openadsdk.core.jp.u.b.u(str4, strU3);
                        }
                    } else {
                        str = "1";
                        str2 = null;
                        strU = str4;
                        str3 = "0";
                        strU2 = com.bytedance.sdk.openadsdk.core.jp.u.b.u();
                    }
                    u(network, strU, strU2, str, str3, str2);
                    if (!TextUtils.isEmpty(this.b.nr())) {
                        break;
                    }
                    break;
                    break;
                }
                if (str4.equals("https://nisportal.10010.com:9001/api?appid=1554778161154")) {
                    b = 2;
                }
                if (b != 0) {
                }
                u(network, strU, strU2, str, str3, str2);
                if (!TextUtils.isEmpty(this.b.nr())) {
                }
            }
        }
        if (!TextUtils.isEmpty(this.b.u()) && mv.contains(this.b.u())) {
            this.iz = false;
        }
        b();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(Network network, String str, String str2, String str3, String str4, String str5) {
        byte b;
        String str6;
        String string;
        JSONObject jSONObjectU = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : com.bytedance.sdk.openadsdk.core.jp.u.nr.u(network, str, str2);
        String str7 = "";
        if (jSONObjectU == null) {
            this.b.u(str4, "6", "", str3);
            return;
        }
        try {
            switch (str3.hashCode()) {
                case 49:
                    b = !str3.equals("1") ? (byte) -1 : (byte) 0;
                    break;
                case 50:
                    if (str3.equals("2")) {
                        b = 2;
                        break;
                    }
                    break;
                case 51:
                    if (str3.equals("3")) {
                        b = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (b == 0) {
                JSONObject jSONObject = jSONObjectU.getJSONObject("body");
                String string2 = jSONObject.getString("resultCode");
                if ("103000".equals(string2)) {
                    string = jSONObject.getString("token");
                    str6 = string;
                    str7 = "0";
                } else {
                    str6 = "";
                    str7 = string2;
                }
            } else if (b == 1) {
                String strValueOf = String.valueOf(jSONObjectU.getInt("result"));
                if ("0".equals(strValueOf)) {
                    string = new JSONObject(com.bytedance.sdk.openadsdk.core.jp.u.u.u(false, x.u(jSONObjectU.getString("data")), str5)).getString("accessCode");
                    str6 = string;
                    str7 = "0";
                } else {
                    str7 = strValueOf;
                    str6 = "";
                }
            } else if (b != 2) {
                str6 = "";
            } else {
                String strOptString = jSONObjectU.has("code") ? jSONObjectU.optString("code") : "";
                if (jSONObjectU.has("authurl")) {
                    String string3 = jSONObjectU.getString("authurl");
                    if (!TextUtils.isEmpty(string3)) {
                        Pair<String, String> pairU = u(network, string3 + "/api?appid=1554778161154", str3, str4);
                        Object obj = pairU.first;
                        if (obj != null) {
                            strOptString = (String) obj;
                        }
                        Object obj2 = pairU.second;
                        if (obj2 != null) {
                            str7 = (String) obj2;
                        }
                    }
                }
                str6 = str7;
                str7 = strOptString;
            }
            this.b.u(str4, str7, str6, str3);
            if (this.pn == null || TextUtils.isEmpty(str6)) {
                return;
            }
            this.pn.b("vd", str4);
            this.pn.b("cr", str3);
            this.pn.b(NotificationCompat.CATEGORY_ERROR, str7);
            this.pn.b("tk", str6);
        } catch (Exception unused) {
        }
    }

    private Pair<String, String> u(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.jp.u.nr.u(network, str, null);
        try {
            if (jSONObjectU == null) {
                this.b.u(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string2 = jSONObjectU.has("err_code") ? jSONObjectU.getString("err_code") : "6";
            if (this.n == null || System.currentTimeMillis() - this.f5288a > 3600000) {
                this.n = sx.iz();
                this.f5288a = System.currentTimeMillis();
            }
            String[] strArr = this.n;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.b.u(this.n[1]);
            }
            if (jSONObjectU.has(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                this.b.nr(jSONObjectU.getString(DistrictSearchQuery.KEYWORDS_PROVINCE));
            }
            if (jSONObjectU.has("code")) {
                string2 = "0";
                string = jSONObjectU.getString("code");
            } else {
                string = "";
            }
            return new Pair<>(string2, string);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
