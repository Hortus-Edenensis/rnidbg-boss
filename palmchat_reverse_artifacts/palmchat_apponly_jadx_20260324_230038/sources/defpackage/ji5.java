package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ji5 extends u10 {
    public View r;
    public TextView s;
    public EffectiveShapeView t;
    public ImageView u;

    public ji5(View view) {
        super(view);
        this.r = view.findViewById(R.id.feed_card_layout);
        this.s = (TextView) view.findViewById(R.id.tv_feed_content);
        this.t = (EffectiveShapeView) view.findViewById(R.id.iv_feed_thumb);
        this.u = (ImageView) view.findViewById(R.id.iv_video_icon);
    }
}
