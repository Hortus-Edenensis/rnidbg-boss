package com.opos.mobad.video.player;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.opos.cmn.module.ui.b.c.d;
import com.opos.cmn.module.ui.b.e.a;
import com.opos.mobad.template.h.p;
import com.opos.mobad.template.h.y;
import com.opos.mobad.ui.b.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10269a;
    private com.opos.cmn.module.ui.b.g.a b;
    private p c;
    private com.opos.cmn.module.ui.b.g.a d;
    private y e;
    private com.opos.cmn.module.ui.b.c.d f;
    private InterfaceC0807b g;
    private Dialog h;
    private com.opos.cmn.module.ui.b.a i;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0807b {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public b(Activity activity) {
        this.f10269a = activity;
    }

    public Dialog a(String str, String str2, e.b bVar) {
        if (com.opos.cmn.i.b.a(this.f10269a)) {
            return null;
        }
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        Dialog dialogA = e.a(this.f10269a, str, str2, bVar);
        this.h = dialogA;
        a(dialogA.getWindow());
        return this.h;
    }

    public void b() {
        com.opos.cmn.module.ui.b.g.a aVar = this.b;
        if (aVar != null && aVar.isShowing()) {
            this.b.dismiss();
        }
        if (com.opos.cmn.i.b.a(this.f10269a)) {
            return;
        }
        if (this.d == null) {
            y yVarA = y.a(this.f10269a.getApplicationContext());
            this.e = yVarA;
            yVarA.a(new y.a() { // from class: com.opos.mobad.video.player.b.5
                @Override // com.opos.mobad.template.h.y.a
                public void a(View view, int[] iArr) {
                    b.this.d.dismiss();
                    if (b.this.g != null) {
                        b.this.g.a(view, iArr);
                    }
                }
            });
            com.opos.cmn.module.ui.b.g.a aVar2 = new com.opos.cmn.module.ui.b.g.a(this.f10269a, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new a.C0676a().a(R.style.Theme.Translucent.NoTitleBar.Fullscreen).a(false).b(false).a());
            this.d = aVar2;
            aVar2.setContentView(this.e);
            a(this.d.getWindow());
        }
        this.d.show();
    }

    public void c() {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        com.opos.cmn.module.ui.b.g.a aVar = this.b;
        if (aVar != null && aVar.isShowing()) {
            this.b.dismiss();
        }
        com.opos.cmn.module.ui.b.c.d dVar = this.f;
        if (dVar != null && dVar.a()) {
            this.f.b();
        }
        com.opos.cmn.module.ui.b.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.opos.cmn.module.ui.b.g.a aVar3 = this.d;
        if (aVar3 != null && aVar3.isShowing()) {
            this.d.dismiss();
        }
        this.f10269a = null;
    }

    public void a() {
        com.opos.cmn.module.ui.b.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b(final a aVar) {
        if (com.opos.cmn.i.b.a(this.f10269a)) {
            return;
        }
        com.opos.cmn.module.ui.b.c.d dVar = this.f;
        if (dVar == null) {
            this.f = new d.a(this.f10269a.getApplicationContext()).a("当前为非WIFI环境,是否使用\n流量观看？").b("关闭视频", new d.b() { // from class: com.opos.mobad.video.player.b.3
                @Override // com.opos.cmn.module.ui.b.c.d.b
                public void a(com.opos.cmn.module.ui.b.c.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }).a("继续观看", new d.b() { // from class: com.opos.mobad.video.player.b.2
                @Override // com.opos.cmn.module.ui.b.c.d.b
                public void a(com.opos.cmn.module.ui.b.c.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }).a();
        } else {
            dVar.a("wifi");
        }
        this.f.a(this.f10269a);
    }

    public static final void a(final Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.getDecorView().setSystemUiVisibility(5894);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.video.player.b.6
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (2 == (i & 2) && 4 == (i & 4)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("DialogTemplate", "reset system ui");
                window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    public void a(final a aVar) {
        if (aVar == null || com.opos.cmn.i.b.a(this.f10269a) || this.i != null) {
            return;
        }
        com.opos.cmn.module.ui.b.a aVar2 = new com.opos.cmn.module.ui.b.a(this.f10269a);
        this.i = aVar2;
        aVar2.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.video.player.b.1
            @Override // com.opos.cmn.module.ui.b.d.a
            public void a(View view, int[] iArr) {
                aVar.b();
                b.this.i.a();
            }

            @Override // com.opos.cmn.module.ui.b.d.a
            public void b(View view, int[] iArr) {
                aVar.a();
                b.this.i.a();
            }
        });
    }

    public void a(InterfaceC0807b interfaceC0807b) {
        this.g = interfaceC0807b;
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        com.opos.cmn.module.ui.b.g.a aVar = this.d;
        if ((aVar == null || !aVar.isShowing()) && !com.opos.cmn.i.b.a(this.f10269a)) {
            if (this.b == null) {
                p pVarA = p.a(this.f10269a.getApplicationContext());
                this.c = pVarA;
                pVarA.a(new p.a() { // from class: com.opos.mobad.video.player.b.4
                    @Override // com.opos.mobad.template.h.p.a
                    public void a(View view, int[] iArr) {
                        b.this.b.dismiss();
                        if (b.this.g != null) {
                            b.this.g.a(view, iArr);
                        }
                    }

                    @Override // com.opos.mobad.template.h.p.a
                    public void b(View view, int[] iArr) {
                        b.this.b.dismiss();
                        if (b.this.g != null) {
                            b.this.g.b(view, iArr);
                        }
                    }
                });
                com.opos.cmn.module.ui.b.g.a aVar2 = new com.opos.cmn.module.ui.b.g.a(this.f10269a, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new a.C0676a().a(R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
                this.b = aVar2;
                aVar2.setContentView(this.c);
                a(this.b.getWindow());
            }
            this.c.b(charSequence2);
            this.c.c(charSequence3);
            this.c.a(charSequence);
            this.b.show();
        }
    }
}
