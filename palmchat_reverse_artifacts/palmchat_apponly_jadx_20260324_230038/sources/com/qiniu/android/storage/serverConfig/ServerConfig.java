package com.qiniu.android.storage.serverConfig;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.http.dns.DnsSource;
import com.qiniu.android.utils.Utils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ServerConfig {
    private DnsConfig dnsConfig;
    private JSONObject info;
    private RegionConfig regionConfig;
    private long timestamp;
    private long ttl;

    /* JADX INFO: compiled from: SearchBox */
    public static class DnsConfig {
        private boolean clearCache;
        private long clearId;
        private DohDnsConfig dohDnsConfig;
        private Boolean enable;
        private UdpDnsConfig udpDnsConfig;

        public DnsConfig(JSONObject jSONObject) {
            this.clearCache = false;
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.opt("enabled") != null) {
                this.enable = Boolean.valueOf(jSONObject.optBoolean("enabled"));
            }
            this.clearId = jSONObject.optLong("clear_id");
            this.clearCache = jSONObject.optBoolean("clear_cache", false);
            this.udpDnsConfig = new UdpDnsConfig(jSONObject.optJSONObject("udp"));
            this.dohDnsConfig = new DohDnsConfig(jSONObject.optJSONObject(DnsSource.Doh));
        }

        public boolean getClearCache() {
            return this.clearCache;
        }

        public long getClearId() {
            return this.clearId;
        }

        public DohDnsConfig getDohDnsConfig() {
            return this.dohDnsConfig;
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public UdpDnsConfig getUdpDnsConfig() {
            return this.udpDnsConfig;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DnsServer {
        private boolean isOverride;
        private String[] servers;

        public DnsServer(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.isOverride = jSONObject.optBoolean("override_default");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            jSONArrayOptJSONArray = jSONArrayOptJSONArray == null ? jSONObject.optJSONArray("urls") : jSONArrayOptJSONArray;
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i, null);
                    if (strOptString != null) {
                        arrayList.add(strOptString);
                    }
                }
            }
            this.servers = (String[]) arrayList.toArray(new String[0]);
        }

        public boolean getIsOverride() {
            return this.isOverride;
        }

        public String[] getServers() {
            return this.servers;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DohDnsConfig {
        private Boolean enable;
        private DnsServer ipv4Server;
        private DnsServer ipv6Server;

        public DohDnsConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.opt("enabled") != null) {
                this.enable = Boolean.valueOf(jSONObject.optBoolean("enabled"));
            }
            this.ipv4Server = new DnsServer(jSONObject.optJSONObject("ipv4"));
            this.ipv6Server = new DnsServer(jSONObject.optJSONObject("ipv6"));
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public DnsServer getIpv4Server() {
            return this.ipv4Server;
        }

        public DnsServer getIpv6Server() {
            return this.ipv6Server;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class RegionConfig {
        private boolean clearCache;
        private long clearId;

        public RegionConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.clearId = jSONObject.optLong("clear_id");
            this.clearCache = jSONObject.optBoolean("clear_cache", false);
        }

        public boolean getClearCache() {
            return this.clearCache;
        }

        public long getClearId() {
            return this.clearId;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class UdpDnsConfig {
        private Boolean enable;
        private DnsServer ipv4Server;
        private DnsServer ipv6Server;

        public UdpDnsConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.opt("enabled") != null) {
                this.enable = Boolean.valueOf(jSONObject.optBoolean("enabled"));
            }
            this.ipv4Server = new DnsServer(jSONObject.optJSONObject("ipv4"));
            this.ipv6Server = new DnsServer(jSONObject.optJSONObject("ipv6"));
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public DnsServer getIpv4Server() {
            return this.ipv4Server;
        }

        public DnsServer getIpv6Server() {
            return this.ipv6Server;
        }
    }

    public ServerConfig(JSONObject jSONObject) {
        this.ttl = 10L;
        if (jSONObject == null) {
            return;
        }
        this.info = jSONObject;
        this.ttl = jSONObject.optLong(RemoteMessageConst.TTL, 300L);
        if (jSONObject.opt("timestamp") != null) {
            this.timestamp = jSONObject.optLong("timestamp");
        }
        if (this.timestamp == 0) {
            long jCurrentSecondTimestamp = Utils.currentSecondTimestamp();
            this.timestamp = jCurrentSecondTimestamp;
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(jCurrentSecondTimestamp));
            } catch (JSONException unused) {
            }
        }
        this.dnsConfig = new DnsConfig(jSONObject.optJSONObject(DnsSource.Udp));
        this.regionConfig = new RegionConfig(jSONObject.optJSONObject("region"));
        if (this.ttl < 10) {
            this.ttl = 10L;
        }
    }

    public DnsConfig getDnsConfig() {
        return this.dnsConfig;
    }

    public JSONObject getInfo() {
        return this.info;
    }

    public RegionConfig getRegionConfig() {
        return this.regionConfig;
    }

    public boolean isValid() {
        return Utils.currentSecondTimestamp() < this.timestamp + this.ttl;
    }
}
