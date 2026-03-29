package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.auth.server.WkParams;
import com.wifi.adsdk.utils.WkSecretKey;
import com.wifi.utils.ConstantMix;
import com.zenmen.openapi.offline.request.BaseBean;
import com.zenmen.openapi.offline.request.FetchPkgInfo;
import com.zenmen.openapi.offline.request.OfflineResponseBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class y54 extends co6<OfflineResponseBean> {
    public String k;
    public List<FetchPkgInfo> l;

    public y54(String str, List<FetchPkgInfo> list, eo6 eo6Var) {
        super(1, r(), eo6Var);
        this.k = str;
        this.l = list;
    }

    public static String r() {
        String strC = nl0.c();
        return (strC.equals("debug") || strC.equals("debug2") || strC.equals("debug3") || strC.equals("dev")) ? "http://wifi3a.51y5.net/alps/fa.sec" : "http://tissbon.51y5.net/alps/fa.sec";
    }

    public static String s(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (String str : map.keySet()) {
            if (i > 0) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            String str2 = map.get(str);
            try {
                String strEncode = URLEncoder.encode(str, "UTF-8");
                if (str2 == null) {
                    str2 = "";
                }
                String strEncode2 = URLEncoder.encode(str2, "UTF-8");
                stringBuffer.append(strEncode);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(strEncode2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String t(List<FetchPkgInfo> list) {
        JSONArray jSONArray = new JSONArray();
        for (FetchPkgInfo fetchPkgInfo : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extId", fetchPkgInfo.getExtId());
                jSONObject.put("verCode", fetchPkgInfo.getVerCode());
            } catch (JSONException e) {
                ma3.c(e);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public static String v(Map<String, String> map) {
        String string = new JSONObject(map).toString();
        map.clear();
        try {
            map.put("appId", eb4.b());
            map.put("pid", "66658001");
            map.put("ed", WkSecretKey.encryptAES(Uri.encode(string.trim(), "UTF-8"), ConstantMix.AES_KEY, ConstantMix.AES_IV));
            map.put("et", "a");
            map.put("st", "m");
            map.put("sign", ja5.d(map, ConstantMix.MD5_KEY));
        } catch (Exception e) {
            ma3.c(e);
        }
        return s(map);
    }

    @Override // defpackage.co6
    public byte[] e() {
        HashMap map = new HashMap();
        map.put("bizId", this.k);
        map.put("pkgInfos", t(this.l));
        try {
            return v(map).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.co6
    public Map<String, List<String>> g() {
        return null;
    }

    @Override // defpackage.co6
    public do6<OfflineResponseBean> n(bo6 bo6Var) {
        try {
            String str = new String(bo6Var.a(), "UTF-8");
            ma3.a("config:" + str, new Object[0]);
            OfflineResponseBean offlineResponseBeanU = u(str);
            return BaseBean.isSuccess(offlineResponseBeanU) ? do6.e(offlineResponseBeanU) : w(offlineResponseBeanU);
        } catch (UnsupportedEncodingException e) {
            return do6.a(e);
        } catch (Exception e2) {
            return do6.a(e2);
        }
    }

    public final OfflineResponseBean u(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        OfflineResponseBean offlineResponseBean = new OfflineResponseBean();
        if (jSONObject.has(WkParams.RETCD)) {
            offlineResponseBean.setRetCd(jSONObject.getString(WkParams.RETCD));
        }
        if (jSONObject.has(WkParams.RETMSG)) {
            offlineResponseBean.setRetMsg(jSONObject.getString(WkParams.RETMSG));
        }
        return jSONObject.has("pkgInfos") ? (OfflineResponseBean) new Gson().fromJson(jSONObject.toString(), OfflineResponseBean.class) : offlineResponseBean;
    }

    public final do6<OfflineResponseBean> w(BaseBean baseBean) {
        if (baseBean == null) {
            return do6.a(new Exception("Json format error"));
        }
        String retMsg = baseBean.getRetMsg();
        return !TextUtils.isEmpty(retMsg) ? do6.a(new Exception(retMsg)) : do6.a(new Exception("empty response message"));
    }
}
