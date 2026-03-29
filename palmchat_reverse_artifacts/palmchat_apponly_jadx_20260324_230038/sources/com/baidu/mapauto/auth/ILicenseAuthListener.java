package com.baidu.mapauto.auth;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface ILicenseAuthListener {
    void onError(int i, String str);

    void onSuccess(Map<String, Integer> map);
}
