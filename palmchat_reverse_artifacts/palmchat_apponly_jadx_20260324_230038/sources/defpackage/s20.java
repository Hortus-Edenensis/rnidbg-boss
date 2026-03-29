package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.SocialPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class s20 extends u10 {
    public TextView A;
    public View B;
    public TextView C;
    public TextView D;
    public TextView E;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public ImageView v;
    public TextView w;
    public View x;
    public TextView y;
    public SocialPortraitView z;

    public s20(View view) {
        super(view);
        this.r = view.findViewById(R.id.ll_gift_content);
        this.s = (TextView) view.findViewById(R.id.tv_gift_title);
        this.t = (TextView) view.findViewById(R.id.tv_sub_title);
        this.u = (TextView) view.findViewById(R.id.tv_action);
        this.v = (ImageView) view.findViewById(R.id.iv_gift_icon);
        this.w = (TextView) view.findViewById(R.id.tv_vip_tag);
        this.x = view.findViewById(R.id.layout_tv_gift_title);
        this.y = (TextView) view.findViewById(R.id.tv_gift_title_group_1);
        SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.iv_gift_receiver_head);
        this.z = socialPortraitView;
        socialPortraitView.changeShapeType(1);
        this.A = (TextView) view.findViewById(R.id.tv_gift_title_group_2);
        this.B = view.findViewById(R.id.gift_thx_tip_layout);
        this.C = (TextView) view.findViewById(R.id.tv_thx_title);
        this.D = (TextView) view.findViewById(R.id.tv_thx_content);
        this.E = (TextView) view.findViewById(R.id.btn_thx_send);
    }
}
