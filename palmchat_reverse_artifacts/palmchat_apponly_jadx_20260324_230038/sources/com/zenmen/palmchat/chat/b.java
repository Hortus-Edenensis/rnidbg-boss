package com.zenmen.palmchat.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.InputItemManager;
import com.zenmen.palmchat.update.AppInfo;
import com.zenmen.palmchat.widget.horizontalgridpager.PageGridAdapter;
import defpackage.nl0;
import defpackage.nx3;
import defpackage.qb4;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b implements qb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12746a;
    public PageGridAdapter<InputItemManager.InputItemType> b = new PageGridAdapter<>(this);
    public InterfaceC0976b c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.ViewHolder {
        public ImageView d;
        public TextView e;
        public TextView f;
        public ImageView g;

        public a(View view) {
            super(view);
            this.d = (ImageView) view.findViewById(R.id.grid_item_image);
            this.e = (TextView) view.findViewById(R.id.grid_item_text);
            this.f = (TextView) view.findViewById(R.id.red_text);
            this.g = (ImageView) view.findViewById(R.id.red_dot);
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0976b {
        void a(View view, int i);
    }

    public b(Context context, com.zenmen.palmchat.widget.horizontalgridpager.a aVar) {
        this.f12746a = context;
        ArrayList<InputItemManager.InputItemType> arrayList = new ArrayList<>();
        int iD = InputItemManager.d();
        for (int i = 0; i < iD; i++) {
            arrayList.add(InputItemManager.e(i));
        }
        this.b.d(aVar);
        this.b.e(arrayList);
    }

    @Override // defpackage.qb4
    public RecyclerView.ViewHolder a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_input_method_grid_item, viewGroup, false));
    }

    @Override // defpackage.qb4
    public void c(RecyclerView.ViewHolder viewHolder, int i) {
        InputItemManager.InputItemType inputItemType = this.b.c().get(i);
        a aVar = (a) viewHolder;
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_IMAGE) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_image);
            aVar.e.setText(R.string.input_fragment_grid_item_tupian);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_FILE) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_file);
            aVar.e.setText(R.string.input_fragment_grid_item_wenjian);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_LOCATION) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_location);
            aVar.e.setText(R.string.input_fragment_grid_item_weizhi);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_vcard);
            aVar.e.setText(R.string.input_fragment_grid_item_mingpian);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_BIG_TEXT) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_bigtext);
            aVar.e.setText(R.string.bittext_title);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_sight);
            aVar.e.setText(R.string.input_fragment_grid_item_sight);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_camera);
            aVar.e.setText(R.string.input_fragment_grid_item_camera);
            aVar.f.setVisibility(8);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_video_call);
            aVar.e.setText(R.string.input_fragment_grid_item_video_call);
            aVar.f.setVisibility(8);
            aVar.g.setImageResource(R.drawable.ic_vip);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_group_voice_call);
            aVar.e.setText(R.string.dialog_item_audio_call);
            aVar.f.setVisibility(8);
            aVar.g.setImageResource(R.drawable.ic_vip);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_red_packet);
            aVar.e.setText(R.string.text_redpacket);
            aVar.g.setImageResource(R.drawable.ic_free);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_TRANSFER) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_transfer);
            aVar.e.setText(R.string.text_transfer);
            aVar.g.setImageResource(R.drawable.ic_free);
        } else if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
            aVar.d.setImageResource(R.drawable.selector_icon_input_voucher_red_packet);
            aVar.e.setText("劵红包");
            aVar.f.setVisibility(8);
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_NAME_CARD) {
            if (nx3.a("key_name_card")) {
                aVar.g.setVisibility(0);
                return;
            } else {
                aVar.g.setVisibility(8);
                return;
            }
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_SIGHT) {
            if (nx3.a("key_small_video")) {
                aVar.g.setVisibility(0);
                return;
            } else {
                aVar.g.setVisibility(8);
                return;
            }
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_CAMERA) {
            if (nx3.a("key_new_camera")) {
                aVar.g.setVisibility(0);
                return;
            } else {
                aVar.g.setVisibility(8);
                return;
            }
        }
        if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_REDPACKET) {
            aVar.g.setVisibility(8);
            aVar.f.setVisibility(8);
            return;
        }
        if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_VIDEO_CALL) {
            if (inputItemType == InputItemManager.InputItemType.INPUT_ITEM_GROUP_VOICE_CALL) {
                if (nx3.a("key_new_group_voice_call")) {
                    aVar.g.setVisibility(0);
                    return;
                } else {
                    aVar.g.setVisibility(0);
                    return;
                }
            }
            if (inputItemType != InputItemManager.InputItemType.INPUT_ITEM_VOUCHER) {
                aVar.g.setVisibility(8);
                return;
            } else if (nx3.a("key_show_voucher_red_packet")) {
                aVar.g.setVisibility(0);
                return;
            } else {
                aVar.g.setVisibility(8);
                return;
            }
        }
        aVar.g.setVisibility(0);
        if (nl0.g()) {
            if (nx3.a("key_video_call") && com.zenmen.palmchat.videocall.c.e()) {
                aVar.g.setVisibility(0);
                return;
            }
            return;
        }
        String versionName = AppInfo.getVersionName(this.f12746a);
        if ((versionName.startsWith("2.0.2") || versionName.startsWith("2.0.3") || versionName.startsWith("2.0.4")) && nx3.a("key_video_call")) {
            aVar.g.setVisibility(0);
        }
    }

    @Override // defpackage.qb4
    public void d(View view, int i) {
        InterfaceC0976b interfaceC0976b = this.c;
        if (interfaceC0976b != null) {
            interfaceC0976b.a(view, i);
        }
    }

    public PageGridAdapter<InputItemManager.InputItemType> e() {
        return this.b;
    }

    public InputItemManager.InputItemType f(int i) {
        return this.b.c().get(i);
    }

    public void g() {
        this.b.notifyDataSetChanged();
    }

    public void h(InterfaceC0976b interfaceC0976b) {
        this.c = interfaceC0976b;
    }

    public void i() {
        if (this.b != null) {
            ArrayList<InputItemManager.InputItemType> arrayList = new ArrayList<>();
            int iD = InputItemManager.d();
            for (int i = 0; i < iD; i++) {
                arrayList.add(InputItemManager.e(i));
            }
            this.b.e(arrayList);
        }
    }

    @Override // defpackage.qb4
    public void b(View view, int i) {
    }
}
