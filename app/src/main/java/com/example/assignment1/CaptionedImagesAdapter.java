package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

    private String[] captions;
    private String[] result;


    public CaptionedImagesAdapter(String[] captions,String[] result){
        this.captions = captions;
        this.result=result;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        TextView txt = (TextView)cardView.findViewById(R.id.textRe);
        txt.setText(captions[position]);
        TextView txt1 = (TextView)cardView.findViewById(R.id.resultRe);
        txt1.setText(result[position]);
        txt1.setOnTouchListener((view, motionEvent) -> {
            if (view.getId() == R.id.resultRe) {

                view.getParent().requestDisallowInterceptTouchEvent(true);

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_UP:
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
            }


            return false;
        });
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
