package com.ss.android.ttvecamera.hardware;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import com.ss.android.ttvecamera.framework.TEReflectUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TECameraMTKProxy extends TECameraHardware2Proxy {
    private static List<String> sNoZsdPlatforms = new ArrayList();
    private static String sPlatform = (String) TEReflectUtil.invokeStatic("android.os.SystemProperties", "get", new String[]{"ro.mediatek.platform"});
    private static boolean sZsdModeSupport;

    static {
        Collections.addAll(sNoZsdPlatforms, "MT6571", "MT6595", "MT6795", "MT6572", "MT6752", "MT6582", "MT6735", "MT6592", "MT6753", "MT6589", "MT6755", "MT6735m", "MT6737T", "MT6580", "MT6750", "MT6750S", "MT6737", "MT6739", "MT6570", "MT6761");
    }

    public TECameraMTKProxy(Context context) {
        super(context);
    }

    public static boolean isMTKPlatform() {
        return !TextUtils.isEmpty(sPlatform);
    }

    public static boolean isSupportZsdMode() {
        if (!sZsdModeSupport) {
            sZsdModeSupport = Collections.unmodifiableList(sNoZsdPlatforms).indexOf(sPlatform) < 0;
        }
        return sZsdModeSupport;
    }
}
