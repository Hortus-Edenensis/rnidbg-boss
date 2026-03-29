package defpackage;

import com.kuaishou.weapon.p0.t;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0004\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Ld00;", "", "", "toString", "a", "Ljava/lang/String;", "getEntryToken", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "entryToken", "", t.l, "[Ljava/lang/String;", "getEntryDataTypes", "()[Ljava/lang/String;", "([Ljava/lang/String;)V", "entryDataTypes", "", "Ljava/lang/Integer;", "getEntryCategory", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "entryCategory", "Lux5;", "d", "Lux5;", "getTimeAnchor", "()Lux5;", "setTimeAnchor", "(Lux5;)V", "timeAnchor", "", "e", "Ljava/util/Map;", "entryExtraInfo", "<init>", "()V", "basics_release"}, k = 1, mv = {1, 4, 0})
public final class d00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String entryToken;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String[] entryDataTypes;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Integer entryCategory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public TimeAnchor timeAnchor = new TimeAnchor();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Map<String, Object> entryExtraInfo = new LinkedHashMap();

    public final void a(Integer num) {
        this.entryCategory = num;
    }

    public final void b(String[] strArr) {
        this.entryDataTypes = strArr;
    }

    public final void c(String str) {
        this.entryToken = str;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("[entryToken:");
        sb.append(this.entryToken);
        sb.append(";entryDataTypes:");
        String[] strArr = this.entryDataTypes;
        if (strArr != null) {
            string = Arrays.toString(strArr);
            Intrinsics.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        } else {
            string = null;
        }
        sb.append(string);
        sb.append(";entryCategory:");
        sb.append(this.entryCategory);
        sb.append(";entryExtraInfo:");
        sb.append(this.entryExtraInfo);
        sb.append(']');
        return sb.toString();
    }
}
