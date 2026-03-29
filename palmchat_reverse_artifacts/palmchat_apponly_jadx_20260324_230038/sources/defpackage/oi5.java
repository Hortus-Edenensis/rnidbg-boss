package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oi5 extends u10 {
    public View r;
    public TextView s;
    public TextView t;
    public EffectiveShapeView u;
    public ImageView v;

    public oi5(View view) {
        super(view);
        this.r = view.findViewById(R.id.feed_card_layout);
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.location);
        this.u = (EffectiveShapeView) view.findViewById(R.id.image);
        this.v = (ImageView) view.findViewById(R.id.iv_video_icon);
    }
}
