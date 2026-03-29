package com.getui.gtc.base.log.a;

import com.getui.gtc.base.log.ILogController;
import com.getui.gtc.base.log.ILogFormatter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements ILogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5697a;
    private ILogFormatter b;

    public b() {
        this(new com.getui.gtc.base.log.c.b());
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final boolean isLoggable(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.f5697a;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final void log(int i, String str, String str2, Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.b.log(i, str, str2, th);
    }

    public b(ILogFormatter iLogFormatter) {
        this.f5697a = true;
        this.b = (ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
    }
}
