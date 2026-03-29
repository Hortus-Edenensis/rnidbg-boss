package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10850a;
    private ArrayList<al> b = new ArrayList<>();

    public ak(String str) {
        this.f10850a = "";
        this.f10850a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f10850a.contains(",")) {
                String str = this.f10850a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strTrim = str.trim();
                if (this.b != null) {
                    this.b.add(new al(strTrim));
                    return;
                }
                return;
            }
            for (String str2 : this.f10850a.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    String strTrim2 = str2.trim();
                    if (this.b != null) {
                        this.b.add(new al(strTrim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i) {
        try {
            ArrayList<al> arrayList = this.b;
            if (arrayList == null) {
                return false;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                al alVar = this.b.get(i2);
                if (alVar != null && alVar.a(i)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
