package bimo.syahputro.chromeincowner.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bimo.syahputro.chromeincowner.R;
import bimo.syahputro.chromeincowner.network.entity.Message;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private Context context;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (messageList.get(position).getSender().equals("0")){
            holder.tvReceiver.setText(messageList.get(position).getMessage());
            holder.tvSender.setVisibility(View.GONE);
        }else {
            holder.tvSender.setText(messageList.get(position).getMessage());
            holder.tvReceiver.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvReceiver, tvSender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReceiver = itemView.findViewById(R.id.tv_receiver);
            tvSender = itemView.findViewById(R.id.tv_sender);
        }
    }
}
