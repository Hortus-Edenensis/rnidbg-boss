package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static x jk;
    private static String u;
    private static AtomicBoolean nr = new AtomicBoolean(false);
    private static final AtomicBoolean fx = new AtomicBoolean(false);
    private static String b = "";
    private static long pn = 0;
    private static int iz = 0;
    private static nr x = null;
    private static volatile DisplayManager.DisplayListener n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5166a = false;

    public static boolean b() {
        x xVar = jk;
        if (xVar != null) {
            return xVar.fx();
        }
        return false;
    }

    public static Context fx() {
        x xVar = jk;
        if (xVar != null) {
            return xVar.u();
        }
        return null;
    }

    public static n iz() {
        x xVar = jk;
        if (xVar != null) {
            return xVar.b();
        }
        return null;
    }

    public static int n() {
        return iz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Handler handler) {
        if (!a.nr() || f5166a || fx() == null) {
            return;
        }
        f5166a = true;
        if (n == null) {
            n = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.iz.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            iz.u(1003, new Object[]{Integer.valueOf(i), iz.fx()});
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            iz.u(1005, new Object[]{Integer.valueOf(i), iz.fx()});
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            iz.u(1004, new Object[]{Integer.valueOf(i), iz.fx()});
                        } catch (Throwable unused) {
                        }
                    }
                }
            };
        }
        ((DisplayManager) fx().getSystemService("display")).registerDisplayListener(n, handler);
    }

    public static String pn() {
        x xVar = jk;
        if (xVar != null) {
            return xVar.nr();
        }
        return null;
    }

    public static long x() {
        return pn;
    }

    public static void u(x xVar) {
        jk = xVar;
    }

    public static void u() {
        try {
            Context contextFx = fx();
            if (!b() || fx.getAndSet(true) || contextFx == null) {
                return;
            }
            if (x != null) {
                nr.u((Application) contextFx).nr((Application) contextFx);
                x = null;
            }
            if (n != null) {
                ((DisplayManager) contextFx.getSystemService("display")).unregisterDisplayListener(n);
                f5166a = false;
                n = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String nr(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            b = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            b = "eyJzdHRzIjozfQ==";
        }
        return b;
    }

    public static String nr() {
        if (u == null) {
            Object objU = u(1011, new Object[0]);
            if (objU instanceof String) {
                u = (String) objU;
            }
        }
        String str = u;
        return str != null ? str : "";
    }

    public static String u(final boolean z) {
        if (a.nr() && jk != null) {
            final Handler handlerU = com.bytedance.sdk.component.utils.jk.u();
            final n nVarIz = iz();
            handlerU.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObjectT;
                    try {
                        if (!iz.fx.get()) {
                            nr unused = iz.x = nr.u((Application) iz.jk.u());
                            iz.nr(handlerU);
                        }
                        pn.u(iz.jk.u());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object objU = iz.u(1001, new Object[]{iz.jk.u(), Boolean.valueOf(z)});
                        if (objU instanceof String) {
                            String unused2 = iz.b = (String) objU;
                        }
                    } catch (Throwable th) {
                        String unused3 = iz.b = iz.nr(th);
                    }
                    if (nVarIz != null && !iz.nr.getAndSet(true)) {
                        JSONObject jSONObjectU = com.bytedance.sdk.component.panglearmor.u.u.u().u(iz.jk.u(), iz.jk.nr());
                        if (jSONObjectU != null && jSONObjectU.length() > 0) {
                            nVarIz.u("detailed_app_info", jSONObjectU);
                        }
                        iz.nr.set(false);
                    }
                    if (nVarIz == null || (jSONObjectT = SoftDecTool.t()) == null || jSONObjectT.length() <= 0) {
                        return;
                    }
                    nVarIz.u("tc_info", jSONObjectT);
                }
            });
        }
        if (TextUtils.isEmpty(b)) {
            String strGc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc)) {
                b = strGc;
            }
        }
        return TextUtils.isEmpty(b) ? "eyJzdHRzIjoxfQ==" : b;
    }

    public static Object u(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    public static void u(final MotionEvent motionEvent) {
        if (motionEvent == null || !a.nr() || fx() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.iz.3
                @Override // java.lang.Runnable
                public void run() {
                    iz.u(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), iz.fx()});
                }
            });
        }
    }

    public static void u(long j, int i) {
        pn = j;
        iz = i;
    }

    public static String u(String str, long j, int i, boolean z) {
        try {
            nr nrVar = x;
            if (nrVar != null) {
                return nrVar.u(str, j, i, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u(String str, String str2) {
        Object objU = u(1010, new String[]{str, str2});
        return objU instanceof String ? (String) objU : str2;
    }
}
