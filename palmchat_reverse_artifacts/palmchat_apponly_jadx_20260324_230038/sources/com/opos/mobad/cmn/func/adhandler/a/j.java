package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8655a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public boolean g;

    public j(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.f8655a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = z;
    }

    public static j a(MaterialData materialData, String str) {
        String strJ = materialData.J();
        return new j(materialData.i(), materialData.r(), materialData.o(), materialData.O(), materialData.P(), str, !TextUtils.isEmpty(strJ) ? true ^ strJ.contains("atd=false") : true);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 1;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f8655a);
    }
}
