package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19306a;

    public a1(Context context) {
        this.f19306a = context;
    }

    public static String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "35bb33", new byte[]{52, 54, 29, 3, 9}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7a8008", new byte[]{37, 108, 79, 65}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8f478a", new byte[]{44, 124, 87, 74, 21, 115, Utf8.REPLACEMENT_BYTE}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public final void b(pblk.pblb pblbVar) {
        Cursor cursorQuery;
        try {
            this.f19306a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "447a48", new byte[]{38, 57, 73, 91, 6, 42, 62, 15, 115, ByteCompanionObject.MAX_VALUE, 35, 58, 93, 24, dn.l, 97, 56, 5, 99, Utf8.REPLACEMENT_BYTE, 44, 50, 87, 17, 0}), 0);
        } catch (Exception unused) {
        }
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b04fb6", new byte[]{112, Base64.padSymbol, 73, 6, 88, 47, 117, 75, 42, 121, 112, Base64.padSymbol, 74, 92, 80, 36, 104, 11, 112, 120, 117, 62, 94, TELogUtils.DEBUG_LEVEL_V, 88, 111, 110, 1, 96, 56, 122, 54, 84, 22, 86, 110}));
        try {
            cursorQuery = this.f19306a.getContentResolver().query(uri, null, null, new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5c28f8", new byte[]{43, 96, 72, 72})}, null);
            try {
                String strA = a(cursorQuery);
                if (pblbVar != null) {
                    pblbVar.u(strA);
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (cursorQuery == null) {
                    return;
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
    }
}
