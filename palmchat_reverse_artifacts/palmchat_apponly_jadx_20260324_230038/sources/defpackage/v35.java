package defpackage;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.route.share.screenshots.ScreenShotItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v35 {
    public static final String[] e = {RedPacketPullNewPlugin.ACTION_SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏", "Screenshots"};
    public static v35 f = new v35();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentObserver f21344a;
    public ContentObserver b;
    public u35 c;
    public long d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21347a;
        public final /* synthetic */ Uri b;

        public c(int i, Uri uri) {
            this.f21347a = i;
            this.b = uri;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zB = tg4.b(AppContext.getContext(), BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList);
            LogUtil.i("ScreenShotManager", "processMediaChange hasPermission=" + zB);
            if (zB) {
                if (this.f21347a == 0) {
                    v35.this.l(this.b);
                } else {
                    v35.this.n(this.b);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21348a;
        public final /* synthetic */ ScreenShotItem b;

        public d(Activity activity, ScreenShotItem screenShotItem) {
            this.f21348a = activity;
            this.b = screenShotItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            v35.this.c.e(this.f21348a, this.b);
        }
    }

    public v35() {
        this.c = null;
        this.c = new u35();
    }

    public static v35 f() {
        return f;
    }

    public final boolean e(String str) {
        if (str != null && str.length() >= 2) {
            String lowerCase = str.toLowerCase();
            for (String str2 : e) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060 A[Catch: all -> 0x0059, Exception -> 0x005c, TRY_LEAVE, TryCatch #4 {Exception -> 0x005c, all -> 0x0059, blocks: (B:6:0x0026, B:8:0x002c, B:13:0x0060), top: B:31:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(int i) throws Throwable {
        String str;
        Cursor cursor = null;
        string = null;
        String string = null;
        cursor = null;
        try {
            try {
                Cursor cursorQuery = AppContext.getContext().getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data", "video_id"}, "video_id=?", new String[]{String.valueOf(i)}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("video_id"));
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            LogUtil.i("ScreenShotManager", "getvideoThumb" + i2 + " " + string);
                        } else {
                            LogUtil.i("ScreenShotManager", "getvideoThumb not found" + i);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = string;
                        cursor = cursorQuery;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery == null) {
                    return string;
                }
                cursorQuery.close();
                return string;
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void h() {
        try {
            this.f21344a = new a(null);
            this.b = new b(null);
            AppContext.getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f21344a);
            AppContext.getContext().getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, this.b);
            LogUtil.i("ScreenShotManager", "init");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i(String str, ScreenShotItem screenShotItem, String str2) {
        HashMap map = new HashMap();
        map.put("shot_type", screenShotItem.type == 0 ? "picture" : "video");
        if (str2 != null) {
            map.put("click_type", str2);
        }
        zn6.h("screenshot_alert", str, map);
    }

    public final void j(Activity activity, ScreenShotItem screenShotItem) {
        HashMap map = new HashMap();
        LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
        if (locationExI != null) {
            map.put("latitude", String.valueOf(locationExI.getLatitude()));
            map.put("longitude", String.valueOf(locationExI.getLongitude()));
        }
        map.put("pageindex", activity.getClass().getSimpleName());
        map.put("shot_type", screenShotItem.type == 0 ? "picture" : "video");
        map.put("lasttime", String.valueOf(screenShotItem.during));
        zn6.h(RedPacketPullNewPlugin.ACTION_SCREENSHOT, "view", map);
    }

    public final void k(ScreenShotItem screenShotItem) {
        Activity currentResumedActivity;
        boolean zIsCorrect = screenShotItem.isCorrect();
        LogUtil.i("ScreenShotManager", "onScreenShotDetect" + az2.c(screenShotItem) + " isCorrect=" + zIsCorrect);
        if (zIsCorrect && (currentResumedActivity = AppLifeCircleManager.getInstance().getCurrentResumedActivity()) != null) {
            j(currentResumedActivity, screenShotItem);
            u93.c(new d(currentResumedActivity, screenShotItem));
        }
    }

    public final void l(Uri uri) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "datetaken", "date_added"}, null, null, "_id desc ");
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0 || cursorQuery.isClosed()) {
                    return;
                }
            }
            if (cursorQuery == null) {
                LogUtil.i("ScreenShotManager", "processImage cursor null");
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
                return;
            }
            if (!cursorQuery.moveToFirst()) {
                LogUtil.i("ScreenShotManager", "processImage cursor empty");
                if (cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
                return;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            int columnIndex2 = cursorQuery.getColumnIndex("datetaken");
            int columnIndex3 = cursorQuery.getColumnIndex("date_added");
            String string = cursorQuery.getString(columnIndex);
            long j = cursorQuery.getLong(columnIndex2);
            cursorQuery.getLong(columnIndex3);
            LogUtil.i("ScreenShotManager", "processImage data" + string + "dateTaken=" + j);
            StringBuilder sb = new StringBuilder();
            sb.append("processImage timepast");
            sb.append(System.currentTimeMillis() - j);
            LogUtil.i("ScreenShotManager", sb.toString());
            if (!TextUtils.isEmpty(string)) {
                System.currentTimeMillis();
                if (e(string)) {
                    k(new ScreenShotItem(0, string, null, 0L, 0L));
                }
            }
            if (cursorQuery.isClosed()) {
                return;
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (0 != 0 && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void m(Uri uri, int i) {
        LogUtil.i("ScreenShotManager", "processMediaChange" + i + "uri =" + uri + " thread" + Thread.currentThread());
        if (Math.abs(this.d - ir5.b()) <= 5500 || AppContext.getContext().isBackground() || !AccountUtils.t(AppContext.getContext())) {
            return;
        }
        LogUtil.i("ScreenShotManager", "processMediaChange 2");
        this.d = ir5.b();
        u93.d(500, new c(i, uri));
    }

    public final void n(Uri uri) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "duration", "_size", "_id"}, null, null, "_id desc ");
                if (cursorQuery == null) {
                    if (cursorQuery == null || cursorQuery.isClosed()) {
                        return;
                    }
                    cursorQuery.close();
                    return;
                }
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery.isClosed()) {
                        return;
                    }
                    cursorQuery.close();
                    return;
                }
                int columnIndex = cursorQuery.getColumnIndex("_data");
                int columnIndex2 = cursorQuery.getColumnIndex("duration");
                int columnIndex3 = cursorQuery.getColumnIndex("_size");
                String string = cursorQuery.getString(columnIndex);
                long j = cursorQuery.getInt(columnIndex2);
                long j2 = cursorQuery.getInt(columnIndex3);
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                LogUtil.i("ScreenShotManager", "processVideo data" + string + "during=" + j + " size=" + j2 + " id=" + i);
                if (!TextUtils.isEmpty(string) && e(string)) {
                    k(new ScreenShotItem(1, string, nk3.h(g(i), i, string), j2, j));
                }
                if (cursorQuery.isClosed()) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0 || cursorQuery.isClosed()) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (0 != 0 && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            LogUtil.i("ScreenShotManager", "image onChange 1");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, @Nullable Uri uri) {
            super.onChange(z, uri);
            LogUtil.i("ScreenShotManager", "image onChange selfChange=" + z + " uri=" + uri);
            v35.this.m(uri, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            LogUtil.i("ScreenShotManager", "video onChange 1");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, @Nullable Uri uri) {
            super.onChange(z, uri);
            LogUtil.i("ScreenShotManager", "video onChange selfChange=" + z + " uri=" + uri);
            v35.this.m(uri, 1);
        }
    }
}
