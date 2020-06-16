package bimo.syahputro.chromeincowner.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bimo.syahputro.chromeincowner.R;
import bimo.syahputro.chromeincowner.network.entity.Message;
import bimo.syahputro.chromeincowner.network.responses.MessageResponse;

import static androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL;

public class MessageFragment extends Fragment {
    View view;
    MessageViewModel viewModel;
    List<Message> messageList;
    RecyclerView rvMessage;
    MessageAdapter adapter;

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
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        rvMessage = view.findViewById(R.id.rv_message);
    }


}