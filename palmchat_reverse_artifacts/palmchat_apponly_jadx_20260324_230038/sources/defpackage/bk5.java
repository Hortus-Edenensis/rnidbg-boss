package defpackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1740a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public bk5(int i, int i2, int i3, int i4, int i5) {
        this.f1740a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static bk5 a(String str) {
        vh.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strE = th.e(strArrSplit[i5].trim());
            strE.hashCode();
            switch (strE) {
                case "end":
                    i2 = i5;
                    break;
                case "text":
                    i4 = i5;
                    break;
                case "start":
                    i = i5;
                    break;
                case "style":
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new bk5(i, i2, i3, i4, strArrSplit.length);
    }
}
