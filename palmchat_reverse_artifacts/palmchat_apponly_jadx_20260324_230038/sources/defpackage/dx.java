package defpackage;

import android.telephony.TelephonyManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.privinfo.PrivInfoManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dx {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        String networkOperator;
        byte b;
        AppContext context = AppContext.getContext();
        if (context == null) {
            return 4;
        }
        try {
            if (((TelephonyManager) context.getSystemService("phone")) == null || (networkOperator = PrivInfoManager.INSTANCE.getNetworkOperator()) == null) {
                return 4;
            }
            int iHashCode = networkOperator.hashCode();
            if (iHashCode != 49679502) {
                switch (iHashCode) {
                    case 49679470:
                        b = !networkOperator.equals("46000") ? (byte) -1 : (byte) 0;
                        break;
                    case 49679471:
                        if (networkOperator.equals("46001")) {
                            b = 4;
                            break;
                        }
                        break;
                    case 49679472:
                        if (networkOperator.equals("46002")) {
                            b = 1;
                            break;
                        }
                        break;
                    case 49679473:
                        if (networkOperator.equals("46003")) {
                            b = 7;
                            break;
                        }
                        break;
                    default:
                        switch (iHashCode) {
                            case 49679475:
                                if (networkOperator.equals("46005")) {
                                    b = 8;
                                    break;
                                }
                                break;
                            case 49679476:
                                if (networkOperator.equals("46006")) {
                                    b = 5;
                                    break;
                                }
                                break;
                            case 49679477:
                                if (networkOperator.equals("46007")) {
                                    b = 2;
                                    break;
                                }
                                break;
                            case 49679478:
                                if (networkOperator.equals("46008")) {
                                    b = 3;
                                    break;
                                }
                                break;
                            case 49679479:
                                if (networkOperator.equals("46009")) {
                                    b = 6;
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                }
            } else if (networkOperator.equals("46011")) {
                b = 9;
            }
            switch (b) {
            }
            return 4;
        } catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }

    public static int b(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return i != 10 ? 6 : 5;
        }
        return 3;
    }
}
