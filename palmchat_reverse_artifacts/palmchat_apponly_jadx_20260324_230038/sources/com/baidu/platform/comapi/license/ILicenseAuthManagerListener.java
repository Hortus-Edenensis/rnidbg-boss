package com.baidu.platform.comapi.license;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface ILicenseAuthManagerListener {
    void onError(String str, String str2, int i, int i2, String str3);

    void onSuccess(String str, String str2, int i, Map<String, Integer> map);
}
