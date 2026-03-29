package defpackage;

import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.maintab.cell.cellstatus.CellStatus;
import com.zenmen.palmchat.maintab.cell.cellstatus.CellStatusContent;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ps5 extends a41 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message.getType() == 400 && fu5.o(message) == 1;
    }

    @Override // defpackage.a41, defpackage.wk2
    public boolean b() {
        return false;
    }

    public final CellStatusContent c(String str) {
        RichMsgVo richMsgVo;
        CellStatus cellStatus;
        CellStatusContent cellStatusContent;
        if (str == null || (richMsgVo = (RichMsgVo) az2.a(str, RichMsgVo.class)) == null || (cellStatus = richMsgVo.cellStatus) == null || (cellStatusContent = cellStatus.content) == null || cellStatusContent.appId == null) {
            return null;
        }
        return cellStatusContent;
    }

    @Override // defpackage.a41, defpackage.ln2
    public void d(MessageProto.Message message) {
        LogUtil.i("TabEntranceUnreadCmdProcessor", "msgext = " + message.getExtension());
        y31.c(c(message.getExtension()));
    }

    @Override // defpackage.a41, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        if (arrayList.size() > 0) {
            HashMap map = new HashMap();
            Iterator<MessageProto.Message> it = arrayList.iterator();
            while (it.hasNext()) {
                CellStatusContent cellStatusContentC = c(it.next().getExtension());
                if (cellStatusContentC != null) {
                    map.put(cellStatusContentC.appId, cellStatusContentC);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                CellStatusContent cellStatusContent = (CellStatusContent) entry.getValue();
                if (str != null && cellStatusContent != null) {
                    y31.c(cellStatusContent);
                }
            }
        }
    }
}
