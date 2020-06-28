package com.example.B10602137_HW1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private boolean[] check = new boolean[100];

    //RecyclerView會呼叫這個方法，建立ViewHolder物件然後回傳
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        ViewHolder myViewHolder = holder;
        myViewHolder.mCheckBox.setText(mData.get(position));
        myViewHolder.mCheckBox.setOnCheckedChangeListener(null);//先設定一次CheckBox的選中監聽器，傳入引數null
        myViewHolder.mCheckBox.setChecked(check[position]);
        myViewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check[position] = isChecked;

            }
        });
    }

    @Override
    public int getItemCount() {
        mData = new ArrayList<>();
        String s = "";
        for(int i=0;i<100;i++){
            s = "第" + i + "項";
            mData.add(s);
        }
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mCheckBox;
        //建構式
        public ViewHolder(View itemView){
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.chk);
            mCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mCheckBox.isChecked()) {
                        MainActivity.num += 1;
                        System.out.println(MainActivity.num);
                    } else {
                        MainActivity.num -= 1;
                        System.out.println(MainActivity.num);
                    }
                }
            });
        }
    }

}
