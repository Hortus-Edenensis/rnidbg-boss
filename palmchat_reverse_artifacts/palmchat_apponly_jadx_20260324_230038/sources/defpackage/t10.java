package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t10 extends u10 {
    public TextView A;
    public TextView B;
    public View r;
    public View s;
    public TextView t;
    public TextView u;
    public View v;
    public TextView w;
    public TextView x;
    public View y;
    public TextView z;

    public t10(View view) {
        super(view);
        this.r = view.findViewById(R.id.ll_container);
        this.s = view.findViewById(R.id.ll_content1_container);
        this.t = (TextView) view.findViewById(R.id.tv_content1);
        this.u = (TextView) view.findViewById(R.id.tv_send1);
        this.v = view.findViewById(R.id.ll_content2_container);
        this.w = (TextView) view.findViewById(R.id.tv_content2);
        this.x = (TextView) view.findViewById(R.id.tv_send2);
        this.y = view.findViewById(R.id.ll_content3_container);
        this.z = (TextView) view.findViewById(R.id.tv_content3);
        this.A = (TextView) view.findViewById(R.id.tv_send3);
        this.B = (TextView) view.findViewById(R.id.tv_refresh);
    }
}
