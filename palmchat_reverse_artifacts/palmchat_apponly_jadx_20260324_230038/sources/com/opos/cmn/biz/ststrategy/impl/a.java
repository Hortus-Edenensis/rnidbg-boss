package com.opos.cmn.biz.ststrategy.impl;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.opos.acs.st.STManager;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.cmn.an.c.c;
import com.opos.cmn.an.j.a;
import com.opos.cmn.an.j.b;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.DataEntity;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.biz.ststrategy.utils.d;
import com.opos.cmn.biz.ststrategy.utils.f;
import com.opos.cmn.func.a.a.d;
import com.ss.android.download.api.constant.BaseConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements com.opos.cmn.biz.ststrategy.interfaces.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7879a = "a";
    private static ConcurrentHashMap<String, AtomicBoolean> c = new ConcurrentHashMap<>();
    private static volatile com.opos.cmn.an.j.a d = null;
    private static final byte[] e = new byte[1];
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-type", "application/json");
        map.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        map.put("Connection", HTTP.CONN_KEEP_ALIVE);
        map.put("Route-Data", e.a(this.b));
        return map;
    }

    private void d() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new a.C0647a().a(1).b(1).a("cmn_strategy_single").a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context, String str) {
        boolean z = (context == null || TextUtils.isEmpty(str) || d.d(context, str) != 0) ? false : true;
        com.opos.cmn.an.f.a.b(f7879a, "isFirstSupplyReq result:" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(JSONObject jSONObject) {
        int i = -1;
        if (jSONObject != null && jSONObject.has("code") && !jSONObject.isNull("code")) {
            try {
                int i2 = jSONObject.getInt("code");
                if (i2 == 0) {
                    i = 0;
                } else if (-3 == i2) {
                    i = -3;
                }
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.c(f7879a, "", e2);
            }
        }
        String str = f7879a;
        StringBuilder sb = new StringBuilder();
        sb.append("isResponseOKByCode result ");
        sb.append(i == 0);
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return i;
    }

    private synchronized AtomicBoolean b(String str) {
        AtomicBoolean atomicBoolean;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (c.containsKey(str)) {
            atomicBoolean = c.get(str);
        } else {
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            c.put(str, atomicBoolean2);
            atomicBoolean = atomicBoolean2;
        }
        return atomicBoolean;
    }

    private boolean d(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            long jE = d.e(context, str);
            if (0 != jE) {
                if (System.currentTimeMillis() - jE < ((long) d.c(context)) * 60000) {
                    z = true;
                }
            }
            com.opos.cmn.an.f.a.b(f7879a, "isWithinDTLimitTime firstInDTLimit:" + jE + ", result :" + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onNotNeedUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(Context context, String str) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str)) {
            z = false;
        } else {
            long jD = d.d(context, str);
            if (0 != jD) {
                if (System.currentTimeMillis() - jD > ((long) d.d(context)) * 60000) {
                    z = true;
                }
            }
        }
        com.opos.cmn.an.f.a.b(f7879a, "isInBlackList :" + z + ",dataType :" + str);
        return z;
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public STConfigEntity a() {
        return com.opos.cmn.biz.ststrategy.utils.e.a(this.b);
    }

    private com.opos.cmn.func.a.a.d a(String str, String str2, boolean z) {
        try {
            return new d.a().b(str2).a(c()).a("POST").a(a(str, z)).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c(f7879a, "getSTConfigNetRequest fail", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        String str2 = f7879a;
        com.opos.cmn.an.f.a.a(str2, "update STConfigs by dataType begin======" + str);
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b(str2, "updateSTConfigsByDataType Params dataType is null");
            a(updateSTConfigListener);
            return;
        }
        AtomicBoolean atomicBooleanB = b(str);
        if (atomicBooleanB != null) {
            if (atomicBooleanB.compareAndSet(false, true)) {
                com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
                try {
                    if (a(this.b, str)) {
                        a(str, false, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.impl.a.3
                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a() {
                                a.this.a(updateSTConfigListener);
                            }

                            @Override // com.opos.cmn.biz.ststrategy.listener.a
                            public void a(com.opos.cmn.func.a.a.e eVar) {
                                JSONObject jSONObjectA = com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, eVar);
                                int iA = a.this.a(jSONObjectA);
                                if (iA == 0) {
                                    if (com.opos.cmn.biz.ststrategy.utils.e.b(a.this.b, jSONObjectA)) {
                                        a.this.b(updateSTConfigListener);
                                        return;
                                    }
                                } else if (iA == -3) {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    a aVar = a.this;
                                    if (aVar.e(aVar.b, str)) {
                                        com.opos.cmn.an.f.a.b(a.f7879a, "set first Req dataType:" + str + ",currTime=" + jCurrentTimeMillis);
                                        com.opos.cmn.biz.ststrategy.utils.d.c(a.this.b, str, jCurrentTimeMillis);
                                    }
                                    com.opos.cmn.biz.ststrategy.utils.d.d(a.this.b, str, jCurrentTimeMillis);
                                }
                                a.this.a(updateSTConfigListener);
                            }
                        });
                    } else {
                        a(updateSTConfigListener);
                    }
                } finally {
                    atomicBooleanB.set(false);
                }
            } else {
                com.opos.cmn.an.f.a.a(str2, "already update stConfig by dataType, do nothing!!!");
                c(updateSTConfigListener);
            }
        }
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType end:" + str);
    }

    private boolean b(Context context, String str) {
        STConfigEntity sTConfigEntityA;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        boolean z = (context == null || TextUtils.isEmpty(str) || (sTConfigEntityA = com.opos.cmn.biz.ststrategy.utils.e.a()) == null || (dataEntity = sTConfigEntityA.dataEntity) == null || (map = dataEntity.metaEntityMap) == null || !map.containsKey(str)) ? false : true;
        com.opos.cmn.an.f.a.b(f7879a, " dataType:" + str + " is included in strategy result:" + z);
        return z;
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public void a(final UpdateParams updateParams, final UpdateSTConfigListener updateSTConfigListener) {
        String str;
        String str2 = f7879a;
        com.opos.cmn.an.f.a.a(str2, "begin update STConfigs by PkgName======" + updateParams);
        if (updateParams == null) {
            str = "update Params is null";
        } else {
            if (!TextUtils.isEmpty(updateParams.pkgName)) {
                final AtomicBoolean atomicBooleanB = b(updateParams.pkgName);
                if (atomicBooleanB == null || !atomicBooleanB.compareAndSet(false, true)) {
                    com.opos.cmn.an.f.a.a(str2, "already update stConfig by pkgName, do nothing!!!");
                    c(updateSTConfigListener);
                    return;
                } else {
                    com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
                    b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.impl.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (a.this.a(updateParams.pkgName)) {
                                    a.this.a(updateParams.pkgName, true, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.impl.a.1.1
                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            a.this.a(updateSTConfigListener);
                                        }

                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a(com.opos.cmn.func.a.a.e eVar) {
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            com.opos.cmn.biz.ststrategy.utils.d.a(a.this.b, updateParams.pkgName, jCurrentTimeMillis);
                                            com.opos.cmn.an.f.a.b(a.f7879a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + jCurrentTimeMillis);
                                            JSONObject jSONObjectA = com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, eVar);
                                            if (a.this.a(jSONObjectA) != 0 || !com.opos.cmn.biz.ststrategy.utils.e.b(a.this.b, jSONObjectA)) {
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                a.this.a(updateSTConfigListener);
                                                return;
                                            }
                                            com.opos.cmn.biz.ststrategy.utils.d.e(a.this.b);
                                            com.opos.cmn.biz.ststrategy.utils.d.b(a.this.b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, jSONObjectA));
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            a.this.b(updateSTConfigListener);
                                        }
                                    });
                                } else {
                                    com.opos.cmn.an.f.a.a(a.f7879a, "don't need update stConfigs,no overdue");
                                    a.this.c(updateSTConfigListener);
                                }
                            } finally {
                                atomicBooleanB.set(false);
                            }
                        }
                    });
                    return;
                }
            }
            str = "update Params pkgName is null";
        }
        com.opos.cmn.an.f.a.c(str2, str);
        a(updateSTConfigListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public void a(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        d();
        com.opos.cmn.an.j.a aVar = d;
        if (aVar != null) {
            try {
                aVar.execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.impl.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(str, updateSTConfigListener);
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeSingleTask", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6 A[Catch: Exception -> 0x012c, PHI: r6 r22
      0x00c6: PHI (r6v2 boolean) = (r6v0 boolean), (r6v4 boolean) binds: [B:39:0x0120, B:27:0x00c4] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r22v3 com.opos.cmn.func.a.a.e) = (r22v2 com.opos.cmn.func.a.a.e), (r22v6 com.opos.cmn.func.a.a.e) binds: [B:39:0x0120, B:27:0x00c4] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x012c, blocks: (B:6:0x0016, B:28:0x00c6, B:44:0x0128, B:45:0x012b), top: B:53:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128 A[Catch: Exception -> 0x012c, TRY_ENTER, TryCatch #2 {Exception -> 0x012c, blocks: (B:6:0x0016, B:28:0x00c6, B:44:0x0128, B:45:0x012b), top: B:53:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, boolean z, com.opos.cmn.biz.ststrategy.listener.a aVar) throws Throwable {
        com.opos.cmn.func.a.a.e eVar;
        com.opos.cmn.func.a.a.e eVarA;
        long j;
        String str2 = f7879a;
        com.opos.cmn.an.f.a.b(str2, "request http st config start======");
        Context context = this.b;
        if (context == null || str == null) {
            return;
        }
        boolean z2 = false;
        try {
            String strA = f.a(context);
            com.opos.cmn.func.a.a.d dVarA = a(str, strA, z);
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.opos.cmn.func.a.a.e eVar2 = null;
            try {
                try {
                    eVarA = com.opos.cmn.func.a.a.b.a().a(this.b, dVarA);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                eVar = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (eVarA != null) {
                try {
                    try {
                        if (200 == eVarA.f7934a) {
                            z2 = true;
                            com.opos.cmn.an.f.a.a(str2, "update stConfig success======ParamsName=" + str);
                            if (aVar != null) {
                                aVar.a(eVarA);
                            }
                            eVar = eVarA;
                        } else {
                            if (eVarA == null) {
                                j = -2;
                            } else {
                                try {
                                    j = eVarA.f7934a;
                                } catch (Throwable th3) {
                                    th = th3;
                                    eVar2 = eVarA;
                                    if (eVar2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            long j2 = j;
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            eVar = eVarA;
                            try {
                                RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, j2, jCurrentTimeMillis2, jCurrentTimeMillis2, "6").setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                                com.opos.cmn.an.f.a.a(str2, "update stConfig failed======code=" + j2);
                            } catch (Exception e3) {
                                e = e3;
                                com.opos.cmn.an.f.a.c(f7879a, "", e);
                                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                                RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, -1L, jCurrentTimeMillis3, jCurrentTimeMillis3, "6").setExt(e.getMessage()).setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                                if (eVar != null) {
                                }
                                if (z2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        eVar = eVarA;
                        com.opos.cmn.an.f.a.c(f7879a, "", e);
                        long jCurrentTimeMillis32 = System.currentTimeMillis() - jCurrentTimeMillis;
                        RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, -1L, jCurrentTimeMillis32, jCurrentTimeMillis32, "6").setExt(e.getMessage()).setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                        if (eVar != null) {
                        }
                        if (z2) {
                        }
                    }
                    if (eVar != null) {
                        eVar.a();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    eVar2 = eVarA;
                    if (eVar2 != null) {
                        eVar2.a();
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            com.opos.cmn.an.f.a.c(f7879a, "", e5);
        }
        if (z2 || aVar == null) {
            return;
        }
        aVar.a();
    }

    private boolean a(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!b(context, str) && !c(context, str)) {
                    if (!d(context, str)) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f7879a, "", e2);
            }
        }
        com.opos.cmn.an.f.a.a(f7879a, "isLegalReq :" + z + ",dataType :" + str);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        boolean zF = com.opos.cmn.biz.ststrategy.utils.d.f(this.b);
        long jB = com.opos.cmn.biz.ststrategy.utils.d.b(this.b, str);
        long jA = com.opos.cmn.biz.ststrategy.utils.d.a(this.b);
        boolean zC = com.opos.cmn.biz.ststrategy.utils.e.c(this.b);
        boolean z = (zC && 0 != jB && System.currentTimeMillis() < (60000 * jA) + jB && f.b(this.b) && zF) ? false : true;
        com.opos.cmn.an.f.a.a(f7879a, "needUpdateStConfigs," + z + ",pkgName =" + str + zC + ",ntLimit=" + jA + ",lastTime=" + jB + ",nowTime=" + System.currentTimeMillis());
        return z;
    }

    private byte[] a(String str, boolean z) {
        String str2;
        String str3 = f7879a;
        com.opos.cmn.an.f.a.b(str3, "getReqConfigContent");
        byte[] bytes = null;
        if (this.b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(WkParams.MODEL, c.a());
            jSONObject2.put("osVersion", com.opos.cmn.an.c.d.a());
            jSONObject2.put("ptoVer", StStrategyManager.getStVerCode());
            jSONObject2.put("region", com.opos.cmn.biz.a.d.a(this.b));
            jSONObject2.put("brand", com.opos.cmn.biz.a.b.a(this.b));
            jSONObject2.put("duId", com.opos.cmn.g.a.b.b(this.b));
            jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.b));
            jSONObject2.put("anId", com.opos.cmn.an.c.e.a(this.b));
            jSONObject2.put("ouIdStatus", com.opos.cmn.g.a.b.g(this.b));
            jSONObject2.put("from", "client");
            JSONObject jSONObject3 = new JSONObject();
            if (z) {
                if (com.opos.cmn.biz.ststrategy.utils.a.c.equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.utils.a.b;
                } else if (com.opos.cmn.biz.ststrategy.utils.a.d.equals(str)) {
                    str2 = BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO;
                } else if ("com.opos.st.demo".equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.utils.a.b;
                } else {
                    jSONObject3.put("pkgName", str);
                }
                jSONObject3.put("pkgName", str2);
            } else {
                jSONObject3.put(STManager.KEY_DATA_TYPE, str);
            }
            if (!f.b(this.b) || !z) {
                jSONObject3.put("currTime", 0);
            } else if (z) {
                jSONObject3.put("currTime", com.opos.cmn.biz.ststrategy.utils.d.c(this.b, str));
            }
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
            bytes = jSONObject.toString().getBytes("UTF-8");
            com.opos.cmn.an.f.a.b(str3, "req st config content=" + jSONObject.toString());
            return bytes;
        } catch (UnsupportedEncodingException | JSONException e2) {
            com.opos.cmn.an.f.a.c(f7879a, "", e2);
            return bytes;
        }
    }
}
