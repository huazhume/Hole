package com.huazhume.hole.hole.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.huazhume.hole.hole.R;
import com.huazhume.hole.hole.main.base.HLBaseFragment;
import com.huazhume.hole.hole.main.home.adapter.HLHomeAdapter;

/**
 * Created by xiaobaizhang on 2017/12/8.
 */

public class HLHomeFragment extends HLBaseFragment {

    private ListView listView;
    private HLHomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home , null);
    }

    @Override
    public void onResume() {
        super.onResume();
        initBaseViews();
    }

    private void initBaseViews() {
        listView = this.getView().findViewById(R.id.listview_main_home);
        homeAdapter = new HLHomeAdapter(this.getContext());
        listView.setAdapter(homeAdapter);
    }

}
