package com.bytedance.sdk.openadsdk.ats.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements t {
    private nr nr = new nr();
    private u fx = new u();
    private boolean u = !this.nr.u();

    @Override // com.bytedance.sdk.component.b.t
    public String get(String str) {
        String str2 = this.nr.u() ? this.nr.get(str) : "";
        return (this.u && TextUtils.isEmpty(str2)) ? this.fx.get(str) : str2;
    }

    @Override // com.bytedance.sdk.component.b.t
    public boolean getBoolean(String str) {
        boolean z = this.nr.u() ? this.nr.getBoolean(str) : false;
        return (!this.u || z) ? z : this.fx.getBoolean(str);
    }

    @Override // com.bytedance.sdk.component.b.t
    public int getInt(String str) {
        int i = this.nr.u() ? this.nr.getInt(str) : Integer.MAX_VALUE;
        return (this.u && i == Integer.MAX_VALUE) ? this.fx.getInt(str) : i;
    }

    @Override // com.bytedance.sdk.component.b.t
    public long getLong(String str) {
        long j = this.nr.u() ? this.nr.getLong(str) : Long.MAX_VALUE;
        return (this.u && j == 2147483647L) ? this.fx.getLong(str) : j;
    }

    @Override // com.bytedance.sdk.component.b.t
    public void set(String str, String str2) {
        if (this.nr.u()) {
            this.nr.set(str, str2);
        }
    }
}
