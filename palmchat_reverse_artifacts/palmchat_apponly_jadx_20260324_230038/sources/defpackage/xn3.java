package defpackage;

import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xn3 {
    public static String a() {
        return b() + String.valueOf(ir5.b());
    }

    public static String b() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 4; i++) {
            if (random.nextBoolean()) {
                str = str + ((char) ((random.nextBoolean() ? 65 : 97) + random.nextInt(26)));
            } else {
                str = str + String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }
}
