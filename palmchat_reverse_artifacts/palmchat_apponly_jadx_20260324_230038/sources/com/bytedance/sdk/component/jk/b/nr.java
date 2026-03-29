package com.bytedance.sdk.component.jk.b;

import android.os.AsyncTask;
import com.bytedance.sdk.component.jk.jk;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static Executor u = new b(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new jk("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> u(Params... paramsArr) {
        return executeOnExecutor(u, paramsArr);
    }
}
