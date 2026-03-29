package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.b.k;
import com.igexin.push.core.d;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements a {
    private static c c;
    private ArrayList<k> d;
    private boolean e;
    private String b = "MessageDataManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7219a = -1;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public static int b() {
        Cursor cursorA = null;
        try {
            cursorA = d.a.f7200a.i.a("message", null, null, null, null);
            if (cursorA != null) {
                int count = cursorA.getCount();
                cursorA.close();
                return count;
            }
            if (cursorA == null) {
                return 0;
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorA == null) {
                    return 0;
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return 0;
    }

    private static void e() {
    }

    public final void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.c.1
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                Cursor cursorA = null;
                try {
                    com.igexin.push.b.b bVar = d.a.f7200a.i;
                    cursorA = bVar.a("message", new String[]{"status"}, new String[]{"0"}, null, null);
                    if (cursorA != null) {
                        while (cursorA.moveToNext()) {
                            byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("info"));
                            long j = cursorA.getLong(cursorA.getColumnIndex("createtime"));
                            try {
                                JSONObject jSONObject = new JSONObject(new String(com.igexin.c.b.a.c(blob)));
                                String string = jSONObject.getString("taskid");
                                if (jSONObject.has("condition") && !c.b(jSONObject) && System.currentTimeMillis() - j > 259200000) {
                                    String unused = c.this.b;
                                    com.igexin.c.a.c.a.a(c.this.b + "|del condition taskid = " + string, new Object[0]);
                                    bVar.a("message", new String[]{"taskid"}, new String[]{string});
                                }
                            } catch (Throwable th) {
                                com.igexin.c.a.c.a.a(th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        com.igexin.c.a.c.a.a(th2);
                        if (cursorA != null) {
                            cursorA.close();
                        }
                    } finally {
                        if (cursorA != null) {
                            cursorA.close();
                        }
                    }
                }
            }
        }, false, true);
    }

    public final void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.c.2
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                d.a.f7200a.i.a("message", "createtime <= ".concat(String.valueOf(System.currentTimeMillis() - com.igexin.push.f.b.d.b)));
            }
        }, false, true);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("message", null, "status =?", new String[]{"0"}, null, null, null, null);
            if (cursorQuery != null) {
                ArrayList<k> arrayList = new ArrayList<>();
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new k(cursorQuery.getInt(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("messageid")), cursorQuery.getString(cursorQuery.getColumnIndex("taskid")), cursorQuery.getString(cursorQuery.getColumnIndex("appid")), cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("info")), cursorQuery.getBlob(cursorQuery.getColumnIndex("msgextra")), cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getInt(cursorQuery.getColumnIndex("status")), cursorQuery.getLong(cursorQuery.getColumnIndex("createtime"))));
                }
                try {
                    this.d = arrayList;
                    arrayList.size();
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.igexin.c.a.c.a.a(th);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        this.e = true;
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("message", null, "status =?", new String[]{"0"}, null, null, null, null);
            if (cursorQuery != null) {
                ArrayList<k> arrayList = new ArrayList<>();
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new k(cursorQuery.getInt(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("messageid")), cursorQuery.getString(cursorQuery.getColumnIndex("taskid")), cursorQuery.getString(cursorQuery.getColumnIndex("appid")), cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("info")), cursorQuery.getBlob(cursorQuery.getColumnIndex("msgextra")), cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getInt(cursorQuery.getColumnIndex("status")), cursorQuery.getLong(cursorQuery.getColumnIndex("createtime"))));
                }
                this.d = arrayList;
                arrayList.size();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
            }
        }
    }

    public static void a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        d.a.f7200a.i.a("message", contentValues, new String[]{"taskid"}, new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            if (jSONObject2.has("wifi") || jSONObject2.has("screenOn") || jSONObject2.has("ssid") || jSONObject2.has("duration")) {
                return false;
            }
            return !jSONObject2.has("netConnected");
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }

    private void a(ContentValues contentValues) {
        try {
            if (this.f7219a == -1) {
                this.f7219a = b();
            }
            if (this.f7219a < 1000) {
                if (d.a.f7200a.i.a("message", contentValues) != -1) {
                    this.f7219a++;
                    return;
                }
                return;
            }
            int iA = d.a.f7200a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
            this.f7219a -= iA;
            if (iA < 250) {
                this.f7219a -= d.a.f7200a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - iA) + ")");
            }
            if (d.a.f7200a.i.a("message", contentValues) != -1) {
                this.f7219a++;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
        ArrayList<k> arrayList;
        if (!this.e || (arrayList = this.d) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<k> arrayList2 = this.d;
        try {
            for (k kVar : arrayList2) {
                byte[] bArr = kVar.e;
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(kVar.f7177a));
                contentValues.put("messageid", kVar.b);
                contentValues.put("taskid", kVar.c);
                contentValues.put("appid", kVar.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                byte[] bArr2 = kVar.f;
                if (bArr2 != null) {
                    contentValues.put("msgextra", bArr2);
                }
                contentValues.put("key", kVar.g);
                contentValues.put("status", Integer.valueOf(kVar.h));
                contentValues.put("createtime", Long.valueOf(kVar.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList2.clear();
    }

    private static void a(SQLiteDatabase sQLiteDatabase, ArrayList<k> arrayList) {
        try {
            for (k kVar : arrayList) {
                byte[] bArr = kVar.e;
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(kVar.f7177a));
                contentValues.put("messageid", kVar.b);
                contentValues.put("taskid", kVar.c);
                contentValues.put("appid", kVar.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                byte[] bArr2 = kVar.f;
                if (bArr2 != null) {
                    contentValues.put("msgextra", bArr2);
                }
                contentValues.put("key", kVar.g);
                contentValues.put("status", Integer.valueOf(kVar.h));
                contentValues.put("createtime", Long.valueOf(kVar.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList.clear();
    }

    public static void a(String str, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Cursor cursorA = null;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("notify_status", Integer.valueOf(i));
            if (i == com.igexin.push.core.b.aj) {
                cursorA = d.a.f7200a.i.a("message", new String[]{WfConstant.EVENT_KEY_TASK_ID}, new String[]{str}, new String[]{"redisplay_num", "redisplay_duration", "redisplay_freq"}, null);
                if (cursorA != null && cursorA.getCount() != 0) {
                    if (cursorA.moveToFirst()) {
                        int i3 = cursorA.getInt(cursorA.getColumnIndex("redisplay_num"));
                        long j = cursorA.getLong(cursorA.getColumnIndex("redisplay_duration"));
                        contentValues.put("redisplay_num", Integer.valueOf(i3 + 1));
                        contentValues.put("expect_redisplay_time", Long.valueOf((System.currentTimeMillis() / 1000) + j));
                    }
                }
                if (cursorA != null) {
                    return;
                } else {
                    return;
                }
            }
            d.a.f7200a.i.a("message", contentValues, new String[]{"taskid"}, new String[]{str});
            com.igexin.push.f.e.a().d();
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorA != null) {
                    cursorA.close();
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
    }

    public static boolean a(String str) {
        boolean z = false;
        Cursor cursorA = null;
        try {
            cursorA = d.a.f7200a.i.a("message", new String[]{"taskid"}, new String[]{str}, null, null);
            if (cursorA != null) {
                if (cursorA.getCount() > 0) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorA != null) {
                    cursorA.close();
                }
                return false;
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
    }
}
