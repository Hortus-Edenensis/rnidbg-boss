package defpackage;

import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class lx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f19096a;
    public View b;
    public View c;

    public static lx3 a(View view) {
        lx3 lx3Var = new lx3();
        lx3Var.b = view.findViewById(R.id.normal);
        lx3Var.c = view.findViewById(R.id.empty);
        lx3Var.f19096a = view;
        return lx3Var;
    }
}
