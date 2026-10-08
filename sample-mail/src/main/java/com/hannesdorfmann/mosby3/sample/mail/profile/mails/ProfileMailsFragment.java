package com.hannesdorfmann.mosby3.sample.mail.profile.mails;

import android.os.Bundle;
import com.hannesdorfmann.mosby3.sample.mail.MailApplication;
import com.hannesdorfmann.mosby3.sample.mail.base.view.BaseMailsFragment;
import com.hannesdorfmann.mosby3.sample.mail.dagger.NavigationModule;
import com.hannesdorfmann.mosby3.sample.mail.model.contact.Person;

/**
 * @author Hannes Dorfmann
 */
public class ProfileMailsFragment extends BaseMailsFragment<ProfileMailsView, ProfileMailsPresenter>
    implements ProfileMailsView {

  private static final String KEY_PERSON = "person";

  Person person;
  ProfileMailsComponent profileMailsComponent;

  public static ProfileMailsFragment newInstance(Person person) {
    ProfileMailsFragment fragment = new ProfileMailsFragment();
    Bundle args = new Bundle();
    args.putParcelable(KEY_PERSON, person);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    person = getArguments().getParcelable(KEY_PERSON);
  }

  @Override public ProfileMailsPresenter createPresenter() {
    return profileMailsComponent.presenter();
  }

  @Override public void loadData(boolean pullToRefresh) {
    presenter.loadMailsSentBy(person, pullToRefresh);
  }

  @Override protected void injectDependencies() {
    profileMailsComponent = DaggerProfileMailsComponent.builder()
        .mailAppComponent(MailApplication.getMailComponents())
        .navigationModule(new NavigationModule())
        .build();

    profileMailsComponent.inject(this);
  }
}
