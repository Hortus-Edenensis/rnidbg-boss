package com.amap.api.maps2d.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0002sl.ar;
import com.amap.api.col.p0002sl.ba;
import com.amap.api.col.p0002sl.ct;
import java.io.FileInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    private static Bitmap a(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            return view.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "getViewBitmap");
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(ar.a.marker_default2d.name() + ".png");
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "defaultMarker");
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            return fromBitmap(ct.a(str));
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "fromAsset");
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = ba.f2628a;
            if (context == null) {
                return null;
            }
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
            fileInputStreamOpenFileInput.close();
            return fromBitmap(bitmapDecodeStream);
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "fromFile");
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "fromPath");
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            Context context = ba.f2628a;
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i)));
            }
            return null;
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "fromResource");
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = ba.f2628a;
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.destroyDrawingCache();
            return fromBitmap(a(frameLayout));
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "fromView");
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            float f2 = (((int) (f + 15.0f)) / 30) * 30;
            if (f2 > 330.0f) {
                f2 = 330.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            String str = "";
            if (f2 == 0.0f) {
                str = "RED";
            } else if (f2 == 30.0f) {
                str = "ORANGE";
            } else if (f2 == 60.0f) {
                str = "YELLOW";
            } else if (f2 == 120.0f) {
                str = "GREEN";
            } else if (f2 == 180.0f) {
                str = "CYAN";
            } else if (f2 == 210.0f) {
                str = "AZURE";
            } else if (f2 == 240.0f) {
                str = "BLUE";
            } else if (f2 == 270.0f) {
                str = "VIOLET";
            } else if (f2 == 300.0f) {
                str = "MAGENTAV";
            } else if (f2 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + "2d.png");
        } catch (Throwable th) {
            ct.a(th, "BitmapDescriptorFactory", "defaultMarker");
            return null;
        }
    }
}
