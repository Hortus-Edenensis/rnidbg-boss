package com.heytap.mspsdk.idmapping.impl;

import android.os.Bundle;
import com.heytap.msp.IMspCallback;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IdMappingServiceModuleInterface {
    void getData(Bundle bundle, IMspCallback iMspCallback) throws BridgeExecuteException, BridgeDispatchException;
}
