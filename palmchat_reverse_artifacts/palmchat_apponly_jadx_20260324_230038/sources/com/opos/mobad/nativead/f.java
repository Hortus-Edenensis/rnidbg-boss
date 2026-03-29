package com.opos.mobad.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: com.opos.mobad.nativead.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9155a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.func.b.a.values().length];
            f9155a = iArr;
            try {
                iArr[com.opos.mobad.cmn.func.b.a.NON_CLICK_BT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9155a[com.opos.mobad.cmn.func.b.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9155a[com.opos.mobad.cmn.func.b.a.CLICK_BT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9155a[com.opos.mobad.cmn.func.b.a.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9155a[com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9155a[com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static boolean a(View view, View view2) {
        if (view != null && view2 != null) {
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                if (viewGroup.indexOfChild(view2) >= 0) {
                    return true;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i) != null && (viewGroup.getChildAt(i) instanceof ViewGroup) && a(viewGroup.getChildAt(i), view2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(AdItemData adItemData, com.opos.mobad.cmn.func.b.a aVar) {
        MaterialData materialData;
        boolean z = false;
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null) {
            switch (AnonymousClass1.f9155a[aVar.ordinal()]) {
                case 1:
                    if (materialData.G() != 0) {
                        z = true;
                    }
                    break;
                case 2:
                case 3:
                    if (materialData.d() != 0) {
                    }
                    break;
                case 4:
                    if (materialData.H() != 0) {
                    }
                    break;
                case 5:
                    if (materialData.S() != 0) {
                    }
                    break;
                case 6:
                    if (materialData.T() != 0) {
                    }
                    break;
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "isValidClickWithInteraction result =" + z);
        return z;
    }
}
