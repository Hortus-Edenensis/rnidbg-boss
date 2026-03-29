package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        if (logDto.isSendImediately()) {
            b(logDto);
        } else {
            CacheManager.getInstance().put(logDto);
        }
    }
}
