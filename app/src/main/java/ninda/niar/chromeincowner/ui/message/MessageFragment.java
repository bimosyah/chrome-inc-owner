package ninda.niar.chromeincowner.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ninda.niar.chromeincowner.R;
import ninda.niar.chromeincowner.network.entity.Message;
import ninda.niar.chromeincowner.network.responses.MessageResponse;

import static androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL;

public class MessageFragment extends Fragment {
    View view;
    MessageViewModel viewModel;
    List<Message> messageList;
    RecyclerView rvMessage;
    MessageAdapter adapter;
    ImageView ivSent;
    EditText etMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        viewModel.getMessage().observe(getActivity(), new Observer<MessageResponse>() {
            @Override
            public void onChanged(MessageResponse messageResponse) {
                messageList = messageResponse.getChat();
                setupRecyclerView();
            }
        });

        ivSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                if (!message.equals("")){
                    messageList.add(new Message("1", message));
                    adapter.notifyDataSetChanged();
                    viewModel.sentMessage(message);
                    etMessage.setText("");
                    rvMessage.scrollToPosition(messageList.size() - 1);
                }
            }
        });
    }

    private void setupRecyclerView() {
        if (adapter == null) {
            adapter = new MessageAdapter(getActivity(), messageList);
            DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
            rvMessage.addItemDecoration(itemDecor);
            rvMessage.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvMessage.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    private void init() {
        etMessage = view.findViewById(R.id.et_message);
        ivSent = view.findViewById(R.id.iv_sent);
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        rvMessage = view.findViewById(R.id.rv_message);
    }


}