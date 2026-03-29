package com.bytedance.sdk.component.a.fx;

import com.bytedance.sdk.component.nr.u.a;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements a {
    private int u;

    public void u(int i) {
        this.u = i;
    }

    @Override // com.bytedance.sdk.component.nr.u.a
    public my u(a.u uVar) throws IOException {
        IOException iOException;
        s sVarU = uVar.u();
        if (x.u().u(this.u).nr() != null) {
            x.u().u(this.u).nr().pn();
        }
        String string = sVarU.nr().toString();
        String strU = x.u().u(this.u).u(string);
        if (!string.equals(strU)) {
            sVarU = sVarU.x().u(strU).nr();
        }
        my myVarU = null;
        try {
            iOException = null;
            myVarU = uVar.u(sVarU);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            x.u().u(this.u).u(sVarU, e);
        }
        x.u().u(this.u).u(sVarU, myVarU);
        if (iOException == null) {
            return myVarU == null ? uVar.u(sVarU) : myVarU;
        }
        throw iOException;
    }
}
