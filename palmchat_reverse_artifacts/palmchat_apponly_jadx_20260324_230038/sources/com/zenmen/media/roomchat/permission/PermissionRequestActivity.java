package com.zenmen.media.roomchat.permission;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.permission.PermissionRequestInterface;
import com.zenmen.media.roomchatdemo.videocallgroup.d;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.rg4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PermissionRequestActivity extends FrameworkBaseActivity implements PermissionRequestInterface {
    public static String v = "PermissionRequestActivity";
    public boolean q = false;
    public PermissionRequestInterface r = null;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;

    public void A1() {
        if (rg4.b(this)) {
            D1();
        } else {
            rg4.d(this);
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void B0() {
        this.u = true;
    }

    public void B1() {
        if (rg4.c(this)) {
            F1();
        } else {
            rg4.h(this, this.r);
        }
    }

    public void C1() {
        if (rg4.a(this)) {
            G1();
        } else {
            rg4.d(this);
        }
    }

    public void D1() {
        if (this.q) {
            finish();
        }
    }

    public void E1() {
        Toast.makeText(this, "权限授予失败，无法开启悬浮窗", 0).show();
        if (this.q) {
            finish();
        }
    }

    public void F1() {
        if (this.q) {
            try {
                Message message = new Message();
                message.what = 15;
                message.arg1 = 1;
                d.P().N().sendMessage(message);
            } catch (Exception unused) {
            }
            finish();
        }
    }

    public void G1() {
        if (this.q) {
            finish();
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void I() {
        this.t = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.q && motionEvent.getAction() == 1) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void g1() {
        Toast.makeText(this, "权限授予失败，无法开启录音", 0).show();
        if (this.q) {
            finish();
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void l() {
        Toast.makeText(this, "权限授予失败，无法开启摄像头", 0).show();
        if (this.q) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == rg4.b) {
            if (rg4.c(this)) {
                return;
            }
            E1();
        } else if (i == rg4.f20465a) {
            Log.i(v, "收到onActivityResult " + i);
        }
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void onCancel() {
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.q = getIntent().getIntExtra("REQUEST_PERMISSION_ONLY", 0) == 1;
        this.r = this;
        PermissionRequestInterface.RequestType requestType = (PermissionRequestInterface.RequestType) getIntent().getSerializableExtra("REQUEST_PERMISSION_ENUM_TYPE");
        if (RTCParameters.c() != null) {
            try {
                if (((ActivityManager) RTCParameters.c().getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName().contains(RTCParameters.c().getPackageName())) {
                    if (requestType == PermissionRequestInterface.RequestType.FloatView) {
                        B1();
                    }
                    if (requestType == PermissionRequestInterface.RequestType.Camera) {
                        A1();
                    }
                    if (requestType == PermissionRequestInterface.RequestType.Record_Audio) {
                        C1();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            if (strArr[0].equals("android.permission.CAMERA")) {
                if (iArr[0] == 0) {
                    D1();
                } else {
                    rg4.g(this, this.r);
                }
            }
            if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                if (iArr[0] == 0) {
                    G1();
                } else {
                    rg4.i(this, this.r);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.s) {
            if (rg4.a(this)) {
                G1();
            } else {
                g1();
            }
            this.s = false;
        }
        if (this.t) {
            if (rg4.c(this)) {
                F1();
            } else {
                E1();
            }
            this.t = false;
        }
        if (!this.u || rg4.b(this)) {
            return;
        }
        l();
        this.u = false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void p1() {
        this.s = true;
    }
}
