package com.beizi.ad.v2.g;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.d.a;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.i;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.internal.e.u;
import com.beizi.ad.lance.a.c;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.d;
import com.beizi.ad.model.f;
import com.beizi.fusion.R;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends com.beizi.ad.v2.a.b {
    private ViewGroup G;
    private View H;
    private com.beizi.ad.a I;
    private CountDownTimer J;
    private String K;
    private f.EnumC0131f L;
    private int M;
    private int N;
    private WebView O;
    private com.beizi.ad.v2.b.a P;

    public b(Context context, ViewGroup viewGroup, View view, String str) {
        super(context, str, com.beizi.ad.internal.f.NEW_SPLASH);
        this.G = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        View viewB;
        FrameLayout frameLayoutA;
        try {
            ViewGroup viewGroup = this.G;
            if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
                Context context = viewGroup.getContext();
                LinearLayout linearLayout = new LinearLayout(this.G.getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                a.C0114a c0114aK = this.c.k();
                if (!TextUtils.isEmpty(c0114aK.a()) && (frameLayoutA = t.a(new MutableContextWrapper(context), c0114aK)) != null) {
                    linearLayout.addView(frameLayoutA, new FrameLayout.LayoutParams(-2, -2, 17));
                    frameLayoutA.setVisibility(0);
                    frameLayoutA.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                        }
                    });
                }
                a.C0114a c0114aJ = this.c.j();
                if (!TextUtils.isEmpty(c0114aJ.a()) && (viewB = t.b(new MutableContextWrapper(this.G.getContext()), c0114aJ)) != null) {
                    linearLayout.addView(viewB, new FrameLayout.LayoutParams(-2, -2, 17));
                    viewB.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
                    layoutParams.setMargins(5, 0, 0, 0);
                    layoutParams.gravity = 17;
                    viewB.setLayoutParams(layoutParams);
                }
                ((FrameLayout) this.G).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int iA = t.a(context, 12.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            com.beizi.ad.internal.d.a aVar = this.c;
            if (aVar != null && this.G != null) {
                int iT = aVar.t();
                if (iT == 2 || iT == 5) {
                    final String strL = this.c.l();
                    String strO = this.c.o();
                    String strN = this.c.n();
                    String strQ = this.c.q();
                    final String strP = !TextUtils.isEmpty(strQ) ? strQ : this.c.p();
                    final String strR = this.c.r();
                    final String strS = this.c.s();
                    final Context context = this.G.getContext();
                    TextView textView = new TextView(context);
                    textView.setText(Html.fromHtml("应用名称：" + strL + " | 开发者：" + strO + " | 应用版本：" + strN + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    textView.setTextSize(2, 6.0f);
                    textView.setTextColor(Color.parseColor("#999999"));
                    textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.9
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                Intent intent = new Intent(context, (Class<?>) DownloadAppInfoActivity.class);
                                intent.putExtra("title_content_key", strL);
                                intent.putExtra("privacy_content_key", strR);
                                intent.putExtra("permission_content_key", strP);
                                intent.putExtra("intro_content_key", strS);
                                intent.setFlags(268435456);
                                context.startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    int iD = (q.d(context) * 2) / 3;
                    ViewGroup viewGroup = this.G;
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).addView(textView, new FrameLayout.LayoutParams(iD, -2, 83));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.j) {
            return;
        }
        this.g = true;
        if (this.I != null) {
            Log.e("BeiZisAd", "enter BeiZi ad load");
            this.I.a();
        }
    }

    private void D() {
        if (this.L == f.EnumC0131f.RENDER_PIC && !TextUtils.isEmpty(this.K)) {
            h.a((Context) null).a(this.K, false, new h.a() { // from class: com.beizi.ad.v2.g.b.3
                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                    b.this.b(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            f.EnumC0131f enumC0131f = this.L;
            if (enumC0131f == f.EnumC0131f.RENDER_PIC) {
                if (TextUtils.isEmpty(this.K)) {
                    b(3);
                    return;
                } else if (this.K.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    x();
                    return;
                } else {
                    b(7);
                    return;
                }
            }
            if (enumC0131f != f.EnumC0131f.RENDER_H5) {
                b(3);
            } else {
                if (TextUtils.isEmpty(this.K)) {
                    b(3);
                    return;
                }
                if (this.K.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.K = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>Document</title>\n  <style>\n    html, body { width: 100%; height: 100%; margin: 0; padding: 0 }\n    .material-wrap { overflow: hidden; position: relative; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: cover }\n    .filter-shadow { content: \"\"; position: absolute; z-index: 2; top: -3%; left: -3%; right: -3%; bottom: -3%; background: inherit; filter: blur(10px) }\n    .material-wrap .black-shadow { position: absolute; z-index: 3; top: 0; left: 0; right: 0; bottom: 0; background: rgba(0, 0, 0, .05) }\n    .material-wrap .material { position: absolute; z-index: 3; top: 0; left: 0; width: 100%; height: 100%; background-repeat: no-repeat; background-position: center center; background-size: contain }\n  </style>\n</head>\n<body>\n  <div class=\"material-wrap\" style=\"background-image: url('__IMAGE_SRC_PATH__')\">\n    <div class=\"filter-shadow\"></div>\n    <div class=\"black-shadow\"></div>\n    <div class=\"material\" style=\"background-image: url('__IMAGE_SRC_PATH__')\"></div>\n  </div>\n</body>\n</html>\n".replaceAll("__IMAGE_SRC_PATH__", this.K);
                }
                y();
            }
        } catch (Exception e) {
            e.printStackTrace();
            b(3);
        }
    }

    private void x() {
        final ImageView imageView;
        if (this.B) {
            try {
                imageView = new ImageView(this.G.getContext());
            } catch (Exception e) {
                e = e;
                imageView = null;
            }
            try {
                this.G.addView(imageView);
                if (this.E) {
                    imageView.setAlpha(0.0f);
                }
                if (!this.C) {
                    A();
                    B();
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } else {
            imageView = null;
        }
        h.a((Context) null).a(this.K, new h.a() { // from class: com.beizi.ad.v2.g.b.4
            @Override // com.beizi.ad.internal.e.h.a
            public void a(final Bitmap bitmap) {
                ViewGroup.LayoutParams layoutParams;
                try {
                    if (b.this.G == null) {
                        b.this.b(10);
                        return;
                    }
                    if (bitmap == null) {
                        b.this.b(8);
                        return;
                    }
                    Log.e("BeiZisAd", "renderImageView onBitmapLoaded");
                    final Context context = b.this.G.getContext();
                    float width = (float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()));
                    int i = b.this.M;
                    int i2 = b.this.N > 0 ? b.this.N : (int) (i / width);
                    final ImageView imageView2 = ((com.beizi.ad.v2.a.b) b.this).B ? imageView : new ImageView(context);
                    if (imageView2 != null && (layoutParams = imageView2.getLayoutParams()) != null) {
                        layoutParams.width = i;
                        layoutParams.height = i2;
                        imageView2.setLayoutParams(layoutParams);
                    }
                    float fAbs = Math.abs(((float) ((((double) i) * 1.0d) / ((double) i2))) - width);
                    if (fAbs > 0.1f) {
                        c.b().e().execute(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                try {
                                    Context context2 = context;
                                    if (context2 == null || (bitmap2 = bitmap) == null) {
                                        return;
                                    }
                                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(i.a(context2, bitmap2, 20.0f));
                                    if (((com.beizi.ad.v2.a.b) b.this).F != null) {
                                        ((com.beizi.ad.v2.a.b) b.this).F.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.4.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                ImageView imageView3;
                                                try {
                                                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                                    if (bitmapDrawable2 == null || (imageView3 = imageView2) == null) {
                                                        return;
                                                    }
                                                    imageView3.setBackground(bitmapDrawable2);
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        });
                    } else if (fAbs > 0.07d) {
                        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    imageView2.setImageBitmap(bitmap);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i2);
                    if (!((com.beizi.ad.v2.a.b) b.this).B) {
                        b.this.G.addView(imageView2, layoutParams2);
                        b.this.A();
                        b.this.B();
                        b.this.C();
                        return;
                    }
                    imageView2.setLayoutParams(layoutParams2);
                    if (((com.beizi.ad.v2.a.b) b.this).E) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f);
                        objectAnimatorOfFloat.setDuration(200L);
                        objectAnimatorOfFloat.start();
                    }
                    if (((com.beizi.ad.v2.a.b) b.this).C) {
                        b.this.A();
                        b.this.B();
                    }
                    if (b.this.P != null) {
                        b.this.P.a();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    b.this.b(8);
                }
            }

            @Override // com.beizi.ad.internal.e.h.a
            public void a() {
                if (((com.beizi.ad.v2.a.b) b.this).B) {
                    try {
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageView.setImageResource(R.drawable.beizi_bg_place_holder);
                            if (((com.beizi.ad.v2.a.b) b.this).E) {
                                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
                                objectAnimatorOfFloat.setDuration(200L);
                                objectAnimatorOfFloat.start();
                            }
                        }
                        if (((com.beizi.ad.v2.a.b) b.this).C) {
                            b.this.A();
                            b.this.B();
                        }
                        if (b.this.P != null) {
                            b.this.P.a();
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                b.this.b(8);
            }
        });
    }

    private void y() {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            b(10);
            return;
        }
        WebView webView = new WebView(viewGroup.getContext());
        this.O = webView;
        u.a(webView);
        if (this.B) {
            this.G.addView(this.O);
            if (!this.C) {
                A();
                B();
            }
        }
        this.O.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.v2.g.b.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                try {
                    if (b.this.G == null) {
                        b.this.b(10);
                        return;
                    }
                    if (b.this.O == null) {
                        b.this.b(9);
                        return;
                    }
                    if (!((com.beizi.ad.v2.a.b) b.this).B) {
                        b.this.G.addView(b.this.O);
                        b.this.A();
                        b.this.B();
                        b.this.C();
                        return;
                    }
                    if (((com.beizi.ad.v2.a.b) b.this).C) {
                        b.this.A();
                        b.this.B();
                    }
                    if (b.this.P != null) {
                        b.this.P.a();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    b.this.b(2);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                b.this.b(2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                b.this.b(2);
            }
        });
        this.O.loadDataWithBaseURL(null, this.K, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        View view = this.H;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.g.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.c();
            }
        });
    }

    public void b(View.OnTouchListener onTouchListener) {
        WebView webView = this.O;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void c() {
        try {
            com.beizi.ad.internal.d.a aVar = this.c;
            if (aVar != null) {
                aVar.d(false);
            }
            com.beizi.ad.a aVar2 = this.I;
            if (aVar2 != null) {
                aVar2.c();
            }
            CountDownTimer countDownTimer = this.J;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u() {
        CountDownTimer countDownTimer = this.J;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.n <= 0) {
            this.n = 5;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(this.n * 1000, 200L) { // from class: com.beizi.ad.v2.g.b.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (((com.beizi.ad.v2.a.b) b.this).c != null) {
                    ((com.beizi.ad.v2.a.b) b.this).c.d(false);
                }
                if (b.this.I != null) {
                    b.this.I.c();
                }
                if (b.this.J != null) {
                    b.this.J.cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.I != null) {
                    b.this.I.a(j);
                }
            }
        };
        this.J = countDownTimer2;
        countDownTimer2.start();
    }

    public void v() {
        try {
            this.c.a(true);
            this.c.b(f());
            this.c.a(this.G, "100", "200", "105", "206", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l);
            this.i = true;
            com.beizi.ad.a aVar = this.I;
            if (aVar == null) {
                return;
            }
            aVar.d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(com.beizi.ad.a aVar) {
        this.I = aVar;
    }

    public void a(int i, int i2) {
        this.M = i;
        this.N = i2;
    }

    public void a(View view) {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            b(11);
        } else {
            this.H = view;
            viewGroup.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.z();
                        b.this.u();
                        if (((com.beizi.ad.v2.a.b) b.this).c != null) {
                            ((com.beizi.ad.v2.a.b) b.this).c.a(b.this.G, ((com.beizi.ad.v2.a.b) b.this).l);
                        }
                        if (((com.beizi.ad.v2.a.b) b.this).t) {
                            ((com.beizi.ad.v2.a.b) b.this).u = true;
                            com.beizi.ad.internal.a.a.a().a(((com.beizi.ad.v2.a.b) b.this).r);
                        }
                        if (b.this.I != null) {
                            b.this.I.b();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        b.this.b(11);
                    }
                }
            });
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void b(final int i) {
        if (this.I == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.10
                @Override // java.lang.Runnable
                public void run() {
                    b.this.I.a(i);
                }
            });
        }
    }

    public void a(com.beizi.ad.v2.b.a aVar) {
        this.P = aVar;
        w();
    }

    public void a(View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            return;
        }
        WebView webView = this.O;
        if (webView != null) {
            webView.setOnTouchListener(onTouchListener);
            return;
        }
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(onTouchListener);
        }
    }

    public void a(d dVar, int i) {
        try {
            com.beizi.ad.internal.d.a aVar = this.c;
            if (aVar != null && this.G != null) {
                aVar.a(true);
                this.c.b(f());
                this.c.a(this.G, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l, i);
                this.i = true;
                com.beizi.ad.a aVar2 = this.I;
                if (aVar2 == null) {
                    return;
                }
                aVar2.d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.ad.v2.a.b
    public void a(com.beizi.ad.internal.d.a aVar) {
        this.n = aVar.h();
        this.K = aVar.D();
        this.L = aVar.E();
        b(aVar.b());
        c(aVar.c());
        a(aVar.A());
        if (this.B) {
            this.F.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.11
                @Override // java.lang.Runnable
                public void run() {
                    b.this.C();
                }
            });
            D();
        } else {
            Handler handler = this.F;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.beizi.ad.v2.g.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.w();
                    }
                });
            }
        }
    }
}
