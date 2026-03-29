package com.zenmen.palmchat.zx.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'M' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/BYTES_UNIT;", "", "size", "", "unit", "", "(Ljava/lang/String;IJLjava/lang/String;)V", "getSize", "()J", "getUnit", "()Ljava/lang/String;", "format", ActionUtils.PAYMENT_AMOUNT, "fmt", "K", "M", WkAdxAdConfigMg.DSP_NAME_GDT, ExifInterface.GPS_DIRECTION_TRUE, "P", "zx-jvm"}, k = 1, mv = {1, 1, 16})
public final class BYTES_UNIT {
    private static final /* synthetic */ BYTES_UNIT[] $VALUES;
    public static final BYTES_UNIT G;
    public static final BYTES_UNIT K;
    public static final BYTES_UNIT M;
    public static final BYTES_UNIT P;
    public static final BYTES_UNIT T;
    private final long size;
    private final String unit;

    static {
        BYTES_UNIT bytes_unit = new BYTES_UNIT("K", 0, 1024L, t.f7496a);
        K = bytes_unit;
        long j = 1024;
        BYTES_UNIT bytes_unit2 = new BYTES_UNIT("M", 1, bytes_unit.size * j, "m");
        M = bytes_unit2;
        BYTES_UNIT bytes_unit3 = new BYTES_UNIT(WkAdxAdConfigMg.DSP_NAME_GDT, 2, bytes_unit2.size * j, "g");
        G = bytes_unit3;
        BYTES_UNIT bytes_unit4 = new BYTES_UNIT(ExifInterface.GPS_DIRECTION_TRUE, 3, bytes_unit3.size * j, "t");
        T = bytes_unit4;
        BYTES_UNIT bytes_unit5 = new BYTES_UNIT("P", 4, bytes_unit4.size * j, "p");
        P = bytes_unit5;
        $VALUES = new BYTES_UNIT[]{bytes_unit, bytes_unit2, bytes_unit3, bytes_unit4, bytes_unit5};
    }

    private BYTES_UNIT(String str, int i, long j, String str2) {
        this.size = j;
        this.unit = str2;
    }

    public static /* synthetic */ String format$default(BYTES_UNIT bytes_unit, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "%.1f";
        }
        return bytes_unit.format(j, str);
    }

    public static BYTES_UNIT valueOf(String str) {
        return (BYTES_UNIT) Enum.valueOf(BYTES_UNIT.class, str);
    }

    public static BYTES_UNIT[] values() {
        return (BYTES_UNIT[]) $VALUES.clone();
    }

    public final String format(long value, String fmt) {
        StringBuilder sb = new StringBuilder();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(fmt, Arrays.copyOf(new Object[]{Double.valueOf(value / this.size)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        sb.append(this.unit);
        return sb.toString();
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUnit() {
        return this.unit;
    }
}
