package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wifi.ad.core.feedbanner.ClearLogoNativeAdContainer;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayoutLine;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a6 extends u10 {
    public FrameLayout A;
    public EffectiveShapeView B;
    public ImageView C;
    public TextView D;
    public AdComInfoAllLayoutLine E;
    public VisibleDetectView F;
    public ShakeView G;
    public ClearLogoNativeAdContainer r;
    public FrameLayout s;
    public View t;
    public FrameLayout u;
    public TextView v;
    public TextView w;
    public LinearLayout x;
    public TextView y;
    public FrameLayout z;

    public a6(Context context, View view) {
        super(view);
        try {
            this.t = view;
            this.r = (ClearLogoNativeAdContainer) view.findViewById(R.id.native_ad_container);
            this.s = (FrameLayout) view.findViewById(R.id.template_ad_container);
            this.u = (FrameLayout) view.findViewById(R.id.ad_icon_container);
            this.v = (TextView) view.findViewById(R.id.ad_app_name);
            this.w = (TextView) view.findViewById(R.id.ad_info);
            this.x = (LinearLayout) view.findViewById(R.id.ad_drop);
            this.y = (TextView) view.findViewById(R.id.ad_sign);
            this.z = (FrameLayout) view.findViewById(R.id.ad_video_wrapper);
            this.A = (FrameLayout) view.findViewById(R.id.ad_video);
            this.B = (EffectiveShapeView) view.findViewById(R.id.ad_img);
            this.C = (ImageView) view.findViewById(R.id.ad_logo);
            this.D = (TextView) view.findViewById(R.id.ad_action);
            this.F = (VisibleDetectView) view.findViewById(R.id.visible_detect);
            this.G = (ShakeView) view.findViewById(R.id.shake);
            this.E = (AdComInfoAllLayoutLine) view.findViewById(R.id.ad_com_info_layout);
        } catch (Exception unused) {
        }
    }

    @Override // defpackage.u10
    public boolean f() {
        return false;
    }
}
