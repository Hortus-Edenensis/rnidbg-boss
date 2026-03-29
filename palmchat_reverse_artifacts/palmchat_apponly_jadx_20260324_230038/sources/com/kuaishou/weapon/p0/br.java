package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.provider.MediaStore;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7421a = "7";
    public static final String b = "6";
    public static final String c = "5";
    public static final String d = "4";
    public static final String e = "3";
    public static final String f = "2";
    public static final String g = "1";

    /* JADX WARN: Removed duplicated region for block: B:67:0x0295  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray a(Context context) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        String str;
        String str2;
        Object obj;
        Object obj2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3 = new JSONArray();
        try {
            try {
                CRC32 crc32 = new CRC32();
                ContentResolver contentResolver = context.getContentResolver();
                Cursor cursorQuery = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 1), null, null, null, null);
                try {
                    try {
                        if (cursorQuery.moveToNext()) {
                            JSONObject jSONObject = new JSONObject();
                            crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")).getBytes());
                            jSONObject.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                            jSONObject.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                            jSONObject.put("2", "1");
                            jSONObject.put("1", "0");
                            jSONArray3.put(jSONObject);
                        }
                        cursorQuery.close();
                        Cursor cursorQuery2 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 2), null, null, null, null);
                        if (cursorQuery2.moveToNext()) {
                            JSONObject jSONObject2 = new JSONObject();
                            str = "_data";
                            crc32.update(cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow(str)).getBytes());
                            jSONObject2.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject2.put("4", cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow("date_added")));
                            jSONObject2.put("3", cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow("date_modified")));
                            jSONObject2.put("2", "1");
                            jSONObject2.put("1", "1");
                            jSONArray3.put(jSONObject2);
                        } else {
                            str = "_data";
                        }
                        cursorQuery2.close();
                        str2 = str;
                        Cursor cursorQuery3 = contentResolver.query(RingtoneManager.getActualDefaultRingtoneUri(context.getApplicationContext(), 4), null, null, null, null);
                        if (cursorQuery3.moveToNext()) {
                            JSONObject jSONObject3 = new JSONObject();
                            crc32.update(cursorQuery3.getString(cursorQuery3.getColumnIndexOrThrow(str2)).getBytes());
                            jSONObject3.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject3.put("4", cursorQuery3.getInt(cursorQuery3.getColumnIndexOrThrow("date_added")));
                            jSONObject3.put("3", cursorQuery3.getInt(cursorQuery3.getColumnIndexOrThrow("date_modified")));
                            jSONObject3.put("2", "1");
                            jSONObject3.put("1", "2");
                            jSONArray3.put(jSONObject3);
                        }
                        cursorQuery3.close();
                        Cursor cursorQuery4 = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_ringtone= ? ", new String[]{"1"}, "date_added");
                        if (cursorQuery4.moveToNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            crc32.update(cursorQuery4.getString(cursorQuery4.getColumnIndexOrThrow(str2)).getBytes());
                            jSONObject4.put("5", Long.toHexString(crc32.getValue()));
                            jSONObject4.put("4", cursorQuery4.getInt(cursorQuery4.getColumnIndexOrThrow("date_added")));
                            jSONObject4.put("3", cursorQuery4.getInt(cursorQuery4.getColumnIndexOrThrow("date_modified")));
                            obj = "0";
                            jSONObject4.put("2", obj);
                            jSONObject4.put("1", obj);
                            jSONArray3.put(jSONObject4);
                        } else {
                            obj = "0";
                        }
                        cursorQuery4.close();
                        obj2 = obj;
                        try {
                            cursorQuery = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_notification= ? ", new String[]{"1"}, "date_added");
                            try {
                                if (cursorQuery.moveToNext()) {
                                    try {
                                        JSONObject jSONObject5 = new JSONObject();
                                        crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(str2)).getBytes());
                                        jSONObject5.put("5", Long.toHexString(crc32.getValue()));
                                        jSONObject5.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                                        jSONObject5.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                                        jSONObject5.put("2", obj2);
                                        jSONObject5.put("1", "1");
                                        jSONArray = jSONArray3;
                                        try {
                                            jSONArray.put(jSONObject5);
                                        } catch (Exception unused) {
                                            jSONArray3 = jSONArray;
                                            cursor2 = cursorQuery;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        }
                                    } catch (Exception unused2) {
                                        jSONArray = jSONArray3;
                                    }
                                } else {
                                    jSONArray = jSONArray3;
                                }
                                try {
                                    cursorQuery.close();
                                    try {
                                        jSONArray2 = jSONArray;
                                    } catch (Exception unused3) {
                                        jSONArray3 = jSONArray;
                                    }
                                } catch (Exception unused4) {
                                    jSONArray3 = jSONArray;
                                }
                            } catch (Exception unused5) {
                                jSONArray3 = jSONArray3;
                            }
                        } catch (Exception unused6) {
                            jSONArray3 = jSONArray3;
                        }
                        try {
                            cursorQuery = contentResolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, "is_alarm= ? ", new String[]{"1"}, "date_added");
                        } catch (Exception unused7) {
                            jSONArray3 = jSONArray2;
                            cursor2 = null;
                            if (cursor2 != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception unused8) {
                }
                try {
                    if (cursorQuery.moveToNext()) {
                        JSONObject jSONObject6 = new JSONObject();
                        crc32.update(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(str2)).getBytes());
                        jSONObject6.put("5", Long.toHexString(crc32.getValue()));
                        jSONObject6.put("4", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_added")));
                        jSONObject6.put("3", cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("date_modified")));
                        jSONObject6.put("2", obj2);
                        jSONObject6.put("1", "2");
                        jSONArray3 = jSONArray2;
                        jSONArray3.put(jSONObject6);
                    } else {
                        jSONArray3 = jSONArray2;
                    }
                    cursorQuery.close();
                } catch (Exception unused9) {
                    jSONArray3 = jSONArray2;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Exception unused10) {
        }
        return jSONArray3;
    }
}
