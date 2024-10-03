package com.example.java4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private final List<String> buttonList;
    private final OnButtonClickListener listener;

    public ButtonAdapter(List<String> buttonList, OnButtonClickListener listener) {
        this.buttonList = buttonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_button, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        String buttonText = buttonList.get(position);
        holder.bind(buttonText);
    }

    @Override
    public int getItemCount() {
        return buttonList.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }

        public void bind(String text) {
            button.setText(text);
            button.setOnClickListener(v -> listener.onButtonClick(text));
        }
    }

    public interface OnButtonClickListener {
        void onButtonClick(String text);
    }
}