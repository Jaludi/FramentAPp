package com.example.android.fraghw;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MohammedFragment extends Fragment implements View.OnClickListener {
    private JaludiCommsCallback callback;
    Button helloToGena_bt;
    Button byeToGena_bt;
    TextView resultTV;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.HGbtn:
                callback.MessageToGena("Sup Gena");
                helloToGena_bt.setVisibility(View.INVISIBLE);
                byeToGena_bt.setVisibility(View.VISIBLE);
                break;
            case R.id.BGbtn:
                callback.MessageToGena("Bye Gena");
                helloToGena_bt.setVisibility(View.VISIBLE);
                byeToGena_bt.setVisibility(View.INVISIBLE);
                break;
            default:
                return;
        }
    }

    public interface JaludiCommsCallback{
        void MessageToGena(String message);
    }
    public MohammedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        super.onAttach(context);
        try {
            callback =  (JaludiCommsCallback) getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()
                    +"must implement JaludiCommsCallback bro");
        }
    }

    public void sentMessage(String sentmessage){resultTV.setText(sentmessage);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mohammed, container, false);
        helloToGena_bt = (Button)view.findViewById(R.id.HGbtn);
        helloToGena_bt.setOnClickListener(this);
        byeToGena_bt = (Button)view.findViewById(R.id.BGbtn);
        byeToGena_bt.setOnClickListener(this);
        resultTV = (TextView)view.findViewById(R.id.result_tv);
        byeToGena_bt.setVisibility(View.INVISIBLE);
        return view;
    }

}
