package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i7 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;

    public i7(View view) {
        super(view);
        this.r = view.findViewById(R.id.agree_friend_request_layout);
        this.s = (TextView) view.findViewById(R.id.tv_agree_friend_request);
        this.t = (TextView) view.findViewById(R.id.tv_add_friend);
        this.u = (TextView) view.findViewById(R.id.tv_already_apply);
        this.v = (TextView) view.findViewById(R.id.tv_already_is_friend);
        this.w = (TextView) view.findViewById(R.id.message);
    }
}
