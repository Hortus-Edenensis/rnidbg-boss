package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.aa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class z implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9885a = false;
    private int b = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
    private int c = 84;
    private int d = 0;
    private int e;
    private Context f;
    private a.InterfaceC0778a g;
    private int h;
    private int i;
    private com.opos.mobad.template.d.b j;
    private com.opos.mobad.template.cmn.n k;
    private aa l;
    private com.opos.mobad.template.cmn.baseview.c m;
    private com.opos.mobad.template.cmn.w n;
    private com.opos.mobad.template.cmn.aa o;
    private com.opos.mobad.d.a p;

    private z(Context context, am amVar, int i, int i2, com.opos.mobad.d.a aVar) {
        this.f = context;
        this.i = i2;
        this.h = i;
        this.p = aVar;
        f();
        a(amVar);
        j();
        i();
    }

    private void f() {
        this.d = com.opos.cmn.an.h.f.a.a(this.f, 128.0f);
        if (this.i == 1) {
            this.b = com.opos.cmn.an.h.f.a.a(this.f, 320.0f);
            this.c = com.opos.cmn.an.h.f.a.a(this.f, 84.0f);
        }
        this.e = this.c;
    }

    private void g() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.f);
        this.n = wVar;
        wVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, this.c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        h();
    }

    private void h() {
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.f, com.opos.cmn.an.h.f.a.a(r1, 4.0f));
        this.k = nVar;
        nVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.d, this.c);
        if (this.i == 1) {
            layoutParams.addRule(11);
        }
        this.n.addView(this.k, layoutParams);
        this.l = aa.a(this.f, this.p);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f, 184.0f), this.c);
        if (this.i == 1) {
            layoutParams2.addRule(0, this.k.getId());
            layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(this.f, 8.0f);
        }
        this.n.addView(this.l, layoutParams2);
    }

    private void i() {
        final com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.f);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.g.z.3
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (z.this.j == null) {
                    return;
                }
                if (z) {
                    if (z.this.g != null) {
                        z.this.g.a((Map<String, String>) null);
                    }
                    aVar.a((a.InterfaceC0735a) null);
                }
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "BlockSmallImage7 onWindowVisibilityChanged：" + z);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.g.z.4
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (z.this.j == null) {
                    return;
                }
                if (z.this.g != null) {
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    z.this.g.a(map);
                }
                aVar.a((a.c) null, (View) null);
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "BlockSmallImage7 onViewVisibleWithoutFocus：" + z + ", " + z2);
            }
        }, c());
        this.m.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void j() {
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.h;
    }

    public static z a(Context context, am amVar, int i, com.opos.mobad.d.a aVar) {
        return new z(context, amVar, i, 1, aVar);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockSmallImage7", "destroy");
        this.j = null;
        this.f9885a = true;
        com.opos.mobad.template.cmn.aa aaVar = this.o;
        if (aaVar != null) {
            aaVar.removeAllViews();
        }
    }

    private void b(final com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.cmn.n nVar;
        List<com.opos.mobad.template.d.e> list = bVar.c;
        if (list == null || list.size() == 0 || (nVar = this.k) == null) {
            return;
        }
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.a(bVar.c.get(0).f9414a, bVar.c.get(0).b, this.b, this.c, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.g.z.5
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (z.this.f9885a) {
                    return;
                }
                if (bVar.c.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage7", "null imgList");
                    return;
                }
                if (i != 0 && i != 1) {
                    if (z.this.g != null) {
                        z.this.g.c(i);
                    }
                } else {
                    if (i == 1 && z.this.g != null) {
                        z.this.g.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.g.z.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (z.this.f9885a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            z.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.g = interfaceC0778a;
        this.l.a(interfaceC0778a);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        b(bVar);
        this.l.a(bVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        String str;
        a.InterfaceC0778a interfaceC0778a;
        if (fVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.template.d.b bVarA = fVar.a();
            if (bVarA == null) {
                str = "adShowData is null";
            } else {
                List<com.opos.mobad.template.d.e> list = bVarA.c;
                if (list != null && list.size() > 0) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage7", "render");
                    if (this.j == null && (interfaceC0778a = this.g) != null) {
                        interfaceC0778a.f();
                    }
                    this.j = bVarA;
                    com.opos.mobad.template.cmn.aa aaVar = this.o;
                    if (aaVar != null && aaVar.getVisibility() != 0) {
                        this.o.setVisibility(0);
                    }
                    com.opos.mobad.template.cmn.baseview.c cVar = this.m;
                    if (cVar != null && cVar.getVisibility() != 0) {
                        this.m.setVisibility(0);
                    }
                    a(bVarA);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockSmallImage7", str);
        this.g.a(1);
    }

    private void a(am amVar) {
        if (amVar == null) {
            amVar = am.a(this.f);
        }
        Context context = this.f;
        int i = amVar.f9704a;
        int i2 = amVar.b;
        int i3 = this.b;
        this.o = new com.opos.mobad.template.cmn.aa(context, new aa.a(i, i2, i3, i3 / this.e));
        this.m = new com.opos.mobad.template.cmn.baseview.c(this.f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.b, -2);
        layoutParams.width = this.b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.o.addView(this.m, layoutParams);
        this.o.setLayoutParams(layoutParams);
        g();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.z.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (z.this.g != null) {
                    z.this.g.h(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(pVar);
        this.m.setOnTouchListener(pVar);
        this.m.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.z.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i4, boolean z) {
                com.opos.cmn.an.f.a.a("BlockSmallImage7", "onMockEventIntercepted->clickMockEvent:" + i4 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (z.this.g != null) {
                    z.this.g.a(view, i4, z);
                }
            }
        });
    }
}
