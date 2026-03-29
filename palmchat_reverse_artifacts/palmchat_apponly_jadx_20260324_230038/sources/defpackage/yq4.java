package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yq4 {
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, Bitmap bitmap, int i) throws Throwable {
        BaseObj baseObj;
        Allocation allocationCreateFromBitmap;
        Allocation allocationCreateTyped;
        RenderScript renderScriptCreate;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = null;
        try {
            renderScriptCreate = RenderScript.create(context);
            try {
                renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
                allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            } catch (Throwable th) {
                th = th;
                allocationCreateFromBitmap = null;
                allocationCreateTyped = null;
            }
        } catch (Throwable th2) {
            th = th2;
            baseObj = null;
            allocationCreateFromBitmap = null;
            allocationCreateTyped = null;
        }
        try {
            allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            try {
                scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.setRadius(i);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                allocationCreateTyped.copyTo(bitmap);
                if (Build.VERSION.SDK_INT >= 23) {
                    RenderScript.releaseAllContexts();
                } else {
                    renderScriptCreate.destroy();
                }
                allocationCreateFromBitmap.destroy();
                allocationCreateTyped.destroy();
                scriptIntrinsicBlurCreate.destroy();
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                BaseObj baseObj2 = scriptIntrinsicBlurCreate;
                renderScript = renderScriptCreate;
                baseObj = baseObj2;
                if (renderScript != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        RenderScript.releaseAllContexts();
                    } else {
                        renderScript.destroy();
                    }
                }
                if (allocationCreateFromBitmap != null) {
                    allocationCreateFromBitmap.destroy();
                }
                if (allocationCreateTyped != null) {
                    allocationCreateTyped.destroy();
                }
                if (baseObj != null) {
                    baseObj.destroy();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            allocationCreateTyped = null;
            renderScript = renderScriptCreate;
            baseObj = allocationCreateTyped;
            if (renderScript != null) {
            }
            if (allocationCreateFromBitmap != null) {
            }
            if (allocationCreateTyped != null) {
            }
            if (baseObj != null) {
            }
            throw th;
        }
    }
}
