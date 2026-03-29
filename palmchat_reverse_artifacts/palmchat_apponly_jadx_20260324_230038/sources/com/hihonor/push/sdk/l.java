package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l {
    public static final l e = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f6459a;
    public volatile boolean b = false;
    public volatile boolean c = false;
    public s d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f6460a;
        public final /* synthetic */ HonorPushCallback b;

        public a(Runnable runnable, HonorPushCallback honorPushCallback) {
            this.f6460a = runnable;
            this.b = honorPushCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.b) {
                this.f6460a.run();
                return;
            }
            HonorPushCallback honorPushCallback = this.b;
            if (honorPushCallback != null) {
                HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
                honorPushCallback.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
            }
        }
    }

    public boolean a(Context context) {
        return HonorPushErrorEnum.SUCCESS.statusCode == b.b(context);
    }

    public Context a() {
        return this.f6459a.get();
    }

    public final void a(Runnable runnable, HonorPushCallback<?> honorPushCallback) {
        b1.a(new a(runnable, honorPushCallback));
    }
}
