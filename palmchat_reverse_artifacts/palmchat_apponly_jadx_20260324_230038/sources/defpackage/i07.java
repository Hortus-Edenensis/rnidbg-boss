package defpackage;

import android.text.TextUtils;
import com.alipay.sdk.m.r.a;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f18079a;
    public String b;
    public String[] c;

    public i07(String str, a aVar) {
        this.b = str;
        this.f18079a = aVar;
    }

    public static List<i07> b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] strArrD = d(jSONObject.optString("name", ""));
        for (int i = 0; i < strArrD.length; i++) {
            a aVarA = a.a(strArrD[i]);
            if (aVarA != a.None) {
                i07 i07Var = new i07(strArrD[i], aVarA);
                i07Var.c = e(strArrD[i]);
                arrayList.add(i07Var);
            }
        }
        return arrayList;
    }

    public static void c(i07 i07Var) {
        String[] strArrF = i07Var.f();
        if (strArrF.length == 3 && TextUtils.equals("tid", strArrF[0])) {
            su6 su6VarA = su6.a(j07.e().c());
            if (TextUtils.isEmpty(strArrF[1]) || TextUtils.isEmpty(strArrF[2])) {
                return;
            }
            su6VarA.b(strArrF[1], strArrF[2]);
        }
    }

    public static String[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(x.aQ);
    }

    public static String[] e(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf(40);
        int iLastIndexOf = str.lastIndexOf(41);
        if (iIndexOf == -1 || iLastIndexOf == -1 || iLastIndexOf <= iIndexOf) {
            return null;
        }
        for (String str2 : str.substring(iIndexOf + 1, iLastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public a a() {
        return this.f18079a;
    }

    public String[] f() {
        return this.c;
    }
}
