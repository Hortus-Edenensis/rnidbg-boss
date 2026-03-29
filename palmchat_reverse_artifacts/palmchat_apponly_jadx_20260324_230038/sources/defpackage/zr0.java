package defpackage;

import android.database.Cursor;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zr0 {
    public static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            LogUtil.i("CursorHelper", "columindex error =" + str);
        }
        if (columnIndex >= 0) {
            return cursor.getInt(columnIndex);
        }
        return 0;
    }
}
