package com.heytap.mspsdk.idmapping.impl;

import android.os.Bundle;
import com.heytap.msp.IMspCallback;
import com.heytap.msp.ipc.annotation.IPCBridgeMethod;
import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.mspsdk.idmapping.util.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@IPCModule(authsOrActions = {"com.heytap.htms.action.ID_MAPPING_SERVICE"}, ipcType = IPCType.SERVICE, targetComponentClass = Constants.MSP_CORE_IDPMAPPING_SERVICE_COMPONENT, targetModuleClass = IdMappingServiceModuleClient.TARGET_CLASS)
public interface IIdMappingServiceModule {
    @IPCBridgeMethod(methodId = 1)
    void getData(Bundle bundle, IMspCallback iMspCallback);
}
