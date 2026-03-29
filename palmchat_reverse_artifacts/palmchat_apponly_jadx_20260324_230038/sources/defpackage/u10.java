package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class u10 extends od5 {
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public LXPortraitView i;
    public View j;
    public ImageView k;
    public ImageView l;
    public View m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;

    public u10(View view) {
        this.e = (TextView) view.findViewById(R.id.time);
        this.f = view.findViewById(R.id.audio_read);
        this.c = (TextView) view.findViewById(R.id.name);
        this.g = view.findViewById(R.id.status_fail);
        this.h = view.findViewById(R.id.status_pending);
        this.i = (LXPortraitView) view.findViewById(R.id.portrait);
        this.j = view.findViewById(R.id.message_area);
        this.k = (ImageView) view.findViewById(R.id.multi_choice);
        this.m = view.findViewById(R.id.chat_unread_sep);
        this.d = (TextView) view.findViewById(R.id.name_role_type);
        this.l = (ImageView) view.findViewById(R.id.iv_vip);
        this.n = view.findViewById(R.id.pay_receiver_des_layout);
        this.o = (TextView) view.findViewById(R.id.pay_receiver_des);
        this.p = (TextView) view.findViewById(R.id.pay_sender_des);
        this.q = (TextView) view.findViewById(R.id.status_fail_TV);
    }

    public ImageView d() {
        return null;
    }

    public SeekBar e() {
        return null;
    }

    public boolean f() {
        return true;
    }
}
