package com.huawei.hms.ads;

import android.content.ComponentName;
import android.content.Intent;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kw {
    private int B;
    private int C;
    private String Code;
    private String I;
    private String V;
    private String Z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final String Code = "RedirectionMatchParam.Builder";
        private String B;
        private int C;
        private String I;
        private int S;
        private String V;
        private String Z;

        public a Code(int i) {
            this.C = i;
            return this;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public a Z(String str) {
            this.B = str;
            return this;
        }

        public a Code(Intent intent) {
            if (intent == null) {
                return this;
            }
            if (com.huawei.openalliance.ad.utils.bc.Code(this.Z)) {
                this.Z = intent.getPackage();
            }
            ComponentName component = intent.getComponent();
            if (component != null && com.huawei.openalliance.ad.utils.bc.Code(this.B)) {
                this.B = component.getClassName();
            }
            return this;
        }

        public a Code(ApkInfo apkInfo) {
            if (apkInfo == null) {
                return this;
            }
            String strCode = apkInfo.Code();
            String strV = apkInfo.v();
            if (!com.huawei.openalliance.ad.utils.bc.Code(strCode)) {
                this.Z = strCode;
            }
            if (!com.huawei.openalliance.ad.utils.bc.Code(strV)) {
                this.B = strV;
            }
            return this;
        }

        public a Code(AdContentData adContentData) {
            if (adContentData == null) {
                fh.I(Code, "send param by content record,record is null.");
                return this;
            }
            this.V = adContentData.a();
            this.I = adContentData.b();
            this.C = adContentData.Z();
            this.S = adContentData.aF();
            return this;
        }

        public a Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            if (appInfo == null) {
                return this;
            }
            String strCode = appInfo.Code();
            String strA = appInfo.A();
            if (!com.huawei.openalliance.ad.utils.bc.Code(strCode)) {
                this.Z = strCode;
            }
            if (!com.huawei.openalliance.ad.utils.bc.Code(strA)) {
                this.B = strA;
            }
            return this;
        }

        public a Code(Integer num) {
            this.S = 3 != num.intValue() ? 2 : num.intValue();
            return this;
        }

        public a Code(String str) {
            this.V = str;
            return this;
        }

        public kw Code() {
            return new kw(this);
        }
    }

    public kw(a aVar) {
        this.I = aVar.Z;
        this.Z = aVar.B;
        this.Code = aVar.V;
        this.V = aVar.I;
        this.B = aVar.C;
        this.C = aVar.S;
    }

    public String B() {
        return this.Z;
    }

    public int C() {
        return this.C;
    }

    public int Code() {
        return this.B;
    }

    public String I() {
        return this.V;
    }

    public String V() {
        return this.Code;
    }

    public String Z() {
        return this.I;
    }

    public void Code(int i) {
        this.B = i;
    }

    public void I(String str) {
        this.I = str;
    }

    public void V(int i) {
        this.C = i;
    }

    public void Z(String str) {
        this.Z = str;
    }

    public void Code(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.I == null) {
            this.I = intent.getPackage();
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            Z(component.getClassName());
        }
    }

    public void V(String str) {
        this.V = str;
    }

    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.V = adContentData.b();
        this.Code = adContentData.a();
    }

    public void Code(String str) {
        this.Code = str;
    }
}
