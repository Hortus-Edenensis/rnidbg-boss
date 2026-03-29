package com.beizi.ad.internal.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static void a(final com.beizi.ad.e eVar, final View view, final b bVar) {
        if (!a(eVar) || view == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (eVar.a(view, bVar)) {
                    view.setTag(R.string.beizi_native_tag, new WeakReference(eVar));
                }
            }
        });
    }

    @Deprecated
    public static void a(final com.beizi.ad.e eVar, final View view, final List<View> list, final b bVar) {
        if (!a(eVar) || view == null || list == null || list.isEmpty()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.beizi.ad.internal.c.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (eVar.a(view, list, bVar)) {
                    view.setTag(R.string.beizi_native_tag, new WeakReference(eVar));
                }
            }
        });
    }

    public static void a(com.beizi.ad.e eVar, View view, String str, String str2, String str3, String str4, int i) {
        try {
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            eVar.a(context, view, str, str2, str3, str4, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(com.beizi.ad.e eVar) {
        return (eVar == null || eVar.f()) ? false : true;
    }

    public static FrameLayout a(View view, com.beizi.ad.e eVar) {
        try {
            int i = R.drawable.beizi_button_close_background;
            if (view.getTag(i) != null && (view.getTag(i) instanceof FrameLayout)) {
                t.a((FrameLayout) view.getTag(i));
                return (FrameLayout) view.getTag(i);
            }
            view.getContext();
            t.a(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(view.getContext(), eVar.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new FrameLayout.LayoutParams(-2, -2, 17));
            View viewB = t.b(view.getContext(), eVar.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new FrameLayout.LayoutParams(-2, -2, 17));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = t.a(view.getContext(), 20.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
            view.setTag(i, frameLayout);
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static FrameLayout a(Context context, Bitmap bitmap, com.beizi.ad.e eVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        return a(imageView, eVar);
    }

    public static View a(final Context context, com.beizi.ad.e eVar) {
        if (context != null && eVar != null) {
            try {
                ApkBean apkBeanM = eVar.m();
                if (apkBeanM == null) {
                    return null;
                }
                final String apkName = apkBeanM.getApkName();
                String appDeveloper = apkBeanM.getAppDeveloper();
                String appVersion = apkBeanM.getAppVersion();
                String appPermissionsUrl = apkBeanM.getAppPermissionsUrl();
                final String appPermissionsDesc = apkBeanM.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsUrl)) {
                    appPermissionsDesc = appPermissionsUrl;
                }
                final String appPrivacyUrl = apkBeanM.getAppPrivacyUrl();
                final String appintro = apkBeanM.getAppintro();
                TextView textView = new TextView(context);
                textView.setText(Html.fromHtml("应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                textView.setTextSize(2, 6.0f);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                textView.setPadding(10, 10, 10, 10);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.c.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(context, (Class<?>) DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", apkName);
                            intent.putExtra("privacy_content_key", appPrivacyUrl);
                            intent.putExtra("permission_content_key", appPermissionsDesc);
                            intent.putExtra("intro_content_key", appintro);
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return textView;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
