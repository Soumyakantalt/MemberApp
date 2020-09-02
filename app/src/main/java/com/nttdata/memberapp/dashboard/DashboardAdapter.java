package com.nttdata.memberapp.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.nttdata.memberapp.R;
import com.nttdata.memberapp.model.Member;

public class DashboardAdapter extends ListAdapter<Member, DashboardAdapter.ViewHolder> {

    Context context;

    public DashboardAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private static final DiffUtil.ItemCallback<Member> DIFF_CALLBACK = new DiffUtil.ItemCallback<Member>() {

        @Override
        public boolean areItemsTheSame(Member oldItem, Member newItem) {
            return oldItem.getName().equalsIgnoreCase(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(Member oldItem, Member newItem) {
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getPhoneNumber().equalsIgnoreCase(newItem.getPhoneNumber());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(getItem(position).getName());
        holder.gender.setText(getItem(position).getGender());
        holder.phoneNumber.setText(getItem(position).getPhoneNumber());
        holder.mail.setText(getItem(position).getEmail());

        holder.consiraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You have clicked on" + " " + getItem(position).getName() + " " + "record", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, gender, phoneNumber, mail;
        ConstraintLayout consiraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name_tv);
            gender = itemView.findViewById(R.id.item_gender_tv);
            phoneNumber = itemView.findViewById(R.id.item_phone_tv);
            mail = itemView.findViewById(R.id.item_mail_tv);
            consiraintLayout = itemView.findViewById(R.id.consiraint_layout);
        }
    }
}