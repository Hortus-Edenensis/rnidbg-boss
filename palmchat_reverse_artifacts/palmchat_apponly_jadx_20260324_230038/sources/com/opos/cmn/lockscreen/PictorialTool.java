package com.opos.cmn.lockscreen;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.heytap.pictorial.sdk.PictorialSDK;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PictorialTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PictorialSDK f8034a = new PictorialSDK();
    private Context b;

    /* JADX INFO: compiled from: SearchBox */
    public static class ResultReceiverWrapper extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f8038a;

        public ResultReceiverWrapper(a aVar) {
            super(null);
            this.f8038a = aVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            a aVar;
            com.opos.cmn.an.f.a.b("PictorialTool", "onReceiveResult:" + i);
            boolean z = true;
            if (i == 1) {
                aVar = this.f8038a;
                if (aVar == null) {
                    return;
                }
            } else {
                aVar = this.f8038a;
                if (aVar == null) {
                    return;
                } else {
                    z = false;
                }
            }
            aVar.a(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(boolean z);
    }

    public PictorialTool(Context context) {
        this.b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support verifyLockScreen");
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("PictorialTool", "verifyLockScreen");
            this.f8034a.a(this.b, "", new ResultReceiverWrapper(aVar));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "verify", e);
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    public void a(a aVar) {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support unlockScreen");
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("PictorialTool", "unlockScreen");
            this.f8034a.a(this.b, new ResultReceiverWrapper(aVar));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "verify", e);
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    public void b(final a aVar) {
        if (a(this.b)) {
            a(new b() { // from class: com.opos.cmn.lockscreen.PictorialTool.2
                @Override // com.opos.cmn.lockscreen.PictorialTool.b
                public void a(boolean z) {
                    if (!z) {
                        PictorialTool.this.c(aVar);
                        return;
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.a(false);
        }
    }

    private void a(final b bVar) {
        if (a(this.b)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.cmn.lockscreen.PictorialTool.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean zBooleanValue;
                    FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.opos.cmn.lockscreen.PictorialTool.1.1
                        @Override // java.util.concurrent.Callable
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Boolean call() throws Exception {
                            return Boolean.valueOf(PictorialTool.this.a());
                        }
                    });
                    com.opos.cmn.an.j.b.c(futureTask);
                    try {
                        zBooleanValue = ((Boolean) futureTask.get(2000L, TimeUnit.MILLISECONDS)).booleanValue();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("PictorialTool", "", e);
                        zBooleanValue = false;
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(zBooleanValue);
                    }
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.b("PictorialTool", "not support queryVerifyAsync");
        if (bVar != null) {
            bVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support queryVerifySync");
            return false;
        }
        try {
            boolean zA = this.f8034a.a(this.b);
            com.opos.cmn.an.f.a.b("PictorialTool", "query verify result:" + zA);
            return zA;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "need verify", e);
            return false;
        }
    }

    public boolean a(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 26) {
            try {
                return PictorialSDK.f6428a.a(context);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("PictorialTool", "checkVerifySupport ");
                return false;
            }
        }
        return false;
    }
}
