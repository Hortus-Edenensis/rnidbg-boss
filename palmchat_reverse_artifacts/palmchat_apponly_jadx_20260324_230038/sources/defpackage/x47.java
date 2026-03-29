package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.heytap.msp.opos.sv.api.params.ErrorCode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class x47<T> {
    public static Handler sMainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m67 f21876a;
        public final /* synthetic */ String b;

        public a(m67 m67Var, String str) {
            this.f21876a = m67Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            x47.this.onFailure(this.f21876a.c, this.b);
            x47.this.onAfter();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21877a;

        public b(Object obj) {
            this.f21877a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            x47.this.onResponse(this.f21877a);
            x47.this.onAfter();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c extends x47<String> {
        @Override // defpackage.x47
        public String onParseResponse(String str) {
            return str;
        }
    }

    public abstract void onAfter();

    public void onError(m67 m67Var) {
        String string;
        if (!TextUtils.isEmpty(m67Var.f19147a)) {
            string = m67Var.f19147a;
        } else if (TextUtils.isEmpty(m67Var.b)) {
            Exception exc = m67Var.d;
            string = exc != null ? exc.toString() : ErrorCode.ERROR_MSG_UNKNOWN_ERROR;
        } else {
            string = m67Var.b;
        }
        sMainHandler.post(new a(m67Var, string));
    }

    public abstract void onFailure(int i, String str);

    public abstract T onParseResponse(String str);

    public abstract void onResponse(T t);

    public void onSuccess(m67 m67Var) {
        sMainHandler.post(new b(onParseResponse(m67Var.f19147a)));
    }
}
