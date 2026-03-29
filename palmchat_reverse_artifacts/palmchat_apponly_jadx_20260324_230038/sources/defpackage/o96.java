package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.VenusPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o96 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public VenusPortraitView x;
    public TextView y;

    public o96(View view) {
        super(view);
        this.r = view.findViewById(R.id.feed_card_layout);
        this.s = (TextView) view.findViewById(R.id.venus_title);
        this.t = (TextView) view.findViewById(R.id.venus_title_before);
        this.u = (TextView) view.findViewById(R.id.venus_title_after);
        this.v = (TextView) view.findViewById(R.id.venus_subtitle);
        this.x = (VenusPortraitView) view.findViewById(R.id.venus_portrait);
        this.w = (TextView) view.findViewById(R.id.venus_btn);
        this.y = (TextView) view.findViewById(R.id.venus_source);
    }
}
