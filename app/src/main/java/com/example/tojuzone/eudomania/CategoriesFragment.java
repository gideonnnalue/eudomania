package com.example.tojuzone.eudomania;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {

    private Button spiritualCouncilBtn;
    private Dialog mDialog;


    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_categories, container, false);

        mDialog = new Dialog(getActivity());

        spiritualCouncilBtn = mView.findViewById(R.id.spiritual_council_btn);

        spiritualCouncilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        return mView;
    }

    public void sendMessage (View v) {
        mDialog.setContentView(R.layout.brief_message_pop_up);
        ImageView closeBtn;
        Button closeRedbtn;
        closeBtn = mDialog.findViewById(R.id.brief_msg_close);
        closeRedbtn = mDialog.findViewById(R.id.brief_msg_close2);

        closeRedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

}
