package com.bytedance.pangle.x.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public com.bytedance.pangle.fx.u fx;
    public int nr;
    public String u;

    public pn(String str, int i) {
        this.u = str;
        this.nr = i;
    }

    public pn(com.bytedance.pangle.fx.u uVar) {
        if (uVar != null) {
            this.u = uVar.nr();
            this.nr = uVar.fx();
            this.fx = uVar;
        }
    }
}
