package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.qd3;
import defpackage.s7;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdBigImageView extends AdView {
    private static final String TAG = "AdBigImageView";
    private ImageView adImageView;

    public AdBigImageView(@NonNull Context context) {
        super(context);
        initView();
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void initView() {
        this.rootView = View.inflate(this.mContext, R$layout.layout_ad_big_image_widget, this);
        super.initView();
        this.adImageView = (ImageView) this.rootView.findViewById(R$id.ad_image);
    }

    @Override // com.zenmen.palmchat.ad.view.AdView
    public void setData(s7 s7Var) {
        qd3 qd3VarN;
        List<String> listE;
        super.setData(s7Var);
        if (s7Var == null || (qd3VarN = s7Var.n()) == null || (listE = qd3VarN.e()) == null || listE.size() == 0) {
            return;
        }
        gr2.j().h(listE.get(0), this.adImageView, AdView.getDisplayImageOptions());
        LogUtil.d(TAG, "setData title = " + qd3VarN.i() + ", imgurl = " + listE.get(0));
    }

    public AdBigImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AdBigImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
