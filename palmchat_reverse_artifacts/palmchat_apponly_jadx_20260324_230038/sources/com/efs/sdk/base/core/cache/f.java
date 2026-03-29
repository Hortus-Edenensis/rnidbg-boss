package com.efs.sdk.base.core.cache;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements IFileFilter {
    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final boolean filter(File file) {
        String name = file.getName();
        LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
        if (logDtoCreateLogDtoByName != null) {
            return ("wa".equals(logDtoCreateLogDtoByName.getLogType()) || com.efs.sdk.base.core.b.c.a().a(logDtoCreateLogDtoByName.getLogType(), file.length())) ? false : true;
        }
        CacheManager.getInstance().onChangeDtoError(file);
        return true;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final void finish() {
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final boolean hasTask() {
        return false;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public final void finish(boolean z, boolean z2) {
    }
}
