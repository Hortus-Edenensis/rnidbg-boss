package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.PermissionDialogUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class og4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f19755a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public int e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActivityPermissionDispatcher.b f19756a;
        public final /* synthetic */ List b;

        public a(BaseActivityPermissionDispatcher.b bVar, List list) {
            this.f19756a = bVar;
            this.b = list;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.dismiss();
            og4.this.b = false;
            og4.this.j(this.f19756a, this.b);
            LogUtil.onImmediateClickEvent("permission04b", null, x63.c(og4.this.e, og4.this.f));
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.dismiss();
            og4.this.b = false;
            if (!r75.d(og4.this.f19755a, "sp_has_request_permission", false)) {
                r75.o(og4.this.f19755a, "sp_has_request_permission", true);
            }
            this.f19756a.a();
            LogUtil.onImmediateClickEvent("permission04a", null, x63.c(og4.this.e, og4.this.f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActivityPermissionDispatcher.b f19757a;

        public b(BaseActivityPermissionDispatcher.b bVar) {
            this.f19757a = bVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.dismiss();
            og4.this.d = false;
            if (!r75.d(og4.this.f19755a, "sp_has_request_permission", false)) {
                r75.o(og4.this.f19755a, "sp_has_request_permission", true);
            }
            this.f19757a.a();
            LogUtil.onImmediateClickEvent("permission05a", null, x63.c(og4.this.e, og4.this.f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.dismiss();
            og4.this.c = false;
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", og4.this.f19755a.getPackageName(), null));
                og4.this.f19755a.startActivity(intent);
                materialDialog.dismiss();
                LogUtil.onImmediateClickEvent("permission06a", null, x63.c(og4.this.e, og4.this.f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public og4(Activity activity) {
        int i = 0;
        this.f19755a = activity;
        String strP = AccountUtils.p(AppContext.getContext());
        String strO = AccountUtils.o(AppContext.getContext());
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strO)) {
            i = 1;
        }
        this.e = i;
    }

    public boolean h() {
        return this.b || this.c || this.d;
    }

    public void i(BaseActivityPermissionDispatcher.b bVar, BaseActivityPermissionDispatcher.PermissionType permissionType) {
        if (h()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean zD = r75.d(this.f19755a, "sp_has_request_permission", false);
        boolean z = false;
        boolean z2 = false;
        for (String str : permissionType.permissionList) {
            if (!tg4.b(this.f19755a, str)) {
                if (!zD || tg4.d(this.f19755a, str)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
                if (g.c.equals(str)) {
                    z = true;
                } else if (g.j.equals(str)) {
                    z2 = true;
                }
            }
        }
        if (z && z2) {
            this.f = 0;
        } else if (z) {
            this.f = 1;
        } else if (z2) {
            this.f = 2;
        }
        if (arrayList.size() > 0) {
            k(bVar, arrayList);
        } else if (arrayList2.size() > 0) {
            l(arrayList2);
        }
    }

    public final void j(BaseActivityPermissionDispatcher.b bVar, List<String> list) {
        if (list.size() > 0) {
            int i = list.size() > 1 ? R.string.permission_cancel_phone_state_and_storage : g.c.equals(list.get(0)) ? R.string.permission_cancel_phone_state : R.string.permission_cancel_storage;
            Activity activity = this.f19755a;
            PermissionDialogUtil.d(this.f19755a, Html.fromHtml(activity.getString(R.string.permission_cancel_dialog_content, activity.getString(i))), new b(bVar));
            this.d = true;
            LogUtil.onImmediateClickEvent("permission05", null, x63.c(this.e, this.f));
        }
    }

    public final void k(BaseActivityPermissionDispatcher.b bVar, List<String> list) {
        PermissionDialogUtil.f(this.f19755a, list, new a(bVar, list));
        this.b = true;
        LogUtil.onImmediateClickEvent("permission04", null, x63.c(this.e, this.f));
    }

    public final void l(List<String> list) {
        PermissionDialogUtil.g(this.f19755a, list, false, new c());
        this.c = true;
        LogUtil.onImmediateClickEvent("permission06", null, x63.c(this.e, this.f));
    }
}
