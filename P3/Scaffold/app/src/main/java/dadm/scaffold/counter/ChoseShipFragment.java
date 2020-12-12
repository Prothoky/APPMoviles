package dadm.scaffold.counter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dadm.scaffold.R;
import dadm.scaffold.ScaffoldActivity;

public class ChoseShipFragment extends Fragment implements View.OnClickListener {

    public ChoseShipFragment() {
    }

    public static ChoseShipFragment newInstance() {
        ChoseShipFragment fragment = new ChoseShipFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chose_ship, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.buttonShip1).setOnClickListener(this);
        view.findViewById(R.id.buttonShip2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonShip1){
            ((ScaffoldActivity)getActivity()).type=0;
            ((ScaffoldActivity)getActivity()).startGame(0);
        }
        if(view.getId() == R.id.buttonShip2){
            ((ScaffoldActivity)getActivity()).type=1;
            ((ScaffoldActivity)getActivity()).startGame(1);
        }
    }
}