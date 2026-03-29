package defpackage;

import android.content.ClipData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¨\u0006\u0004"}, d2 = {"Landroid/content/ClipData;", "", "Landroid/content/ClipData$Item;", "a", "zx-core_release"}, k = 2, mv = {1, 4, 0})
public final class dd0 {
    public static final List<ClipData.Item> a(ClipData clipData) {
        ArrayList arrayList = new ArrayList();
        int itemCount = clipData.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            Intrinsics.checkExpressionValueIsNotNull(itemAt, "getItemAt(i)");
            arrayList.add(itemAt);
        }
        return arrayList;
    }
}
