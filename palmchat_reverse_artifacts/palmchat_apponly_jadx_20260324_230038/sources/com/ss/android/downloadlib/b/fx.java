package com.ss.android.downloadlib.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.downloadlib.addownload.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private static volatile fx nr;
    private SQLiteDatabase u;

    private fx() {
        try {
            this.u = new nr(l.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.pn.fx.u().u(th, "ClickEventHelper");
        }
    }

    public static fx u() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    public boolean fx() {
        return com.ss.android.socialbase.downloader.n.u.fx().u("click_event_switch", 0) == 2;
    }

    public boolean nr() {
        return com.ss.android.socialbase.downloader.n.u.fx().u("click_event_switch", 0) == 1;
    }

    private void fx(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.u.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception unused) {
        }
    }

    public boolean nr(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && j > 0 && !TextUtils.isEmpty(str)) {
            Cursor cursorQuery = null;
            try {
                String strOptString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.u.query("click_event", nr.u, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                cursorQuery.close();
                return z;
            } catch (Exception unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
        return false;
    }

    public void u(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.u;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString(ReportItem.RequestKeyRequestId);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
            contentValues.put(ReportItem.RequestKeyRequestId, strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.u.insert("click_event", null, contentValues);
        } catch (Exception unused) {
        }
        fx(j, str);
    }
}
