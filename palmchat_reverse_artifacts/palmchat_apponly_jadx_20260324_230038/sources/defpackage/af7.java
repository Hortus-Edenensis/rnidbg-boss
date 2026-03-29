package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class af7 {
    public static volatile af7 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cd7 f1221a;

    public af7(@NonNull Context context) {
        this.f1221a = new cd7(context);
    }

    public static af7 a(Context context) {
        if (b == null) {
            synchronized (af7.class) {
                if (b == null) {
                    b = new af7(context);
                }
            }
        }
        return b;
    }

    public void b() {
        this.f1221a.c();
    }
}
