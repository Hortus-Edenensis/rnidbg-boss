package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hr6 extends ih5 {
    public int f;

    public hr6(File file, boolean z, int i) throws FileNotFoundException {
        super(file, z, i);
        this.f = i;
    }

    @Override // defpackage.ih5
    public File b(int i) throws IOException {
        if (i == this.f) {
            return this.b;
        }
        String canonicalPath = this.b.getCanonicalPath();
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + (i >= 9 ? ".z" : ".z0") + (i + 1));
    }
}
