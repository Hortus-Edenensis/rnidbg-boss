package defpackage;

import android.database.Cursor;
import android.util.Pair;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.database.SocialContentProvider;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class eq5 extends wt0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17336a;

        public a(int i) {
            this.f17336a = i;
            put("action", "sync");
            put("status", i == 0 ? "success" : "fail");
            put("resultCode", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17337a;

        public b(String str) {
            this.f17337a = str;
            put("action", "sync");
            put("status", "fail");
            put("detail", "switchAccount requestUid" + str + " dbUid=" + SocialContentProvider.v());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f17338a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ boolean e;

        public c(long j, long j2, long j3, long j4, boolean z) {
            this.f17338a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
            this.e = z;
            put("action", "sync");
            put(TKDownloadReason.KSAD_TK_NET, hx3.h());
            put(com.umeng.analytics.pro.f.p, Long.valueOf(j));
            put(com.umeng.analytics.pro.f.q, Long.valueOf(j2));
            put("rq_start_time", Long.valueOf(j3));
            put("rq_end_time", Long.valueOf(j4));
            put(ActionUtils.IS_SUCCESS, Boolean.valueOf(z));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f17339a;

        public d(String[] strArr) {
            this.f17339a = strArr;
            put("action", "sync");
            put("status", "process");
            put("params", il5.m(strArr));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {
        public e() {
            put("action", "sync");
            put("status", "end");
            put("detail", "empty skey");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17340a;
        public HashMap<String, Long> b;

        public f() {
            this.f17340a = -1;
        }
    }

    public static boolean n(String str, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        for (String str2 : strArr) {
            if (str != null && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static HashMap<String, Long> o() {
        HashMap<String, Long> map = new HashMap<>();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(hq5.f18030a, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(cursorQuery.getColumnIndex("resource_type")), Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("resource_version"))));
            }
            cursorQuery.close();
        }
        return map;
    }

    public static Long p(HashMap<String, Long> map, HashMap<String, Long> map2, String str) {
        Long l;
        Long l2;
        Long l3 = null;
        if (map2 == null || map == null) {
            l = null;
            l2 = null;
        } else {
            Long l4 = map.get(str);
            l2 = map2.get(str);
            if (l4 == null || !l4.equals(l2)) {
                l3 = l4;
                l = l2;
            } else {
                l3 = l4;
                l = null;
            }
        }
        LogUtil.i("SyncDao", "getVersionKey type=" + str + "local =" + l3 + " serverV=" + l2 + " result =" + l);
        return l;
    }

    public static String[] q(String str, String... strArr) {
        HashSet hashSet = new HashSet();
        int i = 0;
        if (strArr == null || strArr.length == 0) {
            while (true) {
                String[] strArr2 = mx4.f19387a;
                if (i >= strArr2.length) {
                    break;
                }
                hashSet.add(strArr2[i]);
                i++;
            }
        } else {
            while (i < strArr.length) {
                hashSet.add(strArr[i]);
                i++;
            }
        }
        hashSet.remove(str);
        String[] strArr3 = new String[hashSet.size()];
        hashSet.toArray(strArr3);
        return strArr3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d5  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Boolean, Long> r(boolean z, String... strArr) {
        ?? r0;
        int i;
        boolean z2;
        LogUtil.i("SyncDao", 3, new d(strArr), (Throwable) null);
        long jLongValue = -1;
        if (AppContext.getSecretKey() == null) {
            LogUtil.i("SyncDao", 3, new e(), (Throwable) null);
            return new Pair<>(Boolean.FALSE, -1L);
        }
        ?? r1 = 0;
        try {
            i = 100;
            try {
            } catch (Exception e2) {
                e = e2;
                r1 = "2";
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (!ns.c().b().isSyncSwitch() || !AppContext.getContext().isBackground()) {
            if (n("2", strArr)) {
                z2 = false;
                while (true) {
                    if (i <= 0) {
                        break;
                    }
                    i--;
                    try {
                        int i2 = s(z, "2").f17340a;
                        boolean z3 = i2 >= 0;
                        if (i2 < 1) {
                            z2 = z3;
                            break;
                        }
                        z2 = z3;
                    } catch (Exception e4) {
                        e = e4;
                        r1 = z2;
                        LogUtil.e("SyncDao", e, 3);
                        r0 = r1;
                    }
                }
            } else {
                z2 = false;
            }
            String[] strArrQ = q("2", strArr);
            if (strArrQ != null) {
                if (strArrQ.length > 0) {
                    r0 = z2;
                    while (i > 0) {
                        i--;
                        f fVarS = s(z, strArrQ);
                        int i3 = fVarS.f17340a;
                        HashMap<String, Long> map = fVarS.b;
                        if (map != null && map.get("3") != null) {
                            jLongValue = fVarS.b.get("3").longValue();
                        }
                        r0 = i3 >= 0 ? 1 : 0;
                        if (i3 >= 1) {
                        }
                    }
                } else {
                    r0 = z2;
                }
            }
            return new Pair<>(Boolean.valueOf((boolean) r0), Long.valueOf(jLongValue));
        }
        LogUtil.i("BatterySaveManager", "syncSwitch enable");
        r0 = 0;
        while (i > 0) {
            i--;
            f fVarS2 = s(z, strArr);
            int i4 = fVarS2.f17340a;
            HashMap<String, Long> map2 = fVarS2.b;
            if (map2 != null && map2.get("3") != null) {
                jLongValue = fVarS2.b.get("3").longValue();
            }
            r0 = i4 >= 0 ? 1 : 0;
            if (i4 >= 1) {
            }
        }
        return new Pair<>(Boolean.valueOf((boolean) r0), Long.valueOf(jLongValue));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9 A[Catch: all -> 0x0237, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0021, B:10:0x0042, B:11:0x0056, B:13:0x006b, B:18:0x0072, B:20:0x0075, B:22:0x0082, B:33:0x00be, B:28:0x0096, B:30:0x00a9, B:32:0x00b8, B:25:0x008b, B:34:0x00c3, B:36:0x012b, B:38:0x0137, B:39:0x0143, B:40:0x0167, B:48:0x0208, B:52:0x0211, B:54:0x021b, B:43:0x01f3, B:44:0x01fb, B:16:0x006f), top: B:62:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized f s(boolean z, String... strArr) throws Exception {
        int i;
        long j;
        long j2;
        f fVar;
        long j3;
        Long l;
        String str;
        long jLongValue;
        String[] strArr2 = strArr;
        synchronized (eq5.class) {
            f fVar2 = new f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!AccountUtils.r(AppContext.getContext()) || AppContext.getSecretKey() == null) {
                i = -1;
                j = 0;
                j2 = 0;
            } else {
                String strZ = k86.Z(nl0.z + "/sync.v4");
                String strP = AccountUtils.p(AppContext.getContext());
                if (!z) {
                    strZ = strZ + "&continuous=0";
                }
                String str2 = strZ;
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                HashMap<String, Long> mapO = o();
                yn0.a(strP, mapO);
                if (strArr2 == null || strArr2.length <= 0) {
                    strArr2 = mx4.f19387a;
                }
                int i2 = 0;
                while (i2 < strArr2.length) {
                    JSONObject jSONObject2 = new JSONObject();
                    String str3 = strArr2[i2];
                    if (am0.b()) {
                        if (str3.equals("9")) {
                            str = strP;
                        }
                        jSONObject2.put("syncKey", strArr2[i2]);
                        l = mapO.get(strArr2[i2]);
                        if (l == null) {
                            str = strP;
                            jLongValue = l.longValue();
                        } else {
                            str = strP;
                            jLongValue = 0;
                        }
                        jSONObject2.put("version", jLongValue);
                        jSONArray.put(jSONObject2);
                    } else if (str3.equals(BaseWrapper.ENTER_ID_AD_SDK)) {
                        str = strP;
                    } else {
                        jSONObject2.put("syncKey", strArr2[i2]);
                        l = mapO.get(strArr2[i2]);
                        if (l == null) {
                        }
                        jSONObject2.put("version", jLongValue);
                        jSONArray.put(jSONObject2);
                    }
                    i2++;
                    strP = str;
                }
                String str4 = strP;
                LogUtil.i("SyncDao", "syncKeys" + jSONArray.toString());
                jSONObject.put("syncKeys", jSONArray);
                RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
                RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
                EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str2, jSONObject, requestFutureNewFuture, requestFutureNewFuture);
                encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(wt0.waitTime, wt0.retryCount, 1.0f));
                normalRequestQueue.add(encryptedJsonRequest);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject3 = (JSONObject) requestFutureNewFuture.get(encryptedJsonRequest);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                int i3 = jSONObject3.getInt("resultCode");
                LogUtil.i("SyncDao", 3, new a(i3), (Throwable) null);
                if (i3 != 0) {
                    j3 = jCurrentTimeMillis3;
                    j = jCurrentTimeMillis2;
                    i = -1;
                    j2 = j3;
                } else if (str4.equals(SocialContentProvider.v())) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                    LogUtil.i("SyncDao", "dataObject: " + jSONObject4.toString());
                    jq5 jq5VarA = jq5.a(jSONObject4);
                    try {
                        yn0.c(jq5VarA, str4);
                        ap4.n(jSONObject4, p(mapO, jq5VarA.c, "1"));
                        ap4.i(jSONObject4, p(mapO, jq5VarA.c, "2"));
                        ap4.o(jSONObject4);
                        ap4.p(jSONObject4);
                        ap4.k(jSONObject4, p(mapO, jq5VarA.c, "4"));
                        j3 = jCurrentTimeMillis3;
                        ap4.m(jSONObject4, p(mapO, jq5VarA.c, "3"), jq5VarA.b);
                        ap4.h(jSONObject4, p(mapO, jq5VarA.c, "11"));
                        rl0.h().m(str4, jSONObject4.optJSONObject("configs"));
                        rl0.h().m(str4, jSONObject4.optJSONObject("incrConfigs"));
                        u13.b().f(jSONObject4.optJSONObject("lbsNotify"));
                        kq3.a().f(jSONObject4.optJSONObject(MediationConstant.RIT_TYPE_FEED));
                        ap4.g(mapO, jq5VarA.c);
                        ap4.b(jq5VarA);
                        int i4 = jq5VarA.f18481a;
                        fVar2.f17340a = i4;
                        fVar2.b = jq5VarA.c;
                        i = i4;
                        j = jCurrentTimeMillis2;
                        j2 = j3;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        LogUtil.log4ClientError("syncDao", e2);
                        throw e2;
                    }
                } else {
                    LogUtil.i("SyncDao", 3, new b(str4), (Throwable) null);
                    j3 = jCurrentTimeMillis3;
                    j = jCurrentTimeMillis2;
                    i = -1;
                    j2 = j3;
                }
            }
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            boolean z2 = i >= 0;
            if (AccountUtils.r(AppContext.getContext())) {
                fVar = fVar2;
                LogUtil.i("SyncDao", LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new c(jCurrentTimeMillis, jCurrentTimeMillis4, j, j2, z2), (Throwable) null);
            } else {
                fVar = fVar2;
            }
        }
        return fVar;
    }
}
