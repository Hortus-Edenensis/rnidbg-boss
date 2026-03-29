package com.heytap.msp.opos.sv.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.msp.opos.sv.api.innerapi.CommonConstants;
import com.heytap.msp.opos.sv.api.innerapi.KitUtils;
import com.heytap.msp.opos.sv.api.innerapi.MSPSDKManager;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.heytap.msp.opos.sv.interapi.CommonAdModule;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkResult;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.exception.MspSdkException;
import com.opos.process.bridge.provider.BridgeException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements b {
    private String a(DeepLinkRequest deepLinkRequest) {
        return deepLinkRequest == null ? "checkDeepLinkRequest() request is null." : TextUtils.isEmpty(deepLinkRequest.getDeepLinkUrl()) ? "checkDeepLinkRequest() deepLinkUrl is invalid." : TextUtils.isEmpty(deepLinkRequest.getDpToken()) ? "checkDeepLinkRequest() dpToken is invalid." : "";
    }

    @Override // com.heytap.msp.opos.sv.b.a.b
    public DeepLinkResult executeDeepLink(Context context, DeepLinkRequest deepLinkRequest) {
        String msg;
        com.opos.cmn.an.f.a.b("CommonAdModuleManagerImplClient", "executeDeepLink() request=", deepLinkRequest);
        int code = 60000000;
        DeepLinkResult deepLinkResult = null;
        try {
            Context applicationContext = context.getApplicationContext();
            if (!TextUtils.isEmpty(a(deepLinkRequest))) {
                msg = ErrorCode.ERROR_MSG_COMMON_AD_ERROR_PREFIX + "";
                code = 60000001;
            } else if (a(applicationContext)) {
                MSPSDKManager.getInstance().initIfNeed(applicationContext);
                Bundle bundle = new Bundle();
                KitUtils.assembleBundle(bundle);
                deepLinkResult = ((CommonAdModule.Interface) MspSdk.apiProxy(new CommonAdModule.Client(applicationContext, bundle))).executeDeepLink(deepLinkRequest);
                com.opos.cmn.an.f.a.b("CommonAdModuleManagerImplClient", "executeDeeplink() server return result:" + deepLinkResult);
                if (deepLinkResult == null) {
                    msg = "60000000 result is null";
                    code = 60001008;
                } else {
                    code = deepLinkResult.getCode();
                    msg = deepLinkResult.getMsg();
                }
            } else {
                msg = ErrorCode.ERROR_MSG_COMMON_AD_ERROR_PREFIX + CommonConstants.ERROR_MSG_KIT_VERSION_NOT_SUPPORT;
                code = 60001002;
            }
        } catch (MspSdkException e) {
            com.opos.cmn.an.f.a.d("CommonAdModuleManagerImplClient", "executeDeeplink() fail", e);
            msg = ErrorCode.ERROR_MSG_COMMON_AD_ERROR_PREFIX + e.getMessage();
            code = 60001004;
        } catch (BridgeException e2) {
            com.opos.cmn.an.f.a.d("CommonAdModuleManagerImplClient", "executeDeeplink() fail", e2);
            msg = ErrorCode.ERROR_MSG_COMMON_AD_ERROR_PREFIX + e2.getMessage();
            code = 60001005;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("CommonAdModuleManagerImplClient", "executeDeeplink() fail", th);
            msg = ErrorCode.ERROR_MSG_COMMON_AD_ERROR_PREFIX + th.getMessage();
        }
        if (deepLinkResult == null) {
            deepLinkResult = new DeepLinkResult(code, msg);
        } else {
            deepLinkResult.setCode(code);
            deepLinkResult.setMsg(msg);
        }
        com.opos.cmn.an.f.a.b("CommonAdModuleManagerImplClient", "executeDeeplink() result=", deepLinkResult);
        return deepLinkResult;
    }

    @Override // com.heytap.msp.opos.sv.b.a.b
    public int getSDKVerCode() {
        return 1003000;
    }

    @Override // com.heytap.msp.opos.sv.b.a.b
    public String getSDKVerName() {
        return "1.3.0";
    }

    private boolean a(Context context) {
        return KitUtils.getKitVersion(context) >= 1003000;
    }
}
