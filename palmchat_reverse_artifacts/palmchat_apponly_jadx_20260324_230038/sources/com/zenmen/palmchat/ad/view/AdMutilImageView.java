package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class AdMutilImageView extends AdView {
    private static final String TAG = "AdMutilImageView";
    private ImageView adImageView1;
    private ImageView adImageView2;
    private ImageView adImageView3;

    public AdMutilImageView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void initView() {
        this.rootView = View.inflate(this.mContext, R$layout.layout_ad_mutil_image_widget, this);
        super.initView();
        this.adImageView1 = (ImageView) this.rootView.findViewById(R$id.ad_image1);
        this.adImageView2 = (ImageView) this.rootView.findViewById(R$id.ad_image2);
        this.adImageView3 = (ImageView) this.rootView.findViewById(R$id.ad_image3);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void setData(s7 s7Var) {
        List<String> listE;
        super.setData(s7Var);
        if (s7Var != null) {
            qd3 qd3VarN = s7Var.n();
            Point pointC = a7.c(s7Var, 1);
            ViewGroup.LayoutParams layoutParams = this.adImageView1.getLayoutParams();
            layoutParams.width = pointC.x;
            layoutParams.height = pointC.y;
            this.adImageView1.setLayoutParams(layoutParams);
            this.adImageView2.setLayoutParams(layoutParams);
            this.adImageView3.setLayoutParams(layoutParams);
            if (qd3VarN == null || (listE = qd3VarN.e()) == null || listE.size() < 2) {
                return;
            }
            gr2.j().h(listE.get(0), this.adImageView1, AdView.getDisplayImageOptions());
            gr2.j().h(listE.get(1), this.adImageView2, AdView.getDisplayImageOptions());
            gr2.j().h(listE.get(2), this.adImageView3, AdView.getDisplayImageOptions());
            LogUtil.d(TAG, "setData title = " + qd3VarN.i() + ", imgurl1 = " + listE.get(0) + ", url2 = " + listE.get(1) + ", url3 = " + listE.get(2));
        }
    }

    public AdMutilImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AdMutilImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
