package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.SocialPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SocialPortraitView f21933a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public LinearLayout i;
    public ImageView j;

    public static xd2 a(View view) {
        xd2 xd2Var = new xd2();
        xd2Var.f21933a = (SocialPortraitView) view.findViewById(R.id.portrait);
        xd2Var.b = (TextView) view.findViewById(R.id.first_name);
        xd2Var.c = (TextView) view.findViewById(R.id.name);
        xd2Var.d = (TextView) view.findViewById(R.id.content);
        xd2Var.e = (TextView) view.findViewById(R.id.group_indicator);
        xd2Var.h = view.findViewById(R.id.divider);
        xd2Var.f = view.findViewById(R.id.btn_check);
        xd2Var.g = view.findViewById(R.id.iv_next);
        xd2Var.i = (LinearLayout) view.findViewById(R.id.lyt_word_title);
        xd2Var.j = (ImageView) view.findViewById(R.id.iv_vip);
        xd2Var.f21933a.changeShapeType(3);
        return xd2Var;
    }
}
