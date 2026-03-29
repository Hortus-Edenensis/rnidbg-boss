package defpackage;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.messaging.MessagingService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t4 {
    public static t4 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f20896a;
    public MessagingService b;
    public HandlerThread c;
    public Handler d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            t4.this.f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t4.this.f();
        }
    }

    public t4() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f20896a = concurrentHashMap;
        e(concurrentHashMap);
    }

    public static t4 b() {
        if (e == null) {
            synchronized (t4.class) {
                if (e == null) {
                    e = new t4();
                }
            }
        }
        return e;
    }

    public String c(String str) {
        return this.f20896a.get(str);
    }

    public void d(MessagingService messagingService) {
        this.b = messagingService;
        HandlerThread handlerThreadA = lg2.a("account_cache_working_thread");
        this.c = handlerThreadA;
        handlerThreadA.start();
        this.d = new Handler(this.c.getLooper());
        try {
            if (AppContext.getContext().getContentResolver() == null) {
                return;
            } else {
                AppContext.getContext().getContentResolver().registerContentObserver(a5.f1152a, true, new a(this.d));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!this.f20896a.containsKey(DeviceInfoUtil.UID_TAG) || AppContext.getContext().getContentResolver() == null) {
            return;
        }
        this.d.post(new b());
    }

    public final void e(Map<String, String> map) {
        if (AppContext.getContext() == null) {
            return;
        }
        String strE = AppContext.getContext().getTrayPreferences().e("current_uid", "");
        if (!TextUtils.isEmpty(strE)) {
            map.put(DeviceInfoUtil.UID_TAG, strE);
        }
        String strE2 = AppContext.getContext().getTrayPreferences().e("current_exid", "");
        if (TextUtils.isEmpty(strE2)) {
            return;
        }
        map.put(bd.h, strE2);
    }

    public final void f() {
        HashMap map = new HashMap();
        e(map);
        try {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(a5.f1152a, null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int columnCount = cursorQuery.getColumnCount();
                    for (int i = 0; i < columnCount; i++) {
                        String string = cursorQuery.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            String columnName = cursorQuery.getColumnName(i);
                            if (columnName != null && columnName.equals("mobile")) {
                                string = yh4.a(string);
                            }
                            map.put(columnName, string);
                        }
                    }
                }
                cursorQuery.close();
            }
            this.f20896a.clear();
            this.f20896a.putAll(map);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f20896a.put(bd.h, str);
            AppContext.getContext().getTrayPreferences().h("current_exid", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f20896a.put(DeviceInfoUtil.UID_TAG, str);
            AppContext.getContext().getTrayPreferences().h("current_uid", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
