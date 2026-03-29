package com.bykv.vk.openvk.component.video.u.nr.nr;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.jk.jk;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.ss.android.download.api.constant.BaseConstants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private static volatile fx nr;
    private final Executor b;
    private final b fx;
    private volatile SQLiteStatement pn;
    private final SparseArray<Map<String, u>> u;

    private fx(Context context) {
        SparseArray<Map<String, u>> sparseArray = new SparseArray<>(2);
        this.u = sparseArray;
        this.b = new com.bytedance.sdk.component.jk.b.b(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new jk(5, "video_proxy_db"));
        this.fx = new b(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, u> map = this.u.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.b.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.nr.nr.fx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fx.this.fx.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void insert(final u uVar) {
        if (uVar != null) {
            Map<String, u> map = this.u.get(uVar.b);
            if (map != null) {
                map.put(uVar.u, uVar);
            }
            this.b.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.nr.nr.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (fx.this.pn == null) {
                            fx fxVar = fx.this;
                            fxVar.pn = fxVar.fx.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            fx.this.pn.clearBindings();
                        }
                        fx.this.pn.bindString(1, uVar.u);
                        fx.this.pn.bindString(2, uVar.nr);
                        fx.this.pn.bindLong(3, uVar.fx);
                        fx.this.pn.bindLong(4, uVar.b);
                        fx.this.pn.bindString(5, uVar.pn);
                        fx.this.pn.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public u query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, u> map = this.u.get(i);
        u uVar = map == null ? null : map.get(str);
        if (uVar != null) {
            return uVar;
        }
        try {
            Cursor cursorQuery = this.fx.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    uVar = new u(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex(IMediaFormat.KEY_MIME)), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i, cursorQuery.getString(cursorQuery.getColumnIndex(BaseConstants.EVENT_LABEL_EXTRA)));
                }
                cursorQuery.close();
            }
            if (uVar != null && map != null) {
                map.put(str, uVar);
            }
            return uVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String nr(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append(Constants.STRING_VALUE_UNSET);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static fx u(Context context) {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx(context);
                }
            }
        }
        return nr;
    }

    public void u(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, u> map = this.u.get(i);
        int i2 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.fx.getWritableDatabase().delete("video_http_header_t", "key IN(" + nr(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void u(final int i) {
        Map<String, u> map = this.u.get(i);
        if (map != null) {
            map.clear();
        }
        this.b.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.nr.nr.fx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fx.this.fx.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
