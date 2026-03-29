package defpackage;

import android.view.TextureView;
import com.volcengine.lxvertc.videocall.call.a;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class il4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18195a = false;
    public TextureView b = null;

    public void a(TextureView textureView) {
        if (!this.f18195a && tg4.b(c.b(), BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL.permissionList)) {
            this.b = textureView;
            textureView.setVisibility(0);
            this.f18195a = true;
            LogUtil.i("PreViewController", "startPreView");
            LxVoipManager.b().e("videoMatch");
            dr4 dr4VarW = a.t().w();
            dr4VarW.r(textureView);
            dr4VarW.t();
            ap3.a().T().l(true);
            LogUtil.i("PreViewController", "startPreView end");
        }
    }

    public void b() {
        LogUtil.i("PreViewController", "stopPreView ");
        this.f18195a = false;
        TextureView textureView = this.b;
        if (textureView != null) {
            textureView.setVisibility(8);
        }
        dr4 dr4VarW = a.t().w();
        if (dr4VarW != null) {
            dr4VarW.y();
            LogUtil.i("PreViewController", "stopPreView end");
        }
        ap3.a().T().l(false);
    }
}
