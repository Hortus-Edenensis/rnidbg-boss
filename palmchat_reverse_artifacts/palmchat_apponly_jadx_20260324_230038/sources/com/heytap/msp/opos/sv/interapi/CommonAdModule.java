package com.heytap.msp.opos.sv.interapi;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkResult;
import com.opos.cmn.an.f.a;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class CommonAdModule implements IBridgeHandler {
    private static final String TAG = "CommonAdModule";
    private Interface mModuleImpl;
    private static CommonAdModule singleInstance = new CommonAdModule();
    public static IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.heytap.msp.opos.sv.interapi.CommonAdModule.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return CommonAdModule.singleInstance;
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public final class Client extends BaseProviderClient implements Interface {
        public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.CommonAdModule";

        public Client(Context context) {
            this(context, null);
        }

        @Override // com.heytap.msp.opos.sv.interapi.CommonAdModule.Interface
        public final DeepLinkResult executeDeepLink(DeepLinkRequest deepLinkRequest) throws BridgeExecuteException, BridgeDispatchException {
            checkMainThread();
            Object objCallForResult = callForResult(this.mContext, "com.heytap.msp.opos.sv.interapi.CommonAdModule", this.mTargetIdentify, 0, deepLinkRequest);
            checkNullResultType(objCallForResult, DeepLinkResult.class);
            if (objCallForResult == null || (objCallForResult instanceof DeepLinkResult)) {
                return (DeepLinkResult) objCallForResult;
            }
            throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
        }

        @Override // com.opos.process.bridge.client.BaseProviderClient
        public String getTargetClass() {
            return "com.heytap.msp.opos.sv.interapi.MSPSvProvider";
        }

        public Client(Context context, Bundle bundle) {
            super(context, null, bundle);
            this.defaultAuthorities = new String[]{"com.heytap.msp.opos.sv.MSP_SV_PROVIDER"};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Interface {
        DeepLinkResult executeDeepLink(DeepLinkRequest deepLinkRequest) throws BridgeExecuteException, BridgeDispatchException;
    }

    public static CommonAdModule getInstance() {
        return singleInstance;
    }

    @BridgeMethod(methodId = 0)
    public DeepLinkResult executeDeepLink(DeepLinkRequest deepLinkRequest) {
        try {
            return this.mModuleImpl.executeDeepLink(deepLinkRequest);
        } catch (Throwable th) {
            a.d(TAG, "executeDeepLink() fail", th);
            return new DeepLinkResult(60000000, th.getMessage());
        }
    }

    public void setModuleImpl(Interface r1) {
        this.mModuleImpl = r1;
    }
}
