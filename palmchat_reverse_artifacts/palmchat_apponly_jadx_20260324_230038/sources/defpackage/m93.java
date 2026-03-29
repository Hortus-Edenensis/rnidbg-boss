package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m93 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19169a;
    public Runnable b;
    public boolean c;
    public Handler d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m93.this.c = false;
        }
    }

    public m93(@NonNull Context context) {
        super(context, R.style.LoveMatchDialog);
        this.f19169a = false;
        this.c = false;
        this.d = new Handler(Looper.getMainLooper());
        setCancelable(false);
    }

    public void b(Runnable runnable) {
        if (!this.f19169a) {
            this.b = runnable;
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public boolean c() {
        return this.c;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f19169a = true;
        this.c = true;
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
            this.b = null;
        }
        this.d.postDelayed(new a(), 300L);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.f19169a = false;
    }
}
