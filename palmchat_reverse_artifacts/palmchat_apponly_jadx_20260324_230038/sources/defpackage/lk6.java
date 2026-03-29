package defpackage;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lk6 implements pp2 {
    @Override // defpackage.pp2
    public String a(String str) {
        String strGroup = "";
        if (!TextUtils.isEmpty(str)) {
            Elements elementsH0 = cz2.a(str).H0(".rich_media_title");
            if (elementsH0 != null && elementsH0.text() != null) {
                return elementsH0.text();
            }
            Matcher matcher = Pattern.compile("var *msg_title *= *\"(.*)\"").matcher(str);
            while (matcher.find()) {
                strGroup = matcher.group(1);
            }
        }
        return strGroup;
    }

    public String b(String str) {
        Matcher matcher = Pattern.compile("var *msg_cdn_url *= *\"(.*)\"").matcher(str);
        String strGroup = "";
        while (matcher.find()) {
            strGroup = matcher.group(1);
        }
        return strGroup;
    }
}
