package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ty5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Toast f21094a;
    public static Object b = new Object();

    public static Context a() {
        return AppContext.getContext();
    }

    public static Toast b(Context context, int i, int i2) {
        return c(context, context.getString(i), i2);
    }

    public static Toast c(Context context, String str, int i) {
        View viewInflate = LayoutInflater.from(a()).inflate(R.layout.manychats_layout_toast_view, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.manychats_toast_content)).setText(str);
        Toast toast = new Toast(context);
        f21094a = toast;
        toast.setGravity(17, 0, 80);
        f21094a.setDuration(1);
        f21094a.setView(viewInflate);
        f21094a.setDuration(i);
        sy5.c(f21094a);
        return f21094a;
    }

    public static Toast d(Context context, int i, int i2) {
        View viewInflate = LayoutInflater.from(a()).inflate(R.layout.manychats_layout_toast_view, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.manychats_toast_content)).setText(i);
        Toast toast = new Toast(context);
        f21094a = toast;
        toast.setGravity(81, 0, 80);
        f21094a.setDuration(1);
        f21094a.setView(viewInflate);
        f21094a.setDuration(i2);
        sy5.c(f21094a);
        return f21094a;
    }

    public static Toast e(Context context, CharSequence charSequence, int i) {
        View viewInflate = LayoutInflater.from(a()).inflate(R.layout.manychats_layout_toast_view, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.manychats_toast_content)).setText(charSequence);
        Toast toast = new Toast(context);
        f21094a = toast;
        toast.setGravity(81, 0, 80);
        f21094a.setDuration(1);
        f21094a.setView(viewInflate);
        f21094a.setDuration(i);
        sy5.c(f21094a);
        return f21094a;
    }
}
