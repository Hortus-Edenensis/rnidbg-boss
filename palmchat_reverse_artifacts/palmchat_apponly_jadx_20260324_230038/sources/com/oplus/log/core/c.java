package com.oplus.log.core;

import defpackage.gd7;
import defpackage.ve7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements gd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gd7 f7568a;
    public boolean b;
    public ve7 c;

    @Override // defpackage.gd7
    public final void logan_debug(boolean z) {
        gd7 gd7Var = this.f7568a;
        if (gd7Var != null) {
            gd7Var.logan_debug(z);
        }
    }

    @Override // defpackage.gd7
    public final void logan_flush() {
        gd7 gd7Var = this.f7568a;
        if (gd7Var != null) {
            gd7Var.logan_flush();
        }
    }

    @Override // defpackage.gd7
    public final void logan_init(String str, String str2, int i, String str3, String str4) {
        if (this.b) {
            return;
        }
        if (!CLoganProtocol.isCloganSuccess()) {
            this.f7568a = null;
            return;
        }
        CLoganProtocol cLoganProtocol = new CLoganProtocol();
        this.f7568a = cLoganProtocol;
        cLoganProtocol.setOnLoganProtocolStatus(this.c);
        this.f7568a.logan_init(str, str2, i, str3, str4);
        this.b = true;
    }

    @Override // defpackage.gd7
    public final void logan_open(String str) {
        gd7 gd7Var = this.f7568a;
        if (gd7Var != null) {
            gd7Var.logan_open(str);
        }
    }

    @Override // defpackage.gd7
    public final void logan_write(int i, String str, long j, String str2, long j2) {
        gd7 gd7Var = this.f7568a;
        if (gd7Var != null) {
            gd7Var.logan_write(i, str, j, str2, j2);
        }
    }

    @Override // defpackage.gd7
    public final void setOnLoganProtocolStatus(ve7 ve7Var) {
        this.c = ve7Var;
    }
}
