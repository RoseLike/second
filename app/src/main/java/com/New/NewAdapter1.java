package com.New;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hcc.mysecondproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 16-9-4.
 */
public class NewAdapter1 extends BaseAdapter {
    Context context;
    List<MyData.Bean2Bean> bean2Been;
    List<MyData.BeanBean> beanBeen;
    Handler handler2 = new Handler();

    public NewAdapter1(Context context, List<MyData.Bean2Bean> bean2Been, List<MyData.BeanBean> beanBeen) {
        this.context = context;
        this.bean2Been = bean2Been;
        this.beanBeen = beanBeen;
    }

    @Override
    public int getCount() {
        return bean2Been.size() / 2 + beanBeen.size();
    }

    @Override
    public Object getItem(int position) {
        if (position % 5 == 0) {
            return bean2Been.get((position / 5) * 2);
        } else {
            return beanBeen.get(position - ((position / 5) + 1));
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;//getItemViewType的下标必须从0开始也就是Type的值是0，1，三个的话就是0,1，2
    }
    @Override
    public int getItemViewType(int position) {
        if (position % 5 == 0) {
            return 0;//getItemViewType的下标必须从0开始也就是Type的值是0，1，三个的话就是0,1，2
        } else {
            return 1;
        }
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

            switch (getItemViewType(position)) {
                case 0:
                    ViewHolder viewHolder = null;
                    if (convertView == null) {
                        viewHolder = new ViewHolder();
                        convertView = LayoutInflater.from(context).inflate(R.layout.new_item2, null);
                        viewHolder.imageView1 = (ImageView) convertView.findViewById(R.id.imageviewId);
                        viewHolder.imageView2 = (ImageView) convertView.findViewById(R.id.imageviewId2);
                        viewHolder.textView1 = (TextView) convertView.findViewById(R.id.textviewId);
                        viewHolder.textView2 = (TextView) convertView.findViewById(R.id.textviewId2);
                        convertView.setTag(viewHolder);
                    } else {
                        viewHolder = (ViewHolder) convertView.getTag();
                    }

                    viewHolder.textView1.setText(bean2Been.get((position / 5) * 2).getTitle());
                    viewHolder.textView2.setText(bean2Been.get((position / 5) * 2 + 1).getTitle());
                    String image_path = bean2Been.get((position / 5) * 2).getPic_url();
                    Log.d("hcc", "images_path=======" + image_path);
                    String image_path2 = bean2Been.get((position / 5) * 2 + 1).getPic_url();
                    Log.d("hcc", "images_path=======" + image_path2);
                    Picasso.with(context).load(image_path).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(viewHolder.imageView1);
                    Picasso.with(context).load(image_path2).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(viewHolder.imageView2);
//                DownImages.downLoadImage(image_path, handler2, viewHolder.imageView1);
//                DownImages.downLoadImage(image_path2, handler2, viewHolder.imageView2);
                    viewHolder.imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent();
//                            intent.setAction(Intent.ACTION_VIEW);
//                            intent.setData(Uri.parse(bean2Been.get((position / 5) * 2 ).getWeb_url()));
                            intent.setAction("com.he.jump");
                            intent.putExtra("url", bean2Been.get((position / 5) * 2 ).getWeb_url());
                            context.startActivity(intent);
                        }
                    });
                    viewHolder.imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent();
                            //intent.setAction(Intent.ACTION_VIEW);
                            intent.setAction("com.he.jump");
                            intent.putExtra("url", bean2Been.get((position / 5) * 2+1).getWeb_url());
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 1:
                    ViewHolderSecond viewHolderSecond = null;
                    if (convertView == null) {
                        viewHolderSecond = new ViewHolderSecond();
                        convertView = LayoutInflater.from(context).inflate(R.layout.new_item1, null);
                        viewHolderSecond.item1_imageView = (ImageView) convertView.findViewById(R.id.item1_imageviewId);
                        viewHolderSecond.titleTextview = (TextView) convertView.findViewById(R.id.titleId);
                        viewHolderSecond.dateTextView = (TextView) convertView.findViewById(R.id.dateId);
                        convertView.setTag(viewHolderSecond);
                    } else {
                        viewHolderSecond = (ViewHolderSecond) convertView.getTag();
                    }

                    viewHolderSecond.dateTextView.setText(beanBeen.get(position - ((position / 5) + 1)).getDate());
                    viewHolderSecond.titleTextview.setText(beanBeen.get(position - ((position / 5) + 1)).getTitle());
                    String images_path = beanBeen.get(position - ((position / 5) + 1)).getPic_url();
                    Log.d("hcc", "images_path=======" + images_path);
                    Picasso.with(context).load(images_path).placeholder(R.drawable.bg_b).error(R.drawable.bg_b).into(viewHolderSecond.item1_imageView);
                    // DownImages.downLoadImage(images_path, handler2, viewHolderSecond.item1_imageView);
                    break;

            }
        return convertView;
    }



    class ViewHolder {
        ImageView imageView1, imageView2;
        TextView textView1, textView2;
    }

    class ViewHolderSecond {
        ImageView item1_imageView;
        TextView titleTextview, dateTextView;
    }
}