package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.permission.PermissionRequestInterface;
import com.zenmen.palmchat.R;
import java.util.Vector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class rg4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f20465a = 2222;
    public static int b = 2211;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20466a;
        public final /* synthetic */ PermissionRequestInterface b;
        public final /* synthetic */ AlertDialog c;

        public a(Activity activity, PermissionRequestInterface permissionRequestInterface, AlertDialog alertDialog) {
            this.f20466a = activity;
            this.b = permissionRequestInterface;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", RTCParameters.c().getPackageName(), null));
            this.f20466a.startActivity(intent);
            this.b.p1();
            this.c.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20467a;
        public final /* synthetic */ PermissionRequestInterface b;

        public b(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20467a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20467a.dismiss();
            this.b.g1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20468a;
        public final /* synthetic */ PermissionRequestInterface b;

        public c(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20468a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20468a.dismiss();
            this.b.onCancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20469a;
        public final /* synthetic */ PermissionRequestInterface b;
        public final /* synthetic */ AlertDialog c;

        public d(Activity activity, PermissionRequestInterface permissionRequestInterface, AlertDialog alertDialog) {
            this.f20469a = activity;
            this.b = permissionRequestInterface;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.fromParts("package", RTCParameters.c().getPackageName(), null));
            this.f20469a.startActivity(intent);
            this.b.I();
            this.c.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20470a;
        public final /* synthetic */ PermissionRequestInterface b;

        public e(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20470a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20470a.dismiss();
            this.b.onCancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20471a;
        public final /* synthetic */ PermissionRequestInterface b;
        public final /* synthetic */ AlertDialog c;

        public f(Activity activity, PermissionRequestInterface permissionRequestInterface, AlertDialog alertDialog) {
            this.f20471a = activity;
            this.b = permissionRequestInterface;
            this.c = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", RTCParameters.c().getPackageName(), null));
            this.f20471a.startActivity(intent);
            this.b.B0();
            this.c.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20472a;
        public final /* synthetic */ PermissionRequestInterface b;

        public g(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20472a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20472a.dismiss();
            this.b.onCancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20473a;
        public final /* synthetic */ PermissionRequestInterface b;

        public h(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20473a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20473a.dismiss();
            this.b.l();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20474a;
        public final /* synthetic */ PermissionRequestInterface b;

        public i(AlertDialog alertDialog, PermissionRequestInterface permissionRequestInterface) {
            this.f20474a = alertDialog;
            this.b = permissionRequestInterface;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f20474a.dismiss();
            this.b.onCancel();
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    public static boolean c(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context);
    }

    public static void d(Context context) {
        Vector vector = new Vector();
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            vector.add("android.permission.RECORD_AUDIO");
        }
        if (vector.isEmpty()) {
            return;
        }
        ActivityCompat.requestPermissions((Activity) context, (String[]) vector.toArray(new String[vector.size()]), 0);
    }

    public static void e(Context context) {
        Vector vector = new Vector();
        if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
            vector.add("android.permission.CAMERA");
        }
        if (vector.isEmpty()) {
            return;
        }
        ActivityCompat.requestPermissions((Activity) context, (String[]) vector.toArray(new String[vector.size()]), f20465a);
    }

    public static void f(Activity activity, PermissionRequestInterface permissionRequestInterface) {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.fromParts("package", RTCParameters.c().getPackageName(), null));
            activity.startActivity(intent);
            permissionRequestInterface.I();
        } catch (Exception unused) {
        }
    }

    public static void g(Activity activity, PermissionRequestInterface permissionRequestInterface) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        window.setContentView(R.layout.manychats_layout_permission);
        ((TextView) window.findViewById(R.id.manychats_permission_tv_message)).setText("在设置-应用-连信-权限中开启相机权限，以正常使用拍照、视频通话等功能\r\n");
        ((TextView) window.findViewById(R.id.btn_ok)).setOnClickListener(new f(activity, permissionRequestInterface, alertDialogCreate));
        alertDialogCreate.setOnCancelListener(new g(alertDialogCreate, permissionRequestInterface));
        ((TextView) window.findViewById(R.id.btn_cancel)).setOnClickListener(new h(alertDialogCreate, permissionRequestInterface));
        alertDialogCreate.setOnCancelListener(new i(alertDialogCreate, permissionRequestInterface));
    }

    public static void h(Activity activity, PermissionRequestInterface permissionRequestInterface) {
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
            alertDialogCreate.show();
            Window window = alertDialogCreate.getWindow();
            window.setContentView(R.layout.manychats_layout_permission);
            ((TextView) window.findViewById(R.id.manychats_permission_titile)).setText("浮窗权限未获取");
            ((TextView) window.findViewById(R.id.manychats_permission_tv_message)).setText("你的手机没有授权连信获得浮窗权限，视频、语音通话最小化不能正常使用");
            TextView textView = (TextView) window.findViewById(R.id.btn_ok);
            textView.setText("开启");
            textView.setOnClickListener(new d(activity, permissionRequestInterface, alertDialogCreate));
            alertDialogCreate.setCanceledOnTouchOutside(false);
            ((TextView) window.findViewById(R.id.btn_cancel)).setVisibility(8);
            alertDialogCreate.setOnCancelListener(new e(alertDialogCreate, permissionRequestInterface));
        } catch (Exception unused) {
        }
    }

    public static void i(Activity activity, PermissionRequestInterface permissionRequestInterface) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        window.setContentView(R.layout.manychats_layout_permission);
        ((TextView) window.findViewById(R.id.manychats_permission_tv_message)).setText("在设置-应用-连信-权限中开启麦克风权限，以正常使用语音、通话等功能\r\n");
        ((TextView) window.findViewById(R.id.btn_ok)).setOnClickListener(new a(activity, permissionRequestInterface, alertDialogCreate));
        ((TextView) window.findViewById(R.id.btn_cancel)).setOnClickListener(new b(alertDialogCreate, permissionRequestInterface));
        alertDialogCreate.setOnCancelListener(new c(alertDialogCreate, permissionRequestInterface));
    }
}
