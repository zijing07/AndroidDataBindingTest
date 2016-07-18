package zijing.com.databindingtest;

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

import zijing.com.databindingtest.databinding.ActivityListviewBinding;
import zijing.com.databindingtest.databinding.LayoutFooterBinding;

/**
 * Created by zijing on 16/7/18.
 */
public class ListViewActiivity extends AppCompatActivity {

    ArrayList<BindingStuff.User> listData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int start = (int) (Math.random() * 15);
        for (int i=0; i<15; ++i) {
            listData.add(new BindingStuff.User("" + (i+start), "" + (i+start)));
        }

        ActivityListviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_listview);
        binding.setHandler(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(listData));
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

        private ArrayList<BindingStuff.User> userList;

        public MyAdapter(ArrayList<BindingStuff.User> _userList) {
            userList = _userList;
        }

        @Override
        public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_footer, parent, false);
            return new BindingViewHolder(v);
        }

        @Override
        public void onBindViewHolder(BindingViewHolder holder, int position) {
            final BindingStuff.User user = userList.get(position);
            holder.getBinding().setUser(user);
            holder.getBinding().executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

    public void changeFistColumnData(View view) {
        listData.get(0).firstName.set("c " + (int) (Math.random() * 10));
    }
}
