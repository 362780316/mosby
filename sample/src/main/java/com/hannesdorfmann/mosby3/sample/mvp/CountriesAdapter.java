/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hannesdorfmann.mosby3.sample.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.R;
import com.hannesdorfmann.mosby3.sample.mvp.model.Country;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {

  private final LayoutInflater inflater;
  private List<Country> countries;

  public CountriesAdapter(Context context) {
    inflater = LayoutInflater.from(context);
  }

  public void setCountries(List<Country> countries) {
    this.countries = countries;
  }

  public List<Country> getCountries() {
    return countries;
  }

  @Override public int getItemCount() {
    return countries == null ? 0 : countries.size();
  }

  @Override public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.row_text, parent, false);
    return new CountryViewHolder(view);
  }

  @Override public void onBindViewHolder(CountryViewHolder holder, int position) {
    holder.name.setText(countries.get(position).getName());
  }

  static class CountryViewHolder extends RecyclerView.ViewHolder {
    final TextView name;

    CountryViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.textView);
    }
  }
}


