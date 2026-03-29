package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static volatile fx u;
    private final ArrayList<String> nr = new ArrayList<>();
    private final AtomicBoolean fx = new AtomicBoolean(false);
    private long b = System.currentTimeMillis();
    private long pn = 0;
    private long iz = 0;
    private String x = "";
    private String n = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5165a = "";
    private boolean jk = false;
    private boolean t = false;

    public static fx u(Application application) {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    fx fxVar = new fx();
                    u = fxVar;
                    fxVar.jk = jk.u(application);
                    u.t = jk.u(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    u.u();
                }
            }
        }
        return u;
    }

    public void nr(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.nr.contains(localClassName)) {
            this.nr.remove(localClassName);
        }
        if (this.nr.size() == 0) {
            this.b = System.currentTimeMillis();
            this.fx.set(true);
            this.n = localClassName;
        }
    }

    public void u(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.nr.size() == 0) {
            this.x = localClassName;
            this.pn = System.currentTimeMillis();
            this.iz = System.currentTimeMillis() - this.b;
            this.fx.set(false);
        }
        if (!this.nr.contains(localClassName)) {
            this.nr.add(localClassName);
        }
        this.f5165a = localClassName;
    }

    private void u() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.nr.contains(localClassName)) {
                            this.nr.add(localClassName);
                        }
                    }
                }
                this.fx.set(this.nr.size() <= 0);
            }
        } catch (Exception unused) {
        }
    }

    public String u(String str, long j, int i, boolean z) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.pn;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.fx.get() && this.t) {
            i2 |= 2;
        }
        if (!this.fx.get() && this.iz >= 5000 && j2 < 1000) {
            i2 = this.n.equals(this.f5165a) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.iz).put("popt", j2).put("uct", j3).put("isbak", this.fx).put("alert", this.t).put("rit", i).put("tag", str).put(NotificationCompat.CATEGORY_SYSTEM, this.jk).put("size", this.nr.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.x = "";
        this.iz = 0L;
        this.pn = 0L;
        this.b = System.currentTimeMillis();
        return string;
    }
}
