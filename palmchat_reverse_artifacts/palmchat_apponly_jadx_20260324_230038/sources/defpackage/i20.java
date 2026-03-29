package defpackage;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgExVo;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.fragment.SimpleChatFragment;
import com.zenmen.palmchat.chat.fragment.c;
import com.zenmen.palmchat.chat.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i20 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<SimpleChatFragment> f18086a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<MessageVo> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageVo messageVo, MessageVo messageVo2) {
            return Long.valueOf(messageVo.get_id()).compareTo(Long.valueOf(messageVo2.get_id()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f18088a;
        public final /* synthetic */ SimpleChatFragment b;

        public b(ArrayList arrayList, SimpleChatFragment simpleChatFragment) {
            this.f18088a = arrayList;
            this.b = simpleChatFragment;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            ArrayList arrayList = this.f18088a;
            if (arrayList != null && arrayList.size() > 0) {
                Intent intent = new Intent(this.b.getActivity(), (Class<?>) SendMessageActivity.class);
                intent.putExtra("message_vo_list", this.f18088a);
                this.b.startActivityForResult(intent, 102);
            } else if (this.b.O0().U()) {
                this.b.O0().F0(false, null);
                this.b.C1();
            }
        }
    }

    public i20(SimpleChatFragment simpleChatFragment) {
        this.f18086a = new WeakReference<>(simpleChatFragment);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
    
        if (r10 != 2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f4, code lost:
    
        if (r10 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f9, code lost:
    
        if (r10 == 10002) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00fe A[SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        boolean z;
        SimpleChatFragment simpleChatFragment = this.f18086a.get();
        if (simpleChatFragment == null || simpleChatFragment.O0() == null) {
            return;
        }
        int i = message.what;
        String string = null;
        if (i == 1000) {
            ArrayList<MessageVo> arrayListG = simpleChatFragment.O0().G();
            String[] strArr = new String[arrayListG.size()];
            Iterator<MessageVo> it = arrayListG.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                strArr[i2] = it.next().mid;
                i2++;
            }
            simpleChatFragment.N0().e(strArr);
            simpleChatFragment.O0().F0(false, null);
            simpleChatFragment.C1();
            return;
        }
        if (i != 1001) {
            if (i == 1002) {
                simpleChatFragment.M0().setVisibility(8);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<MessageVo> arrayListG2 = simpleChatFragment.O0().G();
        Collections.sort(arrayListG2, new a());
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (MessageVo messageVo : arrayListG2) {
            if (c.n(messageVo) || messageVo.attachStatus == 5) {
                z3 = true;
                z = false;
            } else {
                z = true;
            }
            if (a65.e(simpleChatFragment.L0())) {
                int i3 = messageVo.mimeType;
                if (i3 != 1) {
                }
                if (z) {
                    arrayList.add(messageVo);
                }
            } else {
                int i4 = messageVo.mimeType;
                if (i4 == 3 || i4 == 34 || i4 == 37 || ((i4 == 14 && messageVo.data5 != null) || i4 == 9 || i4 == 16 || i4 == 22 || i4 == 17)) {
                    z4 = true;
                } else if (i4 == 28) {
                    RichMsgExVo richMsgExVoH = g.h(messageVo);
                    boolean z5 = richMsgExVoH != null && richMsgExVoH.forwardable == 0;
                    if (!TextUtils.isEmpty(messageVo.extention) && messageVo.extention.equals("message_type_link_illegal")) {
                        z2 = true;
                    }
                }
                if (z) {
                }
            }
            z = false;
            if (z) {
            }
        }
        if (z2) {
            new sd3(simpleChatFragment.getActivity()).j(R.string.string_forward_dialog_illegal).O(R.string.alert_dialog_ok).e().show();
            return;
        }
        if (z3 && z4) {
            string = simpleChatFragment.getResources().getString(R.string.string_forward_dialog_forbid);
        } else if (z3) {
            string = simpleChatFragment.getResources().getString(R.string.downloading_before_forward);
        } else if (z4) {
            string = simpleChatFragment.getResources().getString(R.string.string_forward_dialog_content);
        }
        if (string != null) {
            new sd3(simpleChatFragment.getActivity()).k(string).O(R.string.send).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.dialog_cancel).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).f(new b(arrayList, simpleChatFragment)).e().show();
        } else if (arrayList.size() > 0) {
            Intent intent = new Intent(simpleChatFragment.getActivity(), (Class<?>) SendMessageActivity.class);
            intent.putExtra("message_vo_list", arrayList);
            simpleChatFragment.startActivityForResult(intent, 102);
        }
    }
}
