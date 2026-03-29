package com.bytedance.sdk.openadsdk.core.component.reward.pn;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.kj.x;
import com.bytedance.sdk.openadsdk.core.n;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static String u(String str) {
        if (!k.fx() || TextUtils.isEmpty(str)) {
            return str;
        }
        x xVar = new x(n.o().d());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = xVar.nr().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains(Constants.STRING_VALUE_UNSET)) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(xVar.u());
                } else {
                    sb.append(Constants.STRING_VALUE_UNSET);
                    sb.append(xVar.u());
                }
            }
        }
        return sb.toString();
    }
}
