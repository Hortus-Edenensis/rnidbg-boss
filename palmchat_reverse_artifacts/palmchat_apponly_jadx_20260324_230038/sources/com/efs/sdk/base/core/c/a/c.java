package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {
    private static boolean c(LogDto logDto) {
        return logDto.isCp() || (1 == logDto.getLogProtocol() && !logDto.isSendImediately()) || 1 == logDto.getLogBodyType();
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        if (c(logDto)) {
            b(logDto);
            return;
        }
        byte[] bArrA = com.efs.sdk.base.core.util.b.a(logDto.getData());
        if (bArrA == null) {
            Log.w("efs.base", "gzip error");
            b(logDto);
        } else {
            logDto.setData(bArrA);
            logDto.setCp(Constants.CP_GZIP);
            b(logDto);
        }
    }
}
