package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.gl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xh extends gl.u {
    private volatile boolean u = false;

    public boolean nr() {
        return this.u;
    }

    @Override // com.bytedance.embedapplog.gl
    public void u(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.gl
    public void u(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.u = bundle.getBoolean("oa_id_limit_state");
    }
}
