package com.huawei.openalliance.ad.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private List<FeedbackInfo> B;
    private FeedbackInfo C;
    private AdContentData I;
    private Context S;
    private d V;
    private List<FeedbackInfo> Z;

    public b(FeedbackView feedbackView) {
        this.V = feedbackView;
    }

    public boolean B() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aQ();
        }
        return false;
    }

    public String C() {
        AdContentData adContentData = this.I;
        return adContentData != null ? adContentData.aP() : "";
    }

    public List<FeedbackInfo> Code() {
        return this.Z;
    }

    public FeedbackInfo I() {
        return this.C;
    }

    public List<FeedbackInfo> V() {
        return this.B;
    }

    public boolean Z() {
        fh.V("FeedbackPresenter", "click complain");
        if (this.C == null || this.S == null || this.I == null) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("package_name", this.S.getPackageName());
            intent.putExtra("slotid", this.I.L());
            intent.putExtra("content_id", this.I.a());
            intent.putExtra("templateId", this.I.aE());
            intent.putExtra("apiVer", this.I.aF());
            intent.putExtra(be.aB, this.C.Code());
            fh.V("FeedbackPresenter", "jumpToComplain, adContentData.uniqueId: %s", this.I.aa());
            intent.putExtra("unique_id", this.I.aa());
            intent.setAction(x.cY);
            intent.setPackage(z.Z(this.S));
            if (!(this.S instanceof Activity)) {
                intent.addFlags(268435456);
            }
            bg.Code(this.S, intent);
        } catch (Throwable th) {
            fh.I("FeedbackPresenter", "start ac failed: %s", th.getClass().getSimpleName());
        }
        return true;
    }

    public void Code(Context context, AdContentData adContentData) {
        List<FeedbackInfo> list;
        this.S = context;
        if (adContentData == null || ag.Code(adContentData.aC())) {
            return;
        }
        this.I = adContentData;
        List<FeedbackInfo> listAC = adContentData.aC();
        this.B = new ArrayList();
        this.Z = new ArrayList();
        for (FeedbackInfo feedbackInfo : listAC) {
            if (feedbackInfo != null) {
                int iV = feedbackInfo.V();
                if (iV == 1) {
                    list = this.B;
                } else if (iV == 2) {
                    list = this.Z;
                } else if (iV != 3) {
                    fh.Code("FeedbackPresenter", "invalid feedback type");
                } else {
                    this.C = feedbackInfo;
                }
                list.add(feedbackInfo);
            }
        }
        this.V.Code();
    }

    public boolean Code(Context context) {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return false;
        }
        return z.Code(context, adContentData);
    }
}
