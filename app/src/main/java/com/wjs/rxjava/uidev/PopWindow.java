package com.wjs.rxjava.uidev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PopWindow {
    ListView mListView;
    class Adapter extends BaseAdapter {
        private RadioButton selectView;
        private List<String> mList;
        private Context mContext;
        private LayoutInflater mInflater;
        public Adapter(Context context,List<String> mList){
            this.mList=mList;
            mContext=context;
            mInflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return mList==null?0:mList.size();
        }

        @Override
        public Object getItem(int i) {
            return mList==null?null:mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        public void selectPosition(int position,RadioButton currentSelectView){
            if(selectView!=null){
                selectView.setChecked(false);
            }
            this.selectView=currentSelectView;
            selectView.setChecked(true);
        }
        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            Holder mHolder;
            if(view==null){
                view=mInflater.inflate(R.layout.popup_group_list_item,viewGroup,false);
                mHolder=new Holder();
                mHolder.findView(view);
                view.setTag(mHolder);
            }
            mHolder= (Holder) view.getTag();
            mHolder.mText.setText(mList.get(i));
            return view;
        }
    }
    class Holder{
        private TextView mText;
        private RadioButton mRB;
        public void findView(View view){
            mText=view.findViewById(R.id.mText);
            mRB=view.findViewById(R.id.mRB);
        }
    }
    public void showPopup(View view){
        mListView=view.findViewById(R.id.mListView);
        List<String> list=new ArrayList<String>();
        list.add("全部");
        list.add("初诊患者");
        list.add("复诊患者");
        list.add("已拉黑");
        list.add("新建分组");
        mListView.setAdapter(new Adapter(view.getContext(),list));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter= (Adapter) adapterView.getAdapter();
                adapter.selectPosition(i,(RadioButton) view.findViewById(R.id.mRB));
            }
        });
    }
}
