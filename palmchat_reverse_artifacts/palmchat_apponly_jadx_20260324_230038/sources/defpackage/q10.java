package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q10 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public LXPortraitView w;

    public q10(View view) {
        super(view);
        this.r = view.findViewById(R.id.ll_gift_content);
        this.s = (TextView) view.findViewById(R.id.tv_gift_title);
        this.t = (TextView) view.findViewById(R.id.tv_sub_title);
        this.u = (TextView) view.findViewById(R.id.tv_action);
        this.v = (TextView) view.findViewById(R.id.tv_action2);
        this.w = (LXPortraitView) view.findViewById(R.id.iv_gift_icon);
    }
}
