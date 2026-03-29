package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v20 extends u10 {
    public View A;
    public TextView B;
    public View C;
    public EffectiveShapeView D;
    public EffectiveShapeView E;
    public EffectiveShapeView F;
    public View r;
    public View s;
    public TextView t;
    public View u;
    public TextView v;
    public View w;
    public EffectiveShapeView x;
    public ImageView y;
    public TextView z;

    public v20(View view) {
        super(view);
        this.r = view.findViewById(R.id.guide_container);
        this.s = view.findViewById(R.id.style1_container);
        this.t = (TextView) view.findViewById(R.id.tv_content1);
        this.u = view.findViewById(R.id.style2_container);
        this.v = (TextView) view.findViewById(R.id.tv_content2);
        this.w = view.findViewById(R.id.style2_icon_container);
        this.x = (EffectiveShapeView) view.findViewById(R.id.iv_style2_feed_thumb);
        this.y = (ImageView) view.findViewById(R.id.iv_video_icon);
        this.z = (TextView) view.findViewById(R.id.tv_style2title);
        this.A = view.findViewById(R.id.style3_container);
        this.B = (TextView) view.findViewById(R.id.tv_content3);
        this.C = view.findViewById(R.id.style3_icon_container);
        this.D = (EffectiveShapeView) view.findViewById(R.id.iv_style3_pic_thumb1);
        this.E = (EffectiveShapeView) view.findViewById(R.id.iv_style3_pic_thumb2);
        this.F = (EffectiveShapeView) view.findViewById(R.id.iv_style3_pic_thumb3);
    }
}
