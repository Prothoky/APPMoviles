package dadm.scaffold.counter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.ECField;

import dadm.scaffold.R;
import dadm.scaffold.ScaffoldActivity;
import dadm.scaffold.engine.FramesPerSecondCounter;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.GameView;
import dadm.scaffold.input.JoystickInputController;
import dadm.scaffold.space.SpaceShipPlayer;

public class EndFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_SCORE = "param";

    private int mScore;

    public EndFragment() {
        // Required empty public constructor
    }

    public static EndFragment newInstance(int param) {
        EndFragment fragment = new EndFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SCORE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScore = getArguments().getInt(ARG_SCORE);
            System.out.println(mScore);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_end, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.restart_button).setOnClickListener(this);
        view.findViewById(R.id.quit_button).setOnClickListener(this);
        TextView tcScore = view.findViewById(R.id.Score_int);
        tcScore.setText(String.valueOf(mScore));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.restart_button){
            ((ScaffoldActivity)getActivity()).startGame();
        }
        if(view.getId() == R.id.quit_button){
            ((ScaffoldActivity)getActivity()).finish();
        }
    }
}