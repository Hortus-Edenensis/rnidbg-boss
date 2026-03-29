package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class js extends jv {
    public static final String Code = "1";
    private List<StackTraceElement> D;
    private View F;
    private int L;
    private String S;

    public js(Context context, AdContentData adContentData, StackTraceElement[] stackTraceElementArr, View view) {
        super(context, adContentData);
        this.S = "ClickDetector";
        this.D = new ArrayList();
        this.F = view;
        if (com.huawei.openalliance.ad.utils.ag.Code(stackTraceElementArr)) {
            return;
        }
        this.L = stackTraceElementArr.length;
        this.D = Arrays.asList(stackTraceElementArr);
    }

    private void Code(String str, String str2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.F);
        analysisEventReport.Z(this.F.getClass().getSimpleName() + "_" + str2);
        analysisEventReport.B(str);
        this.B.Code(this.I, analysisEventReport, this.Z);
    }

    @Override // com.huawei.hms.ads.jv
    public boolean Code() {
        if (this.F != null && this.D != null) {
            for (int i = 0; i < this.L; i++) {
                if (!jv.Code(this.D.get(i))) {
                    Code(this.D.get(i).toString(), "1");
                    return true;
                }
            }
            jv jvVar = this.C;
            if (jvVar != null) {
                return jvVar.Code();
            }
        }
        return false;
    }
}
