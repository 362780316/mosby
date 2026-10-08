package com.hannesdorfmann.mosby3.sample.mail.profile.about;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;

import com.hannesdorfmann.mosby3.sample.mail.R;
import com.hannesdorfmann.mosby3.sample.mail.base.view.BaseFragment;
import com.hannesdorfmann.mosby3.sample.mail.model.contact.Person;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Hannes Dorfmann
 */
public class AboutFragment extends BaseFragment {

  private static final String KEY_PERSON = "person";

  Person person;

  @BindView(R.id.email) TextView email;
  @BindView(R.id.birthday) TextView birthday;
  @BindView(R.id.bio) TextView bio;

  @Override protected int getLayoutRes() {
    return R.layout.fragment_about;
  }

  public static AboutFragment newInstance(Person person) {
    AboutFragment fragment = new AboutFragment();
    Bundle args = new Bundle();
    args.putParcelable(KEY_PERSON, person);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    person = getArguments().getParcelable(KEY_PERSON);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());

    if (!TextUtils.isEmpty(person.getEmail())) {
      email.setText(person.getEmail());
    }

    if (person.getBirthday() != null) {
      birthday.setText(sdf.format(person.getBirthday()));
    }

    if (person.getBioRes() != 0) {
      bio.setText(person.getBioRes());
    }
  }
}
