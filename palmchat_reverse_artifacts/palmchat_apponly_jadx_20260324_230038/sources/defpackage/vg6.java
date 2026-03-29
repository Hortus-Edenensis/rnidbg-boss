package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.opensource.svgaplayer.SVGAImageView;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.volcengine.lxvertc.videocall.call.view.CallActivity;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import defpackage.c15;
import defpackage.vx1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class vg6 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile vg6 p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f21438a;
    public WindowManager b;
    public View d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public boolean k;
    public vx1 l;
    public d m = new d();
    public final View.OnTouchListener n = new a();
    public final ex o = new b();
    public Context c = fh.a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                vg6.this.e = motionEvent.getX();
                vg6.this.f = motionEvent.getY();
                vg6.this.g = motionEvent.getRawX();
                vg6.this.h = motionEvent.getRawY() - vg6.this.u();
                vg6.this.i = motionEvent.getRawX();
                vg6.this.j = motionEvent.getRawY() - vg6.this.u();
            } else if (action != 1) {
                if (action == 2) {
                    vg6.this.i = motionEvent.getRawX();
                    vg6.this.j = motionEvent.getRawY() - vg6.this.u();
                    vg6.this.f21438a.x = (int) (vg6.this.i - vg6.this.e);
                    vg6.this.f21438a.y = (int) (vg6.this.j - vg6.this.f);
                    vg6.this.b.updateViewLayout(vg6.this.d, vg6.this.f21438a);
                }
            } else if (vg6.this.g == vg6.this.i && vg6.this.h == vg6.this.j) {
                vg6.this.x();
                vg6.this.z();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends o0 {
        public b() {
        }

        @Override // defpackage.o0, defpackage.ex
        public void e(int i) {
            vg6.this.m.e(i86.b(i));
        }

        @Override // gy.b
        public void g(VoipState voipState, VoipState voipState2, rh6 rh6Var) {
            vg6.this.v();
            if (voipState2 == VoipState.IDLE) {
                vg6.this.x();
            }
        }
    }

    public static void D(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 3001);
        }
    }

    public static vg6 t() {
        if (p == null) {
            synchronized (vg6.class) {
                if (p == null) {
                    p = new vg6();
                }
            }
        }
        return p;
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return Settings.canDrawOverlays(fh.a());
    }

    public final void A() {
        VoipState voipStateR = com.volcengine.lxvertc.videocall.call.a.t().r();
        if (voipStateR == VoipState.CALLING || voipStateR == VoipState.RINGING) {
            this.m.e(com.zenmen.palmchat.c.b().getString(R$string.float_window_status_calling));
        }
        if (ap3.a().T().t() && voipStateR == VoipState.IDLE) {
            this.m.e(i86.b(com.volcengine.lxvertc.videocall.call.a.t().u()));
        }
    }

    public final void B(String str) {
        TextUtils.isEmpty(str);
    }

    public void C(String str) {
        if (this.k) {
            return;
        }
        this.k = true;
        com.volcengine.lxvertc.videocall.call.a.t().S(true);
        com.volcengine.lxvertc.videocall.call.a.t().o(this.o);
        y();
        if (this.d.getParent() == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.b.getDefaultDisplay().getMetrics(displayMetrics);
            WindowManager.LayoutParams layoutParams = this.f21438a;
            layoutParams.x = displayMetrics.widthPixels;
            layoutParams.y = (displayMetrics.heightPixels / 2) - u();
            this.b.addView(this.d, this.f21438a);
        }
        B(str);
        v();
        A();
    }

    public final int u() {
        Resources resources = fh.a().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void x() {
        if (this.k) {
            this.k = false;
            com.volcengine.lxvertc.videocall.call.a.t().S(false);
            if (this.d.getParent() != null) {
                this.m.d();
                this.b.removeView(this.d);
            }
            com.volcengine.lxvertc.videocall.call.a.t().P(this.o);
        }
    }

    public final void y() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.c);
        if (layoutInflaterFrom == null) {
            return;
        }
        this.d = this.m.b(layoutInflaterFrom);
        this.f21438a = new WindowManager.LayoutParams();
        this.b = (WindowManager) this.c.getSystemService("window");
        vx1 vx1Var = new vx1(this.c, this.d, this.b, this.f21438a, new c());
        this.l = vx1Var;
        this.d.setOnTouchListener(vx1Var);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f21438a.type = 2038;
        } else {
            this.f21438a.type = 2003;
        }
        WindowManager.LayoutParams layoutParams = this.f21438a;
        layoutParams.format = 1;
        layoutParams.flags = 131080;
        layoutParams.gravity = 8388659;
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    public final void z() {
        rh6 rh6VarZ = com.volcengine.lxvertc.videocall.call.a.t().z();
        if (rh6VarZ != null) {
            CallActivity.U1(rh6VarZ.a(), rh6VarZ.f, rh6VarZ.h, rh6VarZ.i, rh6VarZ.g);
            return;
        }
        np2 np2VarT = ap3.a().T();
        if (np2VarT.t()) {
            rh6 rh6Var = new rh6();
            rh6Var.b = CallType.VOICE.getValue();
            rh6Var.f = "";
            ArrayList<RoomUserInfo> arrayList = new ArrayList<>();
            rh6Var.i = arrayList;
            arrayList.add(np2VarT.x().getMatchUserInfo());
            rh6Var.g = "";
            CallActivity.U1(rh6Var.a(), rh6Var.f, rh6Var.h, rh6Var.i, rh6Var.g);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f21442a = null;
        public TextView b;
        public SVGAImageView c;

        public d() {
        }

        public View b(LayoutInflater layoutInflater) {
            if (c()) {
                View viewInflate = layoutInflater.inflate(R$layout.layout_float_window_voice_match, (ViewGroup) null);
                this.f21442a = viewInflate;
                SVGAImageView sVGAImageView = (SVGAImageView) viewInflate.findViewById(R$id.svga);
                this.c = sVGAImageView;
                sVGAImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.c.setFillMode(SVGAImageView.FillMode.Clear);
                this.c.setLoops(Integer.MAX_VALUE);
                this.c.setClearsAfterDetached(true);
                c15.INSTANCE.b().n("svga/match_float_chatting.svga", new a(), null);
            } else {
                this.f21442a = layoutInflater.inflate(R$layout.layout_float_window_voice, (ViewGroup) null);
                this.c = null;
            }
            this.b = (TextView) this.f21442a.findViewById(R$id.audio_time);
            return this.f21442a;
        }

        public final boolean c() {
            return ap3.a().T().t();
        }

        public void d() {
            SVGAImageView sVGAImageView = this.c;
            if (sVGAImageView != null) {
                sVGAImageView.stopAnimation();
            }
        }

        public void e(String str) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements c15.d {
            public a() {
            }

            @Override // c15.d
            public void onComplete(@NonNull m15 m15Var) {
                d.this.c.setVideoItem(m15Var);
                d.this.c.startAnimation();
            }

            @Override // c15.d
            public void onError() {
            }
        }
    }

    public final void v() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements vx1.a {
        public c() {
        }

        @Override // vx1.a
        public void onClick() {
            vg6.this.x();
            vg6.this.z();
        }

        @Override // vx1.a
        public void a(int i, int i2) {
        }
    }
}
