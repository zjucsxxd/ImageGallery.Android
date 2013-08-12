package br.com.infoglobo.example.imagegallery.helpers;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import br.com.infoglobo.example.imagegallery.R;

public class VisibilityAnimationHelper {
	
	Animation fadeOut;
	Animation fadeIn;
	
	public void setVisibilityAnimationInView(Context context, final View view) {
		Animation fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out);
		Animation fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);
		
		fadeOut.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				view.setVisibility(View.GONE);
			}
		});

		fadeIn.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				view.setVisibility(View.VISIBLE);
			}
		});
	}

	public void startFadeInAnimationInView(View view) {
		view.startAnimation(fadeIn);
	}
	
	public void startFadeOutAnimationInView(View view) {
		view.startAnimation(fadeIn);
	}
	
}
