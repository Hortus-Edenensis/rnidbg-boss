package defpackage;

import android.app.AppOpsManager;
import android.app.PictureInPictureParams;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import android.view.TextureView;
import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import com.volcengine.lxvertc.videocall.call.a;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class mb6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentActivity f19191a;
    public final ActivityVideoCallVoipBinding b;
    public TextureView c;
    public TextureView d;
    public String e;
    public String f;
    public final HashMap<String, Boolean> g;
    public Boolean h;

    public mb6(ComponentActivity componentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, TextureView textureView, TextureView textureView2, HashMap<String, Boolean> map) {
        this.f19191a = componentActivity;
        this.b = activityVideoCallVoipBinding;
        this.c = textureView;
        this.d = textureView2;
        this.g = map;
    }

    public void a(Rational rational, String str, String str2) {
        if (!d() || c()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hg5.g("暂不支持");
            return;
        }
        if (!b()) {
            hg5.d(R$string.pip_permission_guide);
            f();
            return;
        }
        this.e = str;
        this.f = str2;
        PictureInPictureParams pictureInPictureParamsBuild = gb6.a().setAspectRatio(rational).build();
        if (this.f19191a.getLifecycle().getState() != Lifecycle.State.RESUMED) {
            return;
        }
        this.f19191a.enterPictureInPictureMode(pictureInPictureParamsBuild);
    }

    @RequiresApi(api = 26)
    public final boolean b() {
        AppOpsManager appOpsManager = (AppOpsManager) this.f19191a.getSystemService("appops");
        if (appOpsManager == null) {
            return false;
        }
        int iMyUid = Process.myUid();
        String packageName = this.f19191a.getPackageName();
        return Build.VERSION.SDK_INT >= 29 ? appOpsManager.unsafeCheckOpNoThrow("android:picture_in_picture", iMyUid, packageName) == 0 : appOpsManager.checkOpNoThrow("android:picture_in_picture", iMyUid, packageName) == 0;
    }

    public boolean c() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return this.f19191a.isInPictureInPictureMode();
    }

    public final boolean d() {
        if (this.h == null) {
            this.h = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && this.f19191a.getPackageManager().hasSystemFeature("android.software.picture_in_picture"));
        }
        return this.h.booleanValue();
    }

    public void e(boolean z, String str) {
        Log.d("VideoFloatWindow", "VideoFloatWindowComponent onPictureInPictureModeChanged isInPiPMode:" + z);
        a.t().S(z);
        k(z, str);
    }

    public final void f() {
        try {
            this.f19191a.startActivity(new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS"));
        } catch (Exception e) {
            Log.d("VideoFloatWindow", "start pip permission failed:" + e);
        }
    }

    public final void g(TextureView textureView, String str, String str2) {
        dr4 dr4VarW = a.t().w();
        textureView.setTag(R$id.render_view_uid, str);
        boolean z = this.g.get(str) != null && Boolean.TRUE.equals(this.g.get(str));
        textureView.setVisibility(z ? 0 : 8);
        if (z) {
            if (TextUtils.equals(eg5.c().a(), str)) {
                dr4VarW.r(textureView);
            } else {
                dr4VarW.s(str, str2, textureView);
            }
        }
    }

    public final void h(VoipState voipState) {
        if (c()) {
            int i = voipState == VoipState.CALLING ? R$string.calling_wait_accept : voipState == VoipState.RINGING ? R$string.called_video_wait_accept : voipState == VoipState.IDLE ? R$string.called_video_state_end : 0;
            if (i != 0) {
                i(i86.c(i, new String[0]));
            }
        }
    }

    public void i(String str) {
        j(str, -1);
    }

    public void j(String str, int i) {
        if (!c() || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.g.setText(str);
        this.b.g.setTextColor(i);
    }

    public void k(boolean z, String str) {
        VoipState voipStateR = a.t().r();
        String strA = voipStateR != VoipState.ONTHECALL ? eg5.c().a() : this.e;
        LogUtil.i("RTC", "updateFloatWindowUi floatWindowRenderUid=" + strA);
        if (z) {
            this.b.c.setVisibility(0);
            g(this.b.i, strA, str);
            l(voipStateR);
            h(voipStateR);
            this.b.d.setVisibility(8);
            return;
        }
        this.b.d.setVisibility(0);
        TextureView textureView = this.d;
        int i = R$id.render_view_uid;
        g(this.d, (String) textureView.getTag(i), str);
        g(this.c, (String) this.c.getTag(i), str);
        this.b.c.setVisibility(8);
        this.f = null;
    }

    public final void l(VoipState voipState) {
        rh6 rh6VarZ;
        ArrayList<RoomUserInfo> arrayList;
        RoomUserInfo roomUserInfo;
        if (!c() || voipState == null || (rh6VarZ = a.t().z()) == null || (arrayList = rh6VarZ.i) == null || arrayList.size() <= 0 || (roomUserInfo = rh6VarZ.j) == null) {
            return;
        }
        RoomUserInfo roomUserInfo2 = roomUserInfo.uid.equals(eg5.c().a()) ? rh6VarZ.i.get(0) : rh6VarZ.j;
        if (roomUserInfo2 != null) {
            hc2.a(c.b()).load(k86.p(roomUserInfo2.headImg)).error(R$drawable.video_call_icon_loading_fail_bg).transform(new gu(14, 3)).into(this.b.h);
        }
    }
}
