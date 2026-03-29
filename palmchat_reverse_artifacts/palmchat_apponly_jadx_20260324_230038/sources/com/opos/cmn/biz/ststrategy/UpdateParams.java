package com.opos.cmn.biz.ststrategy;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class UpdateParams {
    public final String pkgName;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7878a;

        public UpdateParams build() {
            if (TextUtils.isEmpty(this.f7878a)) {
                throw new NullPointerException("update params can not be null!");
            }
            return new UpdateParams(this);
        }

        public Builder setPkgName(String str) {
            this.f7878a = str;
            return this;
        }
    }

    private UpdateParams(Builder builder) {
        this.pkgName = builder.f7878a;
    }

    public String toString() {
        return "UpdateParams{pkgName='" + this.pkgName + "'}";
    }
}
