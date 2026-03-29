package com.heytap.msp.opos.sv.interapi;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.bean.csc.InitConfig;
import com.opos.cmn.an.f.a;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MSPSvModule implements IBridgeHandler {
    private static final String TAG = "MSPSvModule";
    private Interface mModuleImpl;
    private static MSPSvModule singleInstance = new MSPSvModule();
    public static IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.heytap.msp.opos.sv.interapi.MSPSvModule.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MSPSvModule.singleInstance;
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public final class Client extends BaseProviderClient implements Interface {
        public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.MSPSvModule";

        public Client(Context context) {
            this(context, null);
        }

        @Override // com.opos.process.bridge.client.BaseProviderClient
        public String getTargetClass() {
            return "com.heytap.msp.opos.sv.interapi.MSPSvProvider";
        }

        @Override // com.heytap.msp.opos.sv.interapi.MSPSvModule.Interface
        public final void init(InitConfig initConfig) throws BridgeExecuteException, BridgeDispatchException {
            checkMainThread();
            call(this.mContext, "com.heytap.msp.opos.sv.interapi.MSPSvModule", this.mTargetIdentify, 0, initConfig);
        }

        public Client(Context context, Bundle bundle) {
            super(context, null, bundle);
            this.defaultAuthorities = new String[]{"com.heytap.msp.opos.sv.MSP_SV_PROVIDER"};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Interface {
        void init(InitConfig initConfig) throws BridgeExecuteException, BridgeDispatchException;
    }

    public static MSPSvModule getInstance() {
        return singleInstance;
    }

    @BridgeMethod(methodId = 0)
    public void init(InitConfig initConfig) {
        try {
            this.mModuleImpl.init(initConfig);
        } catch (Throwable th) {
            a.c(TAG, "init", th);
        }
    }

    public void setModuleImpl(Interface r1) {
        this.mModuleImpl = r1;
    }
}
