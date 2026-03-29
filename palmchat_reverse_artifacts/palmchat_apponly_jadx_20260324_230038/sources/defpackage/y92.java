package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y92 extends u10 {
    public ConstraintLayout r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;

    public y92(View view) {
        super(view);
        this.r = (ConstraintLayout) view.findViewById(R.id.gift_cl_content);
        this.s = (ImageView) view.findViewById(R.id.gift_iv_image);
        this.t = (TextView) view.findViewById(R.id.gift_tv_title);
        this.u = (TextView) view.findViewById(R.id.gift_tv_content);
        this.v = (TextView) view.findViewById(R.id.gift_tv_tips);
    }
}
