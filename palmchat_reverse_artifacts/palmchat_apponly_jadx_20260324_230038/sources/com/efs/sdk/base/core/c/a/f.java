package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.config.remote.RemoteConfig;
import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        Double d;
        com.efs.sdk.base.core.config.remote.b bVarA = com.efs.sdk.base.core.config.remote.b.a();
        String logType = logDto.getLogType();
        RemoteConfig remoteConfig = bVarA.d;
        if (com.efs.sdk.base.core.config.remote.b.f5572a.nextDouble() * 100.0d <= ((!remoteConfig.mUploadSampleRateMap.containsKey(logType) || (d = remoteConfig.mUploadSampleRateMap.get(logType)) == null) ? 100.0d : d.doubleValue())) {
            b(logDto);
        }
    }
}
