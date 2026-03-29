package com.zenmen.palmchat.zx.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.zm.fda.Z200O.ZZ00Z;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/OS_TYPE;", "", ExifInterface.GPS_DIRECTION_TRUE, ActionUtils.PAYMENT_AMOUNT, "Lkotlin/Function0;", "not", "use", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "(Ljava/lang/String;I)V", "Companion", "c", GrsBaseInfo.CountryCodeSource.UNKNOWN, "MACOS", ZZ00Z.x, "WINDOWS", "LINUX", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public enum OS_TYPE {
    UNKNOWN,
    MACOS,
    ANDROID,
    WINDOWS,
    LINUX;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy CURRENT$delegate = LazyKt__LazyJVMKt.lazy(new Function0<OS_TYPE>() { // from class: com.zenmen.palmchat.zx.jvm.OS_TYPE.a
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final OS_TYPE invoke() {
            String strB = OS_TYPE.INSTANCE.b();
            if (strB == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strB.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "android", false, 2, (Object) null) ? OS_TYPE.ANDROID : StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "mac os", false, 2, (Object) null) ? OS_TYPE.MACOS : StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "windows", false, 2, (Object) null) ? OS_TYPE.WINDOWS : StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "linux", false, 2, (Object) null) ? OS_TYPE.LINUX : OS_TYPE.UNKNOWN;
        }
    });
    private static final Lazy NAME$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.zenmen.palmchat.zx.jvm.OS_TYPE.b
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return System.getProperty("os.name");
        }
    });

    /* JADX INFO: renamed from: com.zenmen.palmchat.zx.jvm.OS_TYPE$c, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/OS_TYPE$c;", "", "Lcom/zenmen/palmchat/zx/jvm/OS_TYPE;", "CURRENT$delegate", "Lkotlin/Lazy;", "a", "()Lcom/zenmen/palmchat/zx/jvm/OS_TYPE;", "CURRENT", "", "NAME$delegate", t.l, "()Ljava/lang/String;", "NAME", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f16076a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "CURRENT", "getCURRENT()Lcom/zenmen/palmchat/zx/jvm/OS_TYPE;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "NAME", "getNAME()Ljava/lang/String;"))};

        public Companion() {
        }

        public final OS_TYPE a() {
            Lazy lazy = OS_TYPE.CURRENT$delegate;
            KProperty kProperty = f16076a[0];
            return (OS_TYPE) lazy.getValue();
        }

        public final String b() {
            Lazy lazy = OS_TYPE.NAME$delegate;
            KProperty kProperty = f16076a[1];
            return (String) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final <T> T use(T value, Function0<? extends T> not) {
        return this == INSTANCE.a() ? value : not.invoke();
    }

    public final <T> T use(T value, T not) {
        return this == INSTANCE.a() ? value : not;
    }
}
