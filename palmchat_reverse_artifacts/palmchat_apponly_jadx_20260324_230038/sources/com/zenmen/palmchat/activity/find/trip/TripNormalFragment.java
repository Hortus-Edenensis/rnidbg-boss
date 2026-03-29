package com.zenmen.palmchat.activity.find.trip;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.R;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TripNormalFragment extends Fragment {
    public View d = null;
    public View e = null;
    public List<LoadCountBean.MarkerBean> f = null;
    public Activity g = null;
    public String h = null;
    public FindTripNearbyRecycleView i = null;

    public void D(LoadCountBean.MarkerBean markerBean) {
        FindTripNearbyRecycleView findTripNearbyRecycleView;
        if (markerBean == null || (findTripNearbyRecycleView = this.i) == null) {
            return;
        }
        findTripNearbyRecycleView.addNewData(markerBean);
        View view = this.d;
        if (view == null || this.e == null) {
            return;
        }
        view.setVisibility(8);
        this.e.setVisibility(0);
    }

    public final void E(View view) {
        this.d = view.findViewById(R.id.trip_map_nearby_data_normal_error_layout);
        this.e = view.findViewById(R.id.trip_map_nearby_data_normal_success_layout);
        List<LoadCountBean.MarkerBean> list = this.f;
        if (list == null || list.size() == 0) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
        }
        FindTripNearbyRecycleView findTripNearbyRecycleView = (FindTripNearbyRecycleView) view.findViewById(R.id.trip_map_nearby_data_normal_recycle);
        this.i = findTripNearbyRecycleView;
        findTripNearbyRecycleView.setData(this.f, this.h, "normalTag", this.g);
    }

    public void F(List<LoadCountBean.MarkerBean> list, Activity activity, String str) {
        this.f = list;
        this.g = activity;
        this.h = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_map_trip_nearby_fragment_normal, viewGroup, false);
        E(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FindTripNearbyRecycleView findTripNearbyRecycleView = this.i;
        if (findTripNearbyRecycleView != null) {
            findTripNearbyRecycleView.onDestroy();
        }
        List<LoadCountBean.MarkerBean> list = this.f;
        if (list != null) {
            list.clear();
        }
        this.g = null;
    }
}
