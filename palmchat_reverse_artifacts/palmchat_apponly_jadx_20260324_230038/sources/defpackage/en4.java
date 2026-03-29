package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class en4 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public ImageView w;

    public en4(View view) {
        super(view);
        this.r = view.findViewById(R.id.ll_gift_content);
        this.s = (TextView) view.findViewById(R.id.tv_gift_name);
        this.t = (TextView) view.findViewById(R.id.tv_sub_title);
        this.u = (TextView) view.findViewById(R.id.tv_sub_btn);
        this.v = (TextView) view.findViewById(R.id.tv_desc);
        this.w = (ImageView) view.findViewById(R.id.iv_icon);
    }
}
