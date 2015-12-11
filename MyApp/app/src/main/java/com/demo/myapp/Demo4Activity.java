package com.demo.myapp;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Demo4Activity extends ExpandableListActivity {

    List<String> group;
    List<List<String>> child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        initData();
        getExpandableListView().setAdapter(new MyAdapter());
        getExpandableListView().setGroupIndicator(null);
        getExpandableListView().setCacheColorHint(0);  //设置拖动列表的时候防止出现黑色背景
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(Demo4Activity.this, "第" + groupPosition + "行" + "第" + childPosition + "列", Toast.LENGTH_SHORT).show();
                switch (groupPosition) {
                    case 0:

                        break;
                    case 1:
                        switch (childPosition) {
                            case 1:
                                Intent intent = new Intent(Demo4Activity.this, Deom4SkipToActivity.class);
                                startActivity(intent);
                                break;
                        }
                        break;
                    default:
                        break;
                }

//                if (groupPosition == 1) {
//                    if (childPosition == 1) {
//
//
//                    }
//                }
                return true;
            }
        });

    }

    private void initData() {
        group = new ArrayList<>();
        child = new ArrayList<>();
        addInfo("小米", new String[]{"male", "138123***", "GuangZhou"});
        addInfo("小张", new String[]{"female", "138123***", "GuangZhou"});
        addInfo("Jerry", new String[]{"male", "138123***", "ShenZhen"});
        addInfo("Tom", new String[]{"female", "138123***", "ShangHai"});
        addInfo("Bill", new String[]{"male", "138231***", "ZhanJiang"});
    }

    /**
     * 模拟给组、子列表添加数据
     *
     * @param g-group
     * @param c-child
     */
    private void addInfo(String g, String[] c) {
        group.add(g);
        List<String> childitem = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            childitem.add(c[i]);
        }
        child.add(childitem);
    }


    public class MyAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return group.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return child.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            String string = group.get(groupPosition);
//            return getGenericView(string, true);
            View viewGroup = getLayoutInflater().inflate(R.layout.item_group, null);
            TextView tvGroup = (TextView) viewGroup.findViewById(R.id.tv_group);
            ImageView ivArrow = (ImageView) viewGroup.findViewById(R.id.imageView);
            tvGroup.setText(string);
//            return getGenericView(string, false);
            if(isExpanded){
                ivArrow.setImageResource(R.drawable.icon_dropdown_u);
            }else{
                ivArrow.setImageResource(R.drawable.icon_dropdown_d);
            }
            return viewGroup;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            String string = child.get(groupPosition).get(childPosition);
            return getGenericView(string, false);
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        //创建组/子视图
        public TextView getGenericView(String s, boolean isGroup) {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 120);

            TextView text = new TextView(Demo4Activity.this);
            text.setLayoutParams(lp);
            // Center the text vertically
            text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            text.setPadding(100, 0, 0, 0);
            text.setTextColor(0xffFF80FF);
//            if (isGroup) {
//                text.setTextColor(0xff008080);
//                text.setTextSize(20);
//                text.setBackgroundColor(0xff808080);
//            } else {
//                text.setTextColor(0xffFF80FF);
//            }
            text.setText(s);
            return text;
        }

    }

}
