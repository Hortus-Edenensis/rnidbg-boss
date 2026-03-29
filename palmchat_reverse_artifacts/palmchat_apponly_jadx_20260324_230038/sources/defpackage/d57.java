package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.cdadata.sdk.api.ZMDataSDKManager;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class d57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16980a = "BaseDataManager";
    public ContentResolver b;
    public File c;
    public final Context d;

    public d57(Context context) {
        this.d = context;
        this.b = context.getContentResolver();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Uri uri) {
        boolean z;
        long j;
        if (this.c == null) {
            this.c = this.d.getDatabasePath("cdadatadb");
        }
        if (this.c.exists()) {
            long length = this.c.length();
            try {
                j = ZMDataSDKManager.getInstance().zmConfigOptions.maxCacheSize;
            } catch (Exception e) {
                g57.a(e);
                j = 33554432;
            }
            z = length >= j;
        }
        if (z) {
            g57.b(this.f16980a, "sqlite存储空间不足，将删除最老的100条数据");
            String[] strArrE = e(uri, 100, false);
            if (strArrE == null) {
                return -2;
            }
            c(uri, strArrE[0]);
            if (f(uri) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    public abstract int b(Uri uri, JSONObject jSONObject, boolean z);

    public void c(Uri uri, String str) {
        try {
            if ("DB_DELETE_ALL".equals(str)) {
                this.b.delete(uri, null, null);
            } else {
                this.b.delete(uri, "_id <= ?", new String[]{str});
            }
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public void d(Uri uri, String[] strArr) {
        try {
            if ("DB_DELETE_ALL".equals(strArr)) {
                this.b.delete(uri, null, null);
                return;
            }
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_id in (");
            for (int i = 0; i < strArr.length; i++) {
                sb.append(i == strArr.length - 1 ? strArr[i] : strArr[i] + ",");
            }
            sb.append(")");
            this.b.delete(uri, sb.toString(), null);
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public abstract String[] e(Uri uri, int i, boolean z);

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[PHI: r6
      0x0021: PHI (r6v3 android.database.Cursor) = (r6v2 android.database.Cursor), (r6v4 android.database.Cursor) binds: [B:13:0x001f, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(Uri uri) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.b.query(uri, null, null, null, null);
            } catch (Exception e) {
                g57.a(e);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                int count = cursorQuery.getCount();
                cursorQuery.close();
                return count;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
