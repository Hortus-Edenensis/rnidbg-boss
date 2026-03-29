package com.opos.mobad.cmn.func.adhandler;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.opos.cmn.i.g;
import com.opos.cmn.lockscreen.PictorialTool;
import com.opos.mobad.cmn.func.adhandler.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class UnlockHandler implements f {
    private static Map<String, a> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8635a;
    private PictorialTool b;

    /* JADX INFO: compiled from: SearchBox */
    public static class ActivityResultReceiverWrapper extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f.a f8640a;

        public ActivityResultReceiverWrapper(Handler handler, f.a aVar) {
            super(handler);
            this.f8640a = aVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            if (i == 1) {
                f.a aVar = this.f8640a;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            f.a aVar2 = this.f8640a;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Activity activity);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends com.opos.cmn.an.transactivity.api.b {
        @Override // com.opos.cmn.an.transactivity.api.b, com.opos.cmn.an.transactivity.a.a
        public void a(Activity activity, Bundle bundle) {
            super.a(activity, bundle);
            g.b(activity);
            final ResultReceiver resultReceiver = (ResultReceiver) activity.getIntent().getParcelableExtra("extra_key_extra_callback");
            UnlockHandler.b(new f.a() { // from class: com.opos.mobad.cmn.func.adhandler.UnlockHandler.b.1
                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void a() {
                    ResultReceiver resultReceiver2 = resultReceiver;
                    if (resultReceiver2 == null) {
                        return;
                    }
                    resultReceiver2.send(1, null);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void b() {
                    ResultReceiver resultReceiver2 = resultReceiver;
                    if (resultReceiver2 == null) {
                        return;
                    }
                    resultReceiver2.send(2, null);
                }
            }, true).a(activity);
        }
    }

    public UnlockHandler(Context context) {
        this.f8635a = context;
        this.b = new PictorialTool(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a b(final f.a aVar, final boolean z) {
        return new a() { // from class: com.opos.mobad.cmn.func.adhandler.UnlockHandler.2
            /* JADX INFO: Access modifiers changed from: private */
            public void b(Activity activity) {
                if (activity == null || !z || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                activity.finish();
            }

            private void c(final Activity activity) {
                g.a(activity, new g.a() { // from class: com.opos.mobad.cmn.func.adhandler.UnlockHandler.2.1
                    @Override // com.opos.cmn.i.g.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("UnlockHandler", "on dismiss");
                        f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        b(activity);
                    }

                    @Override // com.opos.cmn.i.g.a
                    public void b() {
                        com.opos.cmn.an.f.a.b("UnlockHandler", "on dismiss fail");
                        f.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                        b(activity);
                    }
                });
            }

            @Override // com.opos.mobad.cmn.func.adhandler.UnlockHandler.a
            public void a(Activity activity) {
                if (activity != null && !activity.isDestroyed()) {
                    c(activity);
                    return;
                }
                f.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        };
    }

    private void d(Context context, f.a aVar) {
        Context context2 = this.f8635a;
        Activity activity = (context2 == null || !(context2 instanceof Activity)) ? null : (Activity) context2;
        if (activity == null && (context instanceof Activity)) {
            activity = (Activity) context;
        }
        if (activity != null) {
            b(aVar, false).a(activity);
        } else {
            com.opos.cmn.an.f.a.b("UnlockHandler", "start with trans act");
            com.opos.cmn.lockscreen.a.a(context, new b(), new ActivityResultReceiverWrapper(null, aVar));
        }
    }

    @Override // com.opos.mobad.cmn.func.adhandler.f
    public void c() {
        this.f8635a = null;
    }

    private void c(Context context, final f.a aVar) {
        if (this.b.a(context)) {
            com.opos.cmn.an.f.a.b("UnlockHandler", "isAndroid8Or9 use pictorial");
            this.b.a(new PictorialTool.a() { // from class: com.opos.mobad.cmn.func.adhandler.UnlockHandler.1
                @Override // com.opos.cmn.lockscreen.PictorialTool.a
                public void a(boolean z) {
                    f.a aVar2 = aVar;
                    if (aVar2 != null) {
                        if (z) {
                            aVar2.a();
                        } else {
                            aVar2.b();
                        }
                    }
                }
            });
        } else {
            com.opos.cmn.an.f.a.b("UnlockHandler", "isAndroid8Or9 pictorial not support");
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private static boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 && i <= 28;
    }

    @Override // com.opos.mobad.cmn.func.adhandler.f
    public void a(Context context, f.a aVar) {
        if (d()) {
            c(context, aVar);
        } else {
            d(context, aVar);
        }
    }

    @Override // com.opos.mobad.cmn.func.adhandler.f
    public void b(Context context, final f.a aVar) {
        this.b.b(new PictorialTool.a() { // from class: com.opos.mobad.cmn.func.adhandler.UnlockHandler.3
            @Override // com.opos.cmn.lockscreen.PictorialTool.a
            public void a(boolean z) {
                f.a aVar2 = aVar;
                if (aVar2 != null) {
                    if (z) {
                        aVar2.a();
                    } else {
                        aVar2.b();
                    }
                }
            }
        });
    }

    @Override // com.opos.mobad.cmn.func.adhandler.f
    public boolean a() {
        return this.b.a(this.f8635a);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.f
    public boolean b() {
        return g.a(this.f8635a);
    }
}
