package zijing.com.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zijing.com.databindingtest.databinding.ActivityRecyclerviewBinding;
import zijing.com.databindingtest.databinding.LayoutFooterBinding;

/**
 * Created by zijing on 16/7/18.
 *
 */
public class RecyclerViewActiivity extends AppCompatActivity {

    ArrayList<UserModel> listData = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int start = (int) (Math.random() * 15);
        for (int i=0; i<15; ++i) {
            listData.add(new UserModel("" + (i+start), "" + (i+start)));
        }

        ActivityRecyclerviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        binding.setHandler(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyAdapter(listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public static class BindingViewHolder extends RecyclerView.ViewHolder {

        LayoutFooterBinding binding;

        public BindingViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LayoutFooterBinding getBinding() {
            return binding;
        }
    }

    public static class MyAdapter extends RecyclerView.Adapter<BindingViewHolder> {

        private ArrayList<UserModel> userList;

        public MyAdapter(ArrayList<UserModel> _userList) {
            userList = _userList;
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_footer, parent, false);
            return new BindingViewHolder(v);
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            final UserModel user = userList.get(position);
            holder.getBinding().setUser(user);
            holder.getBinding().executePendingBindings();
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

    public void changeFistColumnData(View view) {
        listData.get(0).setFirstName("c " + (int) (Math.random() * 10));
        adapter.notifyDataSetChanged();
    }
}
