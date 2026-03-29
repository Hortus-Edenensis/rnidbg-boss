package defpackage;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hs0 {
    public static volatile hs0 b;
    public static PhoneNumberUtil c = PhoneNumberUtil.getInstance();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18039a = "";

    public hs0() {
        i();
    }

    public static int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return 86;
        }
        return Integer.valueOf(str.replace("+", "")).intValue();
    }

    public static hs0 g() {
        if (b == null) {
            synchronized (hs0.class) {
                if (b == null) {
                    b = new hs0();
                }
            }
        }
        return b;
    }

    public String a(String str, String str2) {
        try {
            return c.format(c.parse(str, h(f(str2))), PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String b(String str, String str2, PhoneNumberUtil.PhoneNumberFormat phoneNumberFormat) {
        try {
            return c.format(c.parse(str, h(f(str2))), phoneNumberFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String c(String str) {
        String strI = AccountUtils.i(AppContext.getContext());
        String strValueOf = "";
        if (!TextUtils.isEmpty(strI)) {
            try {
                Phonenumber.PhoneNumber phoneNumber = c.parse(str, h(f(strI)));
                if (c.isValidNumber(phoneNumber)) {
                    if (c.getNumberType(phoneNumber) == PhoneNumberUtil.PhoneNumberType.MOBILE || c.getNumberType(phoneNumber) == PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                        strValueOf = String.valueOf(phoneNumber.getCountryCode());
                    }
                } else if (phoneNumber.getCountryCode() != 0 && phoneNumber.getNationalNumber() != 0) {
                    strValueOf = String.valueOf(phoneNumber.getCountryCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strValueOf;
    }

    public String d(String str) {
        String strK;
        String strI = AccountUtils.i(AppContext.getContext());
        if (TextUtils.isEmpty(strI)) {
            strK = null;
        } else {
            strK = k(str, h(f(strI)));
            if (TextUtils.isEmpty(strK) && !TextUtils.isEmpty(this.f18039a)) {
                strK = k(str, this.f18039a);
            }
        }
        return strK != null ? rb3.c(strK) : strK;
    }

    public String e(String str, String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }

    public final String h(int i) {
        return PhoneNumberUtil.getInstance().getRegionCodeForCountryCode(i);
    }

    public final void i() {
        TelephonyManager telephonyManager = (TelephonyManager) AppContext.getContext().getSystemService("phone");
        String simCountryIso = telephonyManager.getSimCountryIso();
        String networkCountryIso = telephonyManager.getNetworkCountryIso();
        if (!TextUtils.isEmpty(simCountryIso)) {
            this.f18039a = simCountryIso.toUpperCase();
        } else {
            if (TextUtils.isEmpty(networkCountryIso)) {
                return;
            }
            this.f18039a = networkCountryIso.toUpperCase();
        }
    }

    public boolean j(String str, String str2) {
        try {
            Phonenumber.PhoneNumber phoneNumber = c.parse(str, h(f(str2)));
            if (!c.isValidNumber(phoneNumber)) {
                return false;
            }
            if (c.getNumberType(phoneNumber) != PhoneNumberUtil.PhoneNumberType.MOBILE) {
                if (c.getNumberType(phoneNumber) != PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String k(String str, String str2) {
        String str3;
        try {
            Phonenumber.PhoneNumber phoneNumber = c.parse(str, str2);
            if (c.isValidNumber(phoneNumber)) {
                if (c.getNumberType(phoneNumber) != PhoneNumberUtil.PhoneNumberType.MOBILE && c.getNumberType(phoneNumber) != PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                    return null;
                }
                str3 = String.valueOf(phoneNumber.getCountryCode()) + String.valueOf(phoneNumber.getNationalNumber());
            } else {
                if (phoneNumber.getCountryCode() == 0 || phoneNumber.getNationalNumber() == 0) {
                    return null;
                }
                str3 = String.valueOf(phoneNumber.getCountryCode()) + String.valueOf(phoneNumber.getNationalNumber());
            }
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
