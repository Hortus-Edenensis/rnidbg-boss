package defpackage;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.palmchat.widget.RhythmView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LXPortraitView f20597a;
    public TextView b;
    public TextView c;
    public RhythmView d;
    public TextView e;
    public TextView f;
    public View g;
    public ImageView h;
    public TextView i;
    public LinearLayout j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public ImageView p;

    public static rw5 a(View view) {
        rw5 rw5Var = new rw5();
        rw5Var.f20597a = (LXPortraitView) view.findViewById(R.id.icon);
        rw5Var.c = (TextView) view.findViewById(R.id.title);
        RhythmView rhythmView = (RhythmView) view.findViewById(R.id.rhy_view);
        rw5Var.d = rhythmView;
        rhythmView.setCandidate(new int[]{8, 14, 6}).setRoundRadius(2.0f).setColor(Color.parseColor("#ff463c")).setStripe(1.5f, 14.0f, 3.0f).setFreq(30L).setMinHeight(6.0f).setMaxHeight(14.0f).init();
        rw5Var.e = (TextView) view.findViewById(R.id.message);
        rw5Var.f = (TextView) view.findViewById(R.id.date);
        rw5Var.b = (TextView) view.findViewById(R.id.notification_red_dot);
        rw5Var.g = view.findViewById(R.id.notification_red_dot_nodisturb);
        rw5Var.h = (ImageView) view.findViewById(R.id.disturbIv);
        rw5Var.i = (TextView) view.findViewById(R.id.additionMessage);
        rw5Var.j = (LinearLayout) view.findViewById(R.id.message_area);
        rw5Var.k = (ImageView) view.findViewById(R.id.iv_temp_chat);
        rw5Var.l = (ImageView) view.findViewById(R.id.iv_super_greetings);
        rw5Var.m = (TextView) view.findViewById(R.id.tv_official);
        rw5Var.n = (ImageView) view.findViewById(R.id.iv_vip);
        rw5Var.p = (ImageView) view.findViewById(R.id.iv_ai_chat);
        rw5Var.o = (ImageView) view.findViewById(R.id.iv_conversation_specialattention);
        return rw5Var;
    }
}
