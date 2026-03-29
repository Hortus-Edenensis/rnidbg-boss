package com.heytap.msp.ipc.a;

import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.msp.ipc.annotation.IPCType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: com.heytap.msp.ipc.a.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6371a;

        static {
            int[] iArr = new int[IPCType.values().length];
            f6371a = iArr;
            try {
                iArr[IPCType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6371a[IPCType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6371a[IPCType.PROVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static List<l> a(IPCModule iPCModule) {
        ArrayList arrayList = new ArrayList();
        if (iPCModule != null) {
            int i = AnonymousClass1.f6371a[iPCModule.ipcType().ordinal()];
            int i2 = 0;
            if (i == 1 || i == 2) {
                String[] strArrAuthsOrActions = iPCModule.authsOrActions();
                int length = strArrAuthsOrActions.length;
                while (i2 < length) {
                    l lVarB = l.b(iPCModule.targetPackage(), null, strArrAuthsOrActions[i2], iPCModule.targetComponentClass());
                    if (lVarB != null) {
                        arrayList.add(lVarB);
                    }
                    i2++;
                }
            } else if (i == 3) {
                String[] strArrAuthsOrActions2 = iPCModule.authsOrActions();
                int length2 = strArrAuthsOrActions2.length;
                while (i2 < length2) {
                    l lVarA = l.a(iPCModule.targetPackage(), null, strArrAuthsOrActions2[i2], iPCModule.targetComponentClass());
                    if (lVarA != null) {
                        arrayList.add(lVarA);
                    }
                    i2++;
                }
            }
        }
        return arrayList;
    }
}
