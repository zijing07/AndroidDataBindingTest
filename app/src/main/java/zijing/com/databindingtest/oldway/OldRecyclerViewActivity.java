package zijing.com.databindingtest.oldway;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import zijing.com.databindingtest.R;

/**
 * Created by zijing on 16/7/18.
 *
 */
public class OldRecyclerViewActivity extends AppCompatActivity {

    ArrayList<UserModel> listData = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter adapter;
    Button changeText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_recyclerview);

        int start = (int) (Math.random() * 15);
        for (int i=0; i<15; ++i) {
            listData.add(new UserModel("" + (i+start), "" + (i+start)));
        }

        recyclerView = (RecyclerView) findViewById(R.id.old_activity_recyclerview_recyclerview);
        adapter = new MyAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        changeText = (Button) findViewById(R.id.old_acitivity_recyclerview_btn_changedata);
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFistColumnData();
            }
        });
    }

    public static class BindingViewHolder extends RecyclerView.ViewHolder {

        TextView textViewFirstName;
        TextView textViewLastName;

        public BindingViewHolder(View itemView) {
            super(itemView);
            textViewFirstName = (TextView) itemView.findViewById(R.id.layout_footer_tv_firstname);
            textViewLastName = (TextView) itemView.findViewById(R.id.layout_footer_tv_lastname);
        }
    }

    public static class MyAdapter extends RecyclerView.Adapter<BindingViewHolder> {

        private ArrayList<UserModel> userList;

        public MyAdapter(ArrayList<UserModel> _userList) {
            userList = _userList;
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.old_layout_footer, parent, false);
            return new BindingViewHolder(v);
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            final UserModel user = userList.get(position);
            holder.textViewLastName.setText(user.getLastName());
            holder.textViewFirstName.setText(user.getFirstName());
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

    public static class UserModel extends BaseObservable {
        private String lastName;
        private String firstName;

        public UserModel(String fn, String ln) {
            firstName = fn;
            lastName = ln;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
            notifyPropertyChanged(zijing.com.databindingtest.BR.user);
        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
            notifyPropertyChanged(zijing.com.databindingtest.BR.user);
        }
    }

    public void changeFistColumnData() {
        listData.get(0).setFirstName("c " + (int) (Math.random() * 10));
        adapter.notifyDataSetChanged();
    }
}
