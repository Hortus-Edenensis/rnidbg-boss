package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements com.heytap.mspsdk.interceptor.b<e, Object> {
    @Override // com.heytap.mspsdk.interceptor.b
    public Object a(com.heytap.mspsdk.interceptor.a<e, Object> aVar) {
        e eVarA = aVar.a();
        eVarA.a("compatStart");
        eVarA.e.b();
        a(eVarA.f, eVarA.d);
        eVarA.e.c();
        eVarA.a("compatProceedStart");
        return aVar.a(eVarA);
    }

    private void a(Bundle bundle, com.heytap.mspsdk.core.b bVar) {
        Pair<String, String> pair;
        String string;
        int i;
        int i2 = -1;
        if (bundle != null) {
            String string2 = bundle.getString(Constants.BUNDLE_KEY_MSP_SDK_RETENTION_TITLE);
            String string3 = bundle.getString(Constants.BUNDLE_KEY_MSP_SDK_RETENTION_CONTENT);
            pair = (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) ? null : new Pair<>(string2, string3);
            i2 = bundle.getInt(Constants.BUNDLE_KEY_SHOW_DOWNLOAD_MSP_GUIDE, -1);
        } else {
            pair = null;
        }
        if (!bVar.b()) {
            MspLog.iIgnore("CompatCheckInterceptor", "msp app no exist, showDownloadGuide = " + i2);
            if (i2 == 1 && a(bVar, pair)) {
                throw new MspSdkException(2000, MspSdkCode.EXCEPTION_MSG_2000_DOWN_APP);
            }
            if (i2 == 1) {
                throw new MspSdkException(2006, MspSdkCode.EXCEPTION_MSG_2006_NO_EXIST_GUIDE_SDK);
            }
            throw new MspSdkException(2005, MspSdkCode.EXCEPTION_MSG_2005_NOT_INSTALL_MSP);
        }
        if (bundle != null) {
            i = bundle.getInt(Constants.BUNDLE_KEY_APP_MIN_VERSIONCODE);
            string = bundle.getString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME);
        } else {
            string = null;
            i = 0;
        }
        if (bundle == null) {
            throw new MspSdkException(2004, MspSdkCode.EXCEPTION_MSG_2004_IPC_BUNDLE_NULL);
        }
        if (i == 0) {
            throw new MspSdkException(2002, MspSdkCode.EXCEPTION_MSG_2002_MISS_MSP_APP_MIN_VERSION);
        }
        if (TextUtils.isEmpty(string)) {
            throw new MspSdkException(2003, MspSdkCode.EXCEPTION_MSG_2003_MISS_SDK_KIT_NAME);
        }
        boolean z = !bVar.a();
        boolean z2 = i > bVar.e();
        if (z || z2) {
            MspLog.iIgnore("CompatCheckInterceptor", "need download the newest app, [appMinVersionCode,versionCode] is [" + i + "," + bVar.e() + "], showDownloadGuide = " + i2 + ", isMspCoreBelow2Dot0 = " + z + ", versionCodeIsNotMatched = " + z2);
            if (i2 == 1 && a(bVar, pair)) {
                throw new MspSdkException(2001, MspSdkCode.EXCEPTION_MSG_2001_DOWN_APP);
            }
            if (i2 == 1) {
                throw new MspSdkException(2006, MspSdkCode.EXCEPTION_MSG_2006_NO_EXIST_GUIDE_SDK);
            }
            throw new MspSdkException(2005, MspSdkCode.EXCEPTION_MSG_2005_NOT_INSTALL_MSP);
        }
    }

    private boolean a(com.heytap.mspsdk.core.b bVar, Pair<String, String> pair) {
        if (!bVar.c()) {
            MspLog.e("CompatCheckInterceptor", "MspCoreInstaller dos not exist");
            return false;
        }
        Class<?> cls = null;
        try {
            cls = Class.forName("com.heytap.mspsdk.guide.MspCoreInstaller");
            Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (objInvoke instanceof com.heytap.mspsdk.guide.a) {
                ((com.heytap.mspsdk.guide.a) objInvoke).a(com.heytap.mspsdk.core.e.a().b(), pair);
            } else {
                MspLog.e("CompatCheckInterceptor", "object is not IMspCoreInstaller");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MspLog.e("CompatCheckInterceptor", e);
        }
        if (cls != null) {
            return true;
        }
        MspLog.e("CompatCheckInterceptor", "MspCoreInstaller dos not exist");
        return false;
    }
}
