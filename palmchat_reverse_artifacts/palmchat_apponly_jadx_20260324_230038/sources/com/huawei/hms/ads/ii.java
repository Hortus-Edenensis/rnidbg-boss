package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.utils.ac;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ii extends ih<lp> implements iu {
    public ii(Context context, lp lpVar) {
        super(context, lpVar);
    }

    @Override // com.huawei.hms.ads.ih
    public void V(final String str) {
        ((lp) I()).B();
        fh.V("PPSImageViewPresenter", "onMaterialLoaded - begin to load image");
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(str);
        sourceParam.Code(this.Code);
        ac.Code(this.V, sourceParam, new com.huawei.openalliance.ad.utils.aq() { // from class: com.huawei.hms.ads.ii.1
            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code() {
                fh.V("PPSImageViewPresenter", "onMaterialLoaded - image load failed");
                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ii.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lp) ii.this.I()).Code(-9);
                    }
                });
                ii iiVar = ii.this;
                iiVar.V(iiVar.Code);
            }

            @Override // com.huawei.openalliance.ad.utils.aq
            public void Code(String str2, final Drawable drawable) {
                if (TextUtils.equals(str2, str)) {
                    fh.V("PPSImageViewPresenter", "onMaterialLoaded - image load success");
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ii.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((lp) ii.this.I()).Code(drawable);
                            ((lp) ii.this.I()).Z();
                        }
                    });
                } else {
                    Code();
                    ii iiVar = ii.this;
                    db.Code(iiVar.V, 5, "url not equals filePath", iiVar.Code);
                }
            }
        });
    }
}
