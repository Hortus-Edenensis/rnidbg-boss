package com.beizi.ad.lance;

import com.beizi.ad.model.c;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ApkBean implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4463a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private c.b.C0127b p;

    public ApkBean() {
        this.f4463a = "";
        this.b = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.o = "";
    }

    public String getApkDesc() {
        return this.f;
    }

    public String getApkName() {
        return this.b;
    }

    public String getApkTittleName() {
        return this.e;
    }

    public String getApkUrl() {
        return this.f4463a;
    }

    public String getAppDeveloper() {
        return this.h;
    }

    public String getAppIconURL() {
        return this.l;
    }

    public String getAppPermissionsDesc() {
        return this.i;
    }

    public String getAppPermissionsUrl() {
        return this.j;
    }

    public String getAppPrivacyUrl() {
        return this.k;
    }

    public String getAppVersion() {
        return this.g;
    }

    public String getAppintro() {
        return this.m;
    }

    public String getAuthorities() {
        return this.o;
    }

    public String getDownloadPath() {
        return this.d;
    }

    public String getFileMD5() {
        return this.n;
    }

    public String getPkgName() {
        return this.c;
    }

    public c.b.C0127b getmFollowTrackExt() {
        return this.p;
    }

    public void setApkDesc(String str) {
        this.f = str;
    }

    public void setApkName(String str) {
        this.b = str;
    }

    public void setApkTittleName(String str) {
        this.e = str;
    }

    public void setApkUrl(String str) {
        this.f4463a = str;
    }

    public void setAppDeveloper(String str) {
        this.h = str;
    }

    public void setAppIconURL(String str) {
        this.l = str;
    }

    public void setAppPermissionsDesc(String str) {
        this.i = str;
    }

    public void setAppPermissionsUrl(String str) {
        this.j = str;
    }

    public void setAppPrivacyUrl(String str) {
        this.k = str;
    }

    public void setAppVersion(String str) {
        this.g = str;
    }

    public void setAppintro(String str) {
        this.m = str;
    }

    public void setAuthorities(String str) {
        this.o = str;
    }

    public void setDownloadPath(String str) {
        this.d = str;
    }

    public void setFileMD5(String str) {
        this.n = str;
    }

    public void setPkgName(String str) {
        this.c = str;
    }

    public void setmFollowTrackExt(c.b.C0127b c0127b) {
        this.p = c0127b;
    }

    public ApkBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, c.b.C0127b c0127b, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.f4463a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.o = str7;
        this.p = c0127b;
        this.g = str8;
        this.h = str9;
        this.i = str10;
        this.j = str11;
        this.k = str12;
        this.l = str13;
        this.m = str14;
    }
}
