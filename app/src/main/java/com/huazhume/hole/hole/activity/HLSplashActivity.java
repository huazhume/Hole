package com.huazhume.hole.hole.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhume.hole.hole.MainActivity;
import com.huazhume.hole.hole.R;

/**
 * Created by xiaobaizhang on 2017/12/12.
 */

public class HLSplashActivity extends FragmentActivity{

    private TextView textView;
    private ImageView imageView;
    private Integer animationCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initBaseViews();

        setAlphaAnimations(1.0f, 0.2f);
    }

    private void initBaseViews() {

        this.textView = this.findViewById(R.id.textview_splash_title);
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/noe_display_medium.otf");
        this.textView.setTypeface(textFont);

        this.imageView = this.findViewById(R.id.imageview_splash_content);
    }

    private void setAlphaAnimations(final float fromAlpha, final float toAlpha) {

        final AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animationCount ++;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (animationCount > 2) {
                    startActivity(new Intent(HLSplashActivity.this, MainActivity.class));
                    HLSplashActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    HLSplashActivity.this.finish();
                    return;
                }
                setAlphaAnimations(toAlpha, fromAlpha);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(alphaAnimation);
    }
}
