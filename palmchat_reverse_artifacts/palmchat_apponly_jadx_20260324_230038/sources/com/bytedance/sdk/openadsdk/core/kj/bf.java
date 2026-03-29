package com.bytedance.sdk.openadsdk.core.kj;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.cordova.App;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f5304a;
    private static final Set<String> iz;
    private static boolean jk;
    private static volatile boolean l;
    private static final Set<String> n;
    private static final Set<String> pn;
    private static final Map<String, String> t;
    public static final Set<String> u;
    private static final Set<String> x;
    private int nr;
    private static final Set<String> fx = new HashSet();
    private static final Set<String> b = new CopyOnWriteArraySet();

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        pn = copyOnWriteArraySet;
        iz = new CopyOnWriteArraySet();
        x = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        n = copyOnWriteArraySet2;
        f5304a = new CopyOnWriteArraySet();
        jk = false;
        t = new HashMap();
        u = new CopyOnWriteArraySet();
        l = false;
        copyOnWriteArraySet2.addAll(Arrays.asList(".*thefatherofsalmon\\.com.*@3", ".*qallzmx\\.quicklyopen\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*@3", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*@3"));
        copyOnWriteArraySet.addAll(Arrays.asList("^hap://app", "^hwfastapp://", ".*thefatherofsalmon\\.com.*", ".*qallzmx\\.quicklyopen\\.com.*", ".*fastappjump-drcn\\.hispace\\.hicloud\\.com.*", ".*fastappjump-drcn\\.hispace\\.dbankcloud\\.cn.*"));
    }

    public bf(JSONObject jSONObject) {
        this.nr = jSONObject.optInt("block_auto_open");
    }

    public static void nr(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("turn_up_white_list");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                b.clear();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        b.add(strOptString);
                    }
                }
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("turn_up_black_list_1");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                pn.clear();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        pn.add(strOptString2);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("turn_up_black_list_2");
            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                iz.clear();
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    String strOptString3 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString3)) {
                        iz.add(strOptString3);
                    }
                }
            }
        } catch (Exception unused3) {
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("url_report_rule_list");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    x.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                        String strOptString4 = jSONArrayOptJSONArray4.optString(i4);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            x.add(strOptString4);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("net_url_block_list");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    n.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                        String strOptString5 = jSONArrayOptJSONArray5.optString(i5);
                        if (!TextUtils.isEmpty(strOptString5)) {
                            n.add(strOptString5);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray("dialog_black_list");
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    f5304a.clear();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                        String strOptString6 = jSONArrayOptJSONArray6.optString(i6);
                        if (!TextUtils.isEmpty(strOptString6)) {
                            f5304a.add(strOptString6);
                        }
                    }
                }
            } catch (Exception unused4) {
            }
        }
        jk = true;
    }

    public void u(JSONObject jSONObject) {
        try {
            jSONObject.put("block_auto_open", this.nr);
        } catch (JSONException unused) {
        }
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        fxVar.put("turn_up_white_list", b);
        fxVar.put("turn_up_black_list_1", pn);
        fxVar.put("turn_up_black_list_2", iz);
        fxVar.put("url_report_rule_list", x);
        fxVar.put("net_url_block_list", n);
        fxVar.put("_turn_up_is_get_list", jk);
        fxVar.put("dialog_black_list", f5304a);
    }

    public static int u(bc bcVar) {
        bf bfVarMw;
        if (bcVar == null || (bfVarMw = bcVar.mw()) == null) {
            return 0;
        }
        return bfVarMw.nr;
    }

    public static boolean u(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.ja jaVar, String str, boolean z, boolean z2) {
        if (!str.startsWith("bytedance") && !str.startsWith("nativeapp") && !str.startsWith("bds")) {
            if (!com.bytedance.sdk.openadsdk.core.y.jp.u(str, atomicInteger) && u(webView, atomicInteger, str, true)) {
                return true;
            }
            if (jaVar == null || !TextUtils.isEmpty(nr(str, fx)) || !TextUtils.isEmpty(nr(str, b))) {
                return false;
            }
            String strNr = nr(str, x);
            if (!TextUtils.isEmpty(strNr)) {
                nr(jaVar.n(), str, strNr);
            }
            String strU = u(str, jaVar.pn(z2), z, z2);
            if (!TextUtils.isEmpty(strU) && jk) {
                u(jaVar.n(), str, strU);
            }
            if (!TextUtils.isEmpty(strU)) {
                return true;
            }
        }
        return false;
    }

    private static boolean u(WebView webView, AtomicInteger atomicInteger, String str, boolean z) {
        if (TextUtils.isEmpty(str) || webView == null) {
            return false;
        }
        final String[] strArr = {""};
        try {
            final String path = Uri.parse(str).getPath();
            Map<String, String> map = t;
            if (map.containsKey(path)) {
                return u(atomicInteger, map.get(path), str, webView, z);
            }
            if (!l) {
                for (String str2 : com.bytedance.sdk.openadsdk.core.y.bf.u("cloud_path_check_res").get("cloud_path_check_res", new HashSet())) {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit = str2.split(",");
                        t.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Map<String, String> map2 = t;
                if (map2.containsKey(path)) {
                    return u(atomicInteger, map2.get(path), str, webView, z);
                }
            }
            com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
            pnVarNr.u(Uri.parse("https://scc.bytedance.com/scc_sdk/url_scan_v4").buildUpon().appendQueryParameter("aid", "1181").appendQueryParameter("device_platform", "android").appendQueryParameter("device_id", com.bytedance.sdk.openadsdk.core.sx.fx()).appendQueryParameter("scc_mode", "raw").appendQueryParameter("scc_from", App.PLUGIN_NAME).toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("scene", "common");
            jSONObject.put("url", str);
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, "");
            pnVarNr.u(jSONObject);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.1
                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                    try {
                        strArr[0] = new JSONObject(nrVar.pn()).optJSONObject("data").optString("label");
                        if (TextUtils.isEmpty(strArr[0])) {
                            return;
                        }
                        if (bf.t.size() > 1000) {
                            Iterator it = bf.t.entrySet().iterator();
                            for (int i = 0; i < 200; i++) {
                                it.next();
                                it.remove();
                            }
                        }
                        bf.t.put(path, strArr[0]);
                        if (!bf.l) {
                            boolean unused = bf.l = true;
                            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.openadsdk.core.y.bf.u("cloud_path_check_res");
                                    fxVarU.clear();
                                    HashSet hashSet = new HashSet();
                                    for (Map.Entry entry : bf.t.entrySet()) {
                                        hashSet.add(((String) entry.getKey()) + "," + ((String) entry.getValue()));
                                    }
                                    fxVarU.put("cloud_path_check_res", hashSet);
                                    boolean unused2 = bf.l = false;
                                }
                            }, 1800000L);
                        }
                    } catch (Throwable unused2) {
                    }
                    countDownLatch.countDown();
                }

                @Override // com.bytedance.sdk.component.a.u.u
                public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return u(atomicInteger, strArr[0], str, webView, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        Set<String> set = b;
        set.addAll(fxVar.get("turn_up_white_list", set));
        Set<String> set2 = pn;
        set2.addAll(fxVar.get("turn_up_black_list_1", set2));
        Set<String> set3 = iz;
        set3.addAll(fxVar.get("turn_up_black_list_2", set3));
        Set<String> set4 = x;
        set4.addAll(fxVar.get("url_report_rule_list", set4));
        Set<String> set5 = n;
        set5.addAll(fxVar.get("net_url_block_list", set5));
        jk = fxVar.get("_turn_up_is_get_list", false);
        Set<String> set6 = f5304a;
        set6.addAll(fxVar.get("dialog_black_list", set6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String nr(String str, Set<String> set) {
        if (str == null) {
            return null;
        }
        try {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && Pattern.compile(str2).matcher(str).find()) {
                    return str2;
                }
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("JumpModel", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean u(AtomicInteger atomicInteger, String str, String str2, WebView webView, boolean z) {
        byte b2;
        if (webView == null || TextUtils.isEmpty(str) || atomicInteger == null) {
            return false;
        }
        if (atomicInteger.get() == 1) {
            return true;
        }
        switch (str.hashCode()) {
            case -284840886:
                b2 = !str.equals("unknown") ? (byte) -1 : (byte) 1;
                break;
            case 3181155:
                if (str.equals("gray")) {
                    b2 = 2;
                    break;
                }
                break;
            case 93818879:
                if (str.equals("black")) {
                    b2 = 0;
                    break;
                }
                break;
            case 113101865:
                if (str.equals("white")) {
                    b2 = 3;
                    break;
                }
                break;
        }
        if (b2 != 0) {
            return false;
        }
        atomicInteger.set(1);
        com.bytedance.sdk.openadsdk.core.y.iz.u(webView.getContext(), (String) null, true, (iz.u) null);
        return true;
    }

    public static void nr(final bc bcVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.4
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", bcVar.en());
                jSONObject2.put("cid", bcVar.lk());
                jSONObject2.put(ReportItem.RequestKeyRequestId, bcVar.xx());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.y.jp.mv(bcVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_url_report_rule").n(bcVar.ap()).nr(jSONObject.toString());
            }
        }, "stats_url_report_rule");
    }

    public static com.bytedance.sdk.component.nr.u.a nr() {
        return new com.bytedance.sdk.component.nr.u.a() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.5
            @Override // com.bytedance.sdk.component.nr.u.a
            public com.bytedance.sdk.component.nr.u.my u(a.u uVar) throws IOException {
                String str;
                com.bytedance.sdk.component.nr.u.my myVarU = uVar.u(uVar.u());
                String str2 = "";
                final String strU = myVarU.u("csj-location-record", "");
                final String strU2 = myVarU.u("csj-source-from", "");
                final String strU3 = myVarU.u("csj-extra-info", "");
                if (myVarU.fx() == 8848) {
                    final String strPn = myVarU.pn();
                    com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.5.1
                        @Override // com.bytedance.sdk.openadsdk.t.u.u
                        public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("url", strPn);
                            jSONObject.putOpt("sourceFrom", strU2);
                            jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strU3);
                            return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_net_block_url").nr(jSONObject.toString());
                        }
                    }, "stats_net_block_url");
                }
                int i = 0;
                try {
                    String[] strArrU = bf.u(strU);
                    if (strArrU == null || strArrU.length <= 1) {
                        str = "";
                    } else {
                        String str3 = strArrU[0];
                        try {
                            str = strArrU[strArrU.length - 1];
                            str2 = str3;
                        } catch (Exception unused) {
                            str = "";
                            str2 = str3;
                        }
                    }
                    try {
                        i = Integer.parseInt(strU2);
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                final String str4 = str2;
                final String str5 = str;
                if (TextUtils.isEmpty(strU) || i == 0 || !TextUtils.isEmpty(bf.nr(str4, bf.b))) {
                    return myVarU;
                }
                com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.5.2
                    @Override // com.bytedance.sdk.openadsdk.t.u.u
                    public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("url", strU);
                        jSONObject.putOpt("sourceFrom", strU2);
                        jSONObject.putOpt("sourceUrl", str4);
                        jSONObject.putOpt("destUrl", str5);
                        jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, strU3);
                        return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_net_locations_url").nr(jSONObject.toString());
                    }
                }, "stats_net_locations_url");
                return myVarU;
            }
        };
    }

    public static boolean u(WebView webView, AtomicInteger atomicInteger, com.bytedance.sdk.openadsdk.core.ja jaVar, WebResourceRequest webResourceRequest, boolean z, boolean z2) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return false;
        }
        return u(webView, atomicInteger, jaVar, url.toString(), z, z2);
    }

    public static boolean u(final com.bytedance.sdk.openadsdk.core.ja jaVar, final int i, final String str) {
        final String strNr = nr(str, f5304a);
        boolean z = (jk && TextUtils.isEmpty(strNr)) ? false : true;
        final boolean z2 = z;
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("url", str);
                    jSONObject.putOpt("type", Integer.valueOf(i));
                    jSONObject.putOpt("is_block", Boolean.valueOf(z2));
                    jSONObject.putOpt("is_get_setting", Boolean.valueOf(bf.jk));
                    jSONObject.putOpt("pattern", strNr);
                    jSONObject.putOpt("customer_id", com.bytedance.sdk.openadsdk.core.y.jp.mv(jaVar.n()));
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_dialog_report_rule").n(jaVar.n().ap()).nr(jSONObject.toString());
                } catch (Throwable unused) {
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr();
                }
            }
        }, "stats_dialog_report_rule");
        return z;
    }

    private static String u(String str, int i, boolean z, boolean z2) {
        boolean z3 = (!z2 || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
        if (i == 1) {
            if (jk) {
                return nr(str, iz);
            }
            return null;
        }
        if (i == 2) {
            if (!jk) {
                if (z) {
                    return "local://no-setting";
                }
                return null;
            }
            if (z3) {
                return "local://short-internal";
            }
            String strNr = nr(str, pn);
            if (!TextUtils.isEmpty(strNr)) {
                return strNr;
            }
            String strNr2 = nr(str, iz);
            if (TextUtils.isEmpty(strNr2)) {
                return null;
            }
            return strNr2;
        }
        if (i != 3) {
            return null;
        }
        if (z || !jk) {
            return "local://preload-setting:" + jk;
        }
        if (z3) {
            return "local://short-internal";
        }
        String strNr3 = nr(str, pn);
        if (!TextUtils.isEmpty(strNr3)) {
            return strNr3;
        }
        String strNr4 = nr(str, iz);
        if (TextUtils.isEmpty(strNr4)) {
            return null;
        }
        return strNr4;
    }

    public static void u(final bc bcVar, final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.kj.bf.3
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("url", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", bcVar.en());
                jSONObject2.put("cid", bcVar.lk());
                jSONObject2.put(ReportItem.RequestKeyRequestId, bcVar.xx());
                jSONObject2.put("customer_id", com.bytedance.sdk.openadsdk.core.y.jp.mv(bcVar));
                jSONObject.putOpt(MediationConstant.KEY_EXTRA_INFO, jSONObject2.toString());
                jSONObject.putOpt("pattern", str2);
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_block_report").n(bcVar.ap()).nr(jSONObject.toString());
            }
        }, "stats_block_report");
    }

    public static Set<String> u() {
        return n;
    }

    public static String[] u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.substring(1, str.length() - 1).split(",");
    }
}
