package com.bun.miitmdid.utilsforrequestpermission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bun.miitmdid.c;
import com.bun.miitmdid.interfaces.IPermissionCallbackListener;
import com.bun.miitmdid.p;
import com.bun.miitmdid.p0;
import com.bun.miitmdid.s0;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PermissionTransparentActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4936a = 1111;
    public String b = "1";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Override // android.app.Activity
    public native void finish();

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        p0.a("PermissionTransparentActivity", "onActivityResult---------,requestCode: " + i + ", resultCode: " + i2);
        if (this.f4936a == i && -1 == i2 && intent != null) {
            IPermissionCallbackListener iPermissionCallbackListenerB = s0.a().b();
            String stringExtra = intent.getStringExtra("permissionCode");
            String str = p.a().b(this).E;
            p0.a("PermissionTransparentActivity", "providerName: " + str);
            if (str.equals(c.VIVO.E)) {
                p0.a("PermissionTransparentActivity", "providerName is vivo");
                if (this.b.equals(stringExtra)) {
                    p0.a("PermissionTransparentActivity", "onGranted");
                    iPermissionCallbackListenerB.onGranted(new String[]{"VIVO_OAID_STATE_ENABLE"});
                } else {
                    p0.a("PermissionTransparentActivity", "onDenied");
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add("VIVO_OAID_STATE_DISABLE");
                    iPermissionCallbackListenerB.onDenied(arrayList);
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
}
