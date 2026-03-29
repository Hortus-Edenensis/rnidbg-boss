package defpackage;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class z31 implements oy3 {
    @Override // defpackage.oy3
    public ky3 a(CharSequence charSequence, Object obj, List<ky3> list, boolean z) {
        if (charSequence == null) {
            throw new IllegalStateException("The edgeCharacters argument was null");
        }
        if (z || charSequence.length() != 0) {
            if (list == null) {
                throw new IllegalStateException("The childNodes argument was null");
            }
            ry3.b(list);
            return list.isEmpty() ? obj instanceof ph6 ? new v00(charSequence) : obj != null ? new w00(charSequence, obj) : new u00(charSequence) : obj instanceof ph6 ? new y00(charSequence, list) : obj == null ? new x00(charSequence, list) : new t00(charSequence, obj, list);
        }
        throw new IllegalStateException("Invalid edge characters for non-root node: " + a10.h(charSequence));
    }
}
