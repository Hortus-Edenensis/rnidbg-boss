package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.utils.bc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSSplashLabelView extends PPSLabelView {
    public PPSSplashLabelView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (adSource == null) {
            fh.V("PPSSplashLabelView", "adSource is null");
            setClick(spannableStringBuilder);
            return;
        }
        String strV = bc.V(adSource.Code()) == null ? "" : bc.V(adSource.Code());
        if (str == null) {
            str = "";
        }
        String str2 = strV + str;
        String strV2 = adSource.V();
        if (TextUtils.isEmpty(strV) && TextUtils.isEmpty(strV2)) {
            setClick(spannableStringBuilder);
        } else if (TextUtils.isEmpty(strV) || !TextUtils.isEmpty(strV2)) {
            Code(str2, strV2);
        } else {
            setClick(new SpannableStringBuilder(str2));
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void setTextWhenImgLoadFail(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        setClick(spannableStringBuilder);
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void Code(AdSource adSource, String str, boolean z) {
        this.B = z;
        Code(adSource, str);
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            boolean z = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan imageSpanCode = Code(drawable, z);
            if (imageSpanCode != null) {
                spannableStringBuilder.setSpan(imageSpanCode, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            fh.I("PPSSplashLabelView", "setTextWhenImgLoaded error");
        }
    }
}
