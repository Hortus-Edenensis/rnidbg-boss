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
import com.beizi.fusion.tool.am;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.w;
import com.beizi.fusion.widget.CustomRoundImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends a {
    private RelativeLayout V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private ImageView Z;
    private ImageView aa;
    private CustomRoundImageView ab;

    public b(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f, float f2) {
        super(context, str, j, j2, buyerBean, forwardBean, dVar, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(((a) this).n, ((a) this).t, "3");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.b.1
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            b bVar = b.this;
                            an.a(((a) bVar).n, bVar.O, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) b.this).b.setComplain(str);
                            b.this.ao();
                            b.this.H();
                            b.this.aF();
                            if (((com.beizi.fusion.work.a) b.this).d != null && ((com.beizi.fusion.work.a) b.this).d.r() != 2) {
                                ((com.beizi.fusion.work.a) b.this).d.b(b.this.f(), ((a) b.this).u);
                            }
                            b.this.F();
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
            linearLayout.setOrientation(0);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 0, 0, 0);
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
            ((a) this).t.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((((a) this).t.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            ((a) this).t.addView(viewA, layoutParams);
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
            h.a((Context) null).a(eVar.b(), new h.a() { // from class: com.beizi.fusion.work.b.b.2
                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((a) b.this).n == null) {
                                return;
                            }
                            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            float f = (float) ((((double) width) * 1.0d) / ((double) height));
                            b bVar = b.this;
                            int iA = (int) (((double) ap.a(((a) bVar).n, ((a) bVar).r)) * 0.285d);
                            b bVar2 = b.this;
                            float f2 = ((a) bVar2).s;
                            int iA2 = f2 > 0.0f ? ap.a(((a) bVar2).n, f2) - ap.a(((a) b.this).n, 20.0f) : (int) (iA / f);
                            b bVar3 = b.this;
                            bVar3.S = iA;
                            bVar3.T = iA2;
                            if (iA2 < 0) {
                                bVar3.T = height;
                            }
                            if (bVar3.ab != null && (layoutParams = b.this.ab.getLayoutParams()) != null) {
                                layoutParams.width = iA;
                                layoutParams.height = iA2;
                                b.this.ab.setLayoutParams(layoutParams);
                            }
                            if (b.this.ab != null) {
                                b.this.ab.setRectRadius(ap.a(((a) b.this).n, 8.0f));
                                b.this.ab.setBackground(new BitmapDrawable(w.a(((a) b.this).n, bitmap, 20.0f)));
                                b.this.ab.setImageBitmap(bitmap);
                            }
                            b bVar4 = b.this;
                            bVar4.a(bVar4.ab);
                            b.this.aE();
                            b.this.aG();
                            b.this.aI();
                            b.this.ay();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    b.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
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
            ((a) this).t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, 0, 15, 15);
            linearLayout.setLayoutParams(layoutParams2);
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
            View viewInflate = LayoutInflater.from(((a) this).n).inflate(R.layout.beizi_layout_native_left_text_right_picture_view, (ViewGroup) null);
            this.M = viewInflate;
            this.V = (RelativeLayout) viewInflate.findViewById(R.id.native_ad_ltrg_content_rl);
            LinearLayout linearLayout = (LinearLayout) this.M.findViewById(R.id.native_ad_ltrg_title_ll);
            this.W = (TextView) this.M.findViewById(R.id.native_ad_ltrg_title_tv);
            RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.native_ad_ltrg_subtitle_rl);
            this.X = (TextView) this.M.findViewById(R.id.native_ad_ltrg_subtitle_tv);
            this.Y = (TextView) this.M.findViewById(R.id.native_ad_ltrg_go_tv);
            this.Z = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_go_iv);
            this.ab = (CustomRoundImageView) this.M.findViewById(R.id.native_ad_ltrg_image_iv);
            this.aa = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_ad_text_iv);
            RelativeLayout relativeLayout2 = this.V;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(0, ap.a(((a) this).n, 10.0f), ap.a(((a) this).n, 10.0f), 0);
            }
            if (linearLayout != null) {
                linearLayout.setPadding(ap.a(((a) this).n, 20.0f), ap.a(((a) this).n, 8.0f), ap.a(((a) this).n, 11.0f), 0);
            }
            String strA = this.K.a();
            if (this.W != null && !TextUtils.isEmpty(strA)) {
                this.W.setText(strA);
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, ap.a(((a) this).n, 5.0f), 0, 0);
            }
            String strC = this.K.c();
            if (this.X != null && !TextUtils.isEmpty(strC)) {
                this.X.setText(strC);
            }
            ImageView imageView = this.aa;
            if (imageView != null) {
                imageView.setPadding(0, ap.a(((a) this).n, 10.0f), 0, 0);
            }
            TextView textView = this.Y;
            if (textView != null) {
                am.a(textView, "#71A0FF", 0, null, ap.a(((a) this).n, 10.0f));
            }
            a(this.Y, this.Z);
            aH();
            az();
            aA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.b.a
    public void a(e eVar) {
        try {
            ImageView imageView = new ImageView(((a) this).n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(65, 65);
            imageView.setPadding(15, 8, 8, 15);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(65, 65);
            layoutParams2.gravity = 5;
            ((a) this).t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    ((a) b.this).F = motionEvent.getX();
                    ((a) b.this).G = motionEvent.getY();
                    ((a) b.this).H = motionEvent.getRawX();
                    b.this.I = motionEvent.getRawY();
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (b.this.aC()) {
                            b bVar = b.this;
                            bVar.U = false;
                            b.this.a(new String[]{String.valueOf(((a) bVar).F), String.valueOf(((a) b.this).G), String.valueOf(((a) b.this).H), String.valueOf(b.this.I)}, 0);
                        } else {
                            b.this.aD();
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
}
