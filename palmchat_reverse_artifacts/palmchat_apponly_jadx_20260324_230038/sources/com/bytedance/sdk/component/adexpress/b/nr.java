package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bytedance.component.sdk.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    @RequiresApi(api = 17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap u(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        Allocation allocation;
        BaseObj baseObj;
        try {
            if ((!com.bytedance.sdk.component.adexpress.b.u() || Build.VERSION.SDK_INT >= 26) && bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                renderScriptCreate = RenderScript.create(context);
                if (renderScriptCreate == null) {
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
                try {
                    ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                            try {
                                scriptIntrinsicBlurCreate.setRadius(i);
                                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                allocationCreateFromBitmap2.destroy();
                                scriptIntrinsicBlurCreate.destroy();
                                renderScriptCreate.destroy();
                                return bitmapCreateBitmap;
                            } catch (Throwable unused) {
                                baseObj = scriptIntrinsicBlurCreate;
                                allocation = allocationCreateFromBitmap2;
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocation != null) {
                                    allocation.destroy();
                                }
                                if (baseObj != null) {
                                    baseObj.destroy();
                                }
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                return null;
                            }
                        } catch (Throwable unused2) {
                            allocation = null;
                            baseObj = scriptIntrinsicBlurCreate;
                        }
                    } catch (Throwable unused3) {
                        allocationCreateFromBitmap = null;
                        allocation = null;
                        baseObj = scriptIntrinsicBlurCreate;
                    }
                } catch (Throwable unused4) {
                    allocationCreateFromBitmap = null;
                    Allocation allocation2 = allocationCreateFromBitmap;
                    allocation = allocation2;
                    baseObj = allocation2;
                    if (allocationCreateFromBitmap != null) {
                    }
                    if (allocation != null) {
                    }
                    if (baseObj != null) {
                    }
                    if (renderScriptCreate != null) {
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused5) {
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }
}
