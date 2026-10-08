package com.astuetz;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;

public class PagerSlidingTabStrip extends HorizontalScrollView {

  private ViewPager viewPager;

  public PagerSlidingTabStrip(Context context) {
    super(context);
  }

  public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setViewPager(ViewPager viewPager) {
    this.viewPager = viewPager;
  }

  public ViewPager getViewPager() {
    return viewPager;
  }
}
