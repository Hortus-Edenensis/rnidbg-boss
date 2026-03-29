package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.AdditionItem;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExItemVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.g;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class j84 {
    public static Intent a(Context context, Intent intent, q84[] q84VarArr) {
        if (q84VarArr != null && q84VarArr.length != 0) {
            intent.putExtra("extra_share_type", (byte) 4);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (q84 q84Var : q84VarArr) {
                String strI = q84Var.i();
                byte[] bArrH = q84Var.h();
                Uri uriFromFile = null;
                if (!TextUtils.isEmpty(strI)) {
                    File file = new File(strI);
                    if (pu1.g(strI) == 1) {
                        uriFromFile = Uri.fromFile(file);
                    }
                } else if (bArrH != null && bArrH.length > 0) {
                    uriFromFile = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), BitmapFactory.decodeByteArray(bArrH, 0, bArrH.length), (String) null, (String) null));
                }
                if (uriFromFile != null) {
                    arrayList.add(uriFromFile);
                }
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        }
        return intent;
    }

    public static Intent b(Intent intent, MessageVo messageVo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageVo);
        intent.putExtra("message_vo_list", arrayList);
        return intent;
    }

    public static MessageVo c(r84 r84Var) {
        MessageVo messageVoH = h();
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 13;
        richMsgExItemVo.url = r84Var.m();
        richMsgExItemVo.openLink = r84Var.k();
        richMsgExItemVo.cover = r84Var.j();
        richMsgExItemVo.title = r84Var.l();
        richMsgExItemVo.digest = r84Var.h();
        richMsgExVo.items.add(richMsgExItemVo);
        richMsgExVo.source = i(r84Var);
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVoH.data1 = az2.c(richMsgVo);
        messageVoH.data2 = String.valueOf(2);
        messageVoH.text = g.e(richMsgExItemVo, 2);
        return messageVoH;
    }

    public static MessageVo d(u84 u84Var) {
        MessageVo messageVoH = h();
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 15;
        richMsgExItemVo.url = u84Var.m();
        richMsgExItemVo.openLink = u84Var.k();
        richMsgExItemVo.cover = u84Var.j();
        richMsgExItemVo.title = u84Var.l();
        richMsgExItemVo.digest = u84Var.h();
        richMsgExItemVo.appIcon = u84Var.s();
        richMsgExItemVo.appName = u84Var.t();
        richMsgExVo.items.add(richMsgExItemVo);
        richMsgExVo.source = i(u84Var);
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVoH.data1 = az2.c(richMsgVo);
        messageVoH.data2 = String.valueOf(2);
        messageVoH.text = g.e(richMsgExItemVo, 2);
        return messageVoH;
    }

    public static MessageVo e(v84 v84Var) {
        MessageVo messageVoH = h();
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 14;
        richMsgExItemVo.url = v84Var.n();
        richMsgExItemVo.openLink = v84Var.k();
        richMsgExItemVo.cover = v84Var.j();
        richMsgExItemVo.title = v84Var.m();
        richMsgExItemVo.appName = v84Var.i();
        richMsgExItemVo.appIcon = v84Var.h();
        richMsgExVo.items.add(richMsgExItemVo);
        richMsgExVo.source = i(v84Var);
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVoH.data1 = az2.c(richMsgVo);
        messageVoH.data2 = String.valueOf(2);
        messageVoH.text = g.e(richMsgExItemVo, 2);
        return messageVoH;
    }

    public static Intent f(Intent intent, z84 z84Var) {
        if (z84Var == null) {
            return intent;
        }
        intent.putExtra("extra_share_type", (byte) 1);
        intent.putExtra("android.intent.extra.TEXT", z84Var.i());
        return intent;
    }

    public static MessageVo g(b94 b94Var) {
        MessageVo messageVoH = h();
        RichMsgExVo richMsgExVo = new RichMsgExVo();
        richMsgExVo.items = new ArrayList<>();
        RichMsgExItemVo richMsgExItemVo = new RichMsgExItemVo();
        richMsgExItemVo.showType = 12;
        richMsgExItemVo.url = b94Var.m();
        richMsgExItemVo.openLink = b94Var.k();
        richMsgExItemVo.cover = b94Var.j();
        richMsgExItemVo.title = b94Var.l();
        richMsgExItemVo.digest = b94Var.h();
        richMsgExVo.items.add(richMsgExItemVo);
        richMsgExVo.source = i(b94Var);
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.appMsg = richMsgExVo;
        messageVoH.data1 = az2.c(richMsgVo);
        messageVoH.data2 = String.valueOf(2);
        messageVoH.text = g.e(richMsgExItemVo, 2);
        return messageVoH;
    }

    public static MessageVo h() {
        MessageVo messageVo = new MessageVo();
        messageVo.mid = xn3.a();
        messageVo.time = ir5.b();
        messageVo.from = AccountUtils.p(AppContext.getContext());
        messageVo.mimeType = 28;
        messageVo.isRead = true;
        messageVo.isSend = true;
        messageVo.status = 1;
        messageVo.sendFlag = String.valueOf(0);
        messageVo.attachStatus = 2;
        return messageVo;
    }

    public static AdditionItem i(i84 i84Var) {
        AdditionItem additionItem = new AdditionItem();
        additionItem.icon = i84Var.b();
        additionItem.name = i84Var.c();
        return additionItem;
    }
}
