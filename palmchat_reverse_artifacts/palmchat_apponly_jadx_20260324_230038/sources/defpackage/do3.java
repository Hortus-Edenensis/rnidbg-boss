package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class do3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f17104a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public ImageView g;

    public static do3 a(View view) {
        do3 do3Var = new do3();
        do3Var.f17104a = (ImageView) view.findViewById(R.id.icon);
        do3Var.c = (TextView) view.findViewById(R.id.title);
        do3Var.d = (TextView) view.findViewById(R.id.message);
        do3Var.e = (TextView) view.findViewById(R.id.date);
        do3Var.b = (TextView) view.findViewById(R.id.notification_red_dot);
        do3Var.f = view.findViewById(R.id.notification_red_dot_nodisturb);
        do3Var.g = (ImageView) view.findViewById(R.id.disturbIv);
        return do3Var;
    }
}
