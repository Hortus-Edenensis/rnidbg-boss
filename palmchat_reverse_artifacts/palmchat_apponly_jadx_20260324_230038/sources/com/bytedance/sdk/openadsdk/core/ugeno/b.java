package com.bytedance.sdk.openadsdk.core.ugeno;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.ge;
import com.bytedance.sdk.openadsdk.core.y.bg;
import defpackage.td;
import defpackage.ud;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.adsdk.ugeno.u {

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable fx(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zFx = com.bytedance.sdk.openadsdk.core.multipro.nr.fx();
            File fileNr = com.bytedance.sdk.component.utils.n.nr(dw.getContext(), zFx, zFx ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileNr);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileNr));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dw.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th) {
                th = th;
                try {
                    k.u("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public void nr(s sVar, String str, final u.InterfaceC0173u interfaceC0173u) {
        com.bytedance.sdk.component.iz.s sVarType = com.bytedance.sdk.openadsdk.n.nr.u(str).type(1);
        u(sVar, sVarType, str);
        sVarType.to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.3
            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str2, Throwable th) {
                u.InterfaceC0173u interfaceC0173u2 = interfaceC0173u;
                if (interfaceC0173u2 != null) {
                    interfaceC0173u2.u(null);
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my myVar) {
                if (myVar == null) {
                    interfaceC0173u.u(null);
                    return;
                }
                u.InterfaceC0173u interfaceC0173u2 = interfaceC0173u;
                if (interfaceC0173u2 == null) {
                    interfaceC0173u2.u(null);
                    return;
                }
                if (myVar.getResult() instanceof Bitmap) {
                    interfaceC0173u.u((Bitmap) myVar.getResult());
                } else if (myVar.getResult() instanceof byte[]) {
                    try {
                        interfaceC0173u.u(BitmapFactory.decodeByteArray((byte[]) myVar.getResult(), 0, ((byte[]) myVar.getResult()).length));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.u
    public void u(s sVar, String str, ImageView imageView, u.InterfaceC0173u interfaceC0173u) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.n.nr.u(str).type(3).config(Bitmap.Config.RGB_565).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.1
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my myVar) {
                    try {
                        Object result = myVar.getResult();
                        if (!(result instanceof byte[])) {
                            if (result instanceof Bitmap) {
                                gifView.setImageBitmap((Bitmap) result);
                            }
                        } else if (!myVar.isGif()) {
                            gifView.setImageDrawable(bg.u((byte[]) result, 0));
                        } else {
                            gifView.u((byte[]) result, false);
                            gifView.setRepeatConfig(true);
                            gifView.nr();
                        }
                    } catch (Throwable th) {
                        onFailed(1002, "", th);
                    }
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str2, Throwable th) {
                }
            });
            return;
        }
        com.bytedance.sdk.component.iz.s sVarU = com.bytedance.sdk.openadsdk.n.nr.u(str);
        u(sVar, sVarU, str);
        sVarU.to(imageView);
    }

    public boolean nr(byte[] bArr) {
        return TextUtils.equals("png", l.u(Arrays.copyOfRange(bArr, 0, l.u()))) && com.bytedance.sdk.component.adexpress.b.iz.u(bArr);
    }

    @Override // com.bytedance.adsdk.ugeno.u
    public void u(s sVar, String str, final ImageView imageView, int i, int i2, u.InterfaceC0173u interfaceC0173u) {
        com.bytedance.sdk.component.iz.s sVarType = com.bytedance.sdk.openadsdk.n.nr.u(str).type(3);
        u(sVar, sVarType, str);
        sVarType.to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.2
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(final my myVar) {
                if (imageView.isAttachedToWindow()) {
                    b.this.u(myVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            b.this.u(myVar, imageView);
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i3, String str2, Throwable th) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(my myVar, ImageView imageView) {
        Object result = myVar.getResult();
        if (result instanceof byte[]) {
            if (!myVar.isGif()) {
                byte[] bArr = (byte[]) result;
                if (!nr(bArr)) {
                    if (u(bArr)) {
                        com.bytedance.sdk.component.adexpress.b.iz.u(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int iU = ge.u(imageView.getWidth(), imageView.getHeight());
                    Bitmap bitmapU = new com.bytedance.sdk.component.iz.fx.nr.u(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / iU, imageView.getHeight() / iU).u(bArr);
                    if (bitmapU != null) {
                        imageView.setImageBitmap(bitmapU);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                u((byte[]) result, imageView);
                return;
            } else {
                com.bytedance.sdk.component.adexpress.b.iz.u(imageView, (byte[]) result, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (result instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) result);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u
    public void u(s sVar, String str, u.InterfaceC0173u interfaceC0173u) {
        nr(sVar, str, interfaceC0173u);
    }

    private void u(s sVar, com.bytedance.sdk.component.iz.s sVar2, String str) {
        Map<String, Object> mapNr;
        if (sVar == null || (mapNr = sVar.nr()) == null) {
            return;
        }
        Object obj = mapNr.get("image_info");
        if (obj instanceof Map) {
            sVar2.key((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapNr.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sVar2.cacheDir(str2);
    }

    private void u(byte[] bArr, final ImageView imageView) {
        try {
            k.nr("ImageLoaderProvider", "load animation image");
            u(bArr, new u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.4
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.b.u
                public void u(final Drawable drawable) {
                    com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && td.a(drawable)) {
                                ud.a(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception unused) {
        }
    }

    private void u(final byte[] bArr, final u uVar) {
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("csj_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.b.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawableFx = b.this.fx(bArr);
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(drawableFx);
                }
            }
        });
    }

    public boolean u(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.b.iz.u(bArr, 0);
    }
}
