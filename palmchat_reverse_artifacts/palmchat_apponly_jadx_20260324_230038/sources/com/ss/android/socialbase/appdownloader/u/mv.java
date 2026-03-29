package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.WkInitManager;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class mv extends u {
    public mv(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str) {
        super(context, uVar, str);
    }

    public static String u(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String string = stringBuffer.toString();
        return string.endsWith(ContainerUtils.FIELD_DELIMITER) ? string.substring(0, string.length() - 1) : string;
    }

    @Override // com.ss.android.socialbase.appdownloader.u.pn
    public Intent nr() {
        String strFx = this.nr.fx("s");
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("bb"), strFx);
        if (!TextUtils.isEmpty(strU) && strU.split(",").length == 2) {
            String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("bc"), strFx);
            if (!TextUtils.isEmpty(strU2) && strU2.split(",").length == 2) {
                String[] strArrSplit = strU.split(",");
                String[] strArrSplit2 = strU2.split(",");
                String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx(WkInitManager.sdk_bd), strFx);
                String strU4 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("be"), strFx);
                String strU5 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("bf"), strFx);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strU3, this.fx);
                Intent intent = new Intent();
                intent.setAction(strU5);
                intent.setData(Uri.parse(strU4 + u(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
