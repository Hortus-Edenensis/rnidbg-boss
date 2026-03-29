package com.zenmen.palmchat.modulemanager;

import android.util.Log;
import defpackage.ir5;
import defpackage.vw5;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TaskExecutorHelper {
    public static final String TAG = "LXINIT_TaskExecutor";
    private static ExecutorService executor;

    private static ExecutorService getExecutor() {
        if (executor == null) {
            executor = vw5.a("InitExecutor");
        }
        return executor;
    }

    public static void safeRun(final String str, final Runnable runnable) {
        getExecutor().submit(new Runnable() { // from class: com.zenmen.palmchat.modulemanager.TaskExecutorHelper.1
            @Override // java.lang.Runnable
            public void run() {
                long jB = ir5.b();
                try {
                    runnable.run();
                } catch (Throwable th) {
                    th.printStackTrace();
                    InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ASYNCEXECUTE + str, th);
                }
                Log.d(TaskExecutorHelper.TAG, "tag=" + str + " init cost" + ir5.e(jB));
            }
        });
    }
}
