package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.n.nr;
import com.bytedance.sdk.openadsdk.res.pn;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void u(bc bcVar) {
        String strValueOf;
        if (bcVar == null) {
            return;
        }
        Context context = getContext();
        addView(pn.pb(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(y.fx(context, 12.0f));
            tTRatingBar.setStarImageHeight(y.fx(context, 12.0f));
            tTRatingBar.setStarImagePadding(y.fx(context, 4.0f));
            tTRatingBar.u();
        }
        if (textView4 != null) {
            int iIz = bcVar.pu() != null ? bcVar.pu().iz() : 6870;
            String strU = q.u(context, "tt_comment_num");
            if (iIz > 10000) {
                strValueOf = (iIz / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iIz);
            }
            textView4.setText(String.format(strU, strValueOf));
        }
        if (tTRoundRectImageView != null) {
            rh rhVarDd = bcVar.dd();
            if (rhVarDd == null || TextUtils.isEmpty(rhVarDd.u())) {
                q.u(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            } else {
                nr.u(rhVarDd).to(tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(jp.bg(bcVar));
        }
        if (textView2 != null) {
            textView2.setText(jp.bq(bcVar));
        }
        if (textView3 != null) {
            textView3.setText(TextUtils.isEmpty(bcVar.yb()) ? bcVar.qf() != 4 ? "查看详情" : "立即下载" : bcVar.yb());
        }
    }
}
