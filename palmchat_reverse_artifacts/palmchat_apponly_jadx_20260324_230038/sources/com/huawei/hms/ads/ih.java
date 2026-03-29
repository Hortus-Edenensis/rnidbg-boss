package com.huawei.hms.ads;

import android.content.Context;
import android.os.CountDownTimer;
import com.huawei.hms.ads.lv;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ih<V extends lv> extends ga<V> implements ix<V> {
    private CountDownTimer B;
    protected Context V;
    private boolean Z = false;
    private boolean C = false;

    public ih(Context context, V v) {
        this.V = context.getApplicationContext();
        Code(v);
    }

    private void I(String str) {
        if (this.Z) {
            fh.V("PPSBaseViewPresenter", str);
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    public void Code() {
        fh.V("PPSBaseViewPresenter", "cancelDisplayDurationCountTask");
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.B = null;
        }
    }

    @Override // com.huawei.hms.ads.ix
    public void S() {
        if (this.C) {
            fh.V("PPSBaseViewPresenter", "already reset");
        }
        this.C = true;
        if (I() != null) {
            I().destroyView();
        }
    }

    @Override // com.huawei.hms.ads.ix
    public void V() {
        fh.V("PPSBaseViewPresenter", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        S();
        ft adMediator = I().getAdMediator();
        if (adMediator != null) {
            adMediator.n();
        }
    }

    public abstract void V(String str);

    @Override // com.huawei.hms.ads.ix
    public void Code(int i) {
        fh.V("PPSBaseViewPresenter", "startDisplayDurationCountTask duration: %d", Integer.valueOf(i));
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i, 500L) { // from class: com.huawei.hms.ads.ih.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((lv) ih.this.I()).I(1);
                ih.this.V();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int iMax = Math.max(1, (int) Math.ceil((j * 1.0f) / 1000.0f));
                fh.Code("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j), Integer.valueOf(iMax));
                ((lv) ih.this.I()).I(iMax);
            }
        };
        this.B = countDownTimer2;
        countDownTimer2.start();
    }

    public void V(AdContentData adContentData) {
        ft adMediator = I().getAdMediator();
        if (adMediator != null) {
            adMediator.I(adContentData);
        }
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(int i, int i2, AdContentData adContentData, Long l, MaterialClickInfo materialClickInfo, int i3) {
        fh.V("PPSBaseViewPresenter", "onTouch");
        ft adMediator = I().getAdMediator();
        if (adMediator == null || !adMediator.Code(i, i2, adContentData, l, materialClickInfo, i3)) {
            return;
        }
        if (this.Z) {
            fh.V("PPSBaseViewPresenter", "onDoActionSucc hasShowFinish");
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    @Override // com.huawei.hms.ads.ix
    public void V(Long l) {
        I("feedback hasShowFinish");
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(int i, int i2, Long l) {
        fh.V("PPSBaseViewPresenter", "skip ad - hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        S();
        Code();
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
        Code(com.huawei.openalliance.ad.utils.bc.Code(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code())));
        if (adContentData == null) {
            fh.I("PPSBaseViewPresenter", "loadAdMaterial contentRecord is null");
            I().Code(-7);
        } else {
            fh.V("PPSBaseViewPresenter", "loadAdMaterial");
            V(adContentData.h());
            e.Code(this.V, adContentData);
        }
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(AdContentData adContentData, long j, int i) {
        ft adMediator = I().getAdMediator();
        if (adMediator != null) {
            adMediator.Code(adContentData, j, i);
        }
    }

    @Override // com.huawei.hms.ads.ix
    public void Code(Long l) {
        I("onWhyThisAd hasShowFinish");
    }
}
