package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zz2<T> {
    public static String f = "cn.jiguang.sdk.share.profile";
    public static String g = "cn.jpush.preferences.v2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22541a;
    public String b;
    public T c;
    public boolean d;
    public boolean e;

    public zz2(String str, String str2, T t) {
        this.f22541a = str;
        this.b = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.c = t;
    }

    public static zz2<Long> A() {
        return new zz2(f, "key_share_process_uuid_creattime", -1L).c0();
    }

    public static zz2<Integer> B() {
        return new zz2<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static zz2<Boolean> C() {
        return new zz2<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", Boolean.TRUE);
    }

    public static zz2<String> D() {
        return new zz2<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static zz2<String> E() {
        return new zz2<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static zz2<Integer> F() {
        return new zz2("cn.jiguang.sdk.user.profile", "idc", -1).c0();
    }

    public static zz2<Long> G() {
        return new zz2<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static zz2<String> H() {
        return new zz2("cn.jiguang.sdk.user.profile", "key_pwd", "").c0();
    }

    public static zz2<String> I() {
        return new zz2("cn.jiguang.sdk.user.profile", "key_rid", "").c0();
    }

    public static zz2<Long> J() {
        return new zz2<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static zz2<Long> K() {
        return new zz2("cn.jiguang.sdk.user.profile", "key_uid", 0L).c0();
    }

    public static zz2<String> L() {
        return new zz2("cn.jiguang.sdk.address", "default_conn", "").b0();
    }

    public static zz2<String> M() {
        return new zz2("cn.jiguang.sdk.address", "default_conn_srv", "").b0();
    }

    public static zz2<String> N(boolean z) {
        return new zz2("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").c0().b0();
    }

    public static zz2<String> O(boolean z) {
        return new zz2("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").c0().b0();
    }

    public static zz2<String> P() {
        return new zz2("cn.jiguang.sdk.address", "default_sis_ips", "").b0();
    }

    public static zz2<String> R(String str) {
        return new zz2("IpInfos", str, "").b0();
    }

    public static zz2<String> S() {
        return new zz2("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").b0();
    }

    public static zz2<Integer> T(String str) {
        return new zz2<>("netinfo", str, 0);
    }

    public static zz2<Boolean> U() {
        return new zz2<>("cn.jiguang.sdk.address", "udp_data_report", Boolean.FALSE);
    }

    public static zz2<String> V(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_conn");
        sb.append(z ? "_V4" : "_V6");
        return new zz2("cn.jiguang.sdk.address", sb.toString(), "").b0();
    }

    public static zz2<String> W(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_sis_address");
        sb.append(z ? "_V4" : "_V6");
        return new zz2("cn.jiguang.sdk.address", sb.toString(), "").b0();
    }

    public static zz2<Long> X() {
        return new zz2<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static zz2<String> Z() {
        return new zz2<>("PrefsFile", "key", "");
    }

    public static zz2<String> a(String str) {
        return new zz2("cn.jiguang.sdk.address", "dns_" + str, "").b0();
    }

    public static zz2<Long> b(String str) {
        return new zz2<>("cn.jiguang.sdk.address", "dns_last_update_" + str, 0L);
    }

    public static zz2<String> c(String str) {
        return new zz2("cn.jiguang.sdk.address", "srv_" + str, "").b0();
    }

    public static zz2<Long> d(String str) {
        return new zz2<>("cn.jiguang.sdk.address", "srv_last_update_" + str, 0L);
    }

    public static zz2<Long> d0() {
        return new zz2<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static zz2<String> e() {
        return new zz2<>(g, "device_config_appkey", "");
    }

    public static zz2<String> e0() {
        return new zz2("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").b0();
    }

    public static zz2<String> f() {
        return new zz2<>(g, "i_new", "");
    }

    public static zz2<String> f0() {
        return new zz2("cn.jiguang.sdk.address", "tcp_report", "").c0().b0();
    }

    public static zz2<String> g() {
        return new zz2<>(g, "push_udid", "");
    }

    public static zz2<String> h() {
        return new zz2(g, "sdk_version", "").c0();
    }

    public static zz2<String> i() {
        return new zz2<>(g, "last_connection_type", "");
    }

    public static zz2<String> j() {
        return new zz2(g, "sis_report_history", "").b0();
    }

    public static zz2<Boolean> k() {
        return new zz2<>("cn.jpush.android.user.profile", "is_tcp_close", Boolean.FALSE);
    }

    public static zz2<String> l(String str) {
        return new zz2<>("cn.jpush.android.user.profile", "sdk_version_" + str, "");
    }

    public static zz2<Boolean> m() {
        return new zz2<>("cn.jpush.android.user.profile", "upload_crash", Boolean.TRUE);
    }

    public static zz2<String> n() {
        return new zz2("cn.jpush.android.user.profile", "devcie_id_generated", "").c0();
    }

    public static zz2<Long> o() {
        return new zz2<>("Push_Page_Config", "cse", 0L);
    }

    public static zz2<Long> p() {
        return new zz2<>("Push_Page_Config", "last_pause", -1L);
    }

    public static zz2<String> q() {
        return new zz2<>("Push_Page_Config", "session_id", "");
    }

    public static zz2<Long> r() {
        return new zz2<>("Push_Page_Config", "css", 0L);
    }

    public static zz2<Integer> s() {
        return new zz2("cn.jpush.android.user.profile", "jpush_register_code", -1).c0();
    }

    public static zz2<Long> t() {
        return new zz2<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static zz2<String> u() {
        return new zz2("cn.jiguang.sdk.report", "report_sis_urls", "").b0();
    }

    public static zz2<String> v() {
        return new zz2("cn.jiguang.sdk.report", "report_urls", "").b0();
    }

    public static zz2<Long> w() {
        return new zz2<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", 3600000L);
    }

    public static zz2<Long> x() {
        return new zz2<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static zz2<Integer> y() {
        return new zz2(f, "sp_state", -1).c0();
    }

    public static zz2<String> z() {
        return new zz2(f, "key_share_process_uuid", "").c0();
    }

    public zz2<T> Q(String str) {
        this.f22541a = str;
        return this;
    }

    public zz2<T> Y(String str) {
        this.b = str;
        return this;
    }

    public zz2<T> a0(T t) {
        this.c = t;
        return this;
    }

    public final zz2<T> b0() {
        this.e = true;
        return this;
    }

    public final zz2<T> c0() {
        this.d = true;
        return this;
    }
}
