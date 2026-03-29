package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.BaseImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseImageView f9520a;
    private BaseImageView b;
    private h c;
    private Context d;

    public i(Context context) {
        super(context);
        if (context == null) {
            return;
        }
        this.d = context.getApplicationContext();
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, 51));
        BaseImageView baseImageViewB = b(context);
        this.f9520a = baseImageViewB;
        addView(baseImageViewB);
        addView(a(context));
        BaseImageView baseImageView = new BaseImageView(context);
        this.b = baseImageView;
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 145.0f), -1);
        this.b.setLayoutParams(layoutParams);
        layoutParams.addRule(14);
        addView(this.b);
        h hVar = new h(context, 0);
        this.c = hVar;
        addView(hVar);
    }

    private View a(Context context) {
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        return view;
    }

    private BaseImageView b(Context context) {
        BaseImageView baseImageView = new BaseImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        baseImageView.setLayoutParams(layoutParams);
        return baseImageView;
    }

    @Override // com.opos.mobad.template.f.d
    public RelativeLayout a() {
        return this;
    }

    @Override // com.opos.mobad.template.f.d
    public void a(Bitmap bitmap) {
        if (this.d != null) {
            BaseImageView baseImageView = this.b;
            if (baseImageView != null) {
                baseImageView.setImageBitmap(bitmap);
            }
            BaseImageView baseImageView2 = this.f9520a;
            if (baseImageView2 != null) {
                baseImageView2.setImageBitmap(com.opos.mobad.template.cmn.f.a(this.d, bitmap, 75, 0.25f, 60.0f));
            }
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(a.InterfaceC0778a interfaceC0778a) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(interfaceC0778a);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        BaseImageView baseImageView = this.f9520a;
        if (baseImageView != null) {
            baseImageView.a(fVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.p pVar) {
        BaseImageView baseImageView = this.f9520a;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.f9520a.setOnTouchListener(pVar);
        }
        BaseImageView baseImageView2 = this.b;
        if (baseImageView2 != null) {
            baseImageView2.setOnClickListener(pVar);
            this.b.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(bVar, bitmap);
        }
    }
}
