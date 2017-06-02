package com.example.android.fraghw;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenaFragment extends Fragment implements View.OnClickListener {
    private GenaCommsCallback callback;
    Button hellotoJaludi_bt;
    Button byetoJaludi_bt;
    TextView resultTV;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.HJbtn:
                callback.MessageToJaludi("Sup Jaludi");
                hellotoJaludi_bt.setVisibility(View.INVISIBLE);
                byetoJaludi_bt.setVisibility(View.VISIBLE);
                break;
            case R.id.BJbtn:
                callback.MessageToJaludi("Bye Jaludi");
                hellotoJaludi_bt.setVisibility(View.VISIBLE);
                byetoJaludi_bt.setVisibility(View.INVISIBLE);
                break;
            default:
                return;
        }
    }

    public interface GenaCommsCallback{
        void MessageToJaludi(String message);
    }

    public GenaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback =  (GenaCommsCallback) getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()
            +"must implement GenaCommsCallback bro");
        }

    }
    public void sentMessage(String sentmessage){resultTV.setText(sentmessage);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gena, container, false);
        hellotoJaludi_bt = (Button)view.findViewById(R.id.HJbtn);
        hellotoJaludi_bt.setOnClickListener(this);
        byetoJaludi_bt = (Button)view.findViewById(R.id.BJbtn);
        byetoJaludi_bt.setOnClickListener(this);
        resultTV = (TextView) view.findViewById(R.id.result_tv);
        byetoJaludi_bt.setVisibility(View.INVISIBLE);
        return view;
    }

}
