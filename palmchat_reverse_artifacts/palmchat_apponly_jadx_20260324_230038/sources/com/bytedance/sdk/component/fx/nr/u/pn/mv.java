package com.bytedance.sdk.component.fx.nr.u.pn;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface mv {
    public static final mv u = new mv() { // from class: com.bytedance.sdk.component.fx.nr.u.pn.mv.1
        @Override // com.bytedance.sdk.component.fx.nr.u.pn.mv
        public boolean u(int i, List<fx> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.mv
        public boolean u(int i, List<fx> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.component.fx.nr.u.pn.mv
        public boolean u(int i, com.bytedance.sdk.component.fx.u.pn pnVar, int i2, boolean z) throws IOException {
            pnVar.n(i2);
            return true;
        }
    };

    boolean u(int i, com.bytedance.sdk.component.fx.u.pn pnVar, int i2, boolean z) throws IOException;

    boolean u(int i, List<fx> list);

    boolean u(int i, List<fx> list, boolean z);
}
