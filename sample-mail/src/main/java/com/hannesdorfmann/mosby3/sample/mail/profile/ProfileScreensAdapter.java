package com.hannesdorfmann.mosby3.sample.mail.profile;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.hannesdorfmann.mosby3.sample.mail.model.contact.Person;
import com.hannesdorfmann.mosby3.sample.mail.model.contact.ProfileScreen;
import com.hannesdorfmann.mosby3.sample.mail.profile.about.AboutFragment;
import com.hannesdorfmann.mosby3.sample.mail.profile.mails.ProfileMailsFragment;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public class ProfileScreensAdapter extends FragmentPagerAdapter {

  private List<ProfileScreen> screens;
  private Person person;

  public ProfileScreensAdapter(FragmentManager fm, Person person) {
    super(fm);
    this.person = person;
  }

  public List<ProfileScreen> getScreens() {
    return screens;
  }

  public void setScreens(List<ProfileScreen> screens) {
    this.screens = screens;
  }

  @Override public Fragment getItem(int position) {

    ProfileScreen screen = screens.get(position);
    if (screen.getType() == ProfileScreen.TYPE_MAILS) {
      return ProfileMailsFragment.newInstance(person);
    }
    if (screen.getType() == ProfileScreen.TYPE_ABOUT) {
      return AboutFragment.newInstance(person);
    }

    throw new RuntimeException("Unknown Profile Screen (no fragment associated with this type");
  }

  @Override public int getCount() {

    return screens == null ? 0 : screens.size();
  }

  @Override public CharSequence getPageTitle(int position) {
    return screens.get(position).getName();
  }
}
