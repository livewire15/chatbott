package ai.api.poojab26;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public String data[];
    public int value[];
    onItemClickListener onItemClickListener;
    public MyAdapter(String data[],int value[])
    {
        this.data=data;
        this.value=value;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        ImageView v1;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t1);
            v1=(ImageView)itemView.findViewById(R.id.v1);
        }
    }

    public interface onItemClickListener{
        void onItemClick(ImageView imageView,View v,int position);
    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener)
    {
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.view, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, final int position) {
            String title=data[position];
            holder.t1.setText(title);
            holder.v1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(value[position]==0) {
                        holder.v1.setImageResource(R.drawable.ic_pause_black_24dp);
                        value[position] = 1;
                    }
                    else {
                        holder.v1.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        value[position] = 0;
                    }
                    if(onItemClickListener!=null)
                    {
                        onItemClickListener.onItemClick(holder.v1,view,position);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}
