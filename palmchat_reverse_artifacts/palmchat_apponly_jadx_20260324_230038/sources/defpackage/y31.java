package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.cell.cellstatus.CellStatusContent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class y31 {
    public static void a(String str) {
        if (str != null) {
            SPUtil.f14322a.t(SPUtil.SCENE.TAB_ENTRANCE_CELL_STATUS, k86.a("key_tab_entrance_appid" + str), "");
        }
    }

    public static CellStatusContent b(String str) {
        CellStatusContent cellStatusContent;
        if (str != null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.TAB_ENTRANCE_CELL_STATUS, k86.a("key_tab_entrance_appid" + str), "");
            if (!TextUtils.isEmpty(strN) && (cellStatusContent = (CellStatusContent) az2.a(strN, CellStatusContent.class)) != null) {
                return cellStatusContent;
            }
        }
        return null;
    }

    public static void c(CellStatusContent cellStatusContent) {
        if (cellStatusContent == null || cellStatusContent.appId == null) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.TAB_ENTRANCE_CELL_STATUS, k86.a("key_tab_entrance_appid" + cellStatusContent.appId), az2.c(cellStatusContent));
        ch.s().u0(cellStatusContent.appId);
    }
}
