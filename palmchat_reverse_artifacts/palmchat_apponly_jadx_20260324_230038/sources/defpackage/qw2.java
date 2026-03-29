package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class qw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n05 f20337a;

    public static void a(lj2 lj2Var, Context context, byte[] bArr, int i) throws Exception {
        lj2Var.l(30000);
        lj2Var.r(30000);
        lj2Var.n(true);
        lj2Var.m(true);
        lj2Var.v(false);
        String strH = n45.h(n45.i());
        byte[] bArrA = n45.a(bArr, strH, i == 2 ? "0102030405060708" : "iop203040506aPk!", true);
        lj2Var.k(bArrA);
        lj2Var.s("Content-Length", String.valueOf(bArrA.length));
        lj2Var.q(true);
        if (f20337a == null) {
            try {
                if (!TextUtils.isEmpty("-----BEGIN CERTIFICATE-----\nMIIDjjCCAnagAwIBAgIQAzrx5qcRqaC7KGSxHQn65TANBgkqhkiG9w0BAQsFADBh\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\nd3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBH\nMjAeFw0xMzA4MDExMjAwMDBaFw0zODAxMTUxMjAwMDBaMGExCzAJBgNVBAYTAlVT\nMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\nb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IEcyMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzfNNNx7a8myaJCtSnX/RrohCgiN9RlUyfuI\n2/Ou8jqJkTx65qsGGmvPrC3oXgkkRLpimn7Wo6h+4FR1IAWsULecYxpsMNzaHxmx\n1x7e/dfgy5SDN67sH0NO3Xss0r0upS/kqbitOtSZpLYl6ZtrAGCSYP9PIUkY92eQ\nq2EGnI/yuum06ZIya7XzV+hdG82MHauVBJVJ8zUtluNJbd134/tJS7SsVQepj5Wz\ntCO7TG1F8PapspUwtP1MVYwnSlcUfIKdzXOS0xZKBgyMUNGPHgm+F6HmIcr9g+UQ\nvIOlCsRnKPZzFBQ9RnbDhxSJITRNrw9FDKZJobq7nMWxM4MphQIDAQABo0IwQDAP\nBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNVHQ4EFgQUTiJUIBiV\n5uNu5g/6+rkS7QYXjzkwDQYJKoZIhvcNAQELBQADggEBAGBnKJRvDkhj6zHd6mcY\n1Yl9PMWLSn/pvtsrF9+wX3N3KjITOYFnQoQj8kVnNeyIv/iPsGEMNKSuIEyExtv4\nNeF22d+mQrvHRAiGfzZ0JFrabA0UWTW98kndth/Jsw1HKj2ZL7tcu7XUIOGZX1NG\nFdtom/DzMNU+MeKNhJ7jitralj41E6Vf8PlwUHBHQRFXGU7Aj64GxJUTFy8bJZ91\n8rGOmaFvE7FBcf6IKshPECBV1/MUReXgRPTqh5Uykw7+U0b6LJ3/iyK5S9kJRaTe\npLiaWN0bfVKfjllDiIGknibVb63dDcY3fe0Dkhvld1927jyNxF1WW6LZZm6zNTfl\nMrY=\n-----END CERTIFICATE-----")) {
                    f20337a = new n05("-----BEGIN CERTIFICATE-----\nMIIDjjCCAnagAwIBAgIQAzrx5qcRqaC7KGSxHQn65TANBgkqhkiG9w0BAQsFADBh\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\nd3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBH\nMjAeFw0xMzA4MDExMjAwMDBaFw0zODAxMTUxMjAwMDBaMGExCzAJBgNVBAYTAlVT\nMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\nb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IEcyMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzfNNNx7a8myaJCtSnX/RrohCgiN9RlUyfuI\n2/Ou8jqJkTx65qsGGmvPrC3oXgkkRLpimn7Wo6h+4FR1IAWsULecYxpsMNzaHxmx\n1x7e/dfgy5SDN67sH0NO3Xss0r0upS/kqbitOtSZpLYl6ZtrAGCSYP9PIUkY92eQ\nq2EGnI/yuum06ZIya7XzV+hdG82MHauVBJVJ8zUtluNJbd134/tJS7SsVQepj5Wz\ntCO7TG1F8PapspUwtP1MVYwnSlcUfIKdzXOS0xZKBgyMUNGPHgm+F6HmIcr9g+UQ\nvIOlCsRnKPZzFBQ9RnbDhxSJITRNrw9FDKZJobq7nMWxM4MphQIDAQABo0IwQDAP\nBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNVHQ4EFgQUTiJUIBiV\n5uNu5g/6+rkS7QYXjzkwDQYJKoZIhvcNAQELBQADggEBAGBnKJRvDkhj6zHd6mcY\n1Yl9PMWLSn/pvtsrF9+wX3N3KjITOYFnQoQj8kVnNeyIv/iPsGEMNKSuIEyExtv4\nNeF22d+mQrvHRAiGfzZ0JFrabA0UWTW98kndth/Jsw1HKj2ZL7tcu7XUIOGZX1NG\nFdtom/DzMNU+MeKNhJ7jitralj41E6Vf8PlwUHBHQRFXGU7Aj64GxJUTFy8bJZ91\n8rGOmaFvE7FBcf6IKshPECBV1/MUReXgRPTqh5Uykw7+U0b6LJ3/iyK5S9kJRaTe\npLiaWN0bfVKfjllDiIGknibVb63dDcY3fe0Dkhvld1927jyNxF1WW6LZZm6zNTfl\nMrY=\n-----END CERTIFICATE-----");
                }
            } catch (Throwable unused) {
            }
        }
        n05 n05Var = f20337a;
        if (n05Var != null) {
            lj2Var.u(n05Var);
        }
        lj2Var.s(HttpHeaders.ACCEPT, "application/jason");
        lj2Var.s(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        lj2Var.s("X-App-Key", fv2.e(context));
        if (i == 2) {
            lj2Var.o(true);
            lj2Var.t(true);
            lj2Var.p(true);
            lj2Var.s("FillType", "1");
            lj2Var.s(HttpHeaders.AUTHORIZATION, nw4.h(strH));
        } else {
            lj2Var.o(false);
            lj2Var.t(false);
            lj2Var.s(HttpHeaders.AUTHORIZATION, "Basic " + nw4.g(context, nl5.e(bArrA), strH));
        }
        lj2Var.s("Charset", "UTF-8");
    }

    public static void b(lj2 lj2Var, Context context, byte[] bArr, int i, int i2) throws Exception {
        lj2Var.l(30000);
        lj2Var.r(30000);
        lj2Var.n(true);
        lj2Var.m(true);
        lj2Var.v(false);
        lj2Var.k(bArr);
        lj2Var.s("Content-Length", String.valueOf(bArr.length));
        lj2Var.q(true);
        if (f20337a == null) {
            try {
                if (!TextUtils.isEmpty("-----BEGIN CERTIFICATE-----\nMIIDjjCCAnagAwIBAgIQAzrx5qcRqaC7KGSxHQn65TANBgkqhkiG9w0BAQsFADBh\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\nd3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBH\nMjAeFw0xMzA4MDExMjAwMDBaFw0zODAxMTUxMjAwMDBaMGExCzAJBgNVBAYTAlVT\nMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\nb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IEcyMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzfNNNx7a8myaJCtSnX/RrohCgiN9RlUyfuI\n2/Ou8jqJkTx65qsGGmvPrC3oXgkkRLpimn7Wo6h+4FR1IAWsULecYxpsMNzaHxmx\n1x7e/dfgy5SDN67sH0NO3Xss0r0upS/kqbitOtSZpLYl6ZtrAGCSYP9PIUkY92eQ\nq2EGnI/yuum06ZIya7XzV+hdG82MHauVBJVJ8zUtluNJbd134/tJS7SsVQepj5Wz\ntCO7TG1F8PapspUwtP1MVYwnSlcUfIKdzXOS0xZKBgyMUNGPHgm+F6HmIcr9g+UQ\nvIOlCsRnKPZzFBQ9RnbDhxSJITRNrw9FDKZJobq7nMWxM4MphQIDAQABo0IwQDAP\nBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNVHQ4EFgQUTiJUIBiV\n5uNu5g/6+rkS7QYXjzkwDQYJKoZIhvcNAQELBQADggEBAGBnKJRvDkhj6zHd6mcY\n1Yl9PMWLSn/pvtsrF9+wX3N3KjITOYFnQoQj8kVnNeyIv/iPsGEMNKSuIEyExtv4\nNeF22d+mQrvHRAiGfzZ0JFrabA0UWTW98kndth/Jsw1HKj2ZL7tcu7XUIOGZX1NG\nFdtom/DzMNU+MeKNhJ7jitralj41E6Vf8PlwUHBHQRFXGU7Aj64GxJUTFy8bJZ91\n8rGOmaFvE7FBcf6IKshPECBV1/MUReXgRPTqh5Uykw7+U0b6LJ3/iyK5S9kJRaTe\npLiaWN0bfVKfjllDiIGknibVb63dDcY3fe0Dkhvld1927jyNxF1WW6LZZm6zNTfl\nMrY=\n-----END CERTIFICATE-----")) {
                    f20337a = new n05("-----BEGIN CERTIFICATE-----\nMIIDjjCCAnagAwIBAgIQAzrx5qcRqaC7KGSxHQn65TANBgkqhkiG9w0BAQsFADBh\nMQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\nd3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBH\nMjAeFw0xMzA4MDExMjAwMDBaFw0zODAxMTUxMjAwMDBaMGExCzAJBgNVBAYTAlVT\nMRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\nb20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IEcyMIIBIjANBgkqhkiG\n9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzfNNNx7a8myaJCtSnX/RrohCgiN9RlUyfuI\n2/Ou8jqJkTx65qsGGmvPrC3oXgkkRLpimn7Wo6h+4FR1IAWsULecYxpsMNzaHxmx\n1x7e/dfgy5SDN67sH0NO3Xss0r0upS/kqbitOtSZpLYl6ZtrAGCSYP9PIUkY92eQ\nq2EGnI/yuum06ZIya7XzV+hdG82MHauVBJVJ8zUtluNJbd134/tJS7SsVQepj5Wz\ntCO7TG1F8PapspUwtP1MVYwnSlcUfIKdzXOS0xZKBgyMUNGPHgm+F6HmIcr9g+UQ\nvIOlCsRnKPZzFBQ9RnbDhxSJITRNrw9FDKZJobq7nMWxM4MphQIDAQABo0IwQDAP\nBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNVHQ4EFgQUTiJUIBiV\n5uNu5g/6+rkS7QYXjzkwDQYJKoZIhvcNAQELBQADggEBAGBnKJRvDkhj6zHd6mcY\n1Yl9PMWLSn/pvtsrF9+wX3N3KjITOYFnQoQj8kVnNeyIv/iPsGEMNKSuIEyExtv4\nNeF22d+mQrvHRAiGfzZ0JFrabA0UWTW98kndth/Jsw1HKj2ZL7tcu7XUIOGZX1NG\nFdtom/DzMNU+MeKNhJ7jitralj41E6Vf8PlwUHBHQRFXGU7Aj64GxJUTFy8bJZ91\n8rGOmaFvE7FBcf6IKshPECBV1/MUReXgRPTqh5Uykw7+U0b6LJ3/iyK5S9kJRaTe\npLiaWN0bfVKfjllDiIGknibVb63dDcY3fe0Dkhvld1927jyNxF1WW6LZZm6zNTfl\nMrY=\n-----END CERTIFICATE-----");
                }
            } catch (Throwable unused) {
            }
        }
        n05 n05Var = f20337a;
        if (n05Var != null) {
            lj2Var.u(n05Var);
        }
        lj2Var.s(HttpHeaders.ACCEPT, "application/jason");
        lj2Var.s(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        lj2Var.s("X-App-Key", fv2.e(context));
        lj2Var.s("Charset", "UTF-8");
        String strH = n45.h(i);
        if (i2 == 2) {
            lj2Var.o(true);
            lj2Var.t(true);
            lj2Var.p(true);
            lj2Var.s("FillType", "1");
            lj2Var.s(HttpHeaders.AUTHORIZATION, nw4.h(strH));
            return;
        }
        lj2Var.o(false);
        lj2Var.t(false);
        lj2Var.s(HttpHeaders.AUTHORIZATION, "Basic " + nw4.g(context, nl5.e(bArr), strH));
    }

    public static px4 c(Context context, String str, byte[] bArr, int i, int i2, int i3) {
        try {
            lj2 lj2Var = new lj2(str);
            b(lj2Var, context, bArr, i, i3);
            while (i2 > 0) {
                i2--;
                mj2 mj2VarB = sj2.b(context, lj2Var);
                int iB = mj2VarB.b();
                k63.b("HttpHelper", "status code:" + iB + " retry left:" + i2);
                if (iB == 200) {
                    return new px4(0, mj2VarB.a());
                }
                if (iB == 401) {
                    return new px4(-3, mj2VarB.a());
                }
                if (iB == 404 || iB == 410 || iB == 429) {
                    return new px4(-1, mj2VarB.a());
                }
                if (iB == 503) {
                    return new px4(-2, mj2VarB.a());
                }
                if (iB != 3005) {
                    return iB >= 500 ? new px4(-1, mj2VarB.a()) : new px4(-2, mj2VarB.a());
                }
            }
            return new px4(-2, "Failed - retry enough");
        } catch (AssertionError e) {
            return new px4(-2, "Catch AssertionError to avoid http close crash - " + e.getMessage());
        } catch (Exception e2) {
            return new px4(-2, "Exception - " + e2.getMessage());
        } catch (Throwable th) {
            return new px4(-2, "Exception - " + th.getMessage());
        }
    }

    public static px4 d(String str, String str2, Context context, boolean z, int i, int i2) {
        try {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (z) {
                    try {
                        bytes = z86.d(bytes);
                    } catch (IOException e) {
                        return new px4(-2, "zip err:" + e.getMessage());
                    }
                }
                lj2 lj2Var = new lj2(str);
                a(lj2Var, context, bytes, i2);
                while (i > 0) {
                    i--;
                    mj2 mj2VarB = sj2.b(context, lj2Var);
                    int iB = mj2VarB.b();
                    k63.b("HttpHelper", "status code:" + iB + " retry left:" + i);
                    if (iB == 200) {
                        return new px4(0, mj2VarB.a());
                    }
                    if (iB == 401) {
                        return new px4(-3, mj2VarB.a());
                    }
                    if (iB == 404 || iB == 410 || iB == 429) {
                        return new px4(-1, mj2VarB.a());
                    }
                    if (iB == 503) {
                        return new px4(-2, mj2VarB.a());
                    }
                    if (iB != 3005) {
                        return iB >= 500 ? new px4(-1, mj2VarB.a()) : new px4(-2, mj2VarB.a());
                    }
                }
                return new px4(-2, "Failed - retry enough");
            } catch (UnsupportedEncodingException e2) {
                return new px4(-2, "Exception - " + e2.getMessage());
            }
        } catch (AssertionError e3) {
            return new px4(-2, "Catch AssertionError to avoid http close crash - " + e3.getMessage());
        } catch (Exception e4) {
            return new px4(-2, "Exception - " + e4.getMessage());
        } catch (Throwable th) {
            return new px4(-2, "Exception - " + th.getMessage());
        }
    }
}
