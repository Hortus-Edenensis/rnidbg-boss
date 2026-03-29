package com.ss.android.downloadlib.x;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    static final u u = new C0851nr();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.x.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(11)
    public static class C0851nr extends u {
        private C0851nr() {
            super();
        }

        @Override // com.ss.android.downloadlib.x.nr.u
        public <T> void u(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private u() {
        }

        public <T> void u(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.jk.b.nr.u, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void u(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        u.u(asyncTask, tArr);
    }
}
