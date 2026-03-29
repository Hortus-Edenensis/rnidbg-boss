package defpackage;

import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f18848a;
    public View b;
    public View c;

    public static kx3 a(View view) {
        kx3 kx3Var = new kx3();
        kx3Var.b = view.findViewById(R.id.more);
        kx3Var.c = view.findViewById(R.id.arrow);
        kx3Var.f18848a = view;
        return kx3Var;
    }
}
