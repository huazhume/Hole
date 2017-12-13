package com.huazhume.hole.hole.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhume.hole.hole.R;

/**
 * Created by xiaobaizhang on 2017/12/8.
 */

public class HLBookMarkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookmark,null);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.getView().setBackgroundColor(Color.BLUE);
    }
}
