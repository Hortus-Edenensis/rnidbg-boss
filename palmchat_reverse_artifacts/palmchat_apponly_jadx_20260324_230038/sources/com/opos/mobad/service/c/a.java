package com.opos.mobad.service.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.idmapping.IdMappingSdk;
import com.opos.cmn.ac.AcTools;
import com.opos.cmn.an.j.b;
import com.opos.cmn.i.a;
import com.opos.mobad.ad.e;
import com.opos.mobad.provider.openId.IdModelIdentify;
import com.opos.mobad.provider.openId.OpenIdData;
import defpackage.g23;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f9199a;
    private volatile com.opos.mobad.provider.openId.a b;
    private Context c;
    private com.opos.cmn.i.a i;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private int h = 0;
    private boolean j = true;
    private boolean k = true;
    private String l = "";
    private volatile String m = "";
    private volatile boolean n = false;
    private volatile C0768a o = null;
    private AtomicReference<OpenIdData> p = new AtomicReference<>(null);
    private String q = "";

    /* JADX INFO: renamed from: com.opos.mobad.service.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0768a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9210a;
        public final int b = 1;

        public C0768a(String str) {
            this.f9210a = str;
        }

        public static C0768a a(e eVar) {
            String strB = b(eVar);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            return new C0768a(strB);
        }

        private static String b(e eVar) {
            String str;
            if (eVar == null) {
                return null;
            }
            String devImei = eVar.getDevImei();
            com.opos.cmn.an.f.a.b("IdentityIdManager", "parse dev id origin:" + devImei);
            if (TextUtils.isEmpty(devImei)) {
                str = "isNum id null";
            } else {
                String strTrim = devImei.trim();
                if (strTrim.length() >= 15 && strTrim.length() <= 17) {
                    if (a(strTrim)) {
                        return strTrim;
                    }
                    return null;
                }
                str = "isNum id over max";
            }
            com.opos.cmn.an.f.a.b("IdentityIdManager", str);
            return null;
        }

        private static final boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "isNum id null");
                return false;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                try {
                    if (!Character.isDigit(charArray[i])) {
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "parse dev id invalid ");
                        return false;
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("IdentityIdManager", "parse dev error", (Throwable) e);
                    return false;
                }
            }
            return true;
        }
    }

    private a() {
    }

    public static boolean o() {
        String str = Build.BRAND;
        try {
            if (com.opos.cmn.biz.a.a.c.equalsIgnoreCase(str) || com.opos.cmn.biz.a.a.f7817a.equalsIgnoreCase(str)) {
                return true;
            }
            return com.opos.cmn.biz.a.a.b.equalsIgnoreCase(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "isOwnBrand error", e);
            return false;
        }
    }

    private void p() {
        b.c(new Runnable() { // from class: com.opos.mobad.service.c.a.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IdMappingSdk.init(a.this.c, new com.heytap.mspsdk.listener.a() { // from class: com.opos.mobad.service.c.a.2.1
                        @Override // com.heytap.mspsdk.listener.a
                        public void onResult(com.heytap.mspsdk.listener.b bVar) {
                            if (bVar != null && bVar.a() == 0) {
                                a.this.q();
                                return;
                            }
                            com.opos.cmn.an.f.a.d("IdentityIdManager", "Failed to initialize ID-Mapping SDK: " + bVar.toString());
                        }
                    }, true);
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "init IDMapping SDK");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("IdentityIdManager", "Error initializing ID-Mapping SDK", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            IdMappingSdk.getVersionCode(com.heytap.mspsdk.core.e.a().b(), new com.heytap.mspsdk.listener.a() { // from class: com.opos.mobad.service.c.a.3
                @Override // com.heytap.mspsdk.listener.a
                public void onResult(com.heytap.mspsdk.listener.b bVar) {
                    if (bVar == null || bVar.a() != 0) {
                        com.opos.cmn.an.f.a.d("IdentityIdManager", "Failed to get version code: " + bVar.toString());
                        return;
                    }
                    String str = bVar.b().get(Constants.KIT_VERSION_CODE);
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        int i = Integer.parseInt(str);
                        if (i >= 100) {
                            a.this.r();
                        } else {
                            com.opos.cmn.an.f.a.d("IdentityIdManager", "ID-Mapping SDK version too low: " + i);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.d("IdentityIdManager", "Failed to parse version code: " + str, e);
                    }
                }
            }, true);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("IdentityIdManager", "Error getVersionCode ID-Mapping SDK", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        HashMap map = new HashMap();
        map.put("type", "ouid_mapping");
        IdMappingSdk.getData(com.heytap.mspsdk.core.e.a().b(), map, new com.heytap.mspsdk.listener.a() { // from class: com.opos.mobad.service.c.a.4
            @Override // com.heytap.mspsdk.listener.a
            public void onResult(com.heytap.mspsdk.listener.b bVar) {
                if (bVar == null || bVar.a() != 0) {
                    com.opos.cmn.an.f.a.d("IdentityIdManager", "Failed to get ID-Mapping data: " + bVar.toString());
                    return;
                }
                HashMap<String, String> mapB = bVar.b();
                if (mapB != null) {
                    String str = mapB.get("ouid_mapping");
                    if (TextUtils.isEmpty(str)) {
                        com.opos.cmn.an.f.a.c("IdentityIdManager", "ouid mapping is empty");
                        return;
                    }
                    a.this.q = str;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "IdMapping data obtained: " + str);
                }
            }
        }, true);
        com.opos.cmn.an.f.a.b("IdentityIdManager", "IDMapping getData");
    }

    private void s() {
        if (TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e) && this.c != null) {
            this.i.a();
        }
    }

    private void t() {
        Context context = this.c;
        if (context == null) {
            return;
        }
        if (com.opos.cmn.g.a.b.e(context)) {
            b.c(new Runnable() { // from class: com.opos.mobad.service.c.a.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar = a.this;
                        aVar.j = aVar.a(aVar.c).b();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "update status error" + e);
                    }
                }
            });
        } else {
            this.j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OpenIdData u() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (o()) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but own brand");
                if (!a(this.c).d()) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but not support");
                    return null;
                }
                CountDownLatch countDownLatch = new CountDownLatch(2);
                a(countDownLatch);
                try {
                    countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                }
            } else {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId but other brand");
                if (!a(this.c).e()) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "getOutOpenId but not support");
                    return null;
                }
                CountDownLatch countDownLatch2 = new CountDownLatch(2);
                b(countDownLatch2);
                try {
                    countDownLatch2.await(3000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    e = e2;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                }
            }
            OpenIdData openIdData = this.p.get();
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId cost time = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",getOpenIdData" + openIdData);
            return openIdData;
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId error", e3);
            com.opos.mobad.provider.openId.b.f9167a.a(-30090);
            return null;
        }
    }

    public int c() {
        return com.opos.mobad.provider.openId.b.f9167a.a();
    }

    public String d() {
        return AcTools.isSoEnabled() ? AcTools.getBootMark() : "";
    }

    public String e() {
        return AcTools.isSoEnabled() ? AcTools.getUpdateMark() : "";
    }

    public boolean f() {
        return this.k;
    }

    public String g() {
        if (this.n) {
            return "";
        }
        String strA = this.m;
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        Context context = this.c;
        if (context == null) {
            return "";
        }
        try {
            strA = com.opos.cmn.an.c.e.a(context);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("IdentityIdManager", "", th);
        }
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        this.m = strA;
        return strA;
    }

    public String h() {
        s();
        return this.d;
    }

    public String i() {
        s();
        return this.e;
    }

    public String j() {
        s();
        return this.f;
    }

    public String k() {
        s();
        return this.g;
    }

    public boolean l() {
        t();
        return this.j;
    }

    public C0768a m() {
        return this.o;
    }

    public String n() {
        if (!TextUtils.isEmpty(this.d) || !TextUtils.isEmpty(this.e) || this.c == null) {
            return this.d;
        }
        u();
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.provider.openId.a a(Context context) {
        com.opos.mobad.provider.openId.a aVar = this.b;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = this.b;
                if (aVar == null) {
                    aVar = new com.opos.mobad.provider.openId.a(context.getApplicationContext(), new IdModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
                    this.b = aVar;
                }
            }
        }
        return aVar;
    }

    public String b() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[Catch: all -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004a, blocks: (B:17:0x0039, B:25:0x0047), top: B:37:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://mk_ex");
        if (Build.VERSION.SDK_INT > 26) {
            ContentProviderClient contentProviderClient = null;
            try {
                try {
                    contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            try {
                                String string = contentProviderClientAcquireUnstableContentProviderClient.call("query_vaid", null, null).getString("vaid_result");
                                try {
                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                } catch (Throwable unused) {
                                }
                                return string;
                            } catch (Exception e) {
                                try {
                                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                    }
                                } catch (Exception unused2) {
                                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                                    if (contentProviderClient != null) {
                                        contentProviderClient.release();
                                    }
                                    return "";
                                }
                                return "";
                            }
                        } catch (Throwable th) {
                            th = th;
                            contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                            if (contentProviderClient != null) {
                                try {
                                    contentProviderClient.release();
                                } catch (Throwable unused3) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable unused4) {
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
        }
        return "";
    }

    public static a a() {
        a aVar = f9199a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f9199a;
                if (aVar == null) {
                    aVar = new a();
                    f9199a = aVar;
                }
            }
        }
        return aVar;
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    private void b(CountDownLatch countDownLatch) {
        a(new Callable<OpenIdData>() { // from class: com.opos.mobad.service.c.a.7
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OpenIdData call() {
                try {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "real out call");
                    a aVar = a.this;
                    return aVar.a(aVar.c).c();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "readOuterOpenId fail", e);
                    com.opos.mobad.provider.openId.b.f9167a.a(-30091);
                    return null;
                }
            }
        }, countDownLatch);
    }

    public void a(Context context, boolean z, e eVar) {
        this.c = context.getApplicationContext();
        this.n = z;
        this.o = C0768a.a(eVar);
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.c.a.1
            @Override // com.opos.cmn.i.a.b
            public void a(final a.InterfaceC0673a interfaceC0673a) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "init");
                b.c(new Runnable() { // from class: com.opos.mobad.service.c.a.1.1
                    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0002, B:5:0x0014, B:8:0x0027, B:16:0x004a, B:18:0x005c, B:19:0x0063, B:9:0x002e, B:11:0x0038, B:13:0x0041, B:15:0x0045), top: B:24:0x0002 }] */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0002, B:5:0x0014, B:8:0x0027, B:16:0x004a, B:18:0x005c, B:19:0x0063, B:9:0x002e, B:11:0x0038, B:13:0x0041, B:15:0x0045), top: B:24:0x0002 }] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() throws Throwable {
                        try {
                            a aVar = a.this;
                            if (!aVar.a(aVar.c).d()) {
                                a aVar2 = a.this;
                                if (!aVar2.a(aVar2.c).e()) {
                                    com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                                } else {
                                    if (a.this.u() != null) {
                                        com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                        a.InterfaceC0673a interfaceC0673a2 = interfaceC0673a;
                                        if (interfaceC0673a2 != null) {
                                            interfaceC0673a2.b();
                                            return;
                                        }
                                        return;
                                    }
                                    com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                                }
                            } else if (a.this.u() != null) {
                            }
                            a aVar3 = a.this;
                            String strB = aVar3.b(aVar3.c);
                            if (!TextUtils.isEmpty(strB)) {
                                a.this.g = strB;
                            }
                            a.this.d();
                            a.this.e();
                            interfaceC0673a.a();
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e);
                            interfaceC0673a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        s();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OpenIdData openIdData) {
        if (openIdData != null && g23.a(this.p, null, openIdData)) {
            this.d = a(openIdData.f9166a);
            this.e = a(openIdData.b);
            this.f = a(openIdData.c);
        }
    }

    private void a(final Callable<OpenIdData> callable, final CountDownLatch countDownLatch) {
        b.c(new Runnable() { // from class: com.opos.mobad.service.c.a.8
            @Override // java.lang.Runnable
            public void run() {
                OpenIdData openIdData;
                Exception e;
                try {
                    openIdData = (OpenIdData) callable.call();
                } catch (Exception e2) {
                    openIdData = null;
                    e = e2;
                }
                try {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "real call:" + callable + "," + openIdData);
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                }
                if (openIdData != null) {
                    a.this.a(openIdData);
                    countDownLatch.countDown();
                }
                countDownLatch.countDown();
            }
        });
    }

    private void a(CountDownLatch countDownLatch) {
        a(new Callable<OpenIdData>() { // from class: com.opos.mobad.service.c.a.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OpenIdData call() {
                try {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "real op call");
                    a aVar = a.this;
                    return aVar.a(aVar.c).a();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("IdentityIdManager", "", e);
                    return null;
                }
            }
        }, countDownLatch);
    }

    public void a(boolean z) {
        this.k = z;
        com.opos.cmn.an.f.a.b("IdentityIdManager", "app status:" + this.k);
    }
}
