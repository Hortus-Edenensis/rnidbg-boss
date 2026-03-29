package com.opos.process.bridge.client;

import android.text.TextUtils;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TargetInfo {
    String action;
    String authorities;
    String name;
    String packageName;

    private TargetInfo() {
    }

    public TargetInfo(TargetInfo targetInfo) {
        this.name = targetInfo.name;
        this.packageName = targetInfo.packageName;
        this.authorities = targetInfo.authorities;
        this.action = targetInfo.action;
    }

    public static TargetInfo targetInfoAction(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        TargetInfo targetInfo = new TargetInfo();
        targetInfo.packageName = str;
        targetInfo.action = str2;
        targetInfo.name = str3;
        return targetInfo;
    }

    public static TargetInfo targetInfoAuthorities(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        TargetInfo targetInfo = new TargetInfo();
        targetInfo.packageName = str;
        targetInfo.authorities = str2;
        targetInfo.name = str3;
        return targetInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TargetInfo targetInfo = (TargetInfo) obj;
        return Objects.equals(this.name, targetInfo.name) && Objects.equals(this.packageName, targetInfo.packageName) && Objects.equals(this.authorities, targetInfo.authorities) && Objects.equals(this.action, targetInfo.action);
    }

    public String getAction() {
        return this.action;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.packageName, this.authorities, this.action);
    }

    public String toString() {
        return "TargetInfo{name='" + this.name + "', packageName='" + this.packageName + "', authorities='" + this.authorities + "', action='" + this.action + "'}";
    }
}
