package com.zenmen.palmchat.videocall;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.videocall.c;
import defpackage.ap3;
import defpackage.fu2;
import defpackage.fu5;
import defpackage.zn6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameworkBaseActivity f15856a;
    public ChatItem b;
    public e c;
    public boolean d;
    public boolean e = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f15857a;

        public a(Dialog dialog) {
            this.f15857a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (fu2.e(b.this.f15856a, InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL)) {
                b.this.f(this.f15857a, 0);
            } else {
                ap3.z(AppContext.getContext(), b.this.d ? BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP : "47", "1", "scene_voice_video_call");
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.videocall.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1129b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f15858a;

        public ViewOnClickListenerC1129b(Dialog dialog) {
            this.f15858a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (fu2.e(b.this.f15856a, InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL)) {
                b.this.f(this.f15858a, 1);
            } else {
                ap3.z(AppContext.getContext(), b.this.d ? BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP : "47", "1", "scene_voice_video_call");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f15859a;

        public c(Dialog dialog) {
            this.f15859a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15859a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15860a;

        public d(int i) {
            this.f15860a = i;
        }

        @Override // com.zenmen.palmchat.videocall.c.d
        public void a() {
            b.this.e(this.f15860a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void onItemSelected(int i);
    }

    public b(FrameworkBaseActivity frameworkBaseActivity, ChatItem chatItem, e eVar) {
        this.f15856a = frameworkBaseActivity;
        this.b = chatItem;
        this.c = eVar;
    }

    public final void e(int i) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.onItemSelected(i);
        }
        if (i == 0) {
            BaseActivityPermissionDispatcher.b(this.f15856a, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_VIDEO_CALL);
        } else if (i == 1) {
            BaseActivityPermissionDispatcher.b(this.f15856a, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.CHAT_AUDIO_CALL);
        }
    }

    public final void f(Dialog dialog, int i) {
        com.zenmen.palmchat.videocall.c.b(this.f15856a, i, new d(i));
        dialog.dismiss();
    }

    public void g(boolean z) {
        this.d = z;
    }

    public void h() {
        if (this.f15856a == null || this.b == null) {
            return;
        }
        Dialog dialog = new Dialog(this.f15856a, R.style.VideoCallDialogTheme);
        dialog.setContentView(View.inflate(this.f15856a, R.layout.layout_video_call_dialog, null));
        Window window = dialog.getWindow();
        window.setGravity(80);
        window.setLayout(-1, -2);
        dialog.show();
        dialog.findViewById(R.id.layout_video_call_dialog_video).setOnClickListener(new a(dialog));
        dialog.findViewById(R.id.layout_video_call_dialog_voice).setOnClickListener(new ViewOnClickListenerC1129b(dialog));
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new c(dialog));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fuid", this.b.getChatId());
            String str = DomainHelper.m(this.b).domain;
            jSONObject.put("domain", str);
            int bizType = this.b.getBizType();
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
                jSONObject.put("bizType", bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite);
            } else {
                jSONObject.put("bizType", bizType);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("videochat_popup_view", "view", jSONObject);
    }
}
