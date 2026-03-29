package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class me3 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19200a;
        public String b;

        public boolean a() {
            return !TextUtils.isEmpty(this.f19200a);
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("acode", str2);
        return builderBuildUpon.build().toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("acode");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add((String) jSONArrayOptJSONArray.get(i));
                }
            }
            if (arrayList.size() <= 0) {
                return str;
            }
            String str2 = (String) arrayList.get(0);
            String strOptString = jSONObject.optString("hdUrl");
            if (!TextUtils.isEmpty(strOptString)) {
                jSONObject.put("hdUrl", a(strOptString, str2));
            }
            String strOptString2 = jSONObject.optString("midUrl");
            if (!TextUtils.isEmpty(strOptString2)) {
                jSONObject.put("midUrl", a(strOptString2, str2));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("acode");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add((String) jSONArrayOptJSONArray.get(i));
                }
            }
            if (arrayList.size() <= 0) {
                return str;
            }
            String strOptString = jSONObject.optString("hdUrl");
            if (!TextUtils.isEmpty(strOptString)) {
                jSONObject.put("hdUrl", d(strOptString).b);
            }
            String strOptString2 = jSONObject.optString("midUrl");
            if (!TextUtils.isEmpty(strOptString2)) {
                jSONObject.put("midUrl", d(strOptString2).b);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static a d(String str) {
        a aVar = new a();
        if (!TextUtils.isEmpty(str)) {
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("acode");
            if (TextUtils.isEmpty(queryParameter)) {
                aVar.f19200a = null;
                aVar.b = str;
            } else {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.clearQuery();
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null) {
                    for (String str2 : queryParameterNames) {
                        if (!str2.equals("acode")) {
                            builderBuildUpon.appendQueryParameter(str2, uri.getQueryParameter(str2));
                        }
                    }
                }
                aVar.f19200a = queryParameter;
                aVar.b = builderBuildUpon.build().toString();
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[Catch: JSONException -> 0x00d0, TryCatch #0 {JSONException -> 0x00d0, blocks: (B:6:0x0018, B:9:0x002c, B:11:0x0032, B:13:0x003a, B:14:0x0043, B:15:0x0046, B:17:0x004c, B:19:0x0059, B:22:0x0065, B:24:0x006b, B:26:0x007b, B:27:0x0082, B:29:0x008c, B:30:0x0093, B:32:0x009d, B:33:0x00a1, B:35:0x00ab, B:36:0x00af, B:38:0x00b5, B:41:0x00c8, B:40:0x00bb), top: B:46:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MessageProto.Message.Media e(MessageProto.Message message) {
        String str;
        String str2;
        MessageProto.Message.Media media = message.getMedia();
        if (message.getMedia() == null) {
            return media;
        }
        String extension = media.getExtension();
        if (TextUtils.isEmpty(extension)) {
            return media;
        }
        try {
            JSONObject jSONObject = new JSONObject(extension);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("acode");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    if (jSONArrayOptJSONArray.get(i) instanceof String) {
                        arrayList.add((String) jSONArrayOptJSONArray.get(i));
                    }
                }
            }
            if (arrayList.size() > 0) {
                str = (String) arrayList.get(0);
                if (arrayList.size() > 1) {
                    String str3 = (String) arrayList.get(1);
                    str2 = str;
                    str = str3;
                }
                if (!TextUtils.isEmpty(str)) {
                    return media;
                }
                MessageProto.Message.Media.Builder builder = media.toBuilder();
                String url = media.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    builder.setUrl(a(url, str));
                }
                String thumbUrl = media.getThumbUrl();
                if (!TextUtils.isEmpty(thumbUrl)) {
                    builder.setThumbUrl(a(thumbUrl, str2));
                }
                String strOptString = jSONObject.optString("hdUrl");
                if (!TextUtils.isEmpty(strOptString)) {
                    strOptString = a(strOptString, str);
                }
                String strOptString2 = jSONObject.optString("midUrl");
                if (!TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = a(strOptString2, str);
                }
                if (!TextUtils.isEmpty(strOptString) || !TextUtils.isEmpty(strOptString2)) {
                    jSONObject.put("hdUrl", strOptString);
                    jSONObject.put("midUrl", strOptString2);
                    builder.setExtension(jSONObject.toString());
                }
                return builder.build();
            }
            str = null;
            str2 = str;
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return media;
        }
    }
}
