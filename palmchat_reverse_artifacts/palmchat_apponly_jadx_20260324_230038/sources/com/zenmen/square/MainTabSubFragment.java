package com.zenmen.square;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import defpackage.qj5;
import defpackage.sd3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MainTabSubFragment extends BaseFragment {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16080a;

        public a(MaterialDialog materialDialog) {
            this.f16080a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16080a.dismiss();
            qj5.F("discoverleadalert_loc_accept", "click");
            MainTabSubFragment.this.T();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16081a;

        public b(MaterialDialog materialDialog) {
            this.f16081a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16081a.dismiss();
            qj5.F("discoverleadalert_loc_close", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            qj5.F("discoverleadalert_loc_close", "click");
        }
    }

    private void V() {
        View viewInflate = View.inflate(getContext(), R$layout.dialog_square_location_permission, null);
        MaterialDialog materialDialogE = new sd3(getActivity()).p(viewInflate, false).h(true).e();
        materialDialogE.show();
        View viewFindViewById = viewInflate.findViewById(R$id.action);
        View viewFindViewById2 = viewInflate.findViewById(R$id.close);
        viewFindViewById.setOnClickListener(new a(materialDialogE));
        viewFindViewById2.setOnClickListener(new b(materialDialogE));
        materialDialogE.setOnCancelListener(new c());
    }

    public void R() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void T() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getContext().getPackageName(), null));
        startActivity(intent);
    }

    public void W(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        qj5.F("discoverleadalert_loc", "view");
        V();
    }
}
