package defpackage;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tf6 {
    public static void a(int i, View... viewArr) {
        for (View view : viewArr) {
            if (view.getVisibility() != i) {
                view.setVisibility(i);
            }
        }
    }
}
