package itcast.cn.word2;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Fruitadapter extends ArrayAdapter{
    private int resourceID;

    public Fruitadapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {//convertView用于将之前加载好的布局进行缓存，以便之后可以进行重用
        Fruit fruit= (Fruit) getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.fruitText=(TextView)view.findViewById(R.id.tv2);
            viewHolder.fruitImage=(ImageView) view.findViewById(R.id.iv1);
            view.setTag(viewHolder);
        }
        else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.fruitText.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageid());
        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitText;
    }
}
