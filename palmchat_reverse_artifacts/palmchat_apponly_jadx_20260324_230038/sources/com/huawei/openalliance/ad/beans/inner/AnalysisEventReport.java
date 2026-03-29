package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class AnalysisEventReport {
    private AdContentData adData;
    private String analysisType;
    private int apiVer;
    private String contentId;
    private long duration;
    private int errorCode;
    private long expireTime;
    private int extra;
    private String extraStr1;
    private String extraStr10;
    private String extraStr2;
    private String extraStr3;
    private String extraStr4;
    private String extraStr5;
    private String extraStr6;
    private String extraStr7;
    private String extraStr8;
    private String extraStr9;
    private long extraTime1;
    private String slotId;
    private String taskId;
    private String templateId;
    private String url;

    public String B() {
        return this.analysisType;
    }

    public long C() {
        return this.expireTime;
    }

    public String Code() {
        return this.url;
    }

    public String D() {
        return this.extraStr3;
    }

    public String F() {
        return this.extraStr2;
    }

    public int I() {
        return this.extra;
    }

    public String L() {
        return this.extraStr4;
    }

    public String S() {
        return this.extraStr1;
    }

    public int V() {
        return this.errorCode;
    }

    public AdContentData Z() {
        return this.adData;
    }

    public String a() {
        return this.extraStr5;
    }

    public String b() {
        return this.extraStr6;
    }

    public String c() {
        return this.extraStr7;
    }

    public String d() {
        return this.extraStr8;
    }

    public String e() {
        return this.extraStr9;
    }

    public String f() {
        return this.extraStr10;
    }

    public long g() {
        return this.duration;
    }

    public long h() {
        return this.extraTime1;
    }

    public String i() {
        return this.contentId;
    }

    public String j() {
        return this.templateId;
    }

    public String k() {
        return this.slotId;
    }

    public int l() {
        return this.apiVer;
    }

    public String m() {
        return this.taskId;
    }

    public void B(String str) {
        this.extraStr3 = str;
    }

    @Deprecated
    public void C(String str) {
        this.extraStr4 = str;
    }

    public void Code(int i) {
        this.errorCode = i;
    }

    public void D(String str) {
        this.extraStr7 = str;
    }

    public void F(String str) {
        this.extraStr6 = str;
    }

    public void I(int i) {
        this.apiVer = i;
    }

    public void L(String str) {
        this.extraStr8 = str;
    }

    public void S(String str) {
        this.extraStr5 = str;
    }

    public void V(int i) {
        this.extra = i;
    }

    public void Z(String str) {
        this.extraStr2 = str;
    }

    public void a(String str) {
        this.extraStr9 = str;
    }

    public void b(String str) {
        this.extraStr10 = str;
    }

    public void c(String str) {
        this.contentId = str;
    }

    public void d(String str) {
        this.templateId = str;
    }

    public void e(String str) {
        this.slotId = str;
    }

    public void f(String str) {
        this.taskId = str;
    }

    public void Code(long j) {
        this.expireTime = j;
    }

    public void I(long j) {
        this.extraTime1 = j;
    }

    public void V(long j) {
        this.duration = j;
    }

    public void Code(AdContentData adContentData) {
        this.adData = adContentData;
    }

    public void I(String str) {
        this.extraStr1 = str;
    }

    public void V(String str) {
        this.analysisType = str;
    }

    public void Code(String str) {
        this.url = str;
    }
}
