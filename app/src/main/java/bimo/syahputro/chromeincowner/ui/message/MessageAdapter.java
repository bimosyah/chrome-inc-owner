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

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    public static class ViewHolderLeft extends RecyclerView.ViewHolder{
        TextView tvReceiver;
        public ViewHolderLeft(@NonNull View itemView) {
            super(itemView);
            tvReceiver = itemView.findViewById(R.id.tv_receiver);
        }
    }

    public static class ViewHolderRight extends RecyclerView.ViewHolder{
        TextView tvSender;
        public ViewHolderRight(@NonNull View itemView) {
            super(itemView);
            tvSender = itemView.findViewById(R.id.tv_sender);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (messageList.get(position).getSender().equals("0")){
            return 0;
        }else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View vLeft = LayoutInflater.from(context).inflate(R.layout.item_message_left, parent, false);
        final View vRight = LayoutInflater.from(context).inflate(R.layout.item_message_right, parent, false);

        if (viewType == 0){
            return new ViewHolderLeft(vLeft);
        }else {
            return new ViewHolderRight(vRight);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0){
            ViewHolderLeft viewHolderLeft = (ViewHolderLeft) holder;
            viewHolderLeft.tvReceiver.setText(messageList.get(position).getMessage());
        }else {
            ViewHolderRight viewHolderRight = (ViewHolderRight) holder;
            viewHolderRight.tvSender.setText(messageList.get(position).getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
