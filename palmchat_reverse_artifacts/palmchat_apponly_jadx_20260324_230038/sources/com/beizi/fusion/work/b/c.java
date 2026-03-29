package com.beizi.fusion.work.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.ad.e;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.t;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.w;
import com.beizi.fusion.widget.CustomRoundImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends a {
    private LinearLayout V;
    private LinearLayout W;
    private FrameLayout X;
    private CustomRoundImageView Y;
    private TextView Z;
    private TextView aa;
    private TextView ab;
    private ImageView ac;

    public c(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f, float f2) {
        super(context, str, j, j2, buyerBean, forwardBean, dVar, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(((a) this).n, ((a) this).t, "2");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.c.1
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            c cVar = c.this;
                            an.a(((a) cVar).n, cVar.O, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) c.this).b.setComplain(str);
                            c.this.ao();
                            c.this.H();
                            c.this.aF();
                            if (((com.beizi.fusion.work.a) c.this).d != null && ((com.beizi.fusion.work.a) c.this).d.r() != 2) {
                                ((com.beizi.fusion.work.a) c.this).d.b(c.this.f(), ((a) c.this).u);
                            }
                            c.this.F();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        try {
            LinearLayout linearLayout = new LinearLayout(((a) this).n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(((a) this).n);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(((a) this).n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            ((a) this).u.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(((a) this).u.getMeasuredWidth(), ((a) this).u.getMeasuredHeight());
            layoutParams2.gravity = 17;
            ((a) this).t.addView(linearLayout, layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        View viewA;
        try {
            e eVar = this.K;
            if (eVar == null || eVar.m() == null || (viewA = com.beizi.ad.internal.c.d.a(((a) this).n, this.K)) == null) {
                return;
            }
            this.X.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.X.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.X.addView(viewA, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aH() {
        try {
            e eVar = this.K;
            if (eVar == null) {
                return;
            }
            h.a((Context) null).a(eVar.b(), new h.a() { // from class: com.beizi.fusion.work.b.c.2
                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((a) c.this).n == null) {
                                return;
                            }
                            Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            c cVar = c.this;
                            int iA = ap.a(((a) cVar).n, ((a) cVar).r - 16.0f);
                            int i = (int) (((float) iA) / ((float) ((((double) width) * 1.0d) / ((double) height))));
                            c cVar2 = c.this;
                            if (((a) cVar2).s > 0.0f) {
                                int measuredHeight = 0;
                                if (cVar2.W != null) {
                                    c.this.W.measure(0, 0);
                                    measuredHeight = c.this.W.getMeasuredHeight();
                                }
                                c cVar3 = c.this;
                                int iA2 = ap.a(((a) cVar3).n, ((a) cVar3).s - 16.0f);
                                if (iA2 > measuredHeight) {
                                    i = iA2 - measuredHeight;
                                }
                            }
                            c cVar4 = c.this;
                            cVar4.S = iA;
                            cVar4.T = i;
                            if (i < 0) {
                                cVar4.T = height;
                            }
                            if (cVar4.Y != null && (layoutParams = c.this.Y.getLayoutParams()) != null) {
                                layoutParams.width = iA;
                                layoutParams.height = i;
                                c.this.Y.setLayoutParams(layoutParams);
                            }
                            if (c.this.Y != null) {
                                c.this.Y.setRectRadius(ap.a(((a) c.this).n, 4.0f));
                                c.this.Y.setBackground(new BitmapDrawable(w.a(((a) c.this).n, bitmap, 20.0f)));
                                c.this.Y.setImageBitmap(bitmap);
                            }
                            c cVar5 = c.this;
                            cVar5.a(cVar5.Y);
                            c.this.aE();
                            c.this.aG();
                            c.this.aI();
                            c.this.ay();
                        } catch (Exception e) {
                            e.printStackTrace();
                            c.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                        }
                    }
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
                    c.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        try {
            if (this.K == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((a) this).n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(((a) this).n, this.K.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewB = t.b(((a) this).n, this.K.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            ((a) this).t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 53));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            if (aB()) {
                layoutParams2.setMargins(0, ap.a(((a) this).n, 16.0f), ap.a(((a) this).n, 40.0f), 0);
            } else {
                layoutParams2.setMargins(0, ap.a(((a) this).n, 16.0f), ap.a(((a) this).n, 16.0f), 0);
            }
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.b.a
    public void a(e eVar) {
        try {
            ImageView imageView = new ImageView(((a) this).n);
            int iA = ap.a(((a) this).n, 24.0f) + 42;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            int iA2 = ap.a(((a) this).n, 16.0f);
            int iA3 = ap.a(((a) this).n, 8.0f);
            imageView.setPadding(iA3, iA2, iA2, iA3);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close_two);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
            layoutParams2.gravity = 5;
            ((a) this).t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    ((a) c.this).F = motionEvent.getX();
                    ((a) c.this).G = motionEvent.getY();
                    ((a) c.this).H = motionEvent.getRawX();
                    c.this.I = motionEvent.getRawY();
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (c.this.aC()) {
                            c cVar = c.this;
                            cVar.U = false;
                            c.this.a(new String[]{String.valueOf(((a) cVar).F), String.valueOf(((a) c.this).G), String.valueOf(((a) c.this).H), String.valueOf(c.this.I)}, 0);
                        } else {
                            c.this.aD();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.b.a
    public void b() {
        try {
            if (this.K == null) {
                c(-991);
                return;
            }
            View viewInflate = LayoutInflater.from(((a) this).n).inflate(R.layout.beizi_layout_native_top_picture_bottom_text_view, (ViewGroup) null);
            this.M = viewInflate;
            this.V = (LinearLayout) viewInflate.findViewById(R.id.native_ad_tpbt_container_ll);
            this.X = (FrameLayout) this.M.findViewById(R.id.native_ad_tpbt_img_container_fl);
            this.Y = (CustomRoundImageView) this.M.findViewById(R.id.native_ad_tpbt_image_iv);
            this.W = (LinearLayout) this.M.findViewById(R.id.native_ad_tpbt_content_ll);
            this.Z = (TextView) this.M.findViewById(R.id.native_ad_tpbt_title_tv);
            this.aa = (TextView) this.M.findViewById(R.id.native_ad_tpbt_subtitle_tv);
            this.ab = (TextView) this.M.findViewById(R.id.native_ad_tpbt_go_tv);
            this.ac = (ImageView) this.M.findViewById(R.id.native_ad_tpbt_go_iv);
            int iA = ap.a(((a) this).n, ((a) this).r);
            float f = ((a) this).s;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, f > 0.0f ? ap.a(((a) this).n, f) : -2);
            int iA2 = ap.a(((a) this).n, 8.0f);
            LinearLayout linearLayout = this.V;
            if (linearLayout != null) {
                linearLayout.setPadding(iA2, iA2, iA2, iA2);
                this.V.setLayoutParams(layoutParams);
            }
            LinearLayout linearLayout2 = this.W;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, ap.a(((a) this).n, 8.0f), 0, ap.a(((a) this).n, 8.0f));
            }
            String strA = this.K.a();
            if (this.Z != null && !TextUtils.isEmpty(strA)) {
                this.Z.setText(strA);
            }
            String strC = this.K.c();
            if (this.aa != null && !TextUtils.isEmpty(strC)) {
                this.aa.setText(strC);
            }
            TextView textView = this.ab;
            if (textView != null) {
                textView.setBackground(((a) this).n.getDrawable(R.drawable.beizi_bg_operate_button));
            }
            if (this.ac != null) {
                this.ac.setLayoutParams(new RelativeLayout.LayoutParams(ap.a(((a) this).n, 63.0f), ap.a(((a) this).n, 24.0f)));
                this.ac.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            a(this.ab, this.ac);
            aH();
            az();
            aA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
