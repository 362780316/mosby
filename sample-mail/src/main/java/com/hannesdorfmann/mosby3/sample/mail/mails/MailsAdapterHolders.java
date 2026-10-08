package com.hannesdorfmann.mosby3.sample.mail.mails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hannesdorfmann.mosby3.sample.mail.R;
import com.hannesdorfmann.mosby3.sample.mail.ui.view.StarView;

public final class MailsAdapterHolders {

  private MailsAdapterHolders() {
  }

  public static class MailViewHolder extends RecyclerView.ViewHolder {
    public final ImageView senderPic;
    public final TextView subject;
    public final TextView message;
    public final TextView date;
    public final StarView star;

    public MailViewHolder(View itemView) {
      super(itemView);
      senderPic = (ImageView) itemView.findViewById(R.id.senderPic);
      subject = (TextView) itemView.findViewById(R.id.subject);
      message = (TextView) itemView.findViewById(R.id.message);
      date = (TextView) itemView.findViewById(R.id.date);
      star = (StarView) itemView.findViewById(R.id.starButton);
    }
  }
}
