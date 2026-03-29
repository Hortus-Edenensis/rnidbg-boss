package com.huawei.openalliance.ad.beans.metadata.v3;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class TemplateData implements Serializable {
    private static final long serialVersionUID = 4943303525973528850L;
    private String componentContext;
    private List<MotionData> motionData;
    private String motions;
    private String templateContext;

    public TemplateData() {
    }

    public TemplateData(String str, String str2, List<MotionData> list) {
        this.templateContext = str;
        this.motions = str2;
        this.motionData = list;
    }

    public String Code() {
        return this.templateContext;
    }

    public List<MotionData> I() {
        return this.motionData;
    }

    public String V() {
        return this.motions;
    }

    public String Z() {
        return this.componentContext;
    }

    public void Code(String str) {
        this.templateContext = str;
    }

    public void I(String str) {
        this.componentContext = str;
    }

    public void V(String str) {
        this.motions = str;
    }

    public void Code(List<MotionData> list) {
        this.motionData = list;
    }
}
