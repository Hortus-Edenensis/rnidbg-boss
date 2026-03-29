package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class q20 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public TextView w;
    public ImageView x;
    public TextView y;

    public q20(View view) {
        super(view);
        this.r = view.findViewById(R.id.gift_layout);
        this.s = (TextView) view.findViewById(R.id.tv_title);
        this.t = (TextView) view.findViewById(R.id.tv_desc);
        this.x = (ImageView) view.findViewById(R.id.iv_flower);
        this.u = (ImageView) view.findViewById(R.id.iv_card_bg);
        this.v = (ImageView) view.findViewById(R.id.iv_btn_bg);
        this.w = (TextView) view.findViewById(R.id.iv_btn_text);
        this.y = (TextView) view.findViewById(R.id.tv_price);
    }
}
