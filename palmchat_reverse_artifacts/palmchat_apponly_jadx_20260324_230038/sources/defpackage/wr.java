package defpackage;

import android.os.AsyncTask;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class wr<Params, Progress, T> extends AsyncTask<Params, Progress, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pt5<T> f21783a;
    public String b;

    public wr(pt5<T> pt5Var, String str) {
        this.f21783a = pt5Var;
        this.b = str;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(T t) {
        super.onPostExecute(t);
        pt5<T> pt5Var = this.f21783a;
        if (pt5Var != null) {
            pt5Var.onPostExecute(t);
            this.f21783a = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        pt5<T> pt5Var = this.f21783a;
        if (pt5Var != null) {
            pt5Var.onPreExecute(TextUtils.isEmpty(this.b) ? wr.class.getSimpleName() : this.b);
        }
    }
}
