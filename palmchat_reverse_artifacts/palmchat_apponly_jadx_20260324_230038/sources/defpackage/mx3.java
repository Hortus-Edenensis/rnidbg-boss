package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.SocialPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SocialPortraitView f19386a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public View f;
    public View g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public TextView k;

    public static mx3 a(View view) {
        mx3 mx3Var = new mx3();
        mx3Var.f19386a = (SocialPortraitView) view.findViewById(R.id.portrait);
        mx3Var.b = (TextView) view.findViewById(R.id.friend_name);
        mx3Var.c = (TextView) view.findViewById(R.id.friend_info);
        mx3Var.d = (TextView) view.findViewById(R.id.confirm_button);
        mx3Var.e = (ImageView) view.findViewById(R.id.contact_recommend_phone_ic);
        mx3Var.f = view.findViewById(R.id.background);
        mx3Var.g = view.findViewById(R.id.gap);
        mx3Var.h = (ImageView) view.findViewById(R.id.contact_icon);
        mx3Var.i = (ImageView) view.findViewById(R.id.car_image);
        mx3Var.k = (TextView) view.findViewById(R.id.tv_official);
        mx3Var.j = (ImageView) view.findViewById(R.id.iv_vip);
        return mx3Var;
    }
}
