package com.tencent.turingfd.sdk.ams.ad;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.final, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cfinal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10760a;
    public final int b;
    public final Durian c;

    public Cfinal(String str, int i, Durian durian) {
        this.f10760a = str;
        this.b = i;
        this.c = durian;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.f10760a;
        if (str == null) {
            str = "";
        }
        sb.append(a(ContainerUtils.FIELD_DELIMITER, "%0A", a(",", "%54", a("_", "%5F", a(x.aQ, "%3B", a(":", "%3A", str))))));
        sb.append("_");
        sb.append(this.b);
        sb.append("_");
        Durian durian = this.c;
        if (durian == null) {
            return sb.toString();
        }
        sb.append(durian.f10693a);
        sb.append(":");
        sb.append(this.c.b);
        sb.append(":");
        Iterator<Fig> it = this.c.c.iterator();
        while (it.hasNext()) {
            Fig next = it.next();
            sb.append(next.f10694a);
            sb.append(",");
            sb.append(",");
            sb.append(",");
            String strReplaceAll = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.d));
            if (strReplaceAll.indexOf(".") > 0) {
                strReplaceAll = strReplaceAll.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(strReplaceAll);
            sb.append(",");
            String strReplaceAll2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.e));
            if (strReplaceAll2.indexOf(".") > 0) {
                strReplaceAll2 = strReplaceAll2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb.append(strReplaceAll2);
            if (it.hasNext()) {
                sb.append(x.aQ);
            }
        }
        sb.append(":");
        sb.append(this.c.d);
        return sb.toString();
    }
}
