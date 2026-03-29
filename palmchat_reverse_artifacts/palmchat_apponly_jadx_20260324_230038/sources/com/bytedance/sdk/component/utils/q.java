package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    private static String b = null;
    private static Resources fx = null;
    private static boolean iz = false;
    private static String nr = null;
    private static boolean pn = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context u;

    public static int a(Context context, String str) {
        return u(context).getColor(jk(context, str));
    }

    public static Bitmap b(Context context, String str) {
        return BitmapFactory.decodeResource(u(context), pn(context, str));
    }

    private static String fx(Context context) {
        if (b == null) {
            b = context.getPackageName();
        }
        return b;
    }

    public static int iz(Context context, String str) {
        return u(context, str, "id");
    }

    public static int jk(Context context, String str) {
        return u(context, str, "color");
    }

    public static int n(Context context, String str) {
        return u(context, str, "dimen");
    }

    public static int nr(Context context, String str) {
        return u(context, str, "string");
    }

    public static int pn(Context context, String str) {
        try {
            return u(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int t(Context context, String str) {
        return u(context, str, "anim");
    }

    private static int u(Context context, String str, String str2) {
        int identifier = u(context).getIdentifier(str, str2, fx(context));
        if (identifier != 0) {
            return identifier;
        }
        if (pn) {
            return context.getResources().getIdentifier(str, str2, fx(context));
        }
        nr(context);
        return u(context).getIdentifier(str, str2, fx(context));
    }

    public static int x(Context context, String str) {
        return u(context, str, "style");
    }

    public static synchronized void nr(Context context) {
        try {
            if (TextUtils.isEmpty(nr)) {
                return;
            }
            Resources resources = context.getResources();
            fx = new Resources(nr(resources.getAssets(), nr + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            b = context.getPackageName();
            pn = true;
        } catch (Throwable th) {
            k.u("ResourceHelp", "makePluginResources failed", th);
        }
    }

    public static Drawable fx(Context context, String str) {
        try {
            return u(context).getDrawable(pn(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String u(Context context, String str) {
        return u(context).getString(nr(context, str));
    }

    public static void u(Context context, String str, ImageView imageView) {
        Drawable drawable = u(context).getDrawable(pn(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void u(Context context, String str, View view) {
        Drawable drawable = u(context).getDrawable(pn(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    private static AssetManager nr(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            u(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            u(assetManager, str);
        }
        try {
            ja.u(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static Resources u(Context context) {
        Resources resources = fx;
        if (resources == null) {
            resources = null;
        }
        Context context2 = u;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static boolean u(AssetManager assetManager, String str) {
        Method methodU = ja.u((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodU == null) {
            methodU = ja.u((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodU != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                if (((Integer) methodU.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }
}
