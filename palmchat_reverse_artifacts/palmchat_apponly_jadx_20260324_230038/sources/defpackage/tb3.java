package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.permission.PermissionRequestInterface;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class tb3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20950a;
        public final /* synthetic */ AlertDialog b;

        public a(Activity activity, AlertDialog alertDialog) {
            this.f20950a = activity;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", RTCParameters.c().getPackageName());
            this.f20950a.startActivity(intent);
            this.b.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20951a;
        public final /* synthetic */ PermissionRequestInterface b;

        public b(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20951a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20951a.dismiss();
            this.b.onCancel();
        }
    }

    public static void a(Activity activity, PermissionRequestInterface permissionRequestInterface) {
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
            alertDialogCreate.show();
            Window window = alertDialogCreate.getWindow();
            window.setContentView(R.layout.manychats_layout_permission);
            ((TextView) window.findViewById(R.id.manychats_permission_titile)).setText("后台弹出权限未获取");
            ((TextView) window.findViewById(R.id.manychats_permission_tv_message)).setText("你的手机没有授权连信获得后台弹出权限，悬浮窗最小化将不能正常使用");
            TextView textView = (TextView) window.findViewById(R.id.btn_ok);
            textView.setText("开启");
            textView.setOnClickListener(new a(activity, alertDialogCreate));
            alertDialogCreate.setCanceledOnTouchOutside(false);
            ((TextView) window.findViewById(R.id.btn_cancel)).setVisibility(8);
            alertDialogCreate.setOnCancelListener(new b(alertDialogCreate, permissionRequestInterface));
        } catch (Exception unused) {
        }
    }
}
