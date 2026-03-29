package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s87 extends r87 {
    public static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd");
    public static String c = ",";

    public s87(Context context) {
        this(context.getApplicationContext(), "wfc_info", 0);
    }

    public int h(String str) {
        String strE = e(str);
        if (!TextUtils.isEmpty(strE) && strE.contains(c)) {
            try {
                String[] strArrSplit = strE.split(c);
                String str2 = strArrSplit[0];
                int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                if (b.format(new Date()).equalsIgnoreCase(str2)) {
                    return iIntValue;
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int i(String str) {
        return f("define_" + str);
    }

    public void j(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(b.format(new Date()));
        stringBuffer.append(c);
        stringBuffer.append(i);
        c(str, stringBuffer.toString());
    }

    public void k(String str, int i) {
        a("define_" + str, i);
    }

    public s87(Context context, String str, int i) {
        super(context, str, i);
    }
}
