package defpackage;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ws4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f21790a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(f21790a[random.nextInt(f21790a.length)]);
        }
        sb.append("_");
        sb.append(AccountUtils.p(AppContext.getContext()));
        return sb.toString();
    }
}
