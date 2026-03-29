package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.sdk.api.ZXIDChangedListener;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class e3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16791a;
    public final /* synthetic */ ZXIDChangedListener b;

    public e3(x2 x2Var, String str, ZXIDChangedListener zXIDChangedListener) {
        this.f16791a = str;
        this.b = zXIDChangedListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h3 h3VarA = x2.a();
            String str = this.f16791a;
            ZXIDChangedListener zXIDChangedListener = this.b;
            q2 q2Var = h3VarA.c;
            q2Var.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            LinkedList<ZXIDChangedListener> linkedList = q2Var.f16849a.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            linkedList.add(zXIDChangedListener);
            q2Var.f16849a.put(str, linkedList);
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
