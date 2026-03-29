package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class MaterialClickInfo {
    private static final String TAG = "MaterialClickInfo";
    private Integer adCardH;
    private Integer adCardW;
    private Integer adCardX;
    private Integer adCardY;
    private Integer btnClickX;
    private Integer btnClickY;
    private String clickComponent;
    private Long clickDTime;
    private Long clickUTime;
    private Integer clickX;
    private Integer clickY;
    private Integer compH;
    private Integer compW;
    private Integer compX;
    private Integer compY;
    private String creativeSize;
    private Float density;
    private String eventType;
    private String jsVersion;
    private Integer mark;
    private Integer screenH;
    private Integer screenW;
    private String shakeAngle;
    private Integer sld;
    private Integer upX;
    private Integer upY;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private Integer B;
        private Integer C;
        private Integer Code;
        private Integer D;
        private Integer F;
        private String I;
        private Integer L;
        private Integer S;
        private Integer V;
        private Integer Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f6941a;
        private Integer b;
        private Integer c;
        private String d;
        private Integer e;
        private Integer f;
        private Integer g;
        private Float h;
        private String i = com.huawei.openalliance.ad.constant.s.B;
        private Long j;
        private Long k;
        private String l;
        private String m;

        public a B(Integer num) {
            this.g = num;
            return this;
        }

        public a Code(Float f) {
            this.h = f;
            return this;
        }

        public a I(Integer num) {
            this.e = num;
            return this;
        }

        public a V(Integer num) {
            this.V = num;
            return this;
        }

        public a Z(Integer num) {
            this.f = num;
            return this;
        }

        public a Code(Integer num) {
            this.Code = num;
            return this;
        }

        public a I(String str) {
            this.i = str;
            return this;
        }

        public a V(Long l) {
            this.k = l;
            return this;
        }

        public a Z(String str) {
            this.l = str;
            return this;
        }

        public a Code(Long l) {
            this.j = l;
            return this;
        }

        public a V(String str) {
            this.d = str;
            return this;
        }

        public a Code(String str) {
            this.m = str;
            return this;
        }

        public MaterialClickInfo Code() {
            return new MaterialClickInfo(this);
        }
    }

    public MaterialClickInfo() {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
    }

    public Integer B() {
        return this.upX;
    }

    public Integer C() {
        return this.upY;
    }

    public Integer Code() {
        return this.clickX;
    }

    public Long D() {
        return this.clickUTime;
    }

    public String F() {
        return this.eventType;
    }

    public String I() {
        return this.creativeSize;
    }

    public Long L() {
        return this.clickDTime;
    }

    public Float S() {
        return this.density;
    }

    public Integer V() {
        return this.clickY;
    }

    public Integer Z() {
        return this.sld;
    }

    public Integer a() {
        return this.mark;
    }

    public String b() {
        return this.shakeAngle;
    }

    public String c() {
        return this.jsVersion;
    }

    public String d() {
        return this.clickComponent;
    }

    public Integer e() {
        return this.compX;
    }

    public Integer f() {
        return this.compY;
    }

    public Integer g() {
        return this.compW;
    }

    public Integer h() {
        return this.compH;
    }

    public Integer i() {
        return this.adCardX;
    }

    public Integer j() {
        return this.adCardY;
    }

    public Integer k() {
        return this.adCardW;
    }

    public Integer l() {
        return this.adCardH;
    }

    public Integer m() {
        return this.screenW;
    }

    public Integer n() {
        return this.screenH;
    }

    public Integer o() {
        return this.btnClickX;
    }

    public Integer p() {
        return this.btnClickY;
    }

    public String toString() {
        return "MaterialClickInfo{clickX=" + this.clickX + ", clickY=" + this.clickY + ", clickDTime=" + this.clickDTime + ", creativeSize='" + this.creativeSize + "', sld=" + this.sld + ", density=" + this.density + ", upX=" + this.upX + ", upY=" + this.upY + ", clickUTime=" + this.clickUTime + ", shakeAngle=" + this.shakeAngle + ", clickComponent= " + this.clickComponent + ", compX= " + this.compX + ", compY= " + this.compY + ", compW= " + this.compW + ", compH= " + this.compH + ", adCardX= " + this.adCardX + ", adCardY= " + this.adCardY + ", adCardW= " + this.adCardW + ", adCardH= " + this.adCardH + ", screenW= " + this.screenW + ", screenH= " + this.screenH + '}';
    }

    public MaterialClickInfo(a aVar) {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
        this.clickX = aVar.Code;
        this.clickY = aVar.V;
        this.creativeSize = aVar.d;
        this.sld = aVar.e;
        this.density = aVar.h;
        this.upX = aVar.f;
        this.upY = aVar.g;
        this.eventType = aVar.i;
        this.clickDTime = aVar.k;
        this.clickUTime = aVar.j;
        this.shakeAngle = aVar.l;
        this.jsVersion = aVar.m;
        this.clickComponent = aVar.I;
        this.compX = aVar.Z;
        this.compY = aVar.B;
        this.compW = aVar.C;
        this.compH = aVar.S;
        this.adCardX = aVar.F;
        this.adCardY = aVar.D;
        this.adCardW = aVar.L;
        this.adCardH = aVar.f6941a;
        this.screenW = aVar.b;
        this.screenH = aVar.c;
    }

    public void B(Integer num) {
        this.mark = num;
    }

    public void C(Integer num) {
        this.compX = num;
    }

    public void Code(Float f) {
        this.density = f;
    }

    public void D(Integer num) {
        this.compH = num;
    }

    public void F(Integer num) {
        this.compW = num;
    }

    public void I(Integer num) {
        this.upX = num;
    }

    public void L(Integer num) {
        this.adCardX = num;
    }

    public void S(Integer num) {
        this.compY = num;
    }

    public void V(Integer num) {
        this.sld = num;
    }

    public void Z(Integer num) {
        this.upY = num;
    }

    public void a(Integer num) {
        this.adCardY = num;
    }

    public void b(Integer num) {
        this.adCardW = num;
    }

    public void c(Integer num) {
        this.adCardH = num;
    }

    public void d(Integer num) {
        this.screenW = num;
    }

    public void e(Integer num) {
        this.screenH = num;
    }

    public void f(Integer num) {
        this.btnClickX = num;
    }

    public void g(Integer num) {
        this.btnClickY = num;
    }

    public MaterialClickInfo(Integer num, Integer num2, String str) {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
        this.clickX = num;
        this.clickY = num2;
        this.creativeSize = str;
    }

    public void B(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(TAG, "clickComponent is invalid");
        } else {
            this.clickComponent = str;
        }
    }

    public void Code(Integer num) {
        this.clickY = num;
    }

    public void I(String str) {
        this.shakeAngle = str;
    }

    public void V(Long l) {
        this.clickDTime = l;
    }

    public void Z(String str) {
        this.jsVersion = str;
    }

    public void Code(Long l) {
        this.clickUTime = l;
    }

    public void V(String str) {
        this.eventType = str;
    }

    public void Code(String str) {
        this.creativeSize = str;
    }
}
