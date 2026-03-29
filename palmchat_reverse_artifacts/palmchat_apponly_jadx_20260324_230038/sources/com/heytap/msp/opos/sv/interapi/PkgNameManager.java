package com.heytap.msp.opos.sv.interapi;

import com.opos.process.bridge.provider.ThreadLocalUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PkgNameManager {
    private static final String CALLING_PACKAGE_NAME = "opos_calling_package_name";
    private static final String TAG = "PkgNameManager";
    private static volatile PkgNameManager sInstance;

    private PkgNameManager() {
    }

    public static PkgNameManager getInstance() {
        if (sInstance == null) {
            synchronized (PkgNameManager.class) {
                if (sInstance == null) {
                    sInstance = new PkgNameManager();
                }
            }
        }
        return sInstance;
    }

    public String getCallingPackage() {
        return (String) ThreadLocalUtil.get(CALLING_PACKAGE_NAME);
    }

    public void putCallingPackage(String str) {
        ThreadLocalUtil.put(CALLING_PACKAGE_NAME, str);
    }
}
