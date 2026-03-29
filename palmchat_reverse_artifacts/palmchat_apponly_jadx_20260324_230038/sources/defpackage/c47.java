package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c47 extends AsyncTask<Context, Integer, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1892a = "c47";
    public static volatile boolean b = false;

    @SuppressLint({"NewApi"})
    public static void b() {
        if (e()) {
            ga7.e(f1892a, "checkUpgradeBks, execute check task");
            new c47().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, wp0.a());
        }
    }

    public static boolean e() {
        if (b) {
            return false;
        }
        Context contextA = wp0.a();
        if (contextA == null) {
            ga7.f(f1892a, "checkUpgradeBks, context is null");
            return false;
        }
        b = true;
        long jA = qd7.a("lastCheckTime", 0L, contextA);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > 432000000) {
            qd7.d("lastCheckTime", jCurrentTimeMillis, contextA);
            return true;
        }
        ga7.e(f1892a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStreamM;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            inputStreamM = zt.m(contextArr[0]);
        } catch (Exception e) {
            ga7.d(f1892a, "doInBackground: exception : " + e.getMessage());
            inputStreamM = null;
        }
        ga7.b(f1892a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        if (inputStreamM == null) {
            return Boolean.FALSE;
        }
        e87.b(inputStreamM);
        return Boolean.TRUE;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            ga7.e(f1892a, "onPostExecute: upate done");
        } else {
            ga7.d(f1892a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        ga7.e(f1892a, "onProgressUpdate");
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        ga7.b(f1892a, "onPreExecute");
    }
}
