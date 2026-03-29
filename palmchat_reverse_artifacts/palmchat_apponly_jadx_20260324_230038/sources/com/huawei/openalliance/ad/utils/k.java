package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k {
    private static final String Code = "CNStrUtil";

    private static String Code(long j) {
        float f = (j * 1.0f) / 1048576.0f;
        if (f < 0.1f) {
            f = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }

    public static String Code(Context context, int i, String str, Object... objArr) {
        StringBuilder sb;
        Resources resources = context.getResources();
        String string = null;
        try {
            if (cn.Code(context).Code()) {
                int identifier = resources.getIdentifier(str + "_zh", "string", context.getPackageName());
                string = objArr != null ? resources.getString(identifier, objArr) : resources.getString(identifier);
            }
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getChinaString ");
            sb.append(e.getClass().getSimpleName());
            fh.Z(Code, sb.toString());
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getChinaString ");
            sb.append(e.getClass().getSimpleName());
            fh.Z(Code, sb.toString());
        }
        return string == null ? (objArr == null || objArr.length <= 0) ? resources.getString(i) : resources.getString(i, objArr) : string;
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }
}
