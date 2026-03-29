package com.huawei.hms.ads.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.aq;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ChoicesView extends ImageView {

    /* JADX INFO: renamed from: com.huawei.hms.ads.splash.ChoicesView$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        /* JADX INFO: renamed from: com.huawei.hms.ads.splash.ChoicesView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C04361 implements RemoteCallResultCallback<String> {
            public C04361() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                ac.Code(ChoicesView.this.getContext(), sourceParam, new aq() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.aq
                    public void Code() {
                        fh.Code("ChoicesView", "download icon fail, use local icon");
                        bj.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.aq
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            bj.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChoicesView.this.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.Code(x.k);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", ad.V(sourceParam));
                g.V(ChoicesView.this.getContext()).Code(s.L, jSONObject.toString(), new C04361(), String.class);
            } catch (JSONException unused) {
                fh.I("ChoicesView", "load ad choice icon jsonex");
            }
        }
    }

    public ChoicesView(Context context) {
        super(context, null);
        Code();
    }

    public void Code() {
        Resources resources = getContext().getResources();
        int i = com.huawei.hms.ads.base.R.dimen.hiad_24_dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i);
        fh.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_hm_info);
    }

    public void I() {
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_choices_adchoice);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fh.Code("ChoicesView", "updateIcon from server.");
        i.V(new AnonymousClass1(str));
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code();
    }

    @GlobalApi
    public ChoicesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Code();
    }
}
