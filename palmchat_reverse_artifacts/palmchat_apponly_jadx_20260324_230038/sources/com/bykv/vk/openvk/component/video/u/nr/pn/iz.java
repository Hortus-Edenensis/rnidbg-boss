package com.bykv.vk.openvk.component.video.u.nr.pn;

import com.bykv.vk.openvk.component.video.u.nr.iz;
import com.bytedance.sdk.component.nr.u.my;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz extends u {
    private my fx;

    public iz(my myVar, pn pnVar) {
        com.bytedance.sdk.component.nr.u.iz izVarX;
        this.fx = myVar;
        this.u = new ArrayList();
        if (myVar != null && (izVarX = myVar.x()) != null) {
            for (int i = 0; i < izVarX.u(); i++) {
                this.u.add(new iz.nr(izVarX.u(i), izVarX.nr(i)));
            }
        }
        this.nr = pnVar;
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.u
    public InputStream b() {
        return this.fx.iz().fx();
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.u
    public List<iz.nr> fx() {
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.u
    public boolean nr() {
        return this.fx.fx() >= 200 && this.fx.fx() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.u
    public int u() {
        return this.fx.fx();
    }

    @Override // com.bykv.vk.openvk.component.video.u.nr.pn.u
    public String u(String str, String str2) {
        return u(str) != null ? u(str).nr : str2;
    }
}
