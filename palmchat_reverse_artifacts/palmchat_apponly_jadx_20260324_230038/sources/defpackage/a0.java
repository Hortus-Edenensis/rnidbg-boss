package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f1126a;
    public Intent b;
    public Bundle c;

    public a0(Activity activity) {
        this.f1126a = c(activity);
    }

    public static a0 d(@NonNull Activity activity) {
        return new a0(activity);
    }

    public Fragment a(Activity activity) {
        return activity.getFragmentManager().findFragmentByTag("ActivityResult");
    }

    public void b(@Nullable c0 c0Var) {
        this.f1126a.a(c0Var);
        f();
    }

    public final b0 c(Activity activity) {
        Fragment fragmentA = a(activity);
        if (fragmentA == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentA = new b0();
            fragmentManager.beginTransaction().add(fragmentA, "ActivityResult").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (b0) fragmentA;
    }

    public a0 e(Intent intent) {
        this.b = intent;
        return this;
    }

    public void f() {
        Intent intent = this.b;
        if (intent != null) {
            this.f1126a.startActivityForResult(intent, 10086, this.c);
        }
    }
}
