package com.heytap.mspsdk.idmapping.impl;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.IMspCallback;
import com.heytap.mspsdk.idmapping.util.Constants;
import com.opos.process.bridge.client.BaseServiceClient;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class IdMappingServiceModuleClient extends BaseServiceClient implements IdMappingServiceModuleInterface {
    public static final String TARGET_CLASS = "com.heytap.msp.idmapping.IdMappingServiceModule";

    public IdMappingServiceModuleClient(Context context) {
        this(context, null);
    }

    @Override // com.heytap.mspsdk.idmapping.impl.IdMappingServiceModuleInterface
    public final void getData(Bundle bundle, IMspCallback iMspCallback) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, TARGET_CLASS, this.mTargetIdentify, 1, bundle, iMspCallback);
    }

    @Override // com.opos.process.bridge.client.BaseServiceClient
    public String getTargetClass() {
        return Constants.MSP_CORE_IDPMAPPING_SERVICE_COMPONENT;
    }

    public IdMappingServiceModuleClient(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultActions = new String[]{"com.heytap.htms.action.ID_MAPPING_SERVICE"};
    }
}
