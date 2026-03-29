package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.dn;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g67 extends d57 {
    public g67(Context context) {
        super(context);
        this.f16980a = "KVDataManager";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x005b. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:116)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:71)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // defpackage.d57
    public int b(Uri uri, JSONObject jSONObject, boolean z) {
        String str;
        String str2;
        String str3;
        byte b;
        String str4;
        ContentValues contentValues;
        Long lValueOf;
        String strOptString;
        if (uri == null) {
            return -1;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return 0;
            }
            String strSubstring = path.substring(1);
            String str5 = "zm_data_lon";
            String str6 = "app_end_time";
            String str7 = "zm_data_imsi";
            String str8 = "zm_data_imei";
            switch (strSubstring.hashCode()) {
                case -2083080420:
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    if (strSubstring.equals("zm_data_pubinfomd5")) {
                        b = 21;
                        str4 = "zm_data_pubinfomd5";
                    }
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -1847039717:
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    if (strSubstring.equals(str3)) {
                        b = 7;
                        str4 = "zm_data_pubinfomd5";
                    }
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -1583592911:
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    if (!strSubstring.equals(str8)) {
                        str8 = str8;
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                        b = -1;
                    } else {
                        b = 5;
                        str8 = str8;
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    break;
                case -1583592477:
                    str2 = "zm_data_meid";
                    str = "zm_data_nettype";
                    if (!strSubstring.equals(str7)) {
                        str7 = str7;
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                        b = -1;
                    } else {
                        b = 6;
                        str7 = str7;
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    break;
                case -1583481316:
                    str2 = "zm_data_meid";
                    if (!strSubstring.equals(str2)) {
                        str = "zm_data_nettype";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                        b = -1;
                    } else {
                        b = 8;
                        str = "zm_data_nettype";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    break;
                case -1583425578:
                    if (strSubstring.equals("zm_data_oaid")) {
                        b = 12;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -1437430111:
                    if (strSubstring.equals("activity_started_count")) {
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        b = 0;
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -967814066:
                    if (strSubstring.equals("zm_data_nettype")) {
                        b = 16;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -571365073:
                    if (strSubstring.equals("zm_data_installApp")) {
                        b = 17;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case -398203659:
                    if (strSubstring.equals("app_first_start")) {
                        b = 3;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 137889465:
                    if (strSubstring.equals("zm_data_thirdid")) {
                        b = 19;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 560321128:
                    if (strSubstring.equals("zm_data_sessionid")) {
                        b = 20;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 791585128:
                    if (strSubstring.equals("app_start_time")) {
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        b = 1;
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1084224513:
                    if (strSubstring.equals("zm_data_androidid")) {
                        b = 11;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1521941740:
                    if (strSubstring.equals("app_end_data")) {
                        b = 4;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1522425871:
                    if (strSubstring.equals("app_end_time")) {
                        b = 2;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1750034198:
                    if (strSubstring.equals("zm_data_lat")) {
                        b = dn.k;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1750034626:
                    if (strSubstring.equals("zm_data_lon")) {
                        b = dn.l;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1750035142:
                    if (strSubstring.equals("zm_data_mac")) {
                        b = 10;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1813670418:
                    if (strSubstring.equals("zm_data_remote_config")) {
                        b = 22;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1826093115:
                    if (strSubstring.equals("zm_data_loginid")) {
                        b = 18;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1857568260:
                    if (strSubstring.equals("zm_data_sn")) {
                        b = 9;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 1964784692:
                    if (strSubstring.equals("sub_process_flush_data")) {
                        b = 23;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                case 2038108399:
                    if (strSubstring.equals("zm_data_carrier")) {
                        b = 15;
                        str = "zm_data_nettype";
                        str2 = "zm_data_meid";
                        str3 = "zm_data_iccid";
                        str4 = "zm_data_pubinfomd5";
                    }
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
                default:
                    str = "zm_data_nettype";
                    str2 = "zm_data_meid";
                    str3 = "zm_data_iccid";
                    str4 = "zm_data_pubinfomd5";
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    contentValues = contentValues2;
                    contentValues.put("activity_started_count", Integer.valueOf(jSONObject.optInt(ActionUtils.PAYMENT_AMOUNT)));
                    try {
                        this.b.insert(uri, contentValues);
                    } catch (Exception e) {
                        e = e;
                        g57.a(e);
                        return 0;
                    }
                    break;
                case 1:
                    contentValues = contentValues2;
                    lValueOf = Long.valueOf(jSONObject.optLong(ActionUtils.PAYMENT_AMOUNT));
                    str6 = "app_start_time";
                    contentValues.put(str6, lValueOf);
                    this.b.insert(uri, contentValues);
                    break;
                case 2:
                    contentValues = contentValues2;
                    lValueOf = Long.valueOf(jSONObject.optLong(ActionUtils.PAYMENT_AMOUNT));
                    contentValues.put(str6, lValueOf);
                    this.b.insert(uri, contentValues);
                    break;
                case 3:
                    contentValues = contentValues2;
                    lValueOf = Long.valueOf(jSONObject.optLong(ActionUtils.PAYMENT_AMOUNT));
                    str6 = "app_first_start";
                    contentValues.put(str6, lValueOf);
                    this.b.insert(uri, contentValues);
                    break;
                case 4:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "app_end_data";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 5:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = str8;
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 6:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = str7;
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 7:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = str3;
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 8:
                    String str9 = str2;
                    contentValues = contentValues2;
                    str5 = str9;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 9:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_sn";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 10:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_mac";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 11:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_androidid";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 12:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_oaid";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 13:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_lat";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 14:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 15:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_carrier";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 16:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = str;
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 17:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_installApp";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 18:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_loginid";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 19:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_thirdid";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 20:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_sessionid";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 21:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = str4;
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 22:
                    contentValues = contentValues2;
                    strOptString = jSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                    str5 = "zm_data_remote_config";
                    contentValues.put(str5, strOptString);
                    this.b.insert(uri, contentValues);
                    break;
                case 23:
                    contentValues = contentValues2;
                    contentValues.put("sub_process_flush_data", Boolean.valueOf(jSONObject.optBoolean(ActionUtils.PAYMENT_AMOUNT)));
                    this.b.insert(uri, contentValues);
                    break;
            }
            return -1;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // defpackage.d57
    public void c(Uri uri, String str) {
        super.c(uri, str);
    }

    @Override // defpackage.d57
    public void d(Uri uri, String[] strArr) {
        super.d(uri, strArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019f A[PHI: r9
      0x019f: PHI (r9v6 android.database.Cursor) = (r9v5 android.database.Cursor), (r9v7 android.database.Cursor) binds: [B:111:0x019d, B:104:0x0190] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0155  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.database.Cursor] */
    @Override // defpackage.d57
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] e(Uri uri, int i, boolean z) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        byte b;
        if (uri == 0) {
            return null;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            try {
                String strSubstring = path.substring(1);
                cursorQuery = this.b.query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToNext();
                            switch (strSubstring.hashCode()) {
                                case -2083080420:
                                    b = !strSubstring.equals("zm_data_pubinfomd5") ? (byte) -1 : (byte) 20;
                                    break;
                                case -1847039717:
                                    if (strSubstring.equals("zm_data_iccid")) {
                                        b = 7;
                                        break;
                                    }
                                    break;
                                case -1583592911:
                                    if (strSubstring.equals("zm_data_imei")) {
                                        b = 4;
                                        break;
                                    }
                                    break;
                                case -1583592477:
                                    if (strSubstring.equals("zm_data_imsi")) {
                                        b = 5;
                                        break;
                                    }
                                    break;
                                case -1583481316:
                                    if (strSubstring.equals("zm_data_meid")) {
                                        b = 6;
                                        break;
                                    }
                                    break;
                                case -1583425578:
                                    if (strSubstring.equals("zm_data_oaid")) {
                                        b = 11;
                                        break;
                                    }
                                    break;
                                case -1437430111:
                                    if (strSubstring.equals("activity_started_count")) {
                                        b = 0;
                                        break;
                                    }
                                    break;
                                case -967814066:
                                    if (strSubstring.equals("zm_data_nettype")) {
                                        b = 15;
                                        break;
                                    }
                                    break;
                                case -571365073:
                                    if (strSubstring.equals("zm_data_installApp")) {
                                        b = 16;
                                        break;
                                    }
                                    break;
                                case -398203659:
                                    if (strSubstring.equals("app_first_start")) {
                                        b = 2;
                                        break;
                                    }
                                    break;
                                case 137889465:
                                    if (strSubstring.equals("zm_data_thirdid")) {
                                        b = 18;
                                        break;
                                    }
                                    break;
                                case 560321128:
                                    if (strSubstring.equals("zm_data_sessionid")) {
                                        b = 19;
                                        break;
                                    }
                                    break;
                                case 791585128:
                                    if (strSubstring.equals("app_start_time")) {
                                        b = 22;
                                        break;
                                    }
                                    break;
                                case 1084224513:
                                    if (strSubstring.equals("zm_data_androidid")) {
                                        b = 10;
                                        break;
                                    }
                                    break;
                                case 1521941740:
                                    if (strSubstring.equals("app_end_data")) {
                                        b = 3;
                                        break;
                                    }
                                    break;
                                case 1522425871:
                                    if (strSubstring.equals("app_end_time")) {
                                        b = 23;
                                        break;
                                    }
                                    break;
                                case 1750034198:
                                    if (strSubstring.equals("zm_data_lat")) {
                                        b = 12;
                                        break;
                                    }
                                    break;
                                case 1750034626:
                                    if (strSubstring.equals("zm_data_lon")) {
                                        b = dn.k;
                                        break;
                                    }
                                    break;
                                case 1750035142:
                                    if (strSubstring.equals("zm_data_mac")) {
                                        b = 8;
                                        break;
                                    }
                                    break;
                                case 1813670418:
                                    if (strSubstring.equals("zm_data_remote_config")) {
                                        b = 21;
                                        break;
                                    }
                                    break;
                                case 1826093115:
                                    if (strSubstring.equals("zm_data_loginid")) {
                                        b = 17;
                                        break;
                                    }
                                    break;
                                case 1857568260:
                                    if (strSubstring.equals("zm_data_sn")) {
                                        b = 9;
                                        break;
                                    }
                                    break;
                                case 1964784692:
                                    if (strSubstring.equals("sub_process_flush_data")) {
                                        b = 1;
                                        break;
                                    }
                                    break;
                                case 2038108399:
                                    if (strSubstring.equals("zm_data_carrier")) {
                                        b = dn.l;
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            switch (b) {
                                case 0:
                                case 1:
                                case 2:
                                    String[] strArr = {String.valueOf(cursorQuery.getInt(0))};
                                    cursorQuery.close();
                                    return strArr;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                    String[] strArr2 = {String.valueOf(cursorQuery.getString(0))};
                                    cursorQuery.close();
                                    return strArr2;
                                case 22:
                                case 23:
                                    String[] strArr3 = {String.valueOf(cursorQuery.getLong(0))};
                                    cursorQuery.close();
                                    return strArr3;
                                default:
                                    cursorQuery.close();
                                    return null;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        g57.a(e);
                        if (cursorQuery != null) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (uri != 0) {
                    uri.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            uri = 0;
            if (uri != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }
}
