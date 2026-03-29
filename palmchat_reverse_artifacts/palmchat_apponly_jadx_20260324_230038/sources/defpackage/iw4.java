package defpackage;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.openapi.impl.OADeviceUtils;
import com.zenmen.palmchat.c;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18275a;
    public String c;
    public String d;
    public String e;
    public String f;
    public String h;
    public String i;
    public String j;
    public Map<String, String> k;
    public String g = v4.e(c.b());
    public String b = UUID.randomUUID().toString().replace("-", "");

    public iw4(String str) {
        this.e = str;
    }

    public Map<String, String> a(String str) {
        this.k = new HashMap();
        if (!TextUtils.isEmpty(this.f18275a)) {
            this.k.put("tappid", this.f18275a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            this.k.put("sid", this.b);
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = MapController.DEFAULT_LAYER_TAG;
        }
        this.k.put("scene", this.d);
        if (!TextUtils.isEmpty(this.c)) {
            this.k.put("type", this.c);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.k.put("userId", this.g);
        }
        this.k.put("oav", "V210607");
        if (!TextUtils.isEmpty(this.f)) {
            this.k.put("data", this.f);
        }
        this.k.put("code", str);
        if (!TextUtils.isEmpty(this.h)) {
            this.k.put("reqid", this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.k.put("msgtype", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.k.put("mchid", this.j);
        }
        String deviceId = OADeviceUtils.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = "empty";
        }
        this.k.put(DeviceInfoUtil.DEVICEID_TAG, deviceId);
        return this.k;
    }
}
