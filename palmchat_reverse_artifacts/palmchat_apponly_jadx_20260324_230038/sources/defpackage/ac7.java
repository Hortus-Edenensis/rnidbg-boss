package defpackage;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ac7 {
    public static Map<String, Object> a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        try {
            return b(cursor);
        } catch (Throwable th) {
            try {
                h87.d("ResponseUtil", th);
                try {
                    cursor.close();
                    return null;
                } catch (Throwable th2) {
                    h87.d("ResponseUtil", th2);
                    return null;
                }
            } finally {
                try {
                    cursor.close();
                } catch (Throwable th3) {
                    h87.d("ResponseUtil", th3);
                }
            }
        }
    }

    public static Map<String, Object> b(Cursor cursor) throws Throwable {
        HashMap map = new HashMap();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                map.putAll(c(cursor));
            } while (cursor.moveToNext());
        }
        return map;
    }

    public static Map<String, Object> c(Cursor cursor) {
        Object objValueOf;
        HashMap map = new HashMap();
        for (String str : cursor.getColumnNames()) {
            int columnIndex = cursor.getColumnIndex(str);
            int type = cursor.getType(columnIndex);
            if (type == 1) {
                objValueOf = Long.valueOf(cursor.getLong(columnIndex));
            } else if (type == 2) {
                objValueOf = Double.valueOf(cursor.getDouble(columnIndex));
            } else if (type != 3) {
                if (type == 4) {
                    map.put(str, cursor.getBlob(columnIndex));
                }
            } else {
                objValueOf = cursor.getString(columnIndex);
            }
            map.put(str, objValueOf);
        }
        return map;
    }
}
