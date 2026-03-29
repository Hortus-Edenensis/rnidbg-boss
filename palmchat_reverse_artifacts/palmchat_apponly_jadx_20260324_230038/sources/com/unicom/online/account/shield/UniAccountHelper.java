package com.unicom.online.account.shield;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.unicom.online.account.kernel.a;
import com.unicom.online.account.kernel.ab;
import com.unicom.online.account.kernel.ac;
import com.unicom.online.account.kernel.ad;
import com.unicom.online.account.kernel.af;
import com.unicom.online.account.kernel.b;
import com.unicom.online.account.kernel.c;
import com.unicom.online.account.kernel.e;
import com.unicom.online.account.kernel.f;
import com.unicom.online.account.kernel.p;
import com.unicom.online.account.kernel.q;
import com.unicom.online.account.kernel.r;
import com.unicom.online.account.kernel.s;
import com.unicom.online.account.kernel.u;
import com.unicom.online.account.kernel.x;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UniAccountHelper {
    private static final int ID_0_STOP_ONCE_SUCCESS = 0;
    private static final int ID_1_STOP_ALL_SEND = 1;
    private static final int LoopMaxNum = 5;
    public static final int SUCCESS = 100;
    private static volatile UniAccountHelper s_instance;
    private Context mContext = null;
    int loopNum = 0;

    /* JADX INFO: compiled from: SearchBox */
    public enum Language {
        SIMPLECHINESE(0),
        ENGLISH(1);

        private int value;

        Language(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private UniAccountHelper() {
    }

    private void cuGetTokenLoop(int i, int i2, int i3, ResultListener resultListener) {
        int i4 = this.loopNum;
        if (i4 > 1) {
            return;
        }
        this.loopNum = i > 5 ? i4 + 5 : i > 1 ? i4 + i : i4 + 1;
        culoop(this.loopNum, i2, i3, resultListener);
    }

    private void cuPreGetToken(int i, final int i2, final String str, final ResultListener resultListener) {
        String str2;
        Context context = this.mContext;
        if (context == null) {
            initFail(resultListener, "sdk未初始化");
            return;
        }
        if (!f.d(context.getApplicationContext())) {
            initFail(resultListener, "数据网络未开启");
        } else if (getUseCacheFlag()) {
            f.a();
            String strA = f.a(this.mContext, "type".concat(String.valueOf(i2)), str);
            if (c.e(strA).booleanValue()) {
                try {
                    JSONObject jSONObject = new JSONObject(strA);
                    int i3 = jSONObject.getInt("resultCode");
                    long j = jSONObject.getJSONObject("resultData").getLong(bd.b);
                    if (i3 == 100 && j > System.currentTimeMillis()) {
                        resultListener.onResult(strA);
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            f.a();
            f.e(this.mContext);
        }
        f.a();
        if (!f.a(this.mContext)) {
            str2 = "操作频繁,请稍后再试";
        } else if (!str.equals("cuPreGetToken")) {
            str2 = "sdk参数错误";
        } else {
            if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                f fVarA = f.a();
                e eVar = new e() { // from class: com.unicom.online.account.shield.UniAccountHelper.2
                    @Override // com.unicom.online.account.kernel.e
                    public void onResult(String str3) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            c.d(jSONObject2.optString("seq"));
                            if (jSONObject2.getInt("resultCode") == 100) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("resultData");
                                c.b(jSONObject3.optString("fakeMobile"));
                                c.c(jSONObject3.optString("accessCode"));
                                c.b(jSONObject3.getLong(bd.b));
                                c.a(System.currentTimeMillis());
                                String strOptString = jSONObject2.optString("operator");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    c.a(strOptString);
                                }
                                int i4 = i2;
                                if (4 == i4 || 2 == i4) {
                                    jSONObject3.put("fakeMobile", (Object) null);
                                }
                                if (UniAccountHelper.this.getUseCacheFlag()) {
                                    f.a();
                                    f.e(UniAccountHelper.this.mContext);
                                    f.a();
                                    f.a(UniAccountHelper.this.mContext, "type" + i2, str, jSONObject2.toString());
                                }
                                f.a();
                                f.b(UniAccountHelper.this.mContext);
                            } else {
                                f.a();
                                f.c(UniAccountHelper.this.mContext);
                            }
                            resultListener.onResult(jSONObject2.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                if (fVarA.f11155a == null || TextUtils.isEmpty(ac.c()) || TextUtils.isEmpty(ac.d())) {
                    f.a(eVar, "sdk未初始化");
                    return;
                }
                ad.b();
                ad.e("cuPreGetToken");
                ad.c();
                ac.a(i);
                final p pVar = new p();
                final Context context2 = fVarA.f11155a;
                q qVar = new q();
                pVar.b = qVar;
                qVar.f11168a = eVar;
                try {
                    pVar.f11163a.schedule(new Runnable() { // from class: com.unicom.online.account.kernel.p.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (p.this) {
                                q qVar2 = p.this.b;
                                if (qVar2 != null) {
                                    qVar2.a(410000, "请求超时");
                                    p pVar2 = p.this;
                                    pVar2.b = null;
                                    p.a(pVar2);
                                }
                            }
                        }
                    }, i, TimeUnit.MILLISECONDS);
                    final r rVar = new r() { // from class: com.unicom.online.account.kernel.p.2
                        @Override // com.unicom.online.account.kernel.r
                        public final void a(int i4, String str3) {
                            synchronized (p.this) {
                                if (p.this.b == null) {
                                    return;
                                }
                                if (i4 == 1) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(str3);
                                        int iOptInt = jSONObject2.optInt("code");
                                        String strOptString = jSONObject2.optString("msg");
                                        String strOptString2 = jSONObject2.optString("data");
                                        String strOptString3 = jSONObject2.optString("seq");
                                        if (iOptInt == 100) {
                                            String strA2 = ad.a();
                                            String strSubstring = strA2.substring(0, 16);
                                            String strSubstring2 = strA2.substring(16, 32);
                                            String str4 = u.f11171a ? new String(k.b(h.b(strOptString2), strSubstring.getBytes(), strSubstring2.getBytes())) : URLDecoder.decode(ad.b(strOptString2, strSubstring, strSubstring2), "UTF-8");
                                            if (TextUtils.isEmpty(str4)) {
                                                ab.a(2, "\nmsg=" + strOptString + "\ndata=" + strOptString2 + "\nseq=" + strOptString3 + "\n");
                                                p.this.b.a(410002, "数据异常", strOptString2, strOptString3);
                                            } else {
                                                ab.a(2, "\nmsg=" + strOptString + "\ncontent=" + str4 + "\nseq=" + strOptString3 + "\n");
                                                q qVar2 = p.this.b;
                                                try {
                                                    if (qVar2.f11168a != null) {
                                                        JSONObject jSONObject3 = new JSONObject();
                                                        jSONObject3.put("resultCode", 100);
                                                        jSONObject3.put("resultMsg", strOptString);
                                                        jSONObject3.put("seq", strOptString3);
                                                        if (TextUtils.isEmpty(str4)) {
                                                            jSONObject3.put("resultData", "");
                                                        } else {
                                                            jSONObject3.put("resultData", new JSONObject(str4));
                                                        }
                                                        qVar2.f11168a.onResult(jSONObject3.toString());
                                                        qVar2.f11168a = null;
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        } else {
                                            if (iOptInt == -2 && !TextUtils.isEmpty(ac.f())) {
                                                strOptString = strOptString + "apn is " + ac.f();
                                            }
                                            ab.a(2, "\nmsg=" + strOptString + "\ndata=" + strOptString2 + "\nseq=" + strOptString3 + "\n");
                                            q qVar3 = p.this.b;
                                            StringBuilder sb = new StringBuilder("code:");
                                            sb.append(iOptInt);
                                            sb.append("msg:");
                                            sb.append(strOptString);
                                            qVar3.a(410002, sb.toString(), strOptString2, strOptString3);
                                        }
                                    } catch (Exception e2) {
                                        ab.a(2, "\nresponse=" + str3 + "\n");
                                        p.this.b.a(410002, "异常" + e2.getMessage(), str3, "");
                                    }
                                } else {
                                    ab.a(2, "\nresponse=" + str3 + "\n");
                                    p.this.b.a(410002, str3);
                                }
                                p pVar2 = p.this;
                                pVar2.b = null;
                                p.a(pVar2);
                            }
                        }
                    };
                    ab.b("\n■★■★■★■★■★■★■★■★■★■\nrequestPreCheck()\n■★■★■★■★■★■★■★■★■★■\n");
                    try {
                        int iB = ad.b(context2.getApplicationContext());
                        ac.b(iB);
                        ab.b("-1=NULL; 0=流量; 1=双开; 2=WIFI; networkType = ".concat(String.valueOf(iB)));
                        if (iB == 1) {
                            final long jCurrentTimeMillis = System.currentTimeMillis();
                            x.a().a(context2, new x.a() { // from class: com.unicom.online.account.kernel.p.3
                                @Override // com.unicom.online.account.kernel.x.a
                                public final void a(boolean z, Object obj) {
                                    if (!z) {
                                        rVar.a(410003, "无法切换至数据网络");
                                        return;
                                    }
                                    ab.b("selectDataChannel:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                                    p.this.a(context2, i2, obj, rVar);
                                }
                            });
                            return;
                        } else if (iB == 0) {
                            pVar.a(context2, i2, null, rVar);
                            return;
                        } else {
                            rVar.a(410004, "数据网络未开启");
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        rVar.a(410005, "网络判断异常" + e.getMessage());
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            str2 = "sdk type 参数错误";
        }
        initFail(resultListener, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void culoop(int i, final int i2, final int i3, final ResultListener resultListener) {
        if (this.loopNum == 0) {
            return;
        }
        cuPreGetToken(i3, u.f11171a ? 3 : 5, "cuPreGetToken", new ResultListener() { // from class: com.unicom.online.account.shield.UniAccountHelper.1
            /* JADX WARN: Removed duplicated region for block: B:25:0x005a A[Catch: JSONException -> 0x0064, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0064, blocks: (B:2:0x0000, B:4:0x0008, B:8:0x0015, B:10:0x002d, B:12:0x0031, B:14:0x003b, B:15:0x003d, B:23:0x0054, B:25:0x005a, B:16:0x0041, B:18:0x0045, B:20:0x004b, B:22:0x0051, B:6:0x000e, B:7:0x0013), top: B:30:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            @Override // com.unicom.online.account.shield.ResultListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(String str) {
                ResultListener resultListener2;
                int i4;
                try {
                    UniAccountHelper uniAccountHelper = UniAccountHelper.this;
                    int i5 = uniAccountHelper.loopNum;
                    if (i5 > 5) {
                        uniAccountHelper.loopNum = 4;
                    } else if (i5 > 0) {
                        uniAccountHelper.loopNum = i5 - 1;
                    } else {
                        uniAccountHelper.loopNum = 0;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    c.d(jSONObject.optString("seq"));
                    if (jSONObject.getInt("resultCode") == 100) {
                        if (i2 == 0) {
                            UniAccountHelper.this.loopNum = 0;
                            resultListener.onResult(str);
                            return;
                        }
                        resultListener2 = resultListener;
                    } else {
                        if (i2 == 0) {
                            if (UniAccountHelper.this.loopNum == 0) {
                                resultListener.onResult(str);
                                return;
                            }
                            UniAccountHelper uniAccountHelper2 = UniAccountHelper.this;
                            i4 = uniAccountHelper2.loopNum;
                            if (i4 <= 0) {
                                uniAccountHelper2.culoop(i4, i2, i3, resultListener);
                                return;
                            }
                            return;
                        }
                        resultListener2 = resultListener;
                    }
                    resultListener2.onResult(str);
                    UniAccountHelper uniAccountHelper22 = UniAccountHelper.this;
                    i4 = uniAccountHelper22.loopNum;
                    if (i4 <= 0) {
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static String getCertFingerType() {
        return u.d;
    }

    private String getHostName() {
        f.a();
        return f.e();
    }

    public static UniAccountHelper getInstance() {
        if (s_instance == null) {
            synchronized (UniAccountHelper.class) {
                if (s_instance == null) {
                    s_instance = new UniAccountHelper();
                }
            }
        }
        return s_instance;
    }

    private void initFail(ResultListener resultListener, String str) {
        b.a(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 410021);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            this.loopNum = 0;
            if (resultListener != null) {
                resultListener.onResult(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendFail(ResultListener resultListener, int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", "");
            jSONObject.put("seq", "");
            jSONObject.put("operatorType", c.a());
            resultListener.onResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UniAccountHelper clearCache() {
        c.b();
        f.a();
        f.e(this.mContext);
        return s_instance;
    }

    public String cuDebugInfo(String str) {
        if (this.mContext == null) {
            return "sdk 未初始化, context 为空";
        }
        f fVarA = f.a();
        if (fVarA.f11155a == null) {
            return "sdk 未初始化, context 为空";
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "sha256":
            case "md5":
            case "sha1":
                Context context = fVarA.f11155a;
                break;
            case "sm3":
                Context context2 = fVarA.f11155a;
                break;
        }
        return "sdk 未初始化, context 为空";
    }

    public void cuGetToken(int i, ResultListener resultListener) {
        cuPreGetToken(i, u.f11171a ? 3 : 5, "cuPreGetToken", resultListener);
    }

    public void cuMobileAuth(int i, ResultListener resultListener) {
        cuPreGetToken(i, u.f11171a ? 2 : 4, "cuPreGetToken", resultListener);
    }

    public String getSdkVersion() {
        f.a();
        return f.b();
    }

    public boolean getUseCacheFlag() {
        return u.c;
    }

    public UniAccountHelper init(Context context, String str) {
        return init(context, str, false);
    }

    public UniAccountHelper initHostName(String str) {
        f.a();
        if (f.a(str)) {
            return s_instance;
        }
        b.a("初始化参数错误");
        return null;
    }

    public void releaseNetwork() {
        f.a();
        f.h();
    }

    public UniAccountHelper setCertFingerType(String str) {
        if (!str.equalsIgnoreCase("MD5") && !str.equalsIgnoreCase("SHA1") && !str.equalsIgnoreCase("SHA256") && !str.equalsIgnoreCase("sm3")) {
            return null;
        }
        u.d = str.toLowerCase();
        return s_instance;
    }

    public UniAccountHelper setCryptoGM(boolean z) {
        u.f11171a = z;
        return s_instance;
    }

    public void setDefaultLanguage(Language language) {
        c.b = language;
    }

    public void setLogEnable(boolean z) {
        b.a(z);
        f.a();
        f.a(z);
    }

    public UniAccountHelper setUseCacheFlag(boolean z) {
        u.c = z;
        return s_instance;
    }

    public void cuGetTokenLoop(int i, int i2, ResultListener resultListener) {
        cuGetTokenLoop(i, 0, i2, resultListener);
    }

    public UniAccountHelper init(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            b.a("初始化参数不能为空");
            return null;
        }
        if (this.mContext != null) {
            b.a("重复初始化");
            return null;
        }
        this.mContext = context.getApplicationContext();
        a.a(context);
        final f fVarA = f.a();
        ad.b();
        ad.e("cuPreGetToken");
        ad.c();
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                ab.d("初始化参数不能为空");
            } else if (TextUtils.isEmpty(ac.c())) {
                u.b = true;
                u.f11171a = z;
                u.c = true;
                if (u.f11171a) {
                    ab.b(" MyApplication.enableGuoMi  ");
                }
                fVarA.f11155a = context.getApplicationContext();
                ac.b(str);
                ac.c(str);
                ac.f(ad.c(fVarA.f11155a));
                Context context2 = fVarA.f11155a;
                String strA = af.a(context2, "auth02");
                if (TextUtils.isEmpty(strA)) {
                    strA = ad.b(UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis());
                    af.a(context2, "auth02", strA);
                }
                ac.g(strA);
                ac.e();
                ab.b("backupIp=" + ac.f11151a);
                s.f11169a = false;
                s.b = false;
                fVarA.b.submit(new Runnable() { // from class: com.unicom.online.account.kernel.f.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            InetAddress[] allByName = InetAddress.getAllByName(f.e());
                            if (allByName == null || allByName.length <= 0) {
                                s.f11169a = false;
                                return;
                            }
                            ac.f11151a = allByName[f.a(allByName.length)].getHostAddress();
                            af.a(f.this.f11155a, "auth400", h.a(ac.f11151a.getBytes()));
                            s.f11169a = true;
                        } catch (Exception e) {
                            s.b = false;
                            s.f11169a = false;
                            f.g();
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                ab.d("不可重复初始化");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.f11154a = str;
        return s_instance;
    }
}
