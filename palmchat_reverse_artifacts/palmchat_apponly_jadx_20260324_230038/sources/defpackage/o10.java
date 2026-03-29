package defpackage;

import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class o10 extends u10 {
    public LXPortraitView r;
    public TextView s;
    public TextView t;
    public View u;

    public o10(View view) {
        super(view);
        this.u = view.findViewById(R.id.gift_layout);
        this.r = (LXPortraitView) view.findViewById(R.id.amuletHead);
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.content);
    }
}
