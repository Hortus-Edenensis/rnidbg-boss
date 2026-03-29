package org.jsoup.nodes;

import defpackage.jl5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class Entities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pattern f19827a = Pattern.compile("^(\\w+)=(\\w+)(?:,(\\w+))?;(\\w+)$");
    public static final HashMap<String, String> b = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public enum EscapeMode {
        xhtml("entities-xhtml.properties", 4),
        base("entities-base.properties", 106),
        extended("entities-full.properties", 2125);

        private int[] codeKeys;
        private int[] codeVals;
        private String[] nameKeys;
        private String[] nameVals;

        EscapeMode(String str, int i) {
            Entities.h(this, str, i);
        }

        private int size() {
            return this.nameKeys.length;
        }

        public int codepointForName(String str) {
            int iBinarySearch = Arrays.binarySearch(this.nameKeys, str);
            if (iBinarySearch >= 0) {
                return this.codeVals[iBinarySearch];
            }
            return -1;
        }

        public String nameForCodepoint(int i) {
            int iBinarySearch = Arrays.binarySearch(this.codeKeys, i);
            if (iBinarySearch < 0) {
                return "";
            }
            String[] strArr = this.nameVals;
            if (iBinarySearch < strArr.length - 1) {
                int i2 = iBinarySearch + 1;
                if (this.codeKeys[i2] == i) {
                    return strArr[i2];
                }
            }
            return strArr[iBinarySearch];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19828a;

        static {
            int[] iArr = new int[b.values().length];
            f19828a = iArr;
            try {
                iArr[b.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19828a[b.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        ascii,
        utf,
        fallback;

        /* JADX INFO: Access modifiers changed from: private */
        public static b byName(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public static void b(Appendable appendable, EscapeMode escapeMode, int i) throws IOException {
        String strNameForCodepoint = escapeMode.nameForCodepoint(i);
        if (strNameForCodepoint != "") {
            appendable.append(Typography.amp).append(strNameForCodepoint).append(';');
        } else {
            appendable.append("&#x").append(Integer.toHexString(i)).append(';');
        }
    }

    public static boolean c(b bVar, char c, CharsetEncoder charsetEncoder) {
        int i = a.f19828a[bVar.ordinal()];
        if (i == 1) {
            return c < 128;
        }
        if (i != 2) {
            return charsetEncoder.canEncode(c);
        }
        return true;
    }

    public static int d(String str, int[] iArr) {
        String str2 = b.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int iCodepointForName = EscapeMode.extended.codepointForName(str);
        if (iCodepointForName == -1) {
            return 0;
        }
        iArr[0] = iCodepointForName;
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Appendable appendable, String str, Document.OutputSettings outputSettings, boolean z, boolean z2, boolean z3) throws IOException {
        EscapeMode escapeModeE = outputSettings.e();
        CharsetEncoder charsetEncoderD = outputSettings.d();
        b bVarByName = b.byName(charsetEncoderD.charset().name());
        int length = str.length();
        int iCharCount = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (z2) {
                if (!jl5.f(iCodePointAt)) {
                    z4 = true;
                    z5 = false;
                    if (iCodePointAt >= 65536) {
                    }
                } else if ((!z3 || z4) && !z5) {
                    appendable.append(' ');
                    z5 = true;
                }
            } else if (iCodePointAt >= 65536) {
                char c = (char) iCodePointAt;
                if (c != '\"') {
                    if (c == '&') {
                        appendable.append("&amp;");
                    } else if (c != '<') {
                        if (c != '>') {
                            if (c != 160) {
                                if (c(bVarByName, c, charsetEncoderD)) {
                                    appendable.append(c);
                                } else {
                                    b(appendable, escapeModeE, iCodePointAt);
                                }
                            } else if (escapeModeE != EscapeMode.xhtml) {
                                appendable.append("&nbsp;");
                            } else {
                                appendable.append("&#xa0;");
                            }
                        } else if (z) {
                            appendable.append(c);
                        } else {
                            appendable.append("&gt;");
                        }
                    } else if (!z || escapeModeE == EscapeMode.xhtml) {
                        appendable.append("&lt;");
                    } else {
                        appendable.append(c);
                    }
                } else if (z) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c);
                }
            } else {
                String str2 = new String(Character.toChars(iCodePointAt));
                if (charsetEncoderD.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    b(appendable, escapeModeE, iCodePointAt);
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static boolean f(String str) {
        return EscapeMode.base.codepointForName(str) != -1;
    }

    public static boolean g(String str) {
        return EscapeMode.extended.codepointForName(str) != -1;
    }

    public static void h(EscapeMode escapeMode, String str, int i) {
        escapeMode.nameKeys = new String[i];
        escapeMode.codeVals = new int[i];
        escapeMode.codeKeys = new int[i];
        escapeMode.nameVals = new String[i];
        InputStream resourceAsStream = Entities.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalStateException("Could not read resource " + str + ". Make sure you copy resources for " + Entities.class.getCanonicalName());
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        int i2 = 0;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                Matcher matcher = f19827a.matcher(line);
                if (matcher.find()) {
                    String strGroup = matcher.group(1);
                    int i3 = Integer.parseInt(matcher.group(2), 36);
                    int i4 = matcher.group(3) != null ? Integer.parseInt(matcher.group(3), 36) : -1;
                    int i5 = Integer.parseInt(matcher.group(4), 36);
                    escapeMode.nameKeys[i2] = strGroup;
                    escapeMode.codeVals[i2] = i3;
                    escapeMode.codeKeys[i5] = i3;
                    escapeMode.nameVals[i5] = strGroup;
                    if (i4 != -1) {
                        b.put(strGroup, new String(new int[]{i3, i4}, 0, 2));
                    }
                    i2++;
                }
            } catch (IOException unused) {
                throw new IllegalStateException("Error reading resource " + str);
            }
        }
    }
}
