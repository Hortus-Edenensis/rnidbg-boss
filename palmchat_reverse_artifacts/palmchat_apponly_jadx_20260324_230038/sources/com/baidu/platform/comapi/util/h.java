package com.baidu.platform.comapi.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comjni.base.sdkauth.NASDKAuth;
import com.oplus.tblplayer.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f4239a;
    private NASDKAuth b = new NASDKAuth();

    private h() {
    }

    public static void a() {
        if (f4239a != null) {
            synchronized (h.class) {
                if (f4239a != null) {
                    f4239a.c();
                    f4239a = null;
                }
            }
        }
    }

    public static h b() {
        if (f4239a == null) {
            synchronized (h.class) {
                if (f4239a == null) {
                    f4239a = new h();
                }
            }
        }
        return f4239a;
    }

    private void c() {
        this.b.dispose();
    }

    public boolean a(String str, int i) {
        if (str == null) {
            return false;
        }
        com.baidu.platform.comjni.base.sdkauth.a aVar = com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace;
        if ((aVar.a() & i) != 0) {
            this.b.a(str, aVar.a());
        }
        com.baidu.platform.comjni.base.sdkauth.a aVar2 = com.baidu.platform.comjni.base.sdkauth.a.WaterMark;
        if ((i & aVar2.a()) == 0) {
            return true;
        }
        String str2 = "token=" + AppMD5.encodeUrlParamsValue(str);
        this.b.a("https://api.map.baidu.com/sdkproxy/lbs_androidsdk/api_watermark/sdk_get_auth" + Constants.STRING_VALUE_UNSET + (str2 + "&sign=" + AppMD5.getSignMD5String(str2)), aVar2.a());
        return true;
    }
}
