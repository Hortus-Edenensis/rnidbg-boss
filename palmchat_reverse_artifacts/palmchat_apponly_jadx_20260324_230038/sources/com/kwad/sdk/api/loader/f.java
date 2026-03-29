package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f ayk;
    private Thread.UncaughtExceptionHandler ayl;
    private int aym;
    private long ayo;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean ayn = new AtomicBoolean();

    private f(Context context) {
        this.mContext = context;
    }

    public static f bf(Context context) {
        if (ayk == null) {
            synchronized (f.class) {
                if (ayk == null) {
                    ayk = new f(context);
                }
            }
        }
        return ayk;
    }

    public final void cH(int i) {
        this.ayo = System.currentTimeMillis();
        this.aym = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.ayn.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.ayl = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.ayo + ",mMaxDuration:" + this.aym + ",mIsCancel:" + this.ayn.get());
            }
            if (!this.ayn.get() && this.ayo > 0 && System.currentTimeMillis() - this.ayo <= this.aym) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.g("filterStack", th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && zBooleanValue) {
                    b.a(context, i.ays, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.ayl;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.ayl;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.ayl != null) {
                    this.ayl.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
