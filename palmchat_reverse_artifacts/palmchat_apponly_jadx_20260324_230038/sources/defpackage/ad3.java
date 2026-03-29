package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.location.LocationEx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface ad3 {
    ed3 a(int i, LocationEx locationEx);

    void b(LocationEx locationEx, long j);

    void c(float f, LocationEx locationEx);

    ed3 d(int i, LocationEx locationEx, float f, float f2, float f3);

    ed3 e(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3, sc3 sc3Var);

    View f(Context context);

    void g(boolean z);

    void h(LocationEx locationEx);

    void i(ed3 ed3Var, LocationEx locationEx);

    void j(d74 d74Var);

    void k(yi0 yi0Var);

    void l(LocationEx locationEx);

    void m(xi0 xi0Var);

    void n(boolean z);

    void o(ed3 ed3Var);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    View p();

    ed3 q(Bitmap bitmap, LocationEx locationEx, float f, float f2, float f3);
}
