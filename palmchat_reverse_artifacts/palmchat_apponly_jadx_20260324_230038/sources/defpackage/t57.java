package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cdadata.cdazmm.cdazma;
import cdadata.cdazmm.cdazmc;
import com.cdadata.sdk.api.ZMConfigOptions;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.cdadata.sdk.api.protobuf.event.CDAEventResponseOuterClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class t57 {
    public static List<String> e = new ArrayList();
    public static final Map<Context, t57> f = new HashMap();
    public final Context b;
    public final ZMConfigOptions d;
    public final c57 c = c57.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20908a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f20909a = new Object();
        public final Handler b;

        /* JADX INFO: renamed from: t57$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class HandlerC1275a extends Handler {
            public HandlerC1275a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws Throwable {
                try {
                    int i = message.what;
                    if (i == 3) {
                        t57.b(t57.this, true);
                        return;
                    }
                    if (i == 4) {
                        try {
                            c57 c57Var = t57.this.c;
                            c57Var.b.c(c57Var.f1896a.f19698a, "DB_DELETE_ALL");
                            return;
                        } catch (Exception e) {
                            g57.a(e);
                            return;
                        }
                    }
                    if (i == 5) {
                        g57.b("CDAEventWorker", "flushTime：" + t57.this.d.flushTime);
                        if (p67.a()) {
                            ZMDataSDKManager.getInstance().getZMDataActivityLifecycleCallbacks().f("AppScreenOn", false);
                        }
                        t57.this.c();
                        t57.b(t57.this, true);
                        t57.b(t57.this, false);
                    }
                } catch (RuntimeException e2) {
                    g57.d("CDAEventWorker", e2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }

        public a() {
            HandlerThread handlerThread = new HandlerThread("CDAEventWorker", -1);
            handlerThread.start();
            this.b = new HandlerC1275a(handlerThread.getLooper());
        }

        public void a(Message message, long j) {
            synchronized (this.f20909a) {
                Handler handler = this.b;
                if (handler != null && !handler.hasMessages(message.what)) {
                    this.b.sendMessageDelayed(message, j);
                }
            }
        }
    }

    public t57(Context context, ZMConfigOptions zMConfigOptions) {
        this.b = context;
        this.d = zMConfigOptions;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02be A[PHI: r0
      0x02be: PHI (r0v28 java.lang.String) = (r0v27 java.lang.String), (r0v31 java.lang.String) binds: [B:113:0x0255, B:139:0x02bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(t57 t57Var, boolean z) throws Throwable {
        boolean z2;
        String[] strArrE;
        boolean z3;
        String str;
        String str2;
        int i;
        byte[] bArrB;
        boolean z4;
        String str3;
        CDAEventResponseOuterClass.CDAEventResponse from;
        String[] strArrE2;
        t57Var.getClass();
        try {
            g57.b("CDAEventWorker", "sendData：" + z);
            if (TextUtils.isEmpty(t57Var.d.reportUrl)) {
                g57.b("CDAEventWorker", "URL is null");
                return;
            }
            if (e67.w(t57Var.b)) {
                String strX = e67.x(t57Var.b);
                int i2 = t57Var.d.uploadNetWorkType;
                char c = 0;
                int i3 = 1;
                if (!(i2 == 3 || (e67.p(strX) == 1 && i2 == 1) || (e67.p(strX) == 2 && i2 == 2))) {
                    g57.b("CDAEventWorker", String.format("Invalid NetworkType = %s", strX));
                    return;
                }
                c57 c57VarL = c57.l();
                c57VarL.getClass();
                try {
                    strArrE2 = c57VarL.c.e(o57.a().g, 1, true);
                } catch (Exception e2) {
                    g57.a(e2);
                }
                if (strArrE2 == null || strArrE2.length <= 0) {
                    z2 = true;
                } else if (Integer.parseInt(strArrE2[0]) != 1) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
                c57.l().g(true);
                int iC = 1;
                while (iC > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    synchronized (t57Var.c) {
                        c57 c57Var = t57Var.c;
                        c57Var.getClass();
                        try {
                            strArrE = c57Var.b.e(c57Var.f1896a.f19698a, 100, z);
                        } catch (Exception e3) {
                            g57.a(e3);
                            strArrE = null;
                        }
                        List<String> list = e;
                        if (list == null || list.size() <= 0 || strArrE == null) {
                            z3 = false;
                        } else {
                            try {
                                int i4 = Integer.parseInt(strArrE[c].split(",")[c]);
                                List<String> list2 = e;
                                if (i4 >= Integer.parseInt(list2.get(list2.size() - i3))) {
                                    e.clear();
                                }
                            } catch (NumberFormatException unused) {
                            }
                            z3 = false;
                            for (String str4 : e) {
                                String[] strArrSplit = strArrE[c].split(",");
                                int length = strArrSplit.length;
                                int i5 = 0;
                                while (i5 < length) {
                                    if (strArrSplit[i5].equals(str4)) {
                                        t57Var.c.c(new String[]{str4}, z);
                                        z3 = true;
                                    }
                                    i5++;
                                    c = 0;
                                }
                            }
                        }
                        if (z3) {
                            c57 c57Var2 = t57Var.c;
                            c57Var2.getClass();
                            try {
                                strArrE = c57Var2.b.e(c57Var2.f1896a.f19698a, 100, z);
                            } catch (Exception e4) {
                                g57.a(e4);
                                strArrE = null;
                            }
                        }
                    }
                    if (strArrE == null) {
                        break;
                    }
                    g57.b("本地数据耗时", (System.currentTimeMillis() - jCurrentTimeMillis2) + "======" + e.size());
                    String str5 = strArrE[0];
                    int i6 = 1;
                    String str6 = strArrE[1];
                    g57.b("CDAEventWorker", str5);
                    try {
                        try {
                            try {
                                bArrB = i67.a().b(e67.n(new JSONArray(str6)));
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (cdazmc e5) {
                            e = e5;
                            i = 1;
                        }
                    } catch (cdazma e6) {
                        str2 = "Connection error: " + e6.getMessage();
                        if (!TextUtils.isEmpty(str2)) {
                            g57.b("CDAEventWorker", str2);
                        }
                    } catch (Exception e7) {
                        try {
                            str2 = "Exception: " + e7.getMessage();
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = null;
                            i6 = 0;
                            if (!TextUtils.isEmpty(str)) {
                                g57.b("CDAEventWorker", str);
                            }
                            if (i6 != 0) {
                                t57Var.c.c(str5.split(","), z);
                            }
                            throw th;
                        }
                    }
                    if (bArrB == null || bArrB.length <= 0) {
                        z4 = true;
                        str3 = null;
                        if (!TextUtils.isEmpty(str3)) {
                            g57.b("CDAEventWorker", str3);
                        }
                        iC = z4 ? t57Var.c.c(str5.split(","), z) : 0;
                    } else {
                        try {
                            from = CDAEventResponseOuterClass.CDAEventResponse.parseFrom(h67.b(ZMDataSDKManager.getInstance().zmConfigOptions.reportUrl, bArrB));
                            g57.b("CDAEventWorker", "CDAEventResponse>>>>>>>>" + from.getCode() + "=====" + from.getMessage());
                        } catch (Exception unused2) {
                            try {
                                g57.b("CDAEventWorker", "report fial==" + str6);
                                z4 = false;
                            } catch (cdazmc e8) {
                                e = e8;
                                i = 0;
                                try {
                                    i = e.cdazma;
                                    boolean z5 = (i == 404 || i == 403 || (i >= 500 && i < 600)) ? false : true;
                                    String str7 = "ResponseErrorException: " + e.getMessage();
                                    if (!TextUtils.isEmpty(str7)) {
                                        g57.b("CDAEventWorker", str7);
                                    }
                                    if (z5) {
                                        iC = t57Var.c.c(str5.split(","), z);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    i6 = i;
                                    str = null;
                                    if (!TextUtils.isEmpty(str)) {
                                    }
                                    if (i6 != 0) {
                                    }
                                    throw th;
                                }
                            }
                        }
                        if ("200".equals(from.getCode())) {
                            e.addAll(Arrays.asList(str5.split(",")));
                            z4 = true;
                            str3 = null;
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            if (z4) {
                            }
                        } else {
                            try {
                                str3 = "upload server fail: " + str5;
                                z4 = false;
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                if (z4) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                i6 = 0;
                                str = null;
                                if (!TextUtils.isEmpty(str)) {
                                }
                                if (i6 != 0) {
                                }
                                throw th;
                            }
                        }
                    }
                    g57.b("上报数据耗时", (System.currentTimeMillis() - jCurrentTimeMillis) + "");
                    c = 0;
                    i3 = 1;
                }
                c57.l().g(false);
            }
        } catch (Exception e9) {
            g57.a(e9);
        }
    }

    public void a() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            a aVar = this.f20908a;
            synchronized (aVar.f20909a) {
                Handler handler = aVar.b;
                if (handler != null) {
                    handler.sendMessage(messageObtain);
                }
            }
        } catch (Exception e2) {
            g57.a(e2);
        }
    }

    public void c() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            this.f20908a.a(messageObtain, this.d.flushTime);
        } catch (Exception e2) {
            g57.a(e2);
        }
    }
}
