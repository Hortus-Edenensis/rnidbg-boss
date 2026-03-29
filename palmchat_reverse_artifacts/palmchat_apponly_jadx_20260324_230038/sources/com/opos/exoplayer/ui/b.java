package com.opos.exoplayer.ui;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.exoplayer.core.Player;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.source.p;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.h;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.video.e;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8447a;
    private final AspectRatioFrameLayout b;
    private View c;
    private final ViewOnLayoutChangeListenerC0710b d;
    private final View e;
    private final ImageView f;
    private final c g;
    private final com.opos.exoplayer.ui.a h;
    private final FrameLayout i;
    private Player j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;

    /* JADX INFO: renamed from: com.opos.exoplayer.ui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class ViewOnLayoutChangeListenerC0710b extends Player.a implements View.OnLayoutChangeListener, h, e {
        private ViewOnLayoutChangeListenerC0710b() {
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a() {
            if (b.this.e != null) {
                b.this.e.setVisibility(4);
            }
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void b(int i) {
            if (b.this.d() && b.this.p) {
                b.this.a();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            b.b((TextureView) view, b.this.r);
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a(int i, int i2, int i3, float f) {
            if (b.this.b == null) {
                return;
            }
            float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
            if (b.this.c instanceof TextureView) {
                if (i3 == 90 || i3 == 270) {
                    f2 = 1.0f / f2;
                }
                if (b.this.r != 0) {
                    b.this.c.removeOnLayoutChangeListener(this);
                }
                b.this.r = i3;
                if (b.this.r != 0) {
                    b.this.c.addOnLayoutChangeListener(this);
                }
                b.b((TextureView) b.this.c, b.this.r);
            }
            b.this.b.a(f2);
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void a(p pVar, g gVar) {
            b.this.e();
        }

        @Override // com.opos.exoplayer.core.text.h
        public void a(List<Cue> list) {
            if (b.this.g != null) {
                b.this.g.a(list);
            }
        }

        @Override // com.opos.exoplayer.core.Player.a, com.opos.exoplayer.core.Player.b
        public void a(boolean z, int i) {
            if (b.this.d() && b.this.p) {
                b.this.a();
            } else {
                b.this.b(false);
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    private void f() {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f.setVisibility(4);
        }
    }

    public View b() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.j;
        if (player != null && player.o()) {
            this.i.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = d(keyEvent.getKeyCode()) && this.k && !this.h.d();
        b(true);
        return z || a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.k || this.j == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.h.d()) {
            b(true);
        } else if (this.q) {
            this.h.c();
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.k || this.j == null) {
            return false;
        }
        b(true);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Player player = this.j;
        return player != null && player.o() && this.j.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Player player = this.j;
        if (player == null) {
            return;
        }
        g gVarG = player.g();
        for (int i = 0; i < gVarG.f8127a; i++) {
            if (this.j.b(i) == 2 && gVarG.a(i) != null) {
                f();
                return;
            }
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.l) {
            for (int i2 = 0; i2 < gVarG.f8127a; i2++) {
                f fVarA = gVarG.a(i2);
                if (fVarA != null) {
                    for (int i3 = 0; i3 < fVarA.e(); i3++) {
                        Metadata metadata = fVarA.a(i3).d;
                        if (metadata != null && a(metadata)) {
                            return;
                        }
                    }
                }
            }
            if (a(this.m)) {
                return;
            }
        }
        f();
    }

    public void c(int i) {
        View view = this.e;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8447a = 2;
        if (isInEditMode()) {
            this.b = null;
            this.d = null;
            this.c = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            ImageView imageView = new ImageView(context);
            if (y.f8407a >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        this.d = new ViewOnLayoutChangeListenerC0710b();
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
        this.b = aspectRatioFrameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(aspectRatioFrameLayout, layoutParams);
        a(aspectRatioFrameLayout, 0);
        View view = new View(context);
        this.e = view;
        view.setBackgroundColor(-16777216);
        aspectRatioFrameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (this.f8447a != 0) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            View textureView = this.f8447a == 2 ? new TextureView(context) : new SurfaceView(context);
            this.c = textureView;
            textureView.setLayoutParams(layoutParams2);
            aspectRatioFrameLayout.addView(this.c, 0);
        } else {
            this.c = null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.i = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(context);
        this.f = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        aspectRatioFrameLayout.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        this.l = true;
        c cVar = new c(context);
        this.g = cVar;
        aspectRatioFrameLayout.addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        cVar.b();
        cVar.a();
        View view2 = new View(context);
        addView(view2, new FrameLayout.LayoutParams(-1, -1));
        com.opos.exoplayer.ui.a aVar = new com.opos.exoplayer.ui.a(context, null, 0, attributeSet);
        this.h = aVar;
        aVar.setLayoutParams(view2.getLayoutParams());
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeView(view2);
        viewGroup.addView(aVar, iIndexOfChild);
        this.n = this.n;
        this.q = true;
        this.o = true;
        this.p = true;
        this.k = true;
        a();
    }

    private void c(boolean z) {
        if (this.k) {
            this.h.a(z ? 0 : this.n);
            this.h.b();
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean d(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public void a() {
        com.opos.exoplayer.ui.a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void b(int i) {
        com.opos.exoplayer.core.util.a.b(this.b != null);
        this.b.a(i);
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    private boolean c() {
        Player player = this.j;
        if (player == null) {
            return true;
        }
        int iC = player.c();
        return this.o && (iC == 1 || iC == 4 || !this.j.d());
    }

    public void a(int i) {
        if (this.f8447a == i || this.j == null || this.b == null) {
            return;
        }
        View view = this.c;
        this.f8447a = i;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View surfaceView = this.f8447a == 1 ? new SurfaceView(getContext()) : new TextureView(getContext());
        this.c = surfaceView;
        surfaceView.setLayoutParams(layoutParams);
        Player.d dVarA = this.j.a();
        if (dVarA != null) {
            if (view != null) {
                this.b.removeView(view);
                if (view instanceof TextureView) {
                    dVarA.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    dVarA.b((SurfaceView) view);
                }
            }
            View view2 = this.c;
            if (view2 != null) {
                this.b.addView(view2, 0);
                View view3 = this.c;
                if (view3 instanceof TextureView) {
                    dVarA.a((TextureView) view3);
                } else if (view3 instanceof SurfaceView) {
                    dVarA.a((SurfaceView) view3);
                }
            }
        }
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextureView textureView, int i) {
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform(null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate(i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!(d() && this.p) && this.k) {
            boolean z2 = this.h.d() && this.h.a() <= 0;
            boolean zC = c();
            if (z || z2 || zC) {
                c(zC);
            }
            if (z || zC) {
                c(zC);
            }
        }
    }

    public void a(Player player) {
        Player player2 = this.j;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.b(this.d);
            Player.d dVarA = this.j.a();
            if (dVarA != null) {
                dVarA.b(this.d);
                View view = this.c;
                if (view instanceof TextureView) {
                    dVarA.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    dVarA.b((SurfaceView) view);
                }
            }
            Player.c cVarB = this.j.b();
            if (cVarB != null) {
                cVarB.b(this.d);
            }
        }
        this.j = player;
        if (this.k) {
            this.h.a(player);
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        c cVar = this.g;
        if (cVar != null) {
            cVar.b(null);
        }
        if (player == null) {
            a();
            f();
            return;
        }
        Player.d dVarA2 = player.a();
        if (dVarA2 != null) {
            View view3 = this.c;
            if (view3 instanceof TextureView) {
                dVarA2.a((TextureView) view3);
            } else if (view3 instanceof SurfaceView) {
                dVarA2.a((SurfaceView) view3);
            }
            dVarA2.a(this.d);
        }
        Player.c cVarB2 = player.b();
        if (cVarB2 != null) {
            cVarB2.a(this.d);
        }
        player.a(this.d);
        b(false);
        e();
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.a(i);
    }

    public void a(boolean z) {
        com.opos.exoplayer.ui.a aVar;
        Player player;
        com.opos.exoplayer.core.util.a.b((z && this.h == null) ? false : true);
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            aVar = this.h;
            player = this.j;
        } else {
            com.opos.exoplayer.ui.a aVar2 = this.h;
            if (aVar2 == null) {
                return;
            }
            aVar2.c();
            aVar = this.h;
            player = null;
        }
        aVar.a(player);
    }

    private boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                AspectRatioFrameLayout aspectRatioFrameLayout = this.b;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.a(width / height);
                }
                this.f.setImageBitmap(bitmap);
                this.f.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return this.k && this.h.a(keyEvent);
    }

    private boolean a(Metadata metadata) {
        for (int i = 0; i < metadata.a(); i++) {
            Metadata.Entry entryA = metadata.a(i);
            if (entryA instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entryA).d;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }
}
