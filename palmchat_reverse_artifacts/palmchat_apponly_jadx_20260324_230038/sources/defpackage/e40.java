package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e40 extends u10 {
    public View r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;

    public e40(View view) {
        super(view);
        this.r = view.findViewById(R.id.gift_tip_layout);
        this.s = (ImageView) view.findViewById(R.id.iv_bg);
        this.t = (TextView) view.findViewById(R.id.tv_title);
        this.u = (TextView) view.findViewById(R.id.tv_content);
        this.v = (TextView) view.findViewById(R.id.btn_send);
    }
}
