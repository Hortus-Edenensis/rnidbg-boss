package com.bytedance.sdk.openadsdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wq {
    private static int b(View view, int i) {
        if (i == 3) {
            return y.pn(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static boolean fx(View view) {
        return view != null && view.isShown();
    }

    private static boolean nr(View view, int i) {
        return view.getWidth() >= fx(view, i) && view.getHeight() >= b(view, i);
    }

    public static String u(int i) {
        switch (i) {
            case 1:
                return "view不可见";
            case 2:
            case 5:
            default:
                return "";
            case 3:
                return "view可见区域比例不够";
            case 4:
                return "屏幕关闭";
            case 6:
                return "view可见宽高不够";
            case 7:
                return "show检测发生崩溃";
            case 8:
                return "设置为了不需要检测";
            case 9:
                return "没有在检测";
            case 10:
                return "没有在检测，已show";
        }
    }

    private static int fx(View view, int i) {
        if (i == 3) {
            return (int) (((double) y.b(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static boolean u(View view, int i) {
        float fNr = nr(view);
        return fNr > 0.0f && fNr >= ((float) i) / 100.0f;
    }

    public static boolean u(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    public static boolean nr(View view, int i, int i2) {
        return u(view, i, i2) == 0;
    }

    public static float nr(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect) && (!dw.nr().w() || !u(view, new Rect(), (Point) null))) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    public static int u(View view, int i, int i2) throws Throwable {
        if (!com.bytedance.sdk.openadsdk.core.y.t.u()) {
            return 4;
        }
        if (!fx(view)) {
            return 1;
        }
        if (nr(view, i2)) {
            return !u(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean u(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return u(view, 20);
        }
        return false;
    }
}
