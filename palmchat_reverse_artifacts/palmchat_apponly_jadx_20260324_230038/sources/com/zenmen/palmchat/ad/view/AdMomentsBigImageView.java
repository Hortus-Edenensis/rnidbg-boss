package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a7;
import defpackage.gr2;
import defpackage.qd3;
import defpackage.s7;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdMomentsBigImageView extends AdView {
    private static final String TAG = "AdBigImageView";
    private ImageView adImageView;
    private TextView adShowMore;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdMomentsBigImageView.this.onMomentsExtraClick(7);
        }
    }

    public AdMomentsBigImageView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void initView() {
        this.rootView = View.inflate(this.mContext, R$layout.layout_ad_moments_big_image_widget, this);
        super.initView();
        this.adImageView = (ImageView) this.rootView.findViewById(R$id.ad_image);
        this.adShowMore = (TextView) this.rootView.findViewById(R$id.ad_show_more);
        Point pointB = a7.b(103, 2);
        ViewGroup.LayoutParams layoutParams = this.adImageView.getLayoutParams();
        layoutParams.width = pointB.x;
        layoutParams.height = pointB.y;
        this.adImageView.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void setData(s7 s7Var) {
        List<String> listE;
        super.setData(s7Var);
        if (s7Var != null) {
            qd3 qd3VarN = s7Var.n();
            if (qd3VarN != null && (listE = qd3VarN.e()) != null && listE.size() != 0) {
                gr2.j().h(listE.get(0), this.adImageView, AdView.getDisplayImageOptions());
                LogUtil.d(TAG, "setData title = " + qd3VarN.i() + ", imgurl = " + listE.get(0));
            }
            if (!s7Var.C()) {
                this.adShowMore.setVisibility(8);
            } else {
                this.adShowMore.setVisibility(0);
                this.adShowMore.setOnClickListener(new a());
            }
        }
    }

    public AdMomentsBigImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AdMomentsBigImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
