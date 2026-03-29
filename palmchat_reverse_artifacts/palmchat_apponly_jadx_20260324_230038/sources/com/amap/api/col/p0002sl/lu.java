package com.amap.api.col.p0002sl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<a>> f2980a = new Hashtable<>();
    private long i = 0;
    private boolean j = false;
    private String k = "2.0.201501131131".replace(".", "");
    private String l = null;
    boolean b = true;
    long c = 0;
    String d = null;
    ll e = null;
    private String m = null;
    private long n = 0;
    boolean f = true;
    boolean g = true;
    String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private lh f2981a = null;
        private String b = null;

        public final lh a() {
            return this.f2981a;
        }

        public final String b() {
            return this.b;
        }

        public final void a(lh lhVar) {
            this.f2981a = lhVar;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = null;
            } else {
                this.b = str.replace("##", "#");
            }
        }
    }

    private boolean b() {
        long jB = mm.b();
        long j = this.i;
        long j2 = jB - j;
        if (j == 0) {
            return false;
        }
        return this.f2980a.size() > 360 || j2 > 172800000;
    }

    private void c() {
        this.i = 0L;
        if (!this.f2980a.isEmpty()) {
            this.f2980a.clear();
        }
        this.j = false;
    }

    public final void a(String str, StringBuilder sb, lh lhVar, Context context, boolean z) {
        try {
            if (mm.a(lhVar)) {
                String str2 = str + ContainerUtils.FIELD_DELIMITER + lhVar.isOffset() + ContainerUtils.FIELD_DELIMITER + lhVar.i() + ContainerUtils.FIELD_DELIMITER + lhVar.j();
                if (!a(str2, lhVar) || lhVar.e().equals("mem") || lhVar.e().equals("file") || lhVar.e().equals("wifioff") || "-3".equals(lhVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                JSONObject jSONObjectF = lhVar.f();
                if (mm.a(jSONObjectF, "offpct")) {
                    jSONObjectF.remove("offpct");
                    lhVar.a(jSONObjectF);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (lhVar.getAccuracy() >= 300.0f) {
                        int i = 0;
                        for (String str3 : sb.toString().split("#")) {
                            if (str3.contains(",")) {
                                i++;
                            }
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (lhVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(lhVar.g())) {
                        String strReplace = str2.replace("cgiwifi", "cgi");
                        lh lhVarH = lhVar.h();
                        if (mm.a(lhVarH)) {
                            a(strReplace, new StringBuilder(), lhVarH, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(lhVar.d()))) {
                    return;
                }
                lh lhVarA = a(str2, sb, false);
                if (mm.a(lhVarA) && lhVarA.toStr().equals(lhVar.toStr(3))) {
                    return;
                }
                this.i = mm.b();
                a aVar = new a();
                aVar.a(lhVar);
                aVar.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.f2980a.containsKey(str2)) {
                    this.f2980a.get(str2).add(aVar);
                } else {
                    ArrayList<a> arrayList = new ArrayList<>();
                    arrayList.add(aVar);
                    this.f2980a.put(str2, arrayList);
                }
                if (z) {
                    try {
                        a(str2, lhVar, sb, context);
                    } catch (Throwable th) {
                        me.a(th, "Cache", "add");
                    }
                }
            }
        } catch (Throwable th2) {
            me.a(th2, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.j = false;
            this.d = null;
            this.n = 0L;
        } catch (Throwable th) {
            me.a(th, "Cache", "destroy part");
        }
    }

    private void c(Context context) throws Exception {
        boolean zIsOpen;
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!mm.a(sQLiteDatabaseOpenOrCreateDatabase, "hist")) {
                if (sQLiteDatabaseOpenOrCreateDatabase != null) {
                    if (zIsOpen) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            try {
                sQLiteDatabaseOpenOrCreateDatabase.delete("hist" + this.k, "time<?", new String[]{String.valueOf(mm.a() - 172800000)});
            } catch (Throwable th) {
                me.a(th, "DB", "clearHist");
                String message = th.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    message.contains("no such table");
                }
            }
            if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                return;
            }
            sQLiteDatabaseOpenOrCreateDatabase.close();
        } catch (Throwable th2) {
            try {
                me.a(th2, "DB", "clearHist p2");
                if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabaseOpenOrCreateDatabase.close();
            } finally {
                if (sQLiteDatabaseOpenOrCreateDatabase != null && sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                }
            }
        }
    }

    public final lh a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str) || !md.e()) {
            return null;
        }
        String str2 = str + ContainerUtils.FIELD_DELIMITER + this.f + ContainerUtils.FIELD_DELIMITER + this.g + ContainerUtils.FIELD_DELIMITER + this.h;
        if (str2.contains(GeocodeSearch.GPS) || !md.e() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.j) {
            try {
                String strA = a(str2, sb, context);
                c();
                a(context, strA, z2);
            } catch (Throwable unused) {
            }
        }
        if (this.f2980a.isEmpty()) {
            return null;
        }
        return a(str2, sb, z2);
    }

    private lh a(String str, StringBuilder sb, boolean z) {
        a aVarA;
        try {
            if (!str.contains("cgiwifi") && !str.contains("wifi")) {
                aVarA = (str.contains("cgi") && this.f2980a.containsKey(str) && this.f2980a.get(str).size() > 0) ? this.f2980a.get(str).get(0) : null;
            } else {
                aVarA = a(sb, str);
            }
            if (aVarA != null && mm.a(aVarA.a())) {
                lh lhVarA = aVarA.a();
                lhVarA.e("mem");
                lhVarA.h(aVarA.b());
                if (!z && !md.a(lhVarA.getTime())) {
                    Hashtable<String, ArrayList<a>> hashtable = this.f2980a;
                    if (hashtable != null && hashtable.containsKey(str)) {
                        this.f2980a.get(str).remove(aVarA);
                    }
                }
                if (mm.a(lhVarA)) {
                    this.c = 0L;
                }
                lhVarA.setLocationType(4);
                return lhVarA;
            }
        } catch (Throwable th) {
            me.a(th, "Cache", "get1");
        }
        return null;
    }

    private static boolean a(String str, lh lhVar) {
        if (TextUtils.isEmpty(str) || !mm.a(lhVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private a a(StringBuilder sb, String str) {
        a aVar;
        boolean z;
        a aVar2;
        if (this.f2980a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.f2980a.containsKey(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList<a> arrayList = this.f2980a.get(str);
        char c = 1;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            a aVar3 = arrayList.get(size);
            if (!TextUtils.isEmpty(aVar3.b())) {
                if (!a(aVar3.b(), sb)) {
                    z = false;
                } else {
                    if (mm.a(aVar3.b(), sb.toString())) {
                        aVar2 = aVar3;
                        aVar = aVar2;
                        break;
                    }
                    z = true;
                }
                a(aVar3.b(), (Hashtable<String, String>) hashtable);
                a(sb.toString(), (Hashtable<String, String>) hashtable2);
                hashtable3.clear();
                Iterator it = hashtable.keySet().iterator();
                while (it.hasNext()) {
                    hashtable3.put((String) it.next(), "");
                }
                Iterator it2 = hashtable2.keySet().iterator();
                while (it2.hasNext()) {
                    hashtable3.put((String) it2.next(), "");
                }
                Set setKeySet = hashtable3.keySet();
                double[] dArr = new double[setKeySet.size()];
                double[] dArr2 = new double[setKeySet.size()];
                Iterator it3 = setKeySet.iterator();
                int i = 0;
                while (it3 != null && it3.hasNext()) {
                    String str2 = (String) it3.next();
                    double d = 1.0d;
                    dArr[i] = hashtable.containsKey(str2) ? 1.0d : 0.0d;
                    if (!hashtable2.containsKey(str2)) {
                        d = 0.0d;
                    }
                    dArr2[i] = d;
                    i++;
                }
                setKeySet.clear();
                double[] dArrA = a(dArr, dArr2);
                if (dArrA[0] < 0.800000011920929d) {
                    aVar2 = aVar3;
                    if (dArrA[c] >= Math.min(md.g(), 0.618d) || (z && dArrA[0] >= Math.min(md.g(), 0.618d))) {
                        aVar = aVar2;
                        break;
                    }
                } else {
                    aVar2 = aVar3;
                    aVar = aVar2;
                    break;
                }
            }
            size--;
            c = 1;
        }
        aVar = null;
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return aVar;
    }

    private static boolean a(String str, StringBuilder sb) {
        String strSubstring;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] strArrSplit = str.split(",access");
        if (strArrSplit[0].contains("#")) {
            String str2 = strArrSplit[0];
            strSubstring = str2.substring(str2.lastIndexOf("#") + 1);
        } else {
            strSubstring = strArrSplit[0];
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return false;
        }
        return sb.toString().contains(strSubstring + ",access");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                hashtable.put(str2, "");
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            double d4 = dArr[i3];
            d2 += d4 * d4;
            double d5 = dArr2[i3];
            d3 += d5 * d5;
            d += d4 * d5;
            if (d5 == 1.0d) {
                i2++;
                if (d4 == 1.0d) {
                    i++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d6 = i;
        dArr3[1] = (d6 * 1.0d) / ((double) i2);
        dArr3[2] = d6;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (this.j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            me.a(th, "Cache", "loadDB");
        }
        this.j = true;
    }

    private String a(String str, StringBuilder sb, Context context) {
        String strSubstring;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.l = mm.l(context);
            if (str.contains(ContainerUtils.FIELD_DELIMITER)) {
                str = str.substring(0, str.indexOf(ContainerUtils.FIELD_DELIMITER));
            }
            String strSubstring2 = str.substring(str.lastIndexOf("#") + 1);
            if (strSubstring2.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (strSubstring2.length() + 9)));
                String[] strArrSplit = sb.toString().split(",access");
                if (strArrSplit[0].contains("#")) {
                    String str2 = strArrSplit[0];
                    strSubstring = str2.substring(str2.lastIndexOf("#") + 1);
                } else {
                    strSubstring = strArrSplit[0];
                }
                jSONObject.put("mmac", strSubstring);
            }
            return fw.b(lt.a(jSONObject.toString().getBytes("UTF-8"), this.l));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.l == null) {
            this.l = mm.l(context);
        }
        String strA = a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = strA;
            byte[] bArrA = lt.a(sb.toString().getBytes("UTF-8"), this.l);
            objArr[1] = bArrA;
            objArr[2] = lt.a(aMapLocation.toStr().getBytes("UTF-8"), this.l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = fw.b((byte[]) objArr[i]);
            }
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                sQLiteDatabaseOpenOrCreateDatabase.close();
            }
        } catch (Throwable th) {
            try {
                me.a(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabaseOpenOrCreateDatabase.close();
            } catch (Throwable th2) {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabaseOpenOrCreateDatabase != null && sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02b2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0276 A[EDGE_INSN: B:133:0x0276->B:85:0x0276 BREAK  A[LOOP:0: B:40:0x00d8->B:87:0x0286], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0286 A[LOOP:0: B:40:0x00d8->B:87:0x0286, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, String str, boolean z) throws Exception {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        StringBuilder sb;
        String str2;
        if (md.e() && context != null) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                int i = 0;
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                try {
                    try {
                        if (!mm.a(sQLiteDatabaseOpenOrCreateDatabase, "hist")) {
                            if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                                return;
                            }
                            sQLiteDatabaseOpenOrCreateDatabase.close();
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        if (!z) {
                            long jA = mm.a() - md.d();
                            sb2.append("time >");
                            sb2.append(jA);
                            if (str != null) {
                                sb2.append(" and feature = '");
                                sb2.append(str + "'");
                            }
                        } else {
                            long jA2 = mm.a() - 172800000;
                            sb2.append("time >");
                            sb2.append(jA2);
                            if (str != null) {
                                sb2.append(" and feature = '");
                                sb2.append(str + "'");
                            }
                        }
                        int i2 = 1;
                        cursorQuery = sQLiteDatabaseOpenOrCreateDatabase.query("hist" + this.k, new String[]{"feature", " nb", "loc"}, sb2.toString(), null, null, null, "time ASC", null);
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            if (this.l == null) {
                                try {
                                    this.l = mm.l(context);
                                } catch (Throwable th) {
                                    th = th;
                                    sQLiteDatabase2 = sQLiteDatabaseOpenOrCreateDatabase;
                                    me.a(th, "DB", "fetchHist p2");
                                }
                            }
                            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                                sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                            } else {
                                while (true) {
                                    if (cursorQuery.getString(i).startsWith("{")) {
                                        jSONObject = new JSONObject(cursorQuery.getString(i));
                                        sb3.delete(i, sb3.length());
                                        if (!TextUtils.isEmpty(cursorQuery.getString(i2))) {
                                            sb3.append(cursorQuery.getString(i2));
                                        } else if (mm.a(jSONObject, "mmac")) {
                                            sb3.append("#");
                                            sb3.append(jSONObject.getString("mmac"));
                                            sb3.append(",access");
                                        }
                                        jSONObject2 = new JSONObject(cursorQuery.getString(2));
                                        if (mm.a(jSONObject2, "type")) {
                                            jSONObject2.put("type", "new");
                                        }
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject(new String(lt.b(fw.b(cursorQuery.getString(i)), this.l), "UTF-8"));
                                        sb3.delete(0, sb3.length());
                                        if (!TextUtils.isEmpty(cursorQuery.getString(1))) {
                                            sb3.append(new String(lt.b(fw.b(cursorQuery.getString(1)), this.l), "UTF-8"));
                                        } else if (mm.a(jSONObject3, "mmac")) {
                                            sb3.append("#");
                                            sb3.append(jSONObject3.getString("mmac"));
                                            sb3.append(",access");
                                        }
                                        JSONObject jSONObject4 = new JSONObject(new String(lt.b(fw.b(cursorQuery.getString(2)), this.l), "UTF-8"));
                                        if (mm.a(jSONObject4, "type")) {
                                            jSONObject4.put("type", "new");
                                        }
                                        jSONObject = jSONObject3;
                                        jSONObject2 = jSONObject4;
                                    }
                                    lh lhVar = new lh("");
                                    lhVar.b(jSONObject2);
                                    try {
                                        if (mm.a(jSONObject, "mmac") && mm.a(jSONObject, "cgi")) {
                                            String str3 = (jSONObject.getString("cgi") + "#") + "network#";
                                            if (jSONObject.getString("cgi").contains("#")) {
                                                str2 = str3 + "cgiwifi";
                                            } else {
                                                str2 = str3 + "wifi";
                                            }
                                        } else {
                                            if (mm.a(jSONObject, "cgi")) {
                                                String str4 = (jSONObject.getString("cgi") + "#") + "network#";
                                                if (jSONObject.getString("cgi").contains("#")) {
                                                    str2 = str4 + "cgi";
                                                }
                                            }
                                            sb = sb2;
                                            sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                                            if (cursorQuery.moveToNext()) {
                                                break;
                                            }
                                            sb2 = sb;
                                            sQLiteDatabaseOpenOrCreateDatabase = sQLiteDatabase;
                                            i2 = 1;
                                            i = 0;
                                        }
                                        a(str2, sb3, lhVar, context, false);
                                        if (cursorQuery.moveToNext()) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    sb = sb2;
                                    sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                                }
                                sb3.delete(0, sb3.length());
                                sb.delete(0, sb.length());
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursorQuery = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                    cursorQuery = null;
                }
                sQLiteDatabase2 = sQLiteDatabase;
            } catch (Throwable th6) {
                th = th6;
                cursorQuery = null;
            }
            try {
                me.a(th, "DB", "fetchHist p2");
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                    sQLiteDatabase2.close();
                }
            }
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(ll llVar) {
        this.e = llVar;
    }

    private boolean a(lh lhVar, boolean z) {
        if (a(z)) {
            return lhVar == null || md.a(lhVar.getTime()) || z;
        }
        return false;
    }

    private boolean a(boolean z) {
        if (md.e() || z) {
            return this.b || md.f() || z;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final lh a(lm lmVar, boolean z, lh lhVar, ls lsVar, StringBuilder sb, String str, Context context, boolean z2) {
        ll llVar;
        boolean z3;
        boolean zA;
        String str2;
        lh lhVarA;
        String str3;
        if (!a(lhVar, z2)) {
            return null;
        }
        try {
            ll llVarE = lmVar.e();
            boolean z4 = !(llVarE == null && this.e == null) && ((llVar = this.e) == null || !llVar.equals(llVarE));
            if (lhVar != null) {
                z3 = lhVar.getAccuracy() > 299.0f && lsVar.e().size() > 5;
            } else {
                z3 = false;
            }
            if (lhVar == null || (str3 = this.d) == null || z3 || z4) {
                zA = false;
            } else {
                zA = mm.a(str3, sb.toString());
                boolean z5 = this.c != 0 && mm.b() - this.c < 3000;
                if ((zA || z5) && mm.a(lhVar)) {
                    lhVar.e("mem");
                    lhVar.setLocationType(2);
                    return lhVar;
                }
            }
            if (!zA) {
                this.c = mm.b();
            } else {
                this.c = 0L;
            }
            String str4 = this.m;
            if (str4 == null || str.equals(str4)) {
                if (this.m == null) {
                    this.n = mm.a();
                    this.m = str;
                } else {
                    this.n = mm.a();
                }
            } else {
                if (mm.a() - this.n < 3000) {
                    str2 = this.m;
                    lhVarA = (!z3 || z) ? null : a(context, str2, sb, false, false);
                    if (!(z && !mm.a(lhVarA)) || z3 || z) {
                        return null;
                    }
                    this.c = 0L;
                    lhVarA.setLocationType(4);
                    return lhVarA;
                }
                this.n = mm.a();
                this.m = str;
            }
            str2 = str;
            if (z3) {
                if (z) {
                    if (z && !mm.a(lhVarA)) {
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a() {
        this.c = 0L;
        this.d = null;
    }
}
