package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f18053a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;

    public static hu1 a(View view) {
        hu1 hu1Var = new hu1();
        hu1Var.f18053a = (ImageView) view.findViewById(R.id.thumb_image);
        hu1Var.c = (TextView) view.findViewById(R.id.thumb_text);
        hu1Var.d = (TextView) view.findViewById(R.id.title_text);
        hu1Var.e = (TextView) view.findViewById(R.id.sub_title_text);
        hu1Var.b = view.findViewById(R.id.btn_check);
        return hu1Var;
    }
}
