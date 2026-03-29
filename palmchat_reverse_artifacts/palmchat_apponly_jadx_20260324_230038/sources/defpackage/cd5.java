package defpackage;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class cd5 extends nw {
    public static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public cd5(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    @Nullable
    public static cd5 e(File file, long j, long j2, qw qwVar) {
        File file2;
        String strK;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File fileJ = j(file, qwVar);
            if (fileJ == null) {
                return null;
            }
            file2 = fileJ;
            name = fileJ.getName();
        }
        Matcher matcher = i.matcher(name);
        if (!matcher.matches() || (strK = qwVar.k(Integer.parseInt((String) vh.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j == -1 ? file2.length() : j;
        if (length == 0) {
            return null;
        }
        return new cd5(strK, Long.parseLong((String) vh.e(matcher.group(2))), length, j2 == -9223372036854775807L ? Long.parseLong((String) vh.e(matcher.group(3))) : j2, file2);
    }

    @Nullable
    public static cd5 f(File file, long j, qw qwVar) {
        return e(file, j, -9223372036854775807L, qwVar);
    }

    public static cd5 g(String str, long j, long j2) {
        return new cd5(str, j, j2, -9223372036854775807L, null);
    }

    public static cd5 h(String str, long j) {
        return new cd5(str, j, -1L, -9223372036854775807L, null);
    }

    public static File i(File file, int i2, long j, long j2) {
        return new File(file, i2 + "." + j + "." + j2 + ".v3.exo");
    }

    @Nullable
    public static File j(File file, qw qwVar) {
        String strL1;
        String name = file.getName();
        Matcher matcher = h.matcher(name);
        if (matcher.matches()) {
            strL1 = g86.l1((String) vh.e(matcher.group(1)));
        } else {
            matcher = g.matcher(name);
            strL1 = matcher.matches() ? (String) vh.e(matcher.group(1)) : null;
        }
        if (strL1 == null) {
            return null;
        }
        File fileI = i((File) vh.i(file.getParentFile()), qwVar.f(strL1), Long.parseLong((String) vh.e(matcher.group(2))), Long.parseLong((String) vh.e(matcher.group(3))));
        if (file.renameTo(fileI)) {
            return fileI;
        }
        return null;
    }

    public cd5 d(File file, long j) {
        vh.g(this.d);
        return new cd5(this.f19628a, this.b, this.c, j, file);
    }
}
