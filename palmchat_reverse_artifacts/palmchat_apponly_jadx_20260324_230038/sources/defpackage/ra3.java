package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.zenmen.media.album.pop.PopMediaDialog;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.xk3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ra3 implements xk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xk3.a f20426a;
    public FrameworkBaseActivity b;
    public PopMediaDialog c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ra3.this.c = null;
        }
    }

    @Override // defpackage.xk3
    public void a(FrameworkBaseActivity frameworkBaseActivity, xk3.a aVar) {
        this.b = frameworkBaseActivity;
        this.f20426a = aVar;
    }

    @Override // defpackage.xk3
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        PopMediaDialog popMediaDialog = this.c;
        if (popMediaDialog == null || !popMediaDialog.isShowing()) {
            return;
        }
        this.c.m(i, i2, intent);
    }

    @Override // defpackage.xk3
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        PopMediaDialog popMediaDialog = this.c;
        if (popMediaDialog == null || !popMediaDialog.isShowing()) {
            return;
        }
        this.c.o(permissionType, permissionUsage);
    }

    @Override // defpackage.xk3
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        PopMediaDialog popMediaDialog = this.c;
        if (popMediaDialog == null || !popMediaDialog.isShowing()) {
            return;
        }
        this.c.p(permissionType, permissionUsage, z);
    }

    @Override // defpackage.xk3
    public void onResume() {
        PopMediaDialog popMediaDialog = this.c;
        if (popMediaDialog == null || !popMediaDialog.isShowing()) {
            return;
        }
        this.c.q();
    }

    @Override // defpackage.xk3
    public void show() {
        PopMediaDialog popMediaDialog = new PopMediaDialog(this.b);
        popMediaDialog.s(this.f20426a);
        popMediaDialog.setOnDismissListener(new a());
        popMediaDialog.show();
        this.c = popMediaDialog;
    }
}
