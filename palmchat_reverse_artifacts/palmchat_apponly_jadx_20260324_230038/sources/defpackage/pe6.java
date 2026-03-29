package defpackage;

import android.content.Context;
import androidx.annotation.ColorRes;
import com.zenmen.palmchat.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class pe6 {
    public static int a(@ColorRes int i) {
        return c.b().getResources().getColor(i);
    }

    public static int b(Context context, @ColorRes int i) {
        return context.getResources().getColor(i);
    }
}
