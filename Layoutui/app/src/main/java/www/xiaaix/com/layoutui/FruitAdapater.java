package www.xiaaix.com.layoutui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Monster on 2016/8/17.
 */
public class FruitAdapater extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapater(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.fruitImage=(ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.frutiName=(TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }
        else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.frutiName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;
        TextView frutiName;
    }
}
