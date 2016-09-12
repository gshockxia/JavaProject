package www.xiaaix.com.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Monster on 2016/8/21.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourcedId;

    public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
        super(context, textViewResourceId, objects);
        resourcedId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourcedId,null);
            viewHolder=new ViewHolder();
            viewHolder.leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout=(LinearLayout)view.findViewById(R.id.right_layout);
            viewHolder.leftMsg=(TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightMsg=(TextView)view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        if(msg.getType()==Msg.TYPE_RECEIVED){
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }else{
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.leftLayout.setVisibility(view.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}
