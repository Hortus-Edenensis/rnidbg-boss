package com.bytedance.sdk.component.x.fx.u;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static String fx() {
        return pn.nr + "/t_sp/";
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.x.fx.getContext();
    }

    private static ContentResolver nr() {
        try {
            if (u()) {
                return com.bytedance.sdk.component.x.fx.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean u() {
        return com.bytedance.sdk.component.x.fx.getContext() != null;
    }

    private static String fx(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    public static synchronized void u(String str, String str2, Boolean bool) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("boolean", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, bool);
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String nr(String str, String str2, String str3) {
        String type;
        if (!u()) {
            return str3;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("string", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m)) {
                if (!TextUtils.isEmpty(type)) {
                    return type;
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    private static String fx(String str, String str2, String str3) {
        return fx() + str + "/" + str2 + fx(str3);
    }

    @TargetApi(11)
    public static Set<String> nr(String str, String str2, Set<String> set) {
        String type;
        if (!u()) {
            return set;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr == null || (type = contentResolverNr.getType(Uri.parse(fx("string_set", str2, str)))) == null || type.equals(com.igexin.push.core.b.m) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String strSubstring = type.substring(1, type.length() - 1);
            String[] strArrSplit = strSubstring.split(", ");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(strSubstring)) {
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static synchronized void u(String str, String str2, String str3) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("string", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, str3);
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void nr(String str, String str2) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    contentResolverNr.delete(Uri.parse(fx("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void u(String str, String str2, Integer num) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, num);
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> nr(String str) {
        Cursor cursorQuery;
        Object string;
        if (!u()) {
            return null;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null) {
                cursorQuery = contentResolverNr.query(Uri.parse(fx() + "get_all" + fx(str)), null, null, null, null);
                try {
                    HashMap map = new HashMap();
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("cursor_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("cursor_type");
                        int columnIndex3 = cursorQuery.getColumnIndex("cursor_value");
                        do {
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            if (string3.equalsIgnoreCase("string")) {
                                String string4 = cursorQuery.getString(columnIndex3);
                                boolean zContains = string4.contains("__COMMA__");
                                string = string4;
                                if (zContains) {
                                    boolean zMatches = string4.matches("\\[.*\\]");
                                    string = string4;
                                    if (zMatches) {
                                        String strSubstring = string4.substring(1, string4.length() - 1);
                                        String[] strArrSplit = strSubstring.split(", ");
                                        HashSet hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(strSubstring)) {
                                            for (String str2 : strArrSplit) {
                                                hashSet.add(str2.replace("__COMMA__", ", "));
                                            }
                                        }
                                        string = hashSet;
                                    }
                                }
                            } else if (string3.equalsIgnoreCase("boolean")) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string3.equalsIgnoreCase("int")) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string3.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string3.equalsIgnoreCase("float")) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else {
                                string = string3.equalsIgnoreCase("string_set") ? cursorQuery.getString(columnIndex3) : null;
                            }
                            map.put(string2, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }

    public static synchronized void u(String str, String str2, Long l) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, l);
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void u(String str, String str2, Float f) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("float", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, f);
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void u(String str, String str2, Set<String> set) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    Uri uri = Uri.parse(fx("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put(ActionUtils.PAYMENT_AMOUNT, hashSet.toString());
                    contentResolverNr.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int u(String str, String str2, int i) {
        String type;
        if (!u()) {
            return i;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("int", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float u(String str, String str2, float f) {
        String type;
        if (!u()) {
            return f;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("float", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean u(String str, String str2, boolean z) {
        String type;
        if (!u()) {
            return z;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("boolean", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long u(String str, String str2, long j) {
        String type;
        if (!u()) {
            return j;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("long", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static boolean u(String str, String str2) {
        String type;
        if (!u()) {
            return false;
        }
        try {
            ContentResolver contentResolverNr = nr();
            if (contentResolverNr != null && (type = contentResolverNr.getType(Uri.parse(fx("contain", str2, str)))) != null && !type.equals(com.igexin.push.core.b.m) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void u(String str) {
        if (u()) {
            try {
                ContentResolver contentResolverNr = nr();
                if (contentResolverNr != null) {
                    contentResolverNr.delete(Uri.parse(fx() + "clean" + fx(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
