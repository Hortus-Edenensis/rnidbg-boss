package defpackage;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Parcelable;
import android.telephony.CellInfo;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\b\b\u0000\u0010\n*\u00020\u00032\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007R(\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR0\u0010\u0011\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcc4;", "", "Landroid/os/Parcelable$Creator;", "Landroid/os/Parcelable;", "Lcom/zenmen/palmchat/zx/core/ParcelCreatorObject;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "Lcom/zenmen/palmchat/zx/core/ParcelCreatorId;", t.l, "(Landroid/os/Parcelable$Creator;)Ljava/lang/Integer;", "R", "id", "a", "Lss;", "Lkotlin/reflect/KClass;", "Lss;", OapsKey.KEY_IDS, "creators", "<init>", "()V", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public final class cc4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final ss<Integer, KClass<?>> ids;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final ss<Integer, Parcelable.Creator<? extends Parcelable>> creators;
    public static final cc4 c = new cc4();

    static {
        ss<Integer, KClass<?>> ssVar = new ss<>();
        ssVar.b(16, Reflection.getOrCreateKotlinClass(ActivityManager.RunningTaskInfo.class));
        ssVar.b(17, Reflection.getOrCreateKotlinClass(ActivityManager.RunningAppProcessInfo.class));
        ssVar.b(18, Reflection.getOrCreateKotlinClass(ActivityManager.RecentTaskInfo.class));
        ssVar.b(32, Reflection.getOrCreateKotlinClass(Location.class));
        ssVar.b(48, Reflection.getOrCreateKotlinClass(ApplicationInfo.class));
        ssVar.b(49, Reflection.getOrCreateKotlinClass(PackageInfo.class));
        ssVar.b(80, Reflection.getOrCreateKotlinClass(ClipData.class));
        ssVar.b(81, Reflection.getOrCreateKotlinClass(ClipDescription.class));
        ids = ssVar;
        ss<Integer, Parcelable.Creator<? extends Parcelable>> ssVar2 = new ss<>();
        Parcelable.Creator<? extends Parcelable> creator = ActivityManager.RunningTaskInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator, "ActivityManager.RunningTaskInfo.CREATOR");
        ssVar2.b(16, creator);
        Parcelable.Creator<? extends Parcelable> creator2 = ActivityManager.RunningAppProcessInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator2, "ActivityManager.RunningAppProcessInfo.CREATOR");
        ssVar2.b(17, creator2);
        Parcelable.Creator<? extends Parcelable> creator3 = ActivityManager.RecentTaskInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator3, "ActivityManager.RecentTaskInfo.CREATOR");
        ssVar2.b(18, creator3);
        Parcelable.Creator<? extends Parcelable> creator4 = Location.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator4, "Location.CREATOR");
        ssVar2.b(32, creator4);
        Parcelable.Creator<? extends Parcelable> creator5 = ApplicationInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator5, "ApplicationInfo.CREATOR");
        ssVar2.b(48, creator5);
        Parcelable.Creator<? extends Parcelable> creator6 = PackageInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator6, "PackageInfo.CREATOR");
        ssVar2.b(49, creator6);
        Parcelable.Creator<? extends Parcelable> creator7 = ClipData.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator7, "ClipData.CREATOR");
        ssVar2.b(80, creator7);
        Parcelable.Creator<? extends Parcelable> creator8 = ClipDescription.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator8, "ClipDescription.CREATOR");
        ssVar2.b(81, creator8);
        creators = ssVar2;
        ssVar.b(64, Reflection.getOrCreateKotlinClass(CellInfo.class));
        Parcelable.Creator<? extends Parcelable> creator9 = CellInfo.CREATOR;
        Intrinsics.checkExpressionValueIsNotNull(creator9, "CellInfo.CREATOR");
        ssVar2.b(64, creator9);
    }

    public final <R extends Parcelable> Parcelable.Creator<R> a(int id) {
        return (Parcelable.Creator) creators.a(Integer.valueOf(id));
    }

    public final Integer b(Parcelable.Creator<? extends Parcelable> obj) {
        return creators.c(obj);
    }
}
