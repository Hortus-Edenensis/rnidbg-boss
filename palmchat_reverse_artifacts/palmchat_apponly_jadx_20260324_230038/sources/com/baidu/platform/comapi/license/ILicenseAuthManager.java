package com.baidu.platform.comapi.license;

import android.content.Context;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface ILicenseAuthManager {
    boolean isEffective(String str, String str2);

    boolean isHaveAuthority();

    boolean isHaveAuthority(Map<String, Integer> map);

    void loadAuth(Context context, ILicenseAuthManagerListener iLicenseAuthManagerListener);

    Map<String, Integer> loadLocalAuth(Context context) throws BaseLicenseAuthDataStandardProcess.ProcessException;
}
