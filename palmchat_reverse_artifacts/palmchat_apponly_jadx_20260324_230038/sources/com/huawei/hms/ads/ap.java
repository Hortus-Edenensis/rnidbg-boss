package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.jsb.inner.data.DeviceInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ap extends ah {
    public static final String Z = "JsbReqSettings";

    public ap() {
        super(ak.Code);
    }

    private int I(String str) {
        try {
            return R.string.class.getField(str).getInt(null);
        } catch (Throwable th) {
            fh.I(Z, "getResourceId err, " + th.getClass().getSimpleName());
            return 0;
        }
    }

    private String V(Context context) {
        Resources resources = context.getResources();
        Map<String, String> mapCode = com.huawei.openalliance.ad.utils.ad.Code(resources.getString(R.string.hiad_jssdk_i18n));
        if (mapCode == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : mapCode.entrySet()) {
            int I = I(entry.getValue());
            if (I > 0) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(resources.getString(I));
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.Code(cn.Code(context).V());
        deviceInfo.Code(d.Code());
        deviceInfo.V(V(context));
        ah.Code(remoteCallResultCallback, this.Code, 1000, com.huawei.openalliance.ad.utils.ad.Code(deviceInfo), true);
    }
}
