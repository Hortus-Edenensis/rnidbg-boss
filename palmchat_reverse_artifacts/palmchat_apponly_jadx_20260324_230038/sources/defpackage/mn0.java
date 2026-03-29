package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LXPortraitView f19276a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public View k;
    public ViewGroup l;
    public ViewGroup m;
    public TextView n;

    public static mn0 a(View view) {
        mn0 mn0Var = new mn0();
        mn0Var.f19276a = (LXPortraitView) view.findViewById(R.id.portrait);
        mn0Var.d = (TextView) view.findViewById(R.id.nick_name);
        mn0Var.e = (TextView) view.findViewById(R.id.tv_official);
        mn0Var.f = (ImageView) view.findViewById(R.id.iv_vip);
        mn0Var.g = (TextView) view.findViewById(R.id.message);
        mn0Var.h = (TextView) view.findViewById(R.id.group_indicator);
        mn0Var.i = view.findViewById(R.id.special_attention_indicator);
        mn0Var.j = view.findViewById(R.id.group_layout);
        mn0Var.k = view.findViewById(R.id.divider);
        mn0Var.c = (TextView) view.findViewById(R.id.notification_red_dot);
        mn0Var.l = (ViewGroup) view.findViewById(R.id.single_request_layout);
        mn0Var.m = (ViewGroup) view.findViewById(R.id.multi_requests_layout);
        mn0Var.b = (ImageView) view.findViewById(R.id.contact_recommend_phone_ic);
        mn0Var.n = (TextView) view.findViewById(R.id.tv_intimacy_score);
        return mn0Var;
    }
}
