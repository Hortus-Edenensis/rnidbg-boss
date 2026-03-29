package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class zx {
    static final nr[] fx;
    private static final ju[] iz;
    private final xg b;
    private final u pn;
    private String x;
    public static final int[] u = {1};
    static final HashMap<String, ju> nr = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        int fx;
        int nr;
        String u;

        /* JADX INFO: Access modifiers changed from: private */
        public static void nr() {
            for (nr nrVar : zx.fx) {
                nrVar.u = "";
                nrVar.nr = 0;
                nrVar.fx = 0;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.fx);
            sb.append("-");
            sb.append(this.u);
            sb.append("-");
            sb.append(this.nr);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(ju juVar) {
            String strA = juVar.a();
            if (strA == null || strA.length() <= this.nr) {
                return;
            }
            this.u = juVar.n();
            this.nr = strA.length();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends SQLiteOpenHelper {
        public u(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.u(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ju> it = zx.nr.values().iterator();
                while (it.hasNext()) {
                    String strFx = it.next().fx();
                    if (strFx != null) {
                        sQLiteDatabase.execSQL(strFx);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    ti.nr(th);
                } finally {
                    gb.u(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ti.b("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ju> it = zx.nr.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().b());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } catch (Throwable th) {
                }
            }
            gb.u(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    static {
        u(new sf());
        u(new dc(true));
        u(new i());
        u(new ua());
        ju[] juVarArr = {new jw(), new rg(null, false, null), new uq("", new JSONObject())};
        iz = juVarArr;
        for (int i = 0; i < 3; i++) {
            u(juVarArr[i]);
        }
        fx = new nr[]{new nr(), new nr(), new nr()};
    }

    public zx(xg xgVar) {
        this.pn = new u(xgVar.nr(), "bd_embed_tea_agent.db", null, 30);
        this.b = xgVar;
    }

    private String nr(String str, boolean z) {
        StringBuilder sb = new StringBuilder("DELETE FROM page WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str);
        sb.append("'");
        return sb.toString();
    }

    private String u(String str, boolean z) {
        StringBuilder sb = new StringBuilder("SELECT * FROM page WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str);
        sb.append("' ORDER BY ");
        sb.append(z ? "session_id," : "");
        sb.append("duration DESC LIMIT 500");
        return sb.toString();
    }

    private String u(ju juVar, String str, boolean z, int i, int i2) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(juVar.b());
        sb.append(" WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str);
        sb.append("' AND event_type='");
        sb.append(i2);
        sb.append("' ORDER BY _id LIMIT ");
        sb.append(i);
        return sb.toString();
    }

    private String u(String str, int i, String str2, boolean z, long j) {
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str);
        sb.append(" WHERE session_id");
        sb.append(z ? "='" : "!='");
        sb.append(str2);
        sb.append("' AND event_type='");
        sb.append(i);
        sb.append("' AND _id<=");
        sb.append(j);
        return sb.toString();
    }

    private String u(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    private static void u(ju juVar) {
        nr.put(juVar.b(), juVar);
    }

    private boolean u(String str) {
        ti.u("needLaunch, " + this.x + ", " + str);
        if (TextUtils.equals(str, this.x)) {
            return false;
        }
        this.x = str;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:121|4|5|(6:111|6|107|7|101|8)|(9:9|10|(6:124|12|(7:(1:15)|115|16|17|113|18|19)(7:25|119|26|(1:28)|29|(1:31)|32)|33|105|34)(1:126)|69|103|74|(2:122|76)|81|82)|39|(1:43)|99|47|(7:49|(3:51|97|52)|54|117|55|60|82)|53|54|117|55|60|82) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:121|4|5|111|6|107|7|101|8|(9:9|10|(6:124|12|(7:(1:15)|115|16|17|113|18|19)(7:25|119|26|(1:28)|29|(1:31)|32)|33|105|34)(1:126)|69|103|74|(2:122|76)|81|82)|39|(1:43)|99|47|(7:49|(3:51|97|52)|54|117|55|60|82)|53|54|117|55|60|82) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013c, code lost:
    
        com.bytedance.embedapplog.ti.nr(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0145, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList<ua> u(JSONObject jSONObject) {
        ArrayList<ua> arrayList;
        SQLiteDatabase sQLiteDatabase;
        JSONArray[] jSONArrayArr;
        long[] jArr;
        SQLiteDatabase writableDatabase;
        Cursor cursorRawQuery;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        String strU;
        boolean zNr;
        JSONObject jSONObject2;
        long j;
        long j2;
        JSONObject jSONObject3;
        String str;
        SQLiteDatabase sQLiteDatabase3;
        long[] jArr2;
        HashMap<String, ju> map = nr;
        dc dcVar = (dc) map.get("launch");
        i iVar = (i) map.get("terminate");
        sf sfVar = (sf) map.get("page");
        ua uaVar = (ua) map.get("pack");
        arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        try {
            jSONArrayArr = new JSONArray[3];
            jArr = new long[3];
            writableDatabase = this.pn.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                try {
                    bc bcVarX = this.b.x();
                    strU = bcVarX.u();
                    zNr = bcVarX.nr();
                    jSONObject2 = jSONObject;
                    j = Long.MIN_VALUE;
                    j2 = Long.MAX_VALUE;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    sQLiteDatabase2 = writableDatabase;
                }
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        while (true) {
            if (!cursorRawQuery.moveToNext()) {
                break;
            }
            try {
                dcVar.u(cursorRawQuery);
                uaVar.b = dcVar.b;
                JSONObject jSONObjectU = u(dcVar, jSONObject);
                if (TextUtils.equals(dcVar.b, strU)) {
                    try {
                        dcVar.s = zNr ? false : true;
                        jSONObject3 = jSONObjectU;
                        str = strU;
                        cursor = cursorRawQuery;
                        sQLiteDatabase3 = writableDatabase;
                        try {
                            u(jSONObjectU, dcVar, uaVar, writableDatabase, jSONArrayArr, jArr, arrayList);
                            jArr2 = jArr;
                        } catch (Throwable th4) {
                            th = th4;
                            cursor2 = cursor;
                            sQLiteDatabase = sQLiteDatabase3;
                            ti.nr(th);
                            if (cursor2 != null) {
                            }
                            gb.u(sQLiteDatabase);
                            return arrayList;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = cursorRawQuery;
                        sQLiteDatabase3 = writableDatabase;
                    }
                } else {
                    jSONObject3 = jSONObjectU;
                    str = strU;
                    cursor = cursorRawQuery;
                    sQLiteDatabase3 = writableDatabase;
                    try {
                        long j3 = dcVar.u;
                        if (j3 < j2) {
                            j2 = j3;
                        }
                        if (j3 > j) {
                            j = j3;
                        }
                        jArr2 = jArr;
                        u(jSONObject3, dcVar, uaVar, sfVar, iVar, sQLiteDatabase3, jSONArrayArr, jArr);
                    } catch (Throwable th6) {
                        th = th6;
                        sQLiteDatabase = sQLiteDatabase3;
                    }
                }
                JSONObject jSONObject4 = jSONObject3;
                sQLiteDatabase = sQLiteDatabase3;
                try {
                    u(jSONObject4, true, uaVar, sQLiteDatabase);
                    jSONObject2 = jSONObject4;
                    writableDatabase = sQLiteDatabase;
                    strU = str;
                    cursorRawQuery = cursor;
                    jArr = jArr2;
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                cursor = cursorRawQuery;
                sQLiteDatabase = writableDatabase;
            }
            cursor2 = cursor;
            try {
                ti.nr(th);
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Throwable th9) {
                        ti.nr(th9);
                    }
                }
                gb.u(sQLiteDatabase);
            } finally {
            }
        }
        String str2 = strU;
        cursor = cursorRawQuery;
        long[] jArr3 = jArr;
        sQLiteDatabase = writableDatabase;
        if (j2 != Long.MAX_VALUE && j != Long.MIN_VALUE) {
            sQLiteDatabase.execSQL("DELETE FROM launch WHERE _id>=? AND _id<=?", new String[]{String.valueOf(j2), String.valueOf(j)});
        }
        if (cursor.getCount() < 5) {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject5 = jSONObject2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    u(jSONObject2, dcVar, iVar, sfVar, uaVar, sQLiteDatabase, str2, jSONArrayArr, jArr3);
                    u(jSONObject5, false, uaVar, sQLiteDatabase2);
                } catch (Throwable th10) {
                    th = th10;
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor2 = cursor;
                    ti.nr(th);
                    if (cursor2 != null) {
                    }
                    gb.u(sQLiteDatabase);
                }
            }
            sQLiteDatabase2.setTransactionSuccessful();
            cursor.close();
            gb.u(sQLiteDatabase2);
        }
        sQLiteDatabase2 = sQLiteDatabase;
        sQLiteDatabase2.setTransactionSuccessful();
        cursor.close();
        gb.u(sQLiteDatabase2);
        return arrayList;
    }

    private void u(JSONObject jSONObject, boolean z, ua uaVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : u) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iU = u(0, sQLiteDatabase, uaVar.b, z, i, jSONArrayArr, jArr);
            if (u(jArr)) {
                int i2 = iU;
                while (true) {
                    uaVar.u(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    u(uaVar, z, sQLiteDatabase, true);
                    int iU2 = i2;
                    while (iU2 < iz.length) {
                        iU2 = u(iU2, sQLiteDatabase, uaVar.b, z, i, jSONArrayArr, jArr);
                        if (u(jArr)) {
                            break;
                        }
                    }
                    i2 = iU2;
                }
            }
        }
    }

    private JSONObject u(dc dcVar, JSONObject jSONObject) {
        if (TextUtils.equals(dcVar.mv, this.b.pn().fx()) && dcVar.l == this.b.pn().nr()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            gb.nr(jSONObject2, jSONObject);
            jSONObject2.put("app_version", dcVar.mv);
            jSONObject2.put("version_code", dcVar.l);
            return jSONObject2;
        } catch (JSONException e) {
            ti.nr(e);
            return jSONObject;
        }
    }

    private void u(JSONObject jSONObject, dc dcVar, ua uaVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<ua> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        JSONArray[] jSONArrayArr2;
        long[] jArr2;
        zx zxVar;
        JSONObject jSONObject2;
        ua uaVar2;
        int iU;
        ti.u("packCurrentData, " + dcVar.b);
        boolean zU = u(dcVar.b);
        int iU2 = u(0, sQLiteDatabase, dcVar.b, true, 0, jSONArrayArr, jArr);
        if (zU || u(jArr)) {
            uaVar.u(jSONObject, zU ? dcVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iU2 >= iz.length) {
                ua uaVar3 = (ua) uaVar.clone();
                uaVar3.jk();
                arrayList.add(uaVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                iU = iU2;
                jArr2 = jArr;
                zxVar = this;
                jSONObject2 = jSONObject;
                uaVar2 = uaVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                jArr2 = jArr;
                zxVar = this;
                jSONObject2 = jSONObject;
                uaVar2 = uaVar;
                zxVar.u(uaVar2, true, sQLiteDatabase2, true);
                iU = iU2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            jSONArrayArr2 = jSONArrayArr;
            iU = iU2;
            jArr2 = jArr;
            zxVar = this;
            jSONObject2 = jSONObject;
            uaVar2 = uaVar;
        }
        while (iU < iz.length) {
            iU = zxVar.u(iU, sQLiteDatabase2, dcVar.b, true, 0, jSONArrayArr2, jArr2);
            if (zxVar.u(jArr2)) {
                uaVar2.u(jSONObject2, zxVar.u(dcVar.b) ? dcVar : null, null, null, jSONArrayArr2, jArr2, 0);
                zxVar.u(uaVar2, true, sQLiteDatabase2, true);
                iU = iU;
            }
        }
    }

    private void u(JSONObject jSONObject, dc dcVar, ua uaVar, sf sfVar, i iVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        boolean z;
        ti.u("packHistoryData, " + dcVar.b);
        JSONArray jSONArrayU = u(dcVar, true, iVar, sfVar, sQLiteDatabase);
        dcVar.s = jSONArrayU.length() == 0;
        int iU = u(0, sQLiteDatabase, dcVar.b, true, 0, jSONArrayArr, jArr);
        if (dcVar.s) {
            uaVar.u(jSONObject, u(dcVar.b) ? dcVar : null, null, null, jSONArrayArr, jArr, 0);
            z = true;
        } else {
            z = true;
            uaVar.u(jSONObject, null, iVar, jSONArrayU, jSONArrayArr, jArr, 0);
        }
        ua uaVar2 = uaVar;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        while (true) {
            u(uaVar2, z, sQLiteDatabase2, z);
            int iU2 = iU;
            while (iU2 < iz.length) {
                iU2 = u(iU2, sQLiteDatabase, dcVar.b, true, 0, jSONArrayArr, jArr);
                if (u(jArr)) {
                    break;
                }
            }
            return;
            uaVar.u(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
            uaVar2 = uaVar;
            sQLiteDatabase2 = sQLiteDatabase;
            iU = iU2;
            z = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(JSONObject jSONObject, dc dcVar, i iVar, sf sfVar, ua uaVar, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr, long[] jArr) {
        JSONObject jSONObject2;
        JSONArray[] jSONArrayArr2;
        int i;
        zx zxVar;
        i iVar2;
        ua uaVar2;
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        int iU;
        zx zxVar2;
        ti.u("packLostData, ".concat(String.valueOf(str)));
        dcVar.b = str;
        dcVar.bq = false;
        uaVar.b = str;
        JSONArray jSONArrayU = u(dcVar, false, iVar, sfVar, sQLiteDatabase);
        int iU2 = u(0, sQLiteDatabase, str, false, 0, jSONArrayArr, jArr);
        dcVar.s = jSONArrayU.length() == 0;
        if (u(jArr) || !dcVar.s) {
            boolean z = dcVar.s;
            i iVar3 = !z ? iVar : null;
            if (!z) {
                iU = iU2;
                zxVar2 = this;
                uaVar2 = uaVar;
                jSONObject2 = jSONObject;
                uaVar2.u(jSONObject2, null, iVar3, jSONArrayU, jSONArrayArr, jArr, 0);
                zxVar2.u(uaVar2, false, sQLiteDatabase, true);
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                jArr2 = jArr;
            } else {
                jSONObject2 = jSONObject;
                jSONArrayArr2 = jSONArrayArr;
                i = iU2;
                zxVar = this;
                iVar2 = iVar3;
                uaVar2 = uaVar;
                jArr2 = jArr;
                sQLiteDatabase2 = sQLiteDatabase;
                zxVar2 = zxVar;
                iU = i;
                JSONArray[] jSONArrayArr3 = jSONArrayArr2;
                SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase2;
                i iVar4 = iVar2;
                long[] jArr3 = jArr2;
                uaVar2.u(jSONObject2, null, iVar4, null, jSONArrayArr3, jArr3, 0);
                zxVar2.u(uaVar2, false, sQLiteDatabase3, true);
                sQLiteDatabase2 = sQLiteDatabase3;
                jSONArrayArr2 = jSONArrayArr3;
                jArr2 = jArr3;
            }
        } else {
            jSONObject2 = jSONObject;
            jSONArrayArr2 = jSONArrayArr;
            iU = iU2;
            zxVar2 = this;
            jArr2 = jArr;
            uaVar2 = uaVar;
            sQLiteDatabase2 = sQLiteDatabase;
        }
        while (iU < iz.length) {
            iU = zxVar2.u(iU, sQLiteDatabase2, str, false, 0, jSONArrayArr2, jArr2);
            if (zxVar2.u(jArr2)) {
                iVar2 = null;
                i = iU;
                zxVar = zxVar2;
                zxVar2 = zxVar;
                iU = i;
                JSONArray[] jSONArrayArr32 = jSONArrayArr2;
                SQLiteDatabase sQLiteDatabase32 = sQLiteDatabase2;
                i iVar42 = iVar2;
                long[] jArr32 = jArr2;
                uaVar2.u(jSONObject2, null, iVar42, null, jSONArrayArr32, jArr32, 0);
                zxVar2.u(uaVar2, false, sQLiteDatabase32, true);
                sQLiteDatabase2 = sQLiteDatabase32;
                jSONArrayArr2 = jSONArrayArr32;
                jArr2 = jArr32;
                while (iU < iz.length) {
                }
            }
        }
    }

    private boolean u(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void u(ua uaVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.pn.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    ti.nr(th);
                    if (z3) {
                        gb.u(sQLiteDatabase);
                        return;
                    }
                    return;
                } finally {
                    if (z3) {
                        gb.u(sQLiteDatabase);
                    }
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, uaVar.nr((ContentValues) null)) < 0) {
            if (uaVar.bg != null) {
                u((String) null);
            }
            if (z3) {
                return;
            } else {
                return;
            }
        }
        long j = uaVar.my;
        if (j > 0) {
            sQLiteDatabase.execSQL(u("event", uaVar.jk, uaVar.b, z, j));
        }
        long j2 = uaVar.sx;
        if (j2 > 0) {
            sQLiteDatabase.execSQL(u("eventv3", uaVar.jk, uaVar.b, z, j2));
        }
        long j3 = uaVar.dw;
        if (j3 > 0) {
            sQLiteDatabase.execSQL(u("event_misc", uaVar.jk, uaVar.b, z, j3));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z3) {
            gb.u(sQLiteDatabase);
        }
    }

    private int u(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        nr.nr();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < iz.length) {
            u(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            fx[i4].fx = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void u(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        ju juVar = iz[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(u(juVar, str, z, i, i3), null);
            for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    juVar.u(cursorRawQuery);
                    fx[i2].u(juVar);
                    if (ti.nr) {
                        ti.u("queryEvent, ".concat(String.valueOf(juVar)), null);
                    }
                    jSONArray.put(juVar.iz());
                    long j2 = juVar.u;
                    if (j2 > j) {
                        j = j2;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    try {
                        ti.nr(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } finally {
                    }
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th2) {
            th = th2;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4 A[PHI: r12 r15 r17 r18
      0x00d4: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:45:0x00d2, B:34:0x00b5, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x00d4: PHI (r15v2 long) = (r15v3 long), (r15v5 long), (r15v5 long) binds: [B:45:0x00d2, B:34:0x00b5, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x00d4: PHI (r17v3 java.lang.String) = (r17v4 java.lang.String), (r17v7 java.lang.String), (r17v7 java.lang.String) binds: [B:45:0x00d2, B:34:0x00b5, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x00d4: PHI (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v5 java.lang.String), (r18v5 java.lang.String) binds: [B:45:0x00d2, B:34:0x00b5, B:35:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray u(dc dcVar, boolean z, i iVar, sf sfVar, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        String str;
        String str2;
        long j;
        JSONArray jSONArray = new JSONArray();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(u(dcVar.b, z), null);
            try {
                HashMap map = new HashMap(8);
                boolean z2 = false;
                str = null;
                str2 = null;
                j = 0;
                while (cursorRawQuery.moveToNext()) {
                    try {
                        sfVar.u(cursorRawQuery);
                        if (ti.nr) {
                            ti.u("queryPage, ".concat(String.valueOf(sfVar)), null);
                        }
                        Integer num = (Integer) map.get(sfVar.s);
                        z2 = true;
                        if (!sfVar.jk()) {
                            map.put(sfVar.s, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                            long j2 = sfVar.l;
                            j = j2 >= 1000 ? j + j2 : j + 1000;
                            jSONArray.put(sfVar.iz());
                            if (TextUtils.isEmpty(sfVar.bq)) {
                                continue;
                            } else {
                                String str3 = sfVar.bq;
                                try {
                                    str = str3;
                                    str2 = sfVar.iz;
                                } catch (Throwable th) {
                                    th = th;
                                    str = str3;
                                    try {
                                        ti.nr(th);
                                        if (cursorRawQuery != null) {
                                        }
                                        String str4 = str;
                                        String str5 = str2;
                                        if (jSONArray.length() > 0) {
                                        }
                                        return jSONArray;
                                    } finally {
                                    }
                                }
                            }
                        } else if (num != null) {
                            Integer numValueOf = Integer.valueOf(num.intValue() - 1);
                            if (numValueOf.intValue() > 0) {
                                map.put(sfVar.s, numValueOf);
                            } else {
                                map.remove(sfVar.s);
                            }
                        } else {
                            sfVar.l = 1000L;
                            j += 1000;
                            jSONArray.put(sfVar.iz());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (z2) {
                    sQLiteDatabase.execSQL(nr(dcVar.b, z));
                }
            } catch (Throwable th3) {
                th = th3;
                str = null;
                str2 = str;
                j = 0;
                ti.nr(th);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                String str42 = str;
                String str52 = str2;
                if (jSONArray.length() > 0) {
                }
                return jSONArray;
            }
        } catch (Throwable th4) {
            th = th4;
            cursorRawQuery = null;
            str = null;
        }
        cursorRawQuery.close();
        String str422 = str;
        String str522 = str2;
        if (jSONArray.length() > 0) {
            long j3 = j > 1000 ? j : 1000L;
            iVar.l = j3;
            if (z) {
                iVar.b = dcVar.b;
                iVar.u(dcVar.nr + j3);
            } else {
                iVar.b = UUID.randomUUID().toString();
                iVar.u(0L);
            }
            iVar.pn = dcVar.pn;
            iVar.iz = dcVar.iz;
            iVar.x = dcVar.x;
            iVar.n = dcVar.n;
            iVar.mv = iVar.nr;
            iVar.fx = bc.b();
            iVar.s = null;
            if (!TextUtils.isEmpty(dcVar.k)) {
                iVar.s = dcVar.k;
            } else if (!TextUtils.isEmpty(str422)) {
                iVar.s = str422;
                iVar.iz = str522;
            }
        }
        return jSONArray;
    }

    @NonNull
    public ArrayList<ua> u() {
        Cursor cursorRawQuery;
        ArrayList<ua> arrayList = new ArrayList<>();
        ua uaVar = (ua) nr.get("pack");
        try {
            cursorRawQuery = this.pn.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    uaVar = (ua) uaVar.clone();
                    uaVar.u(cursorRawQuery);
                    arrayList.add(uaVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        ti.nr(th);
                        ti.u("queryPack, ".concat(String.valueOf(arrayList)), null);
                        return arrayList;
                    } finally {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
        }
        ti.u("queryPack, ".concat(String.valueOf(arrayList)), null);
        return arrayList;
    }

    public void u(ArrayList<ua> arrayList, ArrayList<ua> arrayList2, ArrayList<ua> arrayList3) {
        SQLiteDatabase sQLiteDatabase = null;
        ti.u("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<ua> it = arrayList2.iterator();
        while (it.hasNext()) {
            ua next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.nr) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.pn.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                try {
                    for (ua uaVar : arrayList) {
                        if (arrayList3.contains(uaVar)) {
                            u(uaVar, true, writableDatabase, false);
                        } else {
                            writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(uaVar.u)});
                        }
                    }
                } catch (Throwable th) {
                    ti.nr(th);
                }
                for (ua uaVar2 : arrayList2) {
                    if (uaVar2.bg != null) {
                        u((String) null);
                    }
                    if (!arrayList3.contains(uaVar2)) {
                        long j = uaVar2.u;
                        int i = uaVar2.mv + 1;
                        uaVar2.mv = i;
                        writableDatabase.execSQL(u(j, i));
                    }
                }
                writableDatabase.setTransactionSuccessful();
                gb.u(writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                try {
                    ti.nr(th);
                } finally {
                    gb.u(sQLiteDatabase);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void u(@NonNull ArrayList<ju> arrayList) {
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.pn.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValuesNr = null;
                for (ju juVar : arrayList) {
                    String strB = juVar.b();
                    contentValuesNr = juVar.nr(contentValuesNr);
                    juVar.u = writableDatabase.insert(strB, null, contentValuesNr);
                    if ("event".equals(juVar.b())) {
                        arrayList3.add(juVar);
                    } else if ("eventv3".equals(juVar.b())) {
                        arrayList3.add(juVar);
                    } else if (juVar instanceof dc) {
                        arrayList2.add((dc) juVar);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                gb.u(writableDatabase);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    ti.nr(th);
                } finally {
                    gb.u(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
