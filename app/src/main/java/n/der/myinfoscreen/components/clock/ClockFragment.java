package n.der.myinfoscreen.components.clock;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import n.der.myinfoscreen.R;

public class ClockFragment extends Fragment {
    private final static long ONE_SECOND = 1000L;
    private Handler _updateHandler = new Handler();
    private TextView _timerText;

    public ClockFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClockFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClockFragment newInstance(String param1, String param2) {
        ClockFragment fragment = new ClockFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        startTimer();
        _timerText = getActivity().findViewById(R.id.frag_clock_time);
    }

    @Override
    public void onPause(){
        super.onPause();
        stopTimer();

    }
    @Override
    public void onResume(){
        super.onResume();
        startTimer();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        startTimer();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        stopTimer();
    }

    private void startTimer(){
        stopTimer(); // just to make sure we don't attache multiple handlers
        _updateHandler.postDelayed(updateCurrentTime, ONE_SECOND);
    }

    private final Runnable updateCurrentTime = new Runnable(){
        public void run(){
            try {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);
                String timertext = String.format("%1$02d:%2$02d %3$02d", hour, minute, second);
                _timerText.setText(timertext);

                startTimer();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private void stopTimer(){
        _updateHandler.removeCallbacksAndMessages(null);
    }
}
