package com.huawei.openalliance.ad.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.ads.ek;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSBaseTwistView extends PPSBaseStyleView {
    protected ImageView F;

    public PPSBaseTwistView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new ek(0.33f, 0.0f, 0.67f, 1.0f));
        ArrayList arrayList = new ArrayList(4);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.F, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, -7.0f);
        objectAnimatorOfFloat.setDuration(150L);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.F, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -7.0f, 7.0f);
        objectAnimatorOfFloat2.setDuration(400L);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.F, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 7.0f, -4.5f);
        objectAnimatorOfFloat3.setDuration(350L);
        arrayList.add(objectAnimatorOfFloat3);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.F, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, -4.5f, 2.0f);
        objectAnimatorOfFloat4.setDuration(350L);
        arrayList.add(objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.F, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 2.0f, 0.0f);
        objectAnimatorOfFloat5.setDuration(250L);
        arrayList.add(objectAnimatorOfFloat5);
        this.F.invalidate();
        animatorSet.playSequentially(arrayList);
        animatorSet.start();
    }

    public String getViewTag() {
        return "PPSBaseStyleView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fh.V(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.F.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseTwistView.1
            @Override // java.lang.Runnable
            public void run() {
                fh.V(PPSBaseTwistView.this.getViewTag(), "imageView %s %s", Integer.valueOf(PPSBaseTwistView.this.F.getWidth()), Integer.valueOf(PPSBaseTwistView.this.F.getHeight()));
                PPSBaseTwistView.this.F.setPivotX(r0.getWidth() / 2.0f);
                PPSBaseTwistView.this.F.setPivotY(r0.getHeight() + z.V(PPSBaseTwistView.this.getContext(), 80.0f));
                PPSBaseTwistView.this.V();
            }
        });
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSBaseTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
