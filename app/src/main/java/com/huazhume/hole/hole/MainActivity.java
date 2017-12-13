package com.huazhume.hole.hole;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.huazhume.hole.hole.main.HLBookMarkFragment;
import com.huazhume.hole.hole.main.home.HLHomeFragment;
import com.huazhume.hole.hole.main.HLMeFragment;
import com.huazhume.hole.hole.main.HLMessageFragment;
import com.huazhume.hole.hole.main.HLNoteFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private static final String STRING_MAIN_HOME = "main_home";
    private static final String STRING_MAIN_BOOKMARK = "main_bookmark";
    private static final String STRING_MAIN_NOTE = "main_note";
    private static final String STRING_MAIN_MESSAGE = "main_message";
    private static final String STRING_MAIN_ME = "main_me";

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private HLHomeFragment homeFragment;
    private HLNoteFragment noteFragment;
    private HLBookMarkFragment bookMarkFragment;
    private HLMessageFragment messageFragment;
    private HLMeFragment meFragment;

    private LinearLayout linearLayout_mainContent;

    private RelativeLayout relativeLayout_home;
    private RelativeLayout relativeLayout_bookMark;
    private RelativeLayout relativeLayout_note;
    private RelativeLayout relativeLayout_message;
    private RelativeLayout relativeLayout_me;

    private ImageView imageView_home;
    private ImageView imageView_bookmark;
    private ImageView imageView_note;
    private ImageView imageView_message;
    private ImageView imageView_me;
    private ArrayList <Map <String, Object> > bottomImageViewArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configBottomBar();
        configFragment();
    }

    private void configFragment() {

        fragmentManager = this.getSupportFragmentManager();
        homeFragment = new HLHomeFragment();
        bookMarkFragment = new HLBookMarkFragment();
        noteFragment = new HLNoteFragment();
        messageFragment = new HLMessageFragment();
        meFragment = new HLMeFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.linearlayout_maincontent, bookMarkFragment, STRING_MAIN_BOOKMARK);
        transaction.replace(R.id.linearlayout_maincontent, noteFragment, STRING_MAIN_NOTE);
        transaction.replace(R.id.linearlayout_maincontent, messageFragment, STRING_MAIN_MESSAGE);
        transaction.replace(R.id.linearlayout_maincontent, meFragment, STRING_MAIN_ME);
        transaction.replace(R.id.linearlayout_maincontent, homeFragment, STRING_MAIN_HOME);
        transaction.commit();

        linearLayout_mainContent = this.findViewById(R.id.linearlayout_maincontent);

    }

    private void configBottomBar() {

        relativeLayout_home = this.findViewById(R.id.relativelayout_home);
        relativeLayout_bookMark = this.findViewById(R.id.relativelayout_bookmark);
        relativeLayout_note = this.findViewById(R.id.relativelayout_note);
        relativeLayout_message = this.findViewById(R.id.relativelayout_message);
        relativeLayout_me = this.findViewById(R.id.relativelayout_me);

        imageView_home = this.findViewById(R.id.imageview_bottom_home);
        imageView_bookmark = this.findViewById(R.id.imageview_bottom_bookmark);
        imageView_note = this.findViewById(R.id.imageview_bottom_note);
        imageView_message = this.findViewById(R.id.imageview_bottom_message);
        imageView_me = this.findViewById(R.id.imageview_bottom_me);

        bottomImageViewArray = new ArrayList<>();
        HashMap homeMap = new HashMap();
        homeMap.put("imageView", imageView_home);
        homeMap.put("normal", R.mipmap.home_stroked_home_normal);
        homeMap.put("selected", R.mipmap.home_stroked_home_selected);

        HashMap bookmarkMap = new HashMap();
        bookmarkMap.put("imageView", imageView_bookmark);
        bookmarkMap.put("normal", R.mipmap.home_stroked_bookmark_normal);
        bookmarkMap.put("selected", R.mipmap.home_stroked_bookmark_selected);

        HashMap noteMap = new HashMap();
        noteMap.put("imageView", imageView_note);
        noteMap.put("normal", R.mipmap.home_stroked_write_normal);
        noteMap.put("selected", R.mipmap.home_stroked_write_selected);

        HashMap messageMap = new HashMap();
        messageMap.put("imageView", imageView_message);
        messageMap.put("normal", R.mipmap.home_stroked_notifications_normal);
        messageMap.put("selected", R.mipmap.home_stroked_notifications_selected);

        HashMap meMap = new HashMap();
        meMap.put("imageView", imageView_me);
        meMap.put("normal", R.mipmap.home_stroked_profile_normal);
        meMap.put("selected", R.mipmap.home_stroked_profile_selected);

        bottomImageViewArray.add(homeMap);
        bottomImageViewArray.add(bookmarkMap);
        bottomImageViewArray.add(noteMap);
        bottomImageViewArray.add(messageMap);
        bottomImageViewArray.add(meMap);

        relativeLayout_home.setOnClickListener(this);
        relativeLayout_bookMark.setOnClickListener(this);
        relativeLayout_note.setOnClickListener(this);
        relativeLayout_message.setOnClickListener(this);
        relativeLayout_me.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relativelayout_home:
                addToBackStack(homeFragment);
                break;
            case R.id.relativelayout_bookmark:
                addToBackStack(bookMarkFragment);
                break;
            case R.id.relativelayout_note:
                addToBackStack(noteFragment);
                break;
            case R.id.relativelayout_message:
                addToBackStack(messageFragment);
                break;
            case R.id.relativelayout_me:
                addToBackStack(meFragment);
                break;
        }
        changeBottomBarStatus(view.getId());
    }

    private void addToBackStack(Fragment fragment) {
        String fragmentTagString = null;
        if (fragment instanceof HLHomeFragment) {
            fragmentTagString = STRING_MAIN_HOME;
        } else if (fragment instanceof HLBookMarkFragment) {
            fragmentTagString = STRING_MAIN_BOOKMARK;
        } else if (fragment instanceof HLNoteFragment) {
            fragmentTagString = STRING_MAIN_NOTE;
        } else if (fragment instanceof HLMessageFragment) {
            fragmentTagString = STRING_MAIN_MESSAGE;
        } else {
            fragmentTagString = STRING_MAIN_ME;
        }
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.linearlayout_maincontent, fragment, fragmentTagString);
        transaction.commit();

    }
    private void changeBottomBarStatus(int viewId) {
        int index = 0;
        switch (viewId) {
            case R.id.relativelayout_home:
                index = 0;
                break;
            case R.id.relativelayout_bookmark:
                index = 1;
                break;
            case R.id.relativelayout_note:
                index = 2;
                break;
            case R.id.relativelayout_message:
                index = 3;
                break;
            case R.id.relativelayout_me:
                index = 4;
                break;
        }
        for (int i = 0; i < bottomImageViewArray.size(); i++) {
            Map map = bottomImageViewArray.get(i);
            ImageView imageView = (ImageView) map.get("imageView");
            if (i == index) {
                imageView.setImageResource((int)map.get("selected"));
            } else {
                imageView.setImageResource((int)map.get("normal"));
            }
        }

    }
}
