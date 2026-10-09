package com.hannesdorfmann.mosby3.mvp.delegate;

import androidx.fragment.app.FragmentActivity;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Hannes Dorfmann
 */
public class FragmentMvpDelegateUiLessMvpFragmentTest {

  public static class UiLessFragment extends MvpFragment<MvpView, MvpPresenter<MvpView>> {

    @Override public MvpPresenter<MvpView> createPresenter() {
      return new MvpBasePresenter<MvpView>();
    }
  }

  public static class CorrectUiFragment extends MvpFragment<MvpView, MvpPresenter<MvpView>> {

    @Override public MvpPresenter<MvpView> createPresenter() {
      return new MvpBasePresenter<MvpView>();
    }
  }

  @Test() public void uiLessShouldFail() {
    try {
      startFragment(new UiLessFragment(), false);
      Assert.fail("Exception expected");
    } catch (IllegalStateException e) {
      Assert.assertEquals(
          "It seems that you are using " + UiLessFragment.class.getCanonicalName() + " as headless (UI less) fragment (because onViewCreated() has not been called or maybe delegation misses that part). Having a Presenter without a View (UI) doesn't make sense. Simply use an usual fragment instead of an MvpFragment if you want to use a UI less Fragment",
          e.getMessage());
    }
  }

  @Test public void correctUi() {
    startFragment(new CorrectUiFragment(), true);
  }

  private static void startFragment(
      MvpFragment<MvpView, MvpPresenter<MvpView>> fragment, boolean withView) {
    FragmentMvpDelegateImpl<MvpView, MvpPresenter<MvpView>> delegate =
        new FragmentMvpDelegateImpl<MvpView, MvpPresenter<MvpView>>(fragment, fragment, false, false);
    delegate.onAttach(Mockito.mock(FragmentActivity.class));
    delegate.onCreate(null);
    if (withView) {
      delegate.onViewCreated(null, null);
    }
    delegate.onStart();
  }
}
