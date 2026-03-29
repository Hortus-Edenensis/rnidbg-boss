package org.apache.cordova;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SafeChecker {
    private static final Set<String> unSafeServiceNameSet = new HashSet<String>() { // from class: org.apache.cordova.SafeChecker.1
        {
            add("UserInfo");
            add("slideVerify");
            add("reportInfo");
            add("RedPacketPullNewUtils");
        }
    };

    public static boolean checkUxssAttackForDangerAction(String str, String str2) {
        return isUnsafeUrl(str) && isUnsafeService(str2);
    }

    private static boolean isUnsafeService(String str) {
        if (str != null) {
            return unSafeServiceNameSet.contains(str);
        }
        return false;
    }

    private static boolean isUnsafeUrl(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("\"") || str.contains("%22"));
    }
}
