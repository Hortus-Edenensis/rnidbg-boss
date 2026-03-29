package com.qiniu.android.http.serverRegion;

import com.qiniu.android.utils.Utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UploadServerFreezeUtil {
    private static final UploadServerFreezeManager globalHttp3Freezer = new UploadServerFreezeManager();
    private static final UploadServerFreezeManager globalHttp2Freezer = new UploadServerFreezeManager();

    public static String getFrozenType(String str, String str2) {
        return String.format("%s-%s", str, Utils.getIpType(str2, str));
    }

    public static UploadServerFreezeManager globalHttp2Freezer() {
        return globalHttp2Freezer;
    }

    public static UploadServerFreezeManager globalHttp3Freezer() {
        return globalHttp3Freezer;
    }

    public static boolean isTypeFrozenByFreezeManagers(String str, UploadServerFreezeManager[] uploadServerFreezeManagerArr) {
        if (str == null || str.length() == 0) {
            return true;
        }
        if (uploadServerFreezeManagerArr == null || uploadServerFreezeManagerArr.length == 0) {
            return false;
        }
        boolean zIsTypeFrozen = false;
        for (UploadServerFreezeManager uploadServerFreezeManager : uploadServerFreezeManagerArr) {
            zIsTypeFrozen = uploadServerFreezeManager.isTypeFrozen(str);
            if (zIsTypeFrozen) {
                break;
            }
        }
        return zIsTypeFrozen;
    }
}
